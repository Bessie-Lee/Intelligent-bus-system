package Dao_line;


import Dao.DBconnector;
import Dao_bus.bus;

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

public class Add_line extends JDialog implements ActionListener{
	/*
	 * 实现序列化接口,用于跨版本翻译
	 */
	private static final long SerialVersionUID =1L;

	private JPanel jp1,jp2;	//局面分布面板。

	JLabel JLlineCode= new JLabel("线路编号:");
	JTextField JTlineCode= new JTextField();

	JLabel JLlineName= new JLabel("线路名称:");
	JTextField JTlineName= new JTextField();

	JLabel JLstatus= new JLabel("线路状态:");
	JTextField JTstatus= new JTextField();
	ButtonGroup BG=new ButtonGroup();//创建一个ButtonGroup标签对象
	JRadioButton JRB1=new JRadioButton("开启");//创建单选按钮
	JRadioButton JRB2=new JRadioButton("关闭");

	JLabel JLstartLineTime= new JLabel("开线时间:");
	JTextField JTstartLineTime= new JTextField();

	JLabel JLdirection= new JLabel("线路方向:");
	JTextField JTdirection= new JTextField();

	// 三个按钮
	JButton JB1=new JButton("添加");
	JButton JB2=new JButton("重置");
	JButton JB3=new JButton("退出");
	ImageIcon image=new ImageIcon("E:\\上课\\大二\\数据库\\数据库实训暑期大作业\\数据库大作业代码\\数据库大作业\\白天.png");
	JLabel label=new JLabel(image);

	// 创建连接数据方法
	String sql="";
	//创建构造方法
	public Add_line()
	{
		Container c = this.getContentPane();
		jp1 = new JPanel();

		// 设置窗口大小
		this.setSize(700,450);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		//
		this.setTitle("添加线路信息");
		this.setLayout(null);//设置窗口布局管理器为null,用setBounds()方法设置组件位置

		//
		JLlineCode.setFont(new Font("黑体", Font.PLAIN, 30));
		JTlineCode.setFont(new Font("黑体", Font.PLAIN, 30));
		JLlineCode.setBounds(20,50,150,30);
		this.add(JLlineCode);
		JTlineCode.setBounds(150,50,150,30);
		this.add(JTlineCode);

		//
		JLlineName.setFont(new Font("黑体", Font.PLAIN, 30));
		JTlineName.setFont(new Font("黑体", Font.PLAIN, 30));
		JLlineName.setBounds(330,50,150,30);
		this.add(JLlineName);
		JTlineName.setBounds(470,50,150,30);
		this.add(JTlineName);

		//
		JLstatus.setFont(new Font("黑体", Font.PLAIN, 30));
		JRB1.setFont(new Font("黑体", Font.PLAIN, 30));
		JRB2.setFont(new Font("黑体", Font.PLAIN, 30));
		JLstatus.setBounds(100,140,150,30);//设置单选标签位置
		this.add(JLstatus);
		JRB1.setBounds(280,140,110,30);
		JRB2.setBounds(420,140,110,30);
		this.add(JRB1);//添加到窗口
		this.add(JRB2);
		BG.add(JRB1);//将单选按钮添加到ButtonGroup组件
		BG.add(JRB2);



		//
		JLstartLineTime.setFont(new Font("黑体", Font.PLAIN, 30));
		JTstartLineTime.setFont(new Font("黑体", Font.PLAIN, 30));
		JLstartLineTime.setBounds(20,230,150,30);
		this.add(JLstartLineTime);
		JTstartLineTime.setBounds(160,230,150,30);
		this.add(JTstartLineTime);

		JLdirection.setFont(new Font("黑体", Font.PLAIN, 30));
		JTdirection.setFont(new Font("黑体", Font.PLAIN, 30));
		JLdirection.setBounds(330,230,150,30);
		this.add(JLdirection);
		JTdirection.setBounds(470,230,150,30);
		this.add(JTdirection);



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
			line line=new line();//实例化对象
			line.setLineCode(JTlineCode.getText());
			line.setLineName(JTlineName.getText());

			line.setStatus("开启");
			if(JRB1.isSelected())
				line.setStatus("关闭");

			line.setStartLineTime(JTstartLineTime.getText());
			line.setDirection(JTdirection.getText());



			sql="select * from 线路 where lineCode='"+line.getLineCode()+"'";
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
					JOptionPane.showMessageDialog(null,"该线路编号已经存在");
					rs.close();
				}
				else{
					sql="insert into 线路(lineCode,lineName,status,startLineTime,direction) "
							+ "values('"+line.getLineCode()+"','"+line.getLineName()+"','"+line.getStatus()+"','"+line.getStartLineTime()+"','"+
							line.getDirection()+"');";
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
			JTlineCode.setText(null);
			JTlineName.setText(null);
			JTstatus.setText(null);
			JTstartLineTime.setText(null);
			JTdirection.setText(null);
		}
		else if(e.getSource()==JB3)
		{
			this.setVisible(false);
		}

	}
	public static void main(String[] args) {
		new Add_line();
	}
}
