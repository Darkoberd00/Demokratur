/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demokrautur;

import java.awt.Color;

/**
 *
 * @author Phil
 */
public class Partei {

    
    
    private final String name;
    private final Color farbe;
    
    /**
     * 
     * wenn ueberzeugung <= 0 ist dann ist die wahrscheinlichkeit bei 50%
     * 
     * @param name
     * @param farbe
     */
    public Partei(String name, Color farbe) {
        this.name = name;
        this.farbe = farbe;
    }

    public String getName() {
        return name;
    }
    
    public Color getFarbe(){
        return farbe;
    }
    
}
