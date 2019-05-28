package com.example.tabuto.keepfit.activities;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tabuto.keepfit.R;
import com.example.tabuto.keepfit.model.User;


public class ProfilUpdate extends AppCompatActivity implements View.OnClickListener {
    public EditText etName;
    public EditText etYas;
    public EditText etBoy;
    public EditText etKilo;
    public EditText etParola;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_update);
        Button geri = (Button)findViewById(R.id.geriU);
        Button guncelle = (Button)findViewById(R.id.btnUpdateProfile) ;
        guncelle.setOnClickListener(this);
        geri.setOnClickListener(this);
      /*  geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfilUpdate.this,AnaSayfa.class  );
                ProfilUpdate.this.startActivity(intent);
                overridePendingTransition(R.anim.anim_in, R.anim.anim_out);
                ProfilUpdate.this.finish();
            }
        });*/

       /*
        guncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(findViewById(R.id.constraintKayit), getString(R.string.success_message), Snackbar.LENGTH_LONG).show();
            }
        });*/
        initViews();


    }
    public void initViews() {
        etName =findViewById(R.id.nameU);
        etYas = findViewById(R.id.yasU);
        etBoy = findViewById(R.id.boyU);
        etKilo =findViewById(R.id.kiloU);
        etParola=findViewById(R.id.parolaU);

    }
    public void update(){

        User user = new User();
        user.setName(etName.getText().toString().trim());

        user.setYas(Integer.parseInt(etYas.getText().toString().trim()));
        user.setBoy(Double.parseDouble(etBoy.getText().toString().trim()));
        user.setKilo(Double.parseDouble(etKilo.getText().toString().trim()));
        user.setPassword(etParola.getText().toString().trim());

    }

    /**
     * This implemented method is to listen the click on view
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnUpdateProfile:
                update();
                Snackbar.make(findViewById(R.id.constraintKayit), getString(R.string.success_message), Snackbar.LENGTH_LONG).show();
                break;
            case R.id.geriU:
                // Navigate to RegisterActivity
                Intent intentRegister = new Intent(getApplicationContext(), ProfilActivity.class);
                startActivity(intentRegister);
                break;
        }
    }

}
