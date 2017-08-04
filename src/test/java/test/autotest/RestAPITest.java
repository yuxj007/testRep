package test.autotest;


import java.io.*; 
import java.net.*; 

public class RestAPITest {
	 /**
     * 从网络获取json数据,(String byte[})

     * @param path
     * @return
     */

    public boolean getJson(String url) throws Exception 
    { 
        URL restURL = new URL(url); 
        HttpURLConnection conn = (HttpURLConnection) restURL.openConnection(); 
        int responseCode=conn.getResponseCode();
        if (responseCode==200) {
        	System.out.println("Status Code: "+responseCode+"   OK");
        	System.out.println("Success");
			InputStream is = conn.getInputStream();
			InputStreamReader isr=new InputStreamReader(is,"UTF-8");
			BufferedReader b = new BufferedReader(isr);
		
			FileOutputStream fos=new FileOutputStream("/Users/yxjmac/Documents/workspace/autotest/restApiLog.txt");
			BufferedWriter br = new BufferedWriter(new OutputStreamWriter(
					fos, "UTF-8"));
			String b2;
			while ((b2 = b.readLine()) != null) {
				System.out.println(b2);
				br.write( b2);
				br.flush();
			}
			b.close();
			br.close();
			conn.disconnect();
	       	return true ;
	       	
        }
        else{
        	System.out.println("Status Code: "+responseCode);
        	System.out.println("No Success");
        	return false;
        }
      
    }
      
 
    
    	//获取其他页面的数据
       /**
        * POST请求获取数据
        */
       public String postJson(String url,String post){
           URL restURL = null;
           try {
        	   restURL = new URL(url);
               HttpURLConnection httpURLConnection = (HttpURLConnection) restURL.openConnection();
               httpURLConnection.setRequestMethod("POST");// 提交模式
               httpURLConnection.setConnectTimeout(100000);//连接超时 单位毫秒
               httpURLConnection.setReadTimeout(20000);//读取超时 单位毫秒
               // 发送POST请求必须设置如下两行
               httpURLConnection.setDoOutput(true);
               httpURLConnection.setDoInput(true);
               httpURLConnection.setRequestProperty("Content-Type", "application/vnd.whispircn.msgcore.message-v1+json");
               // 获取URLConnection对象对应的输出流
               PrintWriter printWriter = new PrintWriter(httpURLConnection.getOutputStream());
               // 发送请求参数
               printWriter.write(post);    //post的参数 xx=xx&yy=yy
               // flush输出流的缓冲
               printWriter.flush();
               int responseCode=httpURLConnection.getResponseCode();
               if (responseCode==202);{
       //     	   System.out.println("Http Response Status Code:	" + responseCode);
            	   //开始获取数据
                   BufferedInputStream bis = new BufferedInputStream(httpURLConnection.getInputStream());
                   ByteArrayOutputStream bos = new ByteArrayOutputStream();
                   int len;
                   byte[] arr = new byte[1024];
                   while((len=bis.read(arr))!= -1){
                       bos.write(arr,0,len);
                       bos.flush();
                   }
                   bos.close();
                   return bos.toString("utf-8");
               } 
               
            
           } catch (Exception e) {
               e.printStackTrace();
           }
           return null;
       }
    
	public  static boolean setUPGET(String url) throws Exception{
	
		boolean status = false;
	    RestAPITest	restApi=new RestAPITest();
	    try{
	    	status=restApi.getJson(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return status;
	}
	public static   String setupPOST(String url,String post) throws Exception{
		
	    RestAPITest	restApi=new RestAPITest();
	   
	    return restApi.postJson(url, post);
		
	}
}

