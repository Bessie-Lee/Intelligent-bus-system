package Dao_line_station;


import Dao.DBconnector;
import Dao_line.line;

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

public class Add_line_station extends JDialog implements ActionListener{
	/*
	 * 实现序列化接口,用于跨版本翻译
	 */
	private static final long SerialVersionUID =1L;

	private JPanel jp1,jp2;	//局面分布面板。

	JLabel JLlineCode= new JLabel("线路编号:");
	JTextField JTlineCode= new JTextField();

	JLabel JLstationCode= new JLabel("站点编号:");
	JTextField JTstationCode= new JTextField();

	JLabel JLid= new JLabel("线路站点序号:");
	JTextField JTid= new JTextField();
	// 三个按钮
	JButton JB1=new JButton("添加");
	JButton JB2=new JButton("重置");
	JButton JB3=new JButton("退出");
	ImageIcon image=new ImageIcon("E:\\上课\\大二\\数据库\\数据库实训暑期大作业\\数据库大作业代码\\数据库大作业\\白天.png");
	JLabel label=new JLabel(image);

	// 创建连接数据方法
	String sql="";
	//创建构造方法
	public Add_line_station()
	{
		Container c = this.getContentPane();
		jp1 = new JPanel();

		// 设置窗口大小
		this.setSize(700,450);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		// 添加学生信息
		this.setTitle("添加线路站点信息");
		this.setLayout(null);//设置窗口布局管理器为null,用setBounds()方法设置组件位置

		//
		JLlineCode.setFont(new Font("黑体", Font.PLAIN, 30));
		JTlineCode.setFont(new Font("黑体", Font.PLAIN, 30));
		JLlineCode.setBounds(150,50,150,30);
		this.add(JLlineCode);
		JTlineCode.setBounds(300,50,150,30);
		this.add(JTlineCode);

		//
		JLstationCode.setFont(new Font("黑体", Font.PLAIN, 30));
		JTstationCode.setFont(new Font("黑体", Font.PLAIN, 30));
		JLstationCode.setBounds(150,150,150,30);
		this.add(JLstationCode);
		JTstationCode.setBounds(300,150,150,30);
		this.add(JTstationCode);

		//
		JLid.setFont(new Font("黑体", Font.PLAIN, 30));
		JTid.setFont(new Font("黑体", Font.PLAIN, 30));
		JLid.setBounds(60,250,200,30);
		this.add(JLid);
		JTid.setBounds(300,250,150,30);
		this.add(JTid);

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
			line_station line_station=new line_station();//实例化对象
			line_station.setLineCode(JTlineCode.getText());
			line_station.setStationCode(JTstationCode.getText());
			line_station.setId(JTid.getText());


			sql="select * from 线路站点 where lineCode = \""+line_station.getLineCode()+"\"" +
					" and stationCode = \""+line_station.getStationCode()+"\";";
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
					sql="insert into 线路站点(lineCode,stationCode,id) "
							+ "values('"+line_station.getLineCode()+"','"+line_station.getStationCode()+"','"+line_station.getId()+"');";
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
			JTstationCode.setText(null);
			JTid.setText(null);
		}
		else if(e.getSource()==JB3)
		{
			this.setVisible(false);
		}

	}
	public static void main(String[] args) {
		new Add_line_station();
	}
}
