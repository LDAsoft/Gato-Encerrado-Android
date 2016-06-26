package service;

import java.util.List;

import domain.Inventario;
import domain.Laberinto;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

public interface LaberintosService {
    @GET("laberintos/{idUsuario}")
    Call<List<Laberinto>> getLaberintos(@Path("idUsuario") String idUsuario);

    @GET ("detalleLaberinto/{idUsuario}/{idLaberinto}")
    Call<Laberinto> getDetalleLaberinto(@Path("idUsuario") String idUsuario,
                                        @Path("idLaberinto") String idLaberinto);

    @GET("inventario/{idUsuario}")
    Call<Inventario> getInventario(@Path("idUsuario") String idUsuario);

}
