package ar.edu.unahur.obj2.observer;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.observer.alertas.Alerta;
import ar.edu.unahur.obj2.observer.entidades.Entidad;

public class Central {
    private List<Entidad> entidades = new ArrayList<>();
    private List<Alerta> registroAlertas = new ArrayList<>();

    public void agregarEntidad(Entidad unaEntidad){
        entidades.add(unaEntidad);
    }

    public void eliminarEntidad(Entidad unaEntidad){
        entidades.remove(unaEntidad);
    }

    public void emitirAlerta(String tipo, Integer nivel){
        this.validarNivel(nivel);
        Alerta nuevaAlerta = new Alerta(tipo, nivel);
        registroAlertas.add(nuevaAlerta);
        entidades.forEach(entidad -> entidad.notificar(nuevaAlerta));

    }

    private void validarNivel(Integer nivel){
        if(nivel < 1 || nivel > 10){
            throw new ExcepcionNivelValido("Nivel de Alerta incorrecto");
        }
    }

    public Integer cantidadDeAlertasEnviadasAEntidades(){
        return registroAlertas.stream().mapToInt(alerta -> alerta.getEntidadesRecibidas().size()).sum();
    }

    
}
