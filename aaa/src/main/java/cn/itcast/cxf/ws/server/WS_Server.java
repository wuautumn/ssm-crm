package cn.itcast.cxf.ws.server;

import javax.xml.ws.Endpoint;

import cn.itcast.cxf.service.IUserService;
import cn.itcast.cxf.service.UserServiceImpl;

public class WS_Server {
	public static void main(String[] args) {
		// 创建服务实现类 对象
		IUserService userService = new UserServiceImpl();
		// 定义服务地址
		String address = "http://localhost:9999/userService";
		// 发布服务
		Endpoint.publish(address, userService);
		// 打印信息
		System.out.println("helloService 服务已经启动 ...");
	}
}
