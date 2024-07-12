package com.application.rest.persistence.impl;

import com.application.rest.entities.Maker;
import com.application.rest.persistence.IMakerDAO;
import com.application.rest.repository.MakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MakerDAOImpl implements IMakerDAO {

    @Autowired
    private MakerRepository makerRepository;

    @Override
    public List<Maker> findAll() {
        return (List<Maker>) this.makerRepository.findAll();
    }

    @Override
    public Optional<Maker> findById(Long id) {
        return this.makerRepository.findById(id);
    }

    @Override
    public void save(Maker maker) {
        this.makerRepository.save(maker);
    }

    @Override
    public void deleteById(Long id) {
        this.makerRepository.deleteById(id);
    }
}
