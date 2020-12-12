package com.cybersoft_java10.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cybersoft_java10.model.GiamDoc;
import com.cybersoft_java10.model.NhanSu;
import com.cybersoft_java10.model.NhanVien;
import com.cybersoft_java10.model.TruongPhong;
import com.cybersoft_java10.view.CongTy;

public class QuanLyNhanSu {
	private List<NhanSu> dsNhanSu;
	
	//contructor
	
	public QuanLyNhanSu() {
		dsNhanSu = new ArrayList<NhanSu>();
	}
	
	public void phanBoNhanVienVaoTruongPhong(Scanner scan) {
		List<NhanVien> dsNhanVienChuaPhanBo = new ArrayList<NhanVien>();
		List<TruongPhong> dsTruongPhong = new ArrayList<TruongPhong>();
		int luaChon;
		for(NhanSu ns: dsNhanSu) {
			if((ns instanceof NhanVien) && (((NhanVien) ns).getTruongPhong() == null)) {
				dsNhanVienChuaPhanBo.add((NhanVien) ns);
			}
			else if(ns instanceof TruongPhong) {
				dsTruongPhong.add((TruongPhong) ns);
			}
		}
		System.out.println("PHAN BO NHAN VIEN:");
		
		for(NhanVien nhanVien: dsNhanVienChuaPhanBo) {
			String dsnv = "Thong tin nhan vien:";
			Helper helper = new Helper();
			int num = 72;
			
			System.out.println(String.format("%" + (num*2 - dsnv.length())/2 + "s", "") + dsnv + String.format("%" + (num*2 - dsnv.length())/2 + "s", ""));
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
			nhanVien.xuatThongTin();
			//System.out.println(nhanVien.getTruongPhong());
			System.out.println();
			String dstp = "Danh sach truong phong:";
			System.out.println(String.format("%" + (num*2 - dstp.length())/2 + "s", "") + dstp + String.format("%" + (num*2 - dstp.length())/2 + "s", ""));
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
			for(int i = 0; i < dsTruongPhong.size(); i++) {
				System.out.print("\t"+(i+1)+". ");
				dsTruongPhong.get(i).xuatThongTin();
			}
			System.out.println("\t0. Khong phan bo!");
			int a = 1, b = dsTruongPhong.size();
			
			System.out.print("Lua chon: ");
			luaChon =  a + (int)(Math.random()*((b - a) + 1));
			System.out.println(luaChon);
			TruongPhong truongPhong;
			if(luaChon <= 0)
				continue;
			truongPhong = dsTruongPhong.get(luaChon -1);
			nhanVien.setTruongPhong(truongPhong.getMaSo());
			truongPhong.tangSoNhanVien();
			
			
		}
	}
	public boolean them(NhanSu nhanSu) {
	 if(nhanSu == null)
		 return false;
	 if("".equalsIgnoreCase(nhanSu.getHoTen()))
		 return false;
	 if(daTonTai(nhanSu))
		 return false;
	 
	 dsNhanSu.add(nhanSu);
	 return true;
	}
	public boolean xoa(String maSo) {
		if(maSo == null)
			return false;
		for(NhanSu nhanSu: dsNhanSu) {
			if(nhanSu instanceof TruongPhong && nhanSu.getMaSo().equalsIgnoreCase(maSo)) {
				for(NhanSu nhanSuLaNhanVien: dsNhanSu) {
					if(nhanSuLaNhanVien instanceof NhanVien) {
						if(((NhanVien)nhanSuLaNhanVien).getTruongPhong() != null
								&& ((NhanVien)nhanSuLaNhanVien).getTruongPhong().equalsIgnoreCase(maSo)) {
							((NhanVien)nhanSuLaNhanVien).setTruongPhong(null);
							
						}
					}
				}
				dsNhanSu.remove(nhanSu);
				System.out.println("Xoa truong phong co ma: "+ maSo+" thanh cong!");
				return true;
			}
			else if(nhanSu instanceof NhanVien && nhanSu.getMaSo().equalsIgnoreCase(maSo)) {
				if(((NhanVien)nhanSu).getTruongPhong() != null) {
					for(NhanSu nhanSuLaTruongPhong: dsNhanSu) {
						if(nhanSuLaTruongPhong instanceof TruongPhong) {
							if(nhanSuLaTruongPhong.getMaSo().equalsIgnoreCase((((NhanVien)nhanSu).getTruongPhong()))) {
								((TruongPhong)nhanSuLaTruongPhong).giamSoNhanVien();
							}
						}
					}
				}
				dsNhanSu.remove(nhanSu);
				System.out.println("Xoa nhan vien co ma: "+ maSo+" thanh cong!");
				return true;
			}
			else if(nhanSu instanceof GiamDoc && nhanSu.getMaSo().equalsIgnoreCase(maSo)){
				dsNhanSu.remove(nhanSu);
				System.out.println("Xoa giam doc co ma: "+ maSo+" thanh cong!");
				return true;
			}
		}
		return false;

	}
	public double tinhTongLuong() {
		double tongLuong = 0;
		for (NhanSu nhanSu : dsNhanSu) {
			tongLuong += nhanSu.tinhLuong();
		}
		
		return tongLuong;
	}
	
	
	public void inDanhSachNhanSu() {
		Helper helper = new Helper();
		int num = 72;
		String ttNhanSu = "DANH SÁCH NHÂN SỰ";
		
		System.out.println(String.format("%" + (num*2 - ttNhanSu.length())/2 + "s", "") + ttNhanSu + String.format("%" + (num*2 - ttNhanSu.length())/2 + "s", ""));
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
		for (NhanSu nhanSu : dsNhanSu) {
			nhanSu.xuatThongTin();
		}
		helper.drawLine(num);
		System.out.println();
		System.out.println(
				String.format(" %10s  ", "")
				+ String.format("%16s  ", "")
				+ String.format("%16s  ", "")
				+ String.format("%30s  ", "Tổng lương")
				+ String.format("%17.2f  ", tinhTongLuong())
				+ String.format("%16s", "")
				+ String.format("%25s  |", "")
			);
		helper.drawLine(num);
	}
	public boolean daTonTai(NhanSu nhanSu) {
		for(NhanSu ns: dsNhanSu) {
			if(ns.getSoDienThoai().equalsIgnoreCase(nhanSu.getSoDienThoai()))
				return true;
		}
		return false;
	}
	public NhanSu timNhanVienLuongCaoNhat() {
		NhanSu nhanVien = new NhanVien();
		int viTri = -1;
		int maxLength = dsNhanSu.size();
		for(int i = 0; i < maxLength; i++) {
			NhanSu nhanSu = dsNhanSu.get(i);
			if(nhanSu instanceof NhanVien) {
				nhanVien.setMaSo(nhanSu.getMaSo());
				nhanVien.setHoTen(nhanSu.getHoTen());
				nhanVien.setSoDienThoai(nhanSu.getSoDienThoai());
				nhanVien.setSoNgayLamViec(nhanSu.getSoNgayLamViec());
				nhanVien.setLuongMotNgayLam(nhanSu.getLuongMotNgayLam());
				viTri = i;
				break;
			}
		}
		for(int i = viTri +1; i < maxLength; i++) {
			NhanSu nhanSu = dsNhanSu.get(i);
			if(!(nhanSu instanceof NhanVien))
				continue;
			if(nhanSu.tinhLuong() > nhanVien.tinhLuong()) {
				nhanVien.setMaSo(nhanSu.getMaSo());
				nhanVien.setHoTen(nhanSu.getHoTen());
				nhanVien.setSoDienThoai(nhanSu.getSoDienThoai());
				nhanVien.setSoNgayLamViec(nhanSu.getSoNgayLamViec());
				nhanVien.setLuongMotNgayLam(nhanSu.getLuongMotNgayLam());
			}
		}
		return nhanVien;
	}
	public List<NhanVien> dsNhanSuCoLuongCaoNhat(){
		List<NhanVien> dsNhanSuCoLuongCaoNhat = new ArrayList<NhanVien>();
		NhanSu nhanVien = null;
		int viTri = -1;
		int maxLength = dsNhanSu.size();
		for(int i = 0; i < maxLength; i++) {
			NhanSu nhanSu = dsNhanSu.get(i);
			if(nhanSu instanceof NhanVien) {
				nhanVien = nhanSu;
				viTri = i;
				break;
			}
			return null;
		}
		for(int i = viTri +1; i < maxLength; i++) {
			NhanSu nhanSu = dsNhanSu.get(i);
			if(!(nhanSu instanceof NhanVien))
				continue;
			if(nhanSu.tinhLuong() > nhanVien.tinhLuong()) {
				nhanVien = nhanSu;
			}
		}
		for(NhanSu ns: dsNhanSu) {
			if(ns.tinhLuong() == nhanVien.tinhLuong()) {
				dsNhanSuCoLuongCaoNhat.add((NhanVien)ns);
			}
		}
		return dsNhanSuCoLuongCaoNhat;
	}
	public NhanSu timTruongPhongCoNhieuNhanVienNhat() {
		NhanSu truongPhong = null;
		int viTri = 0;
		int maxLength = dsNhanSu.size();
		for(int i = 0; i < maxLength; i++) {
			NhanSu nhanSu = dsNhanSu.get(i);
			if(nhanSu instanceof TruongPhong) {
				truongPhong = nhanSu;
				viTri = i;
				break;	
			}	
		}
		for(int i = viTri+1; i < maxLength; i++) {
			NhanSu nhanSu = dsNhanSu.get(i);
			if(!(nhanSu instanceof TruongPhong))
				continue;
			int maxSoNhanVien = ((TruongPhong)truongPhong).getSoNhanVien();
			int soNhanVien = ((TruongPhong)nhanSu).getSoNhanVien();
			if(soNhanVien > maxSoNhanVien) {
				truongPhong = nhanSu;
			}
		}
		return truongPhong;
	}
	public List<TruongPhong> dsTruongPhongCoNhieuNhanVienNhat(){
		List<TruongPhong> dsTruongPhongCoNhieuNhanVienNhat = new ArrayList<TruongPhong>();
		NhanSu truongPhong = null;
		int viTri = -1;
		int maxLength = dsNhanSu.size();
		for(int i = 0; i < maxLength; i++) {
			NhanSu nhanSu = dsNhanSu.get(i);
			if(nhanSu instanceof TruongPhong) {
				truongPhong = nhanSu;
				viTri = i;
				break;
			}
		}
		for(int i = viTri + 1; i < maxLength; i++) {
			NhanSu nhanSu = dsNhanSu.get(i);
			if(!(nhanSu instanceof TruongPhong))
				continue;
			if(((TruongPhong)nhanSu).getSoNhanVien() > ((TruongPhong)truongPhong).getSoNhanVien()) {
				truongPhong = nhanSu;
			}
		}
		for(int i = viTri; i < maxLength ; i++) {
			NhanSu ns = dsNhanSu.get(i);
			if(!(ns instanceof TruongPhong))
				continue;
			if(((TruongPhong)ns).getSoNhanVien() == ((TruongPhong)truongPhong).getSoNhanVien()) {
				dsTruongPhongCoNhieuNhanVienNhat.add((TruongPhong)ns);
			}
		}
		return dsTruongPhongCoNhieuNhanVienNhat;
	}
	public void sapXepNhanVienTheoTen() {
		Helper helper = new Helper();
		for(int i = 0; i < dsNhanSu.size() -1; i++) {
			for(int j = i+1; j < dsNhanSu.size(); j++) {
				if(helper.getTen(dsNhanSu.get(i).getHoTen()).compareToIgnoreCase(helper.getTen(dsNhanSu.get(j).getHoTen())) > 0) {
					NhanSu temp = dsNhanSu.get(i);
					dsNhanSu.set(i, dsNhanSu.get(j));
					dsNhanSu.set(j, temp);
				}
			}
		}
	}
	public void sapXepNhanVienTheoLuongTang() {
		for(int i = 0; i < dsNhanSu.size() -1; i++) {
			for(int j = i+1; j < dsNhanSu.size(); j++) {
				if(dsNhanSu.get(i).tinhLuong() > dsNhanSu.get(j).tinhLuong()) {
					NhanSu temp = dsNhanSu.get(i);
					dsNhanSu.set(i, dsNhanSu.get(j));
					dsNhanSu.set(j, temp);
				}
			}
		}
	}
	public NhanSu timGiamDocCoPhanNhieuNhat() {
		NhanSu giamDoc = null;
		int viTri = 0;
		int maxLength = dsNhanSu.size();
		for(int i = 0; i < maxLength; i++) {
			NhanSu nhanSu = dsNhanSu.get(i);
			if(nhanSu instanceof GiamDoc) {
				giamDoc = nhanSu;
				viTri = i;
				break;
			}
		}
		for(int i = viTri+1; i < maxLength; i++) {
			NhanSu nhanSu = dsNhanSu.get(i);
			if(!(nhanSu instanceof GiamDoc)) {
				continue;
			}
			float maxCoPhan = ((GiamDoc)giamDoc).getCoPhan();
			float coPhan = ((GiamDoc)nhanSu).getCoPhan();
			if(maxCoPhan < coPhan) {
				giamDoc = nhanSu;
			}
		}
		return giamDoc;
	}
	public List<GiamDoc> dsGiamDoc(){
		List<GiamDoc> dsGiamDoc = new ArrayList<GiamDoc>();
		NhanSu giamDoc = null;
		for(NhanSu nhanSu: dsNhanSu) {
			if(!(nhanSu instanceof GiamDoc))
					continue;
			giamDoc = nhanSu;
			dsGiamDoc.add((GiamDoc)giamDoc);
		}
		return dsGiamDoc;
	
	}
}
