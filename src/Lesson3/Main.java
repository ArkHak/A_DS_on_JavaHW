package Lesson3;

public class Main {
    public static void main(String[] args) {

        ex3();
    }

    private static void ex3() {
        Queue<Integer> queue = new QueueImpl<>(5);
//        Queue<Integer> queue = new QueueImpl<>(5);

        System.out.println("add element: " + queue.insert(34));
        System.out.println("add element: " + queue.insert(12));
        System.out.println("add element: " + queue.insert(20));
        System.out.println("add element: " + queue.insert(16));
        System.out.println("add element: " + queue.insert(14));
        System.out.println("add element: " + queue.insert(17));

        queue.display();
        System.out.println("remove: " + queue.remove());
        queue.display();
        System.out.println("add element: " + queue.insert(17));
        queue.display();
        System.out.println("remove: " + queue.remove());
        queue.display();
        System.out.println("add element: " + queue.insert(1722));
        queue.display();
        System.out.println("remove: " + queue.remove());
        queue.display();
        System.out.println("remove: " + queue.remove());
        queue.display();
        System.out.println("add element: " + queue.insert(999));
        queue.display();
    }
}
