package controller;

import model.Laboratory;
import model.Student;

import java.io.File;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Nicu on 23-Mar-18.
 */
public class LaboratoriesControllerTest {

    @org.junit.Test
    public void saveStudentTestCase1() throws Exception {
        File f = new File("test1.txt");
        f.createNewFile();
        LaboratoriesController controller = new LaboratoriesController("test1.txt", "laboratories.txt");
        Student s = new Student("abcd1234", "Johnny Bravo", 932);
        assertTrue(controller.saveStudent(s));
        assertTrue(controller.getAllStudents().contains(s));
    }

    @org.junit.Test
    public void saveStudentTestCase2() throws Exception {
        File f = new File("test2.txt");
        f.createNewFile();
        LaboratoriesController controller = new LaboratoriesController("test2.txt", "laboratories.txt");
        Student s = new Student("abcd1234", "abcd", 935);
        assertFalse(controller.saveStudent(s));
        assertFalse(controller.getAllStudents().contains(s));
    }

    @org.junit.Test
    public void saveStudentTestCase3() throws Exception {
        File f = new File("test3.txt");
        f.createNewFile();
        LaboratoriesController controller = new LaboratoriesController("test3.txt", "laboratories.txt");
        Student s = new Student("abcd1234", "abcd 1234escu", 938);
        assertFalse(controller.saveStudent(s));
        assertFalse(controller.getAllStudents().contains(s));
    }

    @org.junit.Test
    public void saveStudentTestCase4() throws Exception {
        File f = new File("test4.txt");
        f.createNewFile();
        LaboratoriesController controller = new LaboratoriesController("test4.txt", "laboratories.txt");
        Student s = new Student("abcd1234", "Ion Ionescu", 0);
        assertFalse(controller.saveStudent(s));
        assertFalse(controller.getAllStudents().contains(s));
    }

    @org.junit.Test
    public void saveStudentTestCase5() throws Exception {
        File f = new File("test5.txt");
        f.createNewFile();
        LaboratoriesController controller = new LaboratoriesController("test5.txt", "laboratories.txt");
        Student s = new Student("abcd1234", "Ion Ionescu", 1000);
        assertFalse(controller.saveStudent(s));
        assertFalse(controller.getAllStudents().contains(s));

    }

    @org.junit.Test
    public void saveStudentTestCase6() throws Exception {
        File f = new File("test6.txt");
        f.createNewFile();
        LaboratoriesController controller = new LaboratoriesController("test6.txt", "laboratories.txt");
        Student s = new Student("abcd1234", "Ion Ionescu", 414124);
        assertFalse(controller.saveStudent(s));
        assertFalse(controller.getAllStudents().contains(s));
    }


    @org.junit.Test
    public void saveStudentTestCase7() throws Exception {
        File f = new File("test7.txt");
        f.createNewFile();
        LaboratoriesController controller = new LaboratoriesController("test7.txt", "laboratories.txt");
        Student s = new Student("abcd1234", "Ion Ionescu", -1);
        assertFalse(controller.saveStudent(s));
        assertFalse(controller.getAllStudents().contains(s));
    }


    @org.junit.Test
    public void saveStudentTestCase8() throws Exception {
        File f = new File("test8.txt");
        f.createNewFile();
        LaboratoriesController controller = new LaboratoriesController("test8.txt", "laboratories.txt");
        Student s = new Student("abcd1234", "Ion Ionescu", 999);
        assertTrue(controller.saveStudent(s));
        assertTrue(controller.getAllStudents().contains(s));
    }

    @org.junit.Test
    public void saveStudentTestCase9() throws Exception {
        File f = new File("test9.txt");
        f.createNewFile();
        LaboratoriesController controller = new LaboratoriesController("test9.txt", "laboratories.txt");
        Student s = new Student("abcd1234", "Ion Ionescu", 1001);
        assertFalse(controller.saveStudent(s));
        assertFalse(controller.getAllStudents().contains(s));
    }

    @org.junit.Test
    public void saveStudentTestCase10() throws Exception {
        File f = new File("test10.txt");
        f.createNewFile();
        LaboratoriesController controller = new LaboratoriesController("test10.txt", "laboratories.txt");
        Student s = new Student("ab12", "Ion Ionescu", 1001);
        assertFalse(controller.saveStudent(s));
        assertFalse(controller.getAllStudents().contains(s));
    }

    @org.junit.Test
    public void laboratoryWBTCondition1() throws Exception {
        File f = new File("wbt1.txt");
        f.createNewFile();
        LaboratoriesController controller = new LaboratoriesController("students.txt", "wbt1.txt");
        Laboratory l1 = new Laboratory(1, "10/11/2018", 1, "abcd1234");
        assertTrue(controller.saveLaboratory(l1));
        assertFalse(controller.addGrade("abcd1234", "1", (float)11.0));
        assertTrue(controller.addGrade("abcd1234", "1", (float)10.0));

        f.delete();
    }

    @org.junit.Test
    public void laboratoryWBTCondition2() throws Exception {

        File f = new File("wbt2.txt");
        f.createNewFile();

        LaboratoriesController controller = new LaboratoriesController("students.txt", "wbt2.txt");

        Laboratory l3 = new Laboratory(1, "10/11/2018", 1, (float)1.0, "abcd1234");
        assertTrue(controller.saveLaboratory(l3));
        assertFalse(controller.addGrade("abcd1234", "1", (float)0.0));
        assertTrue(controller.addGrade("abcd1234", "1", (float)1.0));

        f.delete();
    }

