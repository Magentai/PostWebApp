package app.rep.hibernateimpl;

import app.obj.Transfer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import app.rep.ObjectRepository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class TransferRepositoryHibernateImpl implements ObjectRepository<Transfer> {

    Session session;

    public TransferRepositoryHibernateImpl(Session session) {
        this.session = session;
    }

    public List<Transfer> findAll(){
        CriteriaQuery<Transfer> cq = session.getCriteriaBuilder().createQuery(Transfer.class);
        Root<Transfer> rootEntry = cq.from(Transfer.class);
        CriteriaQuery<Transfer> all = cq.select(rootEntry);

        TypedQuery<Transfer> allQuery = session.createQuery(all);
        return allQuery.getResultList();
    }

    public Transfer getById(int id){
        return session.get(Transfer.class, id);
    }

    public void save(Transfer obj) {
        Transaction tx = session.beginTransaction();
        session.save(obj);
        tx.commit();
    }

    public void delete(Transfer obj) {
        Transaction tx = session.beginTransaction();
        session.delete(obj);
        tx.commit();
    }
}
