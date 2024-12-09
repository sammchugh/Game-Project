package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Display extends JFrame implements ActionListener {
	public static void main(String[] args) {
        new Display();
    }

    public JTextArea textArea;
    private JTextField inputField;
    private JPanel panel;
    private JLabel label;
    private JButton button;

    public Display() {
        buildWindow();
    }    
 

    @Override
    public void actionPerformed(ActionEvent event) {
    	JButton j = (JButton) event.getSource();
       String s = inputField.getText();
       Game.processCommand(s);
    }

    private void buildWindow() {
        setTitle("Escape House Game");
        setLayout(new BorderLayout());
        
        textArea = new JTextArea();
        panel = new JPanel();
        label = new JLabel("Where do you want to go?");
        inputField = new JTextField();
        button = new JButton("Execute");
        
        panel.setLayout(new GridLayout(3, 1));
        button.addActionListener(this);
        
        panel.add(label);
        panel.add(inputField);
        panel.add(button);
        JScrollPane scroll = new JScrollPane(textArea);
        add(scroll, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
