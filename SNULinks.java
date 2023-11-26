import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SNULinks extends JFrame {
    public SNULinks() {
        setTitle("SNU Links Replica");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createHeaderPanel();
        createContentPanel();
        createFooterPanel();

        setVisible(true);
    }
    private void createHeaderPanel() {
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(0, 81, 155)); // Background color changed to RGB(0, 81, 155)
        headerPanel.setPreferredSize(new Dimension(800, 100));

        // Use GridBagLayout for precise control within the headerPanel
        GridBagLayout layout = new GridBagLayout();
        headerPanel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();

        // Shiv Nadar University logo (placeholder)
        ImageIcon snuLogo = new ImageIcon("Logo.jpg"); // Replace with your logo
        Image scaledImage = snuLogo.getImage().getScaledInstance(180, 63, Image.SCALE_SMOOTH);
        snuLogo = new ImageIcon(scaledImage);
        JLabel logoLabel = new JLabel(snuLogo);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST; // Align to the left
        gbc.insets = new Insets(0, 0, 0, 300); // Add insets for logo
        headerPanel.add(logoLabel, gbc);

        // Create a panel to group the search bar and the attached image
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new BorderLayout());

        // Search bar (placeholder) with "Search" watermark
        JTextField searchBar = new JTextField("Search", 20);
        searchBar.setPreferredSize(new Dimension(194, 31));

        // Attached image
        ImageIcon attachedImage = new ImageIcon("Mag.jpg"); // Replace with your image
        Image scaledAttachedImage = attachedImage.getImage().getScaledInstance(31, 31, Image.SCALE_SMOOTH);
        attachedImage = new ImageIcon(scaledAttachedImage);
        JLabel attachedImageLabel = new JLabel(attachedImage);

        // Add the search bar and the attached image to the searchPanel
        searchPanel.add(searchBar, BorderLayout.CENTER);
        searchPanel.add(attachedImageLabel, BorderLayout.WEST);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 0, 350); // Add insets to center the search bar and create a space
        gbc.anchor = GridBagConstraints.CENTER;
        headerPanel.add(searchPanel, gbc);

        // Hi, username button at the extreme right of the headerPanel with a dropdown menu
        JButton userButton = new JButton("Hi Arnav Aditya ▼");
        userButton.setBackground(new Color(0, 81, 155));
        userButton.setForeground(Color.WHITE);
        userButton.setBorder(BorderFactory.createEmptyBorder());
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(0, 10, 0, 0); // Add insets for Hi, Username
        headerPanel.add(userButton, gbc);

        // Add a dropdown menu to the Hi, Username button
        userButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show a dropdown menu with options
                JPopupMenu popupMenu = new JPopupMenu();
                popupMenu.add(new JMenuItem("Logout"));
                popupMenu.add(new JMenuItem("Forgot Password"));
                popupMenu.add(new JMenuItem("Change/Reset Password"));
                popupMenu.addSeparator(); // Add a separator line
                popupMenu.add(new JMenuItem("IT Helpdesk"));
                popupMenu.add(new JMenuItem("How to Login"));
                popupMenu.show(userButton, 0, userButton.getHeight());
            }
        });

        add(headerPanel, BorderLayout.NORTH);
    }

    private void createContentPanel() {
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 25, 20));

        String[] rectangleNames = {
                "University ERP", "Assistantship/Award", "Blackboard", "CCT", "Certificate Issuance",
                "Course Evaluation Survey", "Doctoral Portal", "Fastrack", "Hostel Management", "ID Card Management",
                "Mobile App CMS", "On Campus Job", "Student Outbound Mobility", "Student Attendance Recording",
                "Student Attendance Management", "Student Clearance", "Student Payment Center"
        };

        String[] imagePaths = {
                "Uni_ERP.jpg", "Assistantship.jpg", "Blackboard.jpg", "CCT.jpg", "Certificate.jpg",
                "CES.jpg", "DP.jpg", "Fastrack.jpg", "HM.jpg", "IDCM.jpg",
                "Mobile.jpg", "OCJ.jpg", "SOM.jpg", "SAR.jpg", "SAM.jpg", "SC.jpg", "SPC.jpg"
        };

        Font customFont = new Font("Times New Roman", Font.PLAIN, 12);

        for (int i = 0; i < rectangleNames.length; i++) {
            JPanel box = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    int width = getWidth() - 1;
                    int height = getHeight() - 1;
                    int cornerRadius = 10;

                    Graphics2D graphics = (Graphics2D) g;
                    graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                    graphics.setColor(getBackground());
                    graphics.fillRoundRect(0, 0, width, height, cornerRadius, cornerRadius);
                }
            };

            box.setLayout(new BorderLayout());

            if (rectangleNames[i].equals("University ERP")) {
                box.setBackground(new Color(0, 81, 155));
            } else {
                box.setBackground(Color.WHITE);
            }

            box.setPreferredSize(new Dimension(170, 47));
            box.setBorder(BorderFactory.createLineBorder(new Color(0, 81, 155)));

            JLabel label = new JLabel(rectangleNames[i]);

            if (rectangleNames[i].equals("University ERP")) {
                label.setForeground(Color.WHITE);
            }

            label.setFont(customFont);

            ImageIcon originalImage = new ImageIcon(imagePaths[i]);
            Image image = originalImage.getImage();
            Image scaledImage = image.getScaledInstance(50, 46, Image.SCALE_SMOOTH);
            ImageIcon resizedImage = new ImageIcon(scaledImage);
            JLabel imageLabel = new JLabel(resizedImage);

            box.add(imageLabel, BorderLayout.WEST);
            box.add(label, BorderLayout.CENTER);

            box.setCursor(new Cursor(Cursor.HAND_CURSOR));

            final int index = i;

            box.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    JOptionPane.showMessageDialog(SNULinks.this,  rectangleNames[index] + " button clicked. " );
                }
            });

            contentPanel.add(box);
        }

        add(contentPanel, BorderLayout.CENTER);
    }


    private void createFooterPanel() {
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(Color.BLACK);
        footerPanel.setLayout(new BorderLayout());
        footerPanel.setPreferredSize(new Dimension(800, 140));

        // Custom font for the labels
        Font customFont = new Font("Product Sans", Font.PLAIN, 12);

        // Part 1: Student Policy, Student Handbook, etc.
        JPanel part1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 70, 20));
        part1.setBackground(Color.BLACK);

        String[] links = {"Student Policy", "Student Handbook", "Academic Research", "University Library", "Mess Menu", "NetID Help"};

        // Define image paths corresponding to the links
        String[] imagePaths = {"policy.png", "handbook.png", "research.png", "library.png", "menu.png", "netid.png"};

        for (int i = 0; i < links.length; i++) {
            final int index = i; // Declare final variable to access it within the anonymous inner class
            JPanel linkPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            linkPanel.setBackground(Color.BLACK);

            // Create an image label with a size of 32x32 pixels
            JLabel imageLabel = new JLabel(new ImageIcon(new ImageIcon(imagePaths[i]).getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT)));
            linkPanel.add(imageLabel);

            // Create a label for the link text with custom font and underline style
            JLabel linkLabel = new JLabel("<html><u>" + links[i] + "</u></html>");
            linkLabel.setForeground(Color.WHITE);
            linkLabel.setFont(customFont);
            linkLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
            linkLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    JOptionPane.showMessageDialog(SNULinks.this, "Clicked on " + links[index]);
                }
            });

            linkPanel.add(linkLabel);
            part1.add(linkPanel);
        }

        footerPanel.add(part1, BorderLayout.NORTH);

        // Separator (thicker white line)
        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setForeground(Color.CYAN); // Set the separator color explicitly
        separator.setPreferredSize(new Dimension(800, 25)); // Thicker white line
        part1.add(separator);

        // Part 2: Copyright notice
        JPanel part2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        part2.setBackground(Color.BLACK);
        JLabel copyrightLabel = new JLabel("<html><u>2023 - SNU (Institute of Eminence Deemed to be University)</u></html>");
        copyrightLabel.setForeground(Color.WHITE);
        copyrightLabel.setFont(customFont);
        part2.add(copyrightLabel);

        footerPanel.add(part2, BorderLayout.CENTER);

        add(footerPanel, BorderLayout.SOUTH);
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SNULinks());
    }
}