package hibernateTest.dto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.FlowLayout;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import java.awt.Color;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import javax.swing.JTabbedPane;
import javax.swing.border.BevelBorder;


public class UI {

	private JFrame frmInventorySoft;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI window = new UI();
					window.frmInventorySoft.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInventorySoft = new JFrame();
		frmInventorySoft.setBackground(SystemColor.activeCaptionBorder);
		frmInventorySoft.setTitle("Inventory Soft");
		frmInventorySoft.setBounds(100, 100, 450, 300);
		frmInventorySoft.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInventorySoft.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(21, 50, 86, 14);
		frmInventorySoft.getContentPane().add(lblNewLabel);
		
		JLabel lblInventorySoft = new JLabel("Inventory soft");
		lblInventorySoft.setBounds(151, 11, 121, 25);
		lblInventorySoft.setToolTipText("Software made by Dinindu Kanchana");
		lblInventorySoft.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		frmInventorySoft.getContentPane().add(lblInventorySoft);
		
		JLabel lblProductName = new JLabel("NAME");
		lblProductName.setBounds(21, 75, 86, 14);
		frmInventorySoft.getContentPane().add(lblProductName);
		
		JLabel lblPrice = new JLabel("PRICE");
		lblPrice.setBounds(21, 100, 46, 14);
		frmInventorySoft.getContentPane().add(lblPrice);
		
		JLabel lblCatogory = new JLabel("CATOGORY");
		lblCatogory.setBounds(21, 125, 86, 14);
		frmInventorySoft.getContentPane().add(lblCatogory);
		
		textField = new JTextField();
		textField.setBounds(161, 47, 86, 20);
		frmInventorySoft.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(161, 72, 86, 20);
		frmInventorySoft.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(161, 97, 86, 20);
		frmInventorySoft.getContentPane().add(textField_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Food", "Fish", "Medicine", "Other"}));
		comboBox.setBounds(160, 122, 87, 20);
		frmInventorySoft.getContentPane().add(comboBox);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addMouseListener(new MouseAdapter() {
			/* (non-Javadoc)
			 * @see java.awt.event.MouseAdapter#mouseClicked(java.awt.event.MouseEvent)
			 */
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("button clicked ");
				int id = Integer.parseInt(textField.getText());
				String name = textField_1.getText();
				int price = Integer.parseInt(textField_2.getText());
				String catogory = (String) comboBox.getSelectedItem();
				System.out.println(id+" "+name+" "+price+" "+catogory);
				HibernateTest hbr = new HibernateTest();
				
				hbr.saveDb(id,name,price,catogory);
				
				
				
				
			}
		});
		btnSubmit.setForeground(Color.BLUE);
		btnSubmit.setBounds(183, 153, 89, 23);
		frmInventorySoft.getContentPane().add(btnSubmit);
		
		JMenuBar menuBar = new JMenuBar();
		frmInventorySoft.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
