package main;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

class JavaArrayBoxTest {

    @Test
    @DisplayName("Конструктор по умолчанию")
    void testDefaultConstructor() {
        JavaArrayBox<String> box = new JavaArrayBox<>();
        assertEquals(0, box.size());
    }

    @Test
    @DisplayName("Добавление элемента")
    void testAdd() {
        JavaArrayBox<Integer> box = new JavaArrayBox<>();
        box.add(100);
        assertEquals(1, box.size());
        assertEquals(100, box.get(0));
    }

    @Test
    @DisplayName("Добавление по индексу")
    void testAddAtIndex() {
        JavaArrayBox<String> box = new JavaArrayBox<>();
        box.add("B");
        box.add(0, "A");
        assertEquals("A", box.get(0));
        assertEquals("B", box.get(1));
    }

    @Test
    @DisplayName("Некорректный индекс при добавлении")
    void testAddInvalidIndex() {
        JavaArrayBox<String> box = new JavaArrayBox<>();
        assertThrows(IndexOutOfBoundsException.class, () -> box.add(1, "X"));
    }

    @Test
    @DisplayName("Получение элемента")
    void testGet() {
        JavaArrayBox<String> box = new JavaArrayBox<>();
        box.add("Hello");
        assertEquals("Hello", box.get(0));
    }

    @Test
    @DisplayName("Удаление элемента")
    void testRemove() {
        JavaArrayBox<String> box = new JavaArrayBox<>();
        box.add("A");
        box.add("B");
        box.remove(0);
        assertEquals(1, box.size());
        assertEquals("B", box.get(0));
    }

    @Test
    @DisplayName("Замена элемента")
    void testSet() {
        JavaArrayBox<String> box = new JavaArrayBox<>();
        box.add("Old");
        String old = box.set(0, "New");
        assertEquals("Old", old);
        assertEquals("New", box.get(0));
    }

    @Test
    @DisplayName("toArray")
    void testToArray() {
        JavaArrayBox<Integer> box = new JavaArrayBox<>();
        box.add(1);
        box.add(2);

        Object[] arr = box.toArray();
        Integer[] intArr = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            intArr[i] = (Integer) arr[i];
        }

        assertArrayEquals(new Integer[]{1, 2}, intArr);
    }

    @Test
    @DisplayName("toString")
    void testToString() {
        JavaArrayBox<String> box = new JavaArrayBox<>();
        box.add("X");
        box.add("Y");
        assertEquals("[X, Y]", box.toString());
    }

    @Test
    @DisplayName("Автоматическое расширение")
    void testAutoGrow() {
        JavaArrayBox<Integer> box = new JavaArrayBox<>(2);
        box.add(1);
        box.add(2);
        box.add(3);
        assertEquals(3, box.size());
        assertEquals(3, box.get(2));
    }
}