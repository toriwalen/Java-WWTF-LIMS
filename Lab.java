import javax.swing.*;

/**
 * This is the main class for the LIMS system.
 *
 * @author Tori
 * @version 2021-12-10
 */
public class Lab
{
    // instance variables - replace the example below with your own
    
     /*
      * 
      public Sample createNewSample(){
      Sample newSample = new Sample();
      return newSample;
     }*/

     public static void main(String[] args){
         JFrame frame = new JFrame("FrameDemo");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         JButton button3 = new JButton("Take Samples");
         JButton button = new JButton("Set TSS");
         JButton button2 = new JButton("Read TSS");
         frame.getContentPane().add(button3);
         frame.getContentPane().add(button2);
         frame.getContentPane().add(button);
         frame.pack();
         frame.setVisible(true);
         
         
     }
}
