package ru.keshox.dbadmin.Commands;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateCommands {
	
	public static void createDb(String name) throws SQLException {
		Statement stmt = ConnectionDb.ConnectDb().createStatement();
		stmt.executeUpdate("create database " + name + ";");
	}
}
