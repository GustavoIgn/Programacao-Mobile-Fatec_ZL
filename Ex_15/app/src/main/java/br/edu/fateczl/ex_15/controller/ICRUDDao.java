package br.edu.fateczl.ex_15.controller;

/*
@author<Gustavo da Silva Ignacio 111082313006>
*/

import java.sql.SQLException;
import java.util.List;

import br.edu.fateczl.ex_15.model.Time;

public interface ICRUDDao<T> {

    public void insert(T t) throws SQLException;

    public void modificar(T t) throws SQLException;

    public void delete(T t) throws SQLException;

    public T buscar(T t) throws SQLException;

    public List<T> listar() throws SQLException;
}
