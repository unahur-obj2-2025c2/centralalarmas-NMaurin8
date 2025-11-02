package ar.edu.unahur.obj2.observer.entidades;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.observer.alertas.Alerta;
import ar.edu.unahur.obj2.observer.entidades.comportamientos.*;

public class Entidad {
    private final String nombre;
    private List<Alerta> alertasRecibidas = new ArrayList<>();
    private Riesgo comportamiento = new RiesgoCritico();

    public Entidad(String nombre) {
        this.nombre = nombre;
    }

    public Entidad(String nombre, Riesgo comportamiento) {
        this.nombre = nombre;
        this.comportamiento = comportamiento;
    }

    public void notificar(Alerta unaAlerta) {
        alertasRecibidas.add(unaAlerta);
        unaAlerta.recibirEntidad(this);
    }

    

    public String getNombre() {
        return nombre;
    }

    public List<Alerta> getAlertasRecibidas() {
        return alertasRecibidas;
    }

    public Alerta ultimaAlerta() {
        return alertasRecibidas.get(alertasRecibidas.size()-1);
    }

    public Double calcularRiesgo(){
        return comportamiento.riesgoActual(this);
    }

    public void setComportamiento(Riesgo comportamiento) {
        this.comportamiento = comportamiento;
    }

    public Boolean contieneAlerta(String tipo){
        return alertasRecibidas.stream().anyMatch(alerta -> alerta.getTipo() == tipo);
    }

    
}
