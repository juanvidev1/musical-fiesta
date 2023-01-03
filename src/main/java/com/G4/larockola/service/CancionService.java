/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.G4.larockola.service;

import com.G4.larockola.model.Cancion;
import java.util.List;

/**
 *
 * @author PERSONAL
 */
public interface CancionService {
    
    public Cancion save(Cancion cancion);
    public void delete(Integer id);
    public Cancion findById(Integer id);
    public List<Cancion> findAll();
    
}
