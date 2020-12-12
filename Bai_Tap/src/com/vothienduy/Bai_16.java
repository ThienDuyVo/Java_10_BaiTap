package com.vothienduy;

import java.util.Scanner;

public class Bai_16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhap vao nam can kiem tra: ");
		int year = scan.nextInt();
		while(year <= 0) {
			System.out.println("Nam vua nhap khong dung! Vui long nhap lai!");
			year = scan.nextInt();
		}
		if((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
			System.out.println("Nam "+year+" la nam nhuan!");
		}
		else
			System.out.println("Nam "+year+" khong phai la nam nhuan!");
		scan.close();
	}
	

}
