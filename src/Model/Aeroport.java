/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author wiemz
 */
public class Aeroport {
    private int id;
    private String nom;
    private String pays;
    
    public Aeroport(int id, String nom, String pays) {
        this.id = id;
        this.nom = nom;
        this.pays = pays;
    }
    
    @Override
    public String toString() {
        return nom;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }
    

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public Aeroport(int id) {
        this.id = id;
    }
    
}
