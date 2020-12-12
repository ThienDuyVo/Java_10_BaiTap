package com.cybersoft_java10.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cybersoft_java10.controller.Helper;
import com.cybersoft_java10.controller.QuanLyNhanSu;
import com.cybersoft_java10.model.GiamDoc;
import com.cybersoft_java10.model.NhanSu;
import com.cybersoft_java10.model.NhanVien;
import com.cybersoft_java10.model.TruongPhong;

public class CongTy {
	private QuanLyNhanSu quanLyNhanSu;
	private String tenCongTy;
	private String maSoThue;
	private double doanhThuThang;
	
	public CongTy() {
		quanLyNhanSu = new QuanLyNhanSu();
		this.doanhThuThang = 600000;
		taoDummyData();
	}
	
	public void mainFunc(Scanner scan) {
		scan = new Scanner(System.in);
		Helper helper = new Helper();
		boolean tiepTucChay = true;
		int luaChon = 0;
		do {
			boolean check;
			do {
				inMenu();
				
				try {
					luaChon = Integer.parseInt(scan.nextLine());
					check = true;
				} catch (Exception e) {
					check = false;
					System.out.println("Ban nhap sai!");
				}
			}while(!check);
				
			System.out.println();
			switch(luaChon) {
			case 0:
				tiepTucChay = false;
				System.out.println("Dang thoat chuong trinh...");
				break;
				
			case 1:
				nhapThongTin(scan);
				System.out.println();
				break;
			
			case 2:
				quanLyNhanSu.phanBoNhanVienVaoTruongPhong(scan);
				System.out.println();
				break;
				
			case 3:
				System.out.println("Chon loai nhan su:\n\t1. Nhan vien.\n\t2. Truong phong.\n\t3. Giam doc.");
				System.out.println("Lua chon: ");
				switch(Integer.parseInt(scan.nextLine())) {
				case 1:
					NhanVien nhanVien = new NhanVien();
					nhanVien.nhapThongTin(scan);
					if(quanLyNhanSu.them(nhanVien)) {
						System.out.println("Them nhan vien thanh cong!");
					}
					else 
						System.out.println("Them nhan vien that bai!");
					break;
				case 2:
					TruongPhong truongPhong = new TruongPhong();
					truongPhong.nhapThongTin(scan);
					if(quanLyNhanSu.them(truongPhong))
						System.out.println("Them truong phong thanh cong!");
					else
						System.out.println("Them truong phong that bai!");
					break;
				case 3:
					GiamDoc giamDoc = new GiamDoc();
					giamDoc.nhapThongTin(scan);
					if(quanLyNhanSu.them(giamDoc))
						System.out.println("Them giam doc thanh cong!");
					else
						System.out.println("Them giam doc that bai!");
					break;
				default:
					System.out.println("Ban chon sai!");
				};
				System.out.println();
				break;
			case 4:
				System.out.println("Nhap ma so nhan su can xoa:");
				String maSo = scan.nextLine();
				if(!quanLyNhanSu.xoa(maSo))
					System.out.println("Xoa khong thanh cong!");
				System.out.println();
				break;
			case 5:
				quanLyNhanSu.inDanhSachNhanSu();
				System.out.println();
				break;
			case 6:
				System.out.println("Tong luong cua cong ty: "+quanLyNhanSu.tinhTongLuong()+" VND");
				System.out.println();
				break;
			case 7:
				String s = "Nhan vien co luong cao nhat:";
				helper.inLine(s);
//				NhanSu nhanVienLuongCaoNhat = quanLyNhanSu.timNhanVienLuongCaoNhat();
//				nhanVienLuongCaoNhat.xuatThongTin();
				List<NhanVien> dsNhanVienCoLuongCaoNhat = quanLyNhanSu.dsNhanSuCoLuongCaoNhat();
				for(NhanVien nv: dsNhanVienCoLuongCaoNhat) {
					nv.xuatThongTin();
					System.out.println();
				}
				System.out.println();
				break;
			case 8:
				s = "Truong phong co nhieu nhan vien nhat:";
				helper.inLine(s);
//				NhanSu truongPhongNhieuNhanVienNhat = quanLyNhanSu.timTruongPhongCoNhieuNhanVienNhat();
//				truongPhongNhieuNhanVienNhat.xuatThongTin();
				List<TruongPhong> dsTruongPhongCoNhieuNhanVienNhat = quanLyNhanSu.dsTruongPhongCoNhieuNhanVienNhat();
				for(TruongPhong tp: dsTruongPhongCoNhieuNhanVienNhat) {
					tp.xuatThongTin();
					System.out.println();
				}
				
				System.out.println();
				break;
			case 9:
				System.out.println("\nDanh sach nhan su sau khi duoc xap xep theo ten:");
				quanLyNhanSu.sapXepNhanVienTheoTen();
				quanLyNhanSu.inDanhSachNhanSu();
				System.out.println();
				break;
			case 10:
				System.out.println("\nDanh sach nhan su sau khi sap xep theo luong tang dan: ");
				quanLyNhanSu.sapXepNhanVienTheoLuongTang();
				quanLyNhanSu.inDanhSachNhanSu();
				System.out.println();
				break;
			case 11:
				s = "Giam doc co co phan nhieu nhat:";
				helper.inLine(s);
				NhanSu giamDocCoNhieuCoPhanNhat = quanLyNhanSu.timGiamDocCoPhanNhieuNhat();
				((GiamDoc)giamDocCoNhieuCoPhanNhat).xuatThongTin();
				System.out.println();
				break;
			case 12:
				System.out.println("\nTong thu nhap cua tung giam doc:");
				for(GiamDoc giamDoc: quanLyNhanSu.dsGiamDoc()) {
					helper.inLine("Thong Tin:");
					giamDoc.xuatThongTin();
					System.out.print("\nTong thu nhap: "+String.format("%20.2f", tongThuNhapCuaGiamDoc(giamDoc)));
					System.out.println();
				}
				System.out.println();
			case 13:
				xuatThongTinCongTy();
				break;
				default: 
					System.out.println("Ban chon sai!");
					break;
			}
		}while(tiepTucChay);
		
		
		
	}
	public void taoDummyData() {
		quanLyNhanSu.them(new NhanVien("MS01", "Tuấn Tiền Ti", "0909000113", 18, 100, null));
		quanLyNhanSu.them(new NhanVien("MS02", "Nguyen Van Liem", "0909000513", 20, 100, null));
		quanLyNhanSu.them(new NhanVien("MS03", "Tran Tuan Khai", "0909000117", 22, 100, null));
		quanLyNhanSu.them(new NhanVien("MS04", "Pham Duc Hoa", "0909000112", 19, 100, null));
		quanLyNhanSu.them(new NhanVien("MS05", "Pham Kim Dung", "0909004113", 22, 100, null));
		quanLyNhanSu.them(new NhanVien("MS06", "Nguyen Kim Ngan", "0909600113", 21, 100, null));
		quanLyNhanSu.them(new NhanVien("MS07", "Tran Duc Toan", "0909009113", 22, 100, null));
		quanLyNhanSu.them(new TruongPhong("MS08", "Vo Thien Duy", "0909000142", 22, 200, 8));
		quanLyNhanSu.them(new TruongPhong("MS16", "Vo Van Chuong", "0909000122", 22, 200, 8));
		quanLyNhanSu.them(new TruongPhong("MS18", "Quach Thanh Danh", "0909010152", 22, 200, 3));
		quanLyNhanSu.them(new TruongPhong("MS09", "Dinh Tien Dat", "0909000813", 22, 200, 2));
		quanLyNhanSu.them(new GiamDoc("MS010", "Tran Kim Thoa", "0909005213", 22, 300, 20));
	}
	public void inMenu() {
		int spaceNum = 20;
		System.out.println(String.format("%" + spaceNum + "s", "") + "QUẢN LÝ NHÂN SỰ" + String.format("%" + spaceNum + "s", ""));
		System.out.println("Menu:");
		System.out.println("\t1. Nhập thông tin công ty");
		System.out.println("\t2. Phân bổ Nhân viên vào Trưởng phòng");
		System.out.println("\t3. Thêm thông tin một nhân sự");
		System.out.println("\t4. Xóa thông tin một nhân sự");
		System.out.println("\t5. Xuất ra thông tin toàn bộ người trong công ty");
		System.out.println("\t6. Tính và xuất tổng lương cho toàn công ty");
		System.out.println("\t7. Tìm Nhân viên thường có lương cao nhất");
		System.out.println("\t8. Tìm Trưởng Phòng có số lượng nhân viên dưới quyền nhiều nhất");
		System.out.println("\t9. Sắp xếp nhân viên toàn công ty theo thứ tự abc");
		System.out.println("\t10. Sắp xếp nhân viên toàn công ty theo thứ tự lương giảm dần");
		System.out.println("\t11. Tìm Giám Đốc có số lượng cổ phần nhiều nhất");
		System.out.println("\t12. Tính và Xuất tổng THU NHẬP của từng Giám Đốc");
		System.out.println("\t13. Xuất thông tin công ty");
		System.out.println("\t0. Thoát.");
		System.out.print("Lựa chọn: ");
		
	}
	public void nhapThongTin(Scanner scan) {
		System.out.println("THONG TIN CONG TY:");
		System.out.print("Ten cong ty: ");
		this.tenCongTy = scan.nextLine();
		System.out.print("\nMa so thue:");
		this.maSoThue = scan.nextLine();
		System.out.print("\nDoanh thu thang:");
		this.doanhThuThang = Double.parseDouble(scan.nextLine());
		
	}
	public void xuatThongTinCongTy() {
		int num = 72;
		String ttCongTy = "THÔNG TIN CÔNG TY";
		System.out.println();
		System.out.println(String.format("%" + (num*2 - ttCongTy.length())/2 + "s", "") + ttCongTy + String.format("%" + (num*2 - ttCongTy.length())/2 + "s", ""));
		System.out.println("Tên công ty: " + tenCongTy);
		System.out.println("Mã số thuế: " + maSoThue);
		System.out.println("Doanh thu: " + String.format("%20.2f", doanhThuThang));

		System.out.println();
	}
	public double tongThuNhapCuaGiamDoc(GiamDoc giamDoc) {
		double loiNhuanCongTy = doanhThuThang - quanLyNhanSu.tinhTongLuong();
		return (giamDoc.tinhLuong() + (giamDoc.getCoPhan()*loiNhuanCongTy)/100);
	}
	
}
