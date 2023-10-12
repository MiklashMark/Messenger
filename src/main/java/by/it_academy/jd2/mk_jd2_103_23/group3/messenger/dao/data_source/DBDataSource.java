package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.dao.data_source;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBDataSource {

    private static ComboPooledDataSource ds;
    private static final Properties properties = new Properties();

    static {
        ds = new ComboPooledDataSource();

        try (InputStream input = DBDataSource.class.getResourceAsStream("/db.properties")) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ds.setDriverClass(properties.getProperty("db.driver"));
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }

        ds.setJdbcUrl(properties.getProperty("db.url"));
        ds.setUser(properties.getProperty("db.user"));
        ds.setPassword(properties.getProperty("db.password"));
    }
    public static DataSource getInstance(){
        return ds;
    }
}
