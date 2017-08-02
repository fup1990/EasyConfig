# EasyConfig

#功能介绍
配置文件管理系统<br/>
动态的管理、获取、修改配置信息

# 模块介绍
easyconfig-common是公共模块<br/>
easyconfig-agent负责客户端与EasyConfig服务端远程通信，获取配置信息<br/>
easyconfig-server服务端，负责配置信息的增删改查<br/>
easyconfig-demo客户端，远程获取服务端的配置信息<br/>

# 如何启动测试用例：<br/>
  1、easyconfig-server，clean package -D maven.test.skip=true tomcat7:run<br/>
  2、在客户端easyconfig-demo的pom.xml文件中添加easyconfig-agent依赖<br/>


