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
package presenter;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import view.iView;
import model.iModel;

/**
 *
 * @author josh
 */
public class ResultsPresenter {

    iModel resultsModel;
    iView resultsView;

    // Constructor
    public ResultsPresenter(iModel m, iView v) {
        resultsModel = m;
        resultsView = v;
    }

    // Operational Methods
    public void close() {
        resultsModel.close();
    }

    public void next() {
        resultsModel.next();
        fillFields();
    }

    public void previous() {
        resultsModel.previous();
        fillFields();
    }

    // String display helper methods
    private void fillFields() {
        try {
            resultsView.setAssignment1Field(String.valueOf(resultsModel.current().getAssignment1()));
            resultsView.setAssignment2Field(String.valueOf(resultsModel.current().getAssignment2()));
            resultsView.setExamField(String.valueOf(resultsModel.current().getExam()));
            resultsView.setGradeField(resultsModel.current().getGrade());
            resultsView.setStudentField(resultsModel.current().getStudent());
            resultsView.setTotalField(String.valueOf(resultsModel.current().getTotal()));
        } catch (Exception e) {
        }
    }

    private void fillTextWindow() {
        String message = String.format("Welcome to the Results viewer\n\n"
                + "Please use the 'Previous' and 'Next' Buttons to navigate results");
        resultsView.setTextDisplayWindow(message);
    }

    // Queries
    public void resultsForAllStudents() {
        resultsModel.getResultsForAllStudents();
        fillTextWindow();
        fillFields();
        resultsView.enableNext();
        resultsView.enablePrevious();
    }

    public void resultsForStudent() {
        resultsModel.getResultsForStudents(resultsView.getQueryStudentField());
        fillTextWindow();
        fillFields();
    }

    public void allAbsentFails() {
        resultsModel.getAllAbsentFails();
        fillTextWindow();
        fillFields();
        resultsView.enableNext();
        resultsView.enablePrevious();
    }

    public void totalMarksInRange() {
        int mark1 = 0;
        int mark2 = 0;
        try {
            if (resultsView.getMark1Field().equals("")) {
                System.out.println("[-] No input was found in mark1");
                String message = "Please make sure a valid mark number has been entered into the mark1 field.";
                JOptionPane.showMessageDialog(null, message);
            } else {
                mark1 = Integer.parseInt(resultsView.getMark1Field());
                System.out.println("[+] Successfully got user input for mark 1");
                if (resultsView.getMark2Field().equals("")) {
                    System.out.println("[-] No input was found in mark 2, trying mark 1 instead");
                    mark2 = mark1;
                    System.out.println("[+] Successfully using input for mark 1 as mark 2");
                } else {
                    mark2 = Integer.parseInt(resultsView.getMark2Field());
                    System.out.println("[+] Successfully got user input for mark 2");
                    System.out.println("[+] Variable mark 1 is " + mark1 + " and mark 2 is " + mark2);
                }
                if (mark2 >= mark1) {
                    try {
                        System.out.println("[+] Attempting to run query using user input");
                        System.out.println("[+] Displaying query results to text display window");
                        resultsModel.getTotalMarksInRange(mark1, mark2);
                    } catch (Exception e) {
                        System.out.println("[-] Failed to run query");
                    } finally {
                        fillTextWindow();
                        fillFields();
                        resultsView.enableNext();
                        resultsView.enablePrevious();
                    }
                } else {
                    System.out.println("[-] Error using input for mark1 as mark2");
                    JOptionPane.showMessageDialog(null,
                            "The input for Mark 2 must be greater than than Mark 1");
                }
            }
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please make sure only numbers have been entered into the fields");
        }
    }

    public void updateExamMark() {
        int exam;
        int total;
        String student;
        if (!"".equals(resultsView.getStudentField())) {
            student = resultsView.getStudentField();
            if (!"".equals(resultsView.getExamField())) {
                exam = Integer.parseInt(resultsView.getExamField());
                if (!"".equals(resultsView.getTotalField())) {
                    total = Integer.parseInt(resultsView.getTotalField());
                    resultsModel.getResultsForStudents(student);
                    if (resultsModel.queryStatus() == true) {
                        try {
                            resultsModel.updateExamMark(student, exam, total);
                            resultsModel.getResultsForStudents(student);
                            fillTextWindow();
                            fillFields();
                            resultsView.enableNext();
                            resultsView.enablePrevious();
                            System.out.println("[+] Succedded in running updateExamMark query");
                        } catch (Exception e) {
                            System.out.println("[-] Failed to run updateExamMark query");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "The student has not been found. Please enter an existing student number");
                    }
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Please make sure the student #, examination and total fields have been entered correctly");
                }
            } else {
                JOptionPane.showMessageDialog(null,
                        "Please make sure the student #, examination and total fields have been entered correctly");
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "Please make sure the student #, examination and total fields have been entered correctly");
        }

    }

    public void updateGrades() {
        resultsModel.updateGrades();
        resultsForAllStudents();
    }
}
