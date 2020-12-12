package com.vothienduy;

import java.util.Scanner;

public class Bai_19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int choose;
		do {
			System.out.println("1. Giai phuong trinh bac 1!");
			System.out.println("2. Giai phuong trinh bac 2!");
			System.out.println("0. Thoat!");
			System.out.println();
			choose = scan.nextInt();
			while(choose < 0 || choose > 2) {
				System.out.println("Ban chon sai! vui long chon lai!\n");
				System.out.println("1. Giai phuong trinh bac 1!");
				System.out.println("2. Giai phuong trinh bac 2!");
				System.out.println("0. Thoat!");
				choose = scan.nextInt();
			}
			
			switch(choose) {
			case 1:
				System.out.println("ax + b = 0");
				System.out.print("Moi ban nhap he so a: ");
				double a = scan.nextDouble();
				System.out.print("\nMoi ban nhap he so b: ");
				double b = scan.nextDouble();
				giaiPTBac_1(a, b);
				System.out.println("\n");
			case 2:
				System.out.println("ax^2 + bx + c = 0");
				System.out.print("Moi ban nhap he so a: ");
				a = scan.nextDouble();
				System.out.print("\nMoi ban nhap he so b: ");
				b = scan.nextDouble();
				System.out.print("\nMoi ban nhap he so c: ");
				double c = scan.nextDouble();
				giaiPTBac_2(a, b, c);
			}
			
		}while(choose != 0);
		scan.close();
	}
	
	public static void giaiPTBac_1(double a, double b) {
		if(a == 0) {
			if(b != 0) {
				System.out.println("Phuong trinh : "+a+"x + "+b+" = 0 vo nghiem!");
				return;
			}
			else
			{
				System.out.println("Phuong trinh : "+a+"x + "+b+" = 0  co vo so nghiem!");
				return;
			}
		}
		else {
			double result = ((double)-b)/a;
			System.out.print("Ngiem cua phuong trinh "+a+"x + "+b+" = 0 la:  ");
			System.out.println(result);
		}	
	}
	
	public static void giaiPTBac_2(double a, double b, double c) {
		double result1, result2;
		if(a == 0) {
			giaiPTBac_1(b, c);
			return;
		}
		else {
			double delta = b*b - 4*a*c;
			if(delta < 0) {
				System.out.println("Phuong trinh : "+a+"x^2 + "+b+"x + "+c+" = 0  vo nghiem!");
				return;
			}
			else if(delta == 0) {
				System.out.println("Phuong trinh : "+a+"x^2 + "+b+"x + "+c+" = 0  co nghiem kep x1 = x2 = " +(-b)/(2*a));
				return;
			}
			else {
				result1 = ((double)(-b) + Math.sqrt(delta))/(2*a);
				result2 = ((double)(-b) - Math.sqrt(delta))/(2*a);
				System.out.println("Phuong trinh : "+a+"x^2 + "+b+"x + "+c+" = 0  co 2 nghiem:\nx1 = " +result1+"\nx2 = "+result2);
			}
		}
		System.out.println();
	}

}
