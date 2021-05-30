package com.mysql.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.mysql.module.Admin;

import java.awt.SystemColor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.swing.JPasswordField;
import java.awt.Color;

@SuppressWarnings("serial")
public class showAdmin extends JInternalFrame {
	private JTextField idText;
	private JTextField nameText;
	private JTextField phoneText;
	private JTextField usernameText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					showAdmin frame = new showAdmin();
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
	public showAdmin() {
		setIconifiable(true);
		setClosable(true);
		getContentPane().setBackground(SystemColor.activeCaption);
		setFrameIcon(new ImageIcon(showAdmin.class.getResource("/image/f-08.png")));
		setTitle("\u663E\u793A\u7BA1\u7406\u5458\u4FE1\u606F");
		setBounds(100, 100, 316, 327);

		JLabel lblNewLabel = new JLabel("\u7F16  \u53F7\uFF1A");
		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));

		idText = new JTextField();
		idText.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		idText.setEditable(false);
		idText.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("\u59D3  \u540D\uFF1A");
		lblNewLabel_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));

		nameText = new JTextField();
		nameText.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		nameText.setEditable(false);
		nameText.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("\u624B\u673A\u53F7\uFF1A");
		lblNewLabel_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));

		phoneText = new JTextField();
		phoneText.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		phoneText.setEditable(false);
		phoneText.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));

		usernameText = new JTextField();
		usernameText.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		usernameText.setEditable(false);
		usernameText.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("\u5BC6  \u7801\uFF1A");
		lblNewLabel_4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));

		passwordText = new JPasswordField();
		passwordText.setEditable(false);
		passwordText.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));

		JLabel lblNewLabel_5 = new JLabel("\u5FD8\u8BB0\u5BC6\u7801\uFF0C\u8BF7\u8054\u7CFB\u7BA1\u7406\u5458");
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(16)
						.addGroup(
								groupLayout
										.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup().addComponent(lblNewLabel_4)
												.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(
														passwordText, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
										.addGroup(groupLayout.createSequentialGroup().addComponent(lblNewLabel_3)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(usernameText, 176, 176, 176))
										.addGroup(groupLayout.createSequentialGroup().addComponent(lblNewLabel_2)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(phoneText, 176, 176, 176))
										.addGroup(groupLayout.createSequentialGroup()
												.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
														.addComponent(lblNewLabel_1).addComponent(lblNewLabel))
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
														.addComponent(nameText).addComponent(idText,
																GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))))
						.addGap(48))
				.addGroup(groupLayout.createSequentialGroup().addGap(51).addComponent(lblNewLabel_5)
						.addContainerGap(195, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(25)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel).addComponent(
						idText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(28)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1).addComponent(
						nameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_2).addComponent(
						phoneText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_3).addComponent(
						usernameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_4).addComponent(
						passwordText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18).addComponent(lblNewLabel_5).addContainerGap(32, Short.MAX_VALUE)));
		getContentPane().setLayout(groupLayout);
		idText.setText(String.valueOf(a.getId()));
		nameText.setText(a.getNAME());
		phoneText.setText(a.getPhone());
		usernameText.setText(a.getUsername());
		passwordText.setText(a.getPassword());
	}

	Admin a = DeserializePerson();
	private JPasswordField passwordText;

	/**
	 * ÏÔÊ¾µÇÂ½ÐÅÏ¢
	 */
	protected Admin DeserializePerson() {
		// TODO Auto-generated method stub
		Admin a = null;
		ObjectInputStream inputStream = null;
		try {
			inputStream = new ObjectInputStream(
					new FileInputStream("D:/Users/Administrator/eclipse-workspace/JDBC/lib/admin.txt"));
			try {
				a = (Admin) inputStream.readObject();
				System.out.println("Ö´ÐÐ·´ÐòÁÐ»¯¹ý³Ì³É¹¦¡£");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return a;
	}
}
