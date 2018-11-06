package isn;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JPanel;
/**
 *
 * @author tboda1
 */
public class Balle extends JPanel {
    
    private int posX = 40;
    int posY = 10;
    int PosYJ1= 40;
    int vitesseYJ1 = 0;
    int PosYJ2= 40;
    int vitesseYJ2 = 0;

    private final String scoreTitre = "Score :       -";
    public int scorePlayer1int = 0;
    public int scorePlayer2int = 0;
    
    public String scoreP1; 
    public String scoreP2;
        
    @Override
    public void paintComponent(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;      

        //Affichage du fond noir
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        //Affichage de la balle
        g.setColor(Color.WHITE);
        g.fillOval(posX, posY, 21, 21);

        //Affichage du score
        g.setFont(new Font("default", Font.BOLD, 16));
        g.drawString(scoreTitre, 200, 15);
        
        
        g.setColor(Color.white);          
        Rectangle a= new Rectangle (45, PosYJ1, 20, 80); // Première raquette
        g2.fill (a);
        g.setColor(Color.white);          
        Rectangle b = new Rectangle (550, PosYJ2, 20, 80); // Deuxième raquette
        g2.fill (b);
        
        scoreP1 = Integer.toString(scorePlayer1int);
        scoreP2 = Integer.toString(scorePlayer2int);
        g.drawString(scoreP1, 265, 15);
        g.drawString(scoreP2, 300, 15);
        
        repaint();
    }
    
  public int getPosX() {
    return posX;
  }

  public void setPosX(int posX) {
    this.posX = posX;
  }

  public int getPosY() {
    return posY;
  }

  public void setPosY(int posY) {
    this.posY = posY;
  }   
    
}
