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

public class Update_line_station extends JFrame implements ActionListener {

	private static final long SerialVersionUID =1L;

	JLabel JLlineCode= new JLabel("线路编号:");
	JTextField JTlineCode= new JTextField();

	JLabel JLstationCode= new JLabel("站点编号:");
	JTextField JTstationCode= new JTextField();

	JLabel JLid= new JLabel("线路站点序号:");
	JTextField JTid= new JTextField();
	// 三个按钮
	JButton JB1=new JButton("修改");
	JButton JB2=new JButton("重置");
	JButton JB3=new JButton("退出");

	ImageIcon image=new ImageIcon("E:\\上课\\大二\\数据库\\数据库实训暑期大作业\\数据库大作业代码\\数据库大作业\\白天.png");
	JLabel label=new JLabel(image);

	// 创建数据库语句对象
	String sql="";
	public Update_line_station()
	{
		// 设置窗口位置及大小，并添加标题
		this.setSize(700,450);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setTitle("修改线路站点信息");
		// 设置窗口管理器为空
		this.setLayout(null);

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
	// 按钮事件
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==JB1)
		{
			line_station line_station=new line_station();//实例化对象
			line_station.setLineCode(JTlineCode.getText());
			line_station.setStationCode(JTstationCode.getText());
			line_station.setId(JTid.getText());

			// 数据库查询语句
			sql="select * from 线路站点 where lineCode="+line_station.getLineCode();
			System.out.print(sql);
			//连接数据库
			DBconnector conn=new DBconnector();
			Connection con=conn.getConnection();
			try {
				Statement stmt=(Statement) con.createStatement();
				ResultSet rs=(ResultSet) stmt.executeQuery(sql);
				if(rs.next())
				{
					sql="update 线路站点 set id='"+line_station.getId()+"' where lineCode = \""+line_station.getLineCode()+
							"\" and stationCode = \""+line_station.getStationCode()+"\";";

					int n=stmt.executeUpdate(sql);
					if(n>0)
					{
						JOptionPane.showMessageDialog(null,"更新成功");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "更新失败");
					}

				}
				else
				{
					JOptionPane.showMessageDialog(null, "此编号户不存在");
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

		new Update_line_station();
	}

}
