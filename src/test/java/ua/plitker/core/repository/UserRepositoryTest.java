package ua.plitker.core.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ua.plitker.core.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:ua/plitker/core/applicationContext.xml")
public class UserRepositoryTest {

	@Autowired
	UserRepository repository;
	
	@Test
	public void shouldSave() {
		User user = getUser();
		User savedUser = repository.save(user);
		System.out.println("***********");
		System.out.println(user);
		System.out.println(savedUser);
		assertEquals(user, savedUser);
	}
	
	private User getUser() {
		User user = new User();
		user.setId(0L);
		user.setDescription("Description");
		user.setFullName("Full Name");
		user.setPassword("password");
		user.setUsername("username");
		user.setEmail("user@gmail.com");
		return user;
	}

}
