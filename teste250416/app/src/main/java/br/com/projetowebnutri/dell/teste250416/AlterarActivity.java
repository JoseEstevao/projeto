package br.com.projetowebnutri.dell.teste250416;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AlterarActivity extends AppCompatActivity {

    LoginDataBaseAdapter loginDataBaseAdapter;

    EditText ednome, edsenha;
    Usuario usuario;
    Button salvar, deletar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar);

        loginDataBaseAdapter = new LoginDataBaseAdapter(this);
        loginDataBaseAdapter=loginDataBaseAdapter.open();

        Intent intent = getIntent();
        Bundle params = intent.getExtras();


        ednome =		(EditText) findViewById(R.id.editText);
        edsenha =		(EditText) findViewById(R.id.editText2);
        salvar =		(Button) findViewById(R.id.btnSalvar);
        deletar =		(Button) findViewById(R.id.btnDeletar);


        if (params != null) {
            String userName = params.getString("mensagem");
            usuario =  loginDataBaseAdapter.read(userName);
            ednome.setText(usuario.getNome() );
            edsenha.setText(usuario.getSenha());
            //setContentView(textView);
            // setContentView(textView2);

        }


        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ednome.equals("")||edsenha.equals("")){
                    Toast.makeText(getApplicationContext(), "Field Vaccant", Toast.LENGTH_LONG).show();
                    return;
                }else {


                    String userName = ednome.getText().toString();
                    String password = edsenha.getText().toString();
                    loginDataBaseAdapter.updateEntry(userName, password);
                    Intent voltar = new Intent(AlterarActivity.this, Welcome.class);
                    Bundle params = new Bundle();

                    params.putString("mensagem", userName);
                    voltar.putExtras(params);
                    startActivity(voltar);
                    Toast.makeText(getApplicationContext(), "Dados alterados", Toast.LENGTH_LONG).show();
                }
            }
        });

        deletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ednome.equals("")||edsenha.equals("")){
                    Toast.makeText(getApplicationContext(), "Field Vaccant", Toast.LENGTH_LONG).show();
                    return;
                }else {


                    String userName = ednome.getText().toString();
                   // String password = edsenha.getText().toString();
                    loginDataBaseAdapter.deleteEntry(userName);
                    Intent voltar = new Intent(AlterarActivity.this, MainActivity.class);
                    /*Bundle params = new Bundle();

                    params.putString("mensagem", userName);
                    voltar.putExtras(params);
                    */startActivity(voltar);
                    Toast.makeText(getApplicationContext(), "Usuario excluido", Toast.LENGTH_LONG).show();
                }
            }


        });
    }
}
