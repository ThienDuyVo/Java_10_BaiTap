package com.vothienduy;

import java.util.Scanner;

public class Bai_07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Nhap vao so tu nhien can tim uoc: ");
		Scanner scan = new Scanner(System.in);
		System.out.println();
		int num = scan.nextInt();
		System.out.print("Cac uoc so cua "+num+ " la: ");
		for(int i = 1; i <= num/2; i++) {
			if(num % i == 0) {
				System.out.print(i+"   ");
			}
		}
		System.out.println(num);
		scan.close();
	}

	
}
