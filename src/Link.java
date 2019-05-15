public class Link<T> {
    Link<T> next;
    T data;

    public Link(T data) {
        this.data = data;
    }
    public Link(T data, Link<T> nextLink) {
        this.data = data;
        this.next = nextLink;
    }
    public void setNext(Link<T> nextLink) {
        this.next = nextLink;
    }

    public Link<T> getNext() {
        return next;
    }
    public T getData() {
        return data;
    }
}
