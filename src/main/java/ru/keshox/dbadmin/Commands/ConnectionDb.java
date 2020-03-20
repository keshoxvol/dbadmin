package ru.keshox.dbadmin.Commands;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDb {
	public static Connection ConnectDb() {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:postgresql://localhost/persons", "kesh", "123");
		} catch(Exception e) {
			System.out.println("Conection KRASH" + e.getMessage());
		}
		return con;
	}
}
