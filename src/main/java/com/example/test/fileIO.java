package com.example.test;

import java.io.BufferedReader;
import java.io.FileReader;

public class fileIO {

    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader(new FileReader("d:\\bw.txt"));
            char[] chs = new char[1024];
            int len;
            while((len=br.read(chs))!=-1)
            {
                System.out.print(new String(chs,0,len));
            }
            br.close();
        }catch (Exception e){

        }

    }
}
