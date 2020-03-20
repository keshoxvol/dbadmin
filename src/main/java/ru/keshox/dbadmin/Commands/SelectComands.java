package ru.keshox.dbadmin.Commands;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectComands {
	
	public static List getDatabases() throws SQLException {
		PreparedStatement stmt = ConnectionDb.ConnectDb().prepareStatement("select * from pg_database;");
		ResultSet rst = stmt.executeQuery();
		List<String> db = new ArrayList<String>();
		while(rst.next()) {
			db.add(rst.getString(1));
		}
		return db;
	}
	
	public static List getUsers() throws SQLException {
		PreparedStatement stmt = ConnectionDb.ConnectDb().prepareStatement("select * from pg_shadow;");
		ResultSet rst = stmt.executeQuery();
		List<String> users = new ArrayList<String>();
		while(rst.next()) {
			users.add(rst.getString(1));
		}
		return users;
	}
	
	public static List getTablesInDb() throws SQLException {
		PreparedStatement stmt = ConnectionDb.ConnectDb().prepareStatement("select table_name FROM information_schema.tables;");
		ResultSet rst = stmt.executeQuery();
		List<String> tables = new ArrayList<String>();
		while(rst.next()) {
			tables.add(rst.getString(1));
		}
		return tables;
	}
	
	public static List getNamesColumns(String table) throws SQLException {
		PreparedStatement stmt = ConnectionDb.ConnectDb().prepareStatement("select column_name from INFORMATION_SCHEMA.COLUMNS WHERE table_name = '" + table + "'");
		ResultSet rst = stmt.executeQuery();
		List<String> columns = new ArrayList<String>();
		while(rst.next()) {
			columns.add(rst.getString(1));
		}
		return columns;
	}
}
