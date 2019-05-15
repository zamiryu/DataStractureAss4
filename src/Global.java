public class Global {

    public static int Mod(int x,int y)
    {
        int i = x % y;
        if (i<0) i += y;
        return i;
    }

    public static int toHorner(String s) {
        int ans = 0;
        ans = s.charAt(0);
        for (int i=1;i<s.length();i++)
        {
            int c = ((Character) s.charAt(i)).hashCode();
            ans = c + Global.Mod(256*ans,15486907);
        }
        return ans;
    }

    public static int toPositiveInt(String s)
    {
        String digits = "0123456789";
        int power = 1;
        int ans = 0;

        if (s.isEmpty())
            throw new IllegalArgumentException("Empty String");

        for (int i=s.length()-1;i>-1;i--)
        {
            int d = digits.indexOf(s.charAt(i));
            if (d == -1)
                throw new IllegalArgumentException("Illegal String");
            ans = ans + d * power;
            power = power * 10;
        }
        return ans;
    }


    public static int toInt(String s) {
        String digits = "0123456789";
        int sign = 1;
        int power = 1;
        int ans = 0;

        if (s.isEmpty())
            throw new IllegalArgumentException("Empty String" + s);

        if (s.charAt(0) == '-') {
            s = s.substring(1);
            sign = -1; }

        for (int i=s.length()-1;i>-1;i--)
        {
            int d = digits.indexOf(s.charAt(i));
            if (d == -1)
                throw new IllegalArgumentException("Illegal String");
            ans = ans + d * power;
            power = power * 10;
        }
        return ans * sign;
    }
}