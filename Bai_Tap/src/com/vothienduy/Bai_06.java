package com.vothienduy;

import java.util.Scanner;

public class Bai_06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Nhap vao chuoi bat ky: ");
		Scanner scan = new Scanner(System.in);
		String string = scan.nextLine();
		String reverse = "";
		for(int i = string.length() -1; i >= 0; i--) {
			reverse += string.charAt(i);
		}
		System.out.print("Chuoi dao cua chuoi "+string+ " la: "+reverse);
		scan.close();

	}

}
