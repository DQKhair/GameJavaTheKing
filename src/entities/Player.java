/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import theking.GamePanel;
import utilz.Constants;
import static utilz.Constants.Directions.DOWN;
import static utilz.Constants.Directions.LEFT;
import static utilz.Constants.Directions.RIGHT;
import static utilz.Constants.Directions.UP;
import static utilz.Constants.PlayerConstants.GetSpriteAmout;
import static utilz.Constants.PlayerConstants.*;
import utilz.LoadSave;

/**
 *
 * @author jondd
 */
public class Player extends Entity{
    private BufferedImage[][] animations;
    private int animationIndex,AnimationTick,animationSpeed = 15;
    private int playerAction = IDLE;
    private boolean moving = false,attacking = false;
    private boolean up,right,down,left;
    private float playerSpeed = 2.0f;
    
    public Player(float x, float y,int width,int height) {
        super(x, y,width,height);
        LoadAnimation();
        
    }
    
    public void update()
    {
        updatePos();
        updateAnimationTick();
        setAnimation();
            
    }
    
    public void render(Graphics g)
    {
        g.drawImage(animations[playerAction][animationIndex], (int)x, (int)y,128,80, null);
    }
    
    private void LoadAnimation() {
        
            BufferedImage img = LoadSave.GetSpriteAtlas(LoadSave.PLAYER_ATLAS);
             
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
                attacking = false;
            }
        }
        
    }

    private void setAnimation() {
        int startAnimation = playerAction;
        if(moving)
            playerAction = RUNNING;
        else
            playerAction = IDLE;
        
        if(attacking)
        {
            playerAction = ATTACK_1;
        }
        
        if(startAnimation != playerAction)
        {
            resetAnimationTick();
        }
    }

    private void updatePos() {
        
        moving = false;
        
        if(left && !right)
        {
            x -= playerSpeed;
            moving = true;
        }else if(right && !left)
        {
            x += playerSpeed;
            moving = true;
        }
        
        if(up && !down)
        {
            y -= playerSpeed;
            moving = true;
        }else if(down && !up)
        {
            y += playerSpeed;
            moving = true;
        }
    }
    
    public void resetDirBoolean()
    {
        left = false;
        right = false;
        up = false;
        down = false;
    }
    
    public void setAttacking(boolean attacking)
    {
        this.attacking = attacking;
    }
        
    private void resetAnimationTick() {
        AnimationTick = 0;
        animationIndex = 0;
    }
  
    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

  
    
    
    
}
