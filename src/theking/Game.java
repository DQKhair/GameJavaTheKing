/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package theking;

import Levels.LevelManager;
import entities.Player;
import java.awt.Graphics;

/**
 *
 * @author jondd
 */
public class Game implements Runnable{
    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private Thread gameThread;
    private final int FPS_SET = 120;
    private final int UPS_SET = 200;
    
    private LevelManager levelManager;
    
    public final static int TILES_DEFAULT_SIZE = 32;
    public final static float SCALE = 2.0f;
    public final static int TILES_IN_WIDTH = 26;
    public final static int TILES_IN_HEIGHT = 14;
    public final static int TILES_SIZE = (int)(TILES_DEFAULT_SIZE * SCALE);
    public final static int GAME_WIDTH = TILES_SIZE * TILES_IN_WIDTH;
    public final static int GAME_HEIGHT = TILES_SIZE * TILES_IN_HEIGHT;
    
    private Player player;
    
    public Game()
    {
        initClasses();
        
        gamePanel = new GamePanel(this);
        gameWindow = new GameWindow(gamePanel);
        gamePanel.setFocusable(true);
        gamePanel.requestFocus();
        
        

        startGameLoop();
    }
    
    private void startGameLoop()
    {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double timePerFrame = 1000000000.0 / FPS_SET;
        double timePerUpdate = 1000000000.0 / UPS_SET;

        
        long previousTime = System.nanoTime();
        
        int frame = 0;
        int update = 0;
        long lastCheck = System.currentTimeMillis();
        
        double deltaU = 0;
        double deltaF = 0;
        
        while (true) {     
            long currentTime = System.nanoTime();
            
            deltaU += (currentTime - previousTime) /timePerUpdate;
            deltaF += (currentTime - previousTime) /timePerFrame;
            previousTime = currentTime;
            
            if(deltaU >= 1)
            {
                update();
                update++;
                deltaU--;
            }
            
            if(deltaF >= 1)
            {
                gamePanel.repaint();
                frame ++;
                deltaF--;
            }
            
            
        if(System.currentTimeMillis() - lastCheck >= 1000)
        {
            lastCheck = System.currentTimeMillis();
            System.out.println("FPS: "+frame+" |  UPS: "+update);
            frame = 0;
            update = 0;
        }
        }
    }

    private void initClasses() {
        player= new Player(200, 200,(int) (64 * SCALE), (int) (40 * SCALE));
        levelManager = new LevelManager(this);
    }
    
    public void update() {
        player.update();
        levelManager.update();
    }
    
    public void render(Graphics g)
    {
        levelManager.draw(g);
        player.render(g);
    }


    
    public Player getPlayer()
    {
        return player;
    }
    public void windowFocusLost()
    {
        player.resetDirBoolean();
    }
}
