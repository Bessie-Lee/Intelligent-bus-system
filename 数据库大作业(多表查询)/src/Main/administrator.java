package Main;

import Dao_bus.Add_bus;
import Dao_bus.Delete_bus;
import Dao_bus.Get_bus;
import Dao_bus.Update_bus;
import Dao_line.Add_line;
import Dao_line.Delete_line;
import Dao_line.Get_line;
import Dao_line.Update_line;
import Dao_line_station.Add_line_station;
import Dao_line_station.Delete_line_station;
import Dao_line_station.Get_line_station;
import Dao_line_station.Update_line_station;
import Dao_password.Updata_A_password;
import Dao_scheduling.*;
import Dao_station.Add_station;
import Dao_station.Delete_station;
import Dao_station.Get_station;
import Dao_station.Update_station;
import Dao_users.Add_users;
import Dao_users.Delete_users;
import Dao_users.Get_users;
import Dao_users.Update_users;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class administrator extends JFrame implements ActionListener{


	/**
	 *
	 */
	private static final long serialVersionUID = 1L;



	// 创建菜单栏
	JMenuBar jm=new JMenuBar();
	// 员工信息
	JMenu jm1=new JMenu("员工信息");
	JMenuItem jmi1=new JMenuItem("增加信息");
	JMenuItem jmi2=new JMenuItem("删除信息");
	JMenuItem jmi3=new JMenuItem("修改信息");
	JMenuItem jmi4=new JMenuItem("查询信息");


	// 排班信息
	JMenu jm2=new JMenu("排班信息");//创建查询菜单项对象
	JMenuItem jmi21=new JMenuItem("增加信息");
	JMenuItem jmi22=new JMenuItem("删除信息");
	JMenuItem jmi23=new JMenuItem("修改信息");
	JMenuItem jmi24=new JMenuItem("查询信息");

	JMenu jm3=new JMenu("站点信息");
	JMenuItem jmi31=new JMenuItem("增加信息");
	JMenuItem jmi32=new JMenuItem("删除信息");
	JMenuItem jmi33=new JMenuItem("修改信息");
	JMenuItem jmi34=new JMenuItem("查询信息");



	JMenu jm4 =new JMenu("线路信息");
	JMenuItem jmi41=new JMenuItem("增加信息");
	JMenuItem jmi42=new JMenuItem("删除信息");
	JMenuItem jmi43=new JMenuItem("修改信息");
	JMenuItem jmi44=new JMenuItem("查询信息");


	JMenu jm5=new JMenu("车辆信息");
	JMenuItem jmi51=new JMenuItem("增加信息");
	JMenuItem jmi52=new JMenuItem("删除信息");
	JMenuItem jmi53=new JMenuItem("修改信息");
	JMenuItem jmi54=new JMenuItem("查询信息");

	JMenu jm6=new JMenu("线路-站点信息");
	JMenuItem jmi61=new JMenuItem("增加信息");
	JMenuItem jmi62=new JMenuItem("删除信息");
	JMenuItem jmi63=new JMenuItem("修改信息");
	JMenuItem jmi64=new JMenuItem("查询信息");

	// 其它
	JMenu jm7=new JMenu("其它");//创建其它菜单项对象
	JMenuItem jmi71=new JMenuItem("修改密码");
	JMenuItem jmi72=new JMenuItem("退出系统");


	// 图片设置
	ImageIcon image=new ImageIcon("E:\\上课\\大二\\数据库\\数据库实训暑期大作业\\数据库大作业代码\\数据库大作业\\管理员.png");
	JLabel label=new JLabel(image);

	// 定义构造方法
	public administrator()
	{
		// 左上角标题
		this.setTitle("管理员界面管理");


		jm1.setFont(new Font("黑体", Font.PLAIN, 25));
		jmi1.setFont(new Font("黑体", Font.PLAIN, 20));
		jmi2.setFont(new Font("黑体", Font.PLAIN, 20));
		jmi3.setFont(new Font("黑体", Font.PLAIN, 20));
		jmi4.setFont(new Font("黑体", Font.PLAIN, 20));

		jm2.setFont(new Font("黑体", Font.PLAIN, 25));
		jmi21.setFont(new Font("黑体", Font.PLAIN, 20));
		jmi22.setFont(new Font("黑体", Font.PLAIN, 20));
		jmi23.setFont(new Font("黑体", Font.PLAIN, 20));
		jmi24.setFont(new Font("黑体", Font.PLAIN, 20));

		jm3.setFont(new Font("黑体", Font.PLAIN, 25));
		jmi31.setFont(new Font("黑体", Font.PLAIN, 20));
		jmi32.setFont(new Font("黑体", Font.PLAIN, 20));
		jmi33.setFont(new Font("黑体", Font.PLAIN, 20));
		jmi34.setFont(new Font("黑体", Font.PLAIN, 20));

		jm4.setFont(new Font("黑体", Font.PLAIN, 25));
		jmi41.setFont(new Font("黑体", Font.PLAIN, 20));
		jmi42.setFont(new Font("黑体", Font.PLAIN, 20));
		jmi43.setFont(new Font("黑体", Font.PLAIN, 20));
		jmi44.setFont(new Font("黑体", Font.PLAIN, 20));

		jm5.setFont(new Font("黑体", Font.PLAIN, 25));
		jmi51.setFont(new Font("黑体", Font.PLAIN, 20));
		jmi52.setFont(new Font("黑体", Font.PLAIN, 20));
		jmi53.setFont(new Font("黑体", Font.PLAIN, 20));
		jmi54.setFont(new Font("黑体", Font.PLAIN, 20));

		jm6.setFont(new Font("黑体", Font.PLAIN, 25));
		jmi61.setFont(new Font("黑体", Font.PLAIN, 20));
		jmi62.setFont(new Font("黑体", Font.PLAIN, 20));
		jmi63.setFont(new Font("黑体", Font.PLAIN, 20));
		jmi64.setFont(new Font("黑体", Font.PLAIN, 20));


		jm7.setFont(new Font("黑体", Font.PLAIN, 25));
		jmi71.setFont(new Font("黑体", Font.PLAIN, 20));
		jmi72.setFont(new Font("黑体", Font.PLAIN, 20));




		// 添加组件
		this.setJMenuBar(jm);
		jm.add(jm1);
		jm.add(jm2);
		jm.add(jm3);
		jm.add(jm4);
		jm.add(jm5);
		jm.add(jm6);
		jm.add(jm7);

		// 员工并设置监听
		jm1.add(jmi1);
		jm1.add(jmi2);
		jm1.add(jmi3);
		jm1.add(jmi4);
		jm1.addActionListener(this);
		jmi1.addActionListener(this);
		jmi2.addActionListener(this);
		jmi3.addActionListener(this);
		jmi4.addActionListener(this);


		// 2
		jm2.add(jmi21);
		jm2.add(jmi22);
		jm2.add(jmi23);
		jm2.add(jmi24);
		jm2.addActionListener(this);
		jmi21.addActionListener(this);
		jmi22.addActionListener(this);
		jmi23.addActionListener(this);
		jmi24.addActionListener(this);

		jm3.add(jmi31);
		jm3.add(jmi32);
		jm3.add(jmi33);
		jm3.add(jmi34);
		jm3.addActionListener(this);
		jmi31.addActionListener(this);
		jmi32.addActionListener(this);
		jmi33.addActionListener(this);
		jmi34.addActionListener(this);

		jm4.add(jmi41);
		jm4.add(jmi42);
		jm4.add(jmi43);
		jm4.add(jmi44);
		jm4.addActionListener(this);
		jmi41.addActionListener(this);
		jmi42.addActionListener(this);
		jmi43.addActionListener(this);
		jmi44.addActionListener(this);

		jm5.add(jmi51);
		jm5.add(jmi52);
		jm5.add(jmi53);
		jm5.add(jmi54);
		jm5.addActionListener(this);
		jmi51.addActionListener(this);
		jmi52.addActionListener(this);
		jmi53.addActionListener(this);
		jmi54.addActionListener(this);

		jm6.add(jmi61);
		jm6.add(jmi62);
		jm6.add(jmi63);
		jm6.add(jmi64);
		jm6.addActionListener(this);
		jmi61.addActionListener(this);
		jmi62.addActionListener(this);
		jmi63.addActionListener(this);
		jmi64.addActionListener(this);


		// 添加其它
		jm7.add(jmi71);
		jm7.add(jmi72);
		jm7.addActionListener(this);
		jmi71.addActionListener(this);
		jmi72.addActionListener(this);

		// 设置图片大小
		this.setLayout(null);
		this.add(label);
		label.setBounds(0,0,1000,700);

		this.setSize(1000,700);
		this.setLocationRelativeTo(null);
		this.setBackground(Color.DARK_GRAY);
		this.setVisible(true);
		//设置窗口监听器
		addWindowListener(new WindowAdapter() {
			public void windowClosing (WindowEvent e)
			{
				dispose();
			}
		});
	}
	public void actionPerformed(ActionEvent e) {
		// 员工
		// 增加信息
		if(e.getSource()==jmi1)
		{
			new Add_users();
		}

		// 删除
		else if(e.getSource()==jmi2)
		{
			new Delete_users();
		}

		// 修改
		else if(e.getSource()==jmi3)
		{
			new Update_users();
		}

		// 查询
		else if(e.getSource()==jmi4)
		{
			new Get_users();
		}

		// 排班

		else if(e.getSource()==jmi21)
		{
			new Add_scheduling();
		}

		else if(e.getSource()==jmi22)
		{
			new Delete_scheduling();
		}


		else if(e.getSource()==jmi23)
		{
			new Update_scheduling();
		}


		else if(e.getSource()==jmi24)
		{
			new Get_schedulings();
		}

		//站点

		if(e.getSource()==jmi31)
		{
			new Add_station();
		}


		else if(e.getSource()==jmi32)
		{
			new Delete_station();
		}

		else if(e.getSource()==jmi33)
		{
			new Update_station();
		}


		else if(e.getSource()==jmi34)
		{
			new Get_station();
		}

		// 线路
		if(e.getSource()==jmi41)
		{
			new Add_line();
		}


		else if(e.getSource()==jmi42)
		{
			new Delete_line();
		}


		else if(e.getSource()==jmi43)
		{
			new Update_line();
		}


		else if(e.getSource()==jmi44)
		{
			new Get_line();
		}

		// 车辆

		if(e.getSource()==jmi51)
		{
			new Add_bus();
		}


		else if(e.getSource()==jmi52)
		{
			new Delete_bus();
		}


		else if(e.getSource()==jmi53)
		{
			new Update_bus();
		}


		else if(e.getSource()==jmi54)
		{
			new Get_bus();
		}


		/// 线路-站点
		if(e.getSource()==jmi61)
		{
			new Add_line_station();
		}


		else if(e.getSource()==jmi62)
		{
			new Delete_line_station();
		}


		else if(e.getSource()==jmi63)
		{
			new Update_line_station();
		}


		else if(e.getSource()==jmi64)
		{
			new Get_line_station();
		}

		// 其他

		// 改密码
		else if(e.getSource()==jmi71)
		{
			new Updata_A_password();
		}
		// 退出
		else if(e.getSource()==jmi72)
		{
			this.dispose();
		}
	}

	// 调用窗口类对象
	public static void main(String [] args)
	{
		new administrator();
	}
}
