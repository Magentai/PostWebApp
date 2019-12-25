package app.rep.hibernateimpl;

import app.obj.Status;
import org.hibernate.Session;
import org.hibernate.Transaction;
import app.rep.ObjectRepository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class StatusRepositoryHibernateImpl implements ObjectRepository<Status> {

    Session session;

    public StatusRepositoryHibernateImpl(Session session) {
        this.session = session;
    }

    public List<Status> findAll(){
        CriteriaQuery<Status> cq = session.getCriteriaBuilder().createQuery(Status.class);
        Root<Status> rootEntry = cq.from(Status.class);
        CriteriaQuery<Status> all = cq.select(rootEntry);

        TypedQuery<Status> allQuery = session.createQuery(all);
        return allQuery.getResultList();
    }

    public Status getById(int id){
        return session.get(Status.class, id);
    }

    public void save(Status obj) {
        Transaction tx = session.beginTransaction();
        session.save(obj);
        tx.commit();
    }

    public void delete(Status obj) {
            Transaction tx = session.beginTransaction();
            session.delete(obj);
            tx.commit();
        }
}
