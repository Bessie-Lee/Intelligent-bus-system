package Dao_bus;

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

public class Update_bus extends JFrame implements ActionListener {

	private static final long SerialVersionUID =1L;


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
	// 三个按钮
	JButton JB1=new JButton("修改");
	JButton JB2=new JButton("重置");
	JButton JB3=new JButton("退出");

	ImageIcon image=new ImageIcon("E:\\上课\\大二\\数据库\\数据库实训暑期大作业\\数据库大作业代码\\数据库大作业\\白天.png");
	JLabel label=new JLabel(image);

	// 创建数据库语句对象
	String sql="";
	public Update_bus()
	{
		// 设置窗口位置及大小，并添加标题
		this.setSize(700,450);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setTitle("修改车辆信息");
		// 设置窗口管理器为空
		this.setLayout(null);

		// 车辆编号
		JLbusCode.setFont(new Font("黑体", Font.PLAIN, 30));
		JTbusCode.setFont(new Font("黑体", Font.PLAIN, 30));
		JLbusCode.setBounds(20,50,150,30);
		this.add(JLbusCode);
		JTbusCode.setBounds(160,50,150,30);
		this.add(JTbusCode);

		//
		JLbusLicense.setFont(new Font("黑体", Font.PLAIN, 30));
		JTbusLicense.setFont(new Font("黑体", Font.PLAIN, 30));
		JLbusLicense.setBounds(360,50,150,30);
		this.add(JLbusLicense);
		JTbusLicense.setBounds(470,50,150,30);
		this.add(JTbusLicense);

		//
		JLbusStatus.setFont(new Font("黑体", Font.PLAIN, 30));
		JRB1.setFont(new Font("黑体", Font.PLAIN, 30));
		JRB2.setFont(new Font("黑体", Font.PLAIN, 30));
		JLbusStatus.setBounds(100,140,150,30);//设置单选标签位置
		this.add(JLbusStatus);
		JRB1.setBounds(280,140,110,30);
		JRB2.setBounds(420,140,110,30);
		this.add(JRB1);//添加到窗口
		this.add(JRB2);
		BG.add(JRB1);//将单选按钮添加到ButtonGroup组件
		BG.add(JRB2);



		//
		JLbusType.setFont(new Font("黑体", Font.PLAIN, 30));
		JTbusType.setFont(new Font("黑体", Font.PLAIN, 30));
		JLbusType.setBounds(50,230,150,30);
		this.add(JLbusType);
		JTbusType.setBounds(160,230,150,30);
		this.add(JTbusType);

		JLstartTime.setFont(new Font("黑体", Font.PLAIN, 30));
		JTstartTime.setFont(new Font("黑体", Font.PLAIN, 30));
		JLstartTime.setBounds(330,230,150,30);
		this.add(JLstartTime);
		JTstartTime.setBounds(470,230,150,30);
		this.add(JTstartTime);



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
			bus bus=new bus();//实例化对象
			bus.setBusCode(JTbusCode.getText());
			bus.setBusLicense(JTbusLicense.getText());

			bus.setBusStatus("开启");
			if(JRB1.isSelected())
				bus.setBusStatus("关闭");

			bus.setBusType(JTbusType.getText());
			bus.setStartTime(JTstartTime.getText());

			// 数据库查询语句
			sql="select * from 车辆 where busCode="+bus.getBusCode();
			System.out.print(sql);
			//连接数据库
			DBconnector conn=new DBconnector();
			Connection con=conn.getConnection();
			try {
				Statement stmt=(Statement) con.createStatement();
				ResultSet rs=(ResultSet) stmt.executeQuery(sql);
				if(rs.next())
				{
					sql="update 车辆 set busLicense='"+bus.getBusLicense()+"',busStatus='"+bus.getBusStatus()+"',busType='"+bus.getBusType()+"',startTime='"+
							bus.getStartTime()+"' where busCode="+bus.getBusCode();


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
					JOptionPane.showMessageDialog(null, "此车辆编号不存在");
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==JB2)
		{
			JTbusCode.setText(null);
			JTbusLicense.setText(null);
			JTbusStatus.setText(null);
			JTbusType.setText(null);
			JTstartTime.setText(null);
		}
		else if(e.getSource()==JB3)
		{
			this.setVisible(false);
		}


	}

	public static void main(String[] args) {

		new Update_bus();
	}

}
