package br.com.projetowebnutri.dell.teste250416;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Welcome extends AppCompatActivity {

    LoginDataBaseAdapter loginDataBaseAdapter;

    TextView nome, senha;
    Button alterar;
    String userName;
    Usuario usuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        loginDataBaseAdapter = new LoginDataBaseAdapter(this);
        loginDataBaseAdapter = loginDataBaseAdapter.open();



        Intent intent = getIntent();
        Bundle params = intent.getExtras();
      //  TextView textView = new TextView(this);
        //TextView textView2 = new TextView(this);


        nome =		(TextView) findViewById(R.id.textView);
        senha =		(TextView) findViewById(R.id.textView2);
        alterar =		(Button) findViewById(R.id.btnAlterar);

        if (params != null) {
            String userName = params.getString("mensagem");
            usuario =  loginDataBaseAdapter.read(userName);
            nome.setText("Bem vindo " + usuario.getNome() + " ao aplicativo WebNutri");
            senha.setText("Sua senha: "+usuario.getSenha());
            //setContentView(textView);
           // setContentView(textView2);

        }

        alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String userName=nome.getText().toString();


                if (userName!="") {
                    Intent alterar = new Intent(Welcome.this, AlterarActivity.class);
                    Bundle params = new Bundle();

                    params.putString("mensagem", userName);
                    alterar.putExtras(params);
                    startActivity(alterar);
                }else{
                    Toast.makeText(Welcome.this, "User Name or Password does not match", Toast.LENGTH_LONG).show();
                }
            }
        });



    }



}





/*
        Bundle params = intent.getExtras();


        if (params != null) {
            String userName = params.getString("mensagem");
            String storedPassword = loginDataBaseAdapter.getSinlgeEntry(userName);

            textView.setText(storedPassword);
            setContentView(textView);
        }

        String userName = params.getString("mensagem");
*/