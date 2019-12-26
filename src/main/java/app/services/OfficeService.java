package app.services;

import app.obj.Office;
import app.rep.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OfficeService {

    @Autowired
    private OfficeRepository repository;

    public List<Office> listAll() {
        return repository.findAll();
    }

    public void save(Office o) {
        repository.save(o);
    }

    public Office get(long id) {
        return repository.findById(id).get();
    }

    public void delete(long id) {
        repository.deleteById(id);
    }
}
