package app.services;

import app.obj.Office;
import app.rep.ObjectRepository;
import app.rep.hibernateimpl.OfficeRepositoryHibernateImpl;
import app.utils.HibernateUtil;

import java.util.List;

public class OfficeService {
    OfficeRepositoryHibernateImpl officeRep;

    public List<Office> findFirstHundred(){
        officeRep = new OfficeRepositoryHibernateImpl(HibernateUtil.startSession());
        List<Office> lo = officeRep.findAll();
        HibernateUtil.closeSession();
        return lo;
    }
}
