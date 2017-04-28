package fr.pizzeria.dao;


public class DaoMemoireFactory implements DaoFactory {

	private IPizzaDao pizzaDao;
	
	
	public DaoMemoireFactory()
	{
		this.pizzaDao = new PizzaDaoMemoire();
	}

	@Override
	public IPizzaDao getPizzaDao() {
		// TODO Auto-generated method stub
		return this.pizzaDao ;
	}

}
