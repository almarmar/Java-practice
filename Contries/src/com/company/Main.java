package com.company;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        double[] phone = readData("data_countries.txt"); //телефоны
        String[] name = readData1("data_countries.txt"); //название
        int[] pop = readData2("data_countries.txt"); //численность
        dop(pop, phone, name);
        srStat(phone, name);
    }

    public static void dop(int[] pop, double[] phone, String[] name) { //дополнительное задание
        int sum = 0, average = 0, count = 0;
        for (int i = 0; i < phone.length; i++) {
            if (phone[i] * (double) 1000 >  pop[i] / 2) {
                sum += pop[i];
                count++;
                System.out.println("Название страны: " + name[i] + "и " + "численность населения: " + pop[i]);
            } else {
                i++;
            }
        }
        double dol = (((double) count / phone.length) * 100d);
        average = sum / count;
        System.out.println("Общая численность: " + sum);
        System.out.println("Средняя численность: " + average);
        System.out.printf("Доля этих стран в мире: " + "%.1f", dol);
        System.out.println("%");
    }

    public static void srStat(double[] data, String[] data1) { //поиск среднего по всему миру
        double sum = 0;
        double average;
        for (double datum : data) {
            sum += datum;
        }
        average = sum / data.length;
        //System.out.printf("Среднее значение по миру: " + "%.1f", average);
        //System.out.println();
        for (int i = 0; i < data.length; i++) {
            data[i] = Math.abs(data[i] - average);
        }
        int m1 = 0, m2 = 0, m3 = 0;
        double first = Double.MAX_VALUE;
        double second = Double.MAX_VALUE;
        double third = Double.MAX_VALUE;
        double current;
        for (int i = 0; i < data.length; ++i) {
            current = data[i];
            if (first > current) {
                third = second;
                m3 = m2;
                second = first;
                m2 = m1;
                first = current;
                m1 = i;
            } else if (second > current) {
                third = second;
                m3 = m2;
                second = current;
                m2 = i;
            } else if (third > current) {
                third = current;
                m3 = i;
            }
        }
        System.out.println("Название 3 стран, в которых количество телефонов на 1000 человек меньшего всего отличается от среднего в мире: " + data1[m1] + " " + data1[m2] + " " + data1[m3]);
    }

    public static double[] readData(String fileName) {
        double[] a = new double[100];
        int i = 0;
        try {
            Scanner sc = new Scanner(new File(fileName));
            String str;
            if (sc.hasNext()) {
                str = sc.nextLine();
            } else throw new IOException();
            while (sc.hasNext()) { //пока есть, что читать
                if (!Pattern.matches("[a-zA-Z]", str)) {//проверить наличие букв в первой строке
                    str = sc.nextLine();//считываем 2 строку
                    str = sc.nextLine();//считываем 3 строку
                    if (sc.hasNextDouble()) {//считываем 4 строку
                        a[i] = sc.nextDouble();
                        i++;
                        if (i == a.length) {
                            double[] a1 = new double[a.length * 2];
                            System.arraycopy(a, 0, a1, 0, a.length);
                            a = a1;
                        }
                    } else throw new IOException();
                } else {
                    str = sc.nextLine();
                }
                if (sc.hasNext()) str = sc.nextLine();
                else break;
                if (sc.hasNext()) str = sc.nextLine();
                else break;
            }
            sc.close();
        } catch (IOException e) {
            System.out.println("file error");
        }
        return Arrays.copyOf(a, i);
    }

    public static String[] readData1(String fileName) {
        String[] a = new String[100];
        int i = 0;
        try {
            Scanner sc = new Scanner(new File(fileName));
            int str1, str2;
            double str3;
            while (sc.hasNext()) {
                a[i] = sc.nextLine();
                i++;
                if (i == a.length) {
                    String[] a1 = new String[a.length * 2];
                    System.arraycopy(a, 0, a1, 0, a.length);
                    a = a1;
                }
                if (sc.hasNextInt())
                    str1 = sc.nextInt();
                else throw new IOException("2");
                if (sc.hasNextInt())
                    str2 = sc.nextInt();
                else throw new IOException("3");
                if (sc.hasNextDouble())
                    str3 = sc.nextDouble();
                else throw new IOException("4");
                if (sc.hasNext())
                    a[i] = sc.nextLine();
            }
            sc.close();
        } catch (IOException e) {
            System.out.println("file error" + e.getMessage());
        }
        return Arrays.copyOf(a, i);
    }

    public static int[] readData2(String fileName) {
        int[] a = new int[100];
        int i = 0;
        try {
            Scanner sc = new Scanner(new File(fileName));
            int str2;
            double str3;
            String str1;
            while (sc.hasNext()) {
                str1 = sc.nextLine();
                if (sc.hasNextInt()) {
                    a[i] = sc.nextInt();
                    i++;
                    if (i == a.length) {
                        int[] a1 = new int[a.length * 2];
                        System.arraycopy(a, 0, a1, 0, a.length);
                        a = a1;
                    }
                }
                if (sc.hasNextInt())
                    str2 = sc.nextInt();
                if (sc.hasNextDouble())
                    str3 = sc.nextDouble();
                if (sc.hasNext())
                    str1 = sc.nextLine();
            }
            sc.close();
        } catch (IOException e) {
            System.out.println("file error");
        }
        return Arrays.copyOf(a, i);
    }
}
