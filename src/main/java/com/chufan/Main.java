package com.chufan;

import org.apache.commons.collections.bag.SynchronizedSortedBag;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.pipeline.FilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.atomic.LongAdder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static LongAdder longAdder = new LongAdder();
    private static LongAdder firstAdder = new LongAdder();
    private static final ConcurrentHashMap<String, String> stores = new ConcurrentHashMap();
    // private static final TreeMap<String,Object> bulks = new TreeMap<>();
    private static final ConcurrentSkipListMap<Integer, Object> pages = new ConcurrentSkipListMap<>();
    private ArrayList<String> pageindex = new ArrayList<>();
    private HashMap<String, Integer> chapMap = new HashMap<>();
    private static String OUTFILE = "D:\\novel-1.txt";
    private int ichaps = 0;

    public static void main(String[] args) {
        Main m = new Main();
        m.job();
        try {
            m.witetofile(OUTFILE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void witetofile(String outfile) throws IOException {
        System.out.println("Begin Dump Files = " + longAdder.longValue());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outfile), "GBK"));
        StringBuffer sb = new StringBuffer();

        pages.forEach((chapid, page) -> {
            NovelPage np = (NovelPage) page;
            String x = "";
            try {
                bw.write(np.getName());
                bw.newLine();
                bw.newLine();
                x = stores.get(np.getContentUrl());
                if (x != null) {
                    bw.write(x);
                    bw.newLine();
                    bw.newLine();
                } else {
                    sb.append(np.getID()).append("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.printf("dumping %s ,Name:[%s] ,[%d]\n", chapid, np.getName(), longAdder.longValue());
            longAdder.decrement();
        });
        bw.close();
        System.out.printf("The chapter is null :%s\n", sb.toString());
    }

    void job() {
        // write your code here.
        System.out.println("Begin");
        FilePipeline fp = new FilePipeline();
        fp.setPath("D://nov");
        Spider.create(new PageProcessor() {
            private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setCharset("GBK").setUserAgent(
                    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.63 Safari/537.36 Edg/102.0.1245.30");

            @Override
            public void process(Page page) {
                // get nova adds
                String chapurl = page.getUrl().toString();
                if (chapurl != null && chapurl.length() > 0)
                    if (chapurl.endsWith(".html")) {
                        String pageInfoStr = page.getHtml().xpath("/html/head/script[4]").get();
                        if (pageInfoStr != null && pageInfoStr.length() > 0) {
                            Pattern pat;
                            int xid;
                            String bookid = "", chapterid = "", mybookid = "", bookurl = "";
                            // get bookid
                            pat = Pattern.compile("bookid=(.*);");
                            Matcher m = pat.matcher(pageInfoStr);
                            if (m.find()) {
                                bookid = m.group(1);
                            }
                            pat = Pattern.compile("chapterid=(.*);");
                            m = pat.matcher(pageInfoStr);
                            if (m.find()) {
                                chapterid = m.group(1);
                            }
                            pat = Pattern.compile("mybookid=(.*);");
                            m = pat.matcher(pageInfoStr);
                            if (m.find()) {
                                mybookid = m.group(1);
                            }
                            xid = (int) Math.floor(Integer.parseInt(bookid) / 1000);
                            // https://www.baishishanhotel.com/files/article/html555/1/1625/1604515.html
                            int pos = chapurl.lastIndexOf("/");

                            bookurl = "https://www.baishishanhotel.com/files/article/html555/" + xid + "/" + bookid
                                    + chapurl.substring(pos);
                            page.addTargetRequest(bookurl);
                            firstAdder.increment();
                            System.out.printf("URL:%s , and cur/total [%d/%d]\n", bookurl, firstAdder.longValue(),
                                    ichaps);
                            NovelPage npage = new NovelPage();
                            npage.setChapterID(Integer.parseInt(chapterid));
                            npage.setContentUrl(bookurl);
                            npage.setUrl(chapurl);
                            npage.setName(pageindex.get(chapMap.get(chapurl)));
                            pages.put(Integer.valueOf(chapterid), npage);
                            // next_id=1604516;bookid=1625;chapterid=1604515;mybookid=8348;xid=Math.floor(mybookid/1000);
                        }
                    } else {
                        // get novel name //*[@id="list"]/div[1]/div[2]/h1
                        String nName = page.getHtml().xpath("//*[@id=\"list\"]/div[1]/div[2]/h1/text()").get();
                        OUTFILE = "D:\\" + nName + ".txt";
                        page.putField("novelname", nName);
                        List chapters = page.getHtml().xpath("//*[@id=\"list\"]/div[3]/ul[2]/li/a/text()").all();
                        page.putField("chapters", chapters);

                        pageindex.addAll(chapters);
                        List<String> urls = page.getHtml().xpath("//*[@id=\"list\"]/div[3]/ul[2]").links().all();
                        int usize = urls.size();
                        for (int i = 0; i < usize; i++) {
                            System.out.println(urls.get(i));
                            chapMap.put(urls.get(i), Integer.valueOf(i));
                        }
                        if (urls.size() > 1) {
                            ichaps = urls.size();
                            page.addTargetRequests(urls);
                            // page.addTargetRequests(urls.subList(0, 2));
                        }
                    }
                if (page.getUrl().regex("html555").match()) {
                    // page.putField("content",page.getRawText());
                    // System.out.println(replaceString(page.getRawText()));
                    longAdder.increment();
                    System.out.printf("Getting the %s , and current/total [%d/%d] \n", page.getUrl(),
                            longAdder.longValue(), ichaps);
                    stores.put(page.getUrl().toString(), replaceString(page.getRawText()));
                }
            }

            @Override
            public Site getSite() {
                return site;
            }
        }).addUrl("https://www.baishishanhotel.com/du/25996093/").addPipeline(new ConsolePipeline()).addPipeline(fp)
                .thread(15).run();
        // 8348 无敌奶爸的捉妖日常 ; 43776 无上崛起 ;7065 亿万甜妻：龙少，花样多！;3199 我修的可能是假仙; 1720 斗破之无上之境;
        // 49490 极品透视 ; 19560 村心芳香; 25996093 无敌剑域
    }

    String replaceString(String s) {
        String ret = "";
        String[] lines = s.split("\n");
        Pattern regbefore = Pattern.compile("/(.*)/");
        Pattern regafter = Pattern.compile("'(.*)'");
        String regs = "";
        String rege = "";
        Matcher m;
        for (int i = 0; i < lines.length; i++) {
            if (i == 0) {
                ret = lines[i];
                ret = ret.replaceAll("&nbsp;", "");
                ret = ret.replaceAll("<br><br>", "\n");
                continue;
            }
            m = regbefore.matcher(lines[i]);
            if (m.find()) {
                regs = m.group(1);
            }
            m = regafter.matcher(lines[i]);
            if (m.find()) {
                rege = m.group(1);
            }
            ret = ret.replaceAll(regs, rege);
        }
        int start = ret.indexOf('\'');
        int end = ret.lastIndexOf('\'');
        return ret.substring(start + 1, end);
    }
}
