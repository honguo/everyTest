package com.example.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class BigFileScanner {

    public static void main(String[] args){

        List<String> re = extractLines("/Users/yp-tc-m-4820/Desktop/code.txt",2);
//
//        List<String> re =new ArrayList<>() ;
//        int r = new Random().nextInt(3);
//
//        re.add("a");
//        re.add("b");
//        re.add("c");
//        re.remove(r);
////        re.poll();
//        re.add("d");
        System.out.println(re);

    }

    public static List<String> extractLines(String filePath, int n){
        List<String> result =new ArrayList<>() ;
        int i=1;
        FileInputStream inputStream = null;
        Scanner sc = null;
        try {
            inputStream = new FileInputStream(filePath);
            sc = new Scanner(inputStream, "UTF-8");
            while (sc.hasNextLine()) {
                String line = "";
                line = sc.nextLine();
                if(i<=n){
                    result.add(line);
                }else {
                    int r = new Random().nextInt(i);
                    if(r<n){
                        result.remove(r);
                        result.add(line);
                    }
                }
                i++;
            }
        }catch(IOException e){
            System.out.println(e);
        }finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                }catch (Exception e){
                    System.out.println(e);
                }
            }
            if (sc != null) {
                sc.close();
            }
        }
        return result;
    }



}
