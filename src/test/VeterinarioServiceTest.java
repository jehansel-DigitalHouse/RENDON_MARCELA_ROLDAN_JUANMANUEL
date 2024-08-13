package test;

import dao.impl.DaoH2Odontologo;
import model.Odontologo;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.VeterinarioService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VeterinarioServiceTest {
    private static final Logger logger = Logger.getLogger(VeterinarioServiceTest.class);
    private static VeterinarioService veterinarioService = new VeterinarioService(new DaoH2Odontologo());

    @BeforeAll
    static void crearTabla(){
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            connection =  DriverManager.getConnection("jdbc:h2:./BaseDatos/preexamen;INIT=RUNSCRIPT FROM 'create.sql'","sa","sa");
        }catch (Exception e){
            logger.error(e.getMessage());
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }
    }

    @Test
    @DisplayName("Testear que se agregue un veterinario de manera correcta")
    void caso1(){
        System.out.println("caso 1");
        //DADO
        Odontologo veterinario = new Odontologo("12345", "Juan","Roldan","Dentista");
        //CUANDO
        Odontologo veterinarioDesdeBD = veterinarioService.guardarVeterinario(veterinario);
        // entonces
        assertNotNull(veterinarioDesdeBD);
    }


    @Test
    @DisplayName("Testear que se listen todos los veterinarios")
    void caso2(){
        //DADO
        List<Odontologo> veterinarios;
        //CUANDO
        veterinarios = veterinarioService.buscarTodos();
        // entonces
        assertNotNull(veterinarios);
    }


}