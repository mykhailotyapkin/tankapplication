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
public class TankView extends JPanel implements ComponentListener {
    
    public Tank model = null;
    public TankController controller = null;
    Image image ;
    
    
     public TankView(Tank tank, TankController controller) {
        
            
            Map map = new Map("./map.txt");
        try {
            Variables.map = ImageIO.read(new File("./media/maps.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(TankView.class.getName()).log(Level.SEVERE, null, ex);
        }
            this.model = tank;
            
            this.controller = controller;
            this.addMouseListener(controller);
            this.addKeyListener(controller);
            this.addMouseMotionListener(controller);
            
            this.addComponentListener(this);
            
       
    }
    
    
    public void drawComponents(){
        Graphics2D g2d = (Graphics2D) image.getGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        
    }

    
    public void paint(Graphics g){
        if (image == null) {
            image = createImage(getWidth(), getHeight());
            System.out.println("Recreated");
            return;
        }
        Graphics2D g2d = (Graphics2D) g;
        
        
        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, 1000, 1000);
        
        
        for (int i = 0; i < Variables.items.size(); i++) {
            Components component = (Components) Variables.items.get(i);
            
            g2d.drawImage(component.getImage(), (int) component.getX(), (int) component.getY() ,
                    (int)component.getWidth() , (int)component.getHeight() ,null);
        }
        
        Collisions.tankHit(g2d);
        int mx = MouseInfo.getPointerInfo().getLocation().x;
        int my = MouseInfo.getPointerInfo().getLocation().y;
        int something = (int)(model.getTankX() + model.getTankWidth()/4);
        int something1 = (int)(model.getTankY() + model.getTankHeight()/2);
        
        
        Image img;
        //g2d.setColor(Color.black);
        //g2d.fillRect(0, 0 , 1000, 1000);
        
        
        
        for (int i = 0; i < Variables.bullet_list.size(); i++) {
            Bullets bul = (Bullets) Variables.bullet_list.get(i);
            g2d.setColor(Color.white);
            g2d.fillOval((int) bul.getBulletX() + (bul.getSize() / 2), (int) bul.getBulletY() + (bul.getSize() / 2), (bul.getSize()), (bul.getSize()));
        }
        
        try {
            image = ImageIO.read(new File("./media/tank.png"));
        } catch (IOException ex) {
            Logger.getLogger(TankView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        //tank
        g2d.rotate(model.getAngle(),(model.getTankX() +model.getTankWidth()/2),
            (model.getTankY()+model.getTankHeight()/2));
        g2d.drawImage(image ,(int)model.getTankX(),(int) model.getTankY() , model.getTankWidth(),
                model.getTankHeight(),this);
        
        //drawBullets();
        //drawComponents();
        /*
        //rectangle
        g2d.setColor(Color.red);
        g2d.rotate(model.getAngle(),(model.getTankX() +model.getTankWidth()/2),
            (model.getTankY()+model.getTankHeight()/2));
        g2d.fillRect((int)model.getTankX(),(int) model.getTankY(),
                model.getTankWidth(), model.getTankHeight());
        //turret
        g2d.setColor(Color.CYAN);
        
        g2d.rotate(Math.atan2(mx-model.getTankX() , my-model.getTankY())*(-1),
                (int)something+model.getTurretRadius()/2 , (int)something1);
        
        g2d.fillRect((int)something+model.getTurretRadius()-30,
                (int)something1, model.getTurretRadius()-20,
                model.getTurretRadius()+60);
        
        //circle
        g2d.setColor(Color.yellow);
        g2d.rotate(Math.atan2(mx-model.getTankX() , my-model.getTankY())*(-1),
                (int)something+model.getTurretRadius()/2 , (int)something1);
        g2d.fillOval((int)model.getTankX(), (int)model.getTankY(), 80, 80);
        */
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

    @Override
    public void componentResized(ComponentEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void componentMoved(ComponentEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void componentShown(ComponentEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void componentHidden(ComponentEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
