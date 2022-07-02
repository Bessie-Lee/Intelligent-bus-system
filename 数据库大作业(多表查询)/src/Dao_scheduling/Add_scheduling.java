package Dao_scheduling;


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

public class Add_scheduling extends JDialog implements ActionListener{
	/*
	 * 实现序列化接口,用于跨版本翻译
	 */
	private static final long SerialVersionUID =1L;

	private JPanel jp1,jp2;	//局面分布面板。

	JLabel JL=new JLabel("添加排班信息",JLabel.CENTER);//创建主标签

	JLabel JLcode= new JLabel("排班编号:");
	JTextField JTcode= new JTextField();

	JLabel JLlineCode= new JLabel("线路名称:");
	JTextField JTlineCode= new JTextField();

	JLabel JLbusLinense= new JLabel("车辆信息:");
	JTextField JTbusLinense= new JTextField();

	JLabel JLtcNumber= new JLabel("趟次:");
	JTextField JTtcNumber= new JTextField();

	JLabel JLtcTime= new JLabel("每趟时间:");
	JTextField JTtcTime= new JTextField();

	JLabel JLuserCode= new JLabel("司机姓名:");
	JTextField JTuserCode= new JTextField();

	JLabel JLstartStation= new JLabel("始发站点:");
	JTextField JTstartStation= new JTextField();

	JLabel JLendStation= new JLabel("终点站点:");
	JTextField JTendStation= new JTextField();

	// 三个按钮
	JButton JB1=new JButton("添加");
	JButton JB2=new JButton("重置");
	JButton JB3=new JButton("退出");
	ImageIcon image=new ImageIcon("E:\\上课\\大二\\数据库\\数据库实训暑期大作业\\数据库大作业代码\\数据库大作业\\白天.png");
	JLabel label=new JLabel(image);

