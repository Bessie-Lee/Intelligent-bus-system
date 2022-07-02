package Dao_password;

import java.awt.Color;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import Dao.DBconnector;
import Dao_users.users;

public class Updata_E_password extends JFrame  implements ActionListener{

	// 初始化标签及文本框
	private static final long serialVersionUID = 1L;
	JLabel JL1=new JLabel("原密码：");
	JTextField JT1=new JTextField();
	JLabel JL2=new JLabel("新密码：");
	JTextField JT2=new JTextField();
	JLabel JLuserName= new JLabel("用户名:");
	JTextField JTuserName= new JTextField();

	// 三个按钮
	JButton JB1=new JButton("修改");
	JButton JB2=new JButton("重置");
	JButton JB3=new JButton("退出");

	ImageIcon image=new ImageIcon("E:\\上课\\大二\\数据库\\数据库实训暑期大作业\\数据库大作业代码\\数据库大作业\\白天.png");
	JLabel label=new JLabel(image);
	// 数据库语句
	String sql="";

	public Updata_E_password() {

		// 设置窗口
		this.setTitle("修改密码");
		this.setSize(700,450);
		this.setLocationRelativeTo(null);
		this.setResizable(false);//设置窗口不可拉伸
		this.setVisible(true);

		// 修改密码
		JLuserName.setFont(new Font("黑体", Font.PLAIN, 30));
		JTuserName.setFont(new Font("黑体", Font.PLAIN, 30));
		JLuserName.setBounds(190,80,120,40);
		this.add(JLuserName);
		JTuserName.setBounds(350,80,150,40);
		this.add(JTuserName);

		JL1.setFont(new Font("黑体", Font.PLAIN, 30));
		JT1.setFont(new Font("黑体", Font.PLAIN, 30));
		JL1.setBounds(190,160,120,40);
		this.add(JL1);
		JT1.setBounds(350,160,150,40);
		this.add(JT1);

		JL2.setFont(new Font("黑体", Font.PLAIN, 30));
		JT2.setFont(new Font("黑体", Font.PLAIN, 30));
		JL2.setBounds(190,240,120,40);
		this.add(JL2);
		JT2.setBounds(350,240,150,40);
		this.add(JT2);

		JB1.setFont(new Font("黑体", Font.PLAIN, 30));
		JB2.setFont(new Font("黑体", Font.PLAIN, 30));
		JB3.setFont(new Font("黑体", Font.PLAIN, 30));
		JB1.setBounds(80,340,120,40);
		this.add(JB1);
		JB1.addActionListener(this);
		JB2.setBounds(280,340,120,40);
		this.add(JB2);
		JB2.addActionListener(this);
		JB3.setBounds(480,340,120,40);
		this.add(JB3);
		JB3.addActionListener(this);

		this.setLayout(null);
		this.add(label);
		label.setBounds(0,0,700,450);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e)
			{
				dispose();
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==JB1)
		{
			// 获取
			String Sno=JTuserName.getText();
			// 密码
			String paw1=JT1.getText();
			String paw2=JT2.getText();
			// System.out.println(paw1);123
			// System.out.println(paw2);1234


			// 输入为空的情况
			if(JTuserName.getText().equals("")||paw1.equals("")||paw2.equals(""))
			{
				JOptionPane.showMessageDialog(null,"请输入完整个人信息");
			}

			//连接数据库
			DBconnector conn=new DBconnector();
			Connection con=(Connection) conn.getConnection();
			System.out.println("连接成功");
			ResultSet rs=null;

			try {

				Statement stmt=(Statement) con.createStatement();
				sql="select * from 员工登录 where userName='"+Sno+"' ";

				rs=(ResultSet) stmt.executeQuery(sql);
				System.out.println(rs);
				if(rs.next())
				{
					if(rs.getString(2).equals(paw1))
					{
						sql="update 员工登录 set password  = '"+paw2+ "' where userName='"+Sno+"' ";
						int i=stmt.executeUpdate(sql);
						if(i>0)
						{
							JOptionPane.showMessageDialog(null,"修改成功");
						}
						else{
							JOptionPane.showMessageDialog(null,"修改失败");
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null,"原密码输入有误");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null,"用户名输入有误");
				}

			} catch (SQLException e1) {

				e1.printStackTrace();
			}
		}else if(e.getSource()==JB2)
		{
			JT1.setText(null);
			JT2.setText(null);
			JTuserName.setText(null);
		}else if(e.getSource()==JB3)
		{
			System.exit(0);
		}
	}
	public static void main(String [] args)
	{
		new Updata_E_password();
	}
}
