package com.belhard.hibernate;

import com.belhard.hibernate.dao.FacultyDao;
import com.belhard.hibernate.dao.StudentDao;
import com.belhard.hibernate.entity.Faculty;
import com.belhard.hibernate.entity.Student;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {

        FacultyDao facultyDao = new FacultyDao();
        StudentDao studentDao = new StudentDao();

        Faculty faculty = new Faculty();
        faculty.setName("FTC");
        facultyDao.saveFaculty(faculty);

        Student ivan = new Student();
        ivan.setFirstName("Ivan");
        ivan.setLastName("Inanov");
        ivan.setReceiptDate(LocalDate.of(2015, 7, 23));
        ivan.setFaculty(faculty);
        studentDao.saveStudent(ivan);

        Student petr = new Student();
        petr.setFirstName("Petr");
        petr.setLastName("Petrov");
        petr.setReceiptDate(LocalDate.of(2015, 7, 27));
        petr.setFaculty(faculty);
        studentDao.saveStudent(petr);

        petr.setReceiptDate(LocalDate.of(2015, 7, 21));
        studentDao.updateStudent(petr);

//        facultyDao.deleteFaculty(1);
    }
}
