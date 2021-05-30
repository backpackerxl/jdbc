package com.mysql.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JDesktopPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/image/f-07.png")));
		setTitle("\u5B66\u751F\u7BA1\u7406\u7CFB\u7EDF-\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("\u7CFB\u7EDF\u8BBE\u7F6E");
		mnNewMenu.setIcon(new ImageIcon(MainFrame.class.getResource("/image/f-15.png")));
		mnNewMenu.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("\u67E5\u770B\u7BA1\u7406\u5458\u4FE1\u606F");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent even) {
				showAdmin admin = new showAdmin();
				admin.setVisible(true);
				// 把他放在虚拟桌面
				desktopPane.add(admin);
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon(MainFrame.class.getResource("/image/f-19.png")));
		mntmNewMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u9000\u51FA\u7CFB\u7EDF");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent even) {
				JOptionPane.showMessageDialog(null, "确定退出吗 ？");
				destory();
			}
		});

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent even) {
				Modification admin = new Modification();
				admin.setVisible(true);
				// 把他放在虚拟桌面
				desktopPane.add(admin);
			}
		});
		mntmNewMenuItem_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		mntmNewMenuItem_1.setIcon(new ImageIcon(MainFrame.class.getResource("/image/f-20.png")));
		mnNewMenu.add(mntmNewMenuItem_1);
		mntmNewMenuItem_2.setIcon(new ImageIcon(MainFrame.class.getResource("/image/f-21.png")));
		mntmNewMenuItem_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		mnNewMenu.add(mntmNewMenuItem_2);

		JMenu mnNewMenu_1 = new JMenu("\u5B66\u751F\u7BA1\u7406");
		mnNewMenu_1.setIcon(new ImageIcon(MainFrame.class.getResource("/image/f-14.png")));
		mnNewMenu_1.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u6DFB\u52A0\u5B66\u751F");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent even) {
				addStudenFrame student = new addStudenFrame();
				student.setVisible(true);
				// 把他放在虚拟桌面
				desktopPane.add(student);
			}
		});
		mntmNewMenuItem_3.setIcon(new ImageIcon(MainFrame.class.getResource("/image/f-17 (2).png")));
		mntmNewMenuItem_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		mnNewMenu_1.add(mntmNewMenuItem_3);

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("\u67E5\u770B\u5B66\u751F");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent even) {
				showStudentFrame(even);
			}

			/**
			 * 显示查看学生页面
			 * 
			 * @param even
			 */
			private void showStudentFrame(ActionEvent even) {
				ShowStudebtInformation student = new ShowStudebtInformation();
				student.setVisible(true);
				// 把他放在虚拟桌面
				desktopPane.add(student);
			}
		});
		mntmNewMenuItem_4.setIcon(new ImageIcon(MainFrame.class.getResource("/image/f-13 (2).png")));
		mntmNewMenuItem_4.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		mnNewMenu_1.add(mntmNewMenuItem_4);

		JMenuItem mntmNewMenuItem_6 = new JMenuItem("\u67E5\u770B\u6210\u7EE9");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent even) {
				showStudentScores student = new showStudentScores();
				student.setVisible(true);
				// 把他放在虚拟桌面
				desktopPane.add(student);
			}
		});

		JMenuItem mntmNewMenuItem_7 = new JMenuItem("\u6DFB\u52A0\u6210\u7EE9");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent even) {
				addScoresFrame student = new addScoresFrame();
				student.setVisible(true);
				// 把他放在虚拟桌面
				desktopPane.add(student);
			}
		});
		mntmNewMenuItem_7.setIcon(new ImageIcon(MainFrame.class.getResource("/image/f-17 (2).png")));
		mntmNewMenuItem_7.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		mnNewMenu_1.add(mntmNewMenuItem_7);
		mntmNewMenuItem_6.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		mntmNewMenuItem_6.setIcon(new ImageIcon(MainFrame.class.getResource("/image/f-36.png")));
		mnNewMenu_1.add(mntmNewMenuItem_6);

		JMenu mnNewMenu_2 = new JMenu("\u5173\u4E8E\u6211\u4EEC");
		mnNewMenu_2.setIcon(new ImageIcon(MainFrame.class.getResource("/image/f-16.png")));
		mnNewMenu_2.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		menuBar.add(mnNewMenu_2);

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("\u8054\u7CFB\u65B9\u5F0F");
		mntmNewMenuItem_5.setIcon(new ImageIcon(MainFrame.class.getResource("/image/f-18 (2).png")));
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent even) {
				showAboutOur(even);
			}

			/**
			 * 展示关于我们的界面
			 * 
			 * @param even
			 */
			private void showAboutOur(ActionEvent even) {
				// 打开关于我们
				AboutOur about = new AboutOur();
				about.setVisible(true);
				// 把他放在虚拟桌面
				desktopPane.add(about);
			}
		});
		mntmNewMenuItem_5.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		mnNewMenu_2.add(mntmNewMenuItem_5);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);

		setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	/**
	 * 退出程序
	 */
	protected void destory() {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	/**
	 * 关闭主窗口
	 */
	public void ColseMainFrame() {
		// TODO Auto-generated method stub
		System.exit(0);// 关闭当前窗口
		new AdminLoginFrame().setVisible(true);
	}
}
