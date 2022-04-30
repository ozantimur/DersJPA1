package com.timurholding.dao;

import com.timurholding.model.Ogrenci;
import com.timurholding.model.Students;

import java.sql.SQLException;
import java.util.List;

public interface VeriTabaniIslemler2 {

    Students findById(int id) throws SQLException;
    List<Students> findAllStudents() throws SQLException;
    void insertStudent(Students student) throws SQLException;
    void updateStudent(Students student) throws SQLException;
    void deleteStudent(int id) throws SQLException;

}
