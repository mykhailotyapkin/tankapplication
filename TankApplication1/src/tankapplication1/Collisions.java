/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tankapplication1;

import java.awt.Graphics;

/**
 *
 * @author Michael
 */
public class Collisions {
    
    public static Tank model = new Tank();
    public static void tankHit(Graphics g){
        for(int k = 0 ; k < Variables.items.size();k++  ){
            Components component = (Components) Variables.items.get(k); 
            boolean b = checkHit(g , component);
            if(b ){
                model.setTankVX(-model.getTankVX());
                model.setTankVY(-model.getTankVY());
                model.setSpeed(0);
            }
        }
    }
    
    public static boolean checkHit(Graphics g , Components component){
        double tankCenter = model.getTankWidth()/2;
        double coorX = model.getTankX() - tankCenter;
        double coorY = model.getTankY() - tankCenter;
        double tankWidth = model.getTankWidth();
        
        if(((coorX + tankWidth) > component.getX()) && (coorX < component.getX() + component.getWidth()) ){
            if(((coorY + tankWidth) > component.getY()) && (coorY < component.getY() + component.getWidth()) )
                System.out.println("Hit:" + component);
                return true;
        }
        return false;
    }
    
}
