package isn;

/**
 *
 * @author tboda1
 */
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Fenetre extends JFrame implements KeyListener {

    private final Balle balle = new Balle();

    public boolean stop;

    public Fenetre() {

        // Paramètres de la fenètre Windows
        this.setTitle("Pong ! (G2)");
        this.setSize(600, 600);
        this.setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }

            private void formKeyPressed(KeyEvent evt) {

                int KeyCode = evt.getKeyCode();
                switch (KeyCode) {

                    case KeyEvent.VK_SPACE:
                        stop = false;
                        repaint();
                        break;

                    case KeyEvent.VK_UP:
                        balle.vitesseYJ2 = -1;
                        break;

                    case KeyEvent.VK_DOWN:
                        balle.vitesseYJ2 = +1;
                        break;

                    case KeyEvent.VK_Z:
                        balle.vitesseYJ1 = -1;
                        break;

                    case KeyEvent.VK_S:
                        balle.vitesseYJ1 = +1;
                        break;
                }

                balle.repaint();
                repaint();
            }

            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }

            // On utilise à la fois le KeyPressed et le KeyReleased afin de ne pas avoir d'intèrférence entre les deux touches
            private void formKeyReleased(KeyEvent evt) { 
                int KeyCode = evt.getKeyCode();
                switch (KeyCode) {
                    case KeyEvent.VK_UP:
                        balle.vitesseYJ2 = 0;
                        break;

                    case KeyEvent.VK_DOWN:
                        balle.vitesseYJ2 = 0;
                        break;

                    case KeyEvent.VK_Z:
                        balle.vitesseYJ1 = 0;
                        break;

                    case KeyEvent.VK_S:
                        balle.vitesseYJ1 = 0;
                        break;
                }
                balle.repaint();
                repaint();
            }
        });

        this.setBackground(Color.BLACK); //Affichage du background
        this.setContentPane(balle); //Affichage de la balle
        this.setVisible(true); //Affichage de la fenêtre

        go();

    }

    private void go() {

        int x = balle.getPosX(), y = balle.getPosY(); // Les coordonnées de départ de la balle

        boolean backX = false; // Le booléen pour savoir si l'on recule ou non sur l'axe x
        boolean backY = false; // Le booléen pour savoir si l'on recule ou non sur l'axe y

       
        // Boucle pour répeter le programme
        while (!stop) {

            if (x > balle.getWidth() - 21) {
                backX = true; // Si la coordonnée x est supérieure à la taille du Panneau moins la taille du rond, on recule
                balle.scorePlayer1int++;
                balle.repaint();
            }
            
            if (x < 1) {
                balle.scorePlayer2int++; 
                backX = false; // Si la coordonnée x est inférieure à 1, on avance
                balle.repaint();
            }
                        
            // Idem pour l'axe y
            if (y < 1) {
                backY = false;
            }
            if (y > balle.getHeight() - 21) {
                backY = true;
            }
            
            if(x < 65 && y > balle.PosYJ1 && y < balle.PosYJ1+80)//Collision raquette 1
            {
                backX = false;
            }
            
            if(x > 530 && y > balle.PosYJ2 && y < balle.PosYJ2+80)//Collision raquette 2
            {
                backX=true;
            }

            // Déplacement de la balle
            if (!backX) {
                balle.setPosX(++x); // Lorsque qu'on avance on fait x=x+1
            } else {
                balle.setPosX(--x); // Quand on recule on fait x=x-1
            }
            
            // Idem pour l'axe Y
            if (!backY) {
                balle.setPosY(++y);
            } else {
                balle.setPosY(--y);
            }
            
            if (balle.scorePlayer1int < 7) {
                stop = false;
            } else { 
                System.out.println("Joueur 1 a gagné !");
                stop = true;
            }
            
            if (balle.scorePlayer2int < 7) {
                stop = false;
            } else {
                System.out.println("Joueur 2 a gagné !");
                stop = true;
            }
                    
            balle.PosYJ1 += balle.vitesseYJ1;
            balle.PosYJ2 += balle.vitesseYJ2;

            balle.repaint(); // On redessine la balle pour qu'elle s'affiche avec les nouvelles coordonnées

// Pause, pour que la balle ne bouge pas trop vite.
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        while (stop) {

            balle.setPosX(150);
            balle.setPosY(200);

            balle.repaint(); }
            
        if (balle.PosYJ1==balle.posY) {
            backX=true; }
        
        if (balle.PosYJ2==balle.posY) {
            backX=true ;
        
    }

}
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
