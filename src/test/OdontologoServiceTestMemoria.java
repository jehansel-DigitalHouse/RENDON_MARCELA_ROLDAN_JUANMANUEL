package test;

import dao.impl.DaoEnMemoria;

import model.Odontologo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.OdontologoService;


import static org.junit.jupiter.api.Assertions.assertNotNull;

class OdontologoServiceTestMemoria {
    OdontologoService odontologoService = new OdontologoService(new DaoEnMemoria());

    @Test
    @DisplayName("Testear que un odontologo fue cargado correctamente con su domicilio")
    void caso1(){
        //Dado
        Odontologo odontologo = new odontologo ("44444","Maria", "Perez");
        //cuando
        Odontologo odontologoDesdeDb = odontologoService.guardarOdontologo(odontologo);
        // entonces
        assertNotNull(odontologoDesdeDb.getId());
    }

    @Test
    @DisplayName("Testear que se listan correctamente los odontólogos")
    void caso2(){
        //Dado
        Odontologo odontologo1 = new Odontologo(1367, "Laura", "Lopez");
        Odontologo odontologo2 = new Odontologo(2689, "Juan", "Pérez");
        //cuando
        List<Odontologo> listaOdontologos = odontologoDAO.listarTodos();
        // entonces
        assertNotNull(listaOdontologos);
        assertEquals(2, listaOdontologos.size());
        assertTrue(listaOdontologos.contains(odontologo1));
        assertTrue(listaOdontologos.contains(odontologo2));
    }

}