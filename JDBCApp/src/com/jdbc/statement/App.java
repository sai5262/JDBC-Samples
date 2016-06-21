// first & Basic JDBC app

package com.jdbc.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		System.out.println("*****connection creation process******");
		// step1: loading & register driver with DriverManager class
		Class.forName("oracle.jdbc.OracleDriver");

		// step2: get the connection object
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "SAIKUMAR", "saikumar");
		if (con != null) {
			System.out.println("Connection successfull");
		}

		// step3- create a statement Object & execute
		System.out.println("*****table creation process******");
		String query1 = "create table emp11(eid number,ename varchar2(24),esal number)";
		Statement st = con.createStatement();
		System.out.println("table created " + st.executeUpdate(query1));

		System.out.println("*****insertion process******");
		String query2 = "insert into emp11 values(111,'ratan',40000)";
		String query3 = "insert into emp11 values(222,'ratan',50000)";
		String query4 = "insert into emp11 values(333,'suneel',60000)";
		st.executeUpdate(query2);
		st.executeUpdate(query3);
		st.executeUpdate(query4);
		System.out.println("values are inserted successfully");

		String query5 = "select * from emp11";
		System.out.println("*****retriveing process******");
		ResultSet rs = st.executeQuery(query5);
		while (rs.next()) {
			System.out.println(rs.getInt("EID") + "----"
					+ rs.getString("ENAME") + "----" + rs.getDouble("ESAL"));
		}

		System.out.println("******updation process******");
		String query6 = "update emp11 set esal=esal+500 where esal>40000";
		int count = st.executeUpdate(query6);
		System.out.println("updated records----->" + count);
		System.out.println("table is updated successfully successfully");

		System.out.println("*************drop table **********");
		String query7 = "drop table emp11";
		st.executeUpdate(query7);
		System.out.println("table dropped successfully");

		con.close();

	}
}
