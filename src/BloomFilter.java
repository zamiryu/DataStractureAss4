import java.util.Scanner;
import java.io.File;
public class BloomFilter {
    private int m1;
    private LinkedList<funcData> functionsDB;
    private boolean[] badPassArr;

    public BloomFilter(String m1, String path) {
        //Convert input to a valid number
        this.m1 = Global.toPositiveInt(m1);

        //Initialize BloomFilter array
        badPassArr = new boolean[this.m1];

        try {
            //Read hash functions text file
            Scanner data = new Scanner(new File(path));

            //Use LinkedList as data-structure for the hash functions
            functionsDB = new LinkedList<>();

            //Go through all lines
            while (data.hasNextLine()) {
                functionsDB.insert(new Link<>(new funcData(data.nextLine())));
            }

        }
        catch (Exception e){e.printStackTrace();}

    }

    public void updateTable(String path) {
        try {
            //Read hash functions text file
            Scanner data = new Scanner(new File(path));

            //Go through all lines
            while (data.hasNextLine()) {

                //Convert password to int by Horner's rule
                int pass = Global.toHorner(data.nextLine());

                //Go through all hash-funtions
                Link<funcData> curr = functionsDB.getFirst();
                for (int i = 0; i < functionsDB.getSize(); i++) {
                    //Convert to key using hash-functions
                    int key = hashFunction(curr.getData(), pass);

                    //Mark key in the array
                    badPassArr[key] = true;
                    curr = curr.getNext();
                }
            }
        }
        catch (Exception e){e.printStackTrace();}
    }

    public String getFalsePositivePercentage(HashTable hashTable, String path)
    {
        try {
            //Read requested passwords text file
            Scanner data = new Scanner(new File(path));

            //Initialize counters
            int bloomRejected = 0;
            int hashRejected = 0;
            int numOfPass = 0;

            //Go through all requested password
            while (data.hasNextLine()) {
                numOfPass++;

                //Convert password to int by Horner's rule
                int pass = Global.toHorner(data.nextLine());

                //Check Presence by Bloom Filter
                if (this.IsExist(pass))
                    bloomRejected++;

                //Check Presence by HashTable
                if (hashTable.isExists(pass))
                    hashRejected++;
            }
            return  ""+((double)(bloomRejected-hashRejected)/(numOfPass-hashRejected));
        }
        catch (Exception e){e.printStackTrace();return null;}
    }

    public String getRejectedPasswordsAmount(String path)
    {
        try {
            //Read requested passwords text file
            Scanner data = new Scanner(new File(path));

            //Initialize counter
            int bloomRejected = 0;

            //Go through all requested password
            while (data.hasNextLine()) {

                //Convert password to int by Horner's rule
                int pass = Global.toHorner(data.nextLine());

                //Check Presence by Bloom Filter
                if (this.IsExist(pass))
                    bloomRejected++;
            }
            return "" + bloomRejected;
        }
        catch (Exception e){e.printStackTrace();return "";}
    }


    private boolean IsExist(int pass){
        //Check Presence by in FilterBloom the hash function data-base
        Link<funcData> curr = functionsDB.getFirst();

        //Go through all hash functions
        for (int i=0; i < functionsDB.getSize();i++)
        {
            //Convert to key using an hash-function
            int key = hashFunction(curr.getData(),pass);

            //If doesn't exist by this function- Mark as false
            if (!badPassArr[key])
                return false;

            curr = curr.getNext();
        }
        return true;
    }

    private int hashFunction(funcData f,int value)
    {
        int p = 15486907;
        int alpha = f.getAlpha();
        int beta = f.getBeta();
        return Global.Mod((Global.Mod((alpha*value)+beta, p)), m1);
    }
}
