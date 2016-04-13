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
        
            //initial values for tank
           // Map map = new Map("./map.txt");
           // Globals.map = ImageIO.read(new File("./media/map.jpg"));
            this.model = tank;
            //Globals.tank = tank;
            this.controller = controller;
            this.addMouseListener(controller);
            this.addKeyListener(controller);
            this.addMouseMotionListener(controller);
            //tank.setX(250);
            //tank.setY(250);
            this.addComponentListener(this);
            //mage = createImage(getWidth(), getHeight());
       
    }
    
    public void drawMap() {
        try {
            Variables.map = ImageIO.read(new File("./media/map.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(TankView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void drawBullets(){
        Graphics2D bg = (Graphics2D) image.getGraphics();
        bg.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        bg.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        bg.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        bg.setColor(Color.black);

        for (int i = 0; i < Variables.bullet_list.size(); i++) {
            Bullets bul = (Bullets) Variables.bullet_list.get(i);
           // System.out.println(Variables.bullet_list.size());
            bg.fillOval((int) bul.getBulletX() + (bul.getSize() / 2), (int) bul.getBulletY() + (bul.getSize() / 2), (bul.getSize()), (bul.getSize()));
        }
    }

    
    public void paint(Graphics g){
        if (image == null) {
            image = createImage(getWidth(), getHeight());
            System.out.println("Recreated");
            return;
        }
       
        int mx = MouseInfo.getPointerInfo().getLocation().x;
        int my = MouseInfo.getPointerInfo().getLocation().y;
        int something = (int)(model.getTankX() + model.getTankWidth()/4);
        int something1 = (int)(model.getTankY() + model.getTankHeight()/2);
        
        Graphics2D g2d = (Graphics2D) g;
        Image img;
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0 , 1000, 1000);
        try {
            image = ImageIO.read(new File("./media/tank.png"));
        } catch (IOException ex) {
            Logger.getLogger(TankView.class.getName()).log(Level.SEVERE, null, ex);
        }
        //tank
        g2d.rotate(model.getAngle(),(model.getTankX() +model.getTankWidth()/2),
            (model.getTankY()+model.getTankHeight()/2));
        g2d.drawImage(image ,(int)model.getTankX(),(int) model.getTankY(),this);
        drawBullets();
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
