package client;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import stub.ParticipantBean;

public class ParticipantListDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private DefaultTableModel model;
	private JScrollPane scrollPane;

	public ParticipantListDialog(List<ParticipantBean> participantList) {
		setTitle("Participants list");
		setBounds(100, 100, 560, 300);
		getContentPane().setLayout(new BorderLayout(0, 0));

		model = new DefaultTableModel(new Object[][] {}, new String[] { "Username", "Name", "Surname", "ID Paper" }) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table = new JTable(model);
		scrollPane = new JScrollPane(table);
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		for (ParticipantBean participant : participantList)
			model.addRow(new Object[] { participant.getUsername(), participant.getName(), participant.getSurname(),
					participant.getIdPaper() });
	}

}