package ru.keshox.dbadmin;

import java.sql.SQLException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ru.keshox.dbadmin.Commands.ConnectionDb;
import ru.keshox.dbadmin.Commands.CreateCommands;
import ru.keshox.dbadmin.Commands.DropCommands;
import ru.keshox.dbadmin.Commands.SelectCommands;

@RestController
public class ConreollerRest {
	
//	@GetMapping("/connect")
//	public String connectDb(@RequestParam(value = "name") String name) throws SQLException{
//		ConnectionDb.ConnectDb()
//		return "Connected";
//	}
	
	@GetMapping("/databases")
	public Iterable<String> findDb() throws SQLException{		
		Iterable<String> db = SelectCommands.getDatabases();
		return db;
	}
	
	@GetMapping("/users")
	public Iterable<String> findUsers() throws SQLException{		
		Iterable<String> users = SelectCommands.getUsers();
		return users;
	}
	
	@GetMapping("/tables")
	public Iterable<String> findTables() throws SQLException{		
		Iterable<String> tables = SelectCommands.getTablesInDb();
		return tables;
	}
	
	@GetMapping("/columns")
	public Iterable<String> findNamesColumn(@RequestParam(value = "table") String table) throws SQLException{
		Iterable<String> columns = SelectCommands.getNamesColumns(table);
		return columns;
	}
	
	@PostMapping("/createdb")
	public String createDb(@RequestParam(value = "name") String name) throws SQLException {
		CreateCommands.createDb(name);
		return "[\"200 OK\"]";
	}
	
	@PostMapping("/deletedb")
	public String deleteDb(@RequestParam(value = "name") String name) throws SQLException {
		DropCommands.deleteDb(name);
		return "[\"200 OK\"]";
	}
	
	@PostMapping("/deletetable")
	public String deleteTable(@RequestParam(value = "name") String name) throws SQLException {
		DropCommands.deleteTable(name);
		return "[\"200 OK\"]";
	}
}
