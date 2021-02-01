package com.example.learnjava.model;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
@Service
@Transactional
public class BarangService {
 
    @Autowired
    private ProductRepository repo;
     
    public List<Barang> listAll() {
        return repo.findAll();
    }
     
    public void save(Barang product) {
        repo.save(product);
    }
     
    public Barang get(int id) {
        return repo.findById(id).get();
    }
     
    public void delete(int id) {
        repo.deleteById(id);
    }
}