package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.ArrayList;

@Repository
public class UserRepository implements IRestRepository<User> {

    protected final JdbcOperations jdbcOperations;

    private static String selectQuery = "SELECT \"id\", \"login\" , \"password\"  " +
            "FROM \"user\" " +
            "ORDER BY \"id\"";

    private static String selectByTypeOfEnvironmentalProblem = "SELECT \"id\", \"login\" , \"password\"  " +
            "FROM \"user\" " +
            "WHERE \"id\" = ?";

    private static String selectByLogin= "SELECT \"id\", \"login\" , \"password\"  " +
            "FROM \"user\" " +
            "WHERE \"login\" = ?";

    private static String insertQuery = "INSERT INTO \"user\"(\"login\" , \"password\" ) " +
            "VALUES (?,?) " +
            "RETURNING \"id\", \"login\" , \"password\"  ";

    private static String updateQuery = "UPDATE \"user\" " +
            "SET \"login\" = ?,\"password\" = ?" +
            "WHERE \"id\" = ? " +
            "RETURNING \"id\", \"login\" , \"password\" ";

    private static String deleteQuery = "DELETE FROM \"user\" " +
            "WHERE \"id\" = ? " +
            "RETURNING \"id\", \"login\" , \"password\"  ";

    public UserRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public User[] select() {
        ArrayList<User> values = new ArrayList<User>();
        SqlRowSet rowSet = jdbcOperations.queryForRowSet(selectQuery);
        while (rowSet.next()) {
            values.add(new User(
                    rowSet.getInt(1),
                    rowSet.getString(2),
                    rowSet.getString(3)
            ));
        }
        User[] result = new User[values.size()];
        result = values.toArray(result);
        return result;
    }

    @Override
    public User select(Integer id) {
        Object[] params = new Object[] { id };
        int[] types = new int[] {Types.INTEGER };
        SqlRowSet rowSet = jdbcOperations.queryForRowSet(selectByTypeOfEnvironmentalProblem, params, types);
        if (!rowSet.next()) {
            return null;
        }
        return new User(
                rowSet.getInt(1),
                rowSet.getString(2),
                rowSet.getString(3)
        );
    }

    public User[] selectByLogin(String region_id) {
        ArrayList<User> values = new ArrayList<User>();
        Object[] params = new Object[]{region_id};
        int[] types = new int[]{Types.VARCHAR};
        SqlRowSet rowSet = jdbcOperations.queryForRowSet(selectByLogin, params, types);
        while (rowSet.next()) {
            values.add(new User(
                    rowSet.getInt(1),
                    rowSet.getString(2),
                    rowSet.getString(3)
            ));
        }
        User[] result = new User[values.size()];
        result = values.toArray(result);
        return result;
    }

    @Override
    public User insert(User entity) {
        Object[] params = new Object[] { entity.getLogin(), entity.getPassword()};
        int[] types = new int[] { Types.VARCHAR, Types.VARCHAR};
        SqlRowSet rowSet = jdbcOperations.queryForRowSet(insertQuery, params, types);
        if (!rowSet.next()) {
            return null;
        }
        return new User(
                rowSet.getInt(1),
                rowSet.getString(2),
                rowSet.getString(3)
        );
    }

    @Override
    public User update(Integer id, User entity) {
        Object[] params = new Object[] { entity.getLogin(), entity.getPassword(), id };
        int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.FLOAT };
        SqlRowSet rowSet = jdbcOperations.queryForRowSet(updateQuery, params, types);
        if (!rowSet.next()) {
            return null;
        }
        return new User(
                rowSet.getInt(1),
                rowSet.getString(2),
                rowSet.getString(3)
        );
    }

    @Override
    public User delete(Integer id) {
        Object[] params = new Object[] { id };
        int[] types = new int[] {Types.INTEGER };
        SqlRowSet rowSet = jdbcOperations.queryForRowSet(deleteQuery, params, types);
        if (!rowSet.next()) {
            return null;
        }
        return new User(
                rowSet.getInt(1),
                rowSet.getString(2),
                rowSet.getString(3)
        );
    }
}
