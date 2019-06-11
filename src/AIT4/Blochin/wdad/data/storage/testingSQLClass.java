package AIT4.Blochin.wdad.data.storage;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;

import static AIT4.Blochin.wdad.data.storage.DataSourceFactory.createDataSource;

public class testingSQLClass {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {


        Connection conn = createDataSource();
        System.out.println("Get connection...");
        conn.close();
        System.out.println("Connection close");


    }

    }
