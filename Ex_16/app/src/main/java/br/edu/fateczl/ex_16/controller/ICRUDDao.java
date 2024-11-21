package br.edu.fateczl.ex_16.controller;

/*
@author:<Gustavo da Silva Ignácio 1110482313006>
*/
 
import java.sql.SQLException;
import java.util.List;

public interface ICRUDDao<T> {
    void insert(T t) throws SQLException;
    int update(T t) throws SQLException;
    void delete(T t) throws SQLException;
    T findOne(T t) throws SQLException;
    List<T> findAll() throws SQLException;
}
