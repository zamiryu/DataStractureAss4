public class SpecialArray extends LinkedList<Integer> {

    private Link<Integer> last;
    public SpecialArray()
    {
        size=0;
    }

    public Link<Integer> getLast()
    {
        return last;
    }
    public void setSize(int n)
    {
        this.size = n;
    }
    public void setFirst(Link<Integer> first)
    {
        this.first = first;
    }
    public void setLast(Link<Integer> last)
    {
        this.last = last;
    }


    public SpecialArray merge(SpecialArray leftArray, SpecialArray rightArray)
    {
        SpecialArray mergedArray = new SpecialArray();
        mergedArray.setSize(leftArray.getSize() + rightArray.getSize());
        leftArray.getLast().setNext(rightArray.getFirst());
        mergedArray.setFirst(leftArray.getFirst());
        mergedArray.setLast(rightArray.getLast());
        return mergedArray;
    }

    public Link<Integer> lookup(Integer value)
    {
        Link<Integer> curr = first;
        for (int i=0;i<this.getSize();i++)
        {
            if (curr.getData().equals(value)){
              return curr;
            }
            curr = curr.getNext();
        }
         return null;
    }

    public Link<Integer> findAt(Integer index)
    {
        if (index >= size)
            return null;

        Link<Integer> curr = first;
        for (int i=0;i<size;i++)
        {
            if (i==index)
                return curr;
            curr = curr.getNext();
        }
        return null;
    }

    public SpecialArray splitAfter(Integer index)
    {
        Link<Integer> lastAtLeft = findAt(index);
        if (lastAtLeft !=null & index!=0 & index!=size)
        {
            SpecialArray rightList = new SpecialArray();
            Link<Integer> firstAtRight = lastAtLeft.getNext();
            rightList.insert(firstAtRight);
            rightList.setSize(size-index-1);
            this.size = index+1;
            this.last = lastAtLeft;
            return rightList;
        }
        return null;
    }

}
