package com.example.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_menu, menu);
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.listview){
            startActivity(new Intent(this, ListActivity.class));
        } else if (item.getItemId() == R.id.custom_listview) {
            startActivity(new Intent(this, CustomListActivity.class));
        } else if (item.getItemId() == R.id.register) {
            startActivity(new Intent(this, RegisterActivity.class));
        }
        return true;
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.listview:
                Toast.makeText(getApplicationContext(), "ListView",
                        Toast.LENGTH_SHORT).show();
                break;

            case R.id.custom_listview:
                Toast.makeText(getApplicationContext(), "Custom ListView",
                        Toast.LENGTH_SHORT).show();
                break;

            case R.id.register:
                Toast.makeText(getApplicationContext(), "Register",
                        Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }

    public void sendMessage(View view)
    {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editTextTextPersonName);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void showList(View view)
    {
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }

    public void showCustomList(View view)
    {
        Intent intent = new Intent(this, CustomListActivity.class);
        startActivity(intent);
    }

    public void showFormRegister(View view){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}