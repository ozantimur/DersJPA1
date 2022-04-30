package com.timurholding.dao;

import com.timurholding.model.Ogrenci;
import com.timurholding.model.Sabitler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VeriTabaniJDBCIslemler implements VeriTabaniIslemler {

    @Override
    public List<Ogrenci> findAllStudents() throws SQLException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Ogrenci> ogrenciList = new ArrayList<>();

        try {
            connection = DriverManager.getConnection(Sabitler.DB_URL, Sabitler.DB_USER, Sabitler.DB_PASSWORD);
            ps = connection.prepareStatement("select * from education.students");
            rs = ps.executeQuery();

            while (rs.next()) {
                Ogrenci ogr = new Ogrenci();
                ogr.setId(rs.getInt("id"));
                ogr.setName(rs.getString("name"));
                ogr.setAge(rs.getInt("age"));
                ogr.setGender(rs.getString("gender"));

                ogrenciList.add(ogr);
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (connection != null) {
                connection.close();
            }
            return ogrenciList;
        }
    }

    @Override
    public void insertOrUpdateStudent(Ogrenci ogrenci) throws SQLException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            connection = DriverManager.getConnection(Sabitler.DB_URL, Sabitler.DB_USER, Sabitler.DB_PASSWORD);

            if(ogrenci.getId() == null) {
                // yeni kayıt
                ps = connection.prepareStatement("insert into students (name, age, gender) values (?, ?, ?)");
                ps.setString(1, ogrenci.getName());
                ps.setInt(2, ogrenci.getAge());
                ps.setString(3, ogrenci.getGender());
                ps.executeUpdate();
            } else {
                // mevcut kaydı güncelleme
                ps = connection.prepareStatement("UPDATE students SET name = ?, age = ?, gender = ? WHERE (id = ?);");
                ps.setString(1, ogrenci.getName());
                ps.setInt(2, ogrenci.getAge());
                ps.setString(3, ogrenci.getGender());
                ps.setInt(4, ogrenci.getId());
                ps.executeUpdate();
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public void deleteStudent(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            connection = DriverManager.getConnection(Sabitler.DB_URL, Sabitler.DB_USER, Sabitler.DB_PASSWORD);
            ps = connection.prepareStatement("DELETE FROM students WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
//encapsulation interface polymorphism abstraction