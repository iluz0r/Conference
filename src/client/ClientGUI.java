package client;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.xml.ws.wsaddressing.W3CEndpointReference;
import net.miginfocom.swing.MigLayout;
import stub.Admin;
import stub.AdminService;
import stub.Conference;
import stub.ConferenceService;
import stub.Participant;
import stub.ParticipantBean;
import stub.ParticipantService;

import javax.swing.JButton;
import javax.swing.JTabbedPane;

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
	private JTextField usernameLoginTextField;
	private JLabel passwordLoginLabel;
	private JPasswordField passwordLoginTextField;
	private JButton registerButton;
	private JButton loginButton;
	private JButton myPaperButton;	
	private JButton getAllPaperButton;	
	private JButton registerStateButton;
	private JPanel operationPanel;
	private ConferenceService conferenceService;
	private Conference conference;
	private ParticipantService participantService;
	private AdminService adminService;
	private Admin admin;
	private Participant user;
	private W3CEndpointReference ref;

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
		conferenceService = new ConferenceService();
		conference = (Conference) conferenceService.getPort(Conference.class);
		participantService = new ParticipantService();
		adminService = new AdminService();

		admin = null;
		user = null;
		ref = null;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmClientGui = new JFrame();
		frmClientGui.setTitle("Client GUI");
		frmClientGui.setBounds(100, 100, 684, 288);
		frmClientGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClientGui.getContentPane().setLayout(new MigLayout("", "[grow]", "[grow][grow]"));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmClientGui.getContentPane().add(tabbedPane, "cell 0 0,grow");
		
		JPanel registerPanel = new JPanel();
		tabbedPane.addTab("Register", null, registerPanel, null);
		registerPanel.setBorder(new TitledBorder(null, "Register", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
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
		
		registerButton = new JButton("Register");
		registerButton.addActionListener(new registerButtonListener());
		
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
		tabbedPane.addTab("Login", null, loginPanel, null);
		loginPanel.setBorder(new TitledBorder(null, "Login", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		usernameLoginLabel = new JLabel("Username:");
		
		usernameLoginTextField = new JTextField();
		usernameLoginTextField.setColumns(10);
		
		passwordLoginLabel = new JLabel("Password:");
		
		passwordLoginTextField = new JPasswordField();
		passwordLoginTextField.setColumns(10);
		
		loginButton = new JButton("Login");
		loginButton.addActionListener(new loginButtonListener());
		
		GroupLayout gl_loginPanel = new GroupLayout(loginPanel);
		gl_loginPanel.setHorizontalGroup(
			gl_loginPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_loginPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_loginPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_loginPanel.createSequentialGroup()
							.addComponent(usernameLoginLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(usernameLoginTextField, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(passwordLoginLabel)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(passwordLoginTextField, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE))
						.addComponent(loginButton, GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_loginPanel.setVerticalGroup(
			gl_loginPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_loginPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_loginPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(usernameLoginTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(usernameLoginLabel)
						.addComponent(passwordLoginLabel)
						.addComponent(passwordLoginTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(loginButton)
					.addContainerGap(194, Short.MAX_VALUE))
		);
		loginPanel.setLayout(gl_loginPanel);
		
		operationPanel = new JPanel();
		tabbedPane.addTab("Operations", null, operationPanel, null);
		operationPanel.setBorder(new TitledBorder(null, "Operations", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		myPaperButton = new JButton("My paper");
		myPaperButton.addActionListener(new myPaperButtonListener());
		
		getAllPaperButton = new JButton("Get all paper");
		getAllPaperButton.addActionListener(new getAllPaperButtonListener());
		
		registerStateButton = new JButton("Register state");
		registerStateButton.addActionListener(new registerStateButtonListener());
		
		GroupLayout gl_operationPanel = new GroupLayout(operationPanel);
		gl_operationPanel.setHorizontalGroup(
			gl_operationPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_operationPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(myPaperButton, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
					.addGap(134)
					.addComponent(getAllPaperButton, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
					.addComponent(registerStateButton, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_operationPanel.setVerticalGroup(
			gl_operationPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_operationPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_operationPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(myPaperButton)
						.addComponent(registerStateButton)
						.addComponent(getAllPaperButton))
					.addContainerGap(32, Short.MAX_VALUE))
		);
		operationPanel.setLayout(gl_operationPanel);
	}
	
	private class registerButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				String username=usernameTextField.getText();
				String password=String.valueOf(passwordTextField.getPassword());
				String name=nameTextField.getText();
				String surname=surnameTextField.getText();
				String idPaper=idPaperTextField.getText();
				conference.register(username, password, name, surname, idPaper);
			} catch (RuntimeException e) {
				System.err.println(e.getMessage());
			}
		}
	}
	
	private class loginButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				String username = usernameLoginTextField.getText();				
				String password=String.valueOf(passwordLoginTextField.getPassword());
				ref = conference.login(username, password);
				
				if(!username.equals("admin")&&!password.equals("admin")){					
					user = participantService.getPort(ref, Participant.class);
					System.out.println("User " + user.getUsername() + " with id paper " + user.getIdPaper() + " logged in.");
				}else{					
					admin = adminService.getPort(ref, Admin.class);
					System.out.println("Logged in as " + admin.getUsername());
				}
				
			} catch (RuntimeException e) {
				System.err.println(e.getMessage());
			}
		}
	}
	
	private class myPaperButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				System.out.println(user.getIdPaper());
			} catch (RuntimeException e) {
				System.err.println(e.getMessage());
			}
		}
	}
	
	private class getAllPaperButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				List<String> idPaperList = conference.getAllIdPapers(ref);
				System.out.println("\nPapers list:");
				for (String idPaper : idPaperList) 
					System.out.println("- " + idPaper);
			} catch (RuntimeException e) {
				System.err.println(e.getMessage());
			}
		}
	}
	
	private class registerStateButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				List<ParticipantBean> participantList = conference.getAllParticipants(ref);
				System.out.println("\nUsers list:");
				for (ParticipantBean participant : participantList) 
					System.out.println("- " + participant.getUsername());
			} catch (RuntimeException e) {
				System.err.println(e.getMessage());
			}
		}
	}
}
