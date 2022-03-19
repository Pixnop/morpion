import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Morpion implements ActionListener{

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel panel_titre = new JPanel();
    JPanel panel_bouton = new JPanel();
    JLabel texte = new JLabel();
    JButton[] butons = new JButton[9];
    boolean tourJoueur1;

    Morpion(){

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        texte.setBackground(new Color(25,25,25));
        texte.setForeground(new Color(25,255,0));
        texte.setFont(new Font("Arial",Font.BOLD,75));
        texte.setHorizontalAlignment(JLabel.CENTER);
        texte.setText("le jeu du Morpion");
        texte.setOpaque(true);

        panel_titre.setLayout(new BorderLayout());
        panel_titre.setBounds(0,0,800,100);

        panel_bouton.setLayout(new GridLayout(3,3));
        panel_bouton.setBackground(new Color(150,150,150));

        for(int i=0;i<9;i++) {
            butons[i] = new JButton();
            panel_bouton.add(butons[i]);
            butons[i].setFont(new Font("Arial",Font.BOLD,120));
            butons[i].setFocusable(false);
            butons[i].addActionListener(this);
        }

        panel_titre.add(texte);
        frame.add(panel_titre,BorderLayout.NORTH);
        frame.add(panel_bouton);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i=0;i<9;i++) {
            if(e.getSource()==butons[i]) {
                if(tourJoueur1) {
                    if(Objects.equals(butons[i].getText(), "")) {
                        butons[i].setForeground(new Color(255,0,0));
                        butons[i].setText("X");
                        tourJoueur1=false;
                        texte.setText("à O de jouer");
                        check();
                    }
                }
                else {
                    if(Objects.equals(butons[i].getText(), "")) {
                        butons[i].setForeground(new Color(0,0,255));
                        butons[i].setText("O");
                        tourJoueur1=true;
                        texte.setText("à X de jouer");
                        check();
                    }
                }
            }
        }
    }

    public void firstTurn() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(random.nextInt(2)==0) {
            tourJoueur1=true;
            texte.setText("à X de jouer");
        }
        else {
            tourJoueur1=false;
            texte.setText("à O de jouer");
        }
    }

    public void check() {
        //check X win conditions
        if(
                (Objects.equals(butons[0].getText(), "X")) &&
                        (Objects.equals(butons[1].getText(), "X")) &&
                        (Objects.equals(butons[2].getText(), "X"))
        ) {
            xWins(0,1,2);
        }
        if(
                (Objects.equals(butons[3].getText(), "X")) &&
                        (Objects.equals(butons[4].getText(), "X")) &&
                        (Objects.equals(butons[5].getText(), "X"))
        ) {
            xWins(3,4,5);
        }
        if(
                (Objects.equals(butons[6].getText(), "X")) &&
                        (Objects.equals(butons[7].getText(), "X")) &&
                        (Objects.equals(butons[8].getText(), "X"))
        ) {
            xWins(6,7,8);
        }
        if(
                (Objects.equals(butons[0].getText(), "X")) &&
                        (Objects.equals(butons[3].getText(), "X")) &&
                        (Objects.equals(butons[6].getText(), "X"))
        ) {
            xWins(0,3,6);
        }
        if(
                (Objects.equals(butons[1].getText(), "X")) &&
                        (Objects.equals(butons[4].getText(), "X")) &&
                        (Objects.equals(butons[7].getText(), "X"))
        ) {
            xWins(1,4,7);
        }
        if(
                (Objects.equals(butons[2].getText(), "X")) &&
                        (Objects.equals(butons[5].getText(), "X")) &&
                        (Objects.equals(butons[8].getText(), "X"))
        ) {
            xWins(2,5,8);
        }
        if(
                (Objects.equals(butons[0].getText(), "X")) &&
                        (Objects.equals(butons[4].getText(), "X")) &&
                        (Objects.equals(butons[8].getText(), "X"))
        ) {
            xWins(0,4,8);
        }
        if(
                (Objects.equals(butons[2].getText(), "X")) &&
                        (Objects.equals(butons[4].getText(), "X")) &&
                        (Objects.equals(butons[6].getText(), "X"))
        ) {
            xWins(2,4,6);
        }
        //check O win conditions
        if(
                (Objects.equals(butons[0].getText(), "O")) &&
                        (Objects.equals(butons[1].getText(), "O")) &&
                        (Objects.equals(butons[2].getText(), "O"))
        ) {
            oWins(0,1,2);
        }
        if(
                (Objects.equals(butons[3].getText(), "O")) &&
                        (Objects.equals(butons[4].getText(), "O")) &&
                        (Objects.equals(butons[5].getText(), "O"))
        ) {
            oWins(3,4,5);
        }
        if(
                (Objects.equals(butons[6].getText(), "O")) &&
                        (Objects.equals(butons[7].getText(), "O")) &&
                        (Objects.equals(butons[8].getText(), "O"))
        ) {
            oWins(6,7,8);
        }
        if(
                (Objects.equals(butons[0].getText(), "O")) &&
                        (Objects.equals(butons[3].getText(), "O")) &&
                        (Objects.equals(butons[6].getText(), "O"))
        ) {
            oWins(0,3,6);
        }
        if(
                (Objects.equals(butons[1].getText(), "O")) &&
                        (Objects.equals(butons[4].getText(), "O")) &&
                        (Objects.equals(butons[7].getText(), "O"))
        ) {
            oWins(1,4,7);
        }
        if(
                (Objects.equals(butons[2].getText(), "O")) &&
                        (Objects.equals(butons[5].getText(), "O")) &&
                        (Objects.equals(butons[8].getText(), "O"))
        ) {
            oWins(2,5,8);
        }
        if(
                (Objects.equals(butons[0].getText(), "O")) &&
                        (Objects.equals(butons[4].getText(), "O")) &&
                        (Objects.equals(butons[8].getText(), "O"))
        ) {
            oWins(0,4,8);
        }
        if(
                (Objects.equals(butons[2].getText(), "O")) &&
                        (Objects.equals(butons[4].getText(), "O")) &&
                        (Objects.equals(butons[6].getText(), "O"))
        ) {
            oWins(2,4,6);
        }
    }

    public void xWins(int a,int b,int c) {
        butons[a].setBackground(Color.GREEN);
        butons[b].setBackground(Color.GREEN);
        butons[c].setBackground(Color.GREEN);

        for(int i=0;i<9;i++) {
            butons[i].setEnabled(false);
        }
        texte.setText("X gagne");
    }
    public void oWins(int a,int b,int c) {
        butons[a].setBackground(Color.GREEN);
        butons[b].setBackground(Color.GREEN);
        butons[c].setBackground(Color.GREEN);

        for(int i=0;i<9;i++) {
            butons[i].setEnabled(false);
        }
        texte.setText("O gagne");
    }
}