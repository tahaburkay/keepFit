package com.example.tabuto.keepfit.activities;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


import com.example.tabuto.keepfit.R;

import com.example.tabuto.keepfit.model.User;


public class kayitOl extends Activity implements View.OnClickListener {
    String value;
    private final Activity activity = kayitOl.this;

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

    private Button buttonKayitOl;
    private AppCompatTextView appCompatTextViewLoginLink;


    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit_ol);


        Button kayitOl=(Button)findViewById(R.id.kayitOlundu);
        Button geri = (Button)findViewById(R.id.geri);
        kayitOl.setOnClickListener(this);
        geri.setOnClickListener(this);


        /*kayitOl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(kayitOl.this,MainActivity.class  );
                kayitOl.this.startActivity(intent);
                overridePendingTransition(R.anim.anim_in, R.anim.anim_out);
                kayitOl.this.finish();

            }

        });*/

        /*
*/
        /*geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(kayitOl.this,MainActivity.class  );
                kayitOl.this.startActivity(intent);
                overridePendingTransition(R.anim.anim_in, R.anim.anim_out);
                kayitOl.this.finish();
            }
        });*/

        initViews();
        initListeners();

          value = ((RadioButton)findViewById(radioGroupGender.getCheckedRadioButtonId())).getText().toString();
        radioGroupGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                value = ((RadioButton)findViewById(radioGroupGender.getCheckedRadioButtonId())).getText().toString();
                Toast.makeText(activity, value, Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void initViews() {

        linearLayout = (LinearLayout) findViewById(R.id.linearLayoutKayit);

        editTextEmail = (EditText) findViewById(R.id.eMail);
        editTextName = (EditText) findViewById(R.id.kullaniciAdiGiriniz);
        radioGroupGender = (RadioGroup) findViewById(R.id.cinsiyet);
        editTextAge = (EditText) findViewById(R.id.yas);
        editTextHeight = (EditText) findViewById(R.id.boy);
        editTextWeight = (EditText) findViewById(R.id.kilo);
        editTextPassword = (EditText) findViewById(R.id.parola);
        editTextConfirmPassword = (EditText) findViewById(R.id.parolaT);
        buttonKayitOl  = (Button) findViewById(R.id.kayitOlundu);
    }

    /**
     * This method is to initialize listeners
     */
    private void initListeners() {
        buttonKayitOl.setOnClickListener(this);
    }

    /**
     * This method is to initialize objects to be used
     */



    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.kayitOlundu:
                break;

            case R.id.geri:
                Intent intent = new Intent(kayitOl.this,MainActivity.class  );
                kayitOl.this.startActivity(intent);
                overridePendingTransition(R.anim.anim_in, R.anim.anim_out);
                kayitOl.this.finish();
                break;
        }
    }

    private void emptyInputEditText() {
        editTextName.setText(null);
        editTextEmail.setText(null);
        editTextAge.setText(null);
        editTextHeight.setText(null);
        editTextWeight.setText(null);
        editTextPassword.setText(null);
        editTextConfirmPassword.setText(null);
    }
}



