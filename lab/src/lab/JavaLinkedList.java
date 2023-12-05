package lab;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Mainer {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int time = Integer.parseInt(scan.nextLine());
		Map<String, Integer> one = new HashMap<>();
		Map<String, Integer> two = new HashMap<>();
		for (int i = 0; i < time; i++) {
			add(scan.nextLine(), one);
		}
		for (int i = 0; i < time; i++) {
			add(scan.nextLine(), two);
		}
		int fin = Math.min(one.getOrDefault("correct", 0), two.getOrDefault("correct", 0));
		fin += Math.min(one.getOrDefault("wronganswer", 0), two.getOrDefault("wronganswer", 0));
		fin += Math.min(one.getOrDefault("timelimit", 0), two.getOrDefault("timelimit", 0));
		System.out.println(fin);
		scan.close();
	}

	public static void add(String key, Map<String, Integer> map) {
		if (map.containsKey(key)) {
			int val = map.get(key);
			map.put(key, val + 1);
		}
		map.putIfAbsent(key, 1);
	}
}