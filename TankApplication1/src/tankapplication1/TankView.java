/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tankapplication1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.RenderingHints;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Michael
 */
public class TankView extends JPanel  {
    
    public Tank model = null;
    public TankController controller = null;
    Image image ;
    Image turretImage;
    
     public TankView(Tank model, TankController controller) {   
        Map map = new Map("./map.txt");
        try {
            Variables.map = ImageIO.read(new File("./media/maps.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(TankView.class.getName()).log(Level.SEVERE, null, ex);
        }
            this.model = model;
            this.controller = controller;
            this.addMouseListener(controller);
            this.addKeyListener(controller);
            this.addMouseMotionListener(controller);
    }
    
    public void paint(Graphics g){
        /*if (image == null) {
            image = createImage(getWidth(), getHeight());
            System.out.println("Recreated");
            return;
        }*/
        Graphics2D g2d = (Graphics2D) g;
        
        
        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, 1000, 1000);
        
        
        for (int i = 0; i < Variables.items.size(); i++) {
            Components component = (Components) Variables.items.get(i);
            
            g2d.drawImage(component.getImage(), (int) component.getX(), (int) component.getY() ,
                    (int)component.getWidth() , (int)component.getHeight() ,null);
        }
        
        int something = (int)(model.getTankX() + model.getTankWidth()/4);
        int something1 = (int)(model.getTankY() + model.getTankHeight()/2);
        
        for (int i = 0; i < model.bullet_list.size(); i++) {
            Bullets bul = (Bullets) model.bullet_list.get(i);
            g2d.setColor(Color.white);
            g2d.fillOval((int) bul.getBulletX() + (bul.getSize() / 2), (int) bul.getBulletY() + (bul.getSize() / 2), (bul.getSize()), (bul.getSize()));
        }
        
        
        Collisions.checkTank();
        //tank
        try {
            image = ImageIO.read(new File("./media/tank-edit.png"));
        } catch (IOException ex) {
            Logger.getLogger(TankView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        g2d.rotate(model.getAngle(),(model.getTankX() +model.getTankWidth()/2),
            (model.getTankY()+model.getTankHeight()/2));
        g2d.drawImage(image ,(int)model.getTankX(),(int) model.getTankY() , model.getTankWidth(),
                model.getTankHeight(),this);
        
        
        //turret
        try {
            turretImage = ImageIO.read(new File("./media/turret.png"));
        } catch (IOException ex) {
            Logger.getLogger(TankView.class.getName()).log(Level.SEVERE, null, ex);
        }

        g2d.rotate(model.getTurretAngle(),
                model.getTankX()+30 ,model.getTankY() + 80 );
        g2d.drawImage(turretImage ,(int)something+model.getTurretRadius()-46,
                (int)something1 - model.getTurretRadius()-12, model.getTurretRadius(),
                model.getTurretRadius()+60 , this); 
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
