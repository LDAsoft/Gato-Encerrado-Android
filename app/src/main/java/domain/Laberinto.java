package domain;

import java.io.Serializable;

/**
 * Created by B032679 on 22/06/2016.
 */
public class Laberinto implements Serializable {

    String nombre;
    String descripcion;
    Integer id;

    public Laberinto(){
    }

    public Integer getId() {return id;}

    public String getNombre() {
        return this.nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }
}
