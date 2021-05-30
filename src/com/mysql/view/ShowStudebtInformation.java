package com.mysql.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.util.List;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.module.Student;
import com.mysql.service.StudentSerivce;
import com.mysql.service.impl.StudentSerivceimpl;
import com.mysql.util.StringUtil;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ShowStudebtInformation extends JInternalFrame {
	private JTable table;
	private JTextField idText;
	private JTextField nameText;
	private JTextField ageText;
	private JTextField sexText;
	private JTextField birthdayText;
	private JTextField classText;
	private JTextField keywordText;
	StudentSerivce ss = new StudentSerivceimpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
					ShowStudebtInformation frame = new ShowStudebtInformation();
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
	public ShowStudebtInformation() {
		setForeground(SystemColor.activeCaptionBorder);
		setBackground(SystemColor.inactiveCaption);
		getContentPane().setBackground(SystemColor.activeCaption);

		JScrollPane scrollPane = new JScrollPane();

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"\u5B66\u751F\u7BA1\u7406\u5176\u4ED6\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null,
				SystemColor.activeCaption));

		JLabel lblNewLabel_6 = new JLabel("\u8BF7\u8F93\u5165\u5173\u952E\u5B57\uFF1A");
		lblNewLabel_6.setIcon(new ImageIcon(ShowStudebtInformation.class.getResource("/image/f-29.png")));
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
					fillTable(new Student());
				} else {
					Student stu = new Student();
					stu.setName(key);
					// 清空表单
					deleteList();
					// 显示查询信息
					fillTable(stu);
				}
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(ShowStudebtInformation.class.getResource("/image/f-28.png")));
		btnNewButton_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 528, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(21, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup().addGap(48).addComponent(lblNewLabel_6)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(keywordText, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(btnNewButton_2).addContainerGap(59, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(22)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_6)
								.addComponent(keywordText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_2))
						.addGap(18)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(panel, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(123, Short.MAX_VALUE)));

		JLabel lblNewLabel = new JLabel("\u7F16  \u53F7\uFF1A");
		lblNewLabel.setIcon(new ImageIcon(ShowStudebtInformation.class.getResource("/image/f-23.png")));
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		idText = new JTextField();
		idText.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		idText.setEditable(false);
		idText.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("\u59D3  \u540D\uFF1A");
		lblNewLabel_1.setIcon(new ImageIcon(ShowStudebtInformation.class.getResource("/image/f-01.png")));
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		nameText = new JTextField();
		nameText.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		nameText.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("\u5E74  \u9F84\uFF1A");
		lblNewLabel_2.setIcon(new ImageIcon(ShowStudebtInformation.class.getResource("/image/f-24.png")));
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		ageText = new JTextField();
		ageText.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		ageText.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("\u6027  \u522B\uFF1A");
		lblNewLabel_3.setIcon(new ImageIcon(ShowStudebtInformation.class.getResource("/image/f-26.png")));
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		sexText = new JTextField();
		sexText.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		sexText.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("\u751F  \u65E5\uFF1A");
		lblNewLabel_4.setIcon(new ImageIcon(ShowStudebtInformation.class.getResource("/image/f-25.png")));
		lblNewLabel_4.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		birthdayText = new JTextField();
		birthdayText.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		birthdayText.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("\u73ED  \u7EA7\uFF1A");
		lblNewLabel_5.setIcon(new ImageIcon(ShowStudebtInformation.class.getResource("/image/f-22.png")));
		lblNewLabel_5.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		classText = new JTextField();
		classText.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		classText.setColumns(10);

		JButton btnNewButton = new JButton("\u4FEE  \u6539");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent even) {
				ModificationList(even);
			}

			/**
			 * 修改代码
			 * 
			 * @param even
			 */
			private void ModificationList(ActionEvent even) {
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
				String age = ageText.getText();
				if (StringUtil.isEmpty(age)) {
					// 没有可操作对象！
					JOptionPane.showMessageDialog(null, "年龄不能为空 !");
					return;
				}
				String sex = sexText.getText();
				if (StringUtil.isEmpty(sex)) {
					// 没有可操作对象！
					JOptionPane.showMessageDialog(null, "性别不能为空 !");
					return;
				}
				String birthday = birthdayText.getText();
				if (StringUtil.isEmpty(birthday)) {
					// 没有可操作对象！
					JOptionPane.showMessageDialog(null, "生日不能为空 !");
					return;
				}
				String classna = classText.getText();
				if (StringUtil.isEmpty(classna)) {
					// 没有可操作对象！
					JOptionPane.showMessageDialog(null, "班级不能为空 !");
					return;
				}
				// 修改
				Student stu = new Student(Integer.parseInt(id), name, age, sex, birthday, classna);
				int i = ss.updateStudent(stu);
				if (i > 0) {
					// 修改成功
					JOptionPane.showMessageDialog(null, "修改成功 !");
					// 清空表单
					deleteList();
					// 重新填充表格
					fillTable(new Student());
				} else {
					JOptionPane.showMessageDialog(null, "修改失败!");
				}
			}
		});
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		btnNewButton.setIcon(new ImageIcon(ShowStudebtInformation.class.getResource("/image/f-20.png")));

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
				int i = ss.deleteStudent(result);
				if (i > 0) {
					// 删除成功
					JOptionPane.showMessageDialog(null, "删除成功 !");
					// 清空表单数据
					deleteList();
					// 重新填充表格
					fillTable(new Student());
				} else {
					// 删除失败
					JOptionPane.showMessageDialog(null, "删除失败 !");
					return;
				}
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(ShowStudebtInformation.class.getResource("/image/f-27.png")));
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addComponent(lblNewLabel_4)
						.addComponent(lblNewLabel_2).addComponent(lblNewLabel))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup().addGap(28).addComponent(btnNewButton).addGap(98)
								.addComponent(btnNewButton_1))
						.addGroup(gl_panel.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
										.addComponent(birthdayText).addComponent(ageText).addComponent(idText,
												GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel_1)
										.addComponent(lblNewLabel_3).addComponent(lblNewLabel_5,
												GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false).addComponent(classText)
										.addComponent(sexText)
										.addComponent(nameText, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))))
				.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel)
								.addComponent(idText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1).addComponent(nameText, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_2)
								.addComponent(ageText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3).addComponent(sexText, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_4)
								.addComponent(birthdayText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_5).addComponent(classText, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(btnNewButton_1)
								.addComponent(btnNewButton))));
		panel.setLayout(gl_panel);

		table = new JTable();
		table.setFont(new Font("微软雅黑", Font.PLAIN, 14));
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
				String name = (String) table.getValueAt(row, 1);
				String age = (String) table.getValueAt(row, 2);
				String sex = (String) table.getValueAt(row, 3);
				String birthday = (String) table.getValueAt(row, 4);
				String classna = (String) table.getValueAt(row, 5);
				// 把这一行的数据，显示到表单
				idText.setText(id.toString());
				nameText.setText(name);
				ageText.setText(age);
				sexText.setText(sex);
				birthdayText.setText(birthday);
				classText.setText(classna);
			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "\u7F16\u53F7", "\u59D3\u540D",
				"\u5E74\u9F84", "\u6027\u522B", "\u751F\u65E5", "\u73ED\u7EA7" }));
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
		// 把数据查出来，并显示在JTable上
		fillTable(new Student());
		setTitle("\u67E5\u770B\u6240\u6709\u5B66\u751F");
		setFrameIcon(new ImageIcon(ShowStudebtInformation.class.getResource("/image/f-08.png")));
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 575, 600);

	}

	/**
	 * 获取数据，并显示
	 * 
	 * @param stu
	 */
	public void fillTable(Student stu) {
		// TODO Auto-generated method stub
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		// 填充之前，清空表格
		model.setRowCount(0);
		@SuppressWarnings("rawtypes")
		List<Vector> list = ss.selectAllStudents(stu);

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
		ageText.setText(null);
		sexText.setText(null);
		birthdayText.setText(null);
		classText.setText(null);
	}
}
