/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project5;

/**
 *
 * @author Nivedha - G
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
 
import javax.net.ssl.HttpsURLConnection;
public class SendSms 
{

      public static void sendSms(String number) throws IOException
      {
          String message ="welcome to bumble! read anytime! anywhere!"+new Date().toLocaleString();
       try{
         String apiKey="C5nUYO97dBXwTfz8iG2ImWtNAvrgRQ0ukZljLFasoyqKhS6pHJwijJKkNdarVcZhzoHRf5bmvSqDUAu3";
        String sendId="FSTSMS";
        //important step...
        message=URLEncoder.encode(message, "UTF-8");
        String language="english";
         
        String route="p";
          
         
        String myUrl="https://www.fast2sms.com/dev/bulk?authorization="+apiKey+"&sender_id="+sendId+"&message="+message+"&language="+language+"&route="+route+"&numbers="+number;
         
        //sending get request using java..
         
        URL url = null;
        try {
            url = new URL(myUrl);
        } catch (MalformedURLException ex) {
            Logger.getLogger(SendSms.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        HttpsURLConnection con=(HttpsURLConnection)url.openConnection();
         
         
        con.setRequestMethod("GET");
         
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        con.setRequestProperty("cache-control", "no-cache");
        System.out.println("Wait..............");
         
        int code=con.getResponseCode();
         
        System.out.println("Response code : "+code);
         
        StringBuffer response=new StringBuffer();
         
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(con.getInputStream()));
        } catch (IOException ex) {
            Logger.getLogger(SendSms.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        while(true)
        {
            String line= br.readLine();
            if(line==null)
            {
                break;
            }
            response.append(line);
        }
         
        System.out.println(response);
         
         
      
       }catch (Exception e) 
         {
            // TODO: handle exception
            e.printStackTrace();
        }
}
  
    public static void main(String[] args) throws IOException 
{
        // TODO code application logic here
 System.out.println("Program started.....");
         
         
        SendSms.sendSms("8300423119");
    }
    private String message;
    
}
