package com.htcursos.sprinklesapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.htcursos.sprinklesapp.R;
import com.htcursos.sprinklesapp.models.User;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Virmerson on 31/07/15.
 */
public class RegisterUserActivity extends AppCompatActivity {


    public static final String USER_KEY ="user_key" ;
    @Bind(R.id.user_name)
    EditText userName;

    @Bind(R.id.user_email)
    EditText userEmail;

    @Bind(R.id.btn_back)
    Button btnBack;

    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
        ButterKnife.bind(this);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        //Acessar Extra para alterar
        if(getIntent().getExtras()!=null) {
            user= (User) getIntent().getExtras().getSerializable(USER_KEY);
            userName.setText(user.name);
            userEmail.setText(user.email);

        }
    }

    @OnClick(R.id.btn_save)
    public void registerNewUser(){

        if(TextUtils.isEmpty(userName.getText()) || TextUtils.isEmpty(userEmail.getText())) {
            Toast.makeText(this, "Preencha o nome e e-mail", Toast.LENGTH_SHORT).show();
        }else{
            if (user==null) {
                user = new User();
            }
            user.name = userName.getText().toString();
            user.email = userEmail.getText().toString();

            //Aqui vem o Sprikles
            user.save();
//            Toast.makeText(this, "Salvo com Sucesso", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

}
