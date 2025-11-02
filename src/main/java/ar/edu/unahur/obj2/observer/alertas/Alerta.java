package ar.edu.unahur.obj2.observer.alertas;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.observer.entidades.Entidad;

public class Alerta {
    private String tipo;
    private Integer nivel;
    
    private List<Entidad> entidadesRecibidas = new ArrayList<>();

    public Alerta(String tipo, Integer nivel){
        this.tipo = tipo;
        this.nivel = nivel;
    }

    public Boolean esCritica(){
        return nivel >= 8;
    }

    public String getTipo() {
        return tipo;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void recibirEntidad(Entidad entidad) {
        entidadesRecibidas.add(entidad);
    }

    public List<Entidad> getEntidadesRecibidas() {
        return entidadesRecibidas;
    }

    

    
}
