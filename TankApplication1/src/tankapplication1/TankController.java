/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tankapplication1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;

/**
 *
 * @author Michael
 */
public class TankController extends JPanel implements KeyListener ,ActionListener{
    Tank model = null;
    TankView view = null;
    
    public void paint(){
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
       
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
    private void doRotateRigth() {
        if(isRotating()){
            model.setAngle(model.getAngle()-0.5);
            view.repaint();
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void doRotateLeft() {
        if(isRotating()){
            model.setAngle(model.getAngle()+0.5);
            view.repaint();
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    private boolean rotating = false;
    Timer timer = new Timer();
    
    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyChar() == 'a'){
            timer.cancel();
            timer = new Timer();
            setRotating(!isRotating());
            final TankController controller = this;
        
            TimerTask task = new TimerTask(){
            public void run(){
                controller.doRotateLeft();
            }
        };
        timer.scheduleAtFixedRate(task , 0 ,30);
        }else if(e.getKeyChar() == 'd'){
            timer.cancel();
            timer = new Timer();
            setRotating(!isRotating());
            final TankController controller = this;
        
            TimerTask task = new TimerTask(){
            public void run(){
                controller.doRotateRigth();
            }
        };
        timer.scheduleAtFixedRate(task , 0 ,30);
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
