package app.rep.hibernateimpl;

import app.obj.Office;
import org.hibernate.Session;
import org.hibernate.Transaction;
import app.rep.ObjectRepository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class OfficeRepositoryHibernateImpl implements ObjectRepository<Office> {
    private Session session;

    public OfficeRepositoryHibernateImpl(Session session) {
        this.session = session;
    }

    public List<Office> findAll() {
        CriteriaQuery<Office> cq = session.getCriteriaBuilder().createQuery(Office.class);
        Root<Office> rootEntry = cq.from(Office.class);
        CriteriaQuery<Office> all = cq.select(rootEntry);

        TypedQuery<Office> allQuery = session.createQuery(all);
        return allQuery.getResultList();
    }

    public Office getById(int id) {
        return session.get(Office.class, id);
    }

    public void save(Office obj) {
        Transaction tx = session.beginTransaction();
        session.save(obj);
        tx.commit();
    }

    public void delete(Office obj) {
        Transaction tx = session.beginTransaction();
        session.delete(obj);
        tx.commit();
    }
}
