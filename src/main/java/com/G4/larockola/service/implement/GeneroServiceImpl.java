/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.G4.larockola.service.implement;

import com.G4.larockola.dao.GeneroDao;
import com.G4.larockola.service.GeneroService;
import com.G4.larockola.model.Genero;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PERSONAL
 */

@Service
public class GeneroServiceImpl implements GeneroService {
    
    @Autowired
    private GeneroDao generoDao;
    
    @Override
    @Transactional(readOnly = false)
    public Genero save(Genero genero) {
        
        return generoDao.save(genero);
    }
    
    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id) {
        
        generoDao.deleteById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Genero findById(Integer id) {
        
        return generoDao.findById(id).orElse(null);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Genero> findAll() {
        
        return(List<Genero>) generoDao.findAll();
    }
    
}
