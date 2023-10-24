package com.chrisreylo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Gui {

  private final JFrame frame;
  private final JPanel mainPanel;
  private final JTextField nameField;
  private final JTextField pathField;
  private final JTextField dataField; // New data text input
  private final JComboBox<String> fileTypeDropdown;
  private final JButton generateButton;
  LineBorder borderColor = new LineBorder(new Color(20, 21, 31));

  public Gui() {
    frame = new JFrame("File Generator");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 250);
    frame.setLayout(new BorderLayout());
    frame.setLocationRelativeTo(null);

    mainPanel = new JPanel();
    mainPanel.setBackground(new Color(40, 42, 58));
    mainPanel.setLayout(new GridBagLayout());

    GridBagConstraints constraints = new GridBagConstraints();
    constraints.fill = GridBagConstraints.HORIZONTAL;
    constraints.insets = new Insets(3, 5, 5, 5);

    // Create labels and text fields for Name, Path, and Data
    JLabel nameLabel = new JLabel("Name:");
    nameLabel.setForeground(Color.WHITE);
    nameField = new JTextField(25); // Adjust width as needed
    nameField.setPreferredSize(new Dimension(200, 30));
    nameField.setBackground(new Color(30, 31, 43));
    nameField.setForeground(Color.WHITE);
    nameField.setBorder(borderColor);

    JLabel dataLabel = new JLabel("Data:");
    dataLabel.setForeground(Color.WHITE);
    dataField = new JTextField(25);
    dataField.setPreferredSize(new Dimension(200, 30)); // Adjust width as needed
    dataField.setBackground(new Color(30, 31, 43));
    dataField.setForeground(Color.WHITE);
    dataField.setBorder(borderColor);

    JLabel pathLabel = new JLabel("Path:");
    pathLabel.setForeground(Color.WHITE);
    pathField = new JTextField(25); // Adjust width as needed
    pathField.setPreferredSize(new Dimension(200, 30));
    pathField.setBackground(new Color(30, 31, 43));
    pathField.setForeground(Color.WHITE);
    pathField.setBorder(borderColor);

    // Create a dropdown menu for selecting File Type
    JLabel fileTypeLabel = new JLabel("File Type:");
    fileTypeLabel.setForeground(Color.WHITE);
    String[] fileTypes = { "JPG", "PNG", "PDF" };
    fileTypeDropdown = new JComboBox<>(fileTypes);
    fileTypeDropdown.setPreferredSize(new Dimension(200, 30));
    fileTypeDropdown.setBackground(new Color(30, 31, 43));
    fileTypeDropdown.setForeground(Color.WHITE);
    fileTypeDropdown.setBorder(borderColor);

    // Create the "Generate" button
    generateButton = new JButton("Generate");
    generateButton.setBackground(new Color(30, 31, 43));
    generateButton.setPreferredSize(new Dimension(200, 30));
    generateButton.setForeground(Color.WHITE);
    generateButton.setBorder(borderColor);

    // Add components to the mainPanel with constraints
    constraints.gridx = 0;
    constraints.gridy = 0;
    mainPanel.add(nameLabel, constraints);

    constraints.gridx = 1;
    mainPanel.add(nameField, constraints);

    constraints.gridx = 0;
    constraints.gridy = 1;
    mainPanel.add(dataLabel, constraints);

    constraints.gridx = 1;
    mainPanel.add(dataField, constraints);

    constraints.gridx = 0;
    constraints.gridy = 2;
    mainPanel.add(pathLabel, constraints);

    constraints.gridx = 1;
    mainPanel.add(pathField, constraints);

    constraints.gridx = 0;
    constraints.gridy = 3;
    mainPanel.add(fileTypeLabel, constraints);

    constraints.gridx = 1;
    mainPanel.add(fileTypeDropdown, constraints);

    constraints.gridwidth = 2;
    constraints.gridx = 0;
    constraints.gridy = 4;
    mainPanel.add(generateButton, constraints);

    // Add an action listener to the "Generate" button
    generateButton.addActionListener(
      new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          String name = nameField.getText();
          String data = dataField.getText();
          String path = pathField.getText();
          String fileType = (String) fileTypeDropdown.getSelectedItem();
          // Add your file generation logic here
          System.out.println("Name: " + name);
          System.out.println("Data: " + data);
          System.out.println("Path: " + path);
          System.out.println("File Type: " + fileType);
        }
      }
    );

    frame.add(mainPanel, BorderLayout.CENTER);
    frame.setVisible(true);
  }
}
