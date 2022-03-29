package com.company;

import java.lang.Math;
import java.lang.String;
import java.util.Scanner;

public class Circle implements Comparable<Circle>  {
    public double x;
    public double y;
    public double r;
    private String n;

    /* Метод позволяет ввести первоначальные данные(координаты и имя центра окружности, радиус окружности) с помощью клавиатуры */
    public void input(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Введите координату X");
        x = reader.nextInt();
        System.out.println("Введите координату Y");
        y = reader.nextInt();
        System.out.println("Введите радиус окружности");
        r = reader.nextInt();
        System.out.println("Введите имя центра окружности");
        n = reader.next();
    }
    public Circle(double x, double y, double r, String n){
        this.x=x;
        this.y=y;
        this.r=r;
        this.n=n;
    }
    public Circle(){
        this.x=0.0;
        this.y=0.0;
        this.r=1.0;
        this.n="";
    }
    public double getX() {return x;}
    public void setX(double x) {this.x = x;}
    public double getY() {return y;}
    public void setY(double y) {this.y = y;}
    public double getR() {return r;}
    public void setR(double r) {this.r = r;}
    public String getName(){return n;}
    public void setName(){this.n=n;}
    /*Сравнение окружностей*/
    @Override
    public int compareTo(Circle obj) {
        if(r>obj.getR()){
            return 1;
        }
        if(r<obj.getR()){
            return -1;
        }
        return 0;
    }
    /* Метод выводит данные об окружности*/
    public void printCircle() {
        System.out.println("Окружность "+n+":("+x+"-x0)^2+("+y+"-y0)^2=("+r+")^2");
    }
    /*Метод находится расстояние между центрами окружностей и определяет касаются ли они */
    public double howLong(Circle obj) {
        double dX = (this.x - obj.getX()) * (this.x - obj.getX());
        double dY = (this.y - obj.getY()) * (this.y - obj.getY());
        return Math.sqrt(dX + dY);
    }
    /*Метод, определяющий, касаются ли окружности.*/
    public boolean touch(Circle obj){
        double d = howLong(obj);
        return (d == this.r + obj.r) || (d == Math.abs(this.r - obj.r));
    }
    /* Метод, выводящий информацию о касательности окружностей */
    public void touchOutput(Circle obj){
        if(this.touch(obj)) {
            System.out.println("Окружности касаются");
        }
        if(!this.touch(obj)){
            System.out.println("Окружности не касаются");
        }
    }


}


