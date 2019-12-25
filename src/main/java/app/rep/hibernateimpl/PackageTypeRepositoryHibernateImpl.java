package app.rep.hibernateimpl;

import app.obj.PackageType;
import org.hibernate.Session;
import org.hibernate.Transaction;
import app.rep.ObjectRepository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class PackageTypeRepositoryHibernateImpl implements ObjectRepository<PackageType> {

    Session session;

    public PackageTypeRepositoryHibernateImpl(Session session) {
        this.session = session;
    }

    public List<PackageType> findAll(){
        CriteriaQuery<PackageType> cq = session.getCriteriaBuilder().createQuery(PackageType.class);
        Root<PackageType> rootEntry = cq.from(PackageType.class);
        CriteriaQuery<PackageType> all = cq.select(rootEntry);

        TypedQuery<PackageType> allQuery = session.createQuery(all);
        return allQuery.getResultList();
    }

    public PackageType getById(int id){
        return session.get(PackageType.class, id);
    }

    public void save(PackageType obj) {
        Transaction tx = session.beginTransaction();
        session.save(obj);
        tx.commit();
    }

    public void delete(PackageType obj) {
        Transaction tx = session.beginTransaction();
        session.delete(obj);
        tx.commit();
    }
}
