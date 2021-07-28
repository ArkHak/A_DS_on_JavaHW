package Lesson3;

public class DequeImpl<E> implements Queue<E> {

    public static final int HEAD_DEFAULT = 0;
    public static final int TAIL_DEFAULT = -1;
    protected final E[] data;
    protected int size;

    protected int tail;
    protected int head;

    public DequeImpl(int maxSize) {
        this.data = (E[]) new Object[maxSize];
        this.head = HEAD_DEFAULT;
        this.tail = TAIL_DEFAULT;
    }

    @Override
    public boolean insert(E value) {
        if (isFull()) {
            return false;
        }

        if (tail == data.length - 1) {
            tail = TAIL_DEFAULT;
        }

        data[++tail] = value;
        size++;
        return true;
    }

    public boolean insertLeft(E value){
        if (isFull()) {
            return false;
        }

        if (--head < HEAD_DEFAULT) {
            head = data.length - 1;
        }

        data[head] = value;
        size++;
        return true;
    }



    @Override
    public E remove() {
        if (isEmpty()) {
            return null;
        }

        E value = data[head++];
        size--;

        return value;
    }

    public E removeRight() {
        if (isEmpty()) {
            return null;
        }

        E value = data[tail--];
        size--;

        return value;
    }


    @Override
    public E peekFront() {
        return data[head];
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
    public boolean isFull() {
        return size == data.length;
    }

    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        int index;
        StringBuilder sb = new StringBuilder("--> [");
        for (int i = 0; i < size; i++) {
            if (i + head < data.length) {
                index = i + head;
            } else {
                index = i + head - data.length;
            }
            sb.append(data[index]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}

