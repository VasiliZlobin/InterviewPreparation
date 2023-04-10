package ru.vasili_zlobin.interview.lesson2;

public class Main {
    public static void main(String[] args) {
        testLinkedList();
        testArrayList();
    }

    private static void testLinkedList() {
        List<Integer> list = new LinkedList<>();
        for (int i = 10; i > 0; i--) {
            list.add(i);
        }
        printList(list);
        list.delete(8);
        System.out.println(list.find(1));
        printList(list);
    }

    private static void testArrayList() {
        List<Integer> list = new ArrayList<>();
        for (int i = 37; i > 0; i--) {
            list.add(i);
        }
        printList(list);
        list.delete(11);
        System.out.println(list.find(21));
        printList(list);
    }

    private static void printList(List<Integer> list) {
        for (int i = 0; i < list.count(); i++) {
            System.out.print(list.get(i) + ",");
        }
        System.out.println();
    }
}
