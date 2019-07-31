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
         ip = "sql2.freesqldatabase.com:3306";
         classs = "com.mysql.jdbc.Driver";
         db = "sql2300441";
         un = "sql2300441";
         password = "jG1%xD9%";
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection conn = null;
        String ConnURL;
        try {
            Class.forName(classs);
            //ConnURL = ;
            conn = DriverManager.getConnection("jdbc:mysql://sql2.freesqldatabase.com:3306/sql2300441","sql2300441","jG1%xD9%");
        }
        catch (SQLException se)
        {
            Log.e("sqlerror", se.getMessage());
            return null;
        }
        catch (ClassNotFoundException e) {
            Log.e("ClassNotFoundException", e.getMessage());
            return null;
        }
        catch (Exception e) {
            Log.e("error", e.getMessage());
            return null;
        }

        return conn;
    }
}