package Validation5.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class MatiereDAO extends DAO<Matiere> {
    private Statement st;

    public MatiereDAO (Connection conn) {
        super(conn);
        try {
            st = conn.createStatement();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public boolean create(Matiere obj) {
        return false;
    }

    @Override
    public boolean delete(Matiere obj) {
        return false;
    }

    @Override
    public boolean update(Matiere obj) {
        return false;
    }

    @Override
    public Matiere find(int id) {
        return null;
    }


}
