import javax.swing.*;

public class Simulator {
    private static JFrame frame = new JFrame();

    public static void main(String[] args) {


        frame.setSize(900,1000);
        frame.setLocationRelativeTo(null);



        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       GUI gui = new GUI();
       frame.setContentPane(gui);



        frame.setVisible(true);
    }

    public static void disposeFrame() {
        frame.dispose();
    }
}
