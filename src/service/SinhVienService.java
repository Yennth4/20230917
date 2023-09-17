package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;
import model.SinhVien;

public class SinhVienService {

    private Connection conn;

    public SinhVienService() {
        try {
            conn = DBContext.getConnection();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public List<SinhVien> getAllSinhVien() {
        List<SinhVien> listSinhVien = new ArrayList<>();
        String query = """
                       SELECT id, ten_sinh_vien, ten_phong_hoc, diem_toan, diem_ly,
                       diem_hoa, (diem_toan + diem_ly + diem_hoa) / 3 FROM SinhVien
                       """;
        try (PreparedStatement ps = conn.prepareStatement(query)) {            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listSinhVien.add(new SinhVien(rs.getString(1),
                        rs.getString(2), rs.getString(3), rs.getDouble(4),
                        rs.getDouble(5), rs.getDouble(6),
                        rs.getDouble(7)));
            }
            
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return listSinhVien;
    }

    public void addSinhVien(SinhVien sinhVien) throws Exception{
        String query = """
                       INSERT INTO SinhVien (ten_sinh_vien, ten_phong_hoc, 
                       diem_toan, diem_ly, diem_hoa)
                       VALUES(?, ?, ?, ?, ?);
                       """;
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, sinhVien.getTen());
            ps.setObject(2, sinhVien.getPhong());
            ps.setObject(3, sinhVien.getDiemToan());
            ps.setObject(4, sinhVien.getDiemLy());
            ps.setObject(5, sinhVien.getDiemHoa());
            ps.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    public void removeSinhVien(String id) throws Exception{
        String query = """
                       DELETE FROM SinhVien WHERE id=?;
                       """;
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    public List<SinhVien> getSinhVienBySearch(Double diemMin, Double diemMax) {
        String query = """
                       SELECT id, ten_sinh_vien, ten_phong_hoc, diem_toan, diem_ly,
                       diem_hoa, (diem_toan + diem_ly + diem_hoa) / 3 FROM SinhVien
                       WHERE (diem_toan + diem_ly + diem_hoa) / 3 >= ?
                       AND (diem_toan + diem_ly + diem_hoa) / 3 <= ?;
                       """;
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            List<SinhVien> listSinhVien = new ArrayList<>();
            ps.setObject(1, diemMin);
            ps.setObject(2, diemMax);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listSinhVien.add(new SinhVien(rs.getString(1),
                        rs.getString(2), rs.getString(3), rs.getDouble(4),
                        rs.getDouble(5), rs.getDouble(6),
                        rs.getDouble(7)));
            }
            return listSinhVien;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }

    public List<SinhVien> sortTheoTen() {
        String query = """
                       SELECT id, ten_sinh_vien, ten_phong_hoc, diem_toan, diem_ly,
                       diem_hoa, (diem_toan + diem_ly + diem_hoa) / 3 FROM SinhVien
                       ORDER BY ten_phong_hoc;
                       """;
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            List<SinhVien> listSinhVien = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listSinhVien.add(new SinhVien(rs.getString(1),
                        rs.getString(2), rs.getString(3), rs.getDouble(4),
                        rs.getDouble(5), rs.getDouble(6),
                        rs.getDouble(7)));
            }
            return listSinhVien;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new SinhVienService().getAllSinhVien());
    }
}
