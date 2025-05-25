package com.datajpa.DataJPA_User;

import com.datajpa.DataJPA_User.model.User;
import com.datajpa.DataJPA_User.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class DataJpaUserApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context =SpringApplication.run(DataJpaUserApplication.class, args);
		UserRepository repo = context.getBean(UserRepository.class);
		//retrieving all the user records using HQL query from the db
	     List<User> getallusershql = repo.getAllUsersHql();
		 getallusershql.forEach(System.out::println);
		/*retrieving all the user records using native query
		List<User> getalluserssql =repo.getAllUsersSql();
        getalluserssql.forEach(System.out::println);*/
		//retrieve user records who belongs to country India
		List<User> getallusersbycountry =repo.getAllUsersByCountry("India");
		getallusersbycountry.forEach(System.out::println);
		//retrieve user records who belongs to country India and age is 25
		List<User> getallusersbycountryandage =repo.getAllUsersByCountryAndAge("India",25);
        getallusersbycountryandage.forEach(System.out::println);





		/* ------Using findBy() methods performing db operations-------
		//method -1 System.out.println(repo.findByCountry("India"));
		//method -2 retrieve user records who belong to India (using for Each)
		List<User> findbycountry = repo.findByCountry("India");
		findbycountry.forEach(System.out::println);
		//retrieve the user records who age is 30
		List<User> findbyage =repo.findByAge(30);
		findbyage.forEach(System.out::println);
		//retrieve the users whose age is greater than or equal to 30
		List<User> findbyagegreaterthanorequal =repo.findByAgeGreaterThanEqual(30);
		findbyagegreaterthanorequal.forEach(System.out::println);
		//retrieve the users who belongs to India and USA
		List<User> findbycountryin =repo.findByCountryIn(Arrays.asList("India","USA")); //when u want to supply more than one value for single column then we go for IN clause
		findbycountryin.forEach(System.out::println);
		//retrieve the user records who belongs to India and age is 25
		List<User> findbycountryandage =repo.findByCountryAndAge("India",25); //if u want to retrieve data from two columns then we use AND operator
        findbycountryandage.forEach(System.out::println);
        //retrive user records whose country is india, age is 25 and gender is male
		List<User> findbycountryagegender =repo.findByCountryAndAgeAndGender("India",25,"Male");
		findbycountryagegender.forEach(System.out::println);
    */
/*     --------using Predefined methods to perfom CRUD operations
		//System.out.println(repo.getClass().getName());
		//intializing values to user Object through setter method
		User u1 = new User();
		u1.setId(101);
		u1.setName("John");
		u1.setGender("Male");
		u1.setCountry("India");
		u1.setAge(20);
		//creating single user data into db
		repo.save(u1);
		//intializing values to user object through constructor
		User u2 = new User(102,"Smith","Male","India",25);
		User u3 = new User(103,"Robert","Male","USA",30);
		User u4 = new User(104,"Michel","Male","Canada",35);
		//adding the User objects into list using Arrays.asList()
		List<User> users =Arrays.asList(u2,u3,u4);
		repo.saveAll(users);//creating multiple user data into db
		//printing the users in the console using foreach and lambda expression
		users.forEach(user -> {
			System.out.println(user);
		});
		//System.out.println(users);
		//retrieving single record based on the primary key of the table
		System.out.println("--------Retrieving single record by primary key from the db------");
		Optional<User> user =repo.findById(101);
		if(user.isPresent())
		{
			System.out.println(user.get());
		}
		else
		{
			System.out.println("user not found...");
		}
		System.out.println("--------Retrieving multiple record by primary key from the db------");

		 Iterable<User> userslist =repo.findAllById(Arrays.asList(102,103,104));
		 userslist.forEach(userls -> {
			 System.out.println(userls);
		 });

		System.out.println("-------retrieve all the records from the db----- ");

		Iterable<User> allusers = repo.findAll();
		allusers.forEach(finduser -> {
			System.out.println(finduser);
		});

		System.out.println("-------retrieve total number of records from the db------");
		long countusers =repo.count();
		System.out.println("Total no of records in the table: "+ countusers);

		System.out.println("------checking if the record is available or not based on Id(primary key) in the db------");
		boolean existsById= repo.existsById(103);
		System.out.println("record presence with given id: "+ existsById);
        */
	}

}
