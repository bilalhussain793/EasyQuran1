package com.example.quranproject;

//import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;
import android.support.v4.app.FragmentManager;

public class Navdrawer extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navdrawer);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }

        //Bottom Navbar COde Start here

        final BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);



        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                String menu=""+menuItem;

                if(menu.equals("Home")){

                    HomeFragment blankFragment=new HomeFragment();
                    // create a FragmentManager
                    FragmentManager fm = getSupportFragmentManager();
                    fm.beginTransaction()
                            .replace(R.id.fragment_container, blankFragment)
                            .commit();

                }if(menu.equals("Tutors")){


                    TutorsFragment blankFragment=new TutorsFragment();
                    // create a FragmentManager
                    FragmentManager fm = getSupportFragmentManager();
                    fm.beginTransaction()
                            .replace(R.id.fragment_container, blankFragment)
                            .commit();


                }if(menu.equals("Articles")){


                    Article blankFragment=new Article();
                    // create a FragmentManager
                    FragmentManager fm = getSupportFragmentManager();
                    fm.beginTransaction()
                            .replace(R.id.fragment_container, blankFragment)
                            .commit();


                }if(menu.equals("Accounts")){


                    TutorsFragment blankFragment=new TutorsFragment();
                    // create a FragmentManager
                    FragmentManager fm = getSupportFragmentManager();
                    fm.beginTransaction()
                            .replace(R.id.fragment_container, blankFragment)
                            .commit();


                }if(menu.equals("Settings")){


                    TutorsFragment blankFragment=new TutorsFragment();
                    // create a FragmentManager
                    FragmentManager fm = getSupportFragmentManager();
                    fm.beginTransaction()
                            .replace(R.id.fragment_container, blankFragment)
                            .commit();


                }


                return true;
            }
        });

    }

    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }



    }

    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new HomeFragment()).commit();
                break;

            case R.id.nav_subs:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new subscribe()).commit();
                break;

//            case R.id.nav_message:
////                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
////                        new Product_main()).commit();
////                break;
            case R.id.nav_mins:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new free_mins()).commit();
                break;
            case R.id.nav_referral:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new referral_code()).commit();
                break;

            case R.id.nav_reserve:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new freservation()).commit();
                break;

            case R.id.nav_stats:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new stats()).commit();
                break;

            case R.id.nav_history:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new chat_history()).commit();
                break;

            case R.id.nav_help:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Help()).commit();
                break;





            case R.id.nav_logout:
                Intent i = new Intent(Navdrawer.this, MainActivity.class);
                startActivity(i);
                finish();
                Toast.makeText(Navdrawer.this,"You have Successfully Logged Out!",Toast.LENGTH_SHORT).show();

                break;
        }

        drawer.closeDrawer(GravityCompat.START);


        return true ;
    }
}
