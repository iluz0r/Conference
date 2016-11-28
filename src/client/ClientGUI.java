package client;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
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

public class ClientGUI {

	private JFrame frame;
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
	private JButton getAllParticipantsButton;
	private JPanel operationPanel;
	private JPanel loginPanel;
	private JTabbedPane tabbedPane;
	private JPanel registerPanel;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private Conference conference;
	private W3CEndpointReference ref;
	private Participant participant;
	private Admin admin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientGUI window = new ClientGUI();
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setTitle("Client GUI");
		frame.setBounds(100, 100, 431, 231);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow]", "[grow][grow]"));

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, "cell 0 0 1 2,grow");

		loginPanel = new JPanel();
		tabbedPane.addTab("Login", null, loginPanel, null);
		loginPanel.setBorder(new TitledBorder(null, "Login", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		usernameLoginLabel = new JLabel("Username:");

		passwordLoginLabel = new JLabel("Password:");
		loginPanel.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[grow][grow]"));
		loginPanel.add(usernameLoginLabel, "cell 0 0,growx");

		usernameLoginTextField = new JTextField();
		usernameLoginTextField.setColumns(10);
		loginPanel.add(usernameLoginTextField, "cell 1 0,growx");
		loginPanel.add(passwordLoginLabel, "cell 3 0,growx");

		loginButton = new JButton("Login");
		loginButton.addActionListener(new LoginButtonListener());

		passwordLoginTextField = new JPasswordField();
		passwordLoginTextField.setColumns(10);
		loginPanel.add(passwordLoginTextField, "cell 4 0,growx");
		loginPanel.add(loginButton, "cell 0 1 5 1,growx");

		registerPanel = new JPanel();
		tabbedPane.addTab("Register", null, registerPanel, null);
		registerPanel.setBorder(new TitledBorder(null, "Register", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		usernameLabel = new JLabel("Username:");

		usernameTextField = new JTextField();
		usernameTextField.setColumns(10);

		passwordLabel = new JLabel("Password:");

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
		registerPanel.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[grow][grow][grow][grow]"));
		registerPanel.add(usernameLabel, "cell 0 0,alignx left");
		registerPanel.add(nameLabel, "cell 0 1,alignx left");
		registerPanel.add(idPaperLabel, "cell 0 2,alignx left");
		registerPanel.add(idPaperTextField, "cell 1 2,growx");
		registerPanel.add(usernameTextField, "cell 1 0,growx");
		registerPanel.add(nameTextField, "cell 1 1,growx");
		registerPanel.add(passwordLabel, "cell 3 0,alignx left");
		registerPanel.add(surnameLabel, "cell 3 1,alignx left");
		registerPanel.add(surnameTextField, "cell 4 1,growx");
		registerPanel.add(passwordTextField, "cell 4 0,growx");

		registerButton = new JButton("Register");
		registerButton.addActionListener(new RegisterButtonListener());
		registerPanel.add(registerButton, "cell 0 3 5 1,growx");

		operationPanel = new JPanel();
		tabbedPane.addTab("Operations", null, operationPanel, null);
		operationPanel
				.setBorder(new TitledBorder(null, "Operations", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		operationPanel.setLayout(new MigLayout("", "[grow]", "[grow][grow][grow]"));

		myPaperButton = new JButton("Get my paper");
		myPaperButton.addActionListener(new MyPaperButtonListener());
		operationPanel.add(myPaperButton, "cell 0 0,growx");

		getAllPaperButton = new JButton("Get all paper");
		getAllPaperButton.addActionListener(new AllPaperButtonListener());
		operationPanel.add(getAllPaperButton, "cell 0 1,growx");

		getAllParticipantsButton = new JButton("Get all participants");
		getAllParticipantsButton.addActionListener(new AllParticipantButtonListener());
		operationPanel.add(getAllParticipantsButton, "cell 0 2,growx");

		tabbedPane.setEnabledAt(2, false);

		try {
			ConferenceService conferenceService = new ConferenceService();
			conference = conferenceService.getPort(Conference.class);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frame, "Server is offline.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private class RegisterButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				String username = usernameTextField.getText();
				String password = String.valueOf(passwordTextField.getPassword());
				String name = nameTextField.getText();
				String surname = surnameTextField.getText();
				String idPaper = idPaperTextField.getText();

				conference.register(username, password, name, surname, idPaper);
				JOptionPane.showMessageDialog(frame, "Registration successful.", "Registration message",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (RuntimeException e) {
				JOptionPane.showMessageDialog(frame, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}

	}

	private class LoginButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (loginButton.getText().equals("Login")) {
				try {
					String username = usernameLoginTextField.getText();
					String password = String.valueOf(passwordLoginTextField.getPassword());

					ref = conference.login(username, password);
					try {
						ParticipantService participantService = new ParticipantService();
						participant = participantService.getPort(ref, Participant.class);
						JOptionPane.showMessageDialog(frame, "Logged in as " + participant.getUsername(),
								"Login message", JOptionPane.INFORMATION_MESSAGE);
					} catch (Exception e2) {
						// Se il W3CEndpointReference non è un Participant viene
						// lanciata una eccezione (gestita qui)
						AdminService adminService = new AdminService();
						admin = adminService.getPort(ref, Admin.class);
						JOptionPane.showMessageDialog(frame, "Logged in as " + admin.getUsername(), "Login message",
								JOptionPane.INFORMATION_MESSAGE);
					}

					loginButton.setText("Logout");
					usernameLoginTextField.setEnabled(false);
					passwordLoginTextField.setEnabled(false);
					tabbedPane.setEnabledAt(2, true);
				} catch (RuntimeException e) {
					JOptionPane.showMessageDialog(frame, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				loginButton.setText("Login");
				usernameLoginTextField.setEnabled(true);
				passwordLoginTextField.setEnabled(true);
				tabbedPane.setEnabledAt(2, false);
				ref = null;
				admin = null;
				participant = null;
			}
		}

	}

	private class MyPaperButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (admin != null)
				JOptionPane.showMessageDialog(frame, "Only participants have a paper", "Error",
						JOptionPane.ERROR_MESSAGE);
			else
				JOptionPane.showMessageDialog(frame, "Your paper is " + participant.getIdPaper(), "Message",
						JOptionPane.INFORMATION_MESSAGE);
		}

	}

	private class AllPaperButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				List<String> idPaperList = conference.getAllIdPapers(ref);
				PaperListDialog dialog = new PaperListDialog(idPaperList);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			} catch (RuntimeException e) {
				JOptionPane.showMessageDialog(frame, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}

	}

	private class AllParticipantButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				List<ParticipantBean> participantList = conference.getAllParticipants(ref);
				ParticipantListDialog dialog = new ParticipantListDialog(participantList);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			} catch (RuntimeException e) {
				JOptionPane.showMessageDialog(frame, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}

	}
}
