package com.vothienduy;

import java.util.Scanner;

public class Bai_20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhap vao so phan tu cua mang: ");
		int n = scan.nextInt();
		while(n <= 0) {
			System.out.println("Vui long nhap lai so phan tu cua mang!");
			n = scan.nextInt();
		}
		int[] arr = new int[n];
		System.out.println("Nhap vao cac phan tu cua mang: ");
		for(int i = 0; i < arr.length; i++) {
			System.out.print("arr["+i+"] = ");
			arr[i] = scan.nextInt();
			System.out.println();
		}
		scan.close();
		int[] evenArr = new int[n];
		int[] oddArr = new int[n];
		int i = 0;
		int lenEven = 0;
		int lenOdd = 0;
		while(i < arr.length) {
			if(arr[i] % 2 == 0) {
				evenArr[lenEven] = arr[i];
				lenEven++;
			}
			else {
				oddArr[lenOdd] = arr[i];
				lenOdd++;
			}
			i++;
		}
		if(lenEven == 0) {
			System.out.println("Mang tren khong co phan tu chan!");
		}
		else {
			System.out.println("Mang cac phan tu chan!");
			for(i = 0; i < lenEven; i++) {
				System.out.print(evenArr[i] +"   ");
			}
			System.out.println();
		}
		if(lenOdd == 0) {
			System.out.println("Mang tren khong co phan tu le!");
		}
		else {
			System.out.println("Mang cac phan tu le!");
			for(i = 0; i < lenOdd; i++) {
				System.out.print(oddArr[i] +"   ");
			}
			System.out.println();
		}
		
	}

}
