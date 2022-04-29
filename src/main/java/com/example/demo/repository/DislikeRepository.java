package com.example.demo.repository;

import com.example.demo.entity.Dislike;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.ArrayList;

@Repository
public class DislikeRepository implements IRestRepository<Dislike> {

    protected final JdbcOperations jdbcOperations;

    private static String selectQuery = "SELECT \"id\", \"userId\" , \"markerId\"  " +
            "FROM \"dislike\" " +
            "ORDER BY \"id\"";

    private static String selectByTypeOfEnvironmentalProblem = "SELECT \"id\", \"userId\" , \"markerId\"  " +
            "FROM \"dislike\" " +
            "WHERE \"id\" = ?";

    private static String selectByUserId= "SELECT \"id\", \"userId\" , \"markerId\"  " +
            "FROM \"dislike\" " +
            "WHERE \"userId\" = ?";

    private static String selectByMarkerId= "SELECT \"id\", \"userId\" , \"markerId\"  " +
            "FROM \"dislike\" " +
            "WHERE \"markerId\" = ?";

    private static String insertQuery = "INSERT INTO \"dislike\"(\"userId\" , \"markerId\" ) " +
            "VALUES (?,?) " +
            "RETURNING \"id\", \"userId\" , \"markerId\"  ";

    private static String updateQuery = "UPDATE \"dislike\" " +
            "SET \"userId\" = ?,\"markerId\" = ?" +
            "WHERE \"id\" = ? " +
            "RETURNING \"id\", \"userId\" , \"markerId\" ";

    private static String deleteQuery = "DELETE FROM \"dislike\" " +
            "WHERE \"id\" = ? " +
            "RETURNING \"id\", \"userId\" , \"markerId\"  ";

    public DislikeRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public Dislike[] select() {
        ArrayList<Dislike> values = new ArrayList<Dislike>();
        SqlRowSet rowSet = jdbcOperations.queryForRowSet(selectQuery);
        while (rowSet.next()) {
            values.add(new Dislike(
                    rowSet.getInt(1),
                    rowSet.getInt(2),
                    rowSet.getInt(3)
            ));
        }
        Dislike[] result = new Dislike[values.size()];
        result = values.toArray(result);
        return result;
    }

    @Override
    public Dislike select(Integer id) {
        Object[] params = new Object[] { id };
        int[] types = new int[] {Types.INTEGER };
        SqlRowSet rowSet = jdbcOperations.queryForRowSet(selectByTypeOfEnvironmentalProblem, params, types);
        if (!rowSet.next()) {
            return null;
        }
        return new Dislike(
                rowSet.getInt(1),
                rowSet.getInt(2),
                rowSet.getInt(3)
        );
    }

    public Dislike[] selectByUserId(Integer region_id) {
        ArrayList<Dislike> values = new ArrayList<Dislike>();
        Object[] params = new Object[]{region_id};
        int[] types = new int[]{Types.INTEGER};
        SqlRowSet rowSet = jdbcOperations.queryForRowSet(selectByUserId, params, types);
        while (rowSet.next()) {
            values.add(new Dislike(
                    rowSet.getInt(1),
                    rowSet.getInt(2),
                    rowSet.getInt(3)
            ));
        }
        Dislike[] result = new Dislike[values.size()];
        result = values.toArray(result);
        return result;
    }

    public Dislike[] selectByMarkerId(Integer marker_id) {
        ArrayList<Dislike> values = new ArrayList<Dislike>();
        Object[] params = new Object[]{marker_id};
        int[] types = new int[]{Types.INTEGER};
        SqlRowSet rowSet = jdbcOperations.queryForRowSet(selectByMarkerId, params, types);
        while (rowSet.next()) {
            values.add(new Dislike(
                    rowSet.getInt(1),
                    rowSet.getInt(2),
                    rowSet.getInt(3)
            ));
        }
        Dislike[] result = new Dislike[values.size()];
        result = values.toArray(result);
        return result;
    }

    @Override
    public Dislike insert(Dislike entity) {
        Object[] params = new Object[] { entity.getUserId(), entity.getMarkerId()};
        int[] types = new int[] { Types.INTEGER, Types.INTEGER};
        SqlRowSet rowSet = jdbcOperations.queryForRowSet(insertQuery, params, types);
        if (!rowSet.next()) {
            return null;
        }
        return new Dislike(
                rowSet.getInt(1),
                rowSet.getInt(2),
                rowSet.getInt(3)
        );
    }

    @Override
    public Dislike update(Integer id, Dislike entity) {
        Object[] params = new Object[] { entity.getUserId(), entity.getMarkerId(), id };
        int[] types = new int[] { Types.INTEGER, Types.INTEGER, Types.FLOAT };
        SqlRowSet rowSet = jdbcOperations.queryForRowSet(updateQuery, params, types);
        if (!rowSet.next()) {
            return null;
        }
        return new Dislike(
                rowSet.getInt(1),
                rowSet.getInt(2),
                rowSet.getInt(3)
        );
    }

    @Override
    public Dislike delete(Integer id) {
        Object[] params = new Object[] { id };
        int[] types = new int[] {Types.INTEGER };
        SqlRowSet rowSet = jdbcOperations.queryForRowSet(deleteQuery, params, types);
        if (!rowSet.next()) {
            return null;
        }
        return new Dislike(
                rowSet.getInt(1),
                rowSet.getInt(2),
                rowSet.getInt(3)
        );
    }
}
