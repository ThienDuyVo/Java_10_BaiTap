package com.vothienduy;

import java.util.Scanner;

public class Bai_02 {
	public static void main(String[] args) {
		System.out.println("Nhap vao so can chuyen: ");
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
		scan.nextLine();
		System.out.println("So "+number+" chuyen thanh so nhi phan la: "+intToBinary(number));
		String binaryNumber = "";
		System.out.println("Nhap vao so nhi phan can chuyen thanh co so 10: ");
		boolean check;
		do {
			check = true;
			binaryNumber = scan.nextLine();
			int i = 0;
			while(i < binaryNumber.length()) {
				if((binaryNumber.charAt(i) != '0')  && binaryNumber.charAt(i) != '1') {
					System.out.println("So nhi phan ban nhap chua dung! Vui long nhap lai!");
					check = false;
					break;
				}
				i++;
			}	
		}while(!check);
//		double temp = Double.parseDouble(binaryNumber);
//		DecimalFormat format = new DecimalFormat("0"); 
		System.out.println("So nhi phan "+ binaryNumber+" chuyen thanh co so 10 la: "+binaryToDec(binaryNumber));
		scan.close();
	}


	public static String intToBinary(int num) {
		String preBinary ="";
		String binary = "";
		while(num > 0) {
			int temp = num%2;
			num = num/2;
			preBinary = preBinary + Integer.toString(temp);
		}
		for(int  i = preBinary.length() -1; i >= 0; i--) {
			binary += preBinary.charAt(i);
		}
		return binary;
	}
	
	public static int binaryToInt(double binary) {
		int num = 0;
		int i = 0;
		while(binary > 0) {
			int temp = (int) (binary % 10);	
			num += (temp*Math.pow(2, i));
			binary /= 10;
			i++;
		}
		return num;
	}
	
	public static int binaryToDec(String binary) {
		int tong = 0;
		int i = 0;
		int len = binary.length() - 1;
		while(i <= len) {
			if(binary.charAt(len - i) == '1') {
				tong += Math.pow(2, i);
			}
			i++;
		}
		return tong;
	}
}