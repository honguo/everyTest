package com.example.test;

public class ErweiList {

    public static void main(String[] args){
        int[][] a ={ };
        int target = 7;
        boolean re = find(target,a);
        System.out.println(re);
    }

    private static boolean find(int target, int [][] array) {
        if(array == null || 0 ==array.length  || array[0].length == 0){
            return false;
        }
        int wideLength = array.length;
        int longLength = array[0].length;
        //从左下角开始 migration>target像右移动一列 migration<target像上移动一列
        int i = wideLength-1;
        int j = 0;
        while (i>=0 && j<longLength){
            int migration = array[i][j];
            if(migration == target){
                return true;
            }
            if (migration < target){
                j++;
            }
            if (migration > target){
                i--;
            }
        }
        return false;
    }
}
