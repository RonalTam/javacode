package Hello;

public class SanPham {
	public String maSP;
	public String name;
	public int soLuong;
	public double gia;
	
	public SanPham(String maSP, String name, int soLuong, double gia) {
		this.maSP = maSP;
		this.name = name;
		this.soLuong = soLuong;
		this.gia = gia;
	}

	public double getGia() {
		return gia;
	}
}
