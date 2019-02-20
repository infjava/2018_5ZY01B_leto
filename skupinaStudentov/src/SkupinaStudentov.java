/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author janik
 */
public class SkupinaStudentov {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Hello world");
        System.out.println("Hello again");
        System.out.println("Bye bye");
        
        Student fero = new Student("222", "Frantisek", "Mrkvicka");
        System.out.println(fero);
        
        Skupina sk5ZY01B = new Skupina("5ZY01B");
        sk5ZY01B.pridajStudenta(fero);
        sk5ZY01B.vypisStudentov();
    }
}
