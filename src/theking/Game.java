/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package theking;

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
    
    public Game()
    {
         gamePanel = new GamePanel();
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

    private void update() {
        gamePanel.updateGame();
    }
}
