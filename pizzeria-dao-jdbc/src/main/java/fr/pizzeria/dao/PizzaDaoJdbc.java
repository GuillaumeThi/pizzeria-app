package fr.pizzeria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.Pizza;


public class PizzaDaoJdbc implements IPizzaDao {
	
	
	static ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
	static Connection connection;
	static Statement statement;
	
	
	static {
		try {
			Class.forName(bundle.getString("jdbc.driver"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Override
	public List<Pizza> findAllPizzas() throws SQLException {
		
		List<Pizza> pizzas = new ArrayList<Pizza>();
		

		ResultSet result = getConnection().executeQuery("SELECT * FROM pizza");
		while(result.next())
		{
			Pizza pizza = new Pizza(result.getInt(1), result.getString(2), result.getString(3), result.getDouble(4));
			pizzas.add(pizza);
		}
		
		result.close();
		closeConnection();
		
		return pizzas;
	}

	@Override
	public Pizza findPizzaById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pizza findPizzaByCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pizza findPizzaByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) throws SQLException {
		
		getConnection().executeUpdate("INSERT INTO pizza(code, libelle, prix) VALUES('" + pizza.getCode() + "', '" + pizza.getNom() + "', " + pizza.getPrix() + ")");
		closeConnection();
		
		return false;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) throws SQLException {
		
		getConnection().executeUpdate("UPDATE pizza p SET code='" + pizza.getCode() + "', libelle='" + pizza.getNom() + "', prix =" + pizza.getPrix() + " WHERE p.code='" + codePizza + "'");
		closeConnection();

		return false;
	}

	@Override
	public boolean deletePizza(String codePizza) throws SQLException {
		
		getConnection().executeUpdate("DELETE FROM pizza WHERE code='" + codePizza + "'");
		closeConnection();
		
		return false;
	}
	
	public static Statement getConnection() throws SQLException
	{
		connection = DriverManager.getConnection(bundle.getString("jdbc.host"), bundle.getString("jdbc.user"), bundle.getString("jdbc.password"));
		statement = connection.createStatement();
		
		return statement;
	}
	
	public static boolean closeConnection() throws SQLException
	{
		statement.close();
		connection.close();
		
		return true;
	}
}
