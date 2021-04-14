package com.example.preguntas.INTERFACES;

import com.example.preguntas.MODELS.Detalle;
import com.example.preguntas.MODELS.Obtener;
import com.example.preguntas.MODELS.Usuarios;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PeticionUsuario {
    @FormUrlEncoded
    @POST("iniciarSesionAppP")
    Call<Usuarios>InSess(@Field("correo") String Account, @Field("contrasennia") String Password);

    @FormUrlEncoded
    @POST("crearUsuarioAppP")
    Call<Usuarios>crearUsuario(@Field("nombre") String Name, @Field("apellido_pat") String Second_Name, @Field("apellido_mat") String LastName, @Field("telefono") String Telephone, @Field("correo") String Account, @Field("usuario") String User, @Field("contrasennia") String Password, @Field("rcontrasennia") String RePassword);

    @GET("preguntasAppP")
    Call<Obtener>accederPreguntas();
}
