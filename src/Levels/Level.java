/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Levels;

/**
 *
 * @author jondd
 */
public class Level {
    private int[][] lvlData;
    
    public Level(int[][] lvlData)
    {
        this.lvlData = lvlData;
    }
    
    public int getSpriteIndex(int x,int y)
    {
        return lvlData[y][x];
    }
}
