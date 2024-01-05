/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;
import Model.Vol;
import Model.Escales;
/**
 *
 * @author wiemz
 */
public class EscalesVols {
    private int id;
    private Vol vol;
    private Escales escale;

    public EscalesVols( Vol vol, Escales escale) {
        this.vol = vol;
        this.escale = escale;
    }
    
    public int getId() {
        return id;
    }

    public Vol getVol() {
        return vol;
    }

    public void setVol(Vol vol) {
        this.vol = vol;
    }

    public Escales getEscale() {
        return escale;
    }

    public void setEscale(Escales escale) {
        this.escale = escale;
    }
    
    
}
