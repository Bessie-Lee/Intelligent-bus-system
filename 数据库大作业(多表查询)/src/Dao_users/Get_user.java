package Dao_users;


import Dao.DBconnector;
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
//import com.sun.*;

public class Get_user extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private static final AbstractButton JTSex = null;

	// 主标题
	JLabel JL=new JLabel("查询员工基本信息",JLabel.CENTER);

	//
	JLabel JLidcode= new JLabel("ID号:");
	JTextField JTidcode= new JTextField();

	// 三个按钮
	JButton JB1=new JButton("查询");
	JButton JB2=new JButton("重置");
	JButton JB3=new JButton("退出");

	JLabel JLname= new JLabel("姓名:");
	JTextField JTname= new JTextField();

	JLabel JLphone= new JLabel("电话:");
	JTextField JTphone= new JTextField();

	JLabel JLidCard= new JLabel("身份证:");
	JTextField JTidCard= new JTextField();

	JLabel JLdriving= new JLabel("驾龄:");
	JTextField JTdriving= new JTextField();

	JLabel JLstatus= new JLabel("状态:");
	JTextField JTstatus= new JTextField();
	ButtonGroup BG=new ButtonGroup();//创建一个ButtonGroup标签对象
	JRadioButton JRB1=new JRadioButton("开启");//创建单选按钮
	JRadioButton JRB2=new JRadioButton("关闭");

	ImageIcon image=new ImageIcon("E:\\上课\\大二\\数据库\\数据库实训暑期大作业\\数据库大作业代码\\数据库大作业\\白天.png");
	JLabel label=new JLabel(image);

	// 建立数据库对象
	String sql="";
	public Get_user()
	{
		// 建立窗口
		this.setSize(700,450);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setTitle("查询员工信息");
		this.setLayout(null);


		//
		JLidcode.setFont(new Font("黑体", Font.PLAIN, 30));
		JTidcode.setFont(new Font("黑体", Font.PLAIN, 30));
		JLidcode.setBounds(200,30,100,30);
		this.add(JLidcode);
		JTidcode.setBounds(300,30,150,30);
		this.add(JTidcode);


		JB1.setFont(new Font("黑体", Font.PLAIN, 30));
		JB2.setFont(new Font("黑体", Font.PLAIN, 30));
		JB3.setFont(new Font("黑体", Font.PLAIN, 30));
		JB1.setBounds(80,90,100,40);
		this.add(JB1);
		JB1.addActionListener(this);
		JB2.setBounds(280,90,100,40);
		this.add(JB2);
		JB2.addActionListener(this);
		JB3.setBounds(480,90,100,40);
		this.add(JB3);
		JB3.addActionListener(this);

		//
		JLname.setFont(new Font("黑体", Font.PLAIN, 30));
		JTname.setFont(new Font("黑体", Font.PLAIN, 30));
		JLname.setBounds(50,170,100,30);
		this.add(JLname);
		JTname.setBounds(150,170,150,30);
		this.add(JTname);



		//
		JLphone.setFont(new Font("黑体", Font.PLAIN, 30));
		JTphone.setFont(new Font("黑体", Font.PLAIN, 30));
		JLphone.setBounds(350,170,100,30);
		this.add(JLphone);
		JTphone.setBounds(470,170,150,30);
		this.add(JTphone);

		//
		JLidCard.setFont(new Font("黑体", Font.PLAIN, 30));
		JTidCard.setFont(new Font("黑体", Font.PLAIN, 30));
		JLidCard.setBounds(30,240,120,30);
		this.add(JLidCard);
		JTidCard.setBounds(150,240,150,30);
		this.add(JTidCard);

		JLdriving.setFont(new Font("黑体", Font.PLAIN, 30));
		JTdriving.setFont(new Font("黑体", Font.PLAIN, 30));
		JLdriving.setBounds(350,240,100,30);
		this.add(JLdriving);
		JTdriving.setBounds(470,240,150,30);
		this.add(JTdriving);

		//
		JLstatus.setFont(new Font("黑体", Font.PLAIN, 30));
		JRB1.setFont(new Font("黑体", Font.PLAIN, 30));
		JRB2.setFont(new Font("黑体", Font.PLAIN, 30));
		JLstatus.setBounds(150,310,100,30);//设置单选标签位置
		this.add(JLstatus);
		JRB1.setBounds(270,310,100,30);
		JRB2.setBounds(420,310,100,30);
		this.add(JRB1);//添加到窗口
		this.add(JRB2);
		BG.add(JRB1);//将单选按钮添加到ButtonGroup组件
		BG.add(JRB2);

		this.setLayout(null);
		this.add(label);
		label.setBounds(0,0,700,450);

		addWindowListener(new WindowAdapter() {//设置窗口监听器
			@SuppressWarnings("unused")
			public void windowsClosing(WindowEvent e)
			{
				dispose();
			}
		});
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==JB1)
		{
			users users=new users();//实例化对象
			users.setIdcode(JTidcode.getText());//返回输入的学号
			sql="select * from 用户 where idcode="+users.getIdcode();
			//连接数据库
			DBconnector conn=new DBconnector();
			Connection con=(Connection) conn.getConnection();
			ResultSet rs=null;
			try {
				Statement stmt= (Statement) con.createStatement();
				rs=(ResultSet) stmt.executeQuery(sql);
				if(rs.next())
				{
					// 读取
					users.setName(rs.getString(2));
					JTname.setText(users.getName());

					// 读取
					users.setPhone(rs.getString(3));
					JTphone.setText(users.getPhone());

					// 读取
					users.setIdCard(rs.getString(4));
					JTidCard.setText(users.getIdCard());

					users.setDriving(rs.getInt(5));
					JTdriving.setText(Integer.toString(users.getDriving()));
					// 读取
					users.setStatus(rs.getString(6));
					if(users.getStatus().equals("开启"))
					{
						JRB1.setSelected(true);
					}
					else {
						JRB2.setSelected(true);
					}

				}
				else{
					JOptionPane.showMessageDialog(null,"查无此人");
				}
			} catch (SQLException e1) {

				e1.printStackTrace();
			}

		}
		// 置空
		else if(e.getSource()==JB2)
		{
			JTidcode.setText(null);
			JTname.setText(null);
			JTphone.setText(null);
			JTidCard.setText(null);
			JTdriving.setText(null);
			JTstatus.setText(null);
		}
		// 关闭窗口
		else if(e.getSource()==JB3)
		{
			this.setVisible(false);
		}

	}

	public static void main(String[] args) {

		new Get_user();
	}

}
