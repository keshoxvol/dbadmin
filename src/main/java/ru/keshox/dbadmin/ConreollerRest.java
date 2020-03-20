package ru.keshox.dbadmin;

import java.sql.SQLException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ru.keshox.dbadmin.Commands.SelectComands;

@RestController
public class ConreollerRest {
	
	@GetMapping("/databases")
	public Iterable<String> findDb() throws SQLException{		
		Iterable<String> db = SelectComands.getDatabases();
		return db;
	}
	
	@GetMapping("/users")
	public Iterable<String> findUsers() throws SQLException{		
		Iterable<String> users = SelectComands.getUsers();
		return users;
	}
	
	@GetMapping("/tables")
	public Iterable<String> findTables() throws SQLException{		
		Iterable<String> tables = SelectComands.getTablesInDb();
		return tables;
	}
	
	@GetMapping("/columns")
	public Iterable<String> findNamesColumn(@RequestParam(value = "table") String table) throws SQLException{
		Iterable<String> columns = SelectComands.getNamesColumns(table);
		return columns;
	}
}
