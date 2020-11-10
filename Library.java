/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project5;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Nivedha - G
 */
public class Library {
    public static int i=1;
    public static int age = 0;
    public static String name = null,email = null,pass=null;
    public static boolean checkusername(String username,String password) throws Exception
    {
        String a = null;
        email = username;
        Connection con = DB.getConnection(); 
        PreparedStatement st = con.prepareStatement("select password,age,cusname from cus_details where email = '"+email+"'");
        ResultSet rs =st.executeQuery();  

        while(rs.next())
        {
            email = username;
            a = rs.getString(1);
            age = rs.getInt(2);
            name = rs.getString(3);
            //if(username.equals(a))
            //{
                User.username = a;
            //}
        }
        if(a.equals(password))
            return true;
        return false;
    }
    
    public static void insetimage(int name,String path) throws SQLException, FileNotFoundException
    {
        System.out.println(path);
        FileInputStream n = new FileInputStream(new File(path));
        Connection con = DB.getConnection();
        PreparedStatement st = con.prepareStatement("update book_detail set image =? where isbn="+name+"");
        
        //st.setInt(1, 103);
        st.setBinaryStream(1, n);
        int i = st.executeUpdate();
        if(i>0)
            JOptionPane.showMessageDialog(null, "Data Inserted");
    }
    
    public static void insertbook(String bookname,String author) throws SQLException
    {
        Connection con = DB.getConnection(); 
        PreparedStatement st = con.prepareStatement("insert into viewshelf values(?,?)");
        
        st.setString(1, bookname);
        st.setString(2, author);
        
        st.executeUpdate();        
    }
     
    public static void update_member(String username,String password)throws SQLException
    {
        Connection con = DB.getConnection(); 
        System.out.println(username+" "+password);
        PreparedStatement st = null;
        try
        {
            st = con.prepareStatement("update cus_details set password ='"+password+"' where email='"+username+"'");
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
        }
        st.executeUpdate();
    }
    
    public static void update_book(int Isbn,int availability,int copies,int accessibility)throws SQLException
    {   
        Connection con = DB.getConnection(); 
        //System.out.println(username+" "+password);
        PreparedStatement st = null;
        /*try
        {
        
            st = con.prepareStatement("update book_detail set isbn = '"+Isbn+"',author='"+author+"',category='"+category+"',bklanguage='"+lan+"',availability='"+availability+"',copies='"+copies+"',accessibility='"+accessibility+"' where book_name='"+book+"'");
            //st = con.prepareStatement("update book_detail set book_name='"+book+"' where Isbn='"+Isbn+"'");
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
        }
        st.executeUpdate();*/
        System.out.println(Isbn+" "+availability+" "+copies+" "+accessibility);
        st = con.prepareStatement("update book_detail set availability="+availability+",copies="+copies+",accessibility="+accessibility+" where isbn="+Isbn+"");
        int i = st.executeUpdate();
        if(i>0)
            JOptionPane.showMessageDialog(null, "Data Updated");
        else
            JOptionPane.showMessageDialog(null, "Data not Updated");
    }
    
    public static void update_profile(String name,String email,String phone,int age) throws SQLException
    {
        Connection con = DB.getConnection();
        PreparedStatement st = null;
        st = con.prepareStatement("update cus_details set phone='"+phone+"',cusname='"+name+"',age="+age+" where email='"+email+"'");
        int i = st.executeUpdate();
        if(i>0)
            JOptionPane.showMessageDialog(null, "Data Updated");
        else
            JOptionPane.showMessageDialog(null, "Data not Updated");
    }
    
    public static void delete_book(int Isbn) throws SQLException
    {
        Connection con = DB.getConnection();
        String sql = "delete from book_detail where isbn = "+Isbn+"";
        PreparedStatement ps = con.prepareStatement(sql);
        int i=ps.executeUpdate();
        if(i>0)
            JOptionPane.showMessageDialog(null, "Data Deleted");
        else
            JOptionPane.showMessageDialog(null, "Data not Deleted");
    }
    public static String getbook(int index) throws Exception
    {
        String book;
        
        Connection con = DB.getConnection();
        Statement st = con.createStatement();
         ResultSet rs = st.executeQuery("select bookname from viewshelf");
         
         rs.next();
         
         if(index==2)
             rs.next();
         
        book = rs.getString(1);
        
        return book;
    }
    
    public static String getauthor(int index) throws Exception
    {
        String author;
        
        Connection con = DB.getConnection();
        Statement st = con.createStatement();
         ResultSet rs = st.executeQuery("select author from viewshelf");
         
         rs.next();
         
         if(index==2)
             rs.next();
         
        author = rs.getString(2);
        
        return author;
    }
    
    
    
    
}

class User
{
    public static boolean loggedin;
    public static String username;
}

/*class DB
{
    public static Connection getConnection()
    {
        Connection con = null;
        
        try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
		}
		catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}
        
        return con;
    }*/
    
class DB
{
    public static Connection getConnection()
    {
        Connection con = null;
        
        try {
			//Class.forName("oracle.jdbc.driver.OracleDriver");
            String url ="jdbc:derby://localhost:1527/reading";
			con = DriverManager.getConnection(url,"reading","reading")
;		}
		catch (SQLException e) {
			System.out.println(e);
		}
        
        return con;
    }
}