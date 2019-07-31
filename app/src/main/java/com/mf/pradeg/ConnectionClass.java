package com.mf.pradeg;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {
String ip,classs,db,un,password;

    @SuppressLint("NewApi")
    public Connection CONN(Context context) {
         ip = "remotemysql.com:3306";
         classs = "net.sourceforge.jtds.jdbc.Driver";
         db = "4vnWf0srgu";
         un = "4vnWf0srgu";
         password = "XPBurEnGvH";
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection conn = null;
        String ConnURL;
        try {
            Class.forName(classs);
            ConnURL = "jdbc:jtds:sqlserver://" + ip + ";"
                    + "databaseName=" + db + ";user=" + un + ";password="
                    + password + ";";
            conn = DriverManager.getConnection(ConnURL);
        }
        catch (SQLException se)
        {
            Log.e("sqlerror", se.getMessage());
            return null;
        }
        catch (ClassNotFoundException e) {
            return null;
        }
        catch (Exception e) {
            Log.e("error", e.getMessage());
            return null;
        }
        return conn;
    }
}