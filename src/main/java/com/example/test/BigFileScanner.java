package com.example.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class BigFileScanner {

    public List<String> extractLines(String filePath, int n){
        Random ran=new Random();
        List<String> re =null ;
        Set<Integer> set=new TreeSet<>();
        set.add(ran.nextInt(100)+1);
        while (set.size() < n){
            set.add(ran.nextInt(100)+1);
        }
        //todo 在这里填充代码
        for (int i=0 ;i<n;i++){
            re.add(getText(filePath, set[i]));
        }
        return re;
    }

    public String getText(String filePath,int n) throws IOException {
        FileInputStream inputStream = null;
        Scanner sc = null;
        try {
            inputStream = new FileInputStream(filePath);
            sc = new Scanner(inputStream, "UTF-8");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                // System.out.println(line);
            }
        }catch(IOException e){
//            logger.error(e);
        }finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (sc != null) {
                sc.close();
            }
        }
    }

}
