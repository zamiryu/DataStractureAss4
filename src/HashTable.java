import java.util.Scanner;
import java.io.File;

public class HashTable {
    HashList[] arr;
    int m2;

    public HashTable(String m2)
    {
        //Convert input to a valid number
        this.m2 = Global.toPositiveInt(m2);

        //Initialize HashTable array
        this.arr = new HashList[this.m2];
    }

    public void updateTable(String path) {

        try {
            //Read requested passwords text file
            Scanner data = new Scanner(new File(path));

            //Insert each bad password to the hash-table
            while (data.hasNextLine()) {

                //Convert password to int by Horner's rule
                int pass = Global.toHorner(data.nextLine());

                //Convert to key using hash-function
                int key = hashFunction(pass);

                //Create the element to be inserted
                HashListElement e = new HashListElement(pass);

                //Create a new LinkedList if current place is Empty
                if (arr[key] == null)
                    arr[key] = new HashList();

                //Insert element to the list
                arr[key].insert(e);
            }
        }
        catch (Exception e){e.printStackTrace();}
    }

    public boolean isExists(int pass)
    {
        //Convert to key using hash-function
        int key = hashFunction(pass);

        if (arr[key]!=null && !arr[key].isEmpty())
        {
            //Go through all elements in the LinkedList
            HashListElement curr = arr[key].getFirst();
            for (int i=0;i<arr[key].getSize();i++) {

                //If pass has been found
                if (curr.getData() == pass)
                    return true;

                curr = curr.getNext();
            }
        }
        return false;
    }

    private int hashFunction(int k) {
        return Global.Mod(k, m2);
    }
}
