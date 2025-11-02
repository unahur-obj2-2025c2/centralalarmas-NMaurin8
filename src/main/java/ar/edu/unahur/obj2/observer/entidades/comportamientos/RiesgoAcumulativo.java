package ar.edu.unahur.obj2.observer.entidades.comportamientos;

import ar.edu.unahur.obj2.observer.entidades.Entidad;

public class RiesgoAcumulativo implements Riesgo{

    @Override
    public Double riesgoActual(Entidad unaEntidad) {
        return unaEntidad.getAlertasRecibidas().stream().mapToDouble(alerta -> alerta.esCritica()?alerta.getNivel(): 0).sum();
    }

}
