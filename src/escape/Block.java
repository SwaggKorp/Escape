/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escape;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author arnaud
 */
public class Block extends JComponent {
    private int length;
    private boolean alive = true;
    private Color aliveColor;
    private Color deadColor;
    
    public Block(int length) {
        super();
        
        this.length = length;
        this.setSize(length, length);
        
        this.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if(evt.getButton()==java.awt.event.MouseEvent.BUTTON1)
                    onClick();
            }
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                onClick();
            }
        });
        aliveColor = new Color(137,220,115);
        deadColor = new Color(136,102,57);
        
        repaint();
    }
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        g.drawRect(0, 0, length, length);
        if(alive)
            g.setColor(aliveColor);
        else 
            g.setColor(deadColor);
       
        g.fillRect(0, 0, length, length);
    }
    public void setAlive(boolean alive) {
        this.alive = alive;
        repaint();
    }
    public boolean alive() {
        return alive;
    }
    private void onClick() {
        alive = !alive;
        repaint();
    }
}
