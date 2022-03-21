package AutoMateCase;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class NewTest {
  @Test
  public void f() {
	 String str1="Hi";
	 String str2="HI";
	 Assert.assertEquals(str1, str2);
	
	 SoftAssert sa=new 	 SoftAssert();
	 sa.assertEquals(str1, str1);
	 sa.assertAll();
			 
  }
}
