/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.G4.larockola.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author PERSONAL
 */

@Entity
@Table(name = "canciones")
public class Cancion implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cancion")
    private Integer idCancion;
    
    @ManyToOne
    @JoinColumn(name = "id_artista")
    private Artista artista;
    
    @ManyToOne
    @JoinColumn(name = "id_genero")
    private Genero genero;
    
    @Column(name = "id_colaborador")
    private Integer idColaborador;
    
    @Column(name = "titulo_cancion")
    private String nombreCancion;
    
    @Column(name = "enlace_cancion")
    private String enlaceCancion;

    public Integer getIdCancion() {
        return idCancion;
    }

    public Artista getArtista() {
        return artista;
    }

    public Integer getIdColaborador() {
        return idColaborador;
    }

    public Genero getGenero() {
        return genero;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public String getEnlaceCancion() {
        return enlaceCancion;
    }

    public void setIdCancion(Integer idCancion) {
        this.idCancion = idCancion;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public void setIdColaborador(Integer idColaborador) {
        this.idColaborador = idColaborador;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public void setEnlaceCancion(String enlaceCancion) {
        this.enlaceCancion = enlaceCancion;
    }
    
    
}
