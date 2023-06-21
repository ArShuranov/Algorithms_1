package org.example;

import org.example.service.StringList;
import org.example.service.StringListImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        StringList stringList1 = new StringListImpl();
        StringList stringList2 = new StringListImpl();

        // проверка пустой
        System.out.println(stringList1.isEmpty());

        //добавление элементов
        System.out.println(stringList1.add("11111"));
        System.out.println(stringList2.add("11111"));

        //сравнение если равны
        System.out.println(stringList1.equals(stringList2));

        //добавим еще
        System.out.println(stringList1.add("Привет"));
        System.out.println(stringList1.add("Bonjour"));
        System.out.println(stringList1.add("Hello"));

        //сравнение если не равны
        System.out.println(stringList1.equals(stringList2));

        //проверка не пустой
        System.out.println(stringList1.isEmpty());

        //добавление по индексу
        System.out.println(stringList1.add(1, "пока"));

        //замена значение по индексу
        System.out.println(stringList1.set(3, "Досвидания"));

        // удаление по значению
        stringList1.remove("11111");

        // удаление по индексу
        stringList1.remove(2);


        //содержит значение
        System.out.println(stringList1.contains("Hello"));

        //находит индекс первого вхождения по возрастанию
        System.out.println(stringList1.indexOf("Привет"));

        //находит индекс первого вхождения в реверсе
        System.out.println(stringList1.lastIndexOf("Bonjour"));

        //получаем элемент по индексу
        System.out.println(stringList1.get(2));

        //получаем размер листа
        System.out.println(stringList1.size());

        //stringList1.clear();


        System.out.println("____________");
        // создаем копию массива из нашего списка
        System.out.println(Arrays.toString(stringList1.toArray()));
    }
}