package DAO;

import java.sql.ResultSet;

public interface IQuery {
    public ResultSet ExecuteQuery(String sqlQuery);
}