	// 创建连接数据方法
	String sql="";
	String sql1="";
	String sql2="";
	//创建构造方法
	public Add_scheduling()
	{
		Container c = this.getContentPane();
		jp1 = new JPanel();

		// 设置窗口大小
		this.setSize(700,450);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		//
		this.setTitle("添加排班信息");
		this.setLayout(null);//设置窗口布局管理器为null,用setBounds()方法设置组件位置


		//
		JLcode.setFont(new Font("黑体", Font.PLAIN, 30));
		JTcode.setFont(new Font("黑体", Font.PLAIN, 30));
		JLcode.setBounds(20,30,150,30);
		this.add(JLcode);
		JTcode.setBounds(170,30,150,30);
		this.add(JTcode);

		//
		JLlineCode.setFont(new Font("黑体", Font.PLAIN, 30));
		JTlineCode.setFont(new Font("黑体", Font.PLAIN, 30));
		JLlineCode.setBounds(350,30,150,30);
		this.add(JLlineCode);
		JTlineCode.setBounds(500,30,150,30);
		this.add(JTlineCode);



		//
		JLbusLinense.setFont(new Font("黑体", Font.PLAIN, 30));
		JTbusLinense.setFont(new Font("黑体", Font.PLAIN, 30));
		JLbusLinense.setBounds(20,100,150,30);
		this.add(JLbusLinense);
		JTbusLinense.setBounds(170,100,150,30);
		this.add(JTbusLinense);

		//
		JLtcNumber.setFont(new Font("黑体", Font.PLAIN, 30));
		JTtcNumber.setFont(new Font("黑体", Font.PLAIN, 30));
		JLtcNumber.setBounds(400,100,150,30);
		this.add(JLtcNumber);
		JTtcNumber.setBounds(500,100,150,30);
		this.add(JTtcNumber);


		JLtcTime.setFont(new Font("黑体", Font.PLAIN, 30));
		JTtcTime.setFont(new Font("黑体", Font.PLAIN, 30));
		JLtcTime.setBounds(20,170,150,30);
		this.add(JLtcTime);
		JTtcTime.setBounds(170,170,150,30);
		this.add(JTtcTime);

		JLuserCode.setFont(new Font("黑体", Font.PLAIN, 30));
		JTuserCode.setFont(new Font("黑体", Font.PLAIN, 30));
		JLuserCode.setBounds(350,170,150,30);
		this.add(JLuserCode);
		JTuserCode.setBounds(500,170,150,30);
		this.add(JTuserCode);

		JLstartStation.setFont(new Font("黑体", Font.PLAIN, 30));
		JTstartStation.setFont(new Font("黑体", Font.PLAIN, 30));
		JLstartStation.setBounds(20,240,150,30);
		this.add(JLstartStation);
		JTstartStation.setBounds(170,240,150,30);
		this.add(JTstartStation);

		JLendStation.setFont(new Font("黑体", Font.PLAIN, 30));
		JTendStation.setFont(new Font("黑体", Font.PLAIN, 30));
		JLendStation.setBounds(350,240,150,30);
		this.add(JLendStation);
		JTendStation.setBounds(500,240,150,30);
		this.add(JTendStation);


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
			// 修改：line
			line line = new line();
			scheduling scheduling = new scheduling();
			scheduling.setCode(JTcode.getText());
			line.setLineName(JTlineCode.getText()); //从文本框获取的线路名称
			scheduling.setBusLinense(JTbusLinense.getText());
			scheduling.setTcNumber(JTtcNumber.getText());
			scheduling.setTcTime(JTtcTime.getText());
			scheduling.setUserCode(JTuserCode.getText());
			scheduling.setStartStation(JTstartStation.getText());
			scheduling.setEndStation(JTendStation.getText());


			sql1="select * from 排班 where code='"+ scheduling.getCode()+"'";
			sql2="select * from 线路 where lineName='"+line.getLineName()+"'";
			//连接数据库
			DBconnector conn=new DBconnector();
			Connection con=conn.getConnection();
			//创建Statement对象
			try {
				Statement stmt1 =(Statement) con.createStatement();
				ResultSet rs1= (ResultSet) stmt1.executeQuery(sql1);
				//rs1.last();
				Statement stmt2 =(Statement) con.createStatement();
				ResultSet rs2= (ResultSet) stmt2.executeQuery(sql2);
				//rs2.last();
				System.out.println("资源获得成功");
				if(rs1.next())
				{
					JOptionPane.showMessageDialog(null,"该排班编号已经存在");
					rs1.close();
				}
				else{
					// 如果在line表中存在这个linecode编号
					if(rs2.next())
					{
					sql="insert into 排班(code,lineCode, busLinense,tcNumber,tcTime,userCode,startStation,endStation) "
							+ "values('"+ scheduling.getCode()+"','"+ line.getLineName()+"','"+ scheduling.getBusLinense()+"','"
							+ scheduling.getTcNumber()+"','"+ scheduling.getTcTime()+"','"
							+ scheduling.getUserCode()+"','"+ scheduling.getStartStation()+"','"+ scheduling.getEndStation()+"');";
					int i= stmt1.executeUpdate(sql);
					System.out.println(line.getLineName());
					System.out.println(scheduling.getLineCode());
					if(i>0)
					{
						JOptionPane.showMessageDialog(null,"添加成功");
					}
					else{
						JOptionPane.showMessageDialog(null,"添加失败");
					}
					}
					else{
						JOptionPane.showMessageDialog(null,"该线路编号不存在于线路中，请先在线路中添加！");
						rs2.close();
					}
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==JB2)
		{
			JTcode.setText(null);
			JTlineCode.setText(null);
			JTbusLinense.setText(null);
			JTtcNumber.setText(null);
			JTtcTime.setText(null);
			JTuserCode.setText(null);
			JTstartStation.setText(null);
			JTendStation.setText(null);
		}
		else if(e.getSource()==JB3)
		{
			this.setVisible(false);
		}

	}
	public static void main(String[] args) {
		new Add_scheduling();
	}
}
