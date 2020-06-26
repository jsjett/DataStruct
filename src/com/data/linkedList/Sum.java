package com.data.linkedList;

public class Sum {

    /**
     * 递归求和
     * @param arr 求和的数组
     * @param l 索引
     * @return 结果
     */
    private static int getSum(int []arr, int l) {
        if(l == arr.length) {
            return 0;
        }
        return arr[l] + getSum(arr, l+1);
    }

    public static int sum(int[] array) {
        return getSum(array, 0);
    }

    // for循环实现的求和
    public static int sumFor(int[] array) {
        int sum = 0;
        for (int i = 0;i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] array = new int[100];
        for (int i = 0; i< array.length; i++) {
            array[i] = i+1;
        }

        double time1 = System.nanoTime();
        System.out.println(sum(array));
        double time2 = System.nanoTime();
        System.out.println(time2 - time1 / 1000000000);


        double time3 = System.nanoTime();
        System.out.println(sumFor(array));
        double time4 = System.nanoTime();
        System.out.println(time4 - time3 / 1000000000);
    }
}
