package cn.itcast.cxf.ws.client;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import cn.itcast.cxf.service.IUserService;

public class WS_Client {
	public static void main(String[] args) {
		JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
		jaxWsProxyFactoryBean.setServiceClass(IUserService.class);
		jaxWsProxyFactoryBean.setAddress("http://localhost:9999/userService");
		
		// 通过拦截器 打印soap 报文信息
		jaxWsProxyFactoryBean.getInInterceptors().add(new LoggingInInterceptor());
		jaxWsProxyFactoryBean.getOutInterceptors().add(new LoggingOutInterceptor());

		IUserService proxy = (IUserService) jaxWsProxyFactoryBean.create();
		System.out.println(proxy.sayHello("美美"));
	}
}
