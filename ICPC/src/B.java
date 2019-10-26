import java.util.HashMap;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        HashMap <Character, String> m = new HashMap<>();
        m.put('x', "yz");
        m.put('y', "x");
        m.put('z', "xxx");

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int s = sc.nextInt();
            System.out.println(numHaunt(s, m));
        }

    }

    public static int numHaunt(int x, HashMap<Character, String> m) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while (count < x) {
            sb.append('x');
            count++;
        }
        int i = 1;
        char curr = sb.charAt(0);
        while (sb.length() > 1) {
           // System.out.println(sb.toString());
            if (sb.length() >= 2) {
                curr = sb.charAt(0);
                i++;
                sb.delete(0, 2);
                sb.append(m.get(curr));
            }
        }
        return i;
    }


}
