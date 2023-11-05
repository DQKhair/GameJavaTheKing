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
import static theking.Game.GAME_HEIGHT;
import static theking.Game.GAME_WIDTH;

/**
 *
 * @author jondd
 */
public class GamePanel extends JPanel{
    private MouseInputs mouseInputs;
    private Game game;
    
    public  GamePanel(Game game)
    {
        this.game = game;
        mouseInputs = new MouseInputs(this);
        
        setPanelSize();
        
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
        
        
    }
    
    
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        game.render(g);
    }

    private void setPanelSize() {
        Dimension size = new Dimension(GAME_WIDTH,GAME_HEIGHT);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
        
        System.out.println("Size : "+GAME_WIDTH + "|" +GAME_HEIGHT);
    }

    public Game getGame()
    {
        return game;
    }
}
