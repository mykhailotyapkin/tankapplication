/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tankapplication1;

import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;

/**
 *
 * @author Michael
 */
public class TankController extends JPanel implements KeyListener ,ActionListener , MouseMotionListener{
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
    
    private void doRotateRigth()  {
        if(isRotating()){
           
                model.setAngle(model.getAngle()-8);
                model.setFuel(model.getFuel() - model.getK());
                System.out.println(Math.toRadians(model.getAngle()));
                //System.out.println(model.getFuel());
                view.repaint();
                //throw new outOfFuelException();
                
            
        }
    }
    
    private void doRotateLeft() {
        if(isRotating()){
            model.setAngle(model.getAngle()+8);
            System.out.println(model.getAngle());
            view.repaint();
        }
    }
    
    
    private boolean rotating = false;
    Timer timer = new Timer();
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }
    
    public boolean isRotating() {
        return rotating;
    }

    /**
     * @param rotating the rotating to set
     */
    public void setRotating(boolean rotating) {
        this.rotating = rotating;
    }

    @Override
    public void keyPressed(KeyEvent e) {
         
       
                if(e.getKeyChar() == 'a'){
                    timer.cancel();
                    timer = new Timer();
                    setRotating(!isRotating());
                    final TankController controller = this;
                    controller.doRotateRigth();
                }else if(e.getKeyChar() == 'd'){
                    timer.cancel();
                    timer = new Timer();
                    setRotating(!isRotating());
                    final TankController controller = this;
                    controller.doRotateLeft();
                }else if(e.getKeyChar() == 'w'){
                    final TankController controller = this;
                    controller.doForward();
                }else if(e.getKeyChar() == 's'){
                    final TankController controller = this;
                    //while(model.getFuel()>0){
                        timer.cancel();
                        timer = new Timer();
                        controller.doBackward();
                    //}
                     
                }/*else if ((e.getKeyChar() == 'w') && (e.getKeyChar() == 'a')){
                    timer.cancel();
                    timer = new Timer();
                    setRotating(!isRotating());
                    final TankController controller = this;
                    controller.doRotateRigth();
                    controller.doForward();
                }else if ((e.getKeyChar() == 'w') && (e.getKeyChar() == 'd')){
                    timer.cancel();
                    timer = new Timer();
                    setRotating(!isRotating());
                    final TankController controller = this;
                    controller.doRotateLeft();
                    controller.doForward();
                }else if ((e.getKeyChar() == 's') && (e.getKeyChar() == 'a')){
                    timer.cancel();
                    timer = new Timer();
                    setRotating(!isRotating());
                    final TankController controller = this;
                    controller.doRotateRigth();
                    controller.doBackward();
                }else if ((e.getKeyChar() == 's') && (e.getKeyChar() == 'd')){
                    timer.cancel();
                    timer = new Timer();
                    setRotating(!isRotating());
                    final TankController controller = this;
                    controller.doRotateLeft();
                    controller.doBackward();
                }*/
                
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
       if(Math.toRadians(model.getAngle()) == 0){
            model.setTankY((model.getTankY()) - 5);
            model.setTurretX(model.getTankX()+(model.getTankWidth()/4));
            model.setTurretY(model.getTankY()+(model.getTankHeight()/2));
            view.repaint();
       }else if(model.getAngle() < 0){
            model.setTankX(model.getTankX() + ((model.getTankX() * Math.toRadians(model.getAngle())/10)));
            model.setTankY(model.getTankY() + ((model.getTankX() * Math.toRadians(model.getAngle())/10)));
            model.setTurretX(model.getTankX()+(model.getTankWidth()/4));
            model.setTurretY(model.getTankY()+(model.getTankHeight()/2));
            view.repaint();
        }else if(model.getAngle() > 0){
            model.setTankX(model.getTankX() + ((model.getTankX() * Math.toRadians(model.getAngle())/10)));
            model.setTankY(model.getTankY() + ((model.getTankX() * Math.toRadians(model.getAngle())/10)));
            model.setTurretX(model.getTankX()+(model.getTankWidth()/4));
            model.setTurretY(model.getTankY()+(model.getTankHeight()/2));
            view.repaint();
        }
        
    }

    private void doBackward() {
        
            model.setTankX((model.getTankX()) + 5);
            model.setTankY((model.getTankY()) + 5);
            model.setTurretX(model.getTankX()+(model.getTankWidth()/4));
            model.setTurretY(model.getTankY()+(model.getTankHeight()/2));
            model.setFuel(model.getFuel() - 0.2);
            System.out.println(model.getFuel());
        
            view.repaint();
        
        
    }

    
}
