package com.example.test;

import java.util.*;

public class ListPerformance
{
    private static final int REPS = 1000;

    private abstract static class Tester//内部抽象类，作为List测试。
    {
        String name;
        int size;

        Tester(String name, int size)
        {
            this.name = name;
            this.size = size;
        }

        abstract void test(List a);
    }

    private static Tester[] tests = {
    new Tester("get", 3000)//一个测试数组，存储get(随机取)、iteration(顺序遍历)、insert(中间插入)、remove(随机删除)
    {
        @Override
        void test(List a)
        {
            for (int i = 0; i < REPS; i++) {
                for (int j = 0; j < a.size(); j++) {
                    a.get(j);
                }
            }
        }
    },
    new Tester("iteration", 3000)
    {
        @Override
        void test(List a)
        {
            for (int i = 0; i < REPS; i++) {
                Iterator it = a.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }
    },
    new Tester("insert", 10000)
    {
        @Override
        void test(List a)
        {
            int half = a.size() / 2;
            String s = "test";
            ListIterator it = a.listIterator(half);
            for (int i = 0; i < size * 10; i++) {
                it.add(s);
            }
        }
    },
    new Tester("remove", 5000)
    {
        @Override
        void test(List a)
        {
            ListIterator it = a.listIterator(3);
            while (it.hasNext()) {
                it.next();
                it.remove();
            }
        }
    },
    };

    public static void test(List a)
    {
        System.out.println("Testing " + a.getClass().getName());//输出测试的类名称
        for (int i = 0; i < tests.length; i++) {
            fill(a, tests[i].size);//填充空集合
            System.out.print(tests[i].name);
            long t1 = System.currentTimeMillis();
            tests[i].test(a);//进行测试
            long t2 = System.currentTimeMillis();
            System.out.print(":" + (t2 - t1)+" ms ");
        }
    }

    public static Collection fill(Collection c, int size)
    {
        for (int i = 0; i < size; i++) {
            c.add(Integer.toString(i));
        }
        return c;
    }

    public static void main(String[] args)
    {
//        test(new ArrayList());
        test(new LinkedList());
        System.out.println();
//        test(new LinkedList());
        test(new ArrayList());

    }

}
