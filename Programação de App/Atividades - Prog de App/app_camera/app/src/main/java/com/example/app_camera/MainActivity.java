package com.example.app_camera;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity { // é a classe que todas as activities são extennsões, herança (extends)
    ImageView foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        foto = findViewById(R.id.iv);
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA)//Checando a permissão da camera
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA},0); // qual activity vai receber as permissões, array list
        }
    }

    public void tiraFoto(View view){
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i, 1);
        abrirCamera.launch(i);// código de requisição para tirar foto
        //quando tiver o resultado de tirar foto volta para a tela
    }
    public void pegaFoto(View v){
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        abrirGaleria.launch(i);
    }

    ActivityResultLauncher<Intent> abrirCamera = registerForActivityResult
            (new ActivityResultContracts.StartActivityForResult(), result -> {
                if(result.getResultCode() == Activity.RESULT_OK){
                    Intent data = result.getData();
                    Bundle dado = data.getExtras();//Bundle: classe para converter dados, fará com que o dado seja compatível com o format view
                    Bitmap imagem = (Bitmap) dado.get("data");//formato de imagem
                    foto.setImageBitmap(imagem);// mudar imagem para bitmap e colocar no image view
                }
            });
    ActivityResultLauncher<Intent> abrirGaleria = registerForActivityResult
            (new ActivityResultContracts.StartActivityForResult(), result ->{
                if(result.getResultCode() == Activity.RESULT_OK){
                    Intent data = result.getData();
                    Uri imagemSelecionada = data.getData();
                    String[] caminho = {MediaStore.Images.Media.DATA};
                    Cursor c = getContentResolver().query
                            (imagemSelecionada, caminho, null, null, null);
                    c.moveToFirst();
                    int coluna = c.getColumnIndex(caminho[0]);
                    String caminhoFisico = c.getString(coluna);
                    c.close();
                    Bitmap imagem = (BitmapFactory.decodeFile(caminhoFisico));
                    foto.setImageBitmap(imagem); //mudar imagem para bitmap e colocar no image view

                }
            });

}