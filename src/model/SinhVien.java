package model;

/**
 *
 * @author cuongnguyenba
 */
public class SinhVien {

    private String id;
    private String ten;
    private String phong;
    private Double diemToan;
    private Double diemLy;
    private Double diemHoa;
    private Double diemTB;

    public SinhVien() {
    }

    public SinhVien(String id, String ten, String phong, Double diemToan, Double diemLy, Double diemHoa, Double diemTB) {
        this.id = id;
        this.ten = ten;
        this.phong = phong;
        this.diemToan = diemToan;
        this.diemLy = diemLy;
        this.diemHoa = diemHoa;
        this.diemTB = diemTB;
    }

    public SinhVien(String ten, String phong, Double diemToan, Double diemLy, Double diemHoa) {
        this.ten = ten;
        this.phong = phong;
        this.diemToan = diemToan;
        this.diemLy = diemLy;
        this.diemHoa = diemHoa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getPhong() {
        return phong;
    }

    public void setPhong(String phong) {
        this.phong = phong;
    }

    public Double getDiemToan() {
        return diemToan;
    }

    public void setDiemToan(Double diemToan) {
        this.diemToan = diemToan;
    }

    public Double getDiemLy() {
        return diemLy;
    }

    public void setDiemLy(Double diemLy) {
        this.diemLy = diemLy;
    }

    public Double getDiemHoa() {
        return diemHoa;
    }

    public void setDiemHoa(Double diemHoa) {
        this.diemHoa = diemHoa;
    }

    public Double getDiemTB() {
        return diemTB;
    }

    public void setDiemTB(Double diemTB) {
        this.diemTB = diemTB;
    }

    @Override
    public String toString() {
        return "SinhVien{" + "id=" + id + ", ten=" + ten + ", phong=" + phong + ", diemToan=" + diemToan + ", diemLy=" + diemLy + ", diemHoa=" + diemHoa + ", diemTB=" + diemTB + '}';
    }

}
