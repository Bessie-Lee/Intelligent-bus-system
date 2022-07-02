package Main;
import Dao.DBconnector;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

import java.sql.Statement;



@SuppressWarnings("unused")
public class Login extends Frame implements ActionListener {
	private static final long serialVersionUID=1L;

	// 创建窗口基本组件
	JLabel JLUserName=new JLabel("用户名:");
	JLabel JLPaw=new JLabel("密  码:");
	JTextField JTUserName= new JTextField();
	JPasswordField JTpaw=new JPasswordField();
	JLabel JL1=new JLabel("身  份:");
	ButtonGroup BG=new ButtonGroup();//创建一个ButtonGroup标签对象
	JRadioButton JRB1=new JRadioButton("管理员");//创建单选按钮
	JRadioButton JRB2=new JRadioButton("调度员");
	JRadioButton JRB3=new JRadioButton("员工");
	//设置窗口图标标签
	JLabel label_headLogin = new JLabel("IB智慧公交");

	// 创建按钮对象
	JButton JB1=new JButton("登录");
	JButton JB2=new JButton("退出");

	ImageIcon image=new ImageIcon("E:\\上课\\大二\\数据库\\数据库实训暑期大作业\\数据库大作业代码\\数据库大作业\\首页.png");
	JLabel label=new JLabel(image);



	public Login()//构造方法
	{
		//设置窗口标题
		this.setTitle("IB智慧公交");
		this.setBackground(Color.LIGHT_GRAY);
		this.setLayout(null);

		// 设置窗口图标标签
		label_headLogin.setFont(new Font("黑体", Font.PLAIN, 50));
		label_headLogin.setBounds(230,60,300,60);
		this.add(label_headLogin);

		// 用户名
		JLUserName.setFont(new Font("黑体", Font.PLAIN, 20));
		JLUserName.setBounds(200,420,80,30);
		this.add(JLUserName);
		JTUserName.setFont(new Font("黑体", Font.PLAIN, 20));
		JTUserName.setBounds(300,420,180,30);
		this.add(JTUserName);

		// 密码
		JLPaw.setFont(new Font("黑体", Font.PLAIN, 20));
		JLPaw.setBounds(200,480,80,30);
		this.add(JLPaw);
		JTpaw.setBounds(300,480,180,30);
		this.add(JTpaw);

		// 选择身份
		JL1.setFont(new Font("黑体", Font.PLAIN, 20));
		JL1.setBounds(150,550,80,20);
		this.add(JL1);
		JRB1.setFont(new Font("黑体", Font.PLAIN, 20));
		JRB2.setFont(new Font("黑体", Font.PLAIN, 20));
		JRB3.setFont(new Font("黑体", Font.PLAIN, 20));
		JRB1.setBounds(240,550,90,30);
		JRB2.setBounds(350,550,90,30);
		JRB3.setBounds(470,550,80,30);
		this.add(JRB1);//添加到窗口
		this.add(JRB2);
		this.add(JRB3);
		BG.add(JRB1);//将单选按钮添加到ButtonGroup组件
		BG.add(JRB2);
		BG.add(JRB3);

		// 按钮
		JB1.setFont(new Font("黑体", Font.PLAIN, 20));
		JB1.setBounds(220,620,80,30);
		this.add(JB1);
		JB1.addActionListener(this);
		JB2.setFont(new Font("黑体", Font.PLAIN, 20));
		JB2.setBounds(420,620,80,30);
		this.add(JB2);
		JB2.addActionListener(this);

		// 设置图片大小
		this.setLayout(null);
		this.add(label);
		label.setBounds(0,0,700,400);


		// 窗口设置
		this.setVisible(true);
		this.setSize(700,700);
		this.setLocationRelativeTo(null);


		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}

	public void actionPerformed(ActionEvent e) {
		// 如果点击登录按钮
		if(e.getSource()==JB1)
		{
			// 获取输入的用户名
			String name=JTUserName.getText();
			// 获取输入的密码
			String password=new String(JTpaw.getPassword());
			String loginsql=null;
			// 获取用户的类型（管理员，调度员，员工）
			String box= null;
			if(JRB1.isSelected())box = "管理员";
			else if (JRB2.isSelected())box = "调度员";
			else box = "员工";
			// 如果是管理员
			if(box.equals("管理员"))
			{
				// 用户名
				loginsql="select password from 管理员登录 where userName = '"+name+"' " ;
				// 打印
				System.out.println(loginsql);
				if(logindb(password,loginsql))
				{
					new administrator();
					this.setVisible(false);
				}//登录成功后设置登录窗口隐藏
			}

			else if(box.equals("调度员"))
			{
				loginsql="select password from 调度员登录 where userName = '"+name+"' ";
				if(logindb(password,loginsql))
				{
					new dispatcher();
					this.setVisible(false);
				}//登录成功后设置登录窗口隐藏
			}
			else if (box.equals("员工")){
				// 用户名
				loginsql="select password from 员工登录 where userName = '"+name+"' " ;
				if(logindb(password,loginsql))
				{
					new employee(name);
					this.setVisible(false);
				}//登录成功后设置登录窗口隐藏
			}
		}
		// 退出按钮
		else if(e.getSource()==JB2)
		{
			System.exit(0);
		}
	}

	//查询数据库
	private boolean logindb(String password,String loginsql){
		ResultSet rs=null;
		//连接数据库
		DBconnector conn=new DBconnector();
		Connection con=conn.getConnection();
		System.out.println("连接成功");
		try {
			Statement stmt=(Statement) con.createStatement();
			rs=stmt.executeQuery(loginsql);
		}
		catch (SQLException e) {
			System.out.println("查询出错");
			e.printStackTrace();
		}

		//比对结果
		try {
			if(rs.next()&&rs.getString(1).equals(password))
			{
				rs.close();
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null,"密码或用户名输入错误");
		return false;

	}
	public static void main(String[] args) {
		new Login();
	}
}
