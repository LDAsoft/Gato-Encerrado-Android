package service;

import java.util.List;

import domain.Laberinto;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

public interface LaberintosService {
    @GET("laberintos/{idUsuario}")
    public Call<List<Laberinto>> getLaberintos(@Path("idUsuario") String idUsuario);


}
