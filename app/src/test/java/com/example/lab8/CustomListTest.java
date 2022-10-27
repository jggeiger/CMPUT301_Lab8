package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


public class CustomListTest {

    private CustomList list;

    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null, new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus
     one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    /**
     * create a list
     * check if hasCity returns false
     * create a city and place it in the list
     * check if hasCity returns true
     */
    @Test
    public void testHasCity(){
        list = MockCityList();
        City city = new City("Estevan", "SK");
        assertEquals(list.hasCity(city), false);
        list.addCity(city);
        assertEquals(list.hasCity(city), true);
    }

    /**
     * create list
     * try to delete city
     * add city to list
     * delete city
     * check if city deleted
     */
    @Test
    public void testDelete(){
        list = MockCityList();
        City city =  new City("Estevan", "SK");
        assertThrows(IllegalArgumentException.class, ()->{
                list.deleteCity(city); });
        list.addCity(city);
        list.deleteCity(city);
        assertEquals(list.getCount(), 0);
    }

    /**
     * create list
     * check size
     * add item
     * check size again
     */
    @Test
    public void testCount(){
        list = MockCityList();
        assertEquals(list.getCount(), 0);
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(), 1);
    }
}
