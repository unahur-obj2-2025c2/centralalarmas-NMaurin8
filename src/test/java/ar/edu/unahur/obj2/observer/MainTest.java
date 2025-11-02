package ar.edu.unahur.obj2.observer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.observer.entidades.Entidad;
import ar.edu.unahur.obj2.observer.entidades.comportamientos.RiesgoPromedio;

public class MainTest {
    Central central = new Central();

    Entidad e1 = new Entidad("Entidad 1");
    Entidad e2 = new Entidad("Entidad 2");
    
    @BeforeEach
    void setUp() {
        central.agregarEntidad(e1);
        central.agregarEntidad(e2);


    }

    @Test
    void dadoElSetUp_alAgregarAlertas_SeVerificaCorretamenteLasAlertasRecibidasYElRiesgo() {
        central.emitirAlerta("Calor", 6);
        central.emitirAlerta("Lluvia", 8);

        assertTrue(e1.contieneAlerta("Calor"));
        assertTrue(e2.contieneAlerta("Lluvia"));

        assertEquals(10.0, e1.calcularRiesgo() );
        assertEquals(10.0, e2.calcularRiesgo() );
    }

    @Test
    void dadoElSetUp_alCambiarElComportamientoYAgregarAlertas_SeVerificaCorretamenteLasAlertasRecibidasYElRiesgo(){
        e1.setComportamiento(new RiesgoPromedio());
        central.emitirAlerta("Calor", 6);
        central.emitirAlerta("Lluvia", 8);

        assertTrue(e1.contieneAlerta("Calor"));
        assertTrue(e2.contieneAlerta("Lluvia"));

        assertEquals(7.0, e1.calcularRiesgo());
        assertEquals(10.0, e2.calcularRiesgo());
    }

    @Test
    void dadoElSetUp_alAgregarAlertasQuitarUnaEntidadYAgregaNuevaAlerta_SeVerificaCorretamenteLasAlertasRecibidasYElRiesgo(){
        central.emitirAlerta("Calor",6);
        central.emitirAlerta("Lluvia",8);

        central.eliminarEntidad(e1);
        central.emitirAlerta("Granizo", 7);

        assertEquals(2, e1.getAlertasRecibidas().size());
        assertEquals(10.0, e1.calcularRiesgo());

        assertEquals(3, e2.getAlertasRecibidas().size());
        assertEquals(7.0, e2.calcularRiesgo());
        
        assertEquals(5, central.cantidadDeAlertasEnviadasAEntidades());
    }

    @Test
    void excepcion(){
        assertThrows(ExcepcionNivelValido.class, () -> {
            central.emitirAlerta("prueba", 11);
        });

        assertThrows(ExcepcionNivelValido.class, () -> {
            central.emitirAlerta("prueba", 0);
        });

        assertThrows(ExcepcionNivelValido.class, () -> {
            central.emitirAlerta("prueba", -1);
        });
    }


}
