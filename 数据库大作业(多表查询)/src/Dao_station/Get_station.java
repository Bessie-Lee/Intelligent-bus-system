package Dao_station;

import Dao.DBconnector;
import Dao_users.users;

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

public class Get_station extends JFrame{
	private static final long serialVersionUID = 1L;

	//存放所有信息
	Vector all=new Vector();
	//存储表头信息向量
	Vector tablehead=new Vector();

	// 创建标题与窗体

	JScrollPane jsl=new JScrollPane();//设置滚动面板

	//
	JLabel JLstationCode= new JLabel("站点编号:");
	JTextField JTstationCode= new JTextField();

	//
	JLabel JLstationName=new JLabel("站点名称:");
	JTextField JTstationName=new JTextField();

	//
	JLabel JLlongitude=new JLabel("经度:");
	JTextField JTlongitude=new JTextField();

	//
	JLabel JLlatitude=new JLabel("维度:");
	JTextField JTlatitude=new JTextField();

	JLabel JLregion= new JLabel("地区:");
	JTextField JTregion= new JTextField();


	JLabel JLstreet= new JLabel("街道:");
	JTextField JTstreet= new JTextField();



	ImageIcon image=new ImageIcon("E:\\上课\\大二\\数据库\\数据库实训暑期大作业\\数据库大作业代码\\数据库大作业\\白天.png");
	JLabel label=new JLabel(image);
	// 定义构造方法
	// 建立数据库连接
	String sql="";
	public Get_station()
	{

		//this.setLayout(null);
		//this.add(label);
		//label.setBounds(100,100,1000,700);

		// 数据库查询语句
		sql="select * from 站点 ;";
		//连接数据库
		DBconnector conn=new DBconnector();
		Connection con=(Connection) conn.getConnection();
		ResultSet rs=null;
		Statement stmt;
		try {
			stmt = (Statement) con.createStatement();
			rs=(ResultSet) stmt.executeQuery(sql);

			tablehead.add("站点编号");
			tablehead.add("站点名称");
			tablehead.add("经度");
			tablehead.add("维度");
			tablehead.add("地区");
			tablehead.add("街道");


			while(rs.next())
			{
				// 建立对象

				station station = new station ();//实例化对象

				station.setStationCode(rs.getString("stationCode"));
				station.setStationName(rs.getString("stationName"));
				station.setLongitude(rs.getInt("longitude"));
				station.setLatitude(rs.getInt("latitude"));
				station.setRegion(rs.getString("region"));
				station.setStreet(rs.getString("street"));

				Vector vc=new Vector();

				vc.add(station.getStationCode());
				vc.add(station.getStationName());
				vc.add(station.getLongitude());
				vc.add(station.getLatitude());
				vc.add(station.getRegion());
				vc.add(station.getStreet());
				System.out.println(vc);


				// 全部放入vc集合中
				all.add(vc);
			}


			JTable JT=new JTable(all,tablehead);


			JT.setRowHeight(20);//设置表格行高
			JT.setEnabled(false);//设置表格不可编辑
			jsl.setViewportView(JT);//显示在滚动面板



			this.add(jsl,BorderLayout.NORTH);
			this.setTitle("查询所有站点信息");
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
		new Get_station();
	}
}
