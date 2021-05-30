package com.mysql.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class AboutOur extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
					AboutOur frame = new AboutOur();
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
	public AboutOur() {
		setForeground(SystemColor.inactiveCaptionBorder);
		setBackground(SystemColor.inactiveCaption);
		setTitle("\u5173\u4E8E\u6211\u4EEC");
		getContentPane().setBackground(SystemColor.activeCaption);
		setFrameIcon(new ImageIcon(AboutOur.class.getResource("/image/f-08.png")));
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 483, 408);

		JLabel lblNewLabel = new JLabel(
				"\u8054\u7CFB\u65B9\u5F0F\uFF1AQQ\uFF1A946115360     phone\uFF1A18283520430\r\n");
		lblNewLabel.setForeground(SystemColor.inactiveCaptionBorder);
		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));

		JLabel lblNewLabel_1 = new JLabel(
				"\u6709\u4EFB\u4F55\u6280\u672F\u95EE\u9898\u90FD\u53EF\u4EE5\u8054\u7CFB\uFF0C\u975E\u8BDA\u52FF\u6270\r\n");
		lblNewLabel_1.setForeground(SystemColor.inactiveCaptionBorder);
		lblNewLabel_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));

		JLabel lblNewLabel_2 = new JLabel("\u672C\u4EBA\u6B64\u9879\u76EE\u6E90\u4EE3\u7801\u5730\u5740\uFF1A");
		lblNewLabel_2.setForeground(SystemColor.inactiveCaptionBorder);
		lblNewLabel_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));

		JLabel lblNewLabel_3 = new JLabel("<html><a href='https://gitee.com/backpackerxl/jdbc'>Ñ§Éú¹ÜÀíÏµÍ³</a></html>");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent even) {
				goGiteeBackPackerxl(even);
			}

			/**
			 * Ìø×ªµ½ÏîÄ¿Ò³Ãæ
			 * 
			 * @param even
			 */
			private void goGiteeBackPackerxl(MouseEvent even) {
				String url = "https://gitee.com/backpackerxl/jdbc";
				try {
					Runtime.getRuntime().exec("cmd.exe /c start " + url);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});

		lblNewLabel_3.setForeground(new Color(204, 51, 204));
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 16));

		JLabel lblNewLabel_4 = new JLabel(
				"\u6B64\u9879\u76EE\u65E0\u4EFB\u4F55\u6846\u67B6\u6280\u672F\uFF0C\u662FJDBC+Java Swing\u6253\u9020\u7684");
		lblNewLabel_4.setForeground(SystemColor.inactiveCaptionBorder);
		lblNewLabel_4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));

		JLabel lblNewLabel_5 = new JLabel(
				"\u5B66\u751F\u7BA1\u7406\u7CFB\u7EDF\uFF0C\u540E\u7EED\u8FD8\u4F1A\u66F4\u65B0\uFF0C\u8BF7\u5173\u6CE8gitee\u6E90\u7801\u5730\u5740\u3002");
		lblNewLabel_5.setForeground(SystemColor.inactiveCaptionBorder);
		lblNewLabel_5.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));

		JLabel lblNewLabel_6 = new JLabel(
				"\u6CE8\u610F\uFF1A\u82F9\u679C\u7535\u8111\u8BF7\u8F93\u5165\u4EE5\u4E0B\u7F51\u5740\uFF1A");
		lblNewLabel_6.setForeground(SystemColor.inactiveCaptionBorder);
		lblNewLabel_6.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));

		JLabel lblNewLabel_7 = new JLabel("https://gitee.com/backpackerxl/jdbc");
		lblNewLabel_7.setForeground(new Color(153, 51, 204));
		lblNewLabel_7.setFont(new Font("Arial", Font.PLAIN, 16));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(45)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel_7)
						.addComponent(lblNewLabel_6).addComponent(lblNewLabel_5).addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2).addComponent(lblNewLabel_3).addComponent(lblNewLabel_4))
				.addContainerGap(30, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(55)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel_2).addGap(18)
						.addComponent(lblNewLabel_3).addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(lblNewLabel_4).addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(lblNewLabel_5).addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(lblNewLabel_6).addGap(18).addComponent(lblNewLabel_7)
						.addContainerGap(38, Short.MAX_VALUE)));
		getContentPane().setLayout(groupLayout);

	}
}
