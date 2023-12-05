package lab;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.io.File;
import java.io.FileNotFoundException;

class aocDay_4 {
	public static void main(String[] args) throws FileNotFoundException {
		int fin = 0;
		Scanner scan = new Scanner(new File("C:\\Users\\cnielson6\\Downloads\\eclipse-workspace\\lab\\src\\words.txt"));
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			fin += getPoints(line);
		}
		System.out.println(fin);
		scan.close();
	}

	public static int getPoints(String line) {
		return compare(toIntArrayList(split(line)[1].strip()), getSet(toIntArrayList(split(line)[2].strip())));
	}

	public static int getVal(int times) {
		if (times < 1) {
			return 0;
		}
		int fin = 1;
		for (int i = 0; i < times - 1; i++) {
			fin *= 2;
		}
		return fin;
	}

	public static int compare(ArrayList<Integer> list, Set<Integer> set) {
		int fin = 0;
		for (Integer integer : list) {
			if (set.contains(integer)) {
				fin++;
			}
		}
		return fin;
	}

	// converting a string of ints to an arrayList
	public static ArrayList<Integer> toIntArrayList(String str) {
		ArrayList<Integer> list = new ArrayList<>();
		for (String string : str.replace("  ", " ").split(" ")) {
			list.add(Integer.parseInt(string));
		}
		return list;
	}

	// adds everything to a set to compare
	private static Set<Integer> getSet(ArrayList<Integer> arr) {
		Set<Integer> set = new HashSet<>();
		set.addAll(arr);
		return set;
	}

	// splits input into three parts, game number, your cards, winning cards
	public static String[] split(String str) {
		String[] arr = str.split("[:|]");
		return arr;
	}
}