package ru.vasili_zlobin.interview.lesson2;

public class ArrayList<T> implements List<T> {
    private static final int INITIAL_CAPACITY = 5;
    private Object[] array = new Object[INITIAL_CAPACITY];
    private int lastIndex = -1;

    private void increaseArray() {
        Object[] target = new Object[array.length + INITIAL_CAPACITY];
        copyToArray(target);
        array = target;
    }

    private void decreaseArray() {
        Object[] target = new Object[array.length - 1];
        copyToArray(target);
        array = target;
    }

    private void copyToArray(Object[] target) {
        int j = -1;
        for (int i = 0; i <= lastIndex; i++) {
            if (array[i] == null) {
                continue;
            }
            j++;
            target[j] = array[i];
        }
    }

    @Override
    public void add(T value) {
        if (array.length <= lastIndex + 1) {
            increaseArray();
        }
        lastIndex++;
        array[lastIndex] = value;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index > lastIndex) {
            return null;
        }
        return (T)array[index];
    }

    @Override
    public int find(T value) {
        int result = -1;
        for (int i = 0; i <= lastIndex; i++) {
            if (value.equals((T)array[i])) {
                result = i;
                break;
            }
        }
        return result;
    }

    @Override
    public void delete(int index) {
        if (index < 0 || index > lastIndex) {
            return;
        }
        array[index] = null;
        decreaseArray();
        lastIndex--;
    }

    @Override
    public int count() {
        return lastIndex + 1;
    }
}
