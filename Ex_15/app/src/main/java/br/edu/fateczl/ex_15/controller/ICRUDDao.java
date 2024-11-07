package br.edu.fateczl.ex_15.controller;

/*
@author<Gustavo da Silva Ignacio 111082313006>
*/

import java.sql.SQLException;
import java.util.List;

public interface ICRUDDao<T> {
    private void insert(T t) throws SQLException;
    private void update(T t) throws SQLException;
    private void delete(T t) throws SQLException;
    private void findOne(T t) throws SQLException;
    private List<T> findAll() throws SQLException;
}
