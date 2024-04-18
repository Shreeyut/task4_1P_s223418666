package sit707_week4;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests functions in LoginForm.
 * @author Ahsan Habib
 */
public class LoginFormTest 
{

	@Test
	public void testStudentIdentity() {
		String studentId = "s223418666";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Shreeyut Shrestha";
		Assert.assertNotNull("Student name is null", studentName);
	}
	
	@Test
    public void testFailEmptyUsernameAndEmptyPasswordAndDontCareValCode()
    {
		LoginStatus status = LoginForm.login(null, null);
		Assert.assertTrue( status.isLoginSuccess() == false );
    }
	
	/*
	 * Write more test functions below.
	 */
	@Test
    public void testFailEmptyUsernameAndWrongPasswordAndDontCareValCode()
    {
		LoginStatus status = LoginForm.login(null, "abcd");
		Assert.assertTrue( status.isLoginSuccess() == false );
    }
	@Test
    public void testFailEmptyUsernameAndCorrectPasswordAndDontCareValCode()
    {
		LoginStatus status = LoginForm.login(null, "ahsan_pass");
		Assert.assertTrue( status.isLoginSuccess() == false );
    }
	@Test
    public void testFailWrongUsernameAndNullPasswordAndDontCareValCode()
    {
		LoginStatus status = LoginForm.login("abcd", null);
		Assert.assertTrue( status.isLoginSuccess() == false );
    }
	@Test
    public void testFailWrongUsernameAndWrongPasswordAndDontCareValCode()
    {
		LoginStatus status = LoginForm.login("abcd", "abcd");
		Assert.assertTrue( status.isLoginSuccess() == false );
    }
	@Test
    public void testFailWrongUsernameAndCorrectPasswordAndDontCareValCode()
    {
		LoginStatus status = LoginForm.login("abcd", "ahsan_pass");
		Assert.assertTrue( status.isLoginSuccess() == false );
    }
	@Test
    public void testFailCorrectUsernameAndNullPasswordAndDontCareValCode()
    {
		LoginStatus status = LoginForm.login("ahsan", null);
		Assert.assertTrue( status.isLoginSuccess() == false );
    }
	@Test
    public void testFailCorrectUsernameAndWrongPasswordAndDontCareValCode()
    {
		LoginStatus status = LoginForm.login("ahsan", "abcd");
		Assert.assertTrue( status.isLoginSuccess() == false );
    }
	@Test
    public void testFailCorrectUsernameAndCorrectPasswordAndNullValCode()
    {
		LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
		boolean Code = LoginForm.validateCode(null);
		Assert.assertTrue( status.isLoginSuccess() == true );
		Assert.assertTrue( Code == false );
    }
	@Test
    public void testFailCorrectUsernameAndCorrectPasswordAndWrongValCode()
    {
		LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
		boolean Code = LoginForm.validateCode("abcd");
		Assert.assertTrue( status.isLoginSuccess() == true );
		Assert.assertTrue( Code == false );
    }
	@Test
    public void testFailCorrectUsernameAndCorrectPasswordAndCorrectValCode()
    {
		LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
		boolean Code = LoginForm.validateCode("123456");
		Assert.assertTrue( status.isLoginSuccess() == true );
		Assert.assertTrue( Code == true );
		
    }
}
