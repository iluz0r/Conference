package client;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JList;

public class PaperListDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JList<String> list;
	private DefaultListModel<String> model;

	public PaperListDialog(List<String> idPaperList) {
		setTitle("Papers list");
		setBounds(100, 100, 230, 300);
		getContentPane().setLayout(new BorderLayout(0, 0));
		model = new DefaultListModel<>();
		list = new JList<>(model);
		getContentPane().add(list, BorderLayout.CENTER);

		for (String idPaper : idPaperList)
			model.addElement(idPaper);
	}

}
