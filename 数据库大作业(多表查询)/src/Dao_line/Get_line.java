package Dao_line;

import Dao.DBconnector;
import Dao_bus.bus;
import Dao_line_station.line_station;
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
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

public class Get_line extends JFrame{
	private static final long serialVersionUID = 1L;

	//存放所有学生信息
	Vector all=new Vector();
	//存储表头信息向量
	Vector tablehead=new Vector();

	// 创建标题与窗体
	JScrollPane jsl=new JScrollPane();//设置滚动面板

	JLabel JLlineCode= new JLabel("线路编号:");
	JTextField JTlineCode= new JTextField();

	JLabel JLlineName= new JLabel("线路名字:");
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


	ImageIcon image=new ImageIcon("E:\\上课\\大二\\数据库\\数据库实训暑期大作业\\数据库大作业代码\\数据库大作业\\白天.png");
	JLabel label=new JLabel(image);
	// 定义构造方法
	// 建立数据库连接
	String sql1="";
	String sql2="";
	public Get_line()
	{

		// 数据库查询语句
		 //sql1="select * from 线路 ;";
		sql1 = "select 线路.lineCode,线路.lineName,线路.status,线路.startLineTime,线路.direction,站点.stationName,线路站点.id " +
				"from 线路,线路站点,站点 where 线路.lineCode = 线路站点.lineCode and 线路站点.stationCode = 站点.stationCode;";

		//连接数据库
		DBconnector conn=new DBconnector();
		Connection con=(Connection) conn.getConnection();
		ResultSet rs1=null;
		Statement stmt1;

		try {
			stmt1 = (Statement) con.createStatement();
			rs1=(ResultSet) stmt1.executeQuery(sql1);


			tablehead.add("线路编号");
			tablehead.add("线路名字");
			tablehead.add("线路状态");
			tablehead.add("开线时间");
			tablehead.add("线路方向");
			tablehead.add("存在站点");
			tablehead.add("站点序号");

			while(rs1.next())
			{
				// 建立对象
				line line=new line();//实例化对象
				station station = new station();
				line_station line_station = new line_station();

				line.setLineCode(rs1.getString("lineCode"));
				line.setLineName(rs1.getString("lineName"));
				line.setStatus(rs1.getString("status"));
				line.setStartLineTime(rs1.getString("startLineTime"));
				line.setDirection(rs1.getString("direction"));

				station.setStationName(rs1.getString("stationName"));
				line_station.setId(rs1.getString("id"));

				Vector vc=new Vector();

				vc.add(line.getLineCode());
				vc.add(line.getLineName());
				vc.add(line.getStatus());
				vc.add(line.getStartLineTime());
				vc.add(line.getDirection());
				vc.add(station.getStationName());
				vc.add(line_station.getId());

				// 全部放入vc集合中
				all.add(vc);
				System.out.println(all);

			}

			JTable JT=new JTable(all,tablehead);


			JT.setRowHeight(20);//设置表格行高
			JT.setEnabled(false);//设置表格不可编辑
			jsl.setViewportView(JT);//显示在滚动面板



			this.add(jsl,BorderLayout.NORTH);
			this.setTitle("查询所有线路信息");
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
		new Get_line();
	}
}
