package com.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.user.entity.User;
import com.user.repository.UserRepository;
import com.user.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceApplicationTests {

	@Autowired
	UserService userService;

	@MockBean
	UserRepository userRepository;

	@Test
	void contextLoads() {
	}

	@SuppressWarnings("removal")
	@Test
	public void test_addUser() {
		User user = new User(new Long(1), "Ashwin1", "Kumar1", "ashwin1@gmail.com", "Bengaluru", "1234567890",
				"ashwin1", "ashwin1");
		when(userRepository.save(user)).thenReturn(user);
		assertEquals(user, userService.addUser(user));
	}

	@Test
	public void test_getUserById() {
		User user = new User(new Long(1), "Ashwin1", "Kumar1", "ashwin1@gmail.com", "Bengaluru", "1234567890",
				"ashwin1", "ashwin1");
		when(userRepository.getById(new Long(1))).thenReturn(user);
		assertEquals(user, userService.getUserById(new Long(1)));
	}

	@Test
	public void test_getUserByEmail() {
		User user = new User(new Long(1), "Ashwin1", "Kumar1", "ashwin1@gmail.com", "Bengaluru", "1234567890",
				"ashwin1", "ashwin1");
		when(userService.getUserByEmail("ashwin1@gmail.com")).thenReturn(user);
		assertEquals(user, userService.getUserByEmail("ashwin1@gmail.com"));
	}

}
