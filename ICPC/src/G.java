import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class G {
	static TreeMap<Integer, String> map;
	
	static ArrayList<int[]> factors(int n) { 
		ArrayList<int[]> list = new ArrayList<>();
		for (int i = 1; i * i <= n; i++) 
			if (n % i == 0) {
            	int[] arr = {i, n/i};
            	list.add(arr);
			}
		return list;	
    } 
	
	static String G(int num) {
		if (map.containsKey(num - 1)) {
			return map.get(num - 1);
		}
		ArrayList<int[]> factors_pairs = factors(num);
		String result = G(num - 1) + "+1";
		if (factors_pairs.size() == 1) {
			map.put(num - 1, result);
		} else {
			for (int i = 1; i < factors_pairs.size(); i++) {
				String str1 = G(factors_pairs.get(i)[0]);
				String str2 = G(factors_pairs.get(i)[1]);
				System.out.println(str1);
				System.out.println(str2);
				String newStr = "";
				if (str1.substring(str1.length() - 1).equals(")") && str1.substring(0, 1).equals("(")){
					newStr += str1 + "*";
				} else if(str1.substring(str1.length() - 1).equals(")")) {
					newStr += "(" + str1 + "*";
				} else if(str1.substring(0, 1).equals("(")) {
					newStr += str1 + ")*";
				} else {
					newStr += "(" + str1 + ")*";
				}
				if (str2.substring(str2.length() - 1).equals(")") && str2.substring(0, 1).equals("(")){
					newStr += str2;
				} else if (str2.substring(str2.length() - 1).equals(")")) {
					newStr += "(" + str2;
				} else if (str2.substring(0, 1).equals("(")) {
					newStr += str2 + ")";
				} else {
					newStr += "(" + str2 + ")";
				}
				if (newStr.length() <= result.length()) {
					result = newStr;
				}
			}
		}
		map.put(num - 1, result);
		return map.get(num - 1);
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			String numStr = scanner.nextLine();
			int num = Integer.parseInt(numStr);
			map = new TreeMap<>();
			map.put(0, "1");
//			G(num);
//			for (int name: map.keySet()){
//	            String value = map.get(name);  
//	            System.out.println(name + 1 + " " + value);  
//			} 
			System.out.println(G(num));
		} catch(NumberFormatException e) { 
		    return;
		} catch(NullPointerException e) {
		    return;
		}
	}
}
