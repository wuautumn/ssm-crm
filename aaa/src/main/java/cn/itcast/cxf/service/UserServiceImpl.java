package cn.itcast.cxf.service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import cn.itcast.cxf.domain.Car;
import cn.itcast.cxf.domain.User;

@WebService(endpointInterface = "cn.itcast.cxf.service.IUserService", serviceName = "userService")
public class UserServiceImpl implements IUserService {

	public String sayHello(String name) {
		System.out.println(123);
		return "Hello"+name;
	}

	public List<Car> findCarsByUser(User user) {
		// 这里本应该查询数据库的，为了演示，做一些假数据
				if ("xiaoming".equals(user.getUsername())) {
					List<Car> cars = new ArrayList<Car>();
					Car car1 = new Car();
					car1.setId(1);
					car1.setCarName("大众途观");
					car1.setPrice(200000d);
					cars.add(car1);

					Car car2 = new Car();
					car2.setId(2);
					car2.setCarName("现代ix35");
					car2.setPrice(170000d);
					cars.add(car2);

					return cars;
				} else {
					return null;
				}
	}

}
