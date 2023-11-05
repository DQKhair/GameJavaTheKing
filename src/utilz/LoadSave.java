/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilz;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import theking.Game;
import theking.GamePanel;

/**
 *
 * @author jondd
 */
public class LoadSave {
    public static final String PLAYER_ATLAS = "player_sprites.png";
    public static final String LEVEL_ATLAS = "outside_sprites.png";
    public static final String LEVEL_ONE_DATA = "level_one_data.png";
    
    
    public static BufferedImage GetSpriteAtlas(String fileName)
    {
        BufferedImage img = null;
        InputStream is = LoadSave.class.getResourceAsStream("/res/"+ fileName);
        try {
             img = ImageIO.read(is);
            
        } catch (IOException ex) {
            Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                is.close();
            }catch(IOException ex) {
                ex.printStackTrace();
            }
        }
        return img;
    }
    
    public static int[][] GetLevelData()
    {
        
        int[][] lvlData = new int[Game.TILES_IN_HEIGHT][Game.TILES_IN_WIDTH];
        BufferedImage img = GetSpriteAtlas(LEVEL_ONE_DATA);
        
        for (int i = 0; i < img.getHeight(); i++) {
            for (int j = 0; j < img.getWidth(); j++) {
                Color color = new Color(img.getRGB(j, i));
                int value = color.getRed();
                if(value >= 48)
                {
                    value = 0;
                }
                lvlData[i][j] = value;
            }
        }
        return lvlData;
    }
}
