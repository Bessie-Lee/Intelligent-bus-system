package Dao_users;

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

public class Get_users extends JFrame{
	private static final long serialVersionUID = 1L;

	//存放所有信息
	Vector all=new Vector();
	//存储表头信息向量
	Vector tablehead=new Vector();

	// 创建标题与窗体
	JLabel JL=new JLabel("查询员工基本信息",JLabel.CENTER);
	JScrollPane jsl=new JScrollPane();//设置滚动面板

	JLabel JLidcode= new JLabel("ID号");
	JTextField JTidcode= new JTextField();

	JLabel JLname= new JLabel("姓名");
	JTextField JTname= new JTextField();

	JLabel JLphone= new JLabel("电话");
	JTextField JTphone= new JTextField();

	JLabel JLidCard= new JLabel("身份证");
	JTextField JTidCard= new JTextField();

	JLabel JLdriving= new JLabel("驾龄");
	JTextField JTdriving= new JTextField();

	JLabel JLstatus= new JLabel("状态");
	JTextField JTstatus= new JTextField();



	// 定义构造方法
	// 建立数据库连接
	String sql="";
	public Get_users()
	{

		//this.setLayout(null);
		//this.add(label);
		//label.setBounds(100,100,1000,700);

		// 数据库查询语句
		sql="select * from 用户 ;";
		//连接数据库
		DBconnector conn=new DBconnector();
		Connection con=(Connection) conn.getConnection();
		ResultSet rs=null;
		Statement stmt;
		try {
			stmt = (Statement) con.createStatement();
			rs=(ResultSet) stmt.executeQuery(sql);

			tablehead.add("ID号");
			tablehead.add("姓名");
			tablehead.add("电话");
			tablehead.add("身份证");
			tablehead.add("驾龄");
			tablehead.add("状态");


			while(rs.next())
			{
				// 建立对象
				users users=new users();


				users.setIdcode(rs.getString("idcode"));
				users.setName(rs.getString("name"));
				users.setPhone(rs.getString("phone"));
				users.setIdCard(rs.getString("idCard"));
				users.setDriving(rs.getInt("driving"));
				users.setStatus(rs.getString("status"));


				Vector vc=new Vector();

				vc.add(users.getIdcode());
				vc.add(users.getName());
				vc.add(users.getPhone());
				vc.add(users.getIdCard());
				vc.add(users.getDriving());
				vc.add(users.getStatus());
				System.out.println(vc);


				// 全部放入vc集合中
				all.add(vc);
			}


			JTable JT=new JTable(all,tablehead);


			JT.setRowHeight(20);//设置表格行高
			JT.setEnabled(false);//设置表格不可编辑
			jsl.setViewportView(JT);//显示在滚动面板



			this.add(jsl,BorderLayout.NORTH);
			this.setTitle("查询所有员工信息");
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
		new Get_users();
	}
}
