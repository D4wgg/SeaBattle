package seabattle.skeleton;

import seabattle.skeleton.mode.*;
import seabattle.skeleton.gameplay.GameEngine;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Launcher extends JFrame {

    public static void main(String[] args) {
        //new Launcher().buildGui();
        System.out.println("Выбери режим игры : обстрел поля оппонента(жми 1) или полноценный бой(жми 2)");
        if (new Scanner(System.in).nextInt() == 1) new GameEngine(new SinkEnemyShips()).startGame();
        else new GameEngine(new RealDuelVsBot()).startGame();
    }

    private void buildGui() {
        JPanel mainPanel = new JPanel();
        JLabel label = new JLabel("Select game mode u`d like to play in");
        setSize(1280, 720);
        setBackground(Color.BLUE);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        add(mainPanel);
        add(BorderLayout.NORTH, label);

        JButton button1 = new JButton("Game mode №1");
        button1.addActionListener(new FirstButtonListener());

        JButton button2 = new JButton("Game mode №2");
        button2.addActionListener(new SecondButtonListener());

        mainPanel.add(button1);
        mainPanel.add(button2);

        setVisible(true);
    }

    class FirstButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new GameEngine(new SinkEnemyShips()).startGame();
        }
    }

    class SecondButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            new GameEngine(new RealDuelVsBot()).startGame();
        }
    }
}
