package fr.pizzeria.console;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;

import fr.pizzeria.model.Pizza;

public class Test {
	
	public static final String PATH = "C:/Users/ETY/Documents/pizzeria-app/data/";

	public static void main(String[] args) {
//		try {
//			Files.createFile(FileSystems.getDefault().getPath(PATH + "test.txt"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//Nous déclarons nos objets en dehors du bloc try/catch
	    ObjectInputStream ois;
	    ObjectOutputStream oos;
	    try {
	      oos = new ObjectOutputStream(
	              new BufferedOutputStream(
	                new FileOutputStream(
	                  new File("pizza.txt"))));
	        	
	      //Nous allons écrire chaque objet Pizza dans le fichier
	      oos.writeObject(new Pizza("FRO", "Fromage", 12));
	      oos.writeObject(new Pizza("MAR", "Margarita", 14));
	      oos.writeObject(new Pizza("ORI", "Orientale", 13.5));
	      //Ne pas oublier de fermer le flux !
	      oos.close();
	        	
	      //On récupère maintenant les données !
	      ois = new ObjectInputStream(
	              new BufferedInputStream(
	                new FileInputStream(
	                  new File("pizza.txt"))));
	            
	      try {
	        System.out.println("Affichage des pizzas :");
	        System.out.println("*************************\n");
	        System.out.println(((Pizza)ois.readObject()).toString());
	        System.out.println(((Pizza)ois.readObject()).toString());
	        System.out.println(((Pizza)ois.readObject()).toString());
	      } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	      }
		
	      ois.close();
	        	
	    } catch (FileNotFoundException e) {
	      e.printStackTrace();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }

	}

}