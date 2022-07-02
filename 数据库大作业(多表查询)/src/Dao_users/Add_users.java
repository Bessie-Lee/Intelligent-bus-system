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

public class Add_users extends JDialog implements ActionListener{
	/*
	 * 实现序列化接口,用于跨版本翻译
	 */
	private static final long SerialVersionUID =1L;

	private JPanel jp1,jp2;	//局面分布面板。

	JLabel JL=new JLabel("添加员工信息",JLabel.CENTER);//创建主标签

	JLabel JLidcode= new JLabel("ID号:");
	JTextField JTidcode= new JTextField();

	JLabel JLname= new JLabel("姓名:");
	JTextField JTname= new JTextField();

	JLabel JLphone= new JLabel("电话:");
	JTextField JTphone= new JTextField();

	JLabel JLidCard= new JLabel("身份证:");
	JTextField JTidCard= new JTextField();

	JLabel JLdriving= new JLabel("驾龄:");
	JTextField JTdriving= new JTextField();

	JLabel JLstatus= new JLabel("状态:");
	JTextField JTstatus= new JTextField();
	ButtonGroup BG=new ButtonGroup();//创建一个ButtonGroup标签对象
	JRadioButton JRB1=new JRadioButton("开启");//创建单选按钮
	JRadioButton JRB2=new JRadioButton("关闭");

	// 三个按钮
	JButton JB1=new JButton("添加");
	JButton JB2=new JButton("重置");
	JButton JB3=new JButton("退出");
	ImageIcon image=new ImageIcon("E:\\上课\\大二\\数据库\\数据库实训暑期大作业\\数据库大作业代码\\数据库大作业\\白天.png");
	JLabel label=new JLabel(image);

	// 创建连接数据方法
	String sql="";
	//创建构造方法
	public Add_users()
	{
		Container c = this.getContentPane();
		jp1 = new JPanel();

		// 设置窗口大小
		this.setSize(700,450);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		// 添加
		this.setTitle("添加员工信息");
		this.setLayout(null);//设置窗口布局管理器为null,用setBounds()方法设置组件位置

		//JL.setFont(new Font("宋体",Font.PLAIN,30));
		//JL.setBounds(100,40,200,40);
		//jp1.add(JL);

		//
		JLidcode.setFont(new Font("黑体", Font.PLAIN, 30));
		JTidcode.setFont(new Font("黑体", Font.PLAIN, 30));
		JLidcode.setBounds(50,50,100,30);
		this.add(JLidcode);
		JTidcode.setBounds(150,50,150,30);
		this.add(JTidcode);

		//
		JLname.setFont(new Font("黑体", Font.PLAIN, 30));
		JTname.setFont(new Font("黑体", Font.PLAIN, 30));
		JLname.setBounds(370,50,100,30);
		this.add(JLname);
		JTname.setBounds(470,50,150,30);
		this.add(JTname);



		//
		JLphone.setFont(new Font("黑体", Font.PLAIN, 30));
		JTphone.setFont(new Font("黑体", Font.PLAIN, 30));
		JLphone.setBounds(50,125,100,30);
		this.add(JLphone);
		JTphone.setBounds(150,125,150,30);
		this.add(JTphone);

		//
		JLidCard.setFont(new Font("黑体", Font.PLAIN, 30));
		JTidCard.setFont(new Font("黑体", Font.PLAIN, 30));
		JLidCard.setBounds(350,125,120,30);
		this.add(JLidCard);
		JTidCard.setBounds(470,125,150,30);
		this.add(JTidCard);

		JLdriving.setFont(new Font("黑体", Font.PLAIN, 30));
		JTdriving.setFont(new Font("黑体", Font.PLAIN, 30));
		JLdriving.setBounds(200,200,100,30);
		this.add(JLdriving);
		JTdriving.setBounds(300,200,150,30);
		this.add(JTdriving);

		//
		JLstatus.setFont(new Font("黑体", Font.PLAIN, 30));
		JRB1.setFont(new Font("黑体", Font.PLAIN, 30));
		JRB2.setFont(new Font("黑体", Font.PLAIN, 30));
		JLstatus.setBounds(150,250,100,30);//设置单选标签位置
		this.add(JLstatus);
		JRB1.setBounds(280,250,100,30);
		JRB2.setBounds(420,250,100,30);
		this.add(JRB1);//添加到窗口
		this.add(JRB2);
		BG.add(JRB1);//将单选按钮添加到ButtonGroup组件
		BG.add(JRB2);

		// 三个按钮
		JB1.setFont(new Font("黑体", Font.PLAIN, 30));
		JB2.setFont(new Font("黑体", Font.PLAIN, 30));
		JB3.setFont(new Font("黑体", Font.PLAIN, 30));
		JB1.setBounds(80,320,120,40);
		this.add(JB1);
		JB1.addActionListener(this);
		JB2.setBounds(280,320,120,40);
		this.add(JB2);
		JB2.addActionListener(this);
		JB3.setBounds(480,320,120,40);
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
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==JB1)
		{
			users users=new users();//实例化对象
			users.setIdcode(JTidcode.getText());
			users.setName(JTname.getText());
			users.setPhone(JTphone.getText());
			users.setIdCard(JTidCard.getText());
			users.setDriving(Integer.parseInt(JTdriving.getText()));
			users.setStatus("开启");
			if(JRB1.isSelected())
				users.setStatus("关闭");

			// '"+users.getIdcode()+"'
			sql="select * from 用户 where idcode='"+users.getIdcode()+"'";
			//连接数据库
			DBconnector conn=new DBconnector();
			Connection con=conn.getConnection();
			//创建Statement对象
			try {
				Statement stmt=(Statement) con.createStatement();
				ResultSet rs= (ResultSet) stmt.executeQuery(sql);
				System.out.println("资源获得成功");
				if(rs.next())
				{
					JOptionPane.showMessageDialog(null,"该编号已经存在");
					rs.close();
				}
				else{
					sql="insert into 用户(idcode,name,phone,idCard,driving,status) "
							+ "values('"+users.getIdcode()+"','"+users.getName()+"','"+users.getPhone()+"','"+users.getIdCard()+"','"+
							users.getDriving()+"','"+users.getStatus()+"');";
					int i=stmt.executeUpdate(sql);
					if(i>0)
					{
						JOptionPane.showMessageDialog(null,"添加成功");
					}
					else{
						JOptionPane.showMessageDialog(null,"添加失败");
					}
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==JB2)
		{
			JTidcode.setText(null);
			JTname.setText(null);
			JTphone.setText(null);
			JTidCard.setText(null);
			JTdriving.setText(null);
			JTstatus.setText(null);
		}
		else if(e.getSource()==JB3)
		{
			this.setVisible(false);
		}

	}
	public static void main(String[] args) {
		new Add_users();
	}
}
