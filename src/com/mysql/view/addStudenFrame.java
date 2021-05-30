package com.mysql.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.mysql.module.Student;
import com.mysql.service.StudentSerivce;
import com.mysql.service.impl.StudentSerivceimpl;
import com.mysql.util.StringUtil;

import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class addStudenFrame extends JInternalFrame {
	private JTextField nameText;
	private JTextField ageText;
	private JTextField sexText;
	private JTextField birthdayText;
	private JTextField classText;
	StudentSerivce ss = new StudentSerivceimpl();
	ShowStudebtInformation fi = new ShowStudebtInformation();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addStudenFrame frame = new addStudenFrame();
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
	public addStudenFrame() {
		getContentPane().setBackground(SystemColor.activeCaption);
		setFrameIcon(new ImageIcon(addStudenFrame.class.getResource("/image/f-08.png")));
		setTitle("\u589E\u52A0\u5B66\u751F\u4FE1\u606F");
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 386, 378);

		JLabel lblNewLabel = new JLabel("\u59D3  \u540D\uFF1A");
		lblNewLabel.setIcon(new ImageIcon(addStudenFrame.class.getResource("/image/f-01.png")));
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		nameText = new JTextField();
		nameText.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		nameText.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("\u5E74  \u9F84\uFF1A");
		lblNewLabel_1.setIcon(new ImageIcon(addStudenFrame.class.getResource("/image/f-24.png")));
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		ageText = new JTextField();
		ageText.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		ageText.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("\u6027  \u522B\uFF1A");
		lblNewLabel_2.setIcon(new ImageIcon(addStudenFrame.class.getResource("/image/f-26.png")));
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		sexText = new JTextField();
		sexText.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		sexText.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("\u751F  \u65E5\uFF1A");
		lblNewLabel_3.setIcon(new ImageIcon(addStudenFrame.class.getResource("/image/f-25.png")));
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		birthdayText = new JTextField();
		birthdayText.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		birthdayText.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("\u73ED  \u7EA7\uFF1A");
		lblNewLabel_4.setIcon(new ImageIcon(addStudenFrame.class.getResource("/image/f-22.png")));
		lblNewLabel_4.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		classText = new JTextField();
		classText.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		classText.setColumns(10);

		JButton btnNewButton = new JButton("\u6DFB  \u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent even) {
				addStudent(even);

			}

			/**
			 * 添加学生信息
			 * 
			 * @param even
			 */
			private void addStudent(ActionEvent even) {
				String name = nameText.getText();
				String age = ageText.getText();
				String sex = sexText.getText();
				String birthday = birthdayText.getText();
				String classna = classText.getText();
				if (StringUtil.isEmpty(name)) {
					JOptionPane.showMessageDialog(null, "姓名不能为空！");
					return;
				}
				if (StringUtil.isEmpty(age)) {
					JOptionPane.showMessageDialog(null, "年龄不能为空！");
					return;
				}
				if (StringUtil.isEmpty(sex)) {
					JOptionPane.showMessageDialog(null, "性别不能为空！");
					return;
				}
				if (StringUtil.isEmpty(birthday)) {
					JOptionPane.showMessageDialog(null, "生日不能为空！");
					return;
				}
				if (StringUtil.isEmpty(classna)) {
					JOptionPane.showMessageDialog(null, "班级不能为空！");
					return;
				}
				Student stu = new Student(name, age, sex, birthday, classna);
				System.out.println(stu);
				int i = ss.register(stu);
				if (i > 0) {
					int rs = JOptionPane.showConfirmDialog(null, "添加成功！是否继续添加");
					// 重新填充表格
					fi.fillTable(new Student());
					if (rs == 0) {
						ClearAdd();
					} else if (rs == 1) {
						ClearAdd();
					} else if (rs == 2) {
						ClearAdd();
					}
				} else {
					JOptionPane.showMessageDialog(null, "添加失败，请重新添加！");
					ClearAdd();
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon(addStudenFrame.class.getResource("/image/f-05.png")));
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		JButton btnNewButton_1 = new JButton("\u91CD  \u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent even) {
				clearAddText(even);

			}

			/**
			 * 清空操作 @ even
			 */
			private void clearAddText(ActionEvent even) {
				ClearAdd();
			}

		});
		btnNewButton_1.setIcon(new ImageIcon(addStudenFrame.class.getResource("/image/f-10.png")));
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				groupLayout.createSequentialGroup().addGap(60).addGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addComponent(lblNewLabel).addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel_1)
										.addComponent(lblNewLabel_2)
										.addGroup(groupLayout.createSequentialGroup().addGap(4)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(lblNewLabel_3).addComponent(btnNewButton)
														.addComponent(lblNewLabel_4))))
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
										.createSequentialGroup().addGap(12)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(birthdayText, GroupLayout.DEFAULT_SIZE, 166,
														Short.MAX_VALUE)
												.addComponent(sexText, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 166,
														Short.MAX_VALUE)
												.addComponent(ageText, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 166,
														Short.MAX_VALUE)
												.addComponent(classText, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
												.addComponent(nameText, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
														166, Short.MAX_VALUE))
										.addGap(40))
										.addGroup(Alignment.TRAILING,
												groupLayout.createSequentialGroup()
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(btnNewButton_1).addGap(53)))))));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(42)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addComponent(lblNewLabel).addComponent(
						nameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1).addComponent(
						ageText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_2).addComponent(
						sexText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_3).addComponent(
						birthdayText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(classText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4))
				.addGap(46).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
				.addContainerGap(144, Short.MAX_VALUE)));
		getContentPane().setLayout(groupLayout);

	}

	/**
	 * 清空操作
	 */
	private void ClearAdd() {
		nameText.setText("");
		ageText.setText("");
		sexText.setText("");
		birthdayText.setText("");
		classText.setText("");
	}
}
