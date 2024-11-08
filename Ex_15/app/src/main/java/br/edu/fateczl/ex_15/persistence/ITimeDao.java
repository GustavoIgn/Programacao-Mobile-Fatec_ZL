package br.edu.fateczl.ex_15.persistence;

/*
@author<Gustavo da Silva Ignacio 111082313006>
*/

import android.database.SQLException;

public interface ITimeDao {

    public TimeDao open() throws SQLException;

    public void close();
}
