package com.vothienduy;

import java.util.Scanner;

public class Bai_09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Nhap vao so tu nhien thu 1:(10 --> 99) :" );
		Scanner scan = new Scanner(System.in);
		int numA = scan.nextInt();
		numA = check(numA);
		System.out.println("Nhap vao so tu nhien thu 2:(10 --> 99) :" );
		int numB = scan.nextInt();
		numB = check(numB);
		System.out.println("Check "+numA+" va "+numB+": "+ checkSame(numA, numB));
		scan.close();
	}
	public static int check(int a) {
		Scanner scan = new Scanner(System.in);
		if(a < 10 || a > 99) {
			do {
				System.out.println("Vui long nhap so trong khoang (10 ---> 99):");
				a = scan.nextInt();
			}while(a < 10 || a > 99);
		}
		return a;
	}
	
	public static boolean checkSame(int a, int b) {
		if((Integer.toString(a).charAt(0) == Integer.toString(b).charAt(0) || Integer.toString(a).charAt(0) == Integer.toString(b).charAt(1))){
			return true;
		}else if(Integer.toString(a).charAt(1) == Integer.toString(b).charAt(0) || Integer.toString(a).charAt(1) == Integer.toString(b).charAt(1)){
			return true;
		}else
			return false;
	}
	
}
