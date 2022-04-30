package com.timurholding;

import com.timurholding.dao.VeriTabaniJDBCIslemler;
import com.timurholding.dao.VeriTabaniJPAIslemler;
import com.timurholding.model.Ogrenci;
import com.timurholding.model.Students;

import java.util.List;

public class AnaSinif {

    public static void main(String[] args) {
        try {

            VeriTabaniJDBCIslemler vtJdbc = new VeriTabaniJDBCIslemler();

            System.out.println("----------------------");

            //veri tabanindan okuma
            List<Ogrenci> ogrList = vtJdbc.findAllStudents();
            for (Ogrenci ogr : ogrList) {
                System.out.println("Öğrenci: " + ogr.getName() + " - " + ogr.getAge());
            }

            System.out.println("----------------------");

            //veri tabanina ekleme islemi
            Ogrenci ogrYeniKayit = new Ogrenci();
            ogrYeniKayit.setName("Elon Musk");
            ogrYeniKayit.setAge(19);
            ogrYeniKayit.setGender("Kız");

            //vtJdbc.insertOrUpdateStudent(ogrYeniKayit);

            System.out.println("----------------------");

            Ogrenci ogrGuncellenecek = new Ogrenci();
            ogrGuncellenecek.setId(7);
            ogrGuncellenecek.setName("Mahmutocasad");
            ogrGuncellenecek.setAge(13);
            ogrGuncellenecek.setGender("Kız");

            vtJdbc.insertOrUpdateStudent(ogrGuncellenecek);

            System.out.println("----------------------");

            //veri tabanindan okuma
            List<Ogrenci> ogrList2 = vtJdbc.findAllStudents();
            for (Ogrenci ogr : ogrList2) {
                System.out.println("Öğrenci: " + ogr.getId() + " - " + ogr.getName() + " - " + ogr.getAge());
            }

            System.out.println("----------------------");


            //veri tabanindan silme islemi
            vtJdbc.deleteStudent(11);

            System.out.println("----------------------");

            //veri tabanindan okuma
            List<Ogrenci> ogrList3 = vtJdbc.findAllStudents();
            for (Ogrenci ogr : ogrList3) {
                System.out.println("Öğrenci: " + ogr.getId() + " - " + ogr.getName() + " - " + ogr.getAge());
            }

            System.out.println("----------------------");

            System.out.println("--------- JPA --------");
            System.out.println("----------------------");

            VeriTabaniJPAIslemler vtJpa = new VeriTabaniJPAIslemler();

            Students yeniStudent = new Students(null, "Ahmet JPA", 59, "erkek");
            //vtJpa.insertStudent(yeniStudent);

            Students guncellenecekStudent = new Students(13, "JPA Musk", 30, "Erkek");
            //vtJpa.updateStudent(guncellenecekStudent);

            //vtJpa.deleteStudent(18);

            Students findByIdStudent = vtJpa.findById(13);
            System.out.println("Sevgili ogrencimiz: " + findByIdStudent.getId() + findByIdStudent.getName() + findByIdStudent.getAge());

            List<Students> studentList = vtJpa.findAllStudents();
            for (Students students : studentList) {
                System.out.println("Ogrenci: " + students.getId() + " " + students.getName() + " " + students.getAge() + " " + students.getGender());
            }



        } catch (Exception e) {
            System.out.println(e);
        }

    }
}