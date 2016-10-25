package com.Ben;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class PetSurvey extends JFrame
{
    // All the form objects, plus a few booleans for the checkbox values.
    private JPanel rootPanel;
    private JCheckBox catCheckBox;
    private JCheckBox dogCheckBox;
    private JCheckBox fishCheckBox;
    private JButton exitButton;
    private JLabel surveyResultsLabel;
    private boolean cat, dog, fish;

    PetSurvey()
    {
        // Create the form and display it. Set it so the app closes when the form closes.
        setContentPane(rootPanel);
        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        // Listeners for the checkboxes. If the box is checked or unchecked, update the result label.
        catCheckBox.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                cat = catCheckBox.isSelected();
                updateResults();
            }
        });

        dogCheckBox.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                dog = dogCheckBox.isSelected();
                updateResults();
            }
        });

        fishCheckBox.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                fish = fishCheckBox.isSelected();
                updateResults();
            }
        });

        // The exit button. Displays a dialog box to confirm that the user wants to exit.
        exitButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int quit = JOptionPane.showConfirmDialog(PetSurvey.this, "Are you sure you want to quit?", "Quit?",
                        JOptionPane.OK_CANCEL_OPTION);

                if (quit == JOptionPane.OK_OPTION)
                {
                    System.exit(0);
                }
            }
        });
    }

    // Update the results label based on the boolean values.
    private void updateResults()
    {
        String hasCat =   cat ? "a cat" : "no cats";
        String hasDog =   dog ? "a dog" : "no dogs";
        String hasFish = fish ? "a fish" : "no fish";

        // Build the result string and set the label.
        String results = "You have " + hasCat + ", " + hasDog + ", and " + hasFish;
        surveyResultsLabel.setText(results);
    }
}
