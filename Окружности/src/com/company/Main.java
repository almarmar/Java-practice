package com.company;

public class Main {

    public static void main(String[] args) {
        Circle A = new Circle ();
        Circle B = new Circle ();
        System.out.println("Введите данные для первой окружности");
        A.input();
        System.out.println("Введите данные для второй окружности");
        B.input();
        A.printCircle();
        B.printCircle();
        System.out.println("Расстояние между центрами окружностей = " + A.howLong(B));
        A.touchOutput(B);
        if(A.compareTo(B) > 0) {
            System.out.println("Первая окружность больше");
        }
        else if(A.compareTo(B) < 0) {
            System.out.println("Вторая окружность больше");
        }
        if(A.compareTo(B)==0) {
            System.out.println("Окружности равны");
        }
    }
}
