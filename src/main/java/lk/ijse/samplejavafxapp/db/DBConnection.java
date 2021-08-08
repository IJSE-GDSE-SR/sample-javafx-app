/*
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) 2021 - present Sandul Renuja. All rights reserved.
 *  *  Licensed under the MIT License. See LICENSE in the project root for license information.
 *  *--------------------------------------------------------------------------------------------
 */

/*
 * @author Sandul Renuja <sandulrenuja@gmail.com>
 * @since  7/8/21
 */

package lk.ijse.samplejavafxapp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static DBConnection dbCon;
    private Connection con;

    private DBConnection() throws SQLException {
//      Class.forName("com.mysql.cj.jdbc.Driver");
        String username = "java_db_admin";
        String password = "java@123";
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample_javafx", username, password);

        if (con != null) {
            System.out.println("Successfully connected to MySQL DB : sample_javafx");
        }
    }

    public static DBConnection getInstance() throws SQLException, ClassNotFoundException {
        return (null == dbCon) ?
                (dbCon = new DBConnection()) :
                (dbCon);
    }

    public Connection getConnection() {
        return con;
    }
}
