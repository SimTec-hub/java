package geekbrain;
import java.util.Arrays;

import static java.lang.Math.*;

public class Main {

    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
    }

    private static void task7() {
        int[] ar = new int[]{1,2,3,4,5,6,7,8,9};
        int n = 3;
        int x;
        if (n < 0) {
            for (int i = 0; i < Math.abs(n); i++) {
                x = ar[0];
                for (int j = 0; j < ar.length - 1; j ++) {
                    ar[j] = ar[j+1];
                }
                ar[ar.length - 1] = x;
            }
        }
        else {
            for (int i = 0; i < n; i++) {
                x = ar[ar.length - 1];
                for (int j = ar.length - 1; j > 0; j --) {
                    ar[j] = ar[j-1];
                }
                ar[0] = x;
            }
        }
    }
    private static void task6() {
        int[] equally = new int[6];
        for (int i = 0; i < equally.length; i++) {
            equally[i] = (int) (Math.random() * 10);
        }
        boolean e;
        int left = equally[0];
        int rigth = 0;
        for (int a : equally) {
           rigth += a;
        }
        rigth = rigth - left;
        for (int j = 1; j < equally.length; j++) {
            if (left == rigth) {
                e = true;
                System.out.println(e);
                break;
            }
            else {
                left = left + equally[j];
                rigth = rigth - equally[j];
            }
        }
    }
    private static void task5() {
    int[] array = new int[20];
    for (int i = 0; i < array.length; i++) {
        array[i] = (int) (Math.random() * 100);
    }
    int min = array[0];
    int max = array[0];
    for (int j  = 1; j < array.length; j++) {
        if (array[j] < min)
            min = array[j];
    }
    for (int k  = 1; k < array.length; k++) {
        if (array[k] > max)
            max = array[k];
    }
    System.out.println("Минимальный элемент в массиве: " + min);
    System.out.println("Максимальный элемент в массиве: " + max);
    }
    private static void task4() {
        int[][] square = new int[7][7];
        for (int i = 0; i < square.length; i++) {
            square[i][i] = 1;
            square[square.length - i - 1][i] = 1;
        }
    }
    private static void task3() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6)
                arr[i] = arr[i] * 2;
            }
    }
    private static void task2() {
        int[] eight = new int[8];
        for (int i = 0, y = 0; i < eight.length; i++, y += 3) {
            eight[i] = y;
        }
    }
    private static void task1() {
        int[] bit = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < bit.length; i++) {
            if (bit[i] == 0)
                bit[i] = 1;
            else bit[i] = 0;
        }
    }
}

