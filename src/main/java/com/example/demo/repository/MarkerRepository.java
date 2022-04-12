package com.example.demo.repository;

import com.example.demo.entity.Marker;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.ArrayList;

@Repository
public class MarkerRepository implements IRestRepository<Marker> {

    protected final JdbcOperations jdbcOperations;

    private static String selectQuery = "SELECT \"id\", \"typeOfEnvironmentalProblem\" , \"description\" , \"dateOfPublication\", \"likeMarker\", \"dislikeMarker\", \"longitude\", \"latitude\", \"user_id\" " +
            "FROM \"marker\" " +
            "ORDER BY \"id\"";

    private static String selectByTypeOfEnvironmentalProblem = "SELECT \"id\", \"typeOfEnvironmentalProblem\" , \"description\" , \"dateOfPublication\", \"likeMarker\", \"dislikeMarker\", \"longitude\", \"latitude\", \"user_id\" " +
            "FROM \"marker\" " +
            "WHERE \"id\" = ?";

    private static String insertQuery = "INSERT INTO \"marker\"(\"typeOfEnvironmentalProblem\" , \"description\" , \"dateOfPublication\", \"likeMarker\", \"dislikeMarker\", \"longitude\", \"latitude\", \"user_id\") " +
            "VALUES (?,?,?,?,?,?,?,?) " +
            "RETURNING \"id\", \"typeOfEnvironmentalProblem\" , \"description\" , \"dateOfPublication\", \"likeMarker\", \"dislikeMarker\", \"longitude\", \"latitude\", \"user_id\" ";

    private static String updateQuery = "UPDATE \"marker\" " +
            "SET \"typeOfEnvironmentalProblem\" = ?, \"description\" = ?, \"dateOfPublication\" = ?, \"likeMarker\" = ?, \"dislikeMarker\" = ?, \"longitude\"=?, \"latitude\"=?, \"user_id\" =?" +
            "WHERE \"id\" = ? " +
            "RETURNING \"id\", \"typeOfEnvironmentalProblem\" , \"description\" , \"dateOfPublication\", \"likeMarker\", \"dislikeMarker\", \"longitude\", \"latitude\", \"user_id\"";

    private static String deleteQuery = "DELETE FROM \"marker\" " +
            "WHERE \"id\" = ? " +
            "RETURNING \"id\", \"typeOfEnvironmentalProblem\" , \"description\" , \"dateOfPublication\", \"likeMarker\", \"dislikeMarker\", \"longitude\", \"latitude\", \"user_id\" ";

    public MarkerRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public Marker[] select() {
        ArrayList<Marker> values = new ArrayList<Marker>();
        SqlRowSet rowSet = jdbcOperations.queryForRowSet(selectQuery);
        while (rowSet.next()) {
            values.add(new Marker(
                    rowSet.getInt(1),
                    rowSet.getString(2),
                    rowSet.getString(3),
                    rowSet.getDate(4),
                    rowSet.getInt(5),
                    rowSet.getInt(6),
                    rowSet.getFloat(7),
                    rowSet.getFloat(8),
                    rowSet.getInt(9)
            ));
        }
        Marker[] result = new Marker[values.size()];
        result = values.toArray(result);
        return result;
    }

    @Override
    public Marker select(Integer id) {
        Object[] params = new Object[] { id };
        int[] types = new int[] {Types.INTEGER };
        SqlRowSet rowSet = jdbcOperations.queryForRowSet(selectByTypeOfEnvironmentalProblem, params, types);
        if (!rowSet.next()) {
            return null;
        }
        return new Marker(
                rowSet.getInt(1),
                rowSet.getString(2),
                rowSet.getString(3),
                rowSet.getDate(4),
                rowSet.getInt(5),
                rowSet.getInt(6),
                rowSet.getFloat(7),
                rowSet.getFloat(8),
                rowSet.getInt(9)
        );
    }

    @Override
    public Marker insert(Marker entity) {
        Object[] params = new Object[] { entity.getTypeOfEnvironmentalProblem(), entity.getDescription(), entity.getDateOfPublication(), entity.getLikeMarker(), entity.getDislikeMarker(),entity.getLongitude(),entity.getLatitude(),entity.getUserId()};
        int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.DATE, Types.INTEGER, Types.INTEGER, Types.FLOAT, Types.FLOAT,Types.INTEGER };
        SqlRowSet rowSet = jdbcOperations.queryForRowSet(insertQuery, params, types);
        if (!rowSet.next()) {
            return null;
        }
        return new Marker(
                rowSet.getInt(1),
                rowSet.getString(2),
                rowSet.getString(3),
                rowSet.getDate(4),
                rowSet.getInt(5),
                rowSet.getInt(6),
                rowSet.getFloat(7),
                rowSet.getFloat(8),
                rowSet.getInt(9)
        );
    }

    @Override
    public Marker update(Integer id, Marker entity) {
        Object[] params = new Object[] { entity.getTypeOfEnvironmentalProblem(), entity.getDescription(), entity.getDateOfPublication(), entity.getLikeMarker(), entity.getDislikeMarker(),entity.getLongitude(),entity.getLatitude(),entity.getUserId(), id };
        int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.DATE, Types.INTEGER, Types.INTEGER,  Types.INTEGER, Types.FLOAT,Types.INTEGER, Types.FLOAT };
        SqlRowSet rowSet = jdbcOperations.queryForRowSet(updateQuery, params, types);
        if (!rowSet.next()) {
            return null;
        }
        return new Marker(
                rowSet.getInt(1),
                rowSet.getString(2),
                rowSet.getString(3),
                rowSet.getDate(4),
                rowSet.getInt(5),
                rowSet.getInt(6),
                rowSet.getFloat(7),
                rowSet.getFloat(8),
                rowSet.getInt(9)
        );
    }

    @Override
    public Marker delete(Integer id) {
        Object[] params = new Object[] { id };
        int[] types = new int[] {Types.INTEGER };
        SqlRowSet rowSet = jdbcOperations.queryForRowSet(deleteQuery, params, types);
        if (!rowSet.next()) {
            return null;
        }
        return new Marker(
                rowSet.getInt(1),
                rowSet.getString(2),
                rowSet.getString(3),
                rowSet.getDate(4),
                rowSet.getInt(5),
                rowSet.getInt(6),
                rowSet.getFloat(7),
                rowSet.getFloat(8),
                rowSet.getInt(9)
        );
    }
}
