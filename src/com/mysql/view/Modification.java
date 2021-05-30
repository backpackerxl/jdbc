package com.mysql.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JPasswordField;
import com.mysql.module.Admin;
import com.mysql.service.AdminService;
import com.mysql.service.impl.AdminServiceimpl;
import com.mysql.util.StringUtil;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings("serial")
public class Modification extends JInternalFrame {
	private JPasswordField passwordText;
	private JPasswordField newpasswordText;
	private String passwordkey;
	AdminService as = new AdminServiceimpl();
	MainFrame mf = new MainFrame();
	private JTextField idText;
	private JTextField phoneText;
	private JTextField usernameText;
	private JTextField nameText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Modification frame = new Modification();
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
	public Modification() {
		setIconifiable(true);
		setClosable(true);
		getContentPane().setBackground(SystemColor.activeCaption);
		setFrameIcon(new ImageIcon(Modification.class.getResource("/image/f-08.png")));
		setTitle("\u4FEE\u6539\u5BC6\u7801");
		setBounds(100, 100, 340, 399);

		JLabel lblNewLabel = new JLabel("\u65E7\u5BC6\u7801\uFF1A");
		lblNewLabel.setIcon(new ImageIcon(Modification.class.getResource("/image/f-34.png")));
		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));

		passwordText = new JPasswordField();
		passwordText.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));

		JLabel lblNewLabel_1 = new JLabel("\u65B0\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setIcon(new ImageIcon(Modification.class.getResource("/image/f-35.png")));
		lblNewLabel_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));

		newpasswordText = new JPasswordField();
		newpasswordText.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));

		JButton btnNewButton = new JButton("\u4FEE  \u6539");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent even) {
				ModificationAdmin(even);
			}

			/**
			 * ÐÞ¸Ä¹¦ÄÜ
			 * 
			 * @param even
			 */
			private void ModificationAdmin(ActionEvent even) {
				String pass = new String(passwordText.getPassword());
				if (StringUtil.isEmpty(pass)) {
					JOptionPane.showMessageDialog(null, "¾ÉÃÜÂë²»ÄÜÎª¿Õ£¡");
					return;
				}
				String newpass = new String(newpasswordText.getPassword());
				if (StringUtil.isEmpty(newpass)) {
					JOptionPane.showMessageDialog(null, "ÐÂÃÜÂë²»ÄÜÎª¿Õ£¡");
					return;
				}
				String name = nameText.getText();
				String phone = phoneText.getText();
				if (StringUtil.isEmpty(phone)) {
					JOptionPane.showMessageDialog(null, "ÊÖ»úºÅ²»ÄÜÎª¿Õ£¡");
					return;
				}
				String id = idText.getText();
				String username = usernameText.getText();
				if (StringUtil.isEmpty(username)) {
					JOptionPane.showMessageDialog(null, "ÊÖ»úºÅ²»ÄÜÎª¿Õ£¡");
					return;
				}
				if (pass.equals(newpass)) {
					JOptionPane.showMessageDialog(null, "Á½´ÎÊäÈëÒ»ÖÂ£¬ÐÞ¸ÄÊ§°Ü£¡");
					ClearAdd(even);
					return;
				}
				Admin a = DeserializePerson();
				if (pass.equals(a.getPassword())) {
					Admin ad = new Admin(Integer.parseInt(id), name, phone, username, newpass);
					int i = as.updataAdmin(ad);
					if (i > 0) {
						JOptionPane.showMessageDialog(null, "ÐÞ¸Ä³É¹¦£¬ÇëÖØÐÂµÇÂ½£¡");
						mf.ColseMainFrame();
					}
				} else {
					JOptionPane.showMessageDialog(null, "¾ÉÃÜÂë´íÎó£¡");
					ClearAdd(even);
					return;
				}
			}

		});

		btnNewButton.setIcon(new ImageIcon(Modification.class.getResource("/image/f-20.png")));
		btnNewButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));

		JButton btnNewButton_1 = new JButton("\u91CD  \u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent even) {
				ClearAdd(even);
			}

		});
		btnNewButton_1.setIcon(new ImageIcon(Modification.class.getResource("/image/f-10.png")));
		btnNewButton_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));

		JLabel lblNewLabel_2 = new JLabel("\u7F16 \u53F7\uFF1A");
		lblNewLabel_2.setIcon(new ImageIcon(Modification.class.getResource("/image/f-23.png")));
		lblNewLabel_2.setFont(new Font("ËÎÌå", Font.PLAIN, 14));

		idText = new JTextField();
		idText.setEditable(false);
		idText.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		idText.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("\u624B\u673A\u53F7\uFF1A");
		lblNewLabel_3.setIcon(new ImageIcon(Modification.class.getResource("/image/f-18 (2).png")));
		lblNewLabel_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));

		phoneText = new JTextField();
		phoneText.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		phoneText.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel_4.setIcon(new ImageIcon(Modification.class.getResource("/image/f-01.png")));
		lblNewLabel_4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));

		usernameText = new JTextField();
		usernameText.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		usernameText.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("\u59D3  \u540D\uFF1A");
		lblNewLabel_5.setIcon(new ImageIcon(Modification.class.getResource("/image/f-16.png")));
		lblNewLabel_5.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));

		nameText = new JTextField();
		nameText.setEditable(false);
		nameText.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		nameText.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout
				.setHorizontalGroup(
						groupLayout
								.createParallelGroup(
										Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(
												Alignment.LEADING,
												groupLayout.createSequentialGroup().addGap(23)
														.addComponent(btnNewButton).addPreferredGap(
																ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
														.addComponent(btnNewButton_1))
												.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
														.addContainerGap().addComponent(lblNewLabel_4).addGap(30)
														.addComponent(usernameText, GroupLayout.DEFAULT_SIZE, 165,
																Short.MAX_VALUE))
												.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
														.addContainerGap().addComponent(lblNewLabel).addGap(
																30)
														.addComponent(passwordText, GroupLayout.DEFAULT_SIZE, 165,
																Short.MAX_VALUE))
												.addGroup(Alignment.LEADING,
														groupLayout
																.createSequentialGroup().addContainerGap()
																.addComponent(lblNewLabel_1).addGap(
																		30)
																.addComponent(newpasswordText, 164, 165,
																		Short.MAX_VALUE))
												.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
														.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
																.addGroup(groupLayout.createSequentialGroup().addGap(20)
																		.addGroup(groupLayout
																				.createParallelGroup(Alignment.LEADING)
																				.addComponent(lblNewLabel_2)
																				.addComponent(lblNewLabel_5)))
																.addGroup(groupLayout.createSequentialGroup()
																		.addContainerGap().addComponent(lblNewLabel_3)))
														.addGap(27)
														.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
																.addComponent(phoneText, GroupLayout.DEFAULT_SIZE, 164,
																		Short.MAX_VALUE)
																.addComponent(nameText, GroupLayout.DEFAULT_SIZE, 164,
																		Short.MAX_VALUE)
																.addComponent(idText, GroupLayout.DEFAULT_SIZE, 164,
																		Short.MAX_VALUE))))
										.addGap(43)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup().addGap(34)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_2).addComponent(
						idText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_5).addComponent(
						nameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_3).addComponent(
						phoneText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_4).addComponent(
						usernameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel).addComponent(
						passwordText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addComponent(lblNewLabel_1).addComponent(
						newpasswordText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addGap(30).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
				.addGap(44)));
		getContentPane().setLayout(groupLayout);
		Admin a = DeserializePerson();
		idText.setText(String.valueOf(a.getId()));
		nameText.setText(a.getNAME());
		phoneText.setText(a.getPhone());
		usernameText.setText(a.getUsername());
	}

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

	public String ModificationPass(String password) {
		// TODO Auto-generated method stub
		passwordkey = password;
		return passwordkey;
	}

	/**
	 * Çå¿Õ²Ù×÷
	 */
	private void ClearAdd(ActionEvent even) {
		phoneText.setText("");
		usernameText.setText("");
		passwordText.setText("");
		newpasswordText.setText("");
	}
}
