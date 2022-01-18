package com.hello.ds;

public class NonRepeatable {
	static final int num = 256;
	static char count[] = new char[num];

	static char[] getCharCountArray(String str) {
		for (int i = 0; i < str.length(); i++) {
			//System.out.println(count[str.charAt(i)]++);
			count[str.charAt(i)]++;
			//System.out.println(count[str.charAt(i)]++);
		}

		return count;

	}

	static int firstNonRepeading(String str) {
		getCharCountArray(str);
		int index = -1, i;
		for (i = 0; i < str.length(); i++) {
			if (count[str.charAt(i)] == 1) {
				index = i;
				break;
			}
		}
		return index;
	}

	public static void main(String[] args) {
		String str = "geeksforgeeks";
		int index = firstNonRepeading(str);
		System.out.println(str.charAt(index));
	}

}
