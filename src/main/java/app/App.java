package app;

import app.obj.Office;
import app.rep.hibernateimpl.OfficeRepositoryHibernateImpl;
import app.utils.HibernateUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    static OfficeRepositoryHibernateImpl officeRep;

    public static void main(String[] args) {
        HibernateUtil hu = new HibernateUtil();
        for (Office o: officeRep.findAll()) {
            System.out.println(o.toString());
        }
       // SpringApplication.run(App.class, args);
    }
}