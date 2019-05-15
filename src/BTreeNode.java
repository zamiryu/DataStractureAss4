public class BTreeNode {
    SpecialArray Keys;
    SpecialArray Children;
    boolean isLeaf;

    public BTreeNode()
    {
        Keys = new SpecialArray();
        Children = new SpecialArray();
        isLeaf = true;
    }

    /*public BTreeNode search(Integer key)
    {
        //
        Link<Integer> curr = Keys.getFirst();
        int i=0;
        while (key > curr.getData()){
            i++;
            curr = curr.getNext();
        }
        if (i<Keys.getSize() & key = curr.getData())
            return curr;
        else if (isLeaf)
            return null;
    }
*/




    public void insertKey(Integer key)
    {
        Link<Integer> curr = Keys.getFirst();
        if (curr==null)
        {
            Keys.insert(new Link<Integer>(key));
        }
        else{
            for (int i=0;i<Keys.getSize();i++)
            {
                if (i<curr.getData())
                {
                    if (curr.getNext()!=null && i>=curr.getNext().getData())
                    {

                    }
                }
                    curr = curr.getNext();
            }
            Keys.setSize(Keys.getSize()+1);
            //curr.
        }
    }
}
