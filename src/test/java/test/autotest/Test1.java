package test.autotest;

import org.junit.Assert;
import org.testng.annotations.Test;

public class Test1 {
	@Test
	public void testCase11() throws Exception{
		String mid="99bc4c61-507e-4bd6-8b97-4274795ed73";
//		String url="http://msg.whispir.cc/api/v1/apps/test/messages/"+mid;
//		String url="http://172.16.1.166:18090/api/v1/apps/test/messages/"+mid;
		String url="http://grcdemo.smartdot.com:38080/demo-web/rest/permission/menuResource/user/1797852098989738004/application/DEFAULT/firstLevelMenus";
		System.out.println("******Test11:	查询状态接口（Get请求）:"+url);
		Assert.assertTrue("HTTP response body contains mid or not:", RestAPITest.setUPGET(url));
	
	}
	

}
