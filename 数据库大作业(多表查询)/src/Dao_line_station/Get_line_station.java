package Dao_line_station;

import Dao.DBconnector;
import Dao_line.line;

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

public class Get_line_station extends JFrame{
	private static final long serialVersionUID = 1L;

	//存放所有信息
	Vector all=new Vector();
	//存储表头信息向量
	Vector tablehead=new Vector();

	// 创建标题与窗体
	JScrollPane jsl=new JScrollPane();//设置滚动面板

	JLabel JLlineCode= new JLabel("线路编号:");
	JTextField JTlineCode= new JTextField();

	JLabel JLstationCode= new JLabel("站点编号:");
	JTextField JTstationCode= new JTextField();

	JLabel JLid= new JLabel("线路站点序号:");
	JTextField JTid= new JTextField();


	ImageIcon image=new ImageIcon("E:\\上课\\大二\\数据库\\数据库实训暑期大作业\\数据库大作业代码\\数据库大作业\\白天.png");
	JLabel label=new JLabel(image);
	// 定义构造方法
	// 建立数据库连接
	String sql="";
	public Get_line_station()
	{
		// 数据库查询语句
		sql="select * from 线路站点 ;";
		//连接数据库
		DBconnector conn=new DBconnector();
		Connection con=(Connection) conn.getConnection();
		ResultSet rs=null;
		Statement stmt;
		try {
			stmt = (Statement) con.createStatement();
			rs=(ResultSet) stmt.executeQuery(sql);

			tablehead.add("线路编号");
			tablehead.add("站点编号");
			tablehead.add("线路站点序号");

			while(rs.next())
			{
				line_station line_station=new line_station();//实例化对象
				line_station.setLineCode(rs.getString("lineCode"));
				line_station.setStationCode(rs.getString("stationCode"));
				line_station.setId(rs.getString("id"));

				Vector vc=new Vector();

				vc.add(line_station.getLineCode());
				vc.add(line_station.getStationCode());
				vc.add(line_station.getId());

				// 全部放入vc集合中
				all.add(vc);
			}


			JTable JT=new JTable(all,tablehead);


			JT.setRowHeight(20);//设置表格行高
			JT.setEnabled(false);//设置表格不可编辑
			jsl.setViewportView(JT);//显示在滚动面板



			this.add(jsl,BorderLayout.NORTH);
			this.setTitle("查询所有线路-站点信息");
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
		new Get_line_station();
	}
}
