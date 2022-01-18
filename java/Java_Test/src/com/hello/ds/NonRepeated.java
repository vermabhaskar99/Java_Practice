package com.hello.ds;

import java.util.LinkedHashMap;
import java.util.Map;

public class NonRepeated {

	static final int no_of_chars = 256;
	static int count[] = new int[no_of_chars];

	static void getCharCount() {
		String str = "geeksforgeeks";
		for (int i = 0; i < str.length(); i++) {
			count[str.charAt(i)]++;
		}
		for (int i = 0; i < count.length-1; i++) {
			if (count[i] !=0)
				System.out.println("count array with ::"+count[i]);
		}

		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		for (int i = 0; i < count.length; i++) {
			if (count[i] != 0) {
				System.out.println((char)i + " " + count[i]);
				map.put((char) i, count[i]);
			}
		}
		System.out.println(map);
		for (char key : map.keySet()) {
			int val = map.get(key);
			if (val == 1) {
				System.out.println("key::" + key);
			break;
			}
		}

	}

	public static void main(String[] args) {
		getCharCount();
	}

}
