package main;

import java.util.Arrays;

/**
 * Класс JavaArrayBox реализует обобщенный контейнер,
 * который использует массив для хранения элементов.
 *
 * @param <E> тип элементов, которые могут храниться в контейнере
 */
public class JavaArrayBox<E> {
    private Object[] array;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public JavaArrayBox() {
        this.array = new Object[DEFAULT_CAPACITY];
    }

    public JavaArrayBox(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Данный индекс некорректен: " + capacity);
        }
        this.array = new Object[capacity];
    }

    public int size() {
        return this.size;
    }

    private Object[] grow() {
        int newCapacity = (int) (array.length * 1.5 + 1);
        Object[] newArray = new Object[newCapacity];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
        return array;
    }

    public boolean add(E e) {
        if (size == array.length) {
            grow();
        }
        array[size] = e;
        size++;
        return true;
    }

    public boolean add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Данный индекс некорректен: " + index);
        }
        if (size == array.length) {
            grow();
        }
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = element;
        size++;
        return true;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Данный индекс некорректен: " + index);
        }
        return (E) array[index];
    }

    public boolean remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Данный индекс некорректен: " + index);
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size - 1] = null;
        size--;
        return true;
    }

    public E set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Данный индекс некорректен: " + index);
        }
        E oldElement = (E) array[index];
        array[index] = element;
        return oldElement;
    }

    /**
     * Возвращает массив, содержащий все элементы текущего массива.
     *
     * @return массив типа Object
     */
    public Object[] toArray() {
        return Arrays.copyOf(array, size);
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }
}