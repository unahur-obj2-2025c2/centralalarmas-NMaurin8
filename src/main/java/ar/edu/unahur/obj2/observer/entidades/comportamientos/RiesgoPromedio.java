package ar.edu.unahur.obj2.observer.entidades.comportamientos;

import ar.edu.unahur.obj2.observer.entidades.Entidad;

public class RiesgoPromedio implements Riesgo {

    @Override
    public Double riesgoActual(Entidad unaEntidad) {
        return unaEntidad.getAlertasRecibidas().stream().mapToDouble(alerta -> alerta.getNivel()).average().orElse(0.0);
    }

}
