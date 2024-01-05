/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author wiemz
 */
public class Escales {
    private int id;
    private Integer heureDepart;
    private Integer heureArrive;

    public Escales(int id, Integer heureDepart, Integer heureArrive) {
        this.id = id;
        this.heureDepart = heureDepart;
        this.heureArrive = heureArrive;
    }
    
    @Override
    public String toString() {
        return "ID: " + id + ", Heure Départ: " + heureDepart + ", Heure Arrivé: " + heureArrive;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getHeureDepart() {
        return heureDepart;
    }

    public void setHeureDepart(Integer heureDepart) {
        this.heureDepart = heureDepart;
    }

    public Integer getHeureArrive() {
        return heureArrive;
    }

    public void setHeureArrive(Integer heureArrive) {
        this.heureArrive = heureArrive;
    }

    
    
}
