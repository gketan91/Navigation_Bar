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
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Addition extends AppCompatActivity {
    EditText e1,e2,result;
    private  NavigationView n;
    private DrawerLayout draw;
    Toolbar tb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition);
        n = (NavigationView) findViewById(R.id.navigation_1);
        draw = (DrawerLayout)findViewById(R.id.draw);
        tb = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(tb);

        ActionBarDrawerToggle toogel = new ActionBarDrawerToggle(this,draw,tb,R.string.open,R.string.close);
        draw.addDrawerListener(toogel);
        toogel.syncState();

        View v= n.inflateHeaderView(R.layout.nav_header);
        n.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                UserMenuSelector(item);
                return false;
            }
        });

    }

    public void OnDisplay(View view) {
        e1 = (EditText) findViewById(R.id.e1);
        e2 = (EditText) findViewById(R.id.e2);
        String m1= e1.getText().toString();
        String m2= e2.getText().toString();
        int f1 = Integer.parseInt(m1);
        int f2 = Integer.parseInt(m2);
        int f3 = f1+f2;
        result = (EditText) findViewById(R.id.er);
        result.setText("Addition is :"+String.valueOf(f3));
        Toast.makeText(this,"Addition is:"+(f1+f2),Toast.LENGTH_LONG).show();
    }

    public void OnReset(View view) {
        e1 = (EditText) findViewById(R.id.e1);
        e2 = (EditText) findViewById(R.id.e2);
        result = (EditText) findViewById(R.id.er);
        e1.setText("");
        e2.setText("");
        result.setText("");
        Toast.makeText(this,"RESET",Toast.LENGTH_LONG).show();
    }
    private void UserMenuSelector(MenuItem item) {
        switch (item.getItemId()){
            case R.id.m1:
                Toast.makeText(this,"Addition",Toast.LENGTH_SHORT).show();
                Intent n1= new Intent(this,Addition.class);
                startActivity(n1);
                break;
            case R.id.m2:
                Intent n2= new Intent(this,Substraction.class);
                startActivity(n2);
                Toast.makeText(this,"Substraction",Toast.LENGTH_SHORT).show();
                break;
            case R.id.m3:
                System.exit(1);
                Toast.makeText(this,"GET LOST",Toast.LENGTH_SHORT).show();
                break;

        }
        draw.closeDrawer(GravityCompat.START);
    }
    public void onBackPressed() {
        if (draw.isDrawerOpen(GravityCompat.START))
        {
            draw.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }
}
