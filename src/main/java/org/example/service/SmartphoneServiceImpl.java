package org.example.service;

import org.example.model.Smartphone;
import org.example.repository.SmartphoneRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class SmartphoneServiceImpl implements SmartphoneService {

    @Autowired
    private SmartphoneRepository smartphoneRepository;

    @Override
    public Iterable<Smartphone> findAll() {
        return smartphoneRepository.findAll();
    }

    @Override
    public Smartphone findById(Integer id) {
        Smartphone smartphone = smartphoneRepository.findOne(id);
        if (smartphone == null) {
            return null;
        }
        return smartphone;
    }

    @Override
    public Smartphone save(Smartphone smartphone) {
        return smartphoneRepository.save(smartphone);
    }

    @Override
    public Smartphone remove(Integer id) {
        Smartphone smartphone = smartphoneRepository.findOne(id);
        smartphoneRepository.delete(id);
        return smartphone;
    }
}
