package dao.connection;

import dao.DaoException;

public class TransactionHelper {
    private static TransactionHelper instance = new TransactionHelper();

    private ConnectionPool pool = ConnectionPool.getInstance();
    private ThreadLocal<DaoConnection> local = new ThreadLocal<>();

    private TransactionHelper(){}

    public static TransactionHelper getInstance(){
        return instance;
    }

    public void beginTransaction() {
        DaoConnection connection = pool.getConnection();
        connection.setIsTransaction(true);
        local.set(connection);
    }

    public void commitTransaction() {
        DaoConnection connection = local.get();
        if (connection == null) {
            throw new DaoException("Can't commit transaction: it has not been begun");
        }
        connection.commit();
        endTransaction(connection);
    }

    public void rollbackTransaction() {
        DaoConnection connection = local.get();
        if (connection == null) {
            throw new DaoException("Can't rollback transaction: it has not been begun");
        }
        connection.rollback();
        endTransaction(connection);
    }

    public DaoConnection getConnection() {
        DaoConnection connection = local.get();
        if (connection == null) {
            connection = pool.getConnection();
        }
        return connection;
    }

    private void endTransaction(DaoConnection connection) {
        connection.setIsTransaction(false);
        connection.close();
        local.set(null);
    }
}
