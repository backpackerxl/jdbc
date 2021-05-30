 # jdbc

学生信息管理系统 介绍
这是一个jdbc的小项目，无框架技术，后续还会更新

jdbc技术， 软件架构
软件架构说明
采用java分层开发

 **学生信息管理系统 安装教程** 

1.  jdk1.8,其它没试过；
2.  eclipse IDE +WindowBuilder；
3.  mysq5.7,如果mysql8.0以上需要更改配置文件；
4.  后续出一个jar包安装jdk1.8就行。

 **学生信息管理系统 使用说明** 

1.  把下载下来的文件放置到eclipse的工作空间，或者用eclipse导入项目；
2.  创建一个数据库名为login，一张表admin，或者自行创建，更改源文件；
3.  后期我会推出一个SQL脚本，提供给大家使用
4.  SQL脚本使用方法：打开数据库，进入数据库，执行source path，path(注意path中不能有中文否则会报错)是你数据库脚本路径，如果报错不要灰心，多试几次，实在不行重启再试。
5. 本人第一次写项目忘记将配置文件写成相对路径，需要使用者，将克隆下来的项目中的Users文件夹复制到计算机D盘中(若D盘中已有此文件夹，就把文件目录依次往后推，这一步一定要做，不然无法启动项目)，并将里面的druid配置文件中的数据库用户名和密码改为自己的，然后双击学生管理系统.bat脚本即可运行。此时会有一个命令行窗口出现，不想看可以缩小,切记不能关闭，关闭相当于退出程序。
6.有兴趣的还可以做个logo图片我放到src下的image下的，右击属性点击更改图标（前提是桌面快捷方式），会提醒点击确定找到图片位置即可。

 **个人项目** 
1.  安装方式：直接下载下来
2.  推荐使用Git命令下载，首先需要到Git官网下载此软件（官网自行百度）。然后新建一个文件夹，单击右键，选择Git bash here，然后输入如下指令git clone https://gitee.com/backpackerxl/jdbc.git 下载下来的项目不能直接使用，详情参考  **学生信息管理系统 使用说明 第5条** 
3.  提交代码
4.  新建 Pull Request


 **学生信息管理系统 特技** 

1.  使用 Readme\_XXX.md 来支持不同的语言，例如 Readme\_en.md, Readme\_zh.md
2.  Gitee 官方博客 [blog.gitee.com](https://blog.gitee.com)
3.  你可以 [https://gitee.com/explore](https://gitee.com/explore) 这个地址来了解 Gitee 上的优秀开源项目
4.  [GVP](https://gitee.com/gvp) 全称是 Gitee 最有价值开源项目，是综合评定出的优秀开源项目
5.  Gitee 官方提供的使用手册 [https://gitee.com/help](https://gitee.com/help)
6.  Gitee 封面人物是一档用来展示 Gitee 会员风采的栏目 [https://gitee.com/gitee-stars/](https://gitee.com/gitee-stars/)
