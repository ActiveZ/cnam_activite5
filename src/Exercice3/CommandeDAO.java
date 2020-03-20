package Exercice3;

import java.sql.Connection;

public class CommandeDAO extends DAO<Commande> {


    public CommandeDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Commande obj) {
        return false;
    }

    @Override
    public boolean delete(Commande obj) {
        return false;
    }

    @Override
    public boolean update(Commande obj) {
        return false;
    }

    @Override
    public Commande find(int id) {
        return null;
    }
}
