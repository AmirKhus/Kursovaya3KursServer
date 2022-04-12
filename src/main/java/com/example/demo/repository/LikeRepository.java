package com.example.demo.repository;

import com.example.demo.entity.Like;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.ArrayList;

@Repository
public class LikeRepository implements IRestRepository<Like> {

    protected final JdbcOperations jdbcOperations;

    private static String selectQuery = "SELECT \"id\", \"userId\" , \"markerId\"  " +
            "FROM \"like\" " +
            "ORDER BY \"id\"";

    private static String selectByTypeOfEnvironmentalProblem = "SELECT \"id\", \"userId\" , \"markerId\"  " +
            "FROM \"like\" " +
            "WHERE \"id\" = ?";

    private static String selectByUserId= "SELECT \"id\", \"userId\" , \"markerId\"  " +
            "FROM \"like\" " +
            "WHERE \"userId\" = ?";

    private static String insertQuery = "INSERT INTO \"like\"(\"userId\" , \"markerId\" ) " +
            "VALUES (?,?) " +
            "RETURNING \"id\", \"userId\" , \"markerId\"  ";

    private static String updateQuery = "UPDATE \"like\" " +
            "SET \"userId\" = ?,\"markerId\" = ?" +
            "WHERE \"id\" = ? " +
            "RETURNING \"id\", \"userId\" , \"markerId\" ";

    private static String deleteQuery = "DELETE FROM \"like\" " +
            "WHERE \"id\" = ? " +
            "RETURNING \"id\", \"userId\" , \"markerId\"  ";

    public LikeRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public Like[] select() {
        ArrayList<Like> values = new ArrayList<Like>();
        SqlRowSet rowSet = jdbcOperations.queryForRowSet(selectQuery);
        while (rowSet.next()) {
            values.add(new Like(
                    rowSet.getInt(1),
                    rowSet.getInt(2),
                    rowSet.getInt(3)
            ));
        }
        Like[] result = new Like[values.size()];
        result = values.toArray(result);
        return result;
    }

    @Override
    public Like select(Integer id) {
        Object[] params = new Object[] { id };
        int[] types = new int[] {Types.INTEGER };
        SqlRowSet rowSet = jdbcOperations.queryForRowSet(selectByTypeOfEnvironmentalProblem, params, types);
        if (!rowSet.next()) {
            return null;
        }
        return new Like(
                rowSet.getInt(1),
                rowSet.getInt(2),
                rowSet.getInt(3)
        );
    }

    public Like[] selectByUserId(Integer region_id) {
        ArrayList<Like> values = new ArrayList<Like>();
        Object[] params = new Object[]{region_id};
        int[] types = new int[]{Types.INTEGER};
        SqlRowSet rowSet = jdbcOperations.queryForRowSet(selectByUserId, params, types);
        while (rowSet.next()) {
            values.add(new Like(
                    rowSet.getInt(1),
                    rowSet.getInt(2),
                    rowSet.getInt(3)
            ));
        }
        Like[] result = new Like[values.size()];
        result = values.toArray(result);
        return result;
    }

    @Override
    public Like insert(Like entity) {
        Object[] params = new Object[] { entity.getUserId(), entity.getMarkerId()};
        int[] types = new int[] { Types.INTEGER, Types.INTEGER};
        SqlRowSet rowSet = jdbcOperations.queryForRowSet(insertQuery, params, types);
        if (!rowSet.next()) {
            return null;
        }
        return new Like(
                rowSet.getInt(1),
                rowSet.getInt(2),
                rowSet.getInt(3)
        );
    }

    @Override
    public Like update(Integer id, Like entity) {
        Object[] params = new Object[] { entity.getUserId(), entity.getMarkerId(), id };
        int[] types = new int[] { Types.INTEGER, Types.INTEGER, Types.FLOAT };
        SqlRowSet rowSet = jdbcOperations.queryForRowSet(updateQuery, params, types);
        if (!rowSet.next()) {
            return null;
        }
        return new Like(
                rowSet.getInt(1),
                rowSet.getInt(2),
                rowSet.getInt(3)
        );
    }

    @Override
    public Like delete(Integer id) {
        Object[] params = new Object[] { id };
        int[] types = new int[] {Types.INTEGER };
        SqlRowSet rowSet = jdbcOperations.queryForRowSet(deleteQuery, params, types);
        if (!rowSet.next()) {
            return null;
        }
        return new Like(
                rowSet.getInt(1),
                rowSet.getInt(2),
                rowSet.getInt(3)
        );
    }
}
