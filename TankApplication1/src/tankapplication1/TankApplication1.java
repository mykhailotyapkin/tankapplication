/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tankapplication1;

import javax.swing.JFrame;


enum Command{
    ROTATION
}
/**
 *
 * @author Michael
 */
public class TankApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        Tank model = new Tank();
        TankView view = new TankView();
        TankController controller = new TankController();
        
        view.setModel(model);
        controller.setModel(model);
        view.setController(controller);
        controller.setView(view);
        
        
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(1000,1000);
        frame.setTitle("Tank Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addKeyListener(controller);
        frame.addMouseMotionListener(controller);
        frame.add(view);
        
        
    }
    
}
