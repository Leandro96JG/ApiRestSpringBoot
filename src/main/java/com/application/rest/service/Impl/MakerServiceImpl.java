package com.application.rest.service.Impl;

import com.application.rest.entities.Maker;
import com.application.rest.persistence.IMakerDAO;
import com.application.rest.service.IMakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MakerServiceImpl implements IMakerService {

    @Autowired
    private IMakerDAO makerDAO;

    @Override
    public List<Maker> findAll() {
        return this.makerDAO.findAll();
    }

    @Override
    public Optional<Maker> findById(Long id) {
        return this.makerDAO.findById(id);
    }

    @Override
    public void save(Maker maker) {
        this.makerDAO.save(maker);
    }

    @Override
    public void deleteById(Long id) {
        this.makerDAO.deleteById(id);
    }
}
