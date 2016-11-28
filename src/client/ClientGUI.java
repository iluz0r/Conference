package client;

import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;

public class ClientGUI {

	private JFrame frmClientGui;
	private JTextField usernameTextField;
	private JPasswordField passwordTextField;
	private JLabel nameLabel;
	private JTextField nameTextField;
	private JLabel surnameLabel;
	private JTextField surnameTextField;
	private JTextField idPaperTextField;
	private JLabel idPaperLabel;
	private JLabel usernameLoginLabel;
	private JTextField textField;
	private JLabel passwordLoginLabel;
	private JPasswordField passwordLoginTextField;
	private JButton loginButton;
	private JPanel operationPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientGUI window = new ClientGUI();
					window.frmClientGui.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ClientGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmClientGui = new JFrame();
		frmClientGui.setTitle("Client GUI");
		frmClientGui.setBounds(100, 100, 684, 435);
		frmClientGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClientGui.getContentPane().setLayout(new MigLayout("", "[grow]", "[grow][grow][grow]"));
		
		JPanel registerPanel = new JPanel();
		registerPanel.setBorder(new TitledBorder(null, "Register", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		frmClientGui.getContentPane().add(registerPanel, "cell 0 0,grow");
		
		JLabel usernameLabel = new JLabel("Username:");
		
		usernameTextField = new JTextField();
		usernameTextField.setColumns(10);
		
		JLabel passwordLabel = new JLabel("Password:");
		
		passwordTextField = new JPasswordField();
		passwordTextField.setColumns(10);
		
		nameLabel = new JLabel("Name:");
		
		nameTextField = new JTextField();
		nameTextField.setColumns(10);
		
		surnameLabel = new JLabel("Surname:");
		
		surnameTextField = new JTextField();
		surnameTextField.setColumns(10);
		
		idPaperTextField = new JTextField();
		idPaperTextField.setColumns(10);
		
		idPaperLabel = new JLabel("Id paper:");
		
		JButton registerButton = new JButton("Register");
		GroupLayout gl_registerPanel = new GroupLayout(registerPanel);
		gl_registerPanel.setHorizontalGroup(
			gl_registerPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_registerPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_registerPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_registerPanel.createSequentialGroup()
							.addComponent(registerButton, GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_registerPanel.createSequentialGroup()
							.addGroup(gl_registerPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(usernameLabel)
								.addComponent(nameLabel)
								.addComponent(idPaperLabel))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_registerPanel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_registerPanel.createSequentialGroup()
									.addComponent(idPaperTextField, GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
									.addContainerGap())
								.addGroup(gl_registerPanel.createSequentialGroup()
									.addGroup(gl_registerPanel.createParallelGroup(Alignment.TRAILING)
										.addComponent(usernameTextField, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
										.addComponent(nameTextField, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE))
									.addGap(18)
									.addGroup(gl_registerPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(passwordLabel)
										.addComponent(surnameLabel))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_registerPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(surnameTextField, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
										.addComponent(passwordTextField, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
									.addGap(12))))))
		);
		gl_registerPanel.setVerticalGroup(
			gl_registerPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_registerPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_registerPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(usernameLabel)
						.addComponent(usernameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordLabel)
						.addComponent(passwordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_registerPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(nameLabel)
						.addComponent(surnameLabel)
						.addComponent(surnameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_registerPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(idPaperTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(idPaperLabel))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(registerButton, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(174, Short.MAX_VALUE))
		);
		registerPanel.setLayout(gl_registerPanel);
		
		JPanel loginPanel = new JPanel();
		loginPanel.setBorder(new TitledBorder(null, "Login", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		frmClientGui.getContentPane().add(loginPanel, "cell 0 1,grow");
		
		usernameLoginLabel = new JLabel("Username:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		passwordLoginLabel = new JLabel("Password:");
		
		passwordLoginTextField = new JPasswordField();
		passwordLoginTextField.setColumns(10);
		
		loginButton = new JButton("Login");
		GroupLayout gl_loginPanel = new GroupLayout(loginPanel);
		gl_loginPanel.setHorizontalGroup(
			gl_loginPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_loginPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_loginPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_loginPanel.createSequentialGroup()
							.addComponent(usernameLoginLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(passwordLoginLabel)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(passwordLoginTextField, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE))
						.addComponent(loginButton, GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_loginPanel.setVerticalGroup(
			gl_loginPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_loginPanel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_loginPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(usernameLoginLabel)
						.addComponent(passwordLoginLabel)
						.addComponent(passwordLoginTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(loginButton)
					.addContainerGap())
		);
		loginPanel.setLayout(gl_loginPanel);
		
		operationPanel = new JPanel();
		operationPanel.setBorder(new TitledBorder(null, "Operations", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		frmClientGui.getContentPane().add(operationPanel, "cell 0 2,grow");
		
		JButton myPaperButton = new JButton("My paper");
		GroupLayout gl_operationPanel = new GroupLayout(operationPanel);
		gl_operationPanel.setHorizontalGroup(
			gl_operationPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_operationPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(myPaperButton, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(515, Short.MAX_VALUE))
		);
		gl_operationPanel.setVerticalGroup(
			gl_operationPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_operationPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(myPaperButton)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		operationPanel.setLayout(gl_operationPanel);
	}
}
