package com.vothienduy;

import java.util.Random;
import java.util.Scanner;

public class Bai_17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		Random rd = new Random();
		int secureNumber = rd.nextInt(999) + 1;
		System.out.println("Nhap vao so du doan cua ban(1 ---------> 1000): ");
		int number = scan.nextInt();
		boolean isExact = false;
		do {
			
			if(number == secureNumber) {
				System.out.println("Ban da doan dung! So bi mat la: "+secureNumber);
				isExact = true;
				break;
			}
			else {
				if(number < secureNumber) {
					System.out.println("So ban vua nhap nho hon so bi mat!");
				}
				else {
					System.out.println("So ban vua nhap lon hon so bi mat!");
				}
				System.out.println("Moi ban doan lai so tu (1 ---------> 1000): ");
				System.out.println("Hoac chon 0 de ket thuc!");
				number = scan.nextInt();
				if(number == 0)
					break;
			}
		
		}while(!isExact || number == 0);	
		scan.close();
	}
}

