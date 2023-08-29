package Interfaces.SwingInterface;

import Interfaces.Interface;

import javax.swing.*;
import java.awt.*;


public class SwingInterface <T> extends JFrame implements Interface<T> {
    private JPanel graphPanel;

    public SwingInterface() {
        super("Gráfico do Willl");
        graphPanel = new JPanel();
        graphPanel.setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 1000);
        getContentPane().add(graphPanel, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void showStep(T[] array, int step, double miliSeconds) {
            graphPanel.removeAll();
            graphPanel.add(new Graphic<>(array, step, miliSeconds));
            graphPanel.revalidate();
            graphPanel.repaint();
    };
}

