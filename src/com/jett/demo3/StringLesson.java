package com.jett.demo3;

public class StringLesson {
    public static void main(String[] args) {
//        long start = System.currentTimeMillis();
//        System.out.println(start);
//        int sum = 0;
//        for (int i = 0;i<10000;i++) {
//            sum += i;
//        }
//
//        long end = System.currentTimeMillis();
//        System.out.println(end);
//        System.out.println("for 循环执行的时间是 " + (end - start));
//        long startNona = System.nanoTime();
//        System.out.println(startNona);
//        int sum = 0;
//        for (int i = 0;i<1000;i++) {
//            sum += i;
//        }
//
//        long endNona = System.nanoTime();
//        System.out.println(endNona);
//
//        System.out.println(endNona - startNona);
        /**
         * （1）如果要操作少量的数据用 String；
         *
         * （2）多线程操作字符串缓冲区下操作大量数据 StringBuffer；线程安全
         *
         * （3）单线程操作字符串缓冲区下操作大量数据 StringBuilder。线程不安全
         *
         */

        StringBuilder sb = new StringBuilder();
        sb.append("你好").append(2).append('c').append(false);

        System.out.println(sb.reverse().toString());
        System.out.println(sb.reverse().toString());

        System.out.println(sb.delete(2,3).toString());
        System.out.println(sb.insert(3,"jett").toString());
    }
}
