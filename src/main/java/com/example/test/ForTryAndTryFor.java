//package com.example.test;
//
//import org.openjdk.jmh.annotations.Benchmark;
//
//public class ForTryAndTryFor {
//    public static void main(String[] args) {
//        tryFor();
//        forTry();
//    }
//
//    @Benchmark
//    public static void tryFor() {
//        int j = 3;
//        try {
//            for (int i = 0; i < 1000; i++) {
//                Math.sin(j);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Benchmark
//    public static void forTry() {
//        int j = 3;
//        for (int i = 0; i < 1000; i++) {
//            try {
//                Math.sin(j);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
//
//}
