package dao;

import org.apache.log4j.Logger;

public class DaoException extends RuntimeException {
    private static Logger logger = Logger.getLogger(DaoException.class);

    public DaoException(Throwable cause) {
        super(cause);
        logger.error(cause);
    }

    public DaoException(String message) {
        super(message);
        logger.error(message);
    }

    public DaoException(String message, Throwable cause) {
        super(message, cause);
        logger.error(message);
    }
}
