package com.cybersoft_java10.model;

import java.util.Scanner;

public class TruongPhong extends NhanSu{
	private int soNhanVien;
	
	//construcor
	public TruongPhong() {
		super();
		this.luongMotNgayLam = 200;
	}
	public TruongPhong(int soNhanVien) {
		super();
		this.soNhanVien = soNhanVien;
	}
	
	
	public TruongPhong(String maSo, String hoTen, String soDienThoai, float soNgayLamViec, float luongMotNgayLam, int soNhanVien) {
		super(maSo, hoTen, soDienThoai, soNgayLamViec, luongMotNgayLam);
		this.soNhanVien = soNhanVien;
	}
	public int tangSoNhanVien() {
		return this.soNhanVien++;
	}
	public int giamSoNhanVien() {
		return this.soNhanVien--;
	}
	
	@Override
	public float tinhLuong() {
		//return luongMotNgayLam*soNgayLamViec + 100*soNhanVien;
		float luong = super.tinhLuong();
		luong += 100*soNhanVien;
		return luong;
	}
	@Override
	public String getChucVu() {
		return "Truong phong";
	}
	public int getSoNhanVien() {
		return this.soNhanVien;
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
		System.out.print("\nSo nhan vien duoi quyen: ");
		this.soNhanVien = Integer.parseInt(scan.nextLine());
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
				+ String.format("%25s |", getSoNhanVien()+" nguoi.")
			);
	}
	
}
