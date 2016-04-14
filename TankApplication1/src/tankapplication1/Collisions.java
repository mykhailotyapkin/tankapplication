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
    
    
    public static void checkTank(){
        for(int k = 0 ; k < Variables.items.size();k++  ){
            Components component = (Components) Variables.items.get(k); 
            boolean b = checkTankHit(component);
            if(b){
                Variables.model.setTankVX(0);
                Variables.model.setTankVY(0);
                Variables.model.setSpeed(0);
            }
        }
    }
    
    public static boolean checkTankHit( Components component){
        
        if(((Variables.model.getTankX()) >= component.getX()) && (Variables.model.getTankX() <= component.getX() + component.getWidth()) ){
            if(((Variables.model.getTankY()) >= component.getY()) && (Variables.model.getTankY() <= component.getY() + component.getHeight()) ){
                return true;
            }
        }
        return false;
    }
}
