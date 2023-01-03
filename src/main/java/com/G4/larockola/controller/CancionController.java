/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.G4.larockola.controller;

import com.G4.larockola.model.Cancion;
import com.G4.larockola.service.CancionService;
import com.G4.larockola.model.Artista;
import com.G4.larockola.service.ArtistaService;
import com.G4.larockola.model.Genero;
import com.G4.larockola.service.GeneroService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PERSONAL
 */

@RestController
@CrossOrigin("*")
@RequestMapping("/canciones")
public class CancionController {
    
    @Autowired
    private CancionService cancionservice;
    
    @PostMapping(value = "/")
    public ResponseEntity<Cancion> agregar(@RequestBody Cancion cancion) {
        
        Cancion obj = cancionservice.save(cancion);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @DeleteMapping(value="/{id}")
    public ResponseEntity<Cancion> eliminar(@PathVariable Integer id) {
        
        Cancion obj = cancionservice.findById(id);
        if(obj != null) {
            cancionservice.delete(id);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        return new ResponseEntity<>(obj, HttpStatus.OK);
        
    }
    
    @PutMapping(value="/")
    public ResponseEntity<Cancion> editar(@RequestBody Cancion cancion) {
        
        Cancion obj = cancionservice.findById(cancion.getIdCancion());
        if(obj != null) {
            obj.setArtista(cancion.getArtista());
            obj.setIdColaborador(cancion.getIdColaborador());
            obj.setGenero(cancion.getGenero());
            obj.setNombreCancion(cancion.getNombreCancion());
            obj.setEnlaceCancion(cancion.getEnlaceCancion());
            cancionservice.save(obj);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        return new ResponseEntity<>(obj, HttpStatus.OK);
        
    }
    
    @GetMapping("/list")
    public List<Cancion> consultarTodo(){
        return cancionservice.findAll();
    }
    
    @GetMapping("/list/{id}")
    public Cancion consultaPorId(@PathVariable Integer id){
        return cancionservice.findById(id);
    }
    
}
