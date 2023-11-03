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
import static utilz.Constants.PlayerConstants.*;
import static utilz.Constants.Directions.*;

/**
 *
 * @author jondd
 */
public class GamePanel extends JPanel{
    private MouseInputs mouseInputs;
    private float xDelta = 100,yDelta = 100;
    private BufferedImage img;
    private BufferedImage[][] animations;
    private int animationIndex,AnimationTick,animationSpeed = 15;
    private int playerAction = IDLE;
    private int playerDir = -1;
    private boolean moving = false;
    
    public  GamePanel()
    {
        mouseInputs = new MouseInputs(this);
        
        importImg();
        LoadAnimation();
        setPanelSize();
        
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
        
        
    }
    
    
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
//        subImg = img.getSubimage(1*64, 4*40, 64, 40);
//        g.drawImage(img.getSubimage(0, 0, 64, 40), 0, 0,128,80, null);
            
            updateAnimationTick();
            setAnimation();
            updatePos();
            g.drawImage(animations[playerAction][animationIndex], (int)xDelta, (int)yDelta,128,80, null);
        
    }

    public void setDirection(int direction)
    {
        this.playerDir = direction;
        moving = true;
    }
    public void setMoving(boolean moving)
    {
        this.moving = moving;
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

    private void LoadAnimation() {
        animations = new BufferedImage[7][8];
        for(int i = 0; i < animations.length;i++)
        {
            for(int j = 0; j <animations[i].length;j++)
            {
                animations[i][j] = img.getSubimage(j * 64, i * 40, 64, 40);
            }
        }
    }

    private void updateAnimationTick() {
        AnimationTick++;
        if(AnimationTick >= animationSpeed)
        {
            AnimationTick = 0;
            animationIndex++;
            if(animationIndex >= GetSpriteAmout(playerAction))
            {
                animationIndex = 0;
            }
        }
        
    }

    private void setAnimation() {
        if(moving)
            playerAction = RUNNING;
        else
            playerAction = IDLE;
    }

    private void updatePos() {
        if (moving) {
            switch (playerDir) {
                case LEFT:
                    xDelta -=5;
                    break;
                case UP:
                    yDelta -=5;
                    break;
                case RIGHT:
                    xDelta +=5;
                    break;
                case DOWN:
                    yDelta +=5;
                    break;    
                default:
                    throw new AssertionError();
            }
        }
    }
}
