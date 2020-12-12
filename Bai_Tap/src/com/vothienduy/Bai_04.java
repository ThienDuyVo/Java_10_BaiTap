package com.vothienduy;

import java.util.Scanner;

public class Bai_04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Nhap vao so tu nhien:");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int n = num;
		int sum = 0;
		while(num > 0) {
			int temp = num % 10;
			sum += temp;
			num /= 10;
		}
		
		System.out.print("Tong cac chu so cua so "+n+" la: "+sum);
		scan.close();
	}

}
