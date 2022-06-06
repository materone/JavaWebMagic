package com.chufan;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.pipeline.FilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        m.job();
//        String s = "content:\tvar cctxt='&nbsp;&nbsp;&nbsp;&nbsp;但黑山羊既然能口吐人言茵右脚楞夺肯定不顺困顶枯枵凡品茵右脚楞夺从拉开架势到勾头伸角对准正前方夺回顾功带困动作茵右脚楞夺比普通羊快得多。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;沈崇刚往前冲出两步茵右脚楞夺拳头才挥到半路茵右脚楞夺黑山羊便已经在地面发力猛蹬茵右脚楞夺向前电射而来。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;欣欣还以为山羊真顺困顶枯枵要和自己玩老鹰捉小鸡茵右脚楞夺兴奋得直拍掌茵右脚楞夺沈崇却被黑羊迅若奔雷夺回顾功带困动作吓了一跳。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;幸好他眼疾手快茵右脚楞夺见势头不对茵右脚楞夺也不收拳茵右脚楞夺把身子压得更低茵右脚楞夺右拳更加用力夺回顾功带困向地面轰去。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;得益于多年苦练得来夺回顾功带困动态视觉与职业选手夺回顾功带困预判力茵右脚楞夺沈崇右拳竟刚好避开山羊犄角茵右脚楞夺正锤在它头顶天灵盖。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;嘭夺回顾功带困一声巨响茵右脚楞夺山羊往前夺回顾功带困冲势为之一顿。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;但沈崇也不轻松茵右脚楞夺指骨上剧痛传来。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;就这一下茵右脚楞夺他竟隐隐觉得自己拳头骨裂了！<br><br>&nbsp;&nbsp;&nbsp;&nbsp;羊头夺回顾功带困骨骼强度夺回顾功带困确大于人夺回顾功带困指骨茵右脚楞夺但沈崇夺回顾功带困拳头也顺困顶枯枵千锤百炼茵右脚楞夺本不该如此不堪。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;可这黑山羊身上夺回顾功带困蹊跷似乎远不止会说人话茵右脚楞夺它夺回顾功带困骨头硬度至少顺困顶枯枵普通羊夺回顾功带困两倍！<br><br>&nbsp;&nbsp;&nbsp;&nbsp;再加上它异常夺回顾功带困运动能力带来夺回顾功带困可怕冲势茵右脚楞夺拳头与羊头夺回顾功带困碰撞强度竟完全超越了沈崇这副职业选手身体夺回顾功带困承受能力。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;顾不得心中惊骇茵右脚楞夺让沈崇更恐慌夺回顾功带困事情发生了。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;硬吃他一拳茵右脚楞夺下巴几乎撞到地面夺回顾功带困黑山羊仿佛没受到什么影响茵右脚楞夺稍微调整之后竟反而试图就此压低身子从他胯下钻过去。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;如果让它得逞茵右脚楞夺就冲着它这冲击力茵右脚楞夺欣欣一旦被撞实了非死即伤。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;沈崇赶紧向后扭腰茵右脚楞夺同时转过身躯茵右脚楞夺往身后扑去茵右脚楞夺双手探出刚好从后方抓住黑山羊两只犄角。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;距离一人一羊堪堪不到半米夺回顾功带困欣欣终于看出来情况不对茵右脚楞夺爸爸脸上夺回顾功带困表情好吓人茵右脚楞夺但更吓人夺回顾功带困顺困顶枯枵山羊。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;这畜生夺回顾功带困疯狂让她想起曾经在电视里偶然看到夺回顾功带困动物世界茵右脚楞夺里面夺回顾功带困狮子打架时就顺困顶枯枵这模样。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;“欣欣！跑！快跑！离我们远点！”<br><br>&nbsp;&nbsp;&nbsp;&nbsp;沈崇用尽全身力气从后面死死拽住黑羊茵右脚楞夺不让它寸进丁点。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;欣欣怕得浑身发抖茵右脚楞夺下意识想扭头跑茵右脚楞夺但猛夺回顾功带困又转过身来茵右脚楞夺反而试着往沈崇夺回顾功带困方向走过来半步茵右脚楞夺嘴里哆哆嗦嗦着茵右脚楞夺“爸爸茵右脚楞夺我……我来帮你。”<br><br>&nbsp;&nbsp;&nbsp;&nbsp;沈崇简直要哭了茵右脚楞夺这局面你能帮得了什么忙呀茵右脚楞夺求求你赶紧站开点我就谢天谢地了。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;但这时候他不能说出来茵右脚楞夺只好勉强挤出个笑茵右脚楞夺“不用茵右脚楞夺爸爸顺困顶枯枵超人嘛茵右脚楞夺不会输夺回顾功带困。你到那边去好不好？看爸爸怎么教训这不听话夺回顾功带困家伙。”<br><br>&nbsp;&nbsp;&nbsp;&nbsp;嘴上说得轻松茵右脚楞夺其实他两只手夺回顾功带困手指都快被扯断了茵右脚楞夺尤其顺困顶枯枵本就受伤夺回顾功带困右手茵右脚楞夺更顺困顶枯枵剧痛难当。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;但他必须忍着茵右脚楞夺绝对不能撒手。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;这鬼东西看着个头不壮茵右脚楞夺力气却大得要命。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;在欣欣稍微靠近点之后茵右脚楞夺它更顺困顶枯枵完全失去所顶置中夺粗功肖功地理智茵右脚楞夺疯了一样要往外窜。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;如果不顺困顶枯枵头上夺回顾功带困角实在结实茵右脚楞夺沈崇觉得恐怕即便自己把它犄角扯下来茵右脚楞夺它都不会停茵右脚楞夺只想冲上去。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;沈崇这会儿那叫一个苦茵右脚楞夺双手抓角茵右脚楞夺双腿夹住疯羊夺回顾功带困肚子茵右脚楞夺身体往后呈六十度倾斜。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;看起来他像骑着羊茵右脚楞夺但其实根本不顺困顶枯枵那么一回事。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;他还要忍受这鬼东西夺回顾功带困前蹄子在自己脚背上夺回顾功带困一通乱踩。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;偏偏他不想吓到欣欣茵右脚楞夺脸上还不能表现得太痛苦茵右脚楞夺还得想方设法夺回顾功带困把人哄走。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;“欣欣你看过斗牛夺回顾功带困动画片没顶置中夺粗功肖功地？”<br><br>&nbsp;&nbsp;&nbsp;&nbsp;“我看过我看过茵右脚楞夺斗牛士很厉害夺回顾功带困！”<br><br>&nbsp;&nbsp;&nbsp;&nbsp;沈崇又说道：“爸爸现在就在给你表演斗牛呀茵右脚楞夺咱们没顶置中夺粗功肖功地牛茵右脚楞夺斗羊也顺困顶枯枵一样夺回顾功带困。所以你别怕茵右脚楞夺也不用帮我茵右脚楞夺看爸爸夺回顾功带困厉害就好了！”<br><br>&nbsp;&nbsp;&nbsp;&nbsp;“那茵右脚楞夺爸爸我到那边去看好不好？”<br><br>&nbsp;&nbsp;&nbsp;&nbsp;欣欣终于信了茵右脚楞夺指了指身后几米外夺回顾功带困一个方形花台茵右脚楞夺大约一米多高。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;沈崇大喜茵右脚楞夺多机灵夺回顾功带困娃啊！<br><br>&nbsp;&nbsp;&nbsp;&nbsp;她如果上到高处茵右脚楞夺被怪羊直接撞中夺回顾功带困几率就小了很多。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;他赶紧点头茵右脚楞夺“没错没错！欣欣你快去茵右脚楞夺爬上去夺回顾功带困时候小心点不要摔了。”<br><br>&nbsp;&nbsp;&nbsp;&nbsp;宝贝女儿乖巧一点头茵右脚楞夺转头就跑向花台。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;这边沈崇坚持得越来越难受茵右脚楞夺左手就不说了茵右脚楞夺右手本就骨裂茵右脚楞夺虽然超强自愈已经生效茵右脚楞夺但没好丁点茵右脚楞夺新伤又来茵右脚楞夺甚至指关节与腕关节处夺回顾功带困筋络都顶置中夺粗功肖功地渐渐承受不住之势。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;但最重夺回顾功带困伤却在他两个脚夺回顾功带困脚背上茵右脚楞夺怪羊夺回顾功带困蹄子力道不输铁锤茵右脚楞夺在他脚背上一下又一下狠狠砸着。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;到现在沈崇脚背上夺回顾功带困骨头怕顺困顶枯枵已经粉碎性骨折茵右脚楞夺全靠脚后跟卡在地上死撑着。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;欣欣刚吭哧吭哧夺回顾功带困爬上花台茵右脚楞夺沈崇这边右手率先脱力茵右脚楞夺犄角被挣脱出去。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;怪羊骤得解脱茵右脚楞夺四蹄狠蹬茵右脚楞夺又给沈崇脚背以重创茵右脚楞夺同时脑袋狠甩茵右脚楞夺让沈崇左手抓住夺回顾功带困犄角也滑了出去。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;然后茵右脚楞夺怪羊就如脱缰野马般往前冲刺而去。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;交锋不过短短一分钟茵右脚楞夺沈崇便已经双脚脚背粉碎骨折茵右脚楞夺右手大面积骨折茵右脚楞夺左手骨裂茵右脚楞夺手掌里更顺困顶枯枵皮肉绽开茵右脚楞夺鲜血淋漓茵右脚楞夺惨到不能再惨。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;其实茵右脚楞夺即便怪羊实力强横茵右脚楞夺沈崇毕竟曾经顺困顶枯枵职业选手茵右脚楞夺也不该如此下风。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;但沈崇现在心顶置中夺粗功肖功地牵挂茵右脚楞夺一开始时又稍许轻敌茵右脚楞夺差点给这家伙穿裆而过茵右脚楞夺为了死死拽住它茵右脚楞夺不得不与它陷入僵持。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;但顺困顶枯枵茵右脚楞夺我怎么可能放弃！<br><br>&nbsp;&nbsp;&nbsp;&nbsp;我夺回顾功带困奶爸幸福人生才刚刚开始茵右脚楞夺怎么可能被一只羊给毁了！<br><br>&nbsp;&nbsp;&nbsp;&nbsp;混蛋！<br><br>&nbsp;&nbsp;&nbsp;&nbsp;想吃我女儿？<br><br>&nbsp;&nbsp;&nbsp;&nbsp;除非你从我尸体上碾过去！<br><br>&nbsp;&nbsp;&nbsp;&nbsp;跟着怪羊夺回顾功带困步伐茵右脚楞夺沈崇往前狠狠踏出一步茵右脚楞夺断裂夺回顾功带困脚掌咔嚓一声。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;但他并没顶置中夺粗功肖功地倒下茵右脚楞夺甚至就此用几乎九十度弯折夺回顾功带困脚掌断骨卡着泥土茵右脚楞夺发力往前激射而出。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;前世当了小半辈子死宅夺回顾功带困他茵右脚楞夺从未想象过自己能扛住这样夺回顾功带困痛苦。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;以正常人夺回顾功带困思维茵右脚楞夺脚掌完全断裂夺回顾功带困人根本不可能往前走出去一步。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;但现在沈崇却做到了。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;因为自己顺困顶枯枵一个孩子夺回顾功带困父亲茵右脚楞夺因为血浓于水。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;就像新闻报道里曾不只一次提到过夺回顾功带困茵右脚楞夺在灾难降临之际茵右脚楞夺用身躯挡住砸下来夺回顾功带困天花板茵右脚楞夺用生命为孩子扛下一线生机夺回顾功带困地震中夺回顾功带困父母们！<br><br>&nbsp;&nbsp;&nbsp;&nbsp;怪羊脱身之后茵右脚楞夺眨眼间便已经窜到了花台前方茵右脚楞夺纵身一跃茵右脚楞夺尖刀般夺回顾功带困头顶犄角对准欣欣直刺而去。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;就在它以为自己终于得逞之际茵右脚楞夺两只后蹄却猛夺回顾功带困被人抓住了。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;“给我下来！”<br><br>&nbsp;&nbsp;&nbsp;&nbsp;沈崇撕心裂肺夺回顾功带困咆哮着茵右脚楞夺身体与地面平行着茵右脚楞夺用全身重量吊住怪羊双腿茵右脚楞夺将它从空中狠狠拽了下来！';\n" +
//                "cctxt=cctxt.replace(/夺回顾功带困/g,'的');\n" +
//                "cctxt=cctxt.replace(/顺困顶枯枵/g,'是');\n" +
//                "cctxt=cctxt.replace(/顶置中夺粗功肖功地/g,'有');\n" +
//                "cctxt=cctxt.replace(/茵右脚楞夺/g,'，');";
//        System.out.println(m.replaceString(s));
    }
    void  job(){
	// write your code here.
        System.out.println("Begin");
        FilePipeline fp = new FilePipeline();
        fp.setPath("G://nov");
        Spider.create(new PageProcessor() {
            private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setCharset("GBK").setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.63 Safari/537.36 Edg/102.0.1245.30");
            @Override
            public void process(Page page) {
                /**
                // 部分二：定义如何抽取页面信息，并保存下来
                page.putField("author", page.getUrl().regex("https://github\\.com/(\\w+)/.*").toString());
                //html/body/div/div[2]/div/div[3]/ul[2]/li[1]
                //*[@id="list"]/div[3]/ul[2]
                //#list > div.book-chapter-list > ul:nth-child(4)

                page.putField("name", page.getHtml().xpath("//h1[@class='entry-title public']/strong/a/text()").toString());
                if (page.getResultItems().get("name") == null) {
                    //skip this page
                    page.setSkip(true);
                }
                page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));

                // 部分三：从页面发现后续的url地址来抓取  //*[@id="chapter"]/script[2]
                page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/[\\w\\-]+/[\\w\\-]+)").all());
                 *///*[@id="txt"]/text()[1]  #txt #txt > br:nth-child(3) //*[@id="txt"]/text()[1] //*[@id="txt"]/text()[2]
                //#chapter > div.chapter-wrap > div.chapter-box //*[@id="chapter-title"] //*[@id="chapter-title"]/h1
                // //*[@id="list"]/div[3]/ul[2]
                page.putField("content",page.getHtml().xpath("/html/body/div/div[1]/div[2]/div[2]/text()[1]").get());
                page.putField("chapters",page.getHtml().xpath("//*[@id=\"list\"]/div[3]/ul[2]/li/a/text()").all());
                //get nova adds
                String chapurl = page.getUrl().toString();
                if(chapurl != null && chapurl.length() > 0) if (chapurl.endsWith(".html")) {
                    String pageInfoStr = page.getHtml().xpath("/html/head/script[4]").get();
                    if (pageInfoStr != null && pageInfoStr.length() > 0) {
                        Pattern pat;
                        int xid;
                        String bookid = "", chapterid = "", mybookid = "", bookurl = "";
                        //get bookid
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

                        bookurl = "https://www.baishishanhotel.com/files/article/html555/" + xid + "/" + bookid + chapurl.substring(pos);
                        page.addTargetRequest(bookurl);
                        System.out.println("URL:" + bookurl );
//                    next_id=1604516;
//                    bookid=1625;
//                    chapterid=1604515;
//                    mybookid=8348;
//                    xid=Math.floor(mybookid/1000);
                    }
                }
                if(page.getUrl().regex("html555").match()){
//                    page.putField("content",page.getRawText());
                    System.out.println(replaceString(page.getRawText()));
                }
                List<String> urls = page.getHtml( ).xpath("//*[@id=\"list\"]/div[3]/ul[2]").links().all();
                urls.stream().forEach((url)->{
                    System.out.println(url);
                });
                if(urls.size() > 1){
                    page.addTargetRequests(urls.subList(0,2));
                }
            }

            @Override
            public Site getSite() {
                return site;
            }
        }).addUrl("https://www.baishishanhotel.com/du/8348/").addPipeline(new ConsolePipeline()).addPipeline(fp).thread(5).run();
    }
    String replaceString(String s){
        String ret = "";
        String[] lines = s.split("\n");
        Pattern regbefore= Pattern.compile("/(.*)/");
        Pattern regafter = Pattern.compile("'(.*)'");
        String regs = "";
        String rege = "";
        Matcher m;
        for (int i = 0; i < lines.length; i++) {
            if(i == 0) {
                ret = lines[i];
                ret=ret.replaceAll("&nbsp;", "");
                ret=ret.replaceAll("<br><br>", "\n");
                continue;
            }
            m = regbefore.matcher(lines[i]);
            if(m.find()){
                regs = m.group(1);
            }
            m = regafter.matcher(lines[i]);
            if(m.find()){
                rege = m.group(1);
            }
            ret = ret.replaceAll(regs,rege);
        }
        int start = ret.indexOf('\'');
        int end = ret.lastIndexOf('\'');
        return ret.substring(start + 1,end);
    }
}
