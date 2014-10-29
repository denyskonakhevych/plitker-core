package ua.plitker.core.model;

import org.junit.Test;

public class MessageModuleTest extends AbstractModelUnitTest {

	@Test
	public void userShouldBeValid() {
		Message message = new Message();
		message.setAuthor(createAuthor());
		message.setText("Hello world");
		
		assertValid(message);
	}
	
	@Test(expected=AssertionError.class)
	public void userShouldNotBeValid() {
		Message message = new Message();
		message.setAuthor(createAuthor());
		message.setText("");
		
		assertValid(message);
	}
	
	private User createAuthor() {
		User user = new User();
		user.setDescription("Description");
		user.setFullName("Full Name");
		user.setPassword("password");
		user.setUsername("username");
		user.setEmail("user@gmail.com");
		return user;
	}

}
