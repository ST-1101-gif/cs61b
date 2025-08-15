import java.util.ArrayList;
import java.util.List;

public class LinkedListDeque61B<T> implements Deque61B<T> {
    Node sentinel;

    private class Node{
        Node prev;
        T item;
        Node next;


        Node(){
            prev = this;
            next = this;
        }

        Node(T item){
            prev = this;
            this.item = item;
            next = this;
        }
    }

    public LinkedListDeque61B() {
        sentinel = new Node();
    }

    @Override
    public void addFirst(T x) {
        Node first = new Node(x);
        first.prev = sentinel;
        first.next = sentinel.next;
        sentinel.next.prev = first;
        sentinel.next = first;
    }

    @Override
    public void addLast(T x) {
        Node last = new Node(x);
        last.next = sentinel;
        last.prev = sentinel.prev;
        sentinel.prev.next = last;
        sentinel.prev = last;
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        Node p = sentinel.next;
        while (p != sentinel) {
            returnList.add(p.item);
            p = p.next;
        }
        return returnList;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        int size = 0;
        Node p = sentinel.next;
        while (p != sentinel) {
            size++;
            p = p.next;
        }
        return size;
    }

    @Override
    public T removeFirst() {
        Node first = sentinel.next;
        sentinel.next = first.next;
        first.next.prev = sentinel;
        return first.item;
    }

    @Override
    public T removeLast() {
        Node last = sentinel.prev;
        sentinel.prev = last.prev;
        last.prev.next = sentinel;
        return last.item;
    }

    @Override
    public T get(int index) {
        Node p = sentinel.next;
        int i;
        for (i = 0; i <index; i++) {
            if (p == sentinel) {
                return null;
            }
            p = p.next;
        }
        return p.item;
    }

    @Override
    public T getRecursive(int index) {
        Node p = sentinel.next;
        if (p == sentinel) {
            return null;
        }
        if (index == 0) {
            return p.item;
        }
        return getRecursive(index - 1);
    }
}
