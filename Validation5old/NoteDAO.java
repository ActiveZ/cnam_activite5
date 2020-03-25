package Validation5;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class NoteDAO extends DAO<Note> {
    private Statement st;

    public NoteDAO(Connection conn) {
        super(conn);
        try {
            st = conn.createStatement();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public boolean create(Note obj) {
        return false;
    }

    @Override
    public boolean delete(Note obj) {
        return false;
    }

    @Override
    public boolean update(Note obj) {
        return false;
    }

    @Override
    public Note find(int id) {
        return null;
    }


}
