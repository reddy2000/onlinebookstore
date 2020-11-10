/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project5;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;
 
public class SendEmail {

    /**
     * @param to
     * @param args the command line arguments
     */
    public static void send(String to)
    {
        String from = "bumbleshines24@gmail.com";
        Properties properties = new Properties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");
        
        Session session;
        session = Session.getDefaultInstance(properties,new javax.mail.Authenticator()
        {
            @Override
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication("bumbleshines24@gmail.com","BUMBLE123");
            }
        });
        try
        {
            MimeMessage message=new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setSubject("WELCOME TO BUMBLE");
            message.setText("Read anytime ! anywhere !  purchase!");
            Transport.send(message);
            System.out.println("sent message successfully...");
        }
        catch(MessagingException mex)
        {
            mex.printStackTrace();
        } 
    }
    public static void authenticate(String to,String otp)
    {
        String from = "bumbleshines24@gmail.com";
        Properties properties = new Properties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");
        
        Session session;
        session = Session.getDefaultInstance(properties,new javax.mail.Authenticator()
        {
            @Override
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication("bumbleshines24@gmail.com","BUMBLE123");
            }
        });
        try
        {
            MimeMessage message=new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setSubject("OTP for Password Change");
            message.setText("One Time Password: "+otp);
            Transport.send(message);
            System.out.println("sent message successfully...");
        }
        catch(MessagingException mex)
        {
            mex.printStackTrace();
        } 
    }
    public static void login(String to)
    {
        String from = "bumbleshines24@gmail.com";
        Properties properties = new Properties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");
        
        Session session;
        session = Session.getDefaultInstance(properties,new javax.mail.Authenticator()
        {
            @Override
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication("bumbleshines24@gmail.com","BUMBLE123");
            }
        });
        try
        {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
            LocalDateTime now = LocalDateTime.now();  
            System.out.println(dtf.format(now));  
            MimeMessage message=new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setSubject("Login Alert!!");
            message.setText("You have accessed your bumble book store accout on "+dtf.format(now)+".If it wasn't you please secure your account by changing your password");
            Transport.send(message);
            System.out.println("sent message successfully...");
        }
        catch(MessagingException mex)
        {
            mex.printStackTrace();
        }
    }
    
    public static void order(int id)
    {
        String to = Library.email;
        String from = "bumbleshines24@gmail.com";
        Properties properties = new Properties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");
        
        Session session;
        session = Session.getDefaultInstance(properties,new javax.mail.Authenticator()
        {
            @Override
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication("bumbleshines24@gmail.com","BUMBLE123");
            }
        });
        try
        { 
            MimeMessage message=new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setSubject("Order Placed Successfully");
            message.setText("Your order with order id "+id+" has received and will be delivered within 7 days");
            Transport.send(message);
            System.out.println("sent message successfully...");
        }
        catch(MessagingException mex)
        {
            mex.printStackTrace();
        }
    }
}
