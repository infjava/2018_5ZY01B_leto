
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author janik
 */
public class Skupina {

    private final String cisloSkupiny;
    private final ArrayList<Student> zoznamStudentov;

    public Skupina(String cisloSkupiny) {
        this.cisloSkupiny = cisloSkupiny;
        this.zoznamStudentov = new ArrayList<Student>();
    }

    public String getCisloSkupiny() {
        return this.cisloSkupiny;
    }

    void pridajStudenta(Student student) {
        this.zoznamStudentov.add(student);
    }

    void vypisStudentov() {
        System.out.println("Skupina c. " + this.cisloSkupiny);
        for (Student student : this.zoznamStudentov) {
            System.out.println(student);
        }
    }

    Student getStudent(String osobneCislo) {
        for (Student student : this.zoznamStudentov) {
            if (student.getOsobneCislo().equals(osobneCislo)) {
                return student;
            }
        }
        
        return null;
    }
}
