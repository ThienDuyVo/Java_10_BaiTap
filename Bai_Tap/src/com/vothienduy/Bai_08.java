package com.vothienduy;

import java.util.Scanner;

public class Bai_08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Nhap vao mot chuoi bat ki: ");
		Scanner scan = new Scanner(System.in);
		String string = scan.nextLine();
		String[] stringArr = string.split(" ");
		for(int i = 0; i < stringArr.length; i++) {
			System.out.print(stringArr[i].substring(0, 1).toUpperCase() + stringArr[i].substring(1).toLowerCase() +" ");
		}
		scan.close();
	}

}
