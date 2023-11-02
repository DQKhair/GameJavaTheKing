/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import theking.GamePanel;

/**
 *
 * @author jondd
 */
public class KeyboardInputs implements KeyListener{
    private GamePanel gamePanel;
    
    public KeyboardInputs(GamePanel gamePanel)
    {
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
               gamePanel.changeYDelta(-5);
                break;
            case KeyEvent.VK_S:
                gamePanel.changeYDelta(5);
                break;
            case KeyEvent.VK_A:
                gamePanel.changeXDelta(-5);
                break;
            case KeyEvent.VK_D:
                gamePanel.changeXDelta(5);
                break;
            default:
                throw new AssertionError();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
