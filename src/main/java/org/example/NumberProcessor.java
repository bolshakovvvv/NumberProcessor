package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.*;

public class NumberProcessor {

    //Для удобства работы представим строку с числами через пробел в качестве массива
    //Инстанцирование массива
    ArrayList<Integer> list;

    //При созданиии объекта тестироваемого класса считываем значения из файла
    public NumberProcessor() throws IOException {
        readFromFile();
    }

    //Функция чтения из файла, инициализации и заполнения массива
    private void readFromFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input_1000000_el.txt"));
        String[] s = br.readLine().split(" ");
        list = new ArrayList<>();
        for (String i : s){
            list.add(Integer.parseInt(i));
        }
        br.close();
    }

    //Функция нахождения суммы чисел с помощью Stream API
    public long getSum(){
        return list.stream().mapToInt(i -> i).sum();
    }

    //Функция нахождения максимума с помощью Stream API
    public int getMax(){
        return list.stream().mapToInt(i -> i).max().getAsInt();
    }

    //Функция нахождения минимума с помощью Stream API
    public int getMin(){
        return list.stream().mapToInt(i -> i).min().getAsInt();
    }

    //Функция нахождения произведения с помощью Stream API
    public BigInteger getMult(){
        return BigInteger.valueOf(list.stream().mapToLong(Integer::longValue).reduce(1, (a, b) -> a * b));
    }

    //Функция нахождения среднего значения чисел с помощью Stream API
    public long getAvg(){
        return getSum() / list.size();
    }

    @Override
    public String toString() {
        return "NumberProcessor{" +
                "list=" + list +
                '}';
    }

    public static void main(String[] args) throws IOException {

        //Создание объекта класса
        NumberProcessor obj = new NumberProcessor();

        //Вывод количества элементов
        System.out.println("Results for " + obj.list.size() + " elements:");

        long start;
        long end;

        //Вычисление времени работы функции поиска максимума
        start = System.nanoTime();
        obj.getMax();
        end = System.nanoTime();
        System.out.println("getMax() works " + (end - start) + " ns");

        //Вычисление времени работы функции поиска минимума
        start = System.nanoTime();
        obj.getMin();
        end = System.nanoTime();
        System.out.println("getMin() works " + (end - start) + " ns");

        //Вычисление времени работы функции поиска произведения
        start = System.nanoTime();
        obj.getMult();
        end = System.nanoTime();
        System.out.println("getMult() works " + (end - start) + " ns");

        //Вычисление времени работы функции поиска суммы
        start = System.nanoTime();
        obj.getSum();
        end = System.nanoTime();
        System.out.println("getSum() works " + (end - start) + " ns");

    }
}
