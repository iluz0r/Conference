package client;

import java.awt.BorderLayout;
import java.util.Iterator;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import stub.StringArray;

public class PaperListDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private DefaultTableModel model;
	private JScrollPane scrollPane;

	public PaperListDialog(List<StringArray> paperList) {
		setTitle("Papers list");
		setBounds(100, 100, 380, 270);
		getContentPane().setLayout(new BorderLayout(0, 0));

		model = new DefaultTableModel(new Object[][] {}, new String[] { "ID Paper", "Title Paper" }) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		table = new JTable(model);
		scrollPane = new JScrollPane(table);
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		Iterator<StringArray> it = paperList.iterator();
		while (it.hasNext()) {
			StringArray sa = (StringArray) it.next();
			List<String> paper = sa.getItem();
			model.addRow(new Object[] { paper.get(0), paper.get(1) });
		}
	}

}
