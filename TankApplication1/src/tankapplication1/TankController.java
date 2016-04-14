/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tankapplication1;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;


/**
 *
 * @author Michael
 */
public class TankController extends JPanel implements KeyListener ,ActionListener , MouseMotionListener , MouseListener {
    Tank model = null;
    TankView view = null;
    
    public void paint(){
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {

    }
    
    public TankView getView() {
        return view;
    }

    /**
     * @param view the view to set
     */
    public void setView(TankView view) {
        this.view = view;
    }

    /**
     * @return the model
     */
    public Tank getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(Tank model) {
        this.model = model;
        
    }
    
    private void doRotateLeft()  {
        try {
            model.empty();
            model.setAngle(model.getAngle()-0.15);
            model.setFuel(model.getFuel()-0.3);
            view.repaint(); 
        } catch (outOfFuelException ex) {
            System.out.println(ex);
            //Logger.getLogger(TankController.class.getName()).log(Level.SEVERE, null, ex);
        }
          
    }
    
    private void doRotateRigth() {
         
            model.setAngle(model.getAngle()+0.15);
            
            view.repaint();
        
        
    }
    
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                try {
                    model.empty();
                    model.setFuel(model.getFuel()-0.05);
                    doRotateLeft();
                } catch (outOfFuelException ex) {
                    System.out.println(ex);
                    //Logger.getLogger(TankController.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case KeyEvent.VK_RIGHT:
                try {
                    model.empty();
                    model.setFuel(model.getFuel()-0.05);
                    doRotateRigth();
                } catch (outOfFuelException ex) {
                    System.out.println(ex);
                    //Logger.getLogger(TankController.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case KeyEvent.VK_UP:
                try {
                    model.empty();
                    doForward();
                    model.setFuel(model.getFuel()-0.3);
                } catch (outOfFuelException ex) {
                    System.out.println(ex);
                    //Logger.getLogger(TankController.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case KeyEvent.VK_DOWN:
                try {
                    model.empty();
                    doBackward();
                    model.setFuel(model.getFuel()-0.3);
                } catch (outOfFuelException ex) {
                    System.out.println(ex);
                    //Logger.getLogger(TankController.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case KeyEvent.VK_SPACE:
                doFireBullet();
                break;
            default:
                break;
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
       
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
       
        model.setTurretAngle(Math.atan2(MouseInfo.getPointerInfo().getLocation().x,
            MouseInfo.getPointerInfo().getLocation().y) );
        view.repaint();
    }

    private void doForward() {
       Variables.speed += 0.1;
    }

    private void doBackward() {
        Variables.speed -= 0.1;
    }
    
    public void doGameLogic(){
        
        
            model.setTankX(model.getTankX() + model.getTankVX());
            model.setTankY(model.getTankY() + model.getTankVY());


            double a = (double) model.getTankX();
            double b = (double) model.getTankY();
            double r = model.getTankWidth();
            double r1 = model.getTankHeight();
            double n = model.getAngle();
            double t = (n + (Math.PI / 2));
            double x = a + (r * Math.cos(t));
            double y = b + (r1 * Math.sin(t));

            double dx = x;
            double dy = y;
            double ox = model.getTankX();
            double oy = model.getTankY();
            dx = -dx + ox;
            dy = -dy + oy;
            double speedX = dx / Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
            double speedY = dy / Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
            speedX *= Variables.speed;
            speedY *= Variables.speed;

            model.setTankVX(speedX);
            model.setTankVY(speedY);

         
        
        
    }
    
    public void doFireBullet(){
        Bullets b = new Bullets();
        int startX = (int)model.getTankX() + b.getSize()/2;
        int startY = (int)model.getTankY() + b.getSize()/2;
        
        b.setBulletX(startX);
        b.setBulletY(startY);
        
        double speed = 5 ;
        double mx = MouseInfo.getPointerInfo().getLocation().x;
        double my = MouseInfo.getPointerInfo().getLocation().x;
        double dx = startX - mx;
        double dy = startY - my;
        
        double speedX = dx/Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
        double speedY = dy/Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
        
        speedX *= speed;
        speedY *= speed;
        
        b.setBulletVX(speedX);
        b.setBulletVY(speedY);
        
        Variables.bullet_list.add(b);
        
        new Sounds("./media/fire_sound.wav").start();
    }
    
     
         
   public void Collisions(){
       for(int k = 0 ; k < Variables.items.size();k++  ){
            Components component = (Components) Variables.items.get(k);
            
            double tankCenter = model.getTankWidth()/2;
            double coorX = model.getTankX() - tankCenter;
            double coorY = model.getTankY() - tankCenter;
            
            double tankWidth = model.getTankWidth();
        
            /*if(((coorX + tankWidth) >= component.getX()) && (coorX <= component.getX() + component.getWidth()) ){
                if(((coorY + tankWidth) >= component.getY()) && (coorY <= component.getY() + component.getHeight()) ){
                    model.setTankVX(-model.getTankVX());
                    model.setTankVY(-model.getTankVY());
                    model.setSpeed(0);
                }      
            }*/
            if((coorX + tankWidth) >= component.getX()){
                model.setTankVX(-model.getTankVX());
                model.setTankVY(-model.getTankVY());
                model.setSpeed(0);
            }else if(coorX <= component.getX() + component.getWidth()){
                model.setTankVX(-model.getTankVX());
                model.setTankVY(-model.getTankVY());
                model.setSpeed(0);
            }
       }
       
        
   }      
         
        
        
        
        
        
      
     
    @Override
    public void mouseClicked(MouseEvent e) {
        doFireBullet();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
