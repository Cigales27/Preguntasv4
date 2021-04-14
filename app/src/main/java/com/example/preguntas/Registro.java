package com.example.preguntas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.preguntas.INTERFACES.PeticionUsuario;
import com.example.preguntas.MODELS.Usuarios;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Registro extends AppCompatActivity {
    private Button Registrar;
    private EditText Nombre, SecondName, UltimateName, Telephone, User, Account, Password, rePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        Registrar = (Button) findViewById(R.id.Registrar);

        Registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Nombre = (EditText) findViewById(R.id.RName);
                SecondName = (EditText) findViewById(R.id.RSecondName);
                UltimateName = (EditText) findViewById(R.id.RUltimateName);
                Telephone = (EditText) findViewById(R.id.RTelephone);
                User = (EditText) findViewById(R.id.RUser);
                Account = (EditText) findViewById(R.id.RAccount);
                Password = (EditText) findViewById(R.id.RPassword);
                rePassword = (EditText) findViewById(R.id.RrePassword);

                Retrofit retro = new Retrofit.Builder().baseUrl("https://t27.herokuapp.com/api/").addConverterFactory(GsonConverterFactory.create()).build();
                PeticionUsuario peticio = retro.create(PeticionUsuario.class);
                Call<Usuarios> call = peticio.crearUsuario(Nombre.getText().toString(),SecondName.getText().toString(),UltimateName.getText().toString(), Telephone.getText().toString(),Account.getText().toString(), User.getText().toString(), Password.getText().toString(), rePassword.getText().toString());
                call.enqueue(new Callback<Usuarios>() {
                    @Override
                    public void onResponse(Call<Usuarios> call, Response<Usuarios> response) {

                        if(response.isSuccessful())
                        {
                            Usuarios usuarios = response.body();
                            if (usuarios.estado)
                            {
                                Intent inicio = new Intent(Registro.this, Inicio.class);
                                startActivity(inicio);
                            }
                            Toast.makeText(Registro.this, usuarios.getDetalle()[0], Toast.LENGTH_LONG).show();

                        }
                    }

                    @Override
                    public void onFailure(Call<Usuarios> call, Throwable t) {
                        Toast.makeText(Registro.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}