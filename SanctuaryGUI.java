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
public class SanctuaryGUI extends JFrame {
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

        // TODO M11: Add ActionListener to searchButton that calls runSearch()

        // TODO M11: Add KeyListener to nameField that calls runSearch() on keyReleased

        setLocationRelativeTo(null);
    }

    public void setModel(Sanctuary s) {
        this.sanctuary = s;
        setTitle("Caribbean Wildlife Conservation Tracker - " + s.getName());
    }

    /**
     * Filters the sanctuary's animals based on the GUI controls and
     * displays matching results.
     *
     * TODO M11: Implement runSearch
     *
     * Steps:
     * 1. Get text from nameField (trim, convert to lowercase)
     * 2. Get selected type from typeCombo
     * 3. Get checkbox state from injuredCheck
     * 4. Loop through sanctuary's animals:
     *    - If text is non-empty, keep only animals whose species or nickname
     *      contains the text (case-insensitive)
     *    - If type is not "All", keep only matching type
     *    - If checkbox is selected, keep only "Injured" or "Critical" animals
     * 5. Build result string and set in resultArea
     * 6. Set statusLabel: "No matches", "1 result", or "N results"
     */
    private void runSearch() {
        // TODO M11: Implement filtering and display
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
