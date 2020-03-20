package Exercice3;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Xavier
 * @version 11/03/2020
 * DAO pour la classe TVA
 */
public class TVADAO extends DAO<TVA>{

    private Statement st;

    // ---------------------------------------
    // ---------- Constructeurs --------------
    // ---------------------------------------
    public TVADAO(Connection conn) {
        super(conn);
        try {
            st = conn.createStatement();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // ---------------------------------------
    // --------------- Méthodes --------------
    // ---------------------------------------

    @Override
    public boolean create(TVA obj) {
        boolean ok = true;
        String sql = "INSERT INTO TVA VALUES ("+obj.getId()+","+obj.getTaux()+")";
        try {
            // exécute la requête
            st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            ok = false;
        }
        return ok;
    }

    @Override
    public boolean delete(TVA obj) {
        boolean ok = true;
        String sql = "DELETE FROM TVA WHERE Id = "+obj.getId()+")";
        try {
            // exécute la requête
            st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            ok = false;
        }
        return ok;
    }

    @Override
    public boolean update(TVA obj) {
        boolean ok = true;
        String sql = "UPDATE TVA SET Taux = "+obj.getTaux()+" WHERE Id = "+obj.getId()+")";
        try {
            // exécute la requête
            st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            ok = false;
        }
        return ok;
    }

    @Override
    public TVA find(int id) {
        TVA tva = null;
        String sql = "SELECT * FROM TVA";
        try {
            // exécute la requête
            ResultSet rs = st.executeQuery(sql);
            // parcours des résultats
            if(rs.first())
                tva = new TVA(id, rs.getDouble("Taux"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tva;
    }


}
