package com.example.aula0902;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Cadastro extends AppCompatActivity {
    EditText novoLogin, novaSenha, confirmacao;
    static ArrayList<Usuario> listinha;// enviou a ArrayList para outra tela,
    //Static fez com que a lista fosse utilizada mesmo fora da classe dela

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        getSupportActionBar().hide();
        novoLogin = findViewById(R.id.nlogin);
        novaSenha = findViewById(R.id.nsenha);
        confirmacao = findViewById(R.id.confirmacao);
    }
    public void cadastrar(View v){
        String login = novoLogin.getText().toString();
        String senha = novaSenha.getText().toString();
        String conf = confirmacao.getText().toString();
        if(senha.equals(conf)){
            Usuario u = new Usuario(login, senha, false);
            listinha.add(u);
        } else{
            Toast.makeText(this, "As senhas não conferem!", Toast.LENGTH_SHORT).show();
        }
        // feito por Isadora Palú

    }
}