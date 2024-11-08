package br.edu.fateczl.ex_15.controller;

/*
@author<Gustavo da Silva Ignacio 111082313006>
*/

import java.sql.SQLException;
import java.util.List;

import br.edu.fateczl.ex_15.model.Jogador;
import br.edu.fateczl.ex_15.persistence.JogadorDao;

public class JogadorController implements ICRUDDao<Jogador> {

    private final JogadorDao jDao;

    public JogadorController(JogadorDao jDao) {
        this.jDao = jDao;
    }

    @Override
    public void insert(Jogador jogador) throws SQLException {
        if (jDao.open() == null) {
            jDao.open();
        }
        jDao.insert(jogador);
        jDao.close();

    }

    @Override
    public void modificar(Jogador jogador) throws SQLException {
        if (jDao.open() == null) {
            jDao.open();
        }
        jDao.update(jogador);
        jDao.close();
    }

    @Override
    public void delete(Jogador jogador) throws SQLException {
        jDao.open();
        try {
            jDao.delete(jogador);
        } finally {
            jDao.close();
        }
    }

    @Override
    public Jogador buscar(Jogador jogador) throws SQLException {
        jDao.open();
        try {
            return jDao.findOne(jogador);
        } finally {
            jDao.close();
        }
    }

    @Override
    public List<Jogador> listar() throws SQLException {
        if (jDao.open() == null) {
            jDao.open();
        }
        return jDao.findAll();
    }
}