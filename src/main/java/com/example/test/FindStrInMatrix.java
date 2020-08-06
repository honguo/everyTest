package com.example.test;

public class FindStrInMatrix {

    public static void main(String[] args){

    }

    private final int[][] next = {{0,1},{0,-1},{-1,0},{1,0}};

    public boolean hasStr(char[][] matrix,String str){
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
        return true;
    }

    private boolean backTracing(char[][] matrix,boolean[][] marked,int i,int j,String str,int pathAt){
        if(pathAt==str.length()){
            return true;
        }
        if(i<0||j<0||i>=matrix.length||j>=matrix[0].length||matrix[i][j]!=str.charAt(pathAt)||marked[i][j]){
            return false;
        }
        marked[i][j]=true;
        for(int[] n:next){
            if(backTracing(matrix,marked,i+n[0],j+n[1],str,++pathAt)){
                return true;
            }
        }
        marked[i][j]=false;
        return false;

    }

}
