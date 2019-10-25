package com.example.test;

import java.util.Calendar;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        System.out.println("start");
        Long startTime = getCurTime();

        List<Long> primeNumberList = Math.getPrimeNumbers(200000L, 300000L);

        for (Long primeNumber : primeNumberList) {
            System.out.println("" + primeNumber);
        }
        Long endTime = getCurTime();

        System.out.println("消耗时间:" + (endTime - startTime) + " ms");
    }

    private static Long getCurTime() {
        Calendar c = Calendar.getInstance();
        return c.getTimeInMillis();
    }
}