package seminar04.homework;

import java.util.ArrayList;

public class Program {

    /**
     Домашняя работа, задача:
     ========================

     a. Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
     b. Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта,
     поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
     c. Для хранения фруктов внутри коробки можно использовать ArrayList;
     d. Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество:
     вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
     e. Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той, которую
     подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае.
     Можно сравнивать коробки с яблоками и апельсинами;
     f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
     Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
     Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;
     g. Не забываем про метод добавления фрукта в коробку.
     */
    public static void main(String[] args) {

        Box<Apple> applesBox1 = new Box<>();
        Box<Apple> applesBox2 = new Box<>();
        for (int i = 0; i < 10; i++) {
            applesBox1.addFruit(new Apple());
            applesBox2.addFruit(new Apple());
        }

        Box<Orange> orangesBox1 = new Box<>();
        orangesBox1.addFruit(new Orange(), 20);


        System.out.println("Коробка яблок 1: " + applesBox1);
        System.out.println("Коробка яблок 2: " + applesBox2);
        System.out.println("Коробка апельсинов: " + orangesBox1);

        System.out.println("\nСравниваем коробки с яблоками");
        if (applesBox2.equals(applesBox1))
            System.out.println("Вес коробок одинаковый");

        System.out.println();

        System.out.println("\nСравниваем коробку с яблоками и коробку с апельсинами");
        switch (orangesBox1.compareTo(applesBox1)){
            case 1:     System.out.println("Коробка с апельсинами тяжелее"); break;
            case -1:    System.out.println("Коробка с апельсинами легче");  break;
            default:    System.out.println("Коробки равны"); break;
        }

        System.out.println("\nПерекладываем 10 яблок из коробки 1 в коробку 2");
        if (applesBox1.transferFruitsTo(applesBox2, 10) == true)
            System.out.println("Успешная транзакция!");
        System.out.println("Коробка яблок 1: " + applesBox1);
        System.out.println("Коробка яблок 2: " + applesBox2);

        System.out.println("\nИ еще раз пытаемся переложить 10 яблок из коробки 1 в коробку 2");
        if (applesBox1.transferFruitsTo(applesBox2, 10) == true)
            System.out.println("Успешная транзакция!");
        else
            System.out.println("Транзакция невыполнима, в коробке источнике нет необходимого количества");
        System.out.println("Коробка яблок 1: " + applesBox1);
        System.out.println("Коробка яблок 2: " + applesBox2);

        System.out.println("\nИ на последок попытаемся переложить апельсины в коробку с яблоками");
        //orangesBox1.transferFruitsTo(applesBox1, 5);
        System.out.println("... но компилятор не позволит такое сделать");
        System.out.println(orangesBox1);






    }

}
