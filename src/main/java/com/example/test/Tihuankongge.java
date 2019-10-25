package com.example.test;

import java.util.regex.*;

public class Tihuankongge {
    public static void main(String args[]) {
        Pattern pattern = Pattern.compile("a|b");
        Matcher m = pattern.matcher("abcabca@126.com");
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(sb, m.group().toUpperCase());
            System.out.println(sb.toString());
        }
        m.appendTail(sb);
        System.out.println(sb.toString());
    }
}