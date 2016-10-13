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
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author josh
 */
public class ResultsQueries {

    // Database Variables
    private String service = "jdbc:derby:";
    private String location = "//localhost:1527/";
    private String database = "results";
    private String create = "true";
    private String url = service + location + database + ";create=" + create;
    private String user = "josh";
    private String password = "josh";
    // Query Variables
    private String absentFailsQuery = "SELECT * FROM marks "
            + "     WHERE exam = 0 AND assignment1 = 0 AND assignment2 = 0";
    private String allStudentsQuery = "SELECT * FROM marks";
    private String studentQuery = "SELECT * FROM marks WHERE studentid = ?";
    private String totalInRangeQuery = "SELECT * FROM marks WHERE total >= ? AND total <= ?";
    private String updateExamMarkQuery = "UPDATE marks SET exam = ? WHERE studentid = ?";
    private String updateExamTotalQuery = "UPDATE marks SET total = ? WHERE studentid = ?";
    private String updateGradeQuery = "UPDATE marks SET grade = ? WHERE studentid = ?";

    // System Variables
    public Connection con;
    private ResultSet rs;
    private PreparedStatement selectAbsentFails;
    private PreparedStatement selectAllStudents;
    private PreparedStatement selectStudent;
    private PreparedStatement selectTotalInRange;
    private PreparedStatement selectUpdateExamMark;
    private PreparedStatement selectUpdateExamTotal;
    private PreparedStatement selectUpdateGrade;

    // Constructor creates connection
    public ResultsQueries() {
        this.con = null;
        try {
            System.out.println("[+] Attempting database connection");
            this.con = DriverManager.getConnection(url, user, password);
            // Fill Database

            if (this.con != null) {
                System.out.println("[+] Connected to database");

                System.out.println("[+] Attempting to prepare statements");
                selectAbsentFails = con.prepareStatement(absentFailsQuery);
                selectAllStudents = con.prepareStatement(allStudentsQuery);
                selectStudent = con.prepareStatement(studentQuery);
                selectTotalInRange = con.prepareStatement(totalInRangeQuery);
                selectUpdateExamMark = con.prepareStatement(updateExamMarkQuery);
                selectUpdateExamTotal = con.prepareStatement(updateExamTotalQuery);
                selectUpdateGrade = con.prepareStatement(updateGradeQuery);
            }
        } catch (SQLException ex) {
            System.out.println("[-] Failed to connect to database");
            JOptionPane.showMessageDialog(null, "Cannot connect to database. Please ensure you have started the derby/javaDB service. Program exiting");
            System.exit(1);
        }
    }

    // Query all students with absent fails
    public List<Result> getAllAbsentFails() {
        List<Result> results = new LinkedList();
        rs = null;
        Result result;
        try {
            System.out.println("[+] Attempting to query database for all students with absent fails");
            rs = selectAbsentFails.executeQuery();
            System.out.println("[+] Successful query attempt");
            System.out.println("[+] Appending List<Result>");
            int i = 0;
            while (rs.next()) {
                result = new Result();
                result.setStudent(rs.getString(1));
                result.setAssignment1(rs.getInt(2));
                result.setAssignment2(rs.getInt(3));
                result.setExam(rs.getInt(4));
                result.setTotal(rs.getInt(5));
                result.setGrade(rs.getString(6));
                results.add(result);
                System.out.println("[+] Successfully added item " + (i + 1));
                ++i;
            }
        } catch (SQLException ex) {
            System.out.println("[-] Query did not execute successfully");
        } finally {
            try {
                System.out.println("[+] Printing results of the query");
                for (Result r : results) {
                    System.out.println(r.toString());
                }
                closeResultSet();
            } catch (Exception ex) {
            }
        }
        return results;
    }

    // Query all students
    public List<Result> getResultsForAllStudents() {
        List<Result> results = new LinkedList();
        rs = null;
        Result result;
        try {
            System.out.println("[+] Attempting to query database for all students");
            rs = selectAllStudents.executeQuery();
            System.out.println("[+] Successful query attempt");
            System.out.println("[+] Appending List<Result>");
            int i = 0;
            while (rs.next()) {
                result = new Result();
                result.setStudent(rs.getString(1));
                result.setAssignment1(rs.getInt(2));
                result.setAssignment2(rs.getInt(3));
                result.setExam(rs.getInt(4));
                result.setTotal(rs.getInt(5));
                result.setGrade(rs.getString(6));
                results.add(result);
                System.out.println("[+] Successfully added item " + (i + 1));
                ++i;
            }
        } catch (SQLException ex) {
            System.out.println("[-] Query did not execute successfully");
        } finally {
            try {
                System.out.println("[+] Printing results of the query");
                for (Result r : results) {
                    System.out.println(r.toString());
                }
                closeResultSet();
            } catch (Exception ex) {
            }
        }
        return results;
    }

