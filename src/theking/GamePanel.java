/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package theking;

import inputs.KeyboardInputs;
import inputs.MouseInputs;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author jondd
 */
public class GamePanel extends JPanel{
    private MouseInputs mouseInputs;
    private float xDelta = 100,yDelta = 100;
    private BufferedImage img,subImg;
    
    public  GamePanel()
    {
        mouseInputs = new MouseInputs(this);
        addKeyListener(new KeyboardInputs(this));
        importImg();
        setPanelSize();
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
        
        
    }
    
    public void changeXDelta(int value)
    {
        this.xDelta += value;
    }
     public void changeYDelta(int value)
    {
        this.yDelta += value;
    }
     public void setRecPos(int x, int y)
     {
         this.xDelta = x;
         this.yDelta = y;
     }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        subImg = img.getSubimage(1*64, 4*40, 64, 40);
//        g.drawImage(img.getSubimage(0, 0, 64, 40), 0, 0,128,80, null);
            g.drawImage(subImg, (int)xDelta, (int)yDelta,128,80, null);
        
    }

    

    private void setPanelSize() {
        Dimension size = new Dimension(1280,800);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }

    private void importImg() {
        InputStream is = getClass().getResourceAsStream("/res/player_sprites.png");
        try {
            img = ImageIO.read(is);
        } catch (IOException ex) {
            Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
