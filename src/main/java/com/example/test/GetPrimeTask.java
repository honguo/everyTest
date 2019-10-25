package com.example.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class GetPrimeTask implements Callable<List<Long>> {

    private Long start;
    private Long end;

    public GetPrimeTask(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    public List<Long> call() throws Exception {
        List<Long> primeNumberList = new ArrayList<Long>();

        for (Long i = start; i <= end; i++) {
            //判断是否是质数,是的话插入集合中
            if (Math.isPrimeNumber(i)) {
                primeNumberList.add(i);
            }
        }
        return primeNumberList;
    }
}