/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.G4.larockola.service.implement;

import com.G4.larockola.dao.ArtistaDao;
import com.G4.larockola.service.ArtistaService;
import com.G4.larockola.model.Artista;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PERSONAL
 */

@Service
public class ArtistaServiceImpl implements ArtistaService {
    
    @Autowired
    private ArtistaDao artistaDao;
    
    @Override
    @Transactional(readOnly = false)
    public Artista save(Artista artista) {
        
        return artistaDao.save(artista);
    }
    
    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id) {
        
        artistaDao.deleteById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Artista findById(Integer id) {
        
        return artistaDao.findById(id).orElse(null);
    }
    
    @Override
    @Transactional(readOnly = false)
    public List<Artista> findAll() {
        
        return (List<Artista>) artistaDao.findAll();
    }
    
}
