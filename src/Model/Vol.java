/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author wiemz
 */
public class Vol {
    private Integer id;
    private Integer numVol;
    private Aeroport id_AeroportDepart;
    private Aeroport id_AeroportArrive;
    private String dateDepart;
    private String dateArrive;
    private Integer heureDepart;
    private Integer heureArrivee;
    private boolean resOpen;
    private Integer nombreEscales;

    public Vol(Integer id, Integer numVol, Aeroport id_AeroportDepart, Aeroport id_AeroportArrive, String dateDepart, String dateArrive, Integer heureDepart, Integer heureArrivee, boolean resOpen, Integer nombreEscales) {
        this.id = id;
        this.numVol = numVol;
        this.id_AeroportDepart = id_AeroportDepart;
        this.id_AeroportArrive = id_AeroportArrive;
        this.dateDepart = dateDepart;
        this.dateArrive = dateArrive;
        this.heureDepart = heureDepart;
        this.heureArrivee = heureArrivee;
        this.resOpen = resOpen;
        this.nombreEscales = nombreEscales;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumVol() {
        return numVol;
    }

    public void setNumVol(Integer numVol) {
        this.numVol = numVol;
    }

    public Aeroport getId_AeroportDepart() {
        return id_AeroportDepart;
    }

    public void setId_AeroportDepart(Aeroport id_AeroportDepart) {
        this.id_AeroportDepart = id_AeroportDepart;
    }

    public Aeroport getId_AeroportArrive() {
        return id_AeroportArrive;
    }

    public void setId_AeroportArrive(Aeroport id_AeroportArrive) {
        this.id_AeroportArrive = id_AeroportArrive;
    }

    public String getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(String dateDepart) {
        this.dateDepart = dateDepart;
    }

    public String getDateArrive() {
        return dateArrive;
    }

    public void setDateArrive(String dateArrive) {
        this.dateArrive = dateArrive;
    }

    public Integer getHeureDepart() {
        return heureDepart;
    }

    public void setHeureDepart(Integer heureDepart) {
        this.heureDepart = heureDepart;
    }

    public Integer getHeureArrivee() {
        return heureArrivee;
    }

    public void setHeureArrivee(Integer heureArrivee) {
        this.heureArrivee = heureArrivee;
    }

    public boolean isResOpen() {
        return resOpen;
    }

    public void setResOpen(Integer nombreEscales) {
        this.nombreEscales = nombreEscales;
    }
    

    public Integer getNombreEscales() {
        return nombreEscales;
    }

    public void setNombreEscales(Integer nombreEscales) {
        this.nombreEscales = nombreEscales;
    }
   
    
}
