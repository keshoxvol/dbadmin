package ru.keshox.dbadmin.Commands;

import java.sql.SQLException;
import java.sql.Statement;

public class DropCommands {

	public static void deleteDb(String name) throws SQLException {
		Statement stmt = ConnectionDb.ConnectDb().createStatement();
		stmt.executeUpdate("drop database " + name + ";");
	}
	
	public static void deleteTable(String name) throws SQLException {
		Statement stmt = ConnectionDb.ConnectDb().createStatement();
		stmt.executeUpdate("drop table " + name + ";");
	}	
}
