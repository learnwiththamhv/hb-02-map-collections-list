package xyz.jguru.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import xyz.jguru.hibernate.demo.entity.Student;

public class CreateStudentImagesListDemo {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                                            .addAnnotatedClass(Student.class)
                                            .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();



        try{
            Student student = new Student("John","Smith","john@jguru.xyz");
            student.getImages().add("photo1.jpg");
            student.getImages().add("photo2.jpg");
            student.getImages().add("photo3.jpg");
            student.getImages().add("photo4.jpg");
            student.getImages().add("photo4.jpg");
            student.getImages().add("photo5.jpg");
            student.getImages().add("photo5.jpg");

            session.beginTransaction();
            System.out.printf("Saving student ... ");

            session.persist(student);

            session.getTransaction().commit();
            System.out.println("Done!!");

        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
