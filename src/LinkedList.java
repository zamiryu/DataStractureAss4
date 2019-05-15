public class LinkedList<T>{
    int size;
    Link<T> first;

    public LinkedList() {
        //Create an empty list
        size = 0;
    }

    public void insert(Link<T> e) {
        //Increase the size of the list
        size++;
        e.setNext(first);
        //Switch pointer
        first = e;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public int getSize() {
        return size;
    }

    public Link<T> getFirst() {
        return first;
    }
}

