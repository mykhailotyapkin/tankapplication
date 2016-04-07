/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tankapplication1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author Michael
 */
public class TankView extends JPanel {
    
    public Tank model = null;
    public TankController controller = null;
    
    
    public void paint(Graphics g){
        
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, 1000, 1000);
        g2d.setColor(Color.red);
       
        //tank
        g2d.rotate(Math.toRadians(model.getAngle()) , model.getTankX()+model.getTankWidth()/2 ,model.getTankY()+ model.getTankHeight()/2);
        g2d.fillRect((int)model.getTankX(), (int)model.getTankY(), model.getTankWidth(), model.getTankHeight());
        //circle
        g2d.rotate(Math.toRadians(model.getTurretAngle()) ,model.getTankX()+(model.getTankWidth()/2) ,model.getTankY()+(model.getTankHeight()/2) );
        g2d.setColor(Color.green);
        g2d.fillOval((int)model.getTankX(), (int)model.getTankY(), 70, 70);
        //turret
        g2d.rotate(model.getTurretAngle()*(-1) ,  model.getTankX()+model.getTankWidth()/2 , model.getTankY()+ model.getTankHeight()/2);
        g2d.setColor(Color.yellow);
        g2d.fillRect((int)model.getTurretX(), (int)model.getTurretY(), model.getTurretRadius(), model.getTurretRadius()+40);
        
        
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

    /**
     * @return the controller
     */
    public TankController getController() {
        return controller;
    }

    /**
     * @param controller the controller to set
     */
    public void setController(TankController controller) {
        this.controller = controller;
    }
    
}
