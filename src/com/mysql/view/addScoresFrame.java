package com.mysql.view;

import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import com.mysql.module.Scores;
import com.mysql.service.ScoresService;
import com.mysql.service.impl.ScoresSerivceimpl;
import com.mysql.util.StringUtil;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class addScoresFrame extends JInternalFrame {
	private JTextField studentidText;
	private JTextField nameText;
	private JTextField linuxText;
	private JTextField htmlText;
	private JTextField mysqlText;
	ScoresService ss = new ScoresSerivceimpl();
	showStudentScores fi = new showStudentScores();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addScoresFrame frame = new addScoresFrame();
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
	public addScoresFrame() {
		setIconifiable(true);
		setClosable(true);
		getContentPane().setBackground(SystemColor.activeCaption);
		setFrameIcon(new ImageIcon(addScoresFrame.class.getResource("/image/f-08.png")));
		setTitle("\u6DFB\u52A0\u5B66\u751F\u6210\u7EE9");
		setBounds(100, 100, 361, 392);

		JLabel lblNewLabel = new JLabel("\u5B66  \u53F7\uFF1A");
		lblNewLabel.setIcon(new ImageIcon(addScoresFrame.class.getResource("/image/f-31.png")));
		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));

		studentidText = new JTextField();
		studentidText.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		studentidText.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("\u59D3  \u540D\uFF1A");
		lblNewLabel_1.setIcon(new ImageIcon(addScoresFrame.class.getResource("/image/f-01.png")));
		lblNewLabel_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));

		nameText = new JTextField();
		nameText.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		nameText.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Linux :");
		lblNewLabel_2.setIcon(new ImageIcon(addScoresFrame.class.getResource("/image/f-32.png")));
		lblNewLabel_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));

		linuxText = new JTextField();
		linuxText.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		linuxText.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("HTML :");
		lblNewLabel_3.setIcon(new ImageIcon(addScoresFrame.class.getResource("/image/f-30.png")));
		lblNewLabel_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));

		htmlText = new JTextField();
		htmlText.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		htmlText.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("MySQL :");
		lblNewLabel_4.setIcon(new ImageIcon(addScoresFrame.class.getResource("/image/f-33.png")));
		lblNewLabel_4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));

		mysqlText = new JTextField();
		mysqlText.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		mysqlText.setColumns(10);

		JButton button = new JButton("\u6DFB  \u52A0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent even) {
				addStudentScores(even);
			}

			/**
			 * Ìí¼ÓÑ§ÉúÐÅÏ¢
			 * 
			 * @param even
			 */
			private void addStudentScores(ActionEvent even) {
				String name = nameText.getText();
				String studentid = studentidText.getText();
				String linux = linuxText.getText();
				String html = htmlText.getText();
				String mysql = mysqlText.getText();
				if (StringUtil.isEmpty(name)) {
					JOptionPane.showMessageDialog(null, "ÐÕÃû²»ÄÜÎª¿Õ£¡");
					return;
				}
				if (StringUtil.isEmpty(studentid)) {
					JOptionPane.showMessageDialog(null, "Ñ§ºÅ²»ÄÜÎª¿Õ£¡");
					return;
				}
				if (StringUtil.isEmpty(linux)) {
					JOptionPane.showMessageDialog(null, "Linux³É¼¨²»ÄÜÎª¿Õ£¡");
					return;
				}
				if (StringUtil.isEmpty(html)) {
					JOptionPane.showMessageDialog(null, "HTML³É¼¨²»ÄÜÎª¿Õ£¡");
					return;
				}
				if (StringUtil.isEmpty(mysql)) {
					JOptionPane.showMessageDialog(null, "MySQL³É¼¨²»ÄÜÎª¿Õ£¡");
					return;
				}
				Scores stu = new Scores(studentid, name, Integer.parseInt(linux), Integer.parseInt(html),
						Integer.parseInt(mysql));
				System.out.println(stu);
				int i = ss.register(stu);
				if (i > 0) {
					int rs = JOptionPane.showConfirmDialog(null, "Ìí¼Ó³É¹¦£¡ÊÇ·ñ¼ÌÐøÌí¼Ó");
					// ÖØÐÂÌî³ä±í¸ñ
					if (rs == 0) {
						ClearAdd(even);
						fi.fillTable(new Scores());
					} else if (rs == 1) {
						ClearAdd(even);
						fi.fillTable(new Scores());
					} else if (rs == 2) {
						ClearAdd(even);
						fi.fillTable(new Scores());
					}
				} else {
					JOptionPane.showMessageDialog(null, "Ìí¼ÓÊ§°Ü£¬ÇëÖØÐÂÌí¼Ó£¡");
					ClearAdd(even);
				}
			}
		});
		button.setIcon(new ImageIcon(addScoresFrame.class.getResource("/image/f-17 (2).png")));
		button.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));

		JButton btnNewButton = new JButton("\u91CD  \u7F6E");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent even) {
				ClearAdd(even);
			}

		});
		btnNewButton.setIcon(new ImageIcon(addScoresFrame.class.getResource("/image/f-10.png")));
		btnNewButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup().addGap(36)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addComponent(lblNewLabel)
										.addComponent(lblNewLabel_3).addComponent(lblNewLabel_4)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNewLabel_2).addComponent(lblNewLabel_1)))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(mysqlText).addComponent(htmlText).addComponent(linuxText)
										.addComponent(nameText)
										.addComponent(studentidText, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup().addGap(50).addComponent(button)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNewButton)))
				.addContainerGap(85, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(28)
				.addGroup(groupLayout
						.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel).addComponent(studentidText,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1).addComponent(
						nameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(linuxText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_3).addComponent(
						htmlText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(26)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(mysqlText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4))
				.addGap(47).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(button)
						.addComponent(btnNewButton))
				.addContainerGap(55, Short.MAX_VALUE)));
		getContentPane().setLayout(groupLayout);

	}

	/**
	 * Çå¿Õ²Ù×÷
	 */
	private void ClearAdd(ActionEvent even) {
		nameText.setText("");
		studentidText.setText("");
		linuxText.setText("");
		htmlText.setText("");
		mysqlText.setText("");
	}
}
