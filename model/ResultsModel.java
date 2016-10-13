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

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author josh
 */
public class ResultsModel implements iModel {

    int current;
    List<Result> results;
    ResultsQueries rq;
    boolean status;

    public ResultsModel() {
        rq = new ResultsQueries();
        results = new LinkedList();
        current = 0;
        status = false;
    }

    @Override
    public void getResultsForAllStudents() {
        try {
            results = rq.getResultsForAllStudents();
            status = true;
            current = 0;
        } catch (Exception e) {
            status = false;
        }
    }

    @Override
    public void getResultsForStudents(String c) {
        try {
            results = rq.getResultsForStudent(c);
            status = true;
            current = 0;
        } catch (Exception e) {
            status = false;
        }
    }

    @Override
    public void getTotalMarksInRange(int m1, int m2) {
        try {
            results = rq.getTotalMarksInRange(m1, m2);
            status = true;
            current = 0;
        } catch (Exception e) {
            status = false;
        }
    }

    @Override
    public void getAllAbsentFails() {
        try {
            results = rq.getAllAbsentFails();
            status = true;
            current = 0;
        } catch (Exception e) {
            status = false;
        }
    }

    @Override
    public void updateExamMark(String student, int exam, int total) {
        try {
            rq.updateExamMark(student, exam, total);
            status = true;
            current = 0;
        } catch (Exception e) {
            status = false;
        }
    }

    private void updateGrade(String student, String grade) {
        try {
            rq.updateGrade(student, grade);
        } catch (Exception e) {
        }
    }

    @Override
    public void updateGrades() {

        try {
            getResultsForAllStudents();
            for (Result r : results) {
                String grade = "F";
                float t = r.getTotal();
                float e = r.getExam();
                float a1 = r.getAssignment1();
                float a2 = r.getAssignment2();
                // begin bad math
                if (t <= 49 & t >= 45) {
                    if (e <= 24) {
                        if (a1 >= 12.5 & a2 >= 12.5) {
                            grade = "SE";
                        }
                    }
                    if (e >= 25) {
                        if (a1 >= 12.5 | a2 >= 12.5) {
                            grade = "SA";
                        }
                    }
                }
                if (t >= 50) {
                    grade = "P";
                }
                if (t >= 65) {
                    grade = "C";
                }
                if (t >= 75) {
                    grade = "D";
                }
                if (t >= 85) {
                    grade = "HD";
                }
                if (t == 0) {
                    grade = "AF";
                }
                updateGrade(r.getStudent(), grade);
            }
            status = true;
            current = 0;
        } catch (Exception e) {
            status = false;
        }
    }

    @Override
    public void close() {
        rq.close();
    }

    @Override
    public void next() {
        ++current;
        if (current >= results.size()) {
            current = 0;
        }
    }

    @Override
    public void previous() {
        --current;
        if (current < 0) {
            current = (results.size() - 1);
        }

    }

    @Override
    public Result current() {
        Result result = results.get(current);
        return result;
    }

    @Override
    public boolean queryStatus() {
        return status;
    }

}
