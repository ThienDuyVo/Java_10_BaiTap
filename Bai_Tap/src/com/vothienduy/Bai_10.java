package com.vothienduy;

import java.util.Scanner;

public class Bai_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n;
		do {
			System.out.println("Nhap vao so tu nhien lon hon 1: ");
			n = scan.nextInt();
		}while(n <= 1);
		int sum = 0;
		for(int i = 2; i <= n; i++) {
			if(checkIsPrime(i)) {
				sum += i;
			}
		}
		System.out.println("Tong cac so nguyen to tu 1 ---> "+n+" la: "+sum);
		scan.close();
	}
	
	public static boolean checkIsPrime(int a) {
		for(int i = 2; i <= a/2; i++) {
			if(a % i == 0) {
				return false;
			}
		}
		return true;
	}

}
