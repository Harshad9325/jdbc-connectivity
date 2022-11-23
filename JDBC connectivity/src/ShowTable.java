


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.ResultSetMetaData;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

@SuppressWarnings("unused")
public class ShowTable extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	protected AbstractButton tblData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowTable frame = new ShowTable();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ShowTable() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 638, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnShow = new JButton("Display data");
		btnShow.addActionListener(new ActionListener() {
			private AbstractButton tbl;

			public void actionPerformed(ActionEvent e) {
				try {

					 Class.forName("com.mysql.jdbc.Driver");

					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/youtube", "root", "");

					java.sql.Statement st = con.createStatement();
					String q = "select * from table1";

					ResultSet rs = st.executeQuery(q);

					ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
					DefaultTableModel mod = (DefaultTableModel) table.getModel();
					int cols = rsmd.getColumnCount();
					String[] colName = new String[cols];
					for (int i = 0; i < cols; i++)
						colName[i] = rsmd.getColumnName(i + 1);
					mod.setColumnIdentifiers(colName);
					String tid;
					String tname;
					String tcity;
					while (rs.next()) {
						tid = rs.getString(1);
						tname = rs.getString(2);
						tcity = rs.getString(3);
						String[] row = { tid, tname, tcity };
						mod.addRow(row);
					}
					st.close();
					con.close();

				} catch (Exception e1) {
				
					e1.printStackTrace();
				}

			}
		});
		btnShow.setBounds(56, 106, 117, 40);
		contentPane.add(btnShow);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(205, 11, 407, 405);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JButton btneset = new JButton("Clear");
		btneset.setBounds(56, 268, 117, 40);
		contentPane.add(btneset);
	}
}
