package com.example.tabuto.keepfit.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.tabuto.keepfit.SQLite.DatabaseHelper;
import com.example.tabuto.keepfit.fragments.FragmentAntrenman;
import com.example.tabuto.keepfit.fragments.FragmentBeslenme;
import com.example.tabuto.keepfit.fragments.FragmentFitness;
import com.example.tabuto.keepfit.R;
import com.example.tabuto.keepfit.fragments.SectionsPageAdapter;

public class AnaSayfa extends AppCompatActivity implements NavigationView .OnNavigationItemSelectedListener{

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mActionBarDrawerToggle;

    SectionsPageAdapter sectionsPageAdapter;
    private ViewPager viewPager;
    private Toolbar mToolbar;
    private NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ana_sayfa);

        mDrawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigationView);
        mActionBarDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mActionBarDrawerToggle);
        mActionBarDrawerToggle.syncState();


        sectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
        viewPager = (ViewPager) findViewById(R.id.container);
        setupPager(viewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        mToolbar = findViewById(R.id.toolbar);
        mToolbar.setNavigationIcon(R.drawable.ic_menu_black_24dp);
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        navigationView.setNavigationItemSelectedListener(this);

        View navHeaderView = navigationView.getHeaderView(0);
        TextView avatarName = navHeaderView.findViewById(R.id.avatarName);
        Intent intent = getIntent();
        SharedPreferences pref = getSharedPreferences("MyPref",0);
        avatarName.setText(pref.getString("username",null));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mActionBarDrawerToggle.onOptionsItemSelected(item)) {

            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void setupPager(ViewPager viewPager){

        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentFitness(),"Fitness");
        adapter.addFragment(new FragmentAntrenman(),"Antrenman");
        adapter.addFragment(new FragmentBeslenme(),"Beslenme");
        viewPager.setAdapter(adapter);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent intent;
           switch (item.getItemId()) {
                case R.id.profil:
                    intent = new Intent(AnaSayfa.this, ProfilActivity.class);
                    finish();
                    startActivity(intent);
                    overridePendingTransition(R.anim.anim_in, R.anim.anim_out);
                    AnaSayfa.this.finish();
                    return true;
                case R.id.grafik:
                case R.id.talimatlar:
                case R.id.ayarlar:
                    intent = new Intent(AnaSayfa.this, MainActivity.class);
                    finish();
                    startActivity(intent);
                    overridePendingTransition(R.anim.anim_in, R.anim.anim_out);
                    AnaSayfa.this.finish();
                    return true;


                   default:
                    return false;
            }

    }
}
