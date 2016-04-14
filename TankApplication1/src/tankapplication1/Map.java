/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tankapplication1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Michael
 */
public class Map {
    public Map(String file)
    {
        FileInputStream fis = null;
        try {
            File f = new File(file);
            fis = new FileInputStream(f);
            int c = -1;
            double x = 0;
            double y = 0;
            while( (c = fis.read()) != -1 ){
                try {
                    if( c == '\n'){
                        y++;
                        x = 0;
                        
                    }
                    else if(c == 'A')
                    {
                        Components component = new Components();
                        component.setImage(ImageIO.read(new File("./media/images.png")));
                        component.setWidth(38);
                        component.setHeight(47);
                        component.setX(x*38);
                        component.setY(y*47);
                        component.setDestroyable(false);
                        Variables.items.add(component);
                        x++;
                    } else {
                        x++;
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Map.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch(Exception ex){}
        
    }
}
