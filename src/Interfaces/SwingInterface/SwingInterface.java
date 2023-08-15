package Interfaces.SwingInterface;

import Interfaces.Interface;

import javax.swing.*;
import java.awt.*;


public class SwingInterface <T> extends JFrame implements Interface<T> {
    private JPanel graphPanel;

    public SwingInterface() {
        super("Gráfico Atualizado");
        graphPanel = new JPanel();
        graphPanel.setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 1000);
        getContentPane().add(graphPanel, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void showStep(T[] array, int step) {
            graphPanel.removeAll();
            graphPanel.add(new Graphic<>(array, step));
            graphPanel.revalidate();
            graphPanel.repaint();
    };
}

