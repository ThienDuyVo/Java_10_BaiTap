package com.vothienduy;

import java.util.Scanner;

public class Bai_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner	 scan = new Scanner(System.in);
		int n;
		do {
			System.out.println("Nhap vao so tu nhien bat ky: ");
			n = scan.nextInt();
		}while(n < 1);
		int maxLog;
		if(n == 1) {
			System.out.println("Khong co so tu nhien nao nho hon log co so 2 cua 1!");
			scan.close();
			return;
			
		}
		else {
			if(n % 2 == 0) {
				maxLog = (int) (Math.log(n)/Math.log(2)) - 1;
			}
			else {
				maxLog = (int) (Math.log(n)/Math.log(2));
			}
		}
		System.out.println("So tu nhien lon nhat nho hon log co so 2 cua n la: "+maxLog);
		scan.close();
	}

}
