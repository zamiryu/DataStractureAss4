public class funcData {

    int alpha;
    int beta;

    public funcData(String line) {

        //Find separation between alpha & beta
        int UnderlineIndex = line.indexOf('_');

        //Throw Exception if separation doesn't exist
        if (UnderlineIndex == -1)
            throw new IllegalArgumentException("Illegal data");

        //Split arguments, Convert to Integers, Update fields
        this.alpha = Global.toInt(line.substring(0,UnderlineIndex));
        this.beta = Global.toInt(line.substring(UnderlineIndex+1));
    }


    public int getAlpha() {
        return alpha;
    }
    public int getBeta() {
        return beta;
    }
}
