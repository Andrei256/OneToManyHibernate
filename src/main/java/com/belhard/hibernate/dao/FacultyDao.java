package com.belhard.hibernate.dao;

import com.belhard.hibernate.entity.Faculty;
import com.belhard.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FacultyDao {

    public void saveFaculty(Faculty faculty) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(faculty);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Faculty getFaculty(long id) {
        Transaction transaction = null;
        Faculty faculty = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            faculty = session.get(Faculty.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return faculty;
    }

    public void updateFaculty(Faculty faculty) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(faculty);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteFaculty(long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Faculty faculty = session.get(Faculty.class, id);
            if (faculty != null) {
                session.delete(faculty);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
