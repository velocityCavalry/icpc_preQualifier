import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class E {

    public static void main(String[] args) {
        HashMap<Integer, HashSet<Integer>> m = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if (s.matches("[0-9]+ [0-9]+ [0-9]+")) {
            String[] title = s.split(" ");
            int totalRoom = Integer.parseInt(title[0]);
            int totalHall = Integer.parseInt(title[1]);
            int exitNum = Integer.parseInt(title[2]);
            int actualHall = 0;
            while (sc.hasNextLine()) {
                String curr = sc.nextLine();
                if (curr.matches("[0-9]+ [0-9]+")) {
                    String[] arr = curr.split(" ");
                    int room1 = Integer.parseInt(arr[0]);
                    int room2 = Integer.parseInt(arr[1]);
                    HashSet<Integer> set = m.getOrDefault(room1, new HashSet<>());
                    set.add(room2);
                    m.put(room1, set);
                    actualHall++;
                }
            }
        }
    }

    public static int Dijkstra(HashMap<Integer, HashSet<Integer>> m, HashSet<Integer> exits) {
        for(int root: exits) {
            Stack<Integer> s = new Stack<>();
            HashSet<Integer> visited = new HashSet<>();
            s.push(root);
            visited.add(root);
            while(!s.isEmpty()) {
                int k = s.pop();

            }
        }
        return 0;
    }



}
