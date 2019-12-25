package app.rep.hibernateimpl;

import app.obj.PostPackage;
import org.hibernate.Session;
import org.hibernate.Transaction;
import app.rep.ObjectRepository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class PackageRepositoryHibernateImpl implements ObjectRepository<PostPackage> {

    Session session;

    public PackageRepositoryHibernateImpl(Session session) {
        this.session = session;
    }

    public List<PostPackage> findAll() {
        CriteriaQuery<PostPackage> cq = session.getCriteriaBuilder().createQuery(PostPackage.class);
        Root<PostPackage> rootEntry = cq.from(PostPackage.class);
        CriteriaQuery<PostPackage> all = cq.select(rootEntry);

        TypedQuery<PostPackage> allQuery = session.createQuery(all);
        return allQuery.getResultList();
    }

    public PostPackage getById(int id) {
        return session.get(PostPackage.class, id);
    }

    public void save(PostPackage obj) {
        Transaction tx = session.beginTransaction();
        session.save(obj);
        tx.commit();
    }

    public void delete(PostPackage obj) {
        Transaction tx = session.beginTransaction();
        session.delete(obj);
        tx.commit();
    }
}
