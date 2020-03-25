package Validation5;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class EleveDAO extends DAO<Eleve> {
    private Statement st;

    public EleveDAO(Connection conn) {
        super(conn);
        try {
            st = conn.createStatement();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public boolean create(Eleve obj) {
        return false;
    }

    @Override
    public boolean delete(Eleve obj) {
        return false;
    }

    @Override
    public boolean update(Eleve obj) {
        return false;
    }

    @Override
    public Eleve find(int id) {
        return null;
    }


}
