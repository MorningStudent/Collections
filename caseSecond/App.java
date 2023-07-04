package caseSecond;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class App {
    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<Student>();

        students.add(new Student("Ion Pavalache", "Marketing", 8.5f));
        students.add(new Student("Mihai Stefan", "Contabilitate", 7.7f));
        students.add(new Student("Ana Nichifor", "Finante si banci", 8.3f));
        students.add(new Student("Elena Cristina", "Psihologie", 9.2f));
        students.add(new Student("Cristian Patrascu", "Arhitectura", 7.0f));

        // Collections.sort(students, new Comparator<Student>() {                    // We can use sort in order to place
        //     public int compare(Student s1, Student s2) {                          // the best student on top of the list
        //         return Float.valueOf(s1.getGrade()).compareTo(s2.getGrade());     // We will know that the element on the 0 index
        //     }                                                                     // is the best.

        Student theBest = Collections.max(students, new Comparator<Student>() {      // <--
            public int compare(Student s1, Student s2) {                             //   |
                return Float.valueOf(s1.getGrade()).compareTo(s2.getGrade());        //   |
            }                                                                        //   |--> It can be optimezed 
        });                                                                          //   |
                                                                                     //   |
        int indexOfTheBest = students.indexOf(theBest);                              // <--

        System.out.println(students);
        System.out.println();
        System.out.print("Index of the best student: " + indexOfTheBest);
        System.out.println(theBest);

        students.get(3).setGrade(students.get(3).getGrade() + 0.1f);
        System.out.println(students);

        ArrayList<Student> bestStudents = new ArrayList<Student>();

        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getGrade() >= 8.0f) {
                bestStudents.add(students.get(i));   //<-----------------------------// Maybe we need to clone the student and
            }                                                                        // only after it, to add in a new Arraylist
        }                                                                            // It dependes on how we want to work the list.
                                                                                     // If the grade will change in the future and will
        System.out.println("The best students: \n" + bestStudents);                  // be updated in one list, maybe we want to get it
                                                                                     // updated in all lists or maybe not.
    }
    
}
