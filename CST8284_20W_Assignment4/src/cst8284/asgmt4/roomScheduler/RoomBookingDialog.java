package cst8284.asgmt4.roomScheduler;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

/* Adapted, with considerable modification, from 
 * http://www.java2s.com/Code/Java/Swing-JFC/TextAcceleratorExample.htm,
 * which is sloppy code and should not be emulated.
 */

public class RoomBookingDialog {
	
	private static final GridBagConstraints labelConstraints = new GridBagConstraints(
    	0, GridBagConstraints.RELATIVE, 1, 1, 1, 1, 
    	GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 20), 0, 0);
	private static final GridBagConstraints textConstraints = new GridBagConstraints(
	    1, GridBagConstraints.RELATIVE, 1, 1, 1, 1,  // gridx, gridy, gridwidth, gridheight, weightx, weighty
	    GridBagConstraints.EAST, 0, new Insets(5, 5, 5, 10), 20, 20); // anchor, fill, insets, ipadx, ipady
	private static final GridBagConstraints btnConstraints = new GridBagConstraints(
	    0, GridBagConstraints.RELATIVE, 2, 1, 0.5, 0.5, 
	    GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 20), 0, 0);

	private static Panel cp = new Panel();
	private static final int labelWidth = 24;
	private static final Font defaultFont = new Font("SansSerif", Font.PLAIN, 20);	
	private static final FlowLayout btnRow = new FlowLayout();
	private static final JPanel btnPanel = new JPanel();
	
	public static void showAppointmentDialog(){
	    JFrame f = new JFrame("");  
	    cp.setLayout(new GridBagLayout());
	    
	    // Set the first seven rows with Label/TextField
	    setRow("Booking Date (YYYYMMDD):", 'e');
	    setRow("Booking Time (2 p.m. or 14:00):", 't');
	    setRow("Client Name (FirstName LastName):", 'n');
	    setRow("Phone Number (e.g. 613-555-1212):", 'p');
	    setRow("Organization (optional):", 'o');
	    setRow("Event Category:", 'c');
	    setRow("Description:", 'd');
	    
	    // Load the buttons across the bottom  
	    btnPanel.setLayout(btnRow);
	    setBtnRow("   Search   ", 'r');
	    setBtnRow("    Save    ", 's');
	    setBtnRow("   Delete   ", 'l');
	    setBtnRow("    Exit    ", 'x');
       
	    cp.add(btnPanel, btnConstraints);
	    f.add(cp); f.pack();
	    
	    // Close dialog
	    f.addWindowListener(new WindowAdapter() {
	       public void windowClosing(WindowEvent evt) {
	    	   f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	       }
	    });
	    
	    f.setVisible(true);
	  }
	
	private static JTextField setRow(String label, char keyboardShortcut) {
		JLabel l; JTextField t;
		cp.add(l = new JLabel(label, SwingConstants.RIGHT), labelConstraints);
		l.setFont(defaultFont);
		l.setDisplayedMnemonic(keyboardShortcut);
	    cp.add(t = new JTextField(labelWidth), textConstraints);
	    t.setFont(defaultFont);
	    t.setFocusAccelerator(keyboardShortcut);
	    return t;
	}
	
	private static JButton setBtnRow(String label, char keyboardShortcut) {
		JButton btn = new JButton(label);
		btn.setFont(defaultFont);
		btn.setMnemonic(keyboardShortcut);
		btnPanel.add(btn);
		return btn;
	}
	  
}
