package com.example.test;

public class FindStrInMatrix {

    public static void main(String[] args){
        char[][] matrix={{'a','b','c','d'},{'e','f','g','h'},{'a','h','c','l'},{'r','b','t','d'}};
        String str="ahfg";
        System.out.println(hasStr(matrix,str));
    }

    private static final int[][] next = {{0,1},{0,-1},{-1,0},{1,0}};

    public static boolean hasStr(char[][] matrix,String str){
        if(matrix.length==0 ||str.length()>matrix.length*matrix[0].length){
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] marked = new boolean[rows][cols];
        for(int i=0; i<rows;i++){
            for(int j=0;j<cols;j++){
                if(backTracing(matrix,marked,i,j,str,0))
                    return true;
            }
        }
        return false;
    }

    private static boolean backTracing(char[][] matrix,boolean[][] marked,int i,int j,String str,int pathAt){
        if(pathAt==str.length()){
            return true;
        }
        if(i<0||j<0||i>=matrix.length||j>=matrix[0].length||matrix[i][j]!=str.charAt(pathAt)||marked[i][j]){
            return false;
        }
        marked[i][j]=true;
        for(int[] n:next){
            if(i+n[0]<0){
                continue;
            }
            if(j+n[1]<0){
                continue;
            }
            if(backTracing(matrix,marked,i+n[0],j+n[1],str,pathAt+1)){
                return true;
            }
        }
        marked[i][j]=false;
        return false;

    }

}
