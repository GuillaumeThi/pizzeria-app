package fr.pizzeria.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Pizza;

public class PizzaDaoFichier implements IPizzaDao {

	private String dataDir;
	private Path path = Paths.get("C:/Users/ETY/Documents/pizzeria-app/pizzeria-console/data");

	public PizzaDaoFichier(String dataDir) {
		super();
		this.dataDir = dataDir;
	}

	@Override
	public List<Pizza> findAllPizzas() {
		try (Stream<Path> list = Files.list(Paths.get(dataDir))) {
			return list.map(path -> {

				String code = path.toFile().getName().replaceAll(".txt", "");

				try (Stream<String> lines = Files.lines(path)) {
					String[] values = lines	.findFirst()
											.orElseThrow(() -> new StockageException("fichier vide")).split(";");

					return new Pizza(code, values[0], Double.valueOf(values[1]));
				} catch (IOException e) {
					throw new StockageException(e);
				}
			}).collect(Collectors.toList());
		} catch (IOException e) {
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

		// creation nouveau fichier avec l'ecriture
		String phrase = pizza.getNom() + ";" + pizza.getPrix() + ";";
		byte data[] = phrase.getBytes();
		String strPath = this.path.toFile().getAbsolutePath() + "/" + pizza.getCode() + ".txt";
		Path path = Paths.get(strPath);

		try {

			// Ajouter du texte
			Files.write(path, data);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) {

		if (deletePizza(codePizza)) {
			saveNewPizza(pizza);
		} else {
			System.out.println("Erreur");
		}

		return true;
	}

	@Override
	public boolean deletePizza(String codePizza) {

		boolean ok = false;
		Path path = Paths.get(this.path.toString() + "/" + codePizza + ".txt");

		try {
			Files.delete(path);
			ok = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ok;
	}

}
