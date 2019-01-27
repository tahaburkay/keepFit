package com.example.tabuto.keepfit.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tabuto.keepfit.Adaptor.UsersRecyclerAdapter;
import com.example.tabuto.keepfit.R;
import com.example.tabuto.keepfit.SQLite.DatabaseHelper;
import com.example.tabuto.keepfit.SQLite.InputValidation;
import com.example.tabuto.keepfit.model.User;

import java.util.List;

public class ProfilActivity extends AppCompatActivity implements View.OnClickListener{
    private AppCompatActivity activity = ProfilActivity.this;
    private RecyclerView recyclerViewUsers;
    private List<User> listUsers;
    private UsersRecyclerAdapter usersRecyclerAdapter;
    private DatabaseHelper databaseHelper;
    private User user;

    public AppCompatTextView tvName;
    public AppCompatTextView tvEmail;
    public AppCompatTextView tvCinsiyet;
    public AppCompatTextView tvYas;
    public AppCompatTextView tvBoy;
    public AppCompatTextView tvKilo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        Button geri = (Button)findViewById(R.id.geriP);
        Button guncelle = (Button)findViewById(R.id.profilGuncelle);
        geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfilActivity.this,AnaSayfa.class  );
                ProfilActivity.this.startActivity(intent);
                overridePendingTransition(R.anim.anim_in, R.anim.anim_out);
                ProfilActivity.this.finish();
            }
        });
        guncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfilActivity.this,ProfilUpdate.class  );
                ProfilActivity.this.startActivity(intent);
                overridePendingTransition(R.anim.anim_in, R.anim.anim_out);
                ProfilActivity.this.finish();
            }
        });
        SharedPreferences pref = getSharedPreferences("MyPref",0);
        initViews();
        DatabaseHelper dh = new DatabaseHelper(getApplicationContext());
        User user = dh.getUserInfo(pref.getString("username", null)); // getting Strin);

        tvEmail.setText(user.getEmail());
        tvName.setText(user.getName());
        tvCinsiyet.setText(user.getGender());
        tvYas.setText(Integer.toString(user.getYas()));
        tvBoy.setText(Double.toString(user.getBoy()));
        tvKilo.setText(Double.toString(user.getKilo()));
    }


        public void initViews() {

            tvEmail = (AppCompatTextView) findViewById(R.id.textViewEmail);
            tvName = (AppCompatTextView) findViewById(R.id.textViewName);
            tvCinsiyet = (AppCompatTextView) findViewById(R.id.textViewCinsyet);
            tvYas = (AppCompatTextView)findViewById(R.id.textViewYas);
            tvBoy = (AppCompatTextView)findViewById(R.id.textViewBoy);
            tvKilo = (AppCompatTextView)findViewById(R.id.textViewKilo);
        }


    @Override
    public void onClick(View v) {

    }

}
