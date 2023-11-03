/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package theking;

import javax.swing.JFrame;

/**
 *
 * @author jondd
 */
public class GameWindow extends JFrame{
    private JFrame jFrame;
    public GameWindow(GamePanel gamePanel)
    {
        jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.add(gamePanel);
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        jFrame.pack();
        jFrame.setVisible(true);
        
    }
}
