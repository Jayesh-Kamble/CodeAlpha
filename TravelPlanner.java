import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TravelPlanner extends JFrame {
    private JTextField destinationField, dateField, preferencesField;
    private JTextArea resultArea;

    public TravelPlanner() {
        setTitle("Travel Itinerary Planner");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel destinationLabel = new JLabel("Destination:");
        JLabel dateLabel = new JLabel("Date:");
        JLabel preferencesLabel = new JLabel("Preferences:");

        destinationField = new JTextField();
        dateField = new JTextField();
        preferencesField = new JTextField();

        JButton generateButton = new JButton("Generate Itinerary");
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateItinerary();
            }
        });

        resultArea = new JTextArea();
        resultArea.setEditable(false);

        panel.add(destinationLabel);
        panel.add(destinationField);
        panel.add(dateLabel);
        panel.add(dateField);
        panel.add(preferencesLabel);
        panel.add(preferencesField);
        panel.add(generateButton);

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);

        setVisible(true);
    }

    private void generateItinerary() {
        String destination = destinationField.getText();
        String date = dateField.getText();
        String preferences = preferencesField.getText();

        // Perform itinerary generation, map integration, weather retrieval, and budget calculations here
        String itinerary = "Generated Itinerary:\n"
                + "Destination: " + destination + "\n"
                + "Date: " + date + "\n"
                + "Preferences: " + preferences + "\n";

        // Update resultArea with the generated itinerary
        resultArea.setText(itinerary);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TravelPlanner();
            }
        });
    }
}
