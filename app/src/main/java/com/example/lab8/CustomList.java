package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }


    /**
     * this gets size of the list
     * @return
     */
    public int getCount(){
        return cities.size();
    }

    /**
     * this adds a city object to the list
     *the second phase, you can add the city
     * @param city
     */
    public void addCity(City city){
        cities.add(city);
    }

    /**
     * this checks to see if a city is in the list
     * @param city
     */
    public boolean hasCity(City city){
        ArrayList<City> allCities = this.cities;
        int listSize = allCities.size();
        for (int i = 0; i < listSize; i++){
            City tempCity = allCities.get(i);
            if(tempCity.getCityName() == city.getCityName()){
                return true;
            }
        }
        return false;
    }

    /**
     * deletes a given city from cityList
     * @param city
     */
    public void deleteCity(City city){

        if (this.hasCity(city) != true){
            throw new IllegalArgumentException();
        }

        int size = this.getCount();

        for (int i = 0; i < size; i++){
            City tempCity = this.cities.get(i);
            if(tempCity.getCityName() == city.getCityName()){
                this.cities.remove(i);
                break;
            }
        }
    }

}
