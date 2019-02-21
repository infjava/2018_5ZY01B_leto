/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author janik
 */
public class Student {

    private final String osobneCislo;
    private final String meno;
    private final String priezvisko;

    public Student(String osobneCislo, String meno, String priezvisko) {
        this.osobneCislo = osobneCislo;
        if (meno != null) {
            this.meno = Character.toUpperCase(meno.charAt(0)) + meno.substring(1).toLowerCase();
        } else {
            this.meno = null;
        }
        this.priezvisko = priezvisko;
    }

    public String getOsobneCislo() {
        return this.osobneCislo;
    }

    public String getMeno() {
        return this.meno;
    }

    public String getPriezvisko() {
        return this.priezvisko;
    }

    @Override
    public String toString() {
        return "Student{" + "osobneCislo=" + this.osobneCislo + ", meno=" + this.meno + ", priezvisko=" + this.priezvisko + '}';
    }
}
