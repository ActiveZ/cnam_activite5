package Exercice3;

import java.sql.Connection;

public class CatalogueDAO extends DAO<Catalogue> {


    public CatalogueDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Catalogue obj) {
        return false;
    }

    @Override
    public boolean delete(Catalogue obj) {
        return false;
    }

    @Override
    public boolean update(Catalogue obj) {
        return false;
    }

    @Override
    public Catalogue find(int id) {
        return null;
    }
}
