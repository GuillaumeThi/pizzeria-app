package fr.pizzeria.dao;

public class DaoFichierFactory implements DaoFactory{

	//private static final String DATA_DIR = "C:/Users/ETY/Documents/pizzeria-app/pizzeria-console/data";
	private static final String DATA_DIR = "data";
	
	private IPizzaDao pizzaDao = new PizzaDaoFichier(DATA_DIR);

	@Override
	public IPizzaDao getPizzaDao() {
		// TODO Auto-generated method stub
		return pizzaDao;
	}

}
