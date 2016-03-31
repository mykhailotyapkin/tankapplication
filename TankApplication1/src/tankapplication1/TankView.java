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
       
        g2d.rotate(model.getAngle() , model.getTankWidth()*2 , model.getTankHeight()*2);
        
        g2d.fillRect(model.getTankX(), model.getTankY(), model.getTankWidth(), model.getTankHeight());
        g2d.rotate(model.getTurretAngle()*(-1) , model.getTurretX() , model.getTurretY());
        g2d.setColor(Color.yellow);
        g2d.fillRect(model.getTurretX(), model.getTurretY(), model.getTurretRadius(), model.getTurretRadius()+80);
        
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
