package ua.plitker.core.model;

import static org.junit.Assert.fail;

import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.apache.log4j.Logger;
import org.junit.Ignore;

import ua.plitker.core.util.logging.LoggerUtil;
import ua.plitker.core.util.validation.BeanValidator;

@Ignore
public class AbstractModelUnitTest {
	
	private static final Logger LOG = Logger.getLogger(LoggerUtil.getLoggingClassName());

	protected <T> void assertValid(T bean) {
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
