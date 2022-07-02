package Main;

import Dao_scheduling.Get_scheduling;
import Dao_users.Get_user;
import Dao_password.Updata_E_password;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class employee extends JFrame implements ActionListener{


	// 创建三个按钮
	private static final long serialVersionUID = 1L;
	JButton JB1=new JButton();
	JButton JB2=new JButton();
	JButton JB3=new JButton();

	ImageIcon image=new ImageIcon("E:\\上课\\大二\\数据库\\数据库实训暑期大作业\\数据库大作业代码\\数据库大作业\\员工.png");
	JLabel label=new JLabel(image);
	String name1 = null;
	public employee(String name)
	{
		// 标题
		name1 = name;
		this.setTitle("员工界面管理");
		this.setBackground(Color.DARK_GRAY);
		this.setLayout(null);
		this.setSize(700,700);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		// 个人信息查询
		JB1.setText("个人信息查询");
		JB1.setFont(new Font("黑体", Font.PLAIN, 20));
		JB1.setBounds(250,420,200,40);
		JB1.addActionListener(this);
		this.add(JB1);

		// 个人成绩查询
		JB2.setText("排班信息查询");
		JB2.setFont(new Font("黑体", Font.PLAIN, 20));
		JB2.setBounds(250,500,200,40);
		JB2.addActionListener(this);
		this.add(JB2);

		// 修改密码
		JB3.setText("修改密码");
		JB3.setFont(new Font("黑体", Font.PLAIN, 20));
		JB3.setBounds(250,580,200,40);
		JB3.addActionListener(this);
		this.add(JB3);

		// 设置图片大小
		this.setLayout(null);
		this.add(label);
		label.setBounds(0,0,700,400);

		addWindowListener(new WindowAdapter() {
			public void windowClosing (WindowEvent e)
			{
				dispose();
			}
		});

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// 查询信息
		if(e.getSource()==JB1)
		{
			new Get_user();
		}
		// 查询排班
		else if(e.getSource()==JB2)
		{
			new Get_scheduling(name1);
		}
		// 修改密码
		else if(e.getSource()==JB3)
		{
			new Updata_E_password();
		}
	}
	public static void main(String[] args) {
		String name  = "111";
		new employee(name);
	}
}
