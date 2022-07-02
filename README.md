# Intelligent-bus-system
Java GUI + Mysql 8.0 +Idea
# 1 绪论
智慧公交项目（简称IB）是JAVA开发的应用软件。旨在提高员工的日常工作便捷性、工作效率，降低管理及运营成本。本软件系统将为该公司提供车辆信息管理、员工信息管理、线路信息管理、站点信息管理、排班方案管理，修改密码等功能。利用这些功能充分满足该公交公司日常工作中的管理及信息同步需求。
# 2 相关技术与工具
- 数据库：Mysql8.0
- 数据库名称：busmanage
- 数据库存放：Mysql Workbench 8.0 CE
- 操作系统：win10专业版 x64
- 代码语言：Java GUI
- 代码软件：idea[2021.3.3]
- JDK：1.8(version 1.8.0_201)
- Mysql版本:mysql-connector-java-8.0.29.jar

  运行方式：配置好上述要求后，直接运行Main包里面的Login.java文件，对应的用户名和密码已直接与数据库进行相连
  [管理员登录，调度员登录，员工登录三个不同的数据库表格分别存放他们的用户名与密码]
# 3 需求分析
## 3.1系统目标
本软件系统将为该公司提供车辆信息管理、员工信息管理、线路信息管理、站点信息管理、排班方案管理和修改密码功能。
## 3.2 角色分析 
管理员，调度员，员工
## 3.3 系统功能分析
需要实现的基本功能：①员工信息的增删改查；②排班信息的增删改查；③线路信息的增删改查；④站点信息的增删改查；⑤车辆信息的增删改查；⑥修改用户密码。
用户分为三种：管理员，调度员，员工
①管理员可以实现上述的全部功能；
②调度员只能实现：员工信息查询，线路信息查询，站点信息查询，车辆信息查询，排班信息增加，修改和查询，密码修改；
③员工只能实现：员工个人信息查询，个人排班信息查询，修改密码。
[系统功能用例图]


![image](https://user-images.githubusercontent.com/83197294/176997192-7987f621-ea44-4965-beb8-b684c412bbc0.png)

# 4 系统设计
## 4.1 系统功能模块设计
附上对应的功能结构图。如图4-1所示。[放大160%即可清晰观看]


![image](https://user-images.githubusercontent.com/83197294/176997211-b6c75acc-ddc8-424a-86d9-62a58eb64539.png)

 
图4-1 系统功能结构图
## 4.2 数据库设计
表4-1  员工信息表

 ![image](https://user-images.githubusercontent.com/83197294/176997222-8fc09267-eb13-4a97-aff7-79ceff91d82a.png)

表4-2  车辆信息表

![image](https://user-images.githubusercontent.com/83197294/176997232-f57b9ce1-9e7a-41f1-a1f9-ff8662ab8f66.png)

 
表4-3  线路信息表

 ![image](https://user-images.githubusercontent.com/83197294/176997235-28a7e34b-c34c-4115-a8a5-c698245bd078.png)



表4-4  站点信息表

 ![image](https://user-images.githubusercontent.com/83197294/176997236-9b872531-7631-45a9-9b17-3dc7d49a95b6.png)

表4-5  排班信息表

 ![image](https://user-images.githubusercontent.com/83197294/176997240-45c4b33b-9b8f-4d55-8584-59c0db082fe0.png)

表4-6  登录信息表
 
![image](https://user-images.githubusercontent.com/83197294/176997245-e7098403-dbe3-444d-b473-fda74c972a42.png)

最后数据库展示：

 ![image](https://user-images.githubusercontent.com/83197294/176997246-ac0005a3-e3d7-444c-b1ee-aded35588aaa.png)

# 5 系统实现
## 5.1 界面展示

代码位置：

 ![image](https://user-images.githubusercontent.com/83197294/176997251-26e1a61b-ef0d-4d84-837f-74d9c3c3a572.png)

界面代码：

![image](https://user-images.githubusercontent.com/83197294/176997266-b622d361-4bac-465d-bcd4-ffc02f5c6b73.png)

![image](https://user-images.githubusercontent.com/83197294/176997268-e090a279-d4f9-4f80-a931-1679d4d9489e.png)

![image](https://user-images.githubusercontent.com/83197294/176997270-632d38ff-2856-4534-9489-f6a0398faa83.png)

## 5.2 代码位置

![image](https://user-images.githubusercontent.com/83197294/176997391-85e52acd-ec96-4828-85ff-ed0c36cebff6.png)


 
 

 
