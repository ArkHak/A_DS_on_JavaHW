package Lesson3;

public class Main {
    public static void main(String[] args) {

        ex2();
//        ex3();


    }

    private static void ex2() {
        DequeImpl<Integer> deque = new DequeImpl<>(5);

        System.out.println("add element: " + deque.insert(34));
        System.out.println("add element: " + deque.insert(12));
        System.out.println("add element: " + deque.insert(20));
        System.out.println("add element: " + deque.insert(16));
        System.out.println("add element: " + deque.insert(14));

        deque.display();
        System.out.println("removeLeft: " + deque.remove());
        deque.display();
        System.out.println("addRight element: " + deque.insert(17));
        deque.display();
        System.out.println("removeRight: " + deque.removeRight());
        deque.display();
        System.out.println("addRight element: " + deque.insert(111));
        deque.display();
        System.out.println("removeLeft: " + deque.remove());
        deque.display();
        System.out.println("addRight element: " + deque.insert(333));
        deque.display();
        System.out.println("removeLeft: " + deque.remove());
        deque.display();
        System.out.println("addLeft element: " + deque.insertLeft(777));
        deque.display();
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
