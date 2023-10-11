package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.dao.data_source;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.beans.PropertyVetoException;

public class DBDataSource {

    private static ComboPooledDataSource ds;

    static {
        ds = new ComboPooledDataSource();
            try {
                ds.setDriverClass("org.postgresql.Driver");
            } catch (PropertyVetoException e) {
                throw new IllegalStateException("error init driver base", e);
            }
            ds.setJdbcUrl("jdbc:postgresql://194.87.93.142:5432/messenger");
            ds.setUser("messenger_app");
            ds.setPassword("7Zgwn:pxE+x");
    }
    public static DataSource getInstance(){
        return ds;
    }
}
