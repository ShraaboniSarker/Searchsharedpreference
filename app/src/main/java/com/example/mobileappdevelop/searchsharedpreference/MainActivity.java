package com.example.mobileappdevelop.searchsharedpreference;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private UserSearch userSearch;
    private ListView myList;
    private ArrayList<String> coutries;
    private ArrayAdapter adapter;
    private String name;
    private EditText showCountryTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userSearch= new UserSearch(this);
        myList = (ListView) findViewById(R.id.my_List);
        showCountryTV=(EditText) findViewById(R.id.countryET);
        coutries=new ArrayList<>();
        coutries.addAll(Arrays.asList(getResources().getStringArray(R.array.countries)));
        adapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,coutries);
        myList.setAdapter(adapter);
    }

    public void searched(View view){

        String country=name;
        userSearch.saveSearch(country);
    }
    public void showUser(View view) {

        /*showEmailTV.setText(userPreferece.getString("email","no such email found"));
        showPassTV.setText(userPreferece.getString("password","password was not set"));*/
        showCountryTV.setText(userSearch.getCountry());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search,menu);
        MenuItem menuItem=menu.findItem(R.id.menuSearch);
        SearchView searchView=(SearchView)menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                name=query;
                Toast.makeText(MainActivity.this, name , Toast.LENGTH_LONG).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}
    



