package com.vothienduy;

import java.util.Scanner;

public class Bai_21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int x1, x2, v1, v2;
		System.out.println("Nhap vao vi tri cua con kangaroo thu 1:(0 ----->10000)");
		x1 = scan.nextInt();
		while(x1 < 0|| x1 > 10000) {
			System.out.println("Vi tri ban nhap nam ngoai khoang quy dinh! Vui long nhap lai trong khoang 0 -------> 10000");
			x1 = scan.nextInt();
		}
		System.out.println("Nhap vao van toc cua con kangaroo thu 1:(1 ------> 10000)");
		v1 = scan.nextInt();
		while(v1 < 1|| v1 > 10000) {
			System.out.println("Van toc ban nhap nam ngoai khoang quy dinh! Vui long nhap lai trong khoang 0 -------> 10000");
			v1 = scan.nextInt();
		}
		///////////////////////////////////////////////////////////
		System.out.println("Nhap vao vi tri cua con kangaroo thu 2:(0 ----->10000)");
		x2 = scan.nextInt();
		while(x2 < 0|| x2 > 10000) {
			System.out.println("Vi tri ban nhap nam ngoai khoang quy dinh! Vui long nhap lai trong khoang 0 -------> 10000");
			x2 = scan.nextInt();
		}
		System.out.println("Nhap vao van toc cua con kangaroo thu 2:(1 ------> 10000)");
		v2 = scan.nextInt();
		while(v2 < 1|| v2 > 10000) {
			System.out.println("Van toc ban nhap nam ngoai khoang quy dinh! Vui long nhap lai trong khoang 0 -------> 10000");
			v2 = scan.nextInt();
		}
		scan.close();
		if(v1 == v2) {
			if(x1 == x2) {
				System.out.println("2 con kangaroo dung chung 1 vi tri va gap nhau tai moi buoc nhay!");
				return;
			}
			else {
				System.out.println("2 con kangaroo nay khong the gap duoc nhau!");
				return;
			}
		}
		else {
			if(x1 == x2) {
				System.out.println("2 con kangaroo dung chung 1 vi tri va chi gap nhau 1 lan tai vi tri truoc khi nhay! Se khong the gap lai!");
				return;
			}
			else if((x1 > x2 && v1 > v2) || (x1 < x2 && v1 < v2) ) {
				System.out.println("2 con kangaroo nay khong the gap duoc nhau!");
				return;
			}
			else {
				int soLanNhay = 0;
				if(x1 < x2) {
					do {
						soLanNhay++;
						x1 += v1;
						x2 += v2;
						}while(x1 < x2);				
					System.out.println("2 con kangaroo nay se gap nhau sau "+soLanNhay+" buoc nhay!");
				}
				else {
					do {
						soLanNhay++;
						x1 += v1;
						x2 += v2;
						}while(x1 > x2);				
					System.out.println("2 con kangaroo nay se gap nhau sau "+soLanNhay+" buoc nhay!");
				}
			}
		}
			
	}
		
		
}
