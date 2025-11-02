package ar.edu.unahur.obj2.observer.entidades.comportamientos;

import ar.edu.unahur.obj2.observer.entidades.Entidad;

public class RiesgoCritico implements Riesgo {

    @Override
    public Double riesgoActual(Entidad unaEntidad) {
        return unaEntidad.ultimaAlerta().esCritica()?10.0:unaEntidad.ultimaAlerta().getNivel();
    }

}
