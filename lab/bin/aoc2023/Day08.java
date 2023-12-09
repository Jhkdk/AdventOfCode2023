import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import misc.ThreadSteps;

public class day08 {
	public static void main(String[] args) throws FileNotFoundException {
		Map<String, String> map = new HashMap<>();
		Set<String> set = new HashSet<>();
		Scanner scan = new Scanner(
				new File("C:\\Users\\cnielson6\\Downloads\\eclipse-workspace\\AdventOfCode\\src\\words.txt"));
		String instructions = scan.nextLine();
		scan.nextLine();
		while (scan.hasNext()) {
			String temp = scan.nextLine();
			if(temp.endsWith("[A]")) {
				
			}
			map.put(temp.split("=")[0].strip(),
					temp.split("=")[1].substring(2, temp.split("=")[1].length() - 1).replaceAll(",", ""));
		}
		System.out.println(step(instructions, map, set));
	}

	public static int step(String directions, Map<String, String> map, Set<String> set) {
		int fin = 0;
		Set<ThreadSteps> threads = new HashSet<>();
		for (String temp : set) {
			threads.add(new ThreadSteps(map,directions,temp));
		}
		for (ThreadSteps threadSteps : threads) {
			fin += threadSteps.getSteps();
		}
		return fin;
	}
}
