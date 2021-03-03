/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demokrautur;

/**
 *
 * @author traegerphi26
 */
public class Wraparound {
    private int up;
    private int down;
    private int left;
    private int right;

    /**
     * arraylist (höhe * breite)
     * partei = Platz der Arraylist (1 bis (höhe * breite))
     * breite = breite des Spielfeldes
     * hoehe = Höhe des Spielfeldes
     * 
     * @param hoehe
     * @param breite
     * @param partei 
     */
    public Wraparound(int hoehe, int breite, int partei) {
        
        /**
         * 20
         * 40
         * 60
         * 80
         * 100
         * 120
         * 140
         * 160
         * 180
         * 200
         * ...
         */
        
        if((partei % breite) == 0){
            //20
            if(partei == breite){
                up = breite*hoehe;
                down = partei + breite;
            //400
            }else if(partei == breite*hoehe){
                up = partei - breite;
                down = breite;
            //40-380
            }else{
                up = partei - breite;
                down = partei + breite;
            }
            right = (partei - breite) + 1;
            left = partei - 1;
        }
        
        
        
    }
    
    /**
     * 
     * gibt den Unteren platz an 
     * z.B. 11 ist der unterer nachbar von 1 (10*2)
     * 
     * @return int
     */
    public int getDown() {
        return down;
    }

    /**
     * 
     * gibt den Linken platz an 
     * z.B 11 ist der Linken nachbar von 1 (10*2)
     * 
     * @return int
     */
    public int getLeft() {
        return left;
    }

    /**
     * 
     * gibt den Rechten platz an 
     * z.B 2 ist der rechte nachbar von 1 (10*2)
     * 
     * @return int
     */
    public int getRight() {
        return right;
    }

    /**
     * 
     * gibt den Oberen platz an 
     * z.B 11 ist der oberer nachbar von 1 (10*2)
     * 
     * @return int
     */
    public int getUp() {
        return up;
    }
    
}
