package com.cybersoft_java10.interfaces;

import java.util.Scanner;

public interface NhapXuat {
	void nhapThongTin(Scanner scanner);
	void xuatThongTin();
	
	default void sayHello() {
		System.out.println("Hello from the otherside.");
		
	}
}
