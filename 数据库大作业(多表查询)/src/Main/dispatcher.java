package Main;

import Dao_bus.Get_bus;
import Dao_line.Get_line;
import Dao_line_station.Get_line_station;
import Dao_password.Updata_D_password;
import Dao_scheduling.Add_scheduling;
import Dao_scheduling.Get_schedulings;
import Dao_scheduling.Update_scheduling;
import Dao_station.Get_station;
import Dao_users.Get_users;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class dispatcher extends JFrame implements ActionListener{


	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	// 创建菜单栏
	JMenuBar jm=new JMenuBar();
	// 查询
	JMenu jm1=new JMenu("查询");
	JMenuItem jmi1=new JMenuItem("员工信息");
	JMenuItem jmi2=new JMenuItem("车辆信息");
	JMenuItem jmi3=new JMenuItem("线路信息");
	JMenuItem jmi4=new JMenuItem("站点信息");
	JMenuItem jmi5=new JMenuItem("排班信息");

	// 排班
	JMenu jm2=new JMenu("排班");//创建查询菜单项对象
	JMenuItem jmi21=new JMenuItem("排班信息添加");
	JMenuItem jmi22=new JMenuItem("排班信息修改");
	JMenuItem jmi23=new JMenuItem("排班信息查询");


	// 其它
	JMenu jm3=new JMenu("其它");//创建其它菜单项对象
	JMenuItem jmi31=new JMenuItem("修改密码");

	JMenuItem jmi32=new JMenuItem("退出系统");

	ImageIcon image=new ImageIcon("E:\\上课\\大二\\数据库\\数据库实训暑期大作业\\数据库大作业代码\\数据库大作业\\调度员.png");
	JLabel label=new JLabel(image);
	// 定义构造方法
	public dispatcher()
	{
		// 标题
		this.setTitle("调度员界面管理");
		this.setFont(new Font("黑体", Font.PLAIN, 30));

		// 添加组件
		this.setJMenuBar(jm);
		jm.add(jm1);
		jm.add(jm2);
		jm.add(jm3);

		// 改变字体
		jm1.setFont(new Font("黑体", Font.PLAIN, 25));
		jmi1.setFont(new Font("黑体", Font.PLAIN, 20));
		jmi2.setFont(new Font("黑体", Font.PLAIN, 20));
		jmi3.setFont(new Font("黑体", Font.PLAIN, 20));
		jmi4.setFont(new Font("黑体", Font.PLAIN, 20));
		jmi5.setFont(new Font("黑体", Font.PLAIN, 20));

		jm2.setFont(new Font("黑体", Font.PLAIN, 25));
		jmi21.setFont(new Font("黑体", Font.PLAIN, 20));
		jmi22.setFont(new Font("黑体", Font.PLAIN, 20));
		jmi23.setFont(new Font("黑体", Font.PLAIN, 20));

		jm3.setFont(new Font("黑体", Font.PLAIN, 25));
		jmi31.setFont(new Font("黑体", Font.PLAIN, 20));
		jmi32.setFont(new Font("黑体", Font.PLAIN, 20));


		// 添加信息并设置监听
		jm1.add(jmi1);
		jm1.add(jmi2);
		jm1.add(jmi3);
		jm1.add(jmi4);
		jm1.add(jmi5);
		jm1.addActionListener(this);
		jmi1.addActionListener(this);
		jmi2.addActionListener(this);
		jmi3.addActionListener(this);
		jmi4.addActionListener(this);
		jmi5.addActionListener(this);

		// 添加查询
		jm2.add(jmi21);
		jm2.add(jmi22);
		jm2.add(jmi23);
		jm2.addActionListener(this);
		jmi21.addActionListener(this);
		jmi22.addActionListener(this);
		jmi23.addActionListener(this);

		// 添加其它
		jm3.add(jmi31);
		jm3.add(jmi32);
		jm3.addActionListener(this);
		jmi31.addActionListener(this);
		jmi32.addActionListener(this);

		this.setSize(1000,700);
		this.setLocationRelativeTo(null);
		this.setBackground(Color.DARK_GRAY);
		this.setVisible(true);

		// 设置图片大小
		this.setLayout(null);
		this.add(label);
		label.setBounds(0,0,1000,700);

		//设置窗口监听器
		addWindowListener(new WindowAdapter() {
			public void windowClosing (WindowEvent e)
			{
				dispose();
			}
		});
	}
	public void actionPerformed(ActionEvent e) {
		// 查询员工
		if(e.getSource()==jmi1)
		{
			new Get_users();
		}

		// 查询车辆
		else if(e.getSource()==jmi2)
		{
			new Get_bus();
		}

		// 查询线路
		else if(e.getSource()==jmi3)
		{
			new Get_line();
		}

		// 查询站点
		else if(e.getSource()==jmi4)
		{
			new Get_station();
		}

		// 查询排班
		else if(e.getSource()==jmi5)
		{
			new Get_schedulings();
		}

		// 增加排班
		else if(e.getSource()==jmi21)
		{
			new Add_scheduling();
		}

		// 修改排班
		else if(e.getSource()==jmi22)
		{
			new Update_scheduling();
		}

		// 查询排班
		else if(e.getSource()==jmi23)
		{
			new Get_schedulings();
		}


		// 修改密码
		else if(e.getSource()==jmi31)
		{
			new Updata_D_password();
		}
		// 退出系统
		else if(e.getSource()==jmi32)
		{
			this.dispose();
		}
	}

	// 调用窗口类对象
	public static void main(String [] args)
	{
		new dispatcher();
	}
}
