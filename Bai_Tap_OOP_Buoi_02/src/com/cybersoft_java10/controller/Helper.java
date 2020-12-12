package com.cybersoft_java10.controller;

import com.cybersoft_java10.model.NhanSu;

public class Helper {
	
//	public String generateId() {
//		return tenVietTat 
//				+ OffsetDateTime.now().getYear()
//				+ getStt(4);
//	}
//	
//	public String getStt(int length) {
//		String result = "";
//		int i = 1;
//		
//		while(STT / (int)Math.pow(10, length-i) == 0) {
//			result += "0";
//			i++;
//		}
//		result += STT;
//		STT++;
//		
//		return result;
//	}
	public void inLine(String s) {
		Helper helper = new Helper();
		int num = 72;
		
		System.out.println(String.format("%" + (num*2 - s.length())/2 + "s", "") + s + String.format("%" + (num*2 - s.length())/2 + "s", ""));
		helper.drawLine(num);
		System.out.println();
		System.out.println(
				String.format(" %10s  ", "Mã số")
				+ String.format("%16s  ", "Họ tên")
				+ String.format("%16s  ", "Số điện thoại")
				+ String.format("%12s  ", "Ngày làm")
				+ String.format("%16s  ", "Lương cơ bản")
				+ String.format("%17s  ", "Lương")
				+ String.format("%16s", "Chức vụ")
				+ String.format("%25s  ", "Số nhân viên/Cổ phần")
			);
		helper.drawLine(num);
		System.out.println();
	}

	public String getTen(String s) {
		String[] temp = s.split("\\s");
		return temp[temp.length - 1];
	}
	public void drawLine(int num) {
		for(int i = 0; i < num; i++) {
			System.out.print("- ");
		}
	}
}
