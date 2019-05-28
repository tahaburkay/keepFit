package com.example.tabuto.keepfit.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;


import com.example.tabuto.keepfit.R;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private final AppCompatActivity activity = MainActivity.this;
    private ConstraintLayout constraintLayout;
    private LinearLayout linearLayout;

    private EditText editTextName;
    private EditText editTextEmail;
    private RadioGroup radioGroupGender;
    private EditText editTextAge;
    private EditText editTextHeight;
    private EditText editTextWeight;
    private EditText editTextPassword;
    private EditText editTextConfirmPassword;

    private Button girisMain;
    private Button kayitMain;
    EditText eMail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initListeners();

        Button button=(Button)findViewById(R.id.kayitOl);
        Button button1=(Button) findViewById(R.id.girisYap);

       /* button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,kayitOl.class  );
                MainActivity.this.startActivity(intent);
                overridePendingTransition(R.anim.anim_in, R.anim.anim_out);
                MainActivity.this.finish();

            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifyFromSQLite();
                MainActivity.this.finish();
            }
        });*/
    }
    private void initViews() {

        constraintLayout = (ConstraintLayout) findViewById(R.id.consrraintMain);

        linearLayout = (LinearLayout) findViewById(R.id.linearLayoutMain);


        editTextName = (EditText) findViewById(R.id.kullaniciadi);
        editTextPassword = (EditText) findViewById(R.id.parola);

        girisMain = (Button) findViewById(R.id.girisYap);

        kayitMain = (Button) findViewById(R.id.kayitOl);

    }

    /**
     * This method is to initialize listeners
     */
    private void initListeners() {
        girisMain.setOnClickListener(this);
        kayitMain.setOnClickListener(this);
    }

    /**
     * This method is to initialize objects to be used
     */

    /**
     * This implemented method is to listen the click on view
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.girisYap:
                break;
            case R.id.kayitOl:
                // Navigate to RegisterActivity
                Intent intentRegister = new Intent(MainActivity.this, AnaSayfa.class);
                startActivity(intentRegister);
                break;
        }
    }

    private void emptyInputEditText() {
        editTextName.setText(null);
        editTextPassword.setText(null);
    }
}
