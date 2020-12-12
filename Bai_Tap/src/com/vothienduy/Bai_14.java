package com.vothienduy;

import java.util.Scanner;

public class Bai_14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("Nhap vao so phan tu cua mang: ");
			n = scan.nextInt();
		}
		while(n <= 0);
		int[] arr = new int[n];
		System.out.println("Nhap vao tung phan tu cua mang: ");
		for(int i = 0; i < n; i++) {
			System.out.print("array["+i+"] = ");
			arr[i] = scan.nextInt();
			System.out.println();
		}
		
		System.out.println("Mang vua nhap la: ");
		for(int i: arr) {
			System.out.print(i+"   ");
		}
		System.out.println();
		System.out.println("Mang sau khi xoa cac phan tu trung lap: ");
		deleteTheSameElements(arr);	

		scan.close();
	}
	
	public static void deleteTheSameElements(int[] a) {
		int[] temp = new int[a.length]; 
		int tempSize = 0;
		temp[tempSize] = a[0];
		tempSize++;
		boolean isExist;
		for(int i = 1; i < a.length; i++) {
			isExist = false;
			for(int j = 0; j < tempSize; j++) {
				if(temp[j] == a[i]) {
					isExist = true;
					break;
				}
			}
			if(!isExist) {
				temp[tempSize] = a[i];
				tempSize++;
			}
		}
		for(int i = 0; i < tempSize; i++) {
			System.out.print(temp[i]+"   ");
		}
		System.out.println();
	}

}
