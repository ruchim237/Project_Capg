package Sprint1;

import static org.junit.Assert.*;

import org.junit.Test;

public class Testing {

	MethodClass l=new MethodClass();
	@Test
	public void testname()
	{
		assertEquals(true,l.validationName("Ruchi"));
	}
	@Test
   public void testMobNumber()
   {
		assertEquals(true,l.validationNumber("9450323180"));

   }
	@Test
	public void testEmailId()
	{
		assertEquals(true,l.EmailValid("ruchim237@gmail.com"));
	}
	@Test
	public void testPassWord()
	{
		assertEquals(true,l.validationPassword("ruchim234@"));
	}
	@Test
	public void AdminLogin()
	{
		assertEquals("Login Successful",l.AdminLogin());
	}
	
}


