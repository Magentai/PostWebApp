package app.services;

import app.obj.Transfer;
import app.rep.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TransferService {

    @Autowired
    private TransferRepository repository;

    public List<Transfer> listAll() {
        return repository.findAll();
    }

    public void save(Transfer o) {
        repository.save(o);
    }

    public Transfer get(long id) {
        return repository.findById(id).get();
    }

    public void delete(long id) {
        repository.deleteById(id);
    }
}
