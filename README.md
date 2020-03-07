## Film Query Project

####  Overview

Film Query Project is a command-line application that uses Object Relational Mapping (ORM) with Java Database Connectivity to retrieve information from a database.

The application allows the user to search for a film by  _id_  or  _keywords_ . Each film in the database has a unique identifier or a primary key. This application looks for the unique key ( _primary key_ ) in the **Film Query Database** and returns attributes like :  _ title_ , _list of actors_ , _language_ , and other descriptions.

If the user inputs an id that has no corresponding value in the database, it will prompt a ** Does Not Exist** and will be prompted back to the main menu.

The user is able to search for movies via  _keywords_ . The database will return movies that has a similar  _keywords_  in their **title** or **descriptions**. If there are no matches it will print ** Does Not Exist** and will be prompted back to the main menu.



The image below displays a snapshot of the FilmQuery Database Schema.

<a href><img src="/Users/ankitshah/SD/Java/workspace/FilmQuery/src/com/skilldistillery/filmquery/ERD/ERD.png" align="center" height="500" width="500" ></a>


#### Concepts

I have 3 packages that does all of the work. There is the **database** package which consists of two classes  _DatabaseAccessor_  and  _DatabaseAccerObject_ .  _DatabaseAccessor_ is an interface and the  _DatabaseAccerObject_ is the class implementing the interface.         
   _DatabaseAccerObject_  is where all the Java Database Connectivity (JDBC) code is encapsulated. Each methods in this class connects to the database and executes a **prepared statement** from a string SQL query. This retrieved information from the database is then used to create either a **Film** or **Actor** object.
 
 The **Film** object also contains a list of actors because there are many actors in a film.
 
 The **app** package has the main app which prompts the user for their input.  
  
 The **entities** package has the **Film** and **Actor** class which has its own constructors, getters,setters, hash code and toString.

 
#### Technologies Used
* Java
* Maven
* MySQL
* MAMP
* Eclipse
* Git
* Object Oriented Programming (OOP)
* JUnit 5

#### Lessons Learned
* I learned the use of **Prepared Statement** instead of **Statement** to prevent the SQL injection vulnerabilities. For example, if we use **Statement** with a binder and use string concatenation it might change the SQL query, which is not what we want.
* I learned how to use  build tools like **Maven** and got introduced to  _xml_  files to work on dependencies.
* The biggest fun personally was to translate relational database information to Java Objects.



