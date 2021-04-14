package com.example.preguntas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.preguntas.INTERFACES.PeticionUsuario;
import com.example.preguntas.MODELS.Obtener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Inicio extends AppCompatActivity {
    private TextView QuestionOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);


        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://t27.herokuapp.com/api/").addConverterFactory(GsonConverterFactory.create()).build();
        PeticionUsuario peticiones = retrofit.create(PeticionUsuario.class);
        Call<Obtener> call = peticiones.accederPreguntas();
        call.enqueue(new Callback<Obtener>() {
            @Override
            public void onResponse(Call<Obtener> call, Response<Obtener> response) {
                if (response.isSuccessful())
                {
                    String textCompleto = "";
                    Obtener listaPrguntas  = response.body();
                    for (int i = 0; i < 10; i++)
                    {
                        textCompleto += listaPrguntas.getDetalle().preguntas.get(i).texto + "\n";
                        textCompleto += listaPrguntas.getDetalle().preguntas.get(i).r1+"\n";
                        textCompleto += listaPrguntas.getDetalle().preguntas.get(i).r2+"\n";
                        textCompleto += listaPrguntas.getDetalle().preguntas.get(i).r3+"\n";
                        textCompleto += listaPrguntas.getDetalle().preguntas.get(i).r4+"\n";
                    }
                    QuestionOne = (TextView) findViewById(R.id.QuestionOne);
                    QuestionOne.setText(textCompleto);
                }
            }

            @Override
            public void onFailure(Call<Obtener> call, Throwable t) {
                Toast.makeText(Inicio.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        //loadDta();
    }

}