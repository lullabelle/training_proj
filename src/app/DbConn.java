package app;

import java.sql.*;

public class DbConn {
	
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	

		public static void dbConnection(String SQL) {
			try {
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Nemesis","root","Staged00r1");
				System.out.println("Connected");
				Statement state = conn.createStatement();
				state.execute(SQL);
				

			} catch (Exception ex) {
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ((SQLException) ex).getSQLState());
				System.out.println("VendorError: "
						+ ((SQLException) ex).getErrorCode());
				System.out.println(SQL);
			}

			
		}
	
}
	

