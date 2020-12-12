package com.vothienduy;

import java.util.Scanner;

public class Bai_18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhap vao so tien gui:");
		double tienGui = scan.nextDouble();
		while(tienGui <= 0) {
			System.out.println("So tien gui cua ban nhap chua dung vui long nhap lai!");
			tienGui = scan.nextDouble();
		}
		System.out.println("Nhap vao so tien mong muon trong tuong lai:");
		double tienAoUoc = scan.nextInt();
		while(tienAoUoc < tienGui) {
			System.out.println("So tien mong muon cua ban nhap chua dung vui long nhap lai!");
			tienAoUoc = scan.nextDouble();
		}
		System.out.println("Nhap vao lai xuat cua ngan hang(0.1 ------------ > 10)%/nam");
		double laiXuat = scan.nextDouble();
		while(laiXuat <= 0 || laiXuat > 10) {
			System.out.println("Lai xuat cua ngan hang ban nhap chua dung vui long nhap lai!");
			laiXuat = scan.nextDouble();
		}
		int namChodoi = 0;
		while(tienGui < tienAoUoc){
			tienGui += (tienGui*laiXuat)/100;
			namChodoi ++;
		}
		System.out.println("So nam can doi: "+namChodoi);
		scan.close();
	}

}
