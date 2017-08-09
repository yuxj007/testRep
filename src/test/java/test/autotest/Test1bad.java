package test.autotest;



import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

public class Test1 {
//	@Test
	public void testCase1() throws Exception{
	//	String url="http://msg.whispir.cc/api/v1/apps/test/messages";
		String url="http://172.16.1.166:18090/api/v1/apps/test/messages";
		String post="{"
				   +" \"to\":{"
				   + " \"sms\":[\"13520849804\"], " 
				   + "\"email\":{\"to\":[\"jackieyu@whispir.cc\"]}"  
				   + "}," 
				   + "\"content\": {"
				   + "\"sms\":\"Hello world!\","  
				   + "\"email\":{\"subject\":\"test\", \"body\":\"hello world\"}"  
				   + "}" 
				  +"}";
				
		System.out.println("******Test Case1:	发送消息接口（post请求）");
		System.out.println(url);
		String strJsonResponse=RestAPITest.setupPOST(url,post);
	//	String strJsonResponse="{\"results\":{\"mid\":\"ea9c7d03-5f53-40ae-a13d-89a6d83b42af\"}}" ;
		System.out.println("Http Post请求返回值：	"+strJsonResponse);
		
		JSONObject jsonObject=new JSONObject(strJsonResponse);
		JSONObject resultsObject=(JSONObject) jsonObject.get("results");
		String results=resultsObject.toString();
		String mid=resultsObject.get("mid").toString();
		System.out.println("解析Json串得到results值:	"+results);
		System.out.println("解析Json串得到mid值:	"+mid);
		
		Assert.assertTrue("HTTP response body contains mid or not:", strJsonResponse.contains("mid"));
	
	}
	
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
