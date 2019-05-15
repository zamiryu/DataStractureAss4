public class HashList{
    private int size;
    private HashListElement first;

    public HashList() {
        //Create an empty list
        size = 0;
    }

    public void insert(HashListElement e) {

        //Increase the size of the list
        size++;

        //Switch pointers
        e.setNext(first);
        first = e;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public int getSize() {
        return size;
    }

    public HashListElement getFirst() {
        return first;
    }

}
