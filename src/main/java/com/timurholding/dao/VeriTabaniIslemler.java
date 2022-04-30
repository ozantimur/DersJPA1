package com.timurholding.dao;


import com.timurholding.model.Ogrenci;

import java.sql.SQLException;
import java.util.List;

public interface VeriTabaniIslemler {

    List<Ogrenci> findAllStudents() throws SQLException;
    void insertOrUpdateStudent(Ogrenci ogrenci) throws SQLException;
    void deleteStudent(int id) throws SQLException;

}
