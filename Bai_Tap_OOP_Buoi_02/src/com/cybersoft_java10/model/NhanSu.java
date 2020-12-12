package com.cybersoft_java10.model;

import java.util.Scanner;

public class NhanSu {
	protected String maSo;
	protected String hoTen;
	protected String soDienThoai;
	protected float soNgayLamViec;
	protected float luongMotNgayLam;
	

	
	public NhanSu() {
		this.maSo = "";
		this.hoTen = "";
		this.soDienThoai = "";
	}
	



	public NhanSu(String maSo, String hoTen, String soDienThoai, float soNgayLamViec, float luongMotNgayLam) {
		this.maSo = maSo;
		this.hoTen = hoTen;
		this.soDienThoai = soDienThoai;
		this.soNgayLamViec = soNgayLamViec;
		this.luongMotNgayLam = luongMotNgayLam;
	}
	



	public float getSoNgayLamViec() {
		return soNgayLamViec;
	}




	public void setSoNgayLamViec(float soNgayLamViec) {
		this.soNgayLamViec = soNgayLamViec;
	}




	public float getLuongMotNgayLam() {
		return luongMotNgayLam;
	}




	public void setLuongMotNgayLam(float luongMotNgayLam) {
		this.luongMotNgayLam = luongMotNgayLam;
	}




	public void setMaSo(String maSo) {
		this.maSo = maSo;
	}




	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}




	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}




	public float tinhLuong() {
		return soNgayLamViec*luongMotNgayLam;
	}
	
	public void nhapThongTin(Scanner scan) {
		System.out.println("NHAP THONG TIN NHAN SU: ");
		System.out.print("Ma so: ");
		this.maSo = scan.nextLine();
		System.out.print("\nHo ten: ");
		this.hoTen = scan.nextLine();
		System.out.print("\nSo dien thoai: ");
		this.soDienThoai = scan.nextLine();
		System.out.print("\nSo ngay lam viec: ");
		this.soNgayLamViec = Float.parseFloat(scan.nextLine());
	}
	public void xuatThongTin() {
		System.out.println(
				String.format("%10s |", maSo)
				+ String.format("%16s |", hoTen)
				+ String.format("%16s |", soDienThoai)
				+ String.format("%12.2f |", soNgayLamViec)
				+ String.format("%16.2f |", luongMotNgayLam)
				+ String.format("%17.2f |", tinhLuong())
				+ String.format("%16s |", getChucVu())
				+ String.format("%25s |", getThongTinThem())
			);
	}
	public String getMaSo() {
		return this.maSo;
	}
	public String getHoTen() {
		return this.hoTen;
	}
	public String getSoDienThoai() {
		return this.soDienThoai;
	}
	public String getChucVu() {
		return "Nhan vien";
	}
	public String getThongTinThem() {
		return "";
	}
}
