package com.rhodso.ds_bingo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author rhodso
 */
public class bingoForm extends javax.swing.JFrame {
    private javax.swing.JButton buttonArray[];
    private int buttonState[];

    public String[] getLines(String _fp){
        String[] res = null;
        ArrayList<String> lines = new ArrayList<>(0);

        try(BufferedReader br = new BufferedReader(new FileReader(new File(_fp)))){
            //Create var to hold the lines
            String line;

            //Read lines
            while( (line = br.readLine()) != null){
                lines.add(line);
            }

            br.close(); //If there's an error before this, it'll cause a memory leak. Too Bad!
        } catch(Exception e){
            System.err.println("Exception occured!\nWhen: reading the bingo lines\n" + e.getMessage() + "\n" + e.getStackTrace());
        }

        //Convert to array
        res = lines.toArray(new String[lines.size()]);
        return res;
    }
    
    /**
     * Creates new form bingoForm
     */
    public bingoForm() {
        //Set icon
        Image icon = Toolkit.getDefaultToolkit().getImage("sources/icon.png");
        setIconImage(icon);

        // Setup button arrays
        buttonArray = new javax.swing.JButton[26];
        buttonState = new int[26];

        initComponents();

        for (int i = 1; i < buttonArray.length; i++) {
            buttonArray[i].addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    incrementButtonState((JButton) evt.getSource());
                }
            });
        }

        // Set states
        for (int i = 1; i < buttonArray.length; i++) {
            buttonArray[i].setMaximumSize(new Dimension(100, 100));
            setButtonState(i);
        }

        // Get button text
        String lines[] = {""};

        // Get list
        ArrayList<String> tmp = new ArrayList<>();
        String[] l = bingoLines.getLines();

        // Shuffle and convert
        for (String s : l) {
            tmp.add(s);
        }
        Collections.shuffle(tmp);
        lines = new String[tmp.size()];
        for (int i = 0; i < tmp.size(); i++) {
            lines[i] = tmp.get(i);
        }

        // I wanted to do this with a text file but it wasn't
        // working very well

        // Set text
        Font f = buttonArray[1].getFont();
        for (int i = 1; i < buttonArray.length; i++) {

            String buttonText = "<html><center>";

            if (i == 13) {
                buttonText += "Free Space";
            } else {
                buttonText += lines[i];
            }

            if (lines[i].length() > 25) {
                buttonArray[i].setFont(new Font(f.getName(), f.getStyle(), 14));
            } else {
                buttonArray[i].setFont(new Font(f.getName(), f.getStyle(), 18));
            }

            buttonText += "</center></html>";
            buttonArray[i].setText(buttonText);
        }

        // Change closing animation
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Change state of button
    // 0 - Set the button colour scheme to White background, Black text
    // 1 - Set the button colour scheme to Green background, Black text
    // 2 - Set the button colour scheme to Red background, White text
    void setButtonState(int idx) {
        // Set button colours
        switch (buttonState[idx]) {
            case 0:
                buttonArray[idx].setBackground(Color.WHITE);
                buttonArray[idx].setForeground(Color.BLACK);
                break;
            case 1:
                buttonArray[idx].setBackground(Color.GREEN);
                buttonArray[idx].setForeground(Color.BLACK);
                break;
            case 2:
                buttonArray[idx].setBackground(Color.RED);
                buttonArray[idx].setForeground(Color.WHITE);
                break;
        }
    }

    // Increment the state of the button
    void incrementButtonState(JButton _sender) {

        // Get index of button in the array
        int idx = 0;
        for (JButton b : buttonArray) {
            if (b == _sender) {
                break;
            } else {
                idx++;
            }
        }

        // Increment but not over 4
        if (buttonState[idx] == 2) {
            buttonState[idx] = 0;
        } else {
            buttonState[idx]++;
        }

        // Set state
        setButtonState(idx);
    }

    // UI vars
    private javax.swing.JPanel bingoPanel;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JScrollPane mainScrollPanel;
    private javax.swing.JLabel subheaderLabel;
    private javax.swing.JLabel taglineLabel;

    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        mainScrollPanel = new javax.swing.JScrollPane();
        mainPanel = new javax.swing.JPanel();
        headerPanel = new javax.swing.JPanel();
        headerLabel = new javax.swing.JLabel();
        subheaderLabel = new javax.swing.JLabel();
        taglineLabel = new javax.swing.JLabel();
        bingoPanel = new javax.swing.JPanel();
        buttonArray[1] = new javax.swing.JButton();
        buttonArray[2] = new javax.swing.JButton();
        buttonArray[3] = new javax.swing.JButton();
        buttonArray[4] = new javax.swing.JButton();
        buttonArray[5] = new javax.swing.JButton();
        buttonArray[6] = new javax.swing.JButton();
        buttonArray[7] = new javax.swing.JButton();
        buttonArray[8] = new javax.swing.JButton();
        buttonArray[9] = new javax.swing.JButton();
        buttonArray[10] = new javax.swing.JButton();
        buttonArray[11] = new javax.swing.JButton();
        buttonArray[12] = new javax.swing.JButton();
        buttonArray[13] = new javax.swing.JButton();
        buttonArray[14] = new javax.swing.JButton();
        buttonArray[15] = new javax.swing.JButton();
        buttonArray[16] = new javax.swing.JButton();
        buttonArray[17] = new javax.swing.JButton();
        buttonArray[18] = new javax.swing.JButton();
        buttonArray[19] = new javax.swing.JButton();
        buttonArray[20] = new javax.swing.JButton();
        buttonArray[21] = new javax.swing.JButton();
        buttonArray[22] = new javax.swing.JButton();
        buttonArray[23] = new javax.swing.JButton();
        buttonArray[24] = new javax.swing.JButton();
        buttonArray[25] = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        headerLabel.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        headerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerLabel.setText("Richard Plays Dark Souls");

        subheaderLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        subheaderLabel.setText("Bingo");

        taglineLabel.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        taglineLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        taglineLabel.setText("Pain");

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(headerPanelLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(headerPanelLayout.createSequentialGroup().addContainerGap()
                        .addGroup(headerPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(headerLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(headerPanelLayout.createSequentialGroup()
                                        .addComponent(subheaderLabel,
                                                javax.swing.GroupLayout.PREFERRED_SIZE, 309,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(
                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(taglineLabel,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                        .addContainerGap()))));
        headerPanelLayout.setVerticalGroup(headerPanelLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(headerPanelLayout.createSequentialGroup().addContainerGap()
                        .addComponent(headerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(headerPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(subheaderLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        41, Short.MAX_VALUE)
                                .addComponent(taglineLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap()));

        java.awt.GridBagLayout jPanel3Layout = new java.awt.GridBagLayout();
        jPanel3Layout.columnWidths = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0};
        jPanel3Layout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0};
        bingoPanel.setLayout(jPanel3Layout);

        buttonArray[1].setText("1");
        buttonArray[1].setMaximumSize(new java.awt.Dimension(100, 24));
        buttonArray[1].setPreferredSize(new java.awt.Dimension(125, 125));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        bingoPanel.add(buttonArray[1], gridBagConstraints);

        buttonArray[2].setText("2");
        buttonArray[2].setPreferredSize(new java.awt.Dimension(125, 125));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        bingoPanel.add(buttonArray[2], gridBagConstraints);

        buttonArray[3].setText("3");
        buttonArray[3].setPreferredSize(new java.awt.Dimension(125, 125));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        bingoPanel.add(buttonArray[3], gridBagConstraints);

        buttonArray[4].setText("4");
        buttonArray[4].setPreferredSize(new java.awt.Dimension(125, 125));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        bingoPanel.add(buttonArray[4], gridBagConstraints);

        buttonArray[5].setText("5");
        buttonArray[5].setPreferredSize(new java.awt.Dimension(125, 125));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        bingoPanel.add(buttonArray[5], gridBagConstraints);

        buttonArray[6].setText("6");
        buttonArray[6].setPreferredSize(new java.awt.Dimension(125, 125));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        bingoPanel.add(buttonArray[6], gridBagConstraints);

        buttonArray[7].setText("7");
        buttonArray[7].setPreferredSize(new java.awt.Dimension(125, 125));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        bingoPanel.add(buttonArray[7], gridBagConstraints);

        buttonArray[8].setText("8");
        buttonArray[8].setPreferredSize(new java.awt.Dimension(125, 125));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        bingoPanel.add(buttonArray[8], gridBagConstraints);

        buttonArray[9].setText("9");
        buttonArray[9].setPreferredSize(new java.awt.Dimension(125, 125));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        bingoPanel.add(buttonArray[9], gridBagConstraints);

        buttonArray[10].setText("10");
        buttonArray[10].setPreferredSize(new java.awt.Dimension(125, 125));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 2;
        bingoPanel.add(buttonArray[10], gridBagConstraints);

        buttonArray[11].setText("11");
        buttonArray[11].setPreferredSize(new java.awt.Dimension(125, 125));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        bingoPanel.add(buttonArray[11], gridBagConstraints);

        buttonArray[12].setText("12");
        buttonArray[12].setPreferredSize(new java.awt.Dimension(125, 125));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        bingoPanel.add(buttonArray[12], gridBagConstraints);

        buttonArray[13].setText("13");
        buttonArray[13].setPreferredSize(new java.awt.Dimension(125, 125));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        bingoPanel.add(buttonArray[13], gridBagConstraints);

        buttonArray[14].setText("14");
        buttonArray[14].setPreferredSize(new java.awt.Dimension(125, 125));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 4;
        bingoPanel.add(buttonArray[14], gridBagConstraints);

        buttonArray[15].setText("15");
        buttonArray[15].setPreferredSize(new java.awt.Dimension(125, 125));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 4;
        bingoPanel.add(buttonArray[15], gridBagConstraints);

        buttonArray[16].setText("16");
        buttonArray[16].setPreferredSize(new java.awt.Dimension(125, 125));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        bingoPanel.add(buttonArray[16], gridBagConstraints);

        buttonArray[17].setText("17");
        buttonArray[17].setPreferredSize(new java.awt.Dimension(125, 125));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        bingoPanel.add(buttonArray[17], gridBagConstraints);

        buttonArray[18].setText("18]");
        buttonArray[18].setPreferredSize(new java.awt.Dimension(125, 125));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        bingoPanel.add(buttonArray[18], gridBagConstraints);

        buttonArray[19].setText("19]");
        buttonArray[19].setPreferredSize(new java.awt.Dimension(125, 125));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 6;
        bingoPanel.add(buttonArray[19], gridBagConstraints);

        buttonArray[20].setText("20]");
        buttonArray[20].setPreferredSize(new java.awt.Dimension(125, 125));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 6;
        bingoPanel.add(buttonArray[20], gridBagConstraints);

        buttonArray[21].setText("21]");
        buttonArray[21].setPreferredSize(new java.awt.Dimension(125, 125));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        bingoPanel.add(buttonArray[21], gridBagConstraints);

        buttonArray[22].setText("22]");
        buttonArray[22].setPreferredSize(new java.awt.Dimension(125, 125));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        bingoPanel.add(buttonArray[22], gridBagConstraints);

        buttonArray[23].setText("23]");
        buttonArray[23].setPreferredSize(new java.awt.Dimension(125, 125));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        bingoPanel.add(buttonArray[23], gridBagConstraints);

        buttonArray[24].setText("24]");
        buttonArray[24].setPreferredSize(new java.awt.Dimension(125, 125));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 8;
        bingoPanel.add(buttonArray[24], gridBagConstraints);

        buttonArray[25].setText("25]");
        buttonArray[25].setPreferredSize(new java.awt.Dimension(125, 125));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 8;
        bingoPanel.add(buttonArray[25], gridBagConstraints);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(mainPanelLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout
                        .createSequentialGroup().addContainerGap()
                        .addGroup(mainPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(bingoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 668,
                                        Short.MAX_VALUE)
                                .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap()));
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup().addContainerGap()
                                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18).addComponent(bingoPanel,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
                                .addContainerGap()));

        mainScrollPanel.setViewportView(mainPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mainScrollPanel));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mainScrollPanel));

        pack();
    }
}
