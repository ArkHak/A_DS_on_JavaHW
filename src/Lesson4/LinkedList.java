package Lesson4;

import java.util.Iterator;

public interface LinkedList<T>  {

    void insertFirst(T id);

    T removeFirst();

    boolean remove(T value);

    boolean contains(T value);

    int size();

    boolean isEmpty();

    void display();

    T getFirst();

    class People<T> {
        T item;
        People<T> next;
        People<T> previous;

        public People(T item, People<T> next) {
            this(item, next, null);
        }

        public People(T item, People<T> next, People<T> previous) {
            this.item = item;
            this.next = next;
            this.previous = previous;
        }

    }
}
