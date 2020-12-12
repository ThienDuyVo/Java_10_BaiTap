package com.vothienduy;

import java.util.Scanner;

public class Bai_15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhap vao chuoi bat ky: ");
		String input = scan.nextLine();
		System.out.print("Do dai cua chuoi vua nhap = "+input.length());
		System.out.println("\nNhap vi tri can xuat ki tu trong chuoi: ");
		int index = scan.nextInt();
		while(index < 0|| index > input.length()) {
			System.out.println("Vi tri khong dung! Vui long nhap lai!");
			index = scan.nextInt();
		}
		System.out.println("Ky tu tai vi tri "+index+" la: "+"'"+input.charAt(index)+"'");
		System.out.println("Nhap chuoi con can kiem tra co trong chuoi tren hay khong: ");
		scan.nextLine();
		String s = scan.nextLine();
		if(input.contains(s)) {
			System.out.println("Chuoi tren co chua chuoi phu: "+"'"+s+"'");
		}
		else
			System.out.println("Chuoi tren khong chua chuoi phu: "+"'"+s+"'");
		scan.close();
	}
}
