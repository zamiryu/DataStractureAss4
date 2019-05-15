public class BTree {
    private int t;
    private BTreeNode root;

    public BTree(String t)
    {
        this.t = Global.toPositiveInt(t);
    }
    /*public boolean delete(Integer key)
    {
        if (root != null)
            //return root.delete(key);
        else
            return false;
    }

    public void insert(Integer key)
    {
        if (root != null)
            root.insert(key);
        else
            root = new BTreeNode(key);
    }

    public BTreeNode search(Integer key)
    {
        if (root != null)
            return root.search(key);
        else
            return null;
    }*/
}
