package ua.plitker.core.model;

import static org.junit.Assert.fail;

import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.apache.log4j.Logger;
import org.junit.Test;

import ua.plitker.core.util.logging.LoggerUtil;
import ua.plitker.core.util.validation.BeanValidator;

//@RunWith(SpringJUnit4ClassRunner.class)
public class UserModuleTest {
	
	private static final Logger LOG = Logger.getLogger(LoggerUtil.getLoggingClassName());

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
	
	private <T> void assertValid(T bean) {
		BeanValidator validator = new BeanValidator();
		Set<ConstraintViolation<T>> constraintViolations = validator.validate(bean);
		if(constraintViolations.size() != 0) {
			pupulateViolationsIfExist(validator.validate(bean));
			fail("Bean constraits has bean violated");
		}
	}
	
	private <T> void pupulateViolationsIfExist(Set<ConstraintViolation<T>> constraintViolations) {
		ConstraintViolation<T> violation;
		for (Iterator<ConstraintViolation<T>> iterator = constraintViolations.iterator(); iterator.hasNext(); ) {
			violation = iterator.next();
			LOG.info("Field: \"" + violation.getPropertyPath() + "\" " + violation.getMessage() + " Validation value: \"" + violation.getInvalidValue() + "\" ");
		}
	}

}
