package app.services;

import app.obj.PackageType;
import app.rep.PackageTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PackageTypeService {

    @Autowired
    private PackageTypeRepository repository;

    public List<PackageType> listAll() {
        return repository.findAll();
    }

    public void save(PackageType o) {
        repository.save(o);
    }

    public PackageType get(long id) {
        return repository.findById(id).get();
    }

    public void delete(long id) {
        repository.deleteById(id);
    }
}
