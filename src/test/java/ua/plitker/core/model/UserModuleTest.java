package ua.plitker.core.model;

import org.junit.Test;

public class UserModuleTest extends AbstractModelUnitTest {
	
	@Test
	public void userShouldBeValid() {
		User user = new User();
		user.setDescription("Description");
		user.setFullName("Full Name");
		user.setPassword("password");
		user.setUsername("username");
		user.setEmail("user@gmail.com");
		
		assertValid(user);
	}
	
	@Test(expected=AssertionError.class)
	public void userShouldNotBeValid() {
		User user = new User();
		user.setDescription("Description");
		user.setFullName("Full Name");
		user.setPassword("pass");
		user.setEmail(null);
		
		assertValid(user);
	}

}
