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

public class MainActivity extends AppCompatActivity {
    private Button InSession, registrar;
    private EditText Account, Password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InSession = (Button) findViewById(R.id.InSession);
        registrar = (Button) findViewById(R.id.changeRegistrar);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent vistaRegistrar = new Intent(view.getContext(), Registro.class);
                startActivity(vistaRegistrar);
            }
        });

        InSession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Account = (EditText) findViewById(R.id.InAccount);
                Password = (EditText) findViewById(R.id.InPassword);
                 String correo = Account.getText().toString();
                 String contrasenia = Password.getText().toString();

                Retrofit retrofit = new Retrofit.Builder().baseUrl("https://t27.herokuapp.com/api/").addConverterFactory(GsonConverterFactory.create()).build();

                PeticionUsuario PUsers = retrofit.create(PeticionUsuario.class);
                Call<Usuarios> call = PUsers.InSess(correo, contrasenia);
                call.enqueue(new Callback<Usuarios>() {
                    @Override
                    public void onResponse(Call<Usuarios> call, Response<Usuarios> response) {
                        if (response.isSuccessful())
                        {
                            Usuarios usuarios = response.body();
                            if (usuarios.estado)
                            {
                                Intent inicio = new Intent(MainActivity.this, Inicio.class);
                                startActivity(inicio);
                            }
                            Toast.makeText(MainActivity.this, usuarios.getDetalle()[0], Toast.LENGTH_LONG).show();

                        }

                    }

                    @Override
                    public void onFailure(Call<Usuarios> call, Throwable t) {
                        Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}