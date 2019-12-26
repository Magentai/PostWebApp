package app.services;

import app.obj.Status;
import app.rep.PackageRepository;
import app.rep.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StatusService {

    @Autowired
    private StatusRepository repository;

    public List<Status> listAll() {
        return repository.findAll();
    }

    public void save(Status o) {
        repository.save(o);
    }

    public Status get(long id) {
        return repository.findById(id).get();
    }

    public void delete(long id) {
        repository.deleteById(id);
    }
}
