/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author jondd
 */
public abstract class Entity {
    protected float x,y;
    protected int width,height;
    public Entity(float x, float y,int width,int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
}
