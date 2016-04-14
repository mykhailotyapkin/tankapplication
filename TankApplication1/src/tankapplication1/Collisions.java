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
    
    Tank model= null;
    public static void checkTank(){
        //Tank model = new Tank();
        for(int k = 0 ; k < Variables.items.size();k++  ){
            Components component = (Components) Variables.items.get(k); 
            boolean b = checkTankHit(component);
            if(b){
                Tank.setTankVX(-Variables.tank.getTankVX());
                Variables.tank.setTankVY(-Variables.tank.getTankVY());
                Variables.tank.setSpeed(0);
            }
        }
    }
    
    public static boolean checkTankHit( Components component){
        
        double tankCenter = 21;
        double coorX = Variables.tank.getTankX() - tankCenter;
        double coorY = Variables.tank.getTankY() - tankCenter;
        System.out.println("coorX" + coorX);
        double tankWidth =Variables.tank.getTankWidth();
        
        if(((coorX + tankWidth) >= component.getX()) && (coorX <= component.getX() + component.getWidth()) ){
            if(((coorY + tankWidth) >= component.getY()) && (coorY <= component.getY() + component.getHeight()) ){
                //System.out.println((coorX + tankWidth) + " " +  component.getX());
                return true;
            }
        }
        return false;
    }
    
    
    public Tank getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(Tank model) {
        this.model = model;
    }
}
