package com.cybersoft_java10.model;

import java.util.Scanner;

public class GiamDoc extends NhanSu{
	private float soCoPhan;
	
	public GiamDoc() {
		super();
		this.luongMotNgayLam = 300;
	}
	public GiamDoc(float soCoPhan) {
		super();
		this.soCoPhan = soCoPhan;
	}
	public GiamDoc(String maSo, String hoTen, String soDienThoai, float soNgayLamViec, int luongMotNgayLam, float soCoPhan) {
		super(maSo, hoTen, soDienThoai, soNgayLamViec, luongMotNgayLam);
		this.soCoPhan = soCoPhan;
	}
	
	@Override
	public String getChucVu() {
		return "Giam doc";
	}
	public float getCoPhan() {
		return this.soCoPhan;
	}
	@Override
	public void nhapThongTin(Scanner scan) {
//		System.out.println("NHAP THONG TIN NHAN SU: ");
//		System.out.print("Ma so: ");
//		this.maSo = scan.nextLine();
//		System.out.print("\nHo ten: ");
//		this.hoTen = scan.nextLine();
//		System.out.print("\nSo dien thoai: ");
//		this.soDienThoai = scan.nextLine();
//		System.out.print("\nSo ngay lam viec: ");
//		this.soNgayLamViec = Float.parseFloat(scan.nextLine());
		super.nhapThongTin(scan);
		System.out.print("\nSo co phan: ");
		this.soCoPhan = Float.parseFloat(scan.nextLine());
		System.out.println();
	}
	@Override
	public void xuatThongTin() {
		System.out.println(
				String.format("%10s |", maSo)
				+ String.format("%16s |", hoTen)
				+ String.format("%16s |", soDienThoai)
				+ String.format("%12.2f |", soNgayLamViec)
				+ String.format("%16.2f |", luongMotNgayLam)
				+ String.format("%17.2f |", tinhLuong())
				+ String.format("%16s |", getChucVu())
				+ String.format("%25s |", getCoPhan()+"%")
			);
	}
	
}
