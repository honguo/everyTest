package com.example.test;

import org.apache.commons.collections.map.HashedMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PrintMatrix {

    public static void main(String[] args){
        int[][] matrix = {{4,5,6,8},{6,2,7,3},{6,8,2,8},{1,6,7,3}};
//        int[][] matrix = {{1},{2},{3},{4},{5}};
        ArrayList<Integer> result = printMatrix(matrix);
//        System.out.println(matrix.length);
//        System.out.println(matrix[0].length);
    }

    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        Map<String,Object> map = cricle(result,matrix,matrix[0].length,matrix.length,0,0);
        while ((Integer)map.get("n") > 0 && (Integer)map.get("m") > 0){
            map = cricle((ArrayList<Integer>)map.get("result"),matrix,(int) map.get("n"),(int) map.get("m"),(int) map.get("i"),(int) map.get("j"));
        }
        System.out.println(result);
        return result;
    }

    public static Map<String,Object> cricle(ArrayList<Integer> result, int [][] matrix, int n,int m, int i, int j){
        Map<String,Object> map = new HashMap<>();
        for(int a=0;a<n-1;a++){
            result.add(matrix[i][j++]);
        }
        for(int a=0;a<m-1;a++){
            result.add(matrix[i++][j]);
        }
        for(int a=0;a<n-1 && m>1;a++){
            result.add(matrix[i][j--]);
        }
        for(int a=0;a<m-2 && n>1;a++){
            result.add(matrix[i--][j]);
        }
        result.add(matrix[i][j]);
        map.put("result",result);
        map.put("i",i);
        map.put("j",j+1);
        map.put("n",n-2);
        map.put("m",m-2);
        return map;
    }
}
