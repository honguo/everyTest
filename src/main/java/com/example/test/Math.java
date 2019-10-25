package com.example.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Math {
    private static final int MAX_THREAD_COUNT = 10;

    /**
     * 获取区间中的质数
     * @param start
     * @param end
     * @return
     */
    public static List<Long> getPrimeNumbers(Long start, Long end) {
        Long[] points = getPoints(start, end);

        List<Long> primeNumbers = new ArrayList<Long>();

        List<FutureTask<List<Long>>> futureTaskList = new ArrayList<FutureTask<List<Long>>>();
        ExecutorService excutorService = Executors.newFixedThreadPool(MAX_THREAD_COUNT);
        for (int i = 0; i < points.length - 1; i++) {
            // FutureTask可以看成是一个可以加入线程池的job,用来执行具体的任务
            FutureTask<List<Long>> futureTask = new FutureTask<List<Long>>(
                    new GetPrimeTask(points[i], points[i + 1] - 1));
            futureTaskList.add(futureTask);
            // executorService可以看成是一个线程池,调用submit方法提交Task任务
            excutorService.submit(futureTask);
        }

        for (FutureTask<List<Long>> futureTask : futureTaskList) {
            try {
                // get方法获取job计算得到的结果,该方法只有在Task完成任务后才会有返回.
                List<Long> partPrimeNumbers = futureTask.get();
                primeNumbers.addAll(partPrimeNumbers);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        ThreadPoolExecutor tp = (ThreadPoolExecutor) excutorService;
        System.out.println("池中最大的线程数据" + tp.getMaximumPoolSize() + ",当前池中线程数:" + tp.getPoolSize() + ",完成任务数:"
                + tp.getCompletedTaskCount());

        return primeNumbers;
    }

    /**
     * 判断是否是质数:只能被1和自身整除
     *
     * @param num
     * @return
     */
    public static boolean isPrimeNumber(Long num) {
        for (Long i = 2L; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * 将数据拆分为多个数据区间
     * @param start
     * @param end
     * @return
     */
    private static Long[] getPoints(Long start, Long end) {
        Long[] points = new Long[MAX_THREAD_COUNT];

        for (int i = 0; i < MAX_THREAD_COUNT - 1; i++) {
            points[i] = start + (end - start) / (MAX_THREAD_COUNT - 1) * i;
        }
        points[MAX_THREAD_COUNT - 1] = end + 1;

        return points;
    }
}
