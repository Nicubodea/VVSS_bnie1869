package controller;

import repository.FileDataPersistence;
import model.Laboratory;
import model.Student;
import validator.Validator;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class LaboratoriesController {
    private FileDataPersistence studentPersistence = new FileDataPersistence(
            "students.txt");
    private FileDataPersistence laboratoryPersistence = new FileDataPersistence(
            "laboratories.txt");

    public LaboratoriesController(String studentFile, String laboratoryFile) {
    	this.studentPersistence = new FileDataPersistence(studentFile);
    	this.laboratoryPersistence = new FileDataPersistence(laboratoryFile);
    }
    
    public boolean saveStudent(Student student) {
        if (Validator.validateStudent(student)) {
            this.studentPersistence.saveStudent(student);
            return true;
        } else {
            return false;
        }
    }

    public boolean saveLaboratory(Laboratory laboratory) {
        if (Validator.validateLaboratory(laboratory)) {
            this.laboratoryPersistence.saveLaboratory(laboratory);
            return true;
        } else {
            return false;
        }
    }

    public boolean addGrade(String student, String labNumber, float grade)
            throws NumberFormatException, IOException, ParseException {
        if (Validator.validateGrade(grade)) {
            this.laboratoryPersistence.addGrade(student, labNumber, grade);
            return true;
        } else {
            return false;
        }
    }

    public List<Student> getAllStudents() throws IOException {
        return this.studentPersistence.getStudentsList();
    }

    public List<Student> passedStudents() throws NumberFormatException,
            IOException, ParseException {
        Map<String, List<Laboratory>> laboratoryMap = this.laboratoryPersistence.getLaboratoryMap();
        List<Student> studentsList = studentPersistence.getStudentsList();

        List<Student> passedStudents = new ArrayList<>();
        Entry<String, List<Laboratory>> entry;

        Set<Entry<String, List<Laboratory>>> entrySet = laboratoryMap.entrySet();
        Iterator<Entry<String, List<Laboratory>>> iterator = entrySet.iterator();

        while (iterator.hasNext()) {
            entry = iterator.next();
            //float midGrade = entry.getValue().get(0).getGrade();
            float sum = 0;
            int cnt = 0;
            for (Laboratory laboratory : entry.getValue()) {
                //midGrade = (midGrade + laboratory.getGrade()) / 2;
                sum = sum+laboratory.getGrade();
                cnt++;
            }
            sum = sum / cnt;
            //System.out.println(midGrade);
            if (sum >= 5) {
                //Student student = new Student();
                //student.setRegNumber(entry.getKey());
                int indexOf = 0;
                boolean found = false;
                for (Student s : studentsList) {
                    if (s.getRegNumber().compareTo(entry.getKey()) == 0) {
                        found = true;
                        break;
                    }
                    indexOf++;
                }
                if (found) {
                    passedStudents.add(studentsList.get(indexOf));
                }
            }
        }

        return passedStudents;
    }
} 