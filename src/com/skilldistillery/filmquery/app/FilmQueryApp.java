package com.skilldistillery.filmquery.app;

import java.util.*;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {
  
  DatabaseAccessor db = new DatabaseAccessorObject();
  

  public static void main(String[] args) {
    FilmQueryApp app = new FilmQueryApp();
//    app.test();
    app.launch();
  }

//  private void test() {
//    Film film = db.findFilmById(1);
//    System.out.println(film);
///   
//    Actor actor =db.findActorById(2);
//    System.out.println(actor);
    
//    List<Actor> act = db.findActorsByFilmId(1);
//    System.out.println(act);
//    
//   
//	  List<Film> ab = db.findFilmByActorId(1);
//	  System.out.println(ab);
//	  
//	  List<Film> ab = db.findFilmByKeywords("Feminist");
//	  System.out.println(ab);
	  
//	  String a= db.getLanguageOfFilm(1);
//	  System.out.println(a);
//  }

  private void launch() {
    Scanner input = new Scanner(System.in);
    
    startUserInterface(input);
    
    input.close();
  }

  private void startUserInterface(Scanner input) {
	  boolean keepGoing = true;
	  while(keepGoing){
		  displayMainMenu();
		  int choice = input.nextInt();
		  switch(choice) {
		  case 1:
			  System.out.println("Enter the Film Id: ");
			  try {
				int filmId=input.nextInt();
				  Film film = db.findFilmById(filmId);
				  if (film !=null) {
					  System.out.println(film);
				  }else {
					  System.err.println("Does not exist");
				  }
			} catch (Exception e) {
				System.err.println("Invalid input");
				input.next();
				startUserInterface(input);
			}
			  break;
			  
		  case 2:
			  System.out.print("Enter your keywords: ");
			  try {
				String keywords=input.next();
				List<Film> filmList = db.findFilmByKeywords(keywords);
				  if(filmList.size() > 0) {
					  for(Film film :filmList) {
						  System.out.println(film);
					  }
				  }else {
					  System.err.println("Does not exist");
				  }
			} catch (Exception e) {
				System.err.println("Invalid input");
				input.next();
				startUserInterface(input);
			}
			  break;
		  case 3:
			  System.out.println("Thank You!");
			  keepGoing=false;
			  break;
			  
		  }
		  
		  
	  }
	  
	  
    
  }
  
  private void displayMainMenu() {
	  System.out.println();
	  System.out.println("Film Query App !!");
	  System.out.println("Choose between (1 - 3) ");
	  System.out.println("1) Look up film by id");
	  System.out.println("2) Look up film by keyword");
	  System.out.println("3) Quit");
	  System.out.print("Please choose: ");
  }

}
