/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tankapplication1;

import java.util.Timer;
import java.util.TimerTask;
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
        
        TankController controller = new TankController();
        TankView view = new TankView(model , controller);
        view.setModel(model);
        controller.setModel(model);
        view.setController(controller);
        controller.setView(view);
        
        
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(1000,1000);
        frame.setTitle("Tank Application");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addKeyListener(controller);
        frame.addMouseMotionListener(controller);
        frame.addMouseListener(controller);
        
        Timer timer = new Timer();
        TimerTask task1 = new TimerTask() {
            @Override
            public void run() {
                view.repaint();
            }
        };
        TimerTask task2 = new TimerTask() {
            @Override
            public void run() {
                controller.doGameLogic();
            }
        };

        timer.scheduleAtFixedRate(task1, 0, 1000/100);
        timer.scheduleAtFixedRate(task2, 0, 1000/100);
        
        frame.add(view);
        
        
    }
    
}
