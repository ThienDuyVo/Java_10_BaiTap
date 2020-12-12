package com.vothienduy;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Bai_22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Nhap vao chuoi can tim chuoi con Palindromic: ");
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		subPal(s);
//		int vtBegin = 0;
//		int vtEnd = 0;
//		int checkIndex = 0;
//		int len = 0;
//		String[] subStringPalindromic = new String[s.length()];
//		while(checkIndex < s.length()/2 - 1) {
//			for(int i = vtBegin; i < s.length()/2; i++) {
//				if(s.charAt(i) == s.charAt(s.length() -1 - i)) {
//					vtBegin = i;
//					break;
//				}
//			}
//			for(int i = vtBegin; i < s.length()/2; i++) {
//				if((s.charAt(i) != s.charAt(s.length() - 1 - i)) || i == (s.length()/2 - 1)) {
//					vtEnd = i;
//					checkIndex = i;
//					break;
//				}
//			}
//			if(vtBegin != vtEnd) {
//				subStringPalindromic[len] = s.substring(vtBegin, vtEnd + 1);
//				vtBegin = vtEnd;
//				len++;
//			}
//		}
//		System.out.println("Toi day");
//		for(int i = 0; i < len; i++) {
//			System.out.println(subStringPalindromic[i]);
//		}
	}
	private static void subPal(String str) {
        String s1 = "";
        int N = str.length();//count = 0;
        Set<String> palindromeArray = new HashSet<String>();
        System.out.println("Given string : " + str);
        System.out.println("******** Ignoring single character as substring palindrome");
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                int k = i + j - 1;
                if (k >= N)
                    continue;
                s1 = str.substring(j, i + j);
                if (s1.equals(new StringBuilder(s1).reverse().toString())) {
                    palindromeArray.add(s1);
                }
            }

        }
        System.out.println(palindromeArray);
        for (String s : palindromeArray)
            System.out.println(s + " - is a palindrome string.");
        System.out.println("The no.of substring that are palindrome : "
                + palindromeArray.size());
        String[] arrayPalindromic = new String[palindromeArray.size()];
        palindromeArray.toArray(arrayPalindromic);
        int max = 0;
        for(int i = 0; i < arrayPalindromic.length; i++) {
        	if(arrayPalindromic[i].length() > max) {
        		max = arrayPalindromic[i].length();
        	}
        }
        System.out.println("\nLongest palindrome string: ");
        for(int i = 0; i < arrayPalindromic.length; i++) {
        	if(arrayPalindromic[i].length() == max) {
        		System.out.println(arrayPalindromic[i]);
        	}
        }
    }
}
