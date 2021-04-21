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
public final class Wraparound {

    private int up = 0;
    private int down = 0;
    private int left = 0;
    private int right = 0;
    private int hoehe = 0;
    private int breite = 0;
    private int bewohner = 0;

    /**
     * arraylist (höhe * breite) partei = Platz der Arraylist (1 bis (höhe *
     * breite)) breite = breite des Spielfeldes hoehe = Höhe des Spielfeldes
     *
     * @param hoehe
     * @param breite
     * @param bewohner
     */
    public Wraparound(int hoehe, int breite, int bewohner) {
        this.hoehe = hoehe;
        this.breite = breite;
        this.bewohner = bewohner;
        nonWrapCreate();
    }
    
    public Wraparound(int hoehe, int breite) {
        this.hoehe = hoehe;
        this.breite = breite;
    }
    
    public Wraparound(){
    }
    
    public void setBewohner(int bewohner){
        this.bewohner = bewohner;
        nonWrapCreate();
    }

    /**
     *
     * gibt den Unteren platz an z.B. 11 ist der unterer nachbar von 1 (10*2)
     *
     * @return int
     */
    public int getDown() {
        return down;
    }

    /**
     *
     * gibt den Linken platz an z.B 11 ist der Linken nachbar von 1 (10*2)
     *
     * @return int
     */
    public int getLeft() {
        return left;
    }

    /**
     *
     * gibt den Rechten platz an z.B 2 ist der rechte nachbar von 1 (10*2)
     *
     * @return int
     */
    public int getRight() {
        return right;
    }

    /**
     *
     * gibt den Oberen platz an z.B 11 ist der oberer nachbar von 1 (10*2)
     *
     * @return int
     */
    public int getUp() {
        return up;
    }
    
    
    public int getHoehe() {
        return hoehe;
    }

    public int getBreite() {
        return breite;
    }
    
    

    public void create() {
        switch (bewohner % breite) {
            case 0:
                if (bewohner == breite) {
                    up = breite * hoehe;
                    down = bewohner + breite;
                } else if (bewohner == breite * hoehe) {
                    up = bewohner - breite;
                    down = breite;
                } else {
                    up = bewohner - breite;
                    down = bewohner + breite;
                }
                right = (bewohner - breite) + 1;
                left = bewohner - 1;
                break;
            case 1:
                if (bewohner == 1) {
                    up = (breite * (hoehe - 1)) + 1;
                    down = bewohner + breite;
                } else if (bewohner == ((breite * (hoehe - 1)) + 1)) {
                    up = bewohner - breite;
                    down = 1;
                } else {
                    up = bewohner - breite;
                    down = bewohner + breite;
                }
                right = bewohner + 1;
                left = (bewohner + breite) - 1;
                break;
            default:
                if (bewohner < breite) {
                    up = (breite * (hoehe - 1)) + bewohner;
                    down = breite + bewohner;
                } else if ((bewohner < breite * hoehe) && (bewohner > breite * (hoehe - 1))) {
                    up = bewohner - breite;
                    down = bewohner - (breite * (hoehe - 1));
                } else {
                    up = bewohner - breite;
                    down = bewohner + breite;
                }
                right = bewohner + 1;
                left = bewohner - 1;
                break;
        }
    }
    
     public void nonWrapCreate() {
        switch (bewohner % breite) {
            case 0:
                if (bewohner == breite) {
                    up = 0;
                    down = bewohner + breite;
                } else if (bewohner == breite * hoehe) {
                    up = bewohner - breite;
                    down = 0;
                } else {
                    up = bewohner - breite;
                    down = bewohner + breite;
                }
                right = 0;
                left = bewohner - 1;
                break;
            case 1:
                if (bewohner == 1) {
                    up = 0;
                    down = bewohner + breite;
                } else if (bewohner == ((breite * (hoehe - 1)) + 1)) {
                    up = bewohner - breite;
                    down = 0;
                } else {
                    up = bewohner - breite;
                    down = bewohner + breite;
                }
                right = bewohner + 1;
                left = 0;
                break;
            default:
                if (bewohner < breite) {
                    up = 0;
                    down = breite + bewohner;
                } else if ((bewohner < breite * hoehe) && (bewohner > breite * (hoehe - 1))) {
                    up = bewohner - breite;
                    down = 0;
                } else {
                    up = bewohner - breite;
                    down = bewohner + breite;
                }
                right = bewohner + 1;
                left = bewohner - 1;
                break;
        }
    }

}
