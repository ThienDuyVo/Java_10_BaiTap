package com.vothienduy;

import java.util.Scanner;

public class Bai_12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n;
		do {
			System.out.println("Nhap vao so tu nhien 1 ------> 9 :");
			n = scan.nextInt();
		}while(n < 1 || n > 9);
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print(j);
			}
			System.out.println();
		}
		scan.close();
	}

}
