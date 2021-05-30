package com.mysql.view;

import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.mysql.module.Scores;
import com.mysql.service.ScoresService;
import com.mysql.service.impl.ScoresSerivceimpl;
import com.mysql.util.StringUtil;
import java.awt.SystemColor;
import java.util.List;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class showStudentScores extends JInternalFrame {
	private JTextField idText;
	private JTextField nameText;
	private JTextField studentidText;
	private JTextField htmlText;
	private JTextField linuxText;
	ScoresService scores = new ScoresSerivceimpl();
	private JTextField mysqlField;
	private JTable table;
	private JTextField keywordText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					showStudentScores frame = new showStudentScores();
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
	public showStudentScores() {
		getContentPane().setBackground(SystemColor.activeCaption);
		setFrameIcon(new ImageIcon(showStudentScores.class.getResource("/image/f-08.png")));
		setClosable(true);
		setIconifiable(true);
		setTitle("\u67E5\u770B\u5B66\u751F\u6210\u7EE9");
		setBounds(100, 100, 567, 562);

		JScrollPane scrollPane = new JScrollPane();

		JLabel lblNewLabel = new JLabel("\u7F16  \u53F7\uFF1A");
		lblNewLabel.setIcon(new ImageIcon(showStudentScores.class.getResource("/image/f-23.png")));
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		idText = new JTextField();
		idText.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		idText.setEditable(false);
		idText.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("\u59D3  \u540D\uFF1A");
		lblNewLabel_1.setIcon(new ImageIcon(showStudentScores.class.getResource("/image/f-01.png")));
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		nameText = new JTextField();
		nameText.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		nameText.setText("");
		nameText.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("\u5B66  \u53F7\uFF1A");
		lblNewLabel_2.setIcon(new ImageIcon(showStudentScores.class.getResource("/image/f-31.png")));
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		studentidText = new JTextField();
		studentidText.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		studentidText.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("HTML\uFF1A");
		lblNewLabel_3.setIcon(new ImageIcon(showStudentScores.class.getResource("/image/f-30.png")));
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		htmlText = new JTextField();
		htmlText.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		htmlText.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Linux\uFF1A");
		lblNewLabel_4.setIcon(new ImageIcon(showStudentScores.class.getResource("/image/f-32.png")));
		lblNewLabel_4.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		linuxText = new JTextField();
		linuxText.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		linuxText.setText("");
		linuxText.setColumns(10);

		JButton btnNewButton = new JButton("\u4FEE  \u6539");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent even) {
				Modification(even);
			}

			/**
			 * 修改代码
			 * 
			 * @param even
			 */
			private void Modification(ActionEvent even) {
				String id = idText.getText();
				if (StringUtil.isEmpty(id)) {
					// 没有可操作对象！
					JOptionPane.showMessageDialog(null, "没有可操作对象 !");
					return;
				}
				String name = nameText.getText();
				if (StringUtil.isEmpty(name)) {
					// 没有可操作对象！
					JOptionPane.showMessageDialog(null, "姓名不能为空 !");
					return;
				}
				String studentid = studentidText.getText();
				if (StringUtil.isEmpty(studentid)) {
					// 没有可操作对象！
					JOptionPane.showMessageDialog(null, "学号手机号不能为空 !");
					return;
				}
				String html = htmlText.getText();
				if (StringUtil.isEmpty(html)) {
					// 没有可操作对象！
					JOptionPane.showMessageDialog(null, "HTML成绩不能为空 !");
					return;
				}
				String linux = linuxText.getText();
				if (StringUtil.isEmpty(linux)) {
					// 没有可操作对象！
					JOptionPane.showMessageDialog(null, "Linux成绩不能为空 !");
					return;
				}
				String mysql = mysqlField.getText();
				if (StringUtil.isEmpty(mysql)) {
					// 没有可操作对象！
					JOptionPane.showMessageDialog(null, "mysql成绩不能为空 !");
					return;
				}
				// 修改
				Scores sco = new Scores(Integer.parseInt(id), studentid, name, Integer.parseInt(linux),
						Integer.parseInt(html), Integer.parseInt(mysql), Integer.parseInt(mysql));
				int i = scores.updateAdmin(sco);
				if (i > 0) {
					// 修改成功
					JOptionPane.showMessageDialog(null, "修改成功 !");
					// 清空表单
					deleteList();
					// 重新填充表格
					fillTable(new Scores());
				} else {
					JOptionPane.showMessageDialog(null, "修改失败!");
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon(showStudentScores.class.getResource("/image/f-20.png")));
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		JButton btnNewButton_1 = new JButton("\u5220  \u9664");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent even) {
				deleteStudent(even);
			}

			/**
			 * 删除操作
			 * 
			 * @param even
			 */
			private void deleteStudent(ActionEvent even) {
				String id = idText.getText();
				if (StringUtil.isEmpty(id)) {
					// 没有可操作对象！
					JOptionPane.showMessageDialog(null, "没有可操作对象 !");
					return;
				}
				int result = Integer.parseInt(id);
				System.out.println(result);
				int i = scores.deleteStudent(result);
				if (i > 0) {
					// 删除成功
					JOptionPane.showMessageDialog(null, "删除成功 !");
					// 清空表单数据
					deleteList();
					// 重新填充表格
					fillTable(new Scores());
				} else {
					// 删除失败
					JOptionPane.showMessageDialog(null, "删除失败 !");
					return;
				}
			}

		});
		btnNewButton_1.setIcon(new ImageIcon(showStudentScores.class.getResource("/image/f-27.png")));
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		JLabel lblNewLabel_5 = new JLabel("MySQL:");
		lblNewLabel_5.setIcon(new ImageIcon(showStudentScores.class.getResource("/image/f-33.png")));
		lblNewLabel_5.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		mysqlField = new JTextField();
		mysqlField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		mysqlField.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("\u8BF7\u8F93\u5165\u5173\u952E\u5B57\uFF1A");
		lblNewLabel_6.setIcon(new ImageIcon(showStudentScores.class.getResource("/image/f-29.png")));
		lblNewLabel_6.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		keywordText = new JTextField();
		keywordText.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		keywordText.setColumns(10);

		JButton btnNewButton_2 = new JButton("\u641C  \u7D22");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent even) {
				SearchList(even);
			}

			/**
			 * //搜索功能
			 * 
			 * @param even
			 */
			private void SearchList(ActionEvent even) {
				String key = keywordText.getText();
				if (StringUtil.isEmpty(key)) {
					// 没有关键字
					JOptionPane.showMessageDialog(null, "没有可操作对象 !");
					// 清空表单
					deleteList();
					// 重新填充表格
					fillTable(new Scores());
				} else {
					Scores sco = new Scores();
					sco.setName(key);
					// 清空表单
					deleteList();
					// 显示查询信息
					fillTable(sco);
				}
			}
		});
		btnNewButton_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		btnNewButton_2.setIcon(new ImageIcon(showStudentScores.class.getResource("/image/f-28.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(24)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout
								.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNewLabel_1).addComponent(lblNewLabel_3))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(nameText, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
												.addComponent(htmlText, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
												.addGroup(groupLayout.createSequentialGroup().addComponent(btnNewButton)
														.addPreferredGap(ComponentPlacement.RELATED))))
								.addGroup(groupLayout.createSequentialGroup().addComponent(lblNewLabel)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(idText, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)))
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
										.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup().addGap(66)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(lblNewLabel_4).addComponent(lblNewLabel_2))
												.addGap(22)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(studentidText, GroupLayout.DEFAULT_SIZE, 148,
																Short.MAX_VALUE)
														.addComponent(linuxText, GroupLayout.DEFAULT_SIZE, 148,
																Short.MAX_VALUE)))
										.addGroup(groupLayout.createSequentialGroup().addGap(70)
												.addComponent(lblNewLabel_5).addGap(18).addComponent(mysqlField,
														GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)))
										.addGroup(groupLayout.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(btnNewButton_1).addGap(81)))))
				.addGap(17))
				.addGroup(groupLayout.createSequentialGroup().addGap(98).addComponent(lblNewLabel_6)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(keywordText, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnNewButton_2)
						.addContainerGap(42, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(16)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_6)
								.addComponent(keywordText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_2))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
						.addGap(26)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel)
								.addComponent(idText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2).addComponent(studentidText, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1)
								.addComponent(nameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_4).addComponent(linuxText, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_3)
								.addComponent(htmlText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(mysqlField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_5))
						.addGap(30).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton_1).addComponent(btnNewButton))
						.addContainerGap()));

		table = new JTable();
		table.setBackground(SystemColor.inactiveCaptionBorder);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent even) {
				goShowList(even);
			}

			/**
			 * 获取当前行的数据，显示到表单 @ even
			 */
			private void goShowList(MouseEvent even) {
				int row = table.getSelectedRow();// 获取行号
				Integer id = (Integer) table.getValueAt(row, 0);
				String studentid = (String) table.getValueAt(row, 1);
				String name = (String) table.getValueAt(row, 2);
				Integer linux = (Integer) table.getValueAt(row, 3);
				Integer html = (Integer) table.getValueAt(row, 4);
				Integer mysql = (Integer) table.getValueAt(row, 5);
				// 把这一行的数据，显示到表单
				idText.setText(id.toString());
				nameText.setText(name);
				studentidText.setText(studentid);
				linuxText.setText(linux.toString());
				htmlText.setText(html.toString());
				mysqlField.setText(mysql.toString());
			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "\u7F16    \u53F7", "\u5B66   \u53F7", "\u59D3   \u540D", "Linux", "HTML", "MySQL" }));
		table.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
//把数据查出来，显示在表格上

		fillTable(new Scores());
	}

	/**
	 * 填充表格
	 */

	public void fillTable(Scores sco) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		// 清空表格
		model.setRowCount(0);
		@SuppressWarnings("rawtypes")
		List<Vector> list = scores.selectAllScores(sco);
		for (@SuppressWarnings("rawtypes")
		Vector v : list) {
			model.addRow(v);
		}
	}

	/**
	 * 清空表单内容
	 */
	private void deleteList() {
		// TODO Auto-generated method stub
		idText.setText(null);
		nameText.setText(null);
		studentidText.setText(null);
		htmlText.setText(null);
		linuxText.setText(null);
		mysqlField.setText(null);
	}

}
