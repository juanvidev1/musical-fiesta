/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.G4.larockola.controller;

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
@RequestMapping("/generos")
public class GeneroController {
    
    @Autowired
    private GeneroService generoservice;
    
    @PostMapping(value = "/")
    public ResponseEntity<Genero> agregar(@RequestBody Genero genero) {
        
        Genero obj = generoservice.save(genero);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @DeleteMapping(value="/{id}")
    public ResponseEntity<Genero> eliminar(@PathVariable Integer id) {
        
        Genero obj = generoservice.findById(id);
        if(obj != null) {
            generoservice.delete(id);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        return new ResponseEntity<>(obj, HttpStatus.OK);
        
    }
    
    @PutMapping(value="/")
    public ResponseEntity<Genero> editar(@RequestBody Genero genero) {
        
        Genero obj = generoservice.findById(genero.getIdGenero());
        if(obj != null) {
            obj.setNombreGenero(genero.getNombreGenero());
            generoservice.save(obj);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        return new ResponseEntity<>(obj, HttpStatus.OK);
        
    }
    
    @GetMapping("/list")
    public List<Genero> consultarTodo(){
        return generoservice.findAll();
    }
    
    @GetMapping("/list/{id}")
    public Genero consultaPorId(@PathVariable Integer id){
        return generoservice.findById(id);
    }
    
}
