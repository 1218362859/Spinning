package com.femtoapp.tool;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;


public class SendTelMessage {
	public static void main(String[] avgs) throws Exception{
	       
	       
	       SMSsend("2345","18379607713");
//	       SendShare("(����������jianidgesfdsadfs��·���ӿ�)","18379607713");
	      
	   }
	 
	 
	 static public int SMSsend(String msg , String mobile) throws Exception{
		   int error_code = 1;
		   String result = "";
		   String CorpID="302237"; //��¼ID��
	       String LoginName="Admin";//��¼��
	       String passwd="216811";//��¼����
	       Date now = new Date(); 
	       SimpleDateFormat dateFormat = new SimpleDateFormat("MMddHHmmss");//���ڸ�ʽ��
	       String timeStamp = dateFormat.format(now);	 
	       String strPwsd = MD5Tools.MD5(CorpID+passwd+timeStamp);//MD5���ܷ�ʽ
		   String urls="";
	       	 
	       
	       try{
	    	   msg=URLEncoder.encode("������֤��Ϊ" + msg,"GBK");//ת��
	    	   String baseUrl = "sms3.mobset.com";//�������׶��Žӿڵ�ַ,CorpID��ͷ������3����Ӧ��ַ��sms3.mobset.com
		       urls="http://"+baseUrl+"/SDK2/Sms_Send.asp?CorpID="+CorpID+"&LoginName="+LoginName+"&TimeStamp="+timeStamp+"&passwd="+strPwsd+"&send_no="+mobile+"&Timer=&msg="+msg+"&LongSms=1";
		       System.out.println(urls);
		       URL U = new URL(urls);
			   URLConnection connection = U.openConnection();
			   connection.connect();
			   BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			   String line;
			   while ((line = in.readLine())!= null) {
			     result += line;
			   }
			   
			   in.close();   
		   }catch(Exception e){
		    System.out.println("û�н����"+e);
		    error_code = -1;
		   }
	       System.out.println(error_code);
	       return  error_code;
	  }


	public static String SendShare(String msg , String mobile) throws Exception {
		// TODO Auto-generated method stub
	   int error_code = 0;
	   String result = "";
	   String CorpID="302237"; //��¼ID��
    String LoginName="Admin";//��¼��
    String passwd="216811";//��¼����
    Date now = new Date(); 
    SimpleDateFormat dateFormat = new SimpleDateFormat("MMddHHmmss");//���ڸ�ʽ��
    String timeStamp = dateFormat.format(now);	 
    String strPwsd = MD5Tools.MD5(CorpID+passwd+timeStamp);//MD5���ܷ�ʽ
	   String urls="";
	   String urls2="";
	   
    try{
 	   msg=URLEncoder.encode("�𾴵��û��������ڿ���ͨ���ٴ�ӥ��APPֱ���ƿ�"+msg+"���ֳ�ʩ��������������ذٴ�ӥ��APP�������·���ַ�������أ�http://www.bc100.com/download/bcyingyan.apk���������⣬���µ�ͷ����ߣ�400-888-6266���ظ�TD�˶�","GBK");	
 	   //msg=URLEncoder.encode("�𾴵��û������ã��������Ѿ�����ͨ���ٴ�ӥ��appֱ�ӹۿ�"+msg+"�ֳ�ʩ�������������������www.bc100.com���������⣬���µ繫˾�ͷ����ߣ�400-888-6266","GBK");//ת��
 	   String baseUrl = "sms3.mobset.com";//�������׶��Žӿڵ�ַ,CorpID��ͷ������3����Ӧ��ַ��sms3.mobset.com
	       urls="http://"+baseUrl+"/SDK2/Sms_Send.asp?CorpID="+CorpID+"&LoginName="+LoginName+"&TimeStamp="+timeStamp+"&passwd="+strPwsd+"&send_no="+mobile+"&Timer=&msg="+msg+"&LongSms=1";
	       System.out.println(urls);
	       URL U = new URL(urls);
		   URLConnection connection = U.openConnection();
		   connection.connect();
		   BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		   String line;
		   while ((line = in.readLine())!= null) {
		     result += line;
		   }
		   
		   in.close();   
	   }catch(Exception e){
	    System.out.println("û�н����"+e);
	    error_code = 1;
	   }
    System.out.println(error_code);
    return  "" + error_code;
	}
}
