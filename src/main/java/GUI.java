import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JPanel implements ActionListener {
    private JLabel player1 = new JLabel(),
                   player2 = new JLabel(),
                    time = new JLabel(),
                  player1Wins = new JLabel(),
                    player2Wins = new JLabel();

    private int p1Win, p2Win;



    private Logic logic = new Logic();

    private JButton[] ja = new JButton[9];
    private JButton restart = new JButton();


    public GUI() {
        setBackground(Color.gray);
        setLayout(new GridLayout(5,3 ,10,10));

        player1.setText("Spieler 1");
        player1.setBounds(10,10 ,50 ,90);
        player1.setBorder(new LineBorder(Color.darkGray, 2));


        player2.setText("Spieler 2");
        player2.setBounds(200,10 ,50 ,90);
        player2.setBorder(new LineBorder(Color.darkGray, 2));

        time.setText("Time:");
        player2.setBorder(new LineBorder(Color.black, 2));
        player2.setBorder(new LineBorder(Color.darkGray, 2));

        restart.setBackground(Color.cyan);
        restart.setText("restart");
        restart.setBounds(250,250,250,250);
        restart.addActionListener(this);
        
        add(player1);
        add(time);
        add(player2);

        logic.toggleTurn(player1, player2);
        logic.toggleTurn(player1, player2);


//        for(JButton b : ja) {
//            b = new JButton();
//            b.setBackground(Color.darkGray);
//            b.addActionListener(this);
//            add(b);
//        }

        for (int i = 0; i < 9; i++) {
            ja[i] = new JButton();
            ja[i].setBackground(Color.darkGray);
            ja[i].addActionListener(this);
            add(ja[i]);
        }

        add(player1Wins);
        add(restart);
        add(player2Wins);




    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jb = (JButton) e.getSource();
        boolean b = logic.onClick(jb);
        if (b) logic.toggleTurn(player1, player2);
        logic.checkIfWon(ja);

    }
}