    @org.junit.Test
    public void laboratoryWBT1() throws Exception {

        LaboratoriesController controller = new LaboratoriesController("wbts3.txt", "wbt3.txt");

        Laboratory l3 = new Laboratory(1, "10/11/2018", 1, (float)1.0, "abcd1234");
        assertTrue(controller.saveLaboratory(l3));
        assertTrue(controller.addGrade("abcd1234", "1", (float)6.0));
    }

    @org.junit.Test
    public void laboratoryWBT2() throws Exception {

        LaboratoriesController controller = new LaboratoriesController("wbts4.txt", "wbt4.txt");

        assertFalse(controller.saveLaboratory(new Laboratory(1,"10/10/2012", 2, "c")));
        assertFalse(controller.addGrade("abcd1234", "1", (float)6.0));
    }

    @org.junit.Test
    public void laboratoryWBT3() throws Exception {

        LaboratoriesController controller = new LaboratoriesController("wbts5.txt", "wbt5.txt");

        Laboratory l3 = new Laboratory(1, "10/11/2018", 1, (float)1.0, "abcd1234");
        assertTrue(controller.saveLaboratory(l3));
        assertFalse(controller.addGrade("abcd1234", "12", (float)6.0));
    }

    @org.junit.Test
    public void laboratoryWBT4() throws Exception {

        LaboratoriesController controller = new LaboratoriesController("wbts6.txt", "wbt6.txt");

        Laboratory l3 = new Laboratory(1, "10/11/2018", 1, (float)1.0, "abcd1234");
        assertTrue(controller.saveLaboratory(l3));
        assertFalse(controller.addGrade("akbc4578", "1", (float)6.0));
    }

    @org.junit.Test
    public void bigbang1() throws Exception {

        LaboratoriesController controller = new LaboratoriesController("bigbangs1.txt", "bigbang1.txt");

        List<Student> lst = controller.passedStudents();

        assertTrue(lst.contains(new Student("abcd1234", "Abcd Abcd", 932)));

    }

    @org.junit.Test
    public void bigbang2() throws Exception {

        LaboratoriesController controller = new LaboratoriesController("bigbangs2.txt", "bigbang2.txt");

        assertTrue(controller.saveStudent(new Student("abcd1234", "Abcd Abcd", 932)));
        Laboratory l3 = new Laboratory(1, "10/11/2018", 1, "abcd1234");
        assertTrue(controller.saveLaboratory(l3));

        Laboratory l4 = new Laboratory(1, "10/11/2018", 2, "abcd1234");
        assertTrue(controller.saveLaboratory(l4));
        assertTrue(controller.addGrade("abcd1234", "1", (float)7.0));
        assertTrue(controller.addGrade("abcd1234", "1", (float)6.0));

        List<Student> lst = controller.passedStudents();

        assertTrue(lst.contains(new Student("abcd1234", "Abcd Abcd", 932)));

        controller.getAllStudents();

        assertTrue(true);

    }


    @org.junit.Test
    public void integration1() throws Exception {
        File f = new File("int1.txt");
        f.createNewFile();
        LaboratoriesController controller = new LaboratoriesController("int1.txt", "intl1.txt");
        Student s = new Student("abcd1234", "Johnny Bravo", 932);
        assertTrue(controller.saveStudent(s));
        assertTrue(controller.getAllStudents().contains(s));

        assertTrue(true);
    }

    @org.junit.Test
    public void integration2() throws Exception {
        File f = new File("int2.txt");
        f.createNewFile();
        LaboratoriesController controller = new LaboratoriesController("int2.txt", "intl2.txt");
        Student s = new Student("abcd1234", "Johnny Bravo", 932);
        assertTrue(controller.saveStudent(s));
        assertTrue(controller.getAllStudents().contains(s));
        Laboratory l3 = new Laboratory(1, "10/11/2018", 1, (float)1.0, "abcd1234");
        assertTrue(controller.saveLaboratory(l3));
        assertTrue(controller.addGrade("abcd1234", "1", (float)6.0));

        assertTrue(true);

    }

    @org.junit.Test
    public void integration3() throws Exception {

        LaboratoriesController controller = new LaboratoriesController("int3.txt", "intl3.txt");

        assertTrue(controller.saveStudent(new Student("abcd1234", "Abcd Abcd", 932)));
        Laboratory l3 = new Laboratory(1, "10/11/2018", 1, "abcd1234");
        assertTrue(controller.saveLaboratory(l3));

        Laboratory l4 = new Laboratory(1, "10/11/2018", 2, "abcd1234");
        assertTrue(controller.saveLaboratory(l4));
        assertTrue(controller.addGrade("abcd1234", "1", (float)7.0));
        assertTrue(controller.addGrade("abcd1234", "1", (float)6.0));

        List<Student> lst = controller.passedStudents();

        assertTrue(lst.contains(new Student("abcd1234", "Abcd Abcd", 932)));

        controller.getAllStudents();

        assertTrue(true);

    }

}