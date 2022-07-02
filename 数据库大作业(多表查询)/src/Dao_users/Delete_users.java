package Dao_users;

import Dao.DBconnector;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete_users extends JFrame implements ActionListener{

	private static final long serialVersionUID=1L;

	ImageIcon image=new ImageIcon("E:\\上课\\大二\\数据库\\数据库实训暑期大作业\\数据库大作业代码\\数据库大作业\\卡通汽车.png");
	JLabel label=new JLabel(image);
	// 标题
	JLabel JL=new JLabel("删除员工基本信息",JLabel.CENTER);
	//
	JLabel JLidcode= new JLabel("ID号:");
	JTextField JTidcode= new JTextField();


	JButton JB1=new JButton("删除");
	JButton JB2=new JButton("重置");
	JButton JB3=new JButton("退出");

	String sql="";
	//定义构造函数
	public Delete_users()
	{
		//设置窗口
		this.setTitle("删除员工信息");
		this.setSize(700,450);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setVisible(true);

		this.setLayout(null);
		this.add(label);
		label.setBounds(0,0,700,260);

		// 设置题目信息
		JL.setForeground(Color.red);
		JL.setFont(new Font("宋体",Font.PLAIN,19));
		JL.setBounds(150,30,200,40);
		this.add(JL);

		//
		JLidcode.setFont(new Font("黑体", Font.PLAIN, 30));
		JTidcode.setFont(new Font("黑体", Font.PLAIN, 30));
		JLidcode.setBounds(200,280,100,30);
		this.add(JLidcode);
		JTidcode.setBounds(300,280,150,30);
		this.add(JTidcode);

		// 三个按钮
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

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e)
			{
				dispose();
			}
		});
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==JB1)
		{
			users users=new users();//实例化对象
			users.setIdcode(JTidcode.getText());

			sql="select * from 用户 where idcode="+users.getIdcode();
			DBconnector conn=new DBconnector();
			Connection con=conn.getConnection();
			try {
				Statement stmt=(Statement) con.createStatement();
				ResultSet rs=(ResultSet) stmt.executeQuery(sql);
				if(rs.next())//如果查询结果存在
				{
					sql="delete from 用户 where idcode="+users.getIdcode();
					int n=stmt.executeUpdate(sql);//更新
					if(n>0)JOptionPane.showMessageDialog(null, "删除成功");
					else JOptionPane.showMessageDialog(null, "删除失败");
				}
				else
				{
					rs.close();
					JOptionPane.showMessageDialog(null, "此编号不存在");
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==JB2)
		{
			JTidcode.setText(null);
		}
		else
		{
			this.setVisible(false);//隐藏当前窗口
		}

	}
	public static void main(String[] args) {
		new Delete_users();
	}
}
