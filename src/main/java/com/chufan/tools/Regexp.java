package com.chufan.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regexp {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("fool=(.*)-(.*);");
        Matcher m = p.matcher("fool=23425235-12312;\nfool=123-2355");
        if (m.find()) {
            System.out.println(m.group(1));
            System.out.println(m.group(2));
        }

    }
}
