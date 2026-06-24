import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Swing GUI for searching and viewing animals in a sanctuary.
 *
 * Layout:
 *   NORTH:  Search field, type combo box, injured checkbox, search button
 *   CENTER: Scrollable text area showing results
 *   SOUTH:  Status label showing match count
 */
public class SanctuaryGUI extends JFrame implements ActionListener, KeyListener {
    private Sanctuary sanctuary;

    private JTextField nameField;
    private JComboBox<String> typeCombo;
    private JCheckBox injuredCheck;
    private JButton searchButton;
    private JTextArea resultArea;
    private JLabel statusLabel;

    public SanctuaryGUI() {
        super("Caribbean Wildlife Conservation Tracker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);

        setLayout(new BorderLayout());

        JPanel northPanel = new JPanel(new FlowLayout());
        northPanel.add(new JLabel("Search:"));
        northPanel.add(nameField = new JTextField(14));
        northPanel.add(new JLabel("Type:"));
        northPanel.add(typeCombo = new JComboBox<>(new String[]{"All", "Bird", "Reptile", "Marine"}));
        northPanel.add(injuredCheck = new JCheckBox("Injured/Critical only"));
        northPanel.add(searchButton = new JButton("Search"));
        add(northPanel, BorderLayout.NORTH);

        resultArea = new JTextArea();
        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        add(scrollPane, BorderLayout.CENTER);

        statusLabel = new JLabel("Ready");
        add(statusLabel, BorderLayout.SOUTH);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runSearch();
            }
        });
       
        nameField.addKeyListener(new KeyListener() {
            @Override
            public void keyReleased(KeyEvent e) {
                runSearch();
            }

            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {}
        });

        setLocationRelativeTo(null);
    }

    public void setModel(Sanctuary s) {
        this.sanctuary = s;
        setTitle("Caribbean Wildlife Conservation Tracker - " + s.getName());
    }

    private void runSearch() {
        String name = nameField.getText().trim().toLowerCase();
        String type = (String) typeCombo.getSelectedItem();
        boolean injuredOnly = injuredCheck.isSelected();

        ArrayList<Animal> results = new ArrayList<>();
        for (Animal a : sanctuary.getAnimals()) {
            boolean matches = true;
            if (!name.isEmpty() && !a.getSpecies().toLowerCase().contains(name) && !a.getNickname().toLowerCase().contains(name)) {
                matches = false;
            }
            if (!type.equals("All") && !a.getType().equals(type)) {
                matches = false;
            }
            if (injuredOnly && !a.getHealthStatus().equals("Injured") && !a.getHealthStatus().equals("Critical")) {
                matches = false;
            }
            if (matches) {
                results.add(a);
            }
        }

        // Build result string
        StringBuilder sb = new StringBuilder();
        for (Animal a : results) {
            sb.append(a.toString()).append("\n");
        }
        resultArea.setText(sb.toString());

        // Update status label
        if (results.isEmpty()) {
            statusLabel.setText("No matches");
        } else {
            statusLabel.setText(results.size() + " result" + (results.size() > 1 ? "s" : ""));
        }
    }

    /**
     * Creates a demo sanctuary, populates it, and launches the GUI.
     *
     * TODO M12: Implement main method
     */
    public static void main(String[] args) {
        // TODO M12: Create Sanctuary, add animals, create GUI, wire model, show
    }
}
