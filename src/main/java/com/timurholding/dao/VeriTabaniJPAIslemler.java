package com.timurholding.dao;

import com.timurholding.model.Ogrenci;
import com.timurholding.model.Students;

import javax.persistence.*;
import java.sql.SQLException;
import java.util.List;

public class VeriTabaniJPAIslemler implements VeriTabaniIslemler2 {


    @Override
    public Students findById(int id) throws SQLException {
        try {

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("ozaninayarlari");
            EntityManager em = emf.createEntityManager();

            Students student = em.find(Students.class, id); //select * from Students where id = 7

            em.close();
            emf.close();
            return student;

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<Students> findAllStudents() throws SQLException {
        try {

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("ozaninayarlari");
            EntityManager em = emf.createEntityManager();

            Query query = em.createQuery("SELECT a FROM students a", Students.class);
            List<Students> studentList = query.getResultList();

            em.close();
            emf.close();
            return studentList;

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public void insertStudent(Students student) throws SQLException {
        try {

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("ozaninayarlari");
            EntityManager em = emf.createEntityManager();

            em.getTransaction().begin();
            em.persist(student); //insert icin
            em.getTransaction().commit();

            em.close();
            emf.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void updateStudent(Students student) throws SQLException {
        try {

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("ozaninayarlari");
            EntityManager em = emf.createEntityManager();

            em.getTransaction().begin();
            em.merge(student); //update icin
            em.getTransaction().commit();

            em.close();
            emf.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Override
    public void deleteStudent(int id) throws SQLException {
        try {

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("ozaninayarlari");
            EntityManager em = emf.createEntityManager();

            Students student = em.getReference(Students.class, id); //id si ile veri tabaninda bulduk

            em.getTransaction().begin();
            em.remove(student); //delete icin
            em.getTransaction().commit();

            em.close();
            emf.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}