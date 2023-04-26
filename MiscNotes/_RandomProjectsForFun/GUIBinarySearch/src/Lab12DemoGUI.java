import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Lab12DemoGUI extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JTextField inputField;
    private JButton searchButton;
    private JPanel contentPane;

    private int[] array = {2, 6, 12, 14, 17, 19, 20, 23, 27, 29, 32, 37, 40, 42, 45};

    public Lab12DemoGUI() {
        super("Enter a number below to search the array: ");

        // Set up the main content pane
        contentPane = new JPanel(new BorderLayout());

        // Add the input field and search button to the content pane
        inputField = new JTextField();
        searchButton = new JButton("Search");
        searchButton.addActionListener(this);
        contentPane.add(inputField, BorderLayout.CENTER);
        contentPane.add(searchButton, BorderLayout.EAST);

        // Add the content pane to the window
        setContentPane(contentPane);

        // Set the window size
        setSize(450, 70);

        // Makes the window not resizable
        setResizable(false);

        // Center the window on the screen
        setLocationRelativeTo(null);

        // Sets the Icon of the GUI window, using an absolute filepath, since just using the name wasn't working.
        ImageIcon window_logo = new ImageIcon("C:/Users/isaac/repos/csci_132_spring2023/MiscNotes/_RandomProjectsForFun/GUIBinarySearch/src/bobcat.png");
        setIconImage(window_logo.getImage());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // Get the user input from the text field
        int num = Integer.parseInt(inputField.getText());

        // Perform the binary search on the array
        int answer = binary_search(array, num);

        // Display the result in a dialog box
        if (answer == -1) {
            JOptionPane.showMessageDialog(this, num + " not found in array.");
        } else {
            JOptionPane.showMessageDialog(this, num + " is located at index: " + answer);
        }
    }

    private static int binary_search(int[] array, int n) {
        int low = 0;
        int high = array.length - 1;

        while(low <= high) {
            int mid = (low + high) / 2;
            if (n == array[mid]) {
                return mid;
            } else if (n > array[mid]) {
                // Discard the left section
                low = mid +1;
            } else {
                // Discard the right section
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        new Lab12DemoGUI();
    }
}