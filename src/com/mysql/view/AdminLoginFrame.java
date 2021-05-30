package com.mysql.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.mysql.module.Admin;
import com.mysql.service.AdminService;
import com.mysql.service.impl.AdminServiceimpl;
import com.mysql.util.StringUtil;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class AdminLoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField usernameText;
	private JPasswordField passwordField;

	// 创建一个service对象，成员变量，方法都可以使用这个对象
	AdminService as = new AdminServiceimpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
					AdminLoginFrame frame = new AdminLoginFrame();
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
	public AdminLoginFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdminLoginFrame.class.getResource("/image/f-04.jpg")));
		setTitle("\u5B66\u751F\u7BA1\u7406\u7CFB\u7EDF -\u767B\u5F55");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 424);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("\u767B  \u5F55");
		lblNewLabel.setIcon(new ImageIcon(AdminLoginFrame.class.getResource("/image/f-03 .png")));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 25));

		JLabel lblNewLabel_1 = new JLabel("\u8D26  \u53F7\uFF1A");
		lblNewLabel_1.setIcon(new ImageIcon(AdminLoginFrame.class.getResource("/image/f-01.png")));
		lblNewLabel_1.setBackground(new Color(230, 230, 250));
		lblNewLabel_1.setForeground(new Color(210, 105, 30));
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));

		usernameText = new JTextField();
		usernameText.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		usernameText.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("\u5BC6   \u7801\uFF1A");
		lblNewLabel_2.setIcon(new ImageIcon(AdminLoginFrame.class.getResource("/image/f-02.png")));
		lblNewLabel_2.setForeground(new Color(210, 105, 30));
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 16));

		JLabel lblNewLabel_3 = new JLabel("\u6CA1\u6709\u8D26\u53F7\uFF0C\u7ACB\u5373\u6CE8\u518C\uFF01");
		lblNewLabel_3.setForeground(new Color(255, 0, 0));
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 12));

		JButton btnNewButton_2 = new JButton("\u6CE8   \u518C");
		btnNewButton_2.setIcon(new ImageIcon(AdminLoginFrame.class.getResource("/image/f-05.png")));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent even) {
				RouterRegiste(even);
			}

			/**
			 * 关闭当前窗口，跳转至注册窗口
			 * 
			 * @param even
			 */
			private void RouterRegiste(ActionEvent even) {
				dispose();// 关闭当前窗口
				new AdminRegisterFrame().setVisible(true);// 跳转到注册窗口
			}
		});
		btnNewButton_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		JButton btnNewButton = new JButton("\u767B   \u5F55");
		btnNewButton.setIcon(new ImageIcon(AdminLoginFrame.class.getResource("/image/f-09.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent even) {
				LoginButton(even);
			}

			/**
			 * 登录功能的实现
			 * 
			 * @param even
			 */

			private void LoginButton(ActionEvent even) {
				String username = usernameText.getText();
				String password = new String(passwordField.getPassword());
				if (StringUtil.isEmpty(username)) {
					JOptionPane.showMessageDialog(null, "账号不能为空！");
					return;
				}
				if (StringUtil.isEmpty(password)) {
					JOptionPane.showMessageDialog(null, "密码不能为空！");
					return;
				}
				// 实现登录
				Admin a = as.login(username);
				System.out.println(a);
				ObjectOutputStream outputStream = null;
				try {
					outputStream = new ObjectOutputStream(
					new FileOutputStream("D:/Users/Administrator/eclipse-workspace/JDBC/lib/admin.txt"));
					outputStream.writeObject(a);
					System.out.println("序列化成功");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						outputStream.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (a == null) {
					// 按用户名没查到
					JOptionPane.showMessageDialog(null, "账号错误！");
					return;
				}
				if (password.equals(a.getPassword())) {
					JOptionPane.showMessageDialog(null, "登陆成功！");
					dispose();
					new MainFrame().setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "密码错误！");
				}
			}
		});
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		JButton btnNewButton_1 = new JButton("\u91CD    \u7F6E");
		btnNewButton_1.setIcon(new ImageIcon(AdminLoginFrame.class.getResource("/image/f-10.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent even) {
				resetActionPerformed(even);
			}

			/**
			 * 重置功能
			 * 
			 * @param even
			 */
			private void resetActionPerformed(ActionEvent even) {
				usernameText.setText("");
				passwordField.setText("");
			}
		});
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
						.createSequentialGroup().addGap(62)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(btnNewButton)
										.addPreferredGap(ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
										.addComponent(btnNewButton_1).addGap(8))
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblNewLabel_1).addGap(18)
										.addComponent(usernameText, GroupLayout.PREFERRED_SIZE, 172,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblNewLabel_2)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(passwordField,
												GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel_3)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnNewButton_2))))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(147).addComponent(lblNewLabel)))
				.addContainerGap(63, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(19)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						.addGap(26)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(59)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblNewLabel_2).addComponent(passwordField,
														GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_1).addComponent(usernameText,
												GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
						.addGap(49)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btnNewButton)
								.addComponent(btnNewButton_1))
						.addGap(26).addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton_2).addComponent(lblNewLabel_3))
						.addContainerGap(77, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
		// 窗体居中
		this.setLocationRelativeTo(null);
		Admin a = DeserializePerson();
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
				System.out.println("执行反序列化过程成功。");
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
