package com.vothienduy;

import java.util.ArrayList;
import java.util.Scanner;

public class Bai_13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n;
		do {
			System.out.println("Nhap vao so phan tu cua mang: ");
			n = scan.nextInt();
		}while(n < 1);
		int[] arr = new int[n];
		int sizeChange = arr.length;
		ArrayList<Integer> listAfterAdd = new ArrayList<Integer>();
		System.out.println("Nhap vao gia tri cac phan tu cua mang: ");
		for(int i = 0; i < arr.length; i++) {
			System.out.print("arr["+i+"] = ");
			arr[i] = scan.nextInt();
			System.out.println();
		}
		System.out.println("Mang da nhap: ");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+"    ");
		}
		System.out.println("\n================================================================================================");
		int choose;
		boolean checkAdded = false;
		boolean checkDeleted = false;
		boolean checkInAdded_one = false;
		boolean checkInAdded_Double = false;
		boolean checkInDeleted_one = false;
		boolean checkInDeleted_Double = false;
		
		do {
			System.out.println("\nMoi ban chon chu nang! \n");
			System.out.println("1. Tinh gia tri trung binh.");
			System.out.println("2. Tim phan tu lon nhat, nho nhat trong mang.");
			System.out.println("3. Tim phan tu am lon nhat, nho nhat trong mang.");
			System.out.println("4. Tim phan tu duong lon nhat, nho nhat trong mang.");
			System.out.println("5. In ra cac phan tu chan, le.");
			System.out.println("6. Them mot phan tu theo index.");
			System.out.println("7. Xoa mot phan tu theo index.");
			System.out.println("0. Ket thuc chuong trinh!");
			choose = scan.nextInt();
			while(choose < 0|| choose > 7) {
				System.out.println("Ban chon sai! Vui long chon lai!");
				choose = scan.nextInt();
			}
			switch(choose) {
			case 1: 
				System.out.println("Gia tri trung binh cua cac phan tu cua mang = "+average(arr));
				break;
			case 2: 
				findMaxMinElement(arr);
				break;
			case 3:
				findMaxMinNegativeElement(arr);
				break;
			case 4:
				findMaxMinPositiveElement(arr);
				break;
			case 5:
				outPutEvenAndOddElement(arr);
				break;
			case 6:
				
				System.out.println("Nhap vi tri can them: ");
				int index = scan.nextInt();
				while(index < 0 || index > sizeChange-1) {
					System.out.println("Vi tri index nam ngoai mang!  Vui long nhap lai! ");
					index = scan.nextInt();
				}
				System.out.println("Nhap vao gia tri can them: ");
				int value = scan.nextInt();
				int[] arrAfterAdd = new int[arr.length+1];
				if(checkInDeleted_one || checkInDeleted_Double) {
					listAfterAdd.add(index, value);
					System.out.println("Mang sau khi them "+value+" vao vi tri "+index+" :");
					for(int i = 0; i < listAfterAdd.size(); i++) {
						System.out.print(listAfterAdd.get(i)+"  ");
						
					}
					System.out.println();
					sizeChange = listAfterAdd.size();
				}
				else {
					if(!checkAdded) {
						arrAfterAdd = addElementwithIndex(arr, index, value);
						System.out.println("Mang sau khi them "+value+" vao vi tri "+index+" :");
						
						for(int i = 0; i < arrAfterAdd.length; i++) {
							System.out.print(arrAfterAdd[i]+"   ");
							listAfterAdd.add(arrAfterAdd[i]);
						}
						
						System.out.println();
						checkAdded = true;
						checkInAdded_one = true;
						sizeChange = listAfterAdd.size();
						
					}
					else {
						if(index >= listAfterAdd.size() -1) {
							listAfterAdd.add(value);
						}
						else
						{
							listAfterAdd.add(index, value);
						}
						System.out.println("Mang sau khi them "+value+" vao vi tri "+index+" :");
						for(int i = 0; i < listAfterAdd.size(); i++) {
							System.out.print(listAfterAdd.get(i)+"  ");
							
						}
						System.out.println();
						sizeChange = listAfterAdd.size();
						checkInAdded_Double = true;
					}
				}
				break;
			case 7:
				System.out.println("Nhap vi tri can xoa: ");
				int index1 = scan.nextInt();
				while(index1 < 0 || index1 > sizeChange-1) {
					System.out.println("Vi tri index nam ngoai mang!  Vui long nhap lai! ");
					index1 = scan.nextInt();
				}
				if(checkInAdded_one || checkInAdded_Double) {
					listAfterAdd.remove(index1);
					System.out.println("Mang sau khi xoa phan thu tai vi tri "+index1+": ");
					for(int i = 0; i < listAfterAdd.size(); i++) {
						System.out.print(listAfterAdd.get(i)+"  ");
					}
					System.out.println();
					sizeChange = listAfterAdd.size();
				}
				else 
					{
						if(!checkDeleted) {
							int[] arrAfterDelete = deleteElementwithIndex(arr, index1);
							System.out.println("Mang sau khi xoa phan thu tai vi tri "+index1+": ");
							for(int i = 0; i < arrAfterDelete.length; i++) {
								System.out.print(arrAfterDelete[i]+"   ");
								listAfterAdd.add(arrAfterDelete[i]);
							}
							System.out.println();
							checkDeleted = true;	
						}
						else {
							listAfterAdd.remove(index1);
							System.out.println("Mang sau khi xoa phan thu tai vi tri "+index1+": ");
							for(int i = 0; i < listAfterAdd.size(); i++) {
								System.out.print(listAfterAdd.get(i)+"  ");
							}
							System.out.println();
							sizeChange = listAfterAdd.size();
							checkInDeleted_one = true;
							checkInDeleted_Double = true;
					}
	
				}
				break;
				
			}
				
		}while(choose != 0);
		scan.close();
	}
	
	public static float average(int[] a) {
		int sum = 0;
		float avg = 0;
		for(int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		avg = ((float)sum/a.length);
		return avg;
	}
	
	public static void findMaxMinElement(int[] a) {
		int max = a[0], min = a[0];
		for(int i = 1; i < a.length; i++) {
			if(a[i] > max) {
				max = a[i];
			}
			if(a[i] < min) {
				min = a[i];
			}
		}
		System.out.println("Gia tri lon nhat: "+max+"\nGia tri nho nhat: "+min);
	}
	public static void findMaxMinNegativeElement(int[] a) {
		int max = - (Integer.MAX_VALUE);
		int min = 0;
		
		for(int i = 0; i < a.length; i++) {
			if(a[i] < 0) {
				if(a[i] > max) {
					max = a[i];
				}
				if(a[i] < min) {
					min = a[i];
				}
			}
		}
		if(min == 0) {
			System.out.println("Khong co phan tu am trong mang!");
			return;
		}
		else if(max == min) {
			System.out.println("Chi co mot phan tu am trong mang la: "+min);
		}
		else {
			System.out.println("So am lon nhat = "+max+"\nSo am nho nhat = "+min);
		}
	}
	
	public static void findMaxMinPositiveElement(int[] a) {
		int max = 0;
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i < a.length; i++) {
			if(a[i] > 0) {
				if(a[i] > max) {
					max = a[i];
				}
				if(a[i] < min) {
					min = a[i];
				}
			}
		}
		if(max == 0) {
			System.out.println("Khong co phan tu duong trong mang!");
			return;
		}
		else if(max == min) {
			System.out.println("Chi co mot phan tu duong trong mang la: "+min);
		}
		else {
			System.out.println("So duong lon nhat = "+max+"\nSo duong nho nhat = "+min);
		}
	}
	
	public static void outPutEvenAndOddElement(int[] a) {
		int[] evenArr = new int[a.length];
		int[] oddArr = new int[a.length];
		int lenEven = 0;
		int lenOdd = 0;
		for(int i = 0; i < a.length; i++) {
			if(a[i] % 2 == 0) {
				evenArr[lenEven] = a[i];
				lenEven++;
			}
			else {
				oddArr[lenOdd] = a[i];
				lenOdd++;
			}
		}
		if(lenEven == 0) {
			System.out.println("Mang khong co phan tu chan!");
		}
		else {
			System.out.println("Cac phan tu chan trong mang:");
			for(int i = 0; i < lenEven; i++) {
				System.out.print(evenArr[i]+"   ");
			}
			System.out.println();
		}
		if(lenOdd == 0) {
			System.out.println("Mang khong co phan tu le!");
		}
		else {
			System.out.println("Cac phan tu le trong mang:");
			for(int i = 0; i < lenOdd; i++) {
				System.out.print(oddArr[i]+"   ");
			}
			System.out.println();
		}
	}
	
	public static int[] addElementwithIndex(int[] a, int index, int value) {
		
//		if(index == 0) {
//			for(int i = temp.length-1; i > 0; i--) {
//				temp[i] = a[i - 1];
//			}
//			temp[0] = value;
//		}
//		else if(index == a.length -1) {
//			for(int i = 0; i < a.length; i++) {
//				temp[i] = a[i];
//			}
//			temp[temp.length-1] = value;
//		}
//		else {
//			for(int i = temp.length-1; i > index; i--) {
//				temp[i] = a[i-1];
//			}
//			temp[index] = value;
//			for(int i = 0; i < index; i++) {
//				temp[i] = a[i];
//			}
//		}
		
		int[] temp = new int[a.length +1];
		for(int i = 0; i <= a.length; i++) {
			if(index == i) {
				temp[i] = value;
			}
			else if(index > i) {
				temp[i] = a[i];
			}
			else {
				temp[i] = a[i-1];
			}
		}
		return temp;
	}
	
	public static int[] deleteElementwithIndex(int[] a, int index) {
		int[] temp = new int[a.length -1];
		for(int i = 0; i < a.length -1; i++) {
			if(index == i || index < i) {
				temp[i] = a[i+1];
			}
			else if(index > i) {
				temp[i] = a[i];
			}
		}
		return temp;
	}
	
}
