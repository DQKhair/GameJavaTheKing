/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package theking;

import inputs.KeyboardInputs;
import inputs.MouseInputs;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author jondd
 */
public class GamePanel extends JPanel{
    private MouseInputs mouseInputs;
    private int xDelta = 100,yDelta = 100;
    public  GamePanel()
    {
        mouseInputs = new MouseInputs(this);
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }
    
    public void changeXDelta(int value)
    {
        this.xDelta += value;
        repaint();
    }
     public void changeYDelta(int value)
    {
        this.yDelta += value;
        repaint();
    }
     public void setRecPos(int x, int y)
     {
         this.xDelta = x;
         this.yDelta = y;
         repaint();
     }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        g.fillRect(xDelta, yDelta, 200, 50);
    }
}
