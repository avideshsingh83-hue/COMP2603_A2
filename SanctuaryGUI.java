import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

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

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runSearch();
            }
        });
       
        nameField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    runSearch();
                }
        });
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

        StringBuilder sb = new StringBuilder();
        for (Animal a : results) {
            sb.append(a.toString()).append("\n");
        }
        resultArea.setText(sb.toString());

        if (results.isEmpty()) {
            statusLabel.setText("No matches");
        } else {
            statusLabel.setText(results.size() + " result" + (results.size() > 1 ? "s" : ""));
        }
    }

    public static void main(String[] args) {
        Sanctuary caroni = new Sanctuary("Caroni Bird Sanctuary", "Trinidad", 20);
        Bird ruby = new Bird("Scarlet Ibis", "Ruby", "Trinidad", 0.35, "Healthy", 60.0, true);
        Bird blaze = new Bird("Scarlet Ibis", "Blaze", "Trinidad", 0.40, "Healthy", 58.0, true);
        Bird dusty = new Bird("Cocrico", "Dusty", "Trinidad", 0.25, "Injured", 30.0, true);
        Reptile brutus = new Reptile("Spectacled Caiman", "Brutus", "Trinidad", 45.0, "Healthy", false, 180.0);
        Reptile medusa = new Reptile("Green Anaconda", "Medusa", "Trinidad", 30.0, "Critical", false, 350.0);
        Marine atlas = new Marine("Leatherback Turtle", "Atlas", "Trinidad", 500.0, "Healthy", 1200.0, 8000);

        caroni.addAnimal(ruby);
        caroni.addAnimal(blaze);
        caroni.addAnimal(dusty);
        caroni.addAnimal(brutus);
        caroni.addAnimal(medusa);
        caroni.addAnimal(atlas);

        SanctuaryGUI gui = new SanctuaryGUI();
        gui.setModel(caroni);
        gui.setVisible(true);
    }
}
