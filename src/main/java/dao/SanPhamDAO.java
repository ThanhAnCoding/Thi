/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DbContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.SanPham;

/**
 *
 * @author ADMIN
 */
public class SanPhamDAO {

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    public ArrayList<SanPham> getDiscount() {
        ArrayList<SanPham> sp = new ArrayList<>();
        String sql = "select top 6 * from sanpham where khuyenmai='true' order by dongia asc ";
        conn = new DbContext().getConnection();
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                sp.add(new SanPham(rs.getInt(1), rs.getString(2),rs.getDouble(3),rs.getString(4),rs.getInt(5),rs.getBoolean(6)));
            }
        }catch(Exception ex){
            System.out.println("Loi:" + ex.toString());
        }
        return sp;
    }
    
    public ArrayList<SanPham> getByType(int msp){
        ArrayList<SanPham> sp = new ArrayList<>();
        String sql = "select  * from sanpham where maloai=? order by maloai ";       
        conn =new DbContext().getConnection();
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, msp);
            rs = ps.executeQuery();
            while (rs.next()) {
                sp.add(new SanPham(rs.getInt(1), rs.getString(2),rs.getDouble(3),rs.getString(4),rs.getInt(5),rs.getBoolean(6)));
            }
        } catch (Exception ex) {
            System.out.println("Loi:" + ex.toString());
        }
        return sp;
    }
    
    
     public static void main(String[] args) {
         SanPhamDAO cDAO = new SanPhamDAO();
         for(SanPham c: cDAO.getDiscount())
         {
             System.out.println(c);
         }
    }
}


