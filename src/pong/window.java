package pong;

/**
 *
 * @author tboda1
 */
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class window extends JFrame implements KeyListener
{
    private final ball ball = new ball();
    public boolean stop;

    public window() {
        this.setTitle("Pong !");
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
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
                        ball.vitesseYJ2 = -1;
                        break;
                    case KeyEvent.VK_DOWN:
                        ball.vitesseYJ2 = +1;
                        break;
                    case KeyEvent.VK_Z:
                        ball.vitesseYJ1 = -1;
                        break;
                    case KeyEvent.VK_S:
                        ball.vitesseYJ1 = +1;
                        break;
                }
                ball.repaint();
                repaint();
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
            private void formKeyReleased(KeyEvent evt) {
                int KeyCode = evt.getKeyCode();
                switch (KeyCode) {
                    case KeyEvent.VK_UP:
                        ball.vitesseYJ2 = 0;
                        break;
                    case KeyEvent.VK_DOWN:
                        ball.vitesseYJ2 = 0;
                        break;
                    case KeyEvent.VK_Z:
                        ball.vitesseYJ1 = 0;
                        break;
                    case KeyEvent.VK_S:
                        ball.vitesseYJ1 = 0;
                        break;
                }
                ball.repaint();
                repaint();
            }
        });
        this.setBackground(Color.BLACK);
        this.setContentPane(ball);
        this.setVisible(true);
        go();
    }

    private void go()
    {
        int x = ball.getPosX(), y = ball.getPosY();
        boolean backX = false;
        boolean backY = false;
        while (!stop) {
            if (x > ball.getWidth() - 21) {
                backX = true;
                ball.scorePlayer1int++;
                ball.repaint();
            }
            if (x < 1) {
                ball.scorePlayer2int++;
                backX = false;
                ball.repaint();
            }
            if (y < 1) {
                backY = false;
            }
            if (y > ball.getHeight() - 21) {
                backY = true;
            }
            if(x < 65 && y > ball.PosYJ1 && y < ball.PosYJ1+80) {
                backX = false;
            }
            if(x > 530 && y > ball.PosYJ2 && y < ball.PosYJ2+80) {
                backX=true;
            }
            if (!backX) {
                ball.setPosX(++x);
            } else {
                ball.setPosX(--x);
            }
            if (!backY) {
                ball.setPosY(++y);
            } else {
                ball.setPosY(--y);
            }
            if (ball.scorePlayer1int < 7) {
                stop = false;
            } else { 
                System.out.println("Joueur 1 a gagné !");
                stop = true;
            }
            if (ball.scorePlayer2int < 7) {
                stop = false;
            } else {
                System.out.println("Joueur 2 a gagné !");
                stop = true;
            }
            ball.PosYJ1 += ball.vitesseYJ1;
            ball.PosYJ2 += ball.vitesseYJ2;
            ball.repaint();
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while (stop) {
            ball.setPosX(150);
            ball.setPosY(200);
            ball.repaint(); }
        if (ball.PosYJ1== ball.posY) {
            backX=true;
        }
        if (ball.PosYJ2== ball.posY) {
            backX=true ;
        }
}
    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {

    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
