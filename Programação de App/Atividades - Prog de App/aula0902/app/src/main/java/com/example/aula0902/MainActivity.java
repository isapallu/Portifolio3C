package com.example.aula0902;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText campo, login, senha;
    ArrayList<Usuario> listinha = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) { //Primeiro método da activity a ser executado
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();//Obter o banner com o título do app e escondê-lo
        campo = findViewById(R.id.nome); //Identifica o componente xml para realizar uma ação
        login = findViewById(R.id.login);
        senha = findViewById(R.id.senha);
        criaUsuario();// chamou o método
    }
    public void clicar(View ficarVisivel){
        String mensagem = "Olá, "+campo.getText()+", seja bem-vindo(a)!";
        Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();
    }
    public void logar(View v){
        String user = login.getText().toString();//string para armazenar em login
        String pass = senha.getText().toString();//string para armazenar em senha
        String mensagem = "Bem-vindo!";
        for(Usuario u:listinha){
            if(user.equals(u.getLogin()) && pass.equals(u.getSenha())){
                if(u.isAdmin()){
                    Intent i = new Intent(this, Admin.class);
                    startActivity(i);//Tela ADM
                } else{
                    Intent c = new Intent(this, Comum.class);
                    startActivity(c);//Tela comum
                }
                mensagem = "Bem-vindo!";
                break;
            }
            else{
                mensagem = "Login ou Senha incorreta!";
            }
        }
        Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();
        /*if(user.equals("admin") && pass.equals("admin")){ //duas condições '&&'
            //abrir a tela admin
            Intent i = new Intent(this, Admin.class);//Intenção de mudar de tela(Activity)
            startActivity(i);//Intenção de mudar de tela(Activity)
        }
        else if (user.equals("comum") && pass.equals("comum")){
            //abrir a tela comum
            Intent i = new Intent(this, Comum.class);//Intenção de mudar de tela(Activity)
            startActivity(i);//Intenção de mudar de tela(Activity)
        }
        else{
            Toast.makeText(this, "Usuário ou senha inválida!", Toast.LENGTH_LONG).show();
            //Se ficar vermelho a pessoa que escreveu, não é um componente do toast
        }*/
    }
    private void criaUsuario() {
        Usuario u1 = new Usuario("admin", "admin", true);
        Usuario u2 = new Usuario("palu", "1234", false);
        Usuario u3 = new Usuario("luca", "1234", false);
        Usuario u4 = new Usuario("mimi", "mimi", true);
        listinha.add(u1);
        listinha.add(u2);
        listinha.add(u3);
        listinha.add(u4);
    }
    public void cadastro(View v){
        Intent i = new Intent(this, Cadastro.class);
        startActivity(i);
        Cadastro.listinha = listinha; // Lista do cadastro vai receber a do activity
    }

}
