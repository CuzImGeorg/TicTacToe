import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Random;

public class Logic {

    private Random rdm = new Random();

    private int currentTurn = 0;
    private boolean won = false;

    public void toggleTurn(JLabel player1, JLabel player2) {
        if(currentTurn == 0) {
            currentTurn = rdm.nextInt(2)+1;
        } else if(currentTurn == 1){
            player1.setBorder(new LineBorder(Color.darkGray ,2));
            player2.setBorder(new LineBorder(Color.green,2));
            currentTurn = 2;
        }else {
            player1.setBorder(new LineBorder(Color.red,2));
            player2.setBorder(new LineBorder(Color.darkGray,2));
            currentTurn = 1;
        }


    }

    public boolean onClick(JButton b) {
        if(b.getBackground().equals(Color.cyan)) {
            Simulator.disposeFrame();
            Simulator.main(null);

        }else {
            if (!won) {
                if (b.getBackground().equals(Color.darkGray)) {
                    if (currentTurn == 1) b.setBackground(Color.red);
                    else b.setBackground(Color.green);
                    return true;
                }
            }

        }
        return false;
    }

    public boolean checkIfWon(JButton[] ja){


        //horizontal
        if(!ja[0].getBackground().equals(Color.darkGray) && ja[0].getBackground() == ja[1].getBackground() && ja[0].getBackground() == ja[2].getBackground()) won = true;
        if(!ja[3].getBackground().equals(Color.darkGray) &&ja[3].getBackground() == ja[4].getBackground() && ja[3].getBackground() == ja[5].getBackground()) won = true;
        if(!ja[6].getBackground().equals(Color.darkGray) &&ja[6].getBackground() == ja[7].getBackground() && ja[6].getBackground() == ja[8].getBackground()) won = true;

        //vertical
        if(!ja[0].getBackground().equals(Color.darkGray) && ja[0].getBackground() == ja[3].getBackground() && ja[0].getBackground() == ja[6].getBackground()) won = true;
        if(!ja[1].getBackground().equals(Color.darkGray) && ja[1].getBackground() == ja[4].getBackground() && ja[1].getBackground() == ja[7].getBackground()) won = true;
        if(!ja[2].getBackground().equals(Color.darkGray) && ja[2].getBackground() == ja[5].getBackground() && ja[2].getBackground() == ja[8].getBackground()) won = true;

        //diagonal
        if(!ja[0].getBackground().equals(Color.darkGray) && ja[0].getBackground() == ja[4].getBackground() && ja[0].getBackground() == ja[8].getBackground()) won = true;
        if(!ja[2].getBackground().equals(Color.darkGray) && ja[2].getBackground() == ja[4].getBackground() && ja[2].getBackground() == ja[6].getBackground()) won = true;



      return won;


    }
}
