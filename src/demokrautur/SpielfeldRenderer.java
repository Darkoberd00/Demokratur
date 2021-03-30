/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demokrautur;

/**
 *
 * @author Phil
 */
import java.util.ArrayList;
import java.util.Random;
import javax.swing.SwingWorker;

public class SpielfeldRenderer extends SwingWorker<Void, Void> {

    private boolean paused = false;

    private ArrayList<Bewohner> spielfeld;
    Wraparound wraparound;
    private Random random = new Random();

    public SpielfeldRenderer(ArrayList<Bewohner> spielfeld, Wraparound wraparound) {
        this.spielfeld = spielfeld;
        this.wraparound = wraparound;
    }

    

    @Override
    protected Void doInBackground() throws Exception {

        while (!isCancelled()) {
            if (!paused) {

                int rngbewohner = random.nextInt((wraparound.getHoehe() * wraparound.getBreite())) + 1;
                wraparound.setBewohner(rngbewohner);
                int randomNachbar = (random.nextInt(4) + 1);
                switch (randomNachbar) {
                    case 1:
                        randomNachbar = wraparound.getUp();
                        break;
                    case 2:
                        randomNachbar = wraparound.getRight();
                        break;
                    case 3:
                        randomNachbar = wraparound.getDown();
                        break;
                    case 4:
                        randomNachbar = wraparound.getLeft();
                        break;
                    default:
                        break;
                }

                // random farbe nachbar
                if (!(spielfeld.get(rngbewohner - 1).getPartei().getName().equals(spielfeld.get(randomNachbar - 1).getPartei().getName()))) {

                    if (random.nextBoolean()) {
                        spielfeld.get(randomNachbar - 1).setPartei(spielfeld.get(rngbewohner - 1).getPartei());
                    }

                }
                
                ausgabe();
                
            }
            
        }

        return null;
    }

    public synchronized void pause() {
        paused = true;
    }

    public synchronized void unpause() {
        paused = false;
    }

    public boolean isPause() {
        return paused;
    }
    
    private void ausgabe() {
        
        for (int i = 0; i < wraparound.getHoehe() * wraparound.getBreite(); i++) {
            spielfeld.get(i).paint(spielfeld.get(i).getGraphics());  
        }
        
    }
}
