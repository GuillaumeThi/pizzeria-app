package fr.pizzeria.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Pizza;

public class PizzaDaoFichier implements IPizzaDao{
	
	private String dataDir;
	public static int id = 0;

	public PizzaDaoFichier(String dataDir)
	{
		super();
		this.dataDir = dataDir;
	}

	@Override
	public List<Pizza> findAllPizzas() {
		try
		{
			return Files.list(Paths.get(dataDir)).map(path -> {

			String code = path.toFile().getName().replaceAll(".txt", "");

			try
			{
				String[] values = Files.lines(path)
										.findFirst()
										.orElseThrow(() -> new StockageException("fichier vide"))
										.split(";");
					
				return new Pizza(code, values[0], Double.valueOf(values[1]));
			}
			catch (IOException e)
			{ 
				throw new StockageException(e);
			}
		 }).collect(Collectors.toList());
		}catch (IOException e)
		{
			throw new StockageException(e);
		}
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
	public boolean saveNewPizza(Pizza pizza) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePizza(String codePizza) {
		// TODO Auto-generated method stub
		return false;
	}

}
