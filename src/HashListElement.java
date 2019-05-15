public class HashListElement{
    HashListElement next;
    Integer data;

    public HashListElement(Integer data) {
        this.data = data;
    }
    public HashListElement getNext() {
        return this.next;
    }
    public void setNext(HashListElement nextLink) {
        this.next = nextLink;
    }
    public Integer getData() {
        return data;
    }
}
