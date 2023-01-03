/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.G4.larockola.dao;

import com.G4.larockola.model.Cancion;
import org.springframework.data.repository.CrudRepository;


/**
 *
 * @author PERSONAL
 */
public interface CancionDao extends CrudRepository<Cancion, Integer> {
    
}
