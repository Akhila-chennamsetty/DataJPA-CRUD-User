package com.datajpa.DataJPA_User.repository;

import com.datajpa.DataJPA_User.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Integer>
{
    //using custom queries
    //retrieving all the user records using HQL query from the db
    @Query(value= "From User")
    public List<User> getAllUsersHql();
    /*retrieving all the user records using native query
    @Query(value="select * from user, nativeQuery=true")
    public List<User> getAllUsersSql();*/
    //retrieve user records who belongs to country India
    @Query(value= "From User where country =:cname")
    public List<User> getAllUsersByCountry(String cname);
    //retrieve user records who belongs to country India and age is 25
    @Query(value="From User where country= :cname and age=:age")
    public List<User> getAllUsersByCountryAndAge(String cname,Integer age);





    /*
    //-------using findBy() methods----------
    //retrieve user records who belong to India
    //select * from user where USER_COUNTRY ='INDIA'
    public List<User> findByCountry(String ucountry);
    //retrieve the user records who age is 30
    //select * from user where USER_AGE=30
    public List<User> findByAge(Integer uage);
    //retrieve the users whose age is greater than or equal to 30
    public List<User> findByAgeGreaterThanEqual(Integer uage);
    //retrieve the users who belongs to India and USA
    public List<User> findByCountryIn(List<String> countries);
    //retrieve the user records who belongs to India and age is 25
    public List<User> findByCountryAndAge(String country,Integer age);
    //retrive user records whose country is india, age is 25 and gender is male
    public List<User> findByCountryAndAgeAndGender(String country,Integer age,String geneder);

     */
}
