package org.example.service;

import org.example.model.Smartphone;

public interface SmartphoneService {
    Iterable<Smartphone> findAll();

    Smartphone findById(Integer id);

    Smartphone save(Smartphone smartphone);

    Smartphone remove(Integer id);
}
