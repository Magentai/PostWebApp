package app.utils;

import app.obj.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static Session session;

    public HibernateUtil() {
    }

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration().configure();
            configuration.addAnnotatedClass(Office.class);
            configuration.addAnnotatedClass(Package.class);
            configuration.addAnnotatedClass(PackageType.class);
            configuration.addAnnotatedClass(Status.class);
            configuration.addAnnotatedClass(Transfer.class);
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            return configuration.buildSessionFactory(builder.build());
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() { sessionFactory.close(); }

    public static Session startSession(){
        if ((session == null)||(!session.isOpen())) session = getSessionFactory().openSession();
        return session;
    }

    public static void closeSession() {
        session.close();
    }
}
