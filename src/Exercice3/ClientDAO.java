package Exercice3;

import java.sql.Connection;

public class ClientDAO extends DAO<Client> {


    public ClientDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Client obj) {
        return false;
    }

    @Override
    public boolean delete(Client obj) {
        return false;
    }

    @Override
    public boolean update(Client obj) {
        return false;
    }

    @Override
    public Client find(int id) {
        return null;
    }
}
