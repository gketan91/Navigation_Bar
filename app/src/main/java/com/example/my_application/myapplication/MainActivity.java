package com.example.my_application.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/*
* ######################################################################################################################################################
*
* NAVIGATION BAR
* ###################################################################################################################################################
* */
public class MainActivity extends AppCompatActivity {

    private  NavigationView n;
    DrawerLayout draw;
    EditText e1,e2,result;
    Toolbar tb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        draw = (DrawerLayout)findViewById(R.id.draw);
        tb = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(this,draw,tb,R.string.open,R.string.close);
        draw.addDrawerListener(toogle);
        toogle.syncState();




        n = (NavigationView) findViewById(R.id.navigation_1);
        View v= n.inflateHeaderView(R.layout.nav_header);
        n.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                UserMenuSelector(item);
                return false;

            }
        });



    }

    @Override
    public void onBackPressed() {
        if (draw.isDrawerOpen(GravityCompat.START))
        {
            draw.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    private void UserMenuSelector(MenuItem item) {
        switch (item.getItemId()){
            case R.id.m1:
                Toast.makeText(MainActivity.this,"Addition",Toast.LENGTH_SHORT).show();
                Intent n1= new Intent(this,Addition.class);
                startActivity(n1);
                break;
            case R.id.m2:
                Intent n2= new Intent(this,Substraction.class);
                startActivity(n2);
                Toast.makeText(MainActivity.this,"Substraction",Toast.LENGTH_SHORT).show();
                break;
            case R.id.m3:
                System.exit(1);
                Toast.makeText(MainActivity.this,"GET LOST",Toast.LENGTH_SHORT).show();
                break;

        }
        draw.closeDrawer(GravityCompat.START);
    }


}
