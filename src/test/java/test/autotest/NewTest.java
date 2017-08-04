package test.autotest;

import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class NewTest {   
	public Assertion assertion;
	    @BeforeClass
	    public void beforeClass() {
	        assertion = new Assertion();
	    }

	    @BeforeMethod
	    public void runBeforeMethod() {
	        // 打开httpclient,相当于打开一个浏览器
	        HttpUtils.OpenHttpClient();//这边一定要记得在测试用例开始之前打开浏览器，否则会出现空指针的错误
	    }
	    @AfterMethod
	    public void runAfterMethod() {
	        // 打开httpclient,相当于打开一个浏览器
	        HttpUtils.CloseHttpClient();
	    }
	    
	  @org.testng.annotations.Test
	  public void f() throws IOException, JSONException {
	      	String loginUrl="http://api.map.baidu.com/telematics/v2/reverseGeocoding?location=116.305145,39.982368&ak=yourkey";
	//        String loginUrl = "http://xx.xxx.cn/Org/PCUserLogin.do?u=11111&p=1111&groupId=1";
	        String json = HttpUtils.sendHttpsGet(loginUrl);
	        System.out.println(json);
	//        boolean success = json.getBoolean("success");
	/*        String enterTrainningUrl = "http://xx.xxx.cn/Training/enterTrainingCamp.do?roomid=1111";
	        System.out.println(enterTrainningUrl);
	        JSONObject enterObj = HttpUtils.visitUrl(enterTrainningUrl);
	        System.out.println(enterObj.toString());
	        boolean success2 = enterObj.getBoolean("success");
	 */  //     assertion.assertTrue(success);
	  }
	}
