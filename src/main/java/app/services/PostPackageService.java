package app.services;

import app.obj.PostPackage;
import app.rep.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PostPackageService {

    @Autowired
    private PackageRepository repository;

    public List<PostPackage> listAll() {
        return repository.findAll();
    }

    public void save(PostPackage o) {
        repository.save(o);
    }

    public PostPackage get(long id) {
        return repository.findById(id).get();
    }

    public void delete(long id) {
        repository.deleteById(id);
    }
}
