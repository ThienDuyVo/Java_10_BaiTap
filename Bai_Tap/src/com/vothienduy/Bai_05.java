package com.vothienduy;

import java.text.DecimalFormat;
import java.util.Scanner;


class Point{
	int x;
	int y;
}

public class Bai_05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point A = new Point();
		Point B = new Point();
		System.out.println("Nhap vao toa do cua A");
		input(A);
		System.out.println("Nhap vao toa do cua B");
		input(B);
		double length =  Math.sqrt(Math.pow((B.x - A.x), 2) + Math.pow((B.y - A.y), 2));
		DecimalFormat format = new DecimalFormat("0.##");
		System.out.print("Do dai doan thang AB = "+format.format(length));
	}

	public static void input(Point A) {
		Scanner scan = new Scanner(System.in);
		System.out.print("x = ");
		A.x = scan.nextInt();
		System.out.println();
		System.out.print("y = ");
		A.y = scan.nextInt();
		System.out.println();
		scan.close();
		
	}

}

