package test;
import dao.impl.DaoEnMemoria;
import dao.impl.DaoH2Odontologo;
import model.Odontologo;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.OdontologoService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OdontologoServiceTestMemoria {
    private static final Logger logger = Logger.getLogger(OdontologoServiceTestMemoria.class);
    private static OdontologoService odontologoService = new OdontologoService(new DaoEnMemoria());

    @Test
    @DisplayName("Testear que un odontologo fue cargado correctamente")
    void caso1(){
        //Dado
        Odontologo odontologo = new Odontologo ("44444","Maria", "Perez");
        //cuando
        Odontologo odontologoDesdeMemoria = odontologoService.guardarOdontologo(odontologo);
        // entonces
        assertNotNull(odontologoDesdeMemoria.getId());
    }

    @Test
    @DisplayName("Testear que se listan correctamente los odontólogos")
    void caso2(){
        //Dado
        Odontologo odontologo1 = new Odontologo("1367", "Laura", "Lopez");
        Odontologo odontologo2 = new Odontologo("2689", "Juan", "Pérez");
        Odontologo odontologoDesdeMemoria1 = odontologoService.guardarOdontologo(odontologo1);
        Odontologo odontologoDesdeMemoria2 = odontologoService.guardarOdontologo(odontologo2);
        //cuando
        List<Odontologo> listaOdontologos = odontologoService.buscarTodos();
        // entonces
        assertNotNull(listaOdontologos);
    }

}