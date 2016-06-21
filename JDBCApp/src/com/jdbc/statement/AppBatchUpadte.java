package com.jdbc.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AppBatchUpadte {

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

		Statement st = con.createStatement();
		st.addBatch("create table emp11(eid number,ename varchar2(24),esal number)");
		st.addBatch("insert into emp11 values(111,'ratan',40000)");
		st.addBatch("insert into emp11 values(222,'ratan',50000)");
		st.addBatch("insert into emp11 values(333,'suneel',60000)");
		st.addBatch("update emp11 set esal=esal+500 where esal>40000");
		st.addBatch("drop table emp11");

		int[] a = st.executeBatch();

		for (int i : a) {
			System.out.println(a[i]);

		}
	}
}
