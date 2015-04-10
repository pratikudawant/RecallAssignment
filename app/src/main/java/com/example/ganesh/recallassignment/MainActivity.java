package com.example.ganesh.recallassignment;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


public class MainActivity extends ActionBarActivity {


    String languagecheck = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Intent EnglishIntent = new Intent(this, EnglishActivity.class);
        final Intent FrenchIntent = new Intent(this, FrenchActivity.class);

        final Spinner dropdown = (Spinner) findViewById(R.id.spinner1);
        String[] items = new String[]{"", "English", "French"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items);
        dropdown.setAdapter(adapter);

        Button b1 = (Button) findViewById(R.id.button);


          b1.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
             if (dropdown.getSelectedItem().toString().equals("English")) {
                    languagecheck = "e";
                }
                if (dropdown.getSelectedItem().toString().equals("French")) {
                    languagecheck = "f";
                }
                if (languagecheck == "e") {
                    startActivity(EnglishIntent);
                }

                else if (languagecheck == "f") {
                    startActivity(FrenchIntent);

                }
            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.action_about) {

            ShowAbout();
            return true;
        }
        if (id == R.id.action_help){
            ShowHelp();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void ShowAbout() {

        setContentView(R.layout.about);

    }

    public void ShowHelp(){
        setContentView(R.layout.help);
    }

}
