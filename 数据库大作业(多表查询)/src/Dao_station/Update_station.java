package Dao_station;

import Dao.DBconnector;
import Dao_users.users;

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

public class Update_station extends JFrame implements ActionListener {

	private static final long SerialVersionUID =1L;

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

	// 三个按钮
	JButton JB1=new JButton("修改");
	JButton JB2=new JButton("重置");
	JButton JB3=new JButton("退出");

	ImageIcon image=new ImageIcon("E:\\上课\\大二\\数据库\\数据库实训暑期大作业\\数据库大作业代码\\数据库大作业\\白天.png");
	JLabel label=new JLabel(image);

	// 创建数据库语句对象
	String sql="";
	public Update_station()
	{
		// 设置窗口位置及大小，并添加标题
		this.setSize(700,450);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setTitle("修改站点信息");
		// 设置窗口管理器为空
		this.setLayout(null);

		//
		JLstationCode.setFont(new Font("黑体", Font.PLAIN, 30));
		JTstationCode.setFont(new Font("黑体", Font.PLAIN, 30));
		JLstationCode.setBounds(120,30,150,30);
		this.add(JLstationCode);
		JTstationCode.setBounds(300,30,150,30);
		this.add(JTstationCode);

		//
		JLstationName.setFont(new Font("黑体", Font.PLAIN, 30));
		JTstationName.setFont(new Font("黑体", Font.PLAIN, 30));
		JLstationName.setBounds(120,110,150,30);
		this.add(JLstationName);
		JTstationName.setBounds(300,110,150,30);
		this.add(JTstationName);

		//
		JLlongitude.setFont(new Font("黑体", Font.PLAIN, 30));
		JTlongitude.setFont(new Font("黑体", Font.PLAIN, 30));
		JLlongitude.setBounds(50,180,100,30);
		this.add(JLlongitude);
		JTlongitude.setBounds(150,180,150,30);
		this.add(JTlongitude);


		//
		JLlatitude.setFont(new Font("黑体", Font.PLAIN, 30));
		JTlatitude.setFont(new Font("黑体", Font.PLAIN, 30));
		JLlatitude.setBounds(350,180,120,30);
		this.add(JLlatitude);
		JTlatitude.setBounds(470,180,150,30);
		this.add(JTlatitude);

		//
		JLregion.setFont(new Font("黑体", Font.PLAIN, 30));
		JTregion.setFont(new Font("黑体", Font.PLAIN, 30));
		JLregion.setBounds(50,250,100,30);
		this.add(JLregion);
		JTregion.setBounds(150,250,150,30);
		this.add(JTregion);

		JLstreet.setFont(new Font("黑体", Font.PLAIN, 30));
		JTstreet.setFont(new Font("黑体", Font.PLAIN, 30));
		JLstreet.setBounds(350,250,100,30);
		this.add(JLstreet);
		JTstreet.setBounds(470,250,150,30);
		this.add(JTstreet);




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
			station station = new station ();//实例化对象

			station.setStationCode(JTstationCode.getText());
			station.setStationName(JTstationName.getText());
			station.setLongitude(Integer.parseInt(JTlongitude.getText()));
			station.setLatitude(Integer.parseInt(JTlatitude.getText()));
			station.setRegion(JTregion.getText());
			station.setStreet(JTstreet.getText());
			// 数据库查询语句
			sql="select * from 站点 where stationCode="+station.getStationCode();
			//连接数据库
			DBconnector conn=new DBconnector();
			Connection con=conn.getConnection();
			try {
				Statement stmt=(Statement) con.createStatement();
				ResultSet rs=(ResultSet) stmt.executeQuery(sql);
				if(rs.next())
				{
					sql="update 站点 set stationName='"+station.getStationName()+"',longitude='"+station.getLongitude()+"',latitude='"+
							station.getLatitude()+"',region='"+station.getRegion()+"',street='"+station.getStreet()+"'where stationCode="+station.getStationCode();


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
					JOptionPane.showMessageDialog(null, "此编号不存在");
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==JB2)
		{
			JTstationCode.setText(null);
			JTstationName.setText(null);
			JTlongitude.setText(null);
			JTlatitude.setText(null);
			JTregion.setText(null);
			JTstreet.setText(null);
		}
		else if(e.getSource()==JB3)
		{
			this.setVisible(false);
		}


	}

	public static void main(String[] args) {

		new Update_station();
	}

}
