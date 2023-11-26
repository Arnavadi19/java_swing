import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class TextEditor {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Text Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1150, 700);
        Border blackline = BorderFactory.createLineBorder(Color.black);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu reviewMenu = new JMenu("Review");
        JMenu helpMenu = new JMenu("Help");

        JMenuItem newFile = new JMenuItem("New");
        JMenuItem openFile = new JMenuItem("Open");
        JMenuItem saveFile = new JMenuItem("Save");
        JMenuItem saveAsFile = new JMenuItem("Save As");
        JMenuItem cutEdit = new JMenuItem("Cut");
        JMenuItem copyEdit = new JMenuItem("Copy");
        JMenuItem pasteEdit = new JMenuItem("Paste");
        JMenuItem spellCheckReview = new JMenuItem("Spell Check");
        JMenuItem aboutHelp = new JMenuItem("About");

        fileMenu.add(newFile);
        fileMenu.add(openFile);
        fileMenu.add(saveFile);
        fileMenu.add(saveAsFile);
        editMenu.add(cutEdit);
        editMenu.add(copyEdit);
        editMenu.add(pasteEdit);
        reviewMenu.add(spellCheckReview);
        helpMenu.add(aboutHelp);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(reviewMenu);
        menuBar.add(helpMenu);

        frame.setJMenuBar(menuBar);

        JPanel leftPanel = new JPanel(new BorderLayout());
        JPanel leftToolbar = new JPanel(new FlowLayout());
        JPanel leftLowerPanel = new JPanel(new FlowLayout());

        leftPanel.setBorder(blackline);

        ImageIcon leftIcon = new ImageIcon("leftAlign.jpg"); // Replace "left_icon.png" with the path to your left arrow icon image
        ImageIcon rightIcon = new ImageIcon("rightAlign.jpg"); // Replace "right_icon.png" with the path to your right arrow icon image
        ImageIcon centerIcon = new ImageIcon("centreAlign.jpg"); // Replace "center_icon.png" with the path to your center align icon image
        ImageIcon justifyIcon = new ImageIcon("justify.jpg"); // Replace "justify_icon.png" with the path to your justify icon image
        ImageIcon boldIcon = new ImageIcon("bold.jpg");
        ImageIcon italicIcon = new ImageIcon("italic.png");
        ImageIcon underlineIcon = new ImageIcon("underline.jpg");
        ImageIcon strikethroughIcon = new ImageIcon("strikethrough.jpg");
        Dimension buttonsize = new Dimension(25, 25);

        JButton button1 = new JButton(boldIcon);
        JButton button2 = new JButton(italicIcon);
        JButton button3 = new JButton(underlineIcon);
        JButton button4 = new JButton(strikethroughIcon);
        JButton button5 = new JButton(leftIcon);
        JButton button6 = new JButton(rightIcon);
        JButton button7 = new JButton(centerIcon);
        JButton button8 = new JButton(justifyIcon);



        button1.setPreferredSize(buttonsize);
        button2.setPreferredSize(buttonsize);
        button3.setPreferredSize(buttonsize);
        button4.setPreferredSize(buttonsize);
        button5.setPreferredSize(buttonsize);
        button6.setPreferredSize(buttonsize);
        button7.setPreferredSize(buttonsize);
        button8.setPreferredSize(buttonsize);

        String[] comboOptions = {"Arial", "Times New Roman", "Comic Sans MS", "Berlin Sans"};
        String[] fontSizes = {"5", "7", "9", "11", "14", "16", "20", "25", "30"};
        JComboBox<String> comboBox1 = new JComboBox<>(comboOptions);
        JComboBox<String> comboBox2 = new JComboBox<>(fontSizes);

        leftToolbar.add(button1);
        leftToolbar.add(button2);
        leftToolbar.add(button3);
        leftToolbar.add(button4);
        leftToolbar.add(button5);
        leftToolbar.add(button6);
        leftToolbar.add(button7);
        leftToolbar.add(button8);
        leftToolbar.add(comboBox1);
        leftToolbar.add(comboBox2);

        // Create JLabels and JTextFields for Find and Replace
        JLabel label1 = new JLabel("Find");
        JTextField textField1 = new JTextField(65); // Adjust the size
        JLabel label2 = new JLabel("Replace");
        JTextField textField2 = new JTextField(65); // Adjust the size

        // Create a toolbar with 4 JButtons for Find and Replace
        JPanel lowerToolbar = new JPanel();
        JButton lowerButton1 = new JButton("Find All");
        JButton lowerButton2 = new JButton("Find Next");
        JButton lowerButton3 = new JButton("Replace All");
        JButton lowerButton4 = new JButton("Replace Next");

        lowerToolbar.add(lowerButton1);
        lowerToolbar.add(lowerButton2);
        lowerToolbar.add(lowerButton3);
        lowerToolbar.add(lowerButton4);

        leftLowerPanel.add(label1);
        leftLowerPanel.add(textField1);
        leftLowerPanel.add(label2);
        leftLowerPanel.add(textField2);
        leftLowerPanel.add(lowerToolbar);

        JTextArea textArea = new JTextArea(); // Create a JTextArea
        textArea.setRows(10);
        textArea.setColumns(60);


        JTextPane bigTextAreaPanel = new JTextPane();
        bigTextAreaPanel.setPreferredSize(new Dimension(970, 850));


        leftPanel.add(leftToolbar, BorderLayout.NORTH);
        leftPanel.add(leftLowerPanel, BorderLayout.CENTER);
        leftPanel.add(bigTextAreaPanel, BorderLayout.SOUTH); // Add the big text area

        JTextArea sketchpad = new JTextArea();
        sketchpad.setBackground(new Color(204, 204, 204));
        sketchpad.setPreferredSize(new Dimension(280, 940));
        JButton sketchButton1 = new JButton("Rectangle");
        JButton sketchButton2 = new JButton("Oval");
        JButton sketchButton3 = new JButton("Line");
        JButton sketchButton4 = new JButton("Triangle");
        JButton sketchButton5 = new JButton("Pentagon");
        JButton sketchButton6 = new JButton("CLEAR");

        JPanel rightToolbar = new JPanel(new FlowLayout());
        rightToolbar.add(sketchButton1);
        rightToolbar.add(sketchButton2);
        rightToolbar.add(sketchButton3);
        rightToolbar.add(sketchButton4);
        rightToolbar.add(sketchButton5);
        rightToolbar.add(sketchButton6);

        JLabel sketch = new JLabel("Sketchpad", SwingConstants.CENTER);

        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.add(sketch, BorderLayout.NORTH);
        rightPanel.add(rightToolbar, BorderLayout.CENTER);
        rightPanel.add(new JScrollPane(sketchpad), BorderLayout.SOUTH);
        rightPanel.setBorder(blackline);

        frame.setLayout(new BorderLayout());

        JPanel footerPanel = new JPanel(new BorderLayout());
        JLabel label3 = new JLabel("Word Count:    ");
        JLabel label4 = new JLabel("Character Count:");
        footerPanel.add(label3, BorderLayout.WEST);
        footerPanel.add(label4, BorderLayout.CENTER);

        leftPanel.setPreferredSize(new Dimension(500, 700)); // Adjust the width as needed
        rightPanel.setPreferredSize(new Dimension(150, 700)); // Adjust the width as needed

        frame.add(leftPanel, BorderLayout.WEST);
        frame.add(rightPanel, BorderLayout.CENTER);
        frame.add(footerPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }}
