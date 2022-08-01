package cn.learning.controller;

import cn.learning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Package: cn.learning.controller
 * @Description: UserController
 * @Author: Sammy
 * @Date: 2022/7/31 19:08
 */
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/zhouyu")
	public void test() {
		userService.test();
	}
}
