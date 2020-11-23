# 简单好用的强大代码生成器！！
<br><br>
## 一.部署项目<br>
1.安装IDEA、JDK、Maven、Tomcat等基础环境。<br><br>
2.项目导入idea，修改/src/main/resources/properties/jdbc.properties配置文件信息，将数据库连接改成你本地的数据库。<br><br>
3.修改/src/test/resources/generatorConfig.properties配置文件，此配置文件为代码生成器配置文件，具体修改内容请看注释。<br><br>
4.确保配置文件无误后，运行/src/test/java/com/codegen/main/CodeGeneratorMain.java类,如控制台打印如下信息，那么说明代码生成成功。
![](http://sowcar.com/t6/691/1553764592x2890149536.png)
<br><br>
5.在生成的mapperxml文件夹中，增加如下查询代码：
  ![](http://sowcar.com/t6/691/1553764548x2099769148.png)
  <br><br>
6.启动项目，访问路径http://127.0.0.1:8080/xxx/page.shtml 即可看到增删改查的效果！
![](http://sowcar.com/t6/691/1553764620x2890149536.png)
<br><br>
7.项目遇到任何问题，启动不了的同学请联系我，我会提供相应支持。<br><br>
QQ群号： 259217951 <br>
QQ:  971886506 <br>
WeChat: zwj971886506 <br>
Email:  zhangwenjunp@126.com<br><br>
8.可能遇到的错误:<br>
  1.代码没有生成到项目文件中，确认你generatorConfig.properties配置文件中project.file.path的配置，一定要确保和你项目同路径，否则代码会生成到磁盘其他路径特别注意！！！<br><br>
  2.项目读取不到generatorConfig.properties和properties文件夹下的配置文件，确认你maven是否配置了打包过滤，编译后的文件中是否存在这些配置文件<br><br>
  3.未在生成的mapperxml增加查询语句，则控制台会报错,分页列表也无效果<br><br>
## 二.未来版本<br>
  下一步会把Bootstrap、ElementUI主流的前端框架增删改查demo集成到项目中，后续会考虑代码生成器和vue、react集成，支持更多的UI框架，适应多种公司开发场景应用。
<br>
## 三.说明与结语<br>
本项目开源旨在，解决日常工作、练习中代码的重复工作量，充分利用开发着的时间去写更多的业务代码，而不是一成不变的curd。<br>
有问题或者有任何疑问请加QQ群：259217951  包括你运行项目的问题，各种问题。我会一一回复你们。如果觉得代码生成器好用，请不要吝啬你的小星星，帮我点点star  thanks~~ 那将会是支持我前进的源动力！<br>
另外推荐一个特别好用的基金自选助手，https://www.yiduu.com

