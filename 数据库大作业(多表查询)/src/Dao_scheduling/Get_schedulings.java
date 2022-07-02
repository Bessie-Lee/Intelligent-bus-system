package Dao_scheduling;

import Dao.DBconnector;

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

public class Get_schedulings extends JFrame{
	private static final long serialVersionUID = 1L;

	//存放所有信息
	Vector all=new Vector();
	//存储表头信息向量
	Vector tablehead=new Vector();

	// 创建标题与窗体
	JLabel JL=new JLabel("查询排班信息",JLabel.CENTER);
	JScrollPane jsl=new JScrollPane();//设置滚动面板


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


	// 定义构造方法
	// 建立数据库连接
	String sql="";
	public Get_schedulings()
	{

		//this.setLayout(null);
		//this.add(label);
		//label.setBounds(100,100,1000,700);

		// 数据库查询语句
		sql="select * from 排班 ;";
		//连接数据库
		DBconnector conn=new DBconnector();
		Connection con=(Connection) conn.getConnection();
		ResultSet rs=null;
		Statement stmt;
		try {
			stmt = (Statement) con.createStatement();
			rs=(ResultSet) stmt.executeQuery(sql);

			tablehead.add("排班编号");
			tablehead.add("线路名称");
			tablehead.add("车辆信息");
			tablehead.add("趟次");
			tablehead.add("每趟时间");
			tablehead.add("司机姓名");
			tablehead.add("始发站点");
			tablehead.add("终点站点");


			while(rs.next())
			{
				// 建立对象
				scheduling scheduling=new scheduling();


				scheduling.setCode(rs.getString("code"));
				scheduling.setLineCode(rs.getString("lineCode"));
				scheduling.setBusLinense(rs.getString("busLinense"));
				scheduling.setTcNumber(rs.getString("tcNumber"));
				scheduling.setTcTime(rs.getString("tcTime"));
				scheduling.setUserCode(rs.getString("userCode"));
				scheduling.setStartStation(rs.getString("startStation"));
				scheduling.setEndStation(rs.getString("endStation"));


				Vector vc=new Vector();

				vc.add(scheduling.getCode());
				vc.add(scheduling.getLineCode());
				vc.add(scheduling.getBusLinense());
				vc.add(scheduling.getTcNumber());
				vc.add(scheduling.getTcTime());
				vc.add(scheduling.getUserCode());
				vc.add(scheduling.getStartStation());
				vc.add(scheduling.getEndStation());
				System.out.println(vc);


				// 全部放入vc集合中
				all.add(vc);
			}


			JTable JT=new JTable(all,tablehead);


			JT.setRowHeight(20);//设置表格行高
			JT.setEnabled(false);//设置表格不可编辑
			jsl.setViewportView(JT);//显示在滚动面板



			this.add(jsl,BorderLayout.NORTH);
			this.setTitle("查询所有排班信息");
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
		new Get_schedulings();
	}
}
