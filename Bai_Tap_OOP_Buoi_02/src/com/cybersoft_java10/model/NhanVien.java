package com.cybersoft_java10.model;

public class NhanVien extends NhanSu{
	private String maTruongPhong;
	
	//contructor
	public NhanVien() {
		super();
		this.luongMotNgayLam = 100;
	}
	public NhanVien(String maTruongPhong) {
		super();
		this.maTruongPhong = maTruongPhong;
	}
	public NhanVien(String maSo, String hoTen, String soDienThoai, float soNgayLamViec, int luongMotNgayLam,
																					String maTruongPhong) {
		super(maSo, hoTen, soDienThoai, soNgayLamViec, luongMotNgayLam);
		this.maTruongPhong = maTruongPhong;
	}
	public String getTruongPhong() {
		return this.maTruongPhong;
	}
	public void setTruongPhong(String maTruongPhong) {
		this.maTruongPhong = maTruongPhong;
	}
}
