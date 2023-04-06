package ru.vasili_zlobin.interview.lesson2;

public class LinkedList<T> implements List<T> {
    private int lastIndex = -1;
    private Element<T> first;
    private Element<T> last;

    private Element<T> getElement(int index) {
        Element<T> result;
        if (lastIndex - index < index) {
            result = last;
            for (int i = 0; i < lastIndex - index; i++) {
                result = result.getPrev();
            }
        } else {
            result = first;
            for (int i = 0; i < index; i++) {
                result = result.getNext();
            }
        }
        return result;
    }

    @Override
    public void add(T value) {
        Element<T> element = new Element<>();
        element.setValue(value);
        if (first == null) {
            first = element;
        } else {
            last.setNext(element);
            element.setPrev(last);
        }
        lastIndex++;
        last = element;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index > lastIndex) {
            return null;
        }
        return getElement(index).getValue();
    }

    @Override
    public int find(T value) {
        int result = -1;
        if (first == null) {
            return -1;
        }
        if (first.getValue().equals(value)) {
            return 0;
        }
        Element<T> current = first;
        for (int i = 1; i <= lastIndex; i++) {
            current = current.getNext();
            if (current.getValue().equals(value)) {
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
        Element<T> element = getElement(index);
        Element<T> prev = element.getPrev();
        Element<T> next = element.getNext();
        prev.setNext(next);
        next.setPrev(prev);
        lastIndex--;
    }

    @Override
    public int count() {
        return lastIndex + 1;
    }
}
