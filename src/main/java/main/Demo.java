package main;

public class Demo {
    public static void main(String[] args) {
        // Создаём контейнеры на основе JavaArrayBox
        JavaArrayBox<Integer> box1 = new JavaArrayBox<>();
        JavaArrayBox<Integer> box2 = new JavaArrayBox<>();

        // Работаем с box2
        box2.add(12);
        box2.add(12);
        box2.add(13);
        box2.add(2, 1); // вставка по индексу
        box2.add(8);

        // Работаем с box1
        box1.add(15);
        box1.add(116);
        box1.add(-1);

        // Выводим размеры
        System.out.println("Размер первого контейнера = " + box1.size());
        System.out.println("Размер второго контейнера = " + box2.size());

        // Получаем элементы
        int r = box1.get(2);
        int r1 = box1.get(0);
        System.out.println("Элемент с индексом (2) = " + r);
        System.out.println("Элемент с индексом (0) = " + r1);

        // Выводим строковое представление
        System.out.println("Первый контейнер после изменений: " + box1.toString());
        System.out.println("Второй контейнер после изменений: " + box2.toString());
    }
}
