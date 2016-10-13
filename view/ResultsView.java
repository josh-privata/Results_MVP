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
package view;

import presenter.ResultsPresenter;

/**
 *
 * @author josh
 */
public class ResultsView extends javax.swing.JFrame implements iView {

    private ResultsPresenter resultsPresenter;
    private final String header = String.format("Student ID\tAssign 1\tAssign 2\tExam\tTotal\tGrade\n");

    /**
     * Creates new form NewJFrame
     */
    public ResultsView() {
        super("Results");
        initComponents();
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        headingText = new javax.swing.JLabel();
        studentLabel = new javax.swing.JLabel();
        studentField = new javax.swing.JTextField();
        assignment1Label = new javax.swing.JLabel();
        assignment1Field = new javax.swing.JTextField();
        Assignment2Label = new javax.swing.JLabel();
        assignment2Field = new javax.swing.JTextField();
        examLabel = new javax.swing.JLabel();
        examField = new javax.swing.JTextField();
        totalLabel = new javax.swing.JLabel();
        totalField = new javax.swing.JTextField();
        gradeLabel = new javax.swing.JLabel();
        gradeField = new javax.swing.JTextField();
        testDisplayScrollPane = new javax.swing.JScrollPane();
        textDisplayWindow = new javax.swing.JTextArea();
        updateExamMarkButton = new javax.swing.JButton();
        queryAllStudentsButton = new javax.swing.JButton();
        queryStudentButton = new javax.swing.JButton();
        queryMarkRangeButton = new javax.swing.JButton();
        queryAbsentFailsButton = new javax.swing.JButton();
        ExitButton = new javax.swing.JButton();
        mark1Field = new javax.swing.JTextField();
        mark2Field = new javax.swing.JTextField();
        queryStudentField = new javax.swing.JTextField();
        previousButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        clearTextButton = new javax.swing.JButton();
        updateGradesButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("mainWindow"); // NOI18N
        setResizable(false);

        mainPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        headingText.setFont(new java.awt.Font("DejaVu Sans", 0, 24)); // NOI18N
        headingText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headingText.setText("Marks Management System");

        studentLabel.setText("Student #");
        studentLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        studentField.setToolTipText("Enter Student Number");

        assignment1Label.setText("Assignment 1");

        assignment1Field.setEditable(false);
        assignment1Field.setToolTipText("Enter Assignment 1 Mark");

        Assignment2Label.setText("Assignment 2");

        assignment2Field.setEditable(false);
        assignment2Field.setToolTipText("Assignment 2 Mark");

        examLabel.setText("Examination");

        examField.setToolTipText("Enter Examination Mark");

        totalLabel.setText("Total");

        totalField.setToolTipText("Enter Total Mark");

        gradeLabel.setText("Grade");
        gradeLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        gradeField.setEditable(false);
        gradeField.setToolTipText("Enter Student Grade");

        textDisplayWindow.setColumns(20);
        textDisplayWindow.setRows(5);
        textDisplayWindow.setToolTipText("Display Test Shows Here");
        testDisplayScrollPane.setViewportView(textDisplayWindow);

        updateExamMarkButton.setText("Update Exam Mark");
        updateExamMarkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateExamMarkButtonActionPerformed(evt);
            }
        });

        queryAllStudentsButton.setText("Query All Students");
        queryAllStudentsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                queryAllStudentsButtonActionPerformed(evt);
            }
        });

        queryStudentButton.setText("Query Student");
        queryStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                queryStudentButtonActionPerformed(evt);
            }
        });

        queryMarkRangeButton.setText("Query Marks in Range");
        queryMarkRangeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                queryMarkRangeButtonActionPerformed(evt);
            }
        });

        queryAbsentFailsButton.setText("Query Absent Fails");
        queryAbsentFailsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                queryAbsentFailsButtonActionPerformed(evt);
            }
        });

        ExitButton.setText("Exit Program");
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });

        previousButton.setText("Previous");
        previousButton.setToolTipText("Previous Record");
        previousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousButtonActionPerformed(evt);
            }
        });

        nextButton.setText("Next");
        nextButton.setToolTipText("Next Record");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        clearTextButton.setText("Clear Text");
        clearTextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearTextButtonActionPerformed(evt);
            }
        });

        updateGradesButton.setText("Update All Grades");
        updateGradesButton.setToolTipText("Update all student grades");
        updateGradesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateGradesButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(queryMarkRangeButton, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(queryAbsentFailsButton, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(queryAllStudentsButton)
                                    .addComponent(updateGradesButton))
                                .addGap(1, 1, 1))
                            .addComponent(queryStudentButton, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addComponent(mark1Field, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(8, 8, 8)
                                        .addComponent(mark2Field, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(queryStudentField))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 338, Short.MAX_VALUE)
                                .addComponent(ExitButton))
                            .addComponent(clearTextButton))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addComponent(headingText, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(209, 209, 209))))
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(examLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Assignment2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gradeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gradeField, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(assignment1Field, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                .addComponent(assignment2Field)
                                .addComponent(examField)
                                .addComponent(totalField))))
                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainPanelLayout.createSequentialGroup()
                            .addComponent(previousButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(nextButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(updateExamMarkButton, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(studentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(assignment1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(studentField, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(testDisplayScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(headingText, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(assignment1Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(assignment2Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Assignment2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(examField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(examLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gradeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gradeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(previousButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(updateExamMarkButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(updateGradesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(queryAllStudentsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearTextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(queryAbsentFailsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(queryStudentField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addComponent(queryStudentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(mark2Field, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(mark1Field, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(queryMarkRangeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup()
                    .addGap(74, 74, 74)
                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(testDisplayScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(studentLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(studentField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(assignment1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(160, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Close database connection and exit program
    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
        resultsPresenter.close();
        System.exit(1);
    }//GEN-LAST:event_ExitButtonActionPerformed

    // Run getNumberOfAbsentFails Query and refresh textDisplayWindow
    private void queryAbsentFailsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_queryAbsentFailsButtonActionPerformed
        resultsPresenter.allAbsentFails();
    }//GEN-LAST:event_queryAbsentFailsButtonActionPerformed

    // Run getTotalMarksInRange Query and refresh textDisplayWindow
    private void queryMarkRangeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_queryMarkRangeButtonActionPerformed
        resultsPresenter.totalMarksInRange();
        mark1Field.setText("");
        mark2Field.setText("");
    }//GEN-LAST:event_queryMarkRangeButtonActionPerformed

    // Run getResultsForStudent Query and refresh textDisplayWindow
    private void queryStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_queryStudentButtonActionPerformed
        resultsPresenter.resultsForStudent();
        queryStudentField.setText("");
    }//GEN-LAST:event_queryStudentButtonActionPerformed

    // Run getResultsForAllStudents Query and refresh textDisplayWindow
    private void queryAllStudentsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_queryAllStudentsButtonActionPerformed
        resultsPresenter.resultsForAllStudents();
    }//GEN-LAST:event_queryAllStudentsButtonActionPerformed

    // Update database and refresh textDisplayWindow
    private void updateExamMarkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateExamMarkButtonActionPerformed
        resultsPresenter.updateExamMark();
    }//GEN-LAST:event_updateExamMarkButtonActionPerformed

    private void previousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousButtonActionPerformed
        resultsPresenter.previous();
    }//GEN-LAST:event_previousButtonActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        resultsPresenter.next();
    }//GEN-LAST:event_nextButtonActionPerformed

    private void clearTextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearTextButtonActionPerformed
        String message = "";
        studentField.setText(message);
        gradeField.setText(message);
        assignment1Field.setText(message);
        assignment2Field.setText(message);
        examField.setText(message);
        totalField.setText(message);
        textDisplayWindow.setText(message);
        nextButton.setEnabled(false);
        previousButton.setEnabled(false);
    }//GEN-LAST:event_clearTextButtonActionPerformed

    private void updateGradesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateGradesButtonActionPerformed
        resultsPresenter.updateGrades();
    }//GEN-LAST:event_updateGradesButtonActionPerformed

    // set the presenter for this view
    public void bind(ResultsPresenter rp) {
        resultsPresenter = rp;
    }

    @Override
    public String getAssignment1Field() {
        return assignment1Field.getText();
    }

    @Override
    public void setAssignment1Field(String s) {
        this.assignment1Field.setText(s);
    }

    @Override
    public String getAssignment2Field() {
        return assignment2Field.getText();
    }

    @Override
    public void setAssignment2Field(String s) {
        this.assignment2Field.setText(s);
    }

    @Override
    public String getExamField() {
        return examField.getText();
    }

    @Override
    public void setExamField(String s) {
        this.examField.setText(s);
    }

    @Override
    public String getGradeField() {
        return gradeField.getText();
    }

    @Override
    public void setGradeField(String s) {
        this.gradeField.setText(s);
    }

    @Override
    public String getMark1Field() {
        return mark1Field.getText();
    }

    @Override
    public void setMark1Field(String s) {
        this.mark1Field.setText(s);
    }

    @Override
    public String getMark2Field() {
        return mark2Field.getText();
    }

    @Override
    public void setMark2Field(String s) {
        this.mark2Field.setText(s);
    }

    @Override
    public String getQueryStudentField() {
        return queryStudentField.getText();
    }

    @Override
    public void setQueryStudentField(String s) {
        this.queryStudentField.setText(s);
    }

    @Override
    public String getStudentField() {
        return studentField.getText();
    }

    @Override
    public void setStudentField(String s) {
        this.studentField.setText(s);
    }

    @Override
    public String getTextDisplayWindow() {
        return textDisplayWindow.getText();
    }

    @Override
    public void setTextDisplayWindow(String s) {
        this.textDisplayWindow.setText(s);
    }

    @Override
    public String getTotalField() {
        return totalField.getText();
    }

    @Override
    public void setTotalField(String s) {
        this.totalField.setText(s);
    }

    @Override
    public void enableNext() {
        nextButton.setEnabled(true);
    }

    @Override
    public void enablePrevious() {
        previousButton.setEnabled(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Assignment2Label;
    private javax.swing.JButton ExitButton;
    private javax.swing.JTextField assignment1Field;
    private javax.swing.JLabel assignment1Label;
    private javax.swing.JTextField assignment2Field;
    private javax.swing.JButton clearTextButton;
    private javax.swing.JTextField examField;
    private javax.swing.JLabel examLabel;
    private javax.swing.JTextField gradeField;
    private javax.swing.JLabel gradeLabel;
    private javax.swing.JLabel headingText;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextField mark1Field;
    private javax.swing.JTextField mark2Field;
    private javax.swing.JButton nextButton;
    private javax.swing.JButton previousButton;
    private javax.swing.JButton queryAbsentFailsButton;
    private javax.swing.JButton queryAllStudentsButton;
    private javax.swing.JButton queryMarkRangeButton;
    private javax.swing.JButton queryStudentButton;
    private javax.swing.JTextField queryStudentField;
    private javax.swing.JTextField studentField;
    private javax.swing.JLabel studentLabel;
    private javax.swing.JScrollPane testDisplayScrollPane;
    private javax.swing.JTextArea textDisplayWindow;
    private javax.swing.JTextField totalField;
    private javax.swing.JLabel totalLabel;
    private javax.swing.JButton updateExamMarkButton;
    private javax.swing.JButton updateGradesButton;
    // End of variables declaration//GEN-END:variables
}
