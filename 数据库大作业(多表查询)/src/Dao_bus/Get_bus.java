package Dao_bus;

import Dao.DBconnector;
import Dao_station.station;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class Get_bus extends JFrame{
	private static final long serialVersionUID = 1L;

	//存放所有车辆信息
	Vector all=new Vector();
	//存储表头车辆信息向量
	Vector tablehead=new Vector();

	// 创建标题与窗体
	JScrollPane jsl=new JScrollPane();//设置滚动面板

	JLabel JLbusCode= new JLabel("车辆编号:");
	JTextField JTbusCode= new JTextField();

	JLabel JLbusLicense= new JLabel("车牌号:");
	JTextField JTbusLicense= new JTextField();

	JLabel JLbusStatus= new JLabel("车辆状态:");
	JTextField JTbusStatus= new JTextField();
	ButtonGroup BG=new ButtonGroup();//创建一个ButtonGroup标签对象
	JRadioButton JRB1=new JRadioButton("开启");//创建单选按钮
	JRadioButton JRB2=new JRadioButton("关闭");

	JLabel JLbusType= new JLabel("车型:");
	JTextField JTbusType= new JTextField();

	JLabel JLstartTime= new JLabel("起运时间:");
	JTextField JTstartTime= new JTextField();


	ImageIcon image=new ImageIcon("E:\\上课\\大二\\数据库\\数据库实训暑期大作业\\数据库大作业代码\\数据库大作业\\白天.png");
	JLabel label=new JLabel(image);
	// 定义构造方法
	// 建立数据库连接
	String sql="";
	public Get_bus()
	{

		//this.setLayout(null);
		//this.add(label);
		//label.setBounds(100,100,1000,700);

		// 数据库查询语句
		sql="select * from 车辆 ;";
		//连接数据库
		DBconnector conn=new DBconnector();
		Connection con=(Connection) conn.getConnection();
		ResultSet rs=null;
		Statement stmt;
		try {
			stmt = (Statement) con.createStatement();
			rs=(ResultSet) stmt.executeQuery(sql);

			tablehead.add("车辆编号");
			tablehead.add("车牌号");
			tablehead.add("车辆状态");
			tablehead.add("车型");
			tablehead.add("起运时间");


			while(rs.next())
			{
				// 建立车辆对象
				bus bus=new bus();//实例化对象
				bus.setBusCode(rs.getString("busCode"));
				bus.setBusLicense(rs.getString("busLicense"));
				bus.setBusStatus(rs.getString("busStatus"));
				bus.setBusType(rs.getString("busType"));
				bus.setStartTime(rs.getString("startTime"));


				Vector vc=new Vector();

				vc.add(bus.getBusCode());
				vc.add(bus.getBusLicense());
				vc.add(bus.getBusStatus());
				vc.add(bus.getBusType());
				vc.add(bus.getStartTime());


				// 全部放入vc集合中
				all.add(vc);
			}


			JTable JT=new JTable(all,tablehead);


			JT.setRowHeight(20);//设置表格行高
			JT.setEnabled(false);//设置表格不可编辑
			jsl.setViewportView(JT);//显示在滚动面板



			this.add(jsl,BorderLayout.NORTH);
			this.setTitle("查询所有车辆信息");
			this.setSize(700,450);
			this.setLocationRelativeTo(null);
			this.setVisible(true);


		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		addWindowListener(new WindowAdapter() {//设置窗口监听器
			@SuppressWarnings("unused")
			public void windowsClosing(WindowEvent e)
			{
				dispose();
			}
		});
	}
	public void actionPerformed(ActionEvent e) {


	}


	public static void main(String[] args) {
		new Get_bus();
	}
}
