package grid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class Casanofamily {
	
	
	
	@Test
	public void testDb() throws Throwable
	{
		
		String actual_data="sutrishnagiri";
		boolean flag=false;
		
		Driver d= new Driver();
		DriverManager.registerDriver(d);
		Connection conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm","root","root");
		
		System.out.println("connection is estabilished");
		
		Statement stat = conn.createStatement();
		ResultSet result = stat.executeQuery("select * from project ");
			while(result.next())
			{
				String expected_data = result.getString(2);
				
				if(actual_data.equals(expected_data))
				{
					flag=true;
					System.out.println(actual_data+":"+"data is present");
				}
			}
		
			if(flag==false)
			{
				System.out.println(actual_data+":"+"data is present");
			}
			conn.close();
	}

}
