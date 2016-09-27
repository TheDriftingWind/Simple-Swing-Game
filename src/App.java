
import javax.swing.*;

public class App extends javax.swing.JFrame {
 
   
    DrawingPanel _drawPanel;
    StateHolder _stateHolder;
 
   public App (String title) {
 
    super(title);
    this.setSize(550, 550);
    this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
    this.add(new MainPanel());
    
    this.pack();
    this.setVisible(true);
  }
 
  public static void main (String[] args) {
    App app = new App ("Shapes App");
  }
}