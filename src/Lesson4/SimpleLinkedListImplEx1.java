package Lesson4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleLinkedListImplEx1<E> implements LinkedList<E>, Iterable<E> {

    protected People<E> firstPeople;
    protected int size;

    @Override
    public void insertFirst(E name) {
        firstPeople = new People<>(name, firstPeople);
        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        People<E> removedPeople = firstPeople;
        firstPeople = removedPeople.next;
        removedPeople.previous = null;

        size--;
        return removedPeople.item;
    }


    @Override
    public boolean remove(E value) {
        People<E> current = firstPeople;
        People<E> previous = null;
        while (current != null) {
            if (current.item.equals(value)) {
                break;
            }
            previous = current;
            current = current.next;
        }
        if (current == null) {
            return false;
        } else if (current == firstPeople) {
            removeFirst();
            return true;
        } else {
            previous.next = current.next;
        }

        current.next = null;
        size--;
        return true;
    }

    @Override
    public boolean contains(E value) {
        People<E> current = firstPeople;
        while (current != null) {
            if (current.item.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        People<E> current = firstPeople;
        while (current != null) {
            sb.append(current.item);
            if (current.next != null) {
                sb.append(" -> ");
            }

            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public E getFirst() {
        return getValue(firstPeople);
    }

    protected E getValue(People<E> value) {
        return value != null ? value.item : null;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    public void forEach() {
        for(Iterator<String> i = (Iterator<String>) this.iterator(); i.hasNext(); ) {
            String peopleName = i.next();
            System.out.println(peopleName);
        }
    }


    private class LinkedListIterator implements Iterator<E> {

        private final SimpleLinkedListImplEx1<E> list;

        private People<E> current;
        private People<E> previous;

        public LinkedListIterator() {
            this.list = SimpleLinkedListImplEx1.this;
            reset();
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            E nextValue = current.item;
            previous = current;
            current = current.next;
            return nextValue;
        }

        @Override
        public void remove() {
            if (previous == null) {
                list.firstPeople = current.next;
                reset();
            } else {
                previous.next = current.next;
                if (!hasNext()) {
                    reset();
                } else {
                    current = current.next;
                }
            }
        }

        public void reset() {
            current = list.firstPeople;
            previous = null;
        }
    }

}
