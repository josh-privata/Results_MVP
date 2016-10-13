/*
 * Copyright (c) 2016, josh
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package results;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author josh
 */
public class InitiateDatabase {

    // Database Variables
    private String service = "jdbc:derby:";
    private String location = "//localhost:1527/";
    private String database = "results";
    private String create = "true";
    private String url = service + location + database + ";create=" + create;
    private String user = "josh";
    private String password = "josh";

    // Global Variables
    private Statement statement;
    private final String droptable = "DROP TABLE MARKS";
    private final String createtable = "CREATE TABLE MARKS ("
            + "STUDENTID VARCHAR (8) NOT NULL,"
            + "ASSIGNMENT1 INT NOT NULL,"
            + "ASSIGNMENT2 INT NOT NULL,"
            + "EXAM INT NOT NULL,"
            + "TOTAL INT NOT NULL,"
            + "GRADE VARCHAR (4) NOT NULL,"
            + "PRIMARY KEY (STUDENTID))";
    private final String insertdata = "INSERT INTO MARKS"
            + "(STUDENTID,ASSIGNMENT1,ASSIGNMENT2,EXAM,TOTAL,GRADE)"
            + "VALUES"
            + "('S01',20,0,25,45,'?'),"
            + "('S02',0,0,0,0,'?'),"
            + "('S03',15,0,0,15,'?'),"
            + "('S04',15,15,19,49,'?'),"
            + "('S05',25,20,39,84,'?'),"
            + "('S06',0,0,45,45,'?'), "
            + "('S07',25,24,0,50,'?'),"
            + "('S08',20,20,25,65,'?'),"
            + "('S09',20,20,24,64,'?'),"
            + "('S10',17,19,39,75,'?')";
    Connection con;

    // Constructor initiates database, drops existing tables, creates new table and fills with data
    public InitiateDatabase() {
        System.out.println("[+] Initialising the Marks Management System Database\n");
        System.out.println("[+] Attempting database connection");
        con = null;
        try {
            con = DriverManager.getConnection(url, user, password);
            if (this.con != null) {
                try {
                    System.out.println("[+] Preparing to create the data table and fill it with data");
                    statement = con.createStatement();
                    try {
                        statement.executeUpdate(droptable);
                    } catch (SQLException e) {
                        System.out.println("[-] Existing table was not found");
                    }
                    System.out.println("[+] Existing table has been removed");
                    statement.executeUpdate(createtable);
                    System.out.println("[+] New table created successfully");
                    statement.executeUpdate(insertdata);
                    System.out.println("[+] Test data entered successfully");
                } catch (SQLException ex) {
                    System.out.println("[-] Failed to connect to database");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cannot connect to database. Please ensure you have started the derby/javaDB service. Program exiting");
            System.exit(1);
        }
    }
}
