import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = Integer.valueOf(sc.nextLine());
        String eles = sc.nextLine();
        String[] values = eles.split(" ");
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.valueOf(values[i]);
        }
        if (ifRestore(arr, size)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    
    static boolean ifRestore(int[] arr, int num) {
        boolean result = true;
        int zero = 0;
        int previous = arr[0];
        for (int i = 1; i < num; i++) {
            if (arr[i] != 0) {
                if (arr[i] - previous <= zero) {
                    zero = 0;
                    return false;
                }
                if (arr[i] <= arr[i-1]) {
                    return false;
                } else {
                    previous = arr[i];
                }
            } else {
                zero ++;
            }
        }
        return true;
    }


}
