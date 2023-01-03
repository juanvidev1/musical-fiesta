/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.G4.larockola.controller;

import com.G4.larockola.model.Artista;
import com.G4.larockola.service.ArtistaService;
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
@RequestMapping("/artistas")
public class ArtistaController {
    
    @Autowired
    private ArtistaService artistaservice;
    
    @PostMapping(value = "/")
    public ResponseEntity<Artista> agregar(@RequestBody Artista artista) {
        Artista obj = artistaservice.save(artista);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @DeleteMapping(value="/{id}")
    public ResponseEntity<Artista> eliminar(@PathVariable Integer id){
        Artista obj = artistaservice.findById(id);
        if(obj!=null)
            artistaservice.delete(id);
        else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @PutMapping(value="/")
    public ResponseEntity<Artista> editar(@RequestBody Artista artista){
        Artista obj = artistaservice.findById(artista.getIdArtista());
        if(obj!=null)
        {
            obj.setNombreArtista(artista.getNombreArtista());
            artistaservice.save(obj);
        }
    else
        return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
    return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @GetMapping("/list")
    public List<Artista> consultarTodo(){
        return artistaservice.findAll();
    }
    
    @GetMapping("/list/{id}")
    public Artista consultaPorId(@PathVariable Integer id){
        return artistaservice.findById(id);
    }
    
}
