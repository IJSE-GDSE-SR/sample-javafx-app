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

    private DBConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc://mysql://localhost:3306/sample_javafx", "java_db_admin", "java@123");
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
