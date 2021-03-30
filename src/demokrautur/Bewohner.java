/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demokrautur;

import javax.swing.JPanel;

/**
 *
 * @author Phil
 */
public class Bewohner extends JPanel{
    
    private Partei partei;
    
    public Bewohner(Partei partei) {
        this.partei = partei;
        refech();
    }

    public Partei getPartei() {
        return partei;
    }

    public void setPartei(Partei partei) {
        this.partei = partei;
        refech();
    }

    private void refech(){
        this.setBackground(partei.getFarbe());
    }
    
}
