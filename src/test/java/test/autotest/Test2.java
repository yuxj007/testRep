package test.autotest;

import org.junit.Assert;
import org.testng.annotations.Test;

public class Test2 {
	 @Test
	  public void testcase21() throws Exception {

		
		  		String mid="99bc4c61-507e-4bd6-8b97-4274795ed73";
		  		String url="http://grcdemo.smartdot.com:38080/demo-web/rest/permission/menuResource/user/1797852098989738004/application/DEFAULT/firstLevelMenus";
		  		System.out.println("******Test21:	查询状态接口（Get请求）:"+url);
		  		Assert.assertTrue("HTTP response body contains mid or not:", RestAPITest.setUPGET(url));
		  	
		  	}
}

