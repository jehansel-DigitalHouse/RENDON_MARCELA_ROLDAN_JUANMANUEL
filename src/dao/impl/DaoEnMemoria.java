package dao.impl;

import dao.IDao;
import db.H2Connection;
import model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoEnMemoria implements IDao<Odontologo> {
    public static final Logger logger = Logger.getLogger(DaoEnMemoria.class);
    private List<Odontologo> odontologos = new ArrayList<>();
    @Override
    public Odontologo guardar(Odontologo odontologo) {
        odontologo.setId(odontologos.size()+1);
        odontologos.add(odontologo);
        logger.info("Odontologo guardado en memoria " + odontologo);
        return odontologo;
    }

    @Override
    public List<Odontologo> buscarTodos() {
        for(Odontologo odontologo : odontologos){
            logger.info("Odontologo en memoria: "+ odontologo);
        }

        return odontologos;
    }
}
