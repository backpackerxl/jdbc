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
import java.awt.SystemColor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class AdminRegisterFrame extends JFrame {

	private JPanel contentPane;
//注入service
	AdminService as = new AdminServiceimpl();
	private JTextField nameText;
	private JTextField phoneText;
	private JTextField usernameText;
	private JPasswordField newpasswordField;
	private JPasswordField passwordField;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
					AdminRegisterFrame frame = new AdminRegisterFrame();
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
	public AdminRegisterFrame() {
		setBackground(SystemColor.activeCaption);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdminRegisterFrame.class.getResource("/image/f-06.jpg")));
		setTitle("\u5B66\u751F\u7BA1\u7406\u7CFB\u7EDF-\u6CE8\u518C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 507);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("\u59D3  \u540D\uFF1A");
		lblNewLabel.setIcon(new ImageIcon(AdminRegisterFrame.class.getResource("/image/f-01.png")));
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		nameText = new JTextField();
		nameText.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		nameText.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("\u624B\u673A\u53F7\uFF1A");
		lblNewLabel_1.setIcon(new ImageIcon(AdminRegisterFrame.class.getResource("/image/f-18 (2).png")));
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		phoneText = new JTextField();
		phoneText.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		phoneText.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel_2.setIcon(new ImageIcon(AdminRegisterFrame.class.getResource("/image/f-16.png")));
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		usernameText = new JTextField();
		usernameText.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		usernameText.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("\u5BC6  \u7801 \uFF1A");
		lblNewLabel_3.setIcon(new ImageIcon(AdminRegisterFrame.class.getResource("/image/f-34.png")));
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		JLabel lblNewLabel_4 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		lblNewLabel_4.setIcon(new ImageIcon(AdminRegisterFrame.class.getResource("/image/f-35.png")));
		lblNewLabel_4.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		newpasswordField = new JPasswordField();
		newpasswordField.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		JButton btnNewButton = new JButton("\u6CE8  \u518C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent even) {
				registerActionPerformen(even);
			}

			/**
			 * 注册功能的实现
			 * 
			 * @param even
			 */
			private void registerActionPerformen(ActionEvent even) {
				String name = nameText.getText();
				String phone = phoneText.getText();
				String username = usernameText.getText();
				String password = new String(passwordField.getPassword());
				String newpassword = new String(newpasswordField.getPassword());
				if (StringUtil.isEmpty(name)) {
					JOptionPane.showMessageDialog(null, "姓名不能为空！");
					return;
				}
				if (StringUtil.isEmpty(phone)) {
					JOptionPane.showMessageDialog(null, "联系方式不能为空！");
					return;
				}
				if (StringUtil.isEmpty(username)) {
					JOptionPane.showMessageDialog(null, "用户名不能为空！");
					return;
				} else if (StringUtil.isEmpty(password)) {
					JOptionPane.showMessageDialog(null, "密码不能为空！");
					return;
				} else if (StringUtil.isEmpty(newpassword)) {
					JOptionPane.showMessageDialog(null, "确认密码不能为空！");
					return;
				} else {
					// 校验用户名重复问题
					boolean flag = as.validataUserName(username);
					if (flag) {
						JOptionPane.showMessageDialog(null, "该用户名已存在，请重新注册！");
						return;
					} else {
						if (password.equals(newpassword)) {
							// 注册功能，提交数据到数据库
							Admin admin = new Admin(name, phone, username, password);
							int i = as.register(admin);
							if (i > 0) {
								int rs = JOptionPane.showConfirmDialog(null, "注册成功！是否跳转至登录界面");
								if (rs == 0) {
									dispose();// 关闭当前窗口
									new AdminLoginFrame().setVisible(true);
								}
							}
						} else {
							JOptionPane.showMessageDialog(null, "注册失败，请重新注册！");
							resetActionPerdormend(even);
						}

					}
				}

			}
		});
		btnNewButton.setIcon(new ImageIcon(AdminRegisterFrame.class.getResource("/image/f-11.png")));
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		btnNewButton_1 = new JButton("\u91CD  \u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent even) {
				resetActionPerdormend(even);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(AdminRegisterFrame.class.getResource("/image/f-10.png")));
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		btnNewButton_2 = new JButton("\u767B  \u5F55");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent even) {
				GotoLogin(even);
			}

			/**
			 * 关闭注册窗口，去登陆
			 * 
			 * @param even
			 */
			private void GotoLogin(ActionEvent even) {
				dispose();// 关闭当前窗口
				new AdminLoginFrame().setVisible(true);// 跳转到登录窗口
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(AdminRegisterFrame.class.getResource("/image/f-09.png")));
		btnNewButton_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		lblNewLabel_5 = new JLabel("\u70B9\u6211\u53BB\u767B\u9646");
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setFont(new Font("微软雅黑", Font.PLAIN, 12));

		lblNewLabel_6 = new JLabel("\u6CE8  \u518C");
		lblNewLabel_6.setForeground(SystemColor.inactiveCaptionBorder);
		lblNewLabel_6.setIcon(new ImageIcon(AdminRegisterFrame.class.getResource("/image/f-12.png")));
		lblNewLabel_6.setFont(new Font("微软雅黑", Font.BOLD, 25));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
						.createSequentialGroup().addGap(71)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel_3)
								.addComponent(lblNewLabel_4).addComponent(lblNewLabel_2).addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel))
						.addGap(32)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(newpasswordField, Alignment.LEADING)
								.addComponent(passwordField, Alignment.LEADING)
								.addComponent(usernameText, Alignment.LEADING)
								.addComponent(phoneText, Alignment.LEADING).addComponent(nameText, Alignment.LEADING,
										GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(195).addComponent(lblNewLabel_6)))
				.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup().addGap(39).addComponent(btnNewButton).addGap(77)
						.addComponent(btnNewButton_1).addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
						.addComponent(lblNewLabel_5).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnNewButton_2).addGap(20)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(26).addComponent(lblNewLabel_6).addGap(42)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(nameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
				.addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(phoneText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
				.addGap(18)
				.addGroup(gl_contentPane
						.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_2).addComponent(usernameText,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPane
						.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_3).addComponent(passwordField,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_4)
						.addComponent(newpasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(58)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btnNewButton)
						.addComponent(btnNewButton_1).addComponent(btnNewButton_2).addComponent(lblNewLabel_5))
				.addContainerGap(74, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
		// 窗体居中
		this.setLocationRelativeTo(null);
	}

	/**
	 * 重置功能
	 * 
	 * @param even
	 */
	private void resetActionPerdormend(ActionEvent even) {
		nameText.setText("");
		phoneText.setText("");
		usernameText.setText("");
		passwordField.setText("");
		newpasswordField.setText("");
	}
}