    // Query for a particular student
    public List<Result> getResultsForStudent(String student) {
        List<Result> results = new LinkedList();
        Result result;
        rs = null;
        try {
            System.out.println("[+] Attempting to prepare statement");
            selectStudent.setString(1, student);
            System.out.println("[+] Attempting to query database for student "
                    + student);
            rs = selectStudent.executeQuery();
            System.out.println("[+] Successful query attempt");
            System.out.println("[+] Appending Result");
            int i = 0;
            while (rs.next()) {
                result = new Result();
                result.setStudent(rs.getString(1));
                result.setAssignment1(rs.getInt(2));
                result.setAssignment2(rs.getInt(3));
                result.setExam(rs.getInt(4));
                result.setTotal(rs.getInt(5));
                result.setGrade(rs.getString(6));
                results.add(result);
                System.out.println("[+] Successfully added item " + (i + 1));
                ++i;
            }
        } catch (SQLException ex) {
            System.out.println("[-] Query did not execute successfully");
        } finally {
            try {
                System.out.println("[+] Printing results of query");
                for (Result r : results) {
                    System.out.println(r.toString());
                }
                closeResultSet();
            } catch (Exception ex) {
            }
        }
        return results;
    }

    // Query all students with marks between given number range
    public List<Result> getTotalMarksInRange(int mark1, int mark2) {
        Result result = new Result();
        List<Result> results = new LinkedList();
        rs = null;
        try {
            System.out.println("[+] Attempting to prepare statement");
            selectTotalInRange.setInt(1, mark1);
            selectTotalInRange.setInt(2, mark2);
            System.out.println("[+] Attempting to query database for students"
                    + " within a mark range of " + mark1 + " and " + mark2);
            rs = selectTotalInRange.executeQuery();
            System.out.println("[+] Successful query attempt");
            System.out.println("[+] Appending List<Result>");
            int i = 0;
            while (rs.next()) {
                result = new Result();
                result.setStudent(rs.getString(1));
                result.setAssignment1(rs.getInt(2));
                result.setAssignment2(rs.getInt(3));
                result.setExam(rs.getInt(4));
                result.setTotal(rs.getInt(5));
                result.setGrade(rs.getString(6));
                results.add(result);
                System.out.println("[+] Successfully added item " + (i + 1));
                ++i;
            }
        } catch (SQLException ex) {
            System.out.println("[-] Query did not execute successfully");
        } finally {
            try {
                System.out.println("[+] Printing results of query");
                for (Result r : results) {
                    System.out.println(r.toString());
                }
                closeResultSet();
            } catch (Exception ex) {
            }
        }
        return results;
    }

    // Update the exam and total result for a particular student
    public void updateExamMark(String student, int exam, int total) {
        try {
            System.out.println("[+] Attempting to update exam results for student " + student);
            selectUpdateExamMark.setInt(1, exam);
            System.out.println("[+] Successfully inserted exam result variable");
            selectUpdateExamMark.setString(2, student);
            System.out.println("[+] Attempting to execute update");
            selectUpdateExamMark.executeUpdate();
            System.out.println("[+] Successfully executed exam update");
            System.out.println("[+] Attempting to update total results for student " + student);
            selectUpdateExamTotal.setInt(1, total);
            System.out.println("[+] Successfully inserted total result variable");
            selectUpdateExamTotal.setString(2, student);
            System.out.println("[+] Attempting to execute update");
            selectUpdateExamTotal.executeUpdate();
            System.out.println("[+] Successfully executed total update");
            System.out.println("[+] Attempting to execute update");
            selectUpdateExamTotal.executeUpdate();
            System.out.println("[+] Successfully executed results update");
            con.commit();
            System.out.println("[+] Successfully commited new results for student "
                    + student + " to the database");

        } catch (SQLException ex) {
            System.out.println("[-] Failed to update database");
        } finally {
            try {
                closeResultSet();
            } catch (Exception ex) {
            }
        }
    }

    // Update grade for a particular student
    public void updateGrade(String student, String grade) {
        try {
            System.out.println("[+] Attempting to update grade results for student " + student);
            selectUpdateGrade.setString(1, grade);
            System.out.println("[+] Successfully inserted grade result variable");
            selectUpdateGrade.setString(2, student);
            System.out.println("[+] Attempting to execute update");
            selectUpdateGrade.executeUpdate();
            System.out.println("[+] Successfully executed results update");
            con.commit();
            System.out.println("[+] Successfully commited new results for student "
                    + student + " to the database");
        } catch (SQLException ex) {
            System.out.println("[-] Failed to update database");
        } finally {
            try {
                closeResultSet();
            } catch (Exception ex) {
            }
        }
    }

    // Query the count of all zero scores
    public int getNumberOfAbsentFails() {
        int fails = 0;
        rs = null;
        try {
            System.out.println("[+] Attempting to query database for all "
                    + "absent fail instances");
            rs = selectAbsentFails.executeQuery();
            System.out.println("[+] Successful query attempt");
            System.out.println("[+] Appending results");
            while (rs.next()) {
                ++fails;
            }
        } catch (SQLException ex) {
            System.out.println("[-] Query did not execute successfully");
        } finally {
            try {
                System.out.println("[+] Printing results of query");
                System.out.println("[+] Successfully found "
                        + fails + " absent fail instances");
                closeResultSet();
            } catch (Exception ex) {
            }
        }
        return fails;
    }

    // Close ResultSet 
    private void closeResultSet() {
        try {
            System.out.println("[+] Attempting to close result set");
            rs.close();
            System.out.println("[+] Result set closed successfuly");
        } catch (SQLException ex) {
            System.out.println("[-] Failed to close result set");
        }
    }

    // Close connection
    public void close() {
        try {
            if (!con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
        }
    }

}
