package Hello;

//import java.io.FileInputStream;
import java.util.ArrayList;
//import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class Main {
	public static List<SanPham> sp = new ArrayList<>();

	public static void themSanPham(List<SanPham> sp) {
		Scanner sc = new Scanner(System.in);
		System.out.print("(?) Nhập số sản phẩm muốn thêm: ");
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++) {
			System.out.print("(?) Nhập mã sản phẩm: ");
			String maSP = sc.nextLine();
			System.out.print("(?) Nhập tên sản phẩm: ");
			String name = sc.nextLine();
			System.out.print("(?) Nhập số lượng sản phẩm: ");
			int soLuong = Integer.parseInt(sc.nextLine());
			System.out.print("(?) Nhập giá của sản phẩm: ");
			double gia = Double.parseDouble(sc.nextLine());

			SanPham a = new SanPham(maSP, name, soLuong, gia);
			sp.add(a);

		}
	}

	public static void hienThiSP(List<SanPham> sp) {
		if (sp == null || sp.isEmpty()) {
			System.out.println("(!) Chưa có sản phẩm. Vui lòng nhập sản phẩm.");
			System.out.println("");
		} else {
			System.out.println("");
			System.out.println("+--------------- Danh Sách Sản Phẩm --------------+ ");
			System.out.printf("|%s|%-20s|%-10s|%-10s|\n", " Mã SP", " Tên sản phẩm", " Giá", " Số lượng");
			System.out.printf("+------+--------------------+----------+----------+\n");
			for (SanPham sanPham : sp) {
				System.out.printf("|%-6s|%-20s|%-10s|%10s|\n", sanPham.maSP, sanPham.name, sanPham.gia,
						sanPham.soLuong);
			}
			System.out.printf("+------+--------------------+----------+----------+\n");
			System.out.println("");
		}
	}

	public static void xoaSP(List<SanPham> sp) {
		Scanner sc = new Scanner(System.in);
		if (sp == null || sp.isEmpty()) {
			System.out.println("(!) Chưa có sản phẩm. Vui lòng nhập sản phẩm.");
			System.out.println("");
		} else {
			System.out.print("(?) Nhập mã sản phẩm cần xóa: ");
			String id = sc.nextLine();

			List<SanPham> spPhu = new ArrayList<>();
			boolean check = false;
			for (SanPham sanPham : sp) {
				if (sanPham.maSP.equals(id)) {
					spPhu.add(sanPham);
					check = true;
				}
			}

			if (!check) {
				System.out.println("(!) Sản phẩm mã '" + id + "' không tồn tại.");
				System.out.println("");
			} else {
				sp.removeAll(spPhu);
				System.out.println("(!) Xóa sản phẩm thành công.");
				System.out.println("");
			}
		}
	}

	public static void suaSP(List<SanPham> sp) {
		Scanner sc = new Scanner(System.in);

		if (sp == null || sp.isEmpty()) {
			System.out.println("(!) Chưa có sản phẩm. Vui lòng nhập sản phẩm.");
			System.out.println("");
		} else {
			System.out.print("(?) Nhập mã của sản phẩm cần chỉnh sửa: ");
			String id = sc.nextLine();

			boolean check = false;
			for (SanPham sanPham : sp) {
				if (sanPham.maSP.equals(id)) {
					System.out.print("(?) Nhập mã sản phẩm: ");
					sanPham.maSP = sc.nextLine();
					System.out.print("(?) Nhập tên sản phẩm: ");
					sanPham.name = sc.nextLine();
					System.out.print("(?) Nhập số lượng sản phẩm: ");
					sanPham.soLuong = Integer.parseInt(sc.nextLine());
					System.out.print("(?) Nhập giá của sản phẩm: ");
					sanPham.gia = Double.parseDouble(sc.nextLine());

					check = true;
				}
			}
			if (!check) {
				System.out.println("(!) Sản phẩm mã '" + id + "' không tồn tại.");
				System.out.println("");
			} else {
				System.out.println("(!) Sửa sản phẩm thành công.");
				System.out.println("");
				hienThiSP(sp);
			}
		}
	}

	public static void timKiem(List<SanPham> sp) {
		Scanner sc = new Scanner(System.in);

		if (sp == null || sp.isEmpty()) {
			System.out.println("(!) Chưa có sản phẩm. Vui lòng nhập sản phẩm.");
			System.out.println("");
		} else {
			System.out.println("(?) Nhập mã sản phẩm cần tìm: ");
			String id = sc.nextLine();

			boolean check = false;

			for (SanPham sanPham : sp) {
				if (sanPham.maSP.equals(id)) {
					check = true;
				}
			}
			if (check == false) {
				System.out.println("(!) Sản phẩm mã '" + id + "' không tồn tại.");
				System.out.println("");
			} else {
				System.out.println("");
				System.out.println("+--------------- Danh Sách Sản Phẩm --------------+ ");
				System.out.printf("|%s|%-20s|%-10s|%-10s|\n", " Mã SP", " Tên sản phẩm", " Giá", " Số lượng");
				System.out.printf("+------+--------------------+----------+----------+\n");
				for (SanPham sanPham : sp) {
					if (sanPham.maSP.equals(id)) {
						System.out.printf("|%-6s|%-20s|%-10s|%10s|\n", sanPham.maSP, sanPham.name, sanPham.gia,
								sanPham.soLuong);
					}
				}
				System.out.printf("+------+--------------------+----------+----------+\n");
				System.out.println("");
			}
		}
	}

	public static void sapXepSP(List<SanPham> sp) {
		if (sp == null || sp.isEmpty()) {
			System.out.println("(!) Chưa có sản phẩm. Vui lòng nhập sản phẩm.");
			System.out.println("");
		} else {
			int n = sp.size();
			for (int i = 0; i < n - 1; i++) {
				for (int j = 0; j < n - i - 1; j++) {
					if (sp.get(j).getGia() > sp.get(j + 1).getGia()) {
						SanPham temp = sp.get(j);
						sp.set(j, sp.get(j + 1));
						sp.set(j + 1, temp);
					}
				}
			}
			hienThiSP(sp);
		}
	}

	public static void nhapTuFileExcel(List<SanPham> sp) {
		Scanner sc = new Scanner(System.in);
		System.out.print("(?) Nhập đường dẫn tới file Excel: ");
		String excelFilePath = sc.nextLine();

		try {
			FileInputStream fis = new FileInputStream(new File(excelFilePath));
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);

			for (Row row : sheet) {
				if (row.getRowNum() == 0) {
					// Skip header row
					continue;
				}
				String maSP = row.getCell(0).getStringCellValue();
				String name = row.getCell(1).getStringCellValue();
				int soLuong = (int) row.getCell(2).getNumericCellValue();
				double gia = row.getCell(3).getNumericCellValue();

				SanPham product = new SanPham(maSP, name, soLuong, gia);
				sp.add(product);
			}

			workbook.close();
			fis.close();
			System.out.println("Danh sách sản phẩm đã được nhập từ file Excel thành công.");
			System.out.println("");
		} catch (IOException e) {
			System.out.println("Đường dẫn hoặc định dạng file không hợp lệ. Vui lòng kiểm tra lại.");
			System.out.println("");
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		boolean thoatVongLap = true;

		while (thoatVongLap) {
			System.out.println("+------------- CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM -------------+");
			System.out.println("|1. Thêm mặt hàng mới                                     |");
			System.out.println("|2. Hiển thị danh sách sản phẩm                           |");
			System.out.println("|3. Xóa một sản phẩm                                	  |");
			System.out.println("|4. Chỉnh sửa sản phẩm                                    |");
			System.out.println("|5. Tìm kiếm sản phẩm                                     |");
			System.out.println("|6. Sắp xếp lại danh sách sản phẩm                        |");
			System.out.println("|7. Nhập dữ liệu từ file excel                            |");
			System.out.println("|8. Xuất dữ liệu ra file excel                            |");
			System.out.println("|0. Thoát chương trình                                    |");
			System.out.println("+---------------------------------------------------------+");
			System.out.print("(?) Mời chọn chức năng: ");
			int chon = sc.nextInt();

			switch (chon) {
			case 1:
				themSanPham(sp);
				break;
			case 2:
				hienThiSP(sp);
				break;
			case 3:
				xoaSP(sp);
				break;
			case 4:
				suaSP(sp);
				break;
			case 5:
				timKiem(sp);
				break;
			case 6:
				sapXepSP(sp);
				break;
			case 0:
				thoatVongLap = false;
				break;
			default:
				System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập số từ 0 đến 6!");
				System.out.println("");
			}
		}
	}

}
