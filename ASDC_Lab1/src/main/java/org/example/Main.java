package org.example;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        File fileToRead = new File("src/MOCK_DATA.csv");
        Random random = new Random();
        ArrayList<Student> list = Student.readingFromFile(fileToRead);
        MyTree tree = new MyTree();


        Collections.shuffle(list);
        int i = random.nextInt(51);
        Student student1 = new Student(list.get(i));
        long before = System.nanoTime();
        int j = AlgorithmsOfSearch.linear(list,student1);
        long after = System.nanoTime();
        System.out.println("\nLinear search");
        System.out.println("Expected time - O(n)");
        System.out.println("Searched student - " + student1);
        System.out.println("Student we got - " + list.get(j));
        System.out.println("Time of searching in nanos - " + (after - before));

        Collections.sort(list,(x,x2) -> x.getIdnp() - x2.getIdnp() );
        i = random.nextInt(51);
        student1 = list.get(i);
        before = System.nanoTime();
        j = AlgorithmsOfSearch.binary(list,student1);
        after = System.nanoTime();
        System.out.println("\nBinary search");
        System.out.println("Expected time - O(n*log(n)");
        System.out.println("Searched student - " + student1);
        System.out.println("Student we got - " + list.get(j));
        System.out.println("Time of searching in nanos - " + (after - before));

        i = random.nextInt(51);
        student1 = list.get(i);
        before = System.nanoTime();
        j = AlgorithmsOfSearch.interpolation(list,student1);
        after = System.nanoTime();
        System.out.println("\nInterpolation search");
        System.out.println("Expected time - O(n*log(n)");
        System.out.println("Searched student - " + student1);
        System.out.println("Student we got - " + list.get(j));
        System.out.println("Time of searching in nanos - " + (after - before));

        Collections.shuffle(list);
        for(Student student : list){
            tree.add(student);
        }
        i = random.nextInt(51);
        student1 = list.get(i);
        before = System.nanoTime();
        boolean exist = tree.exists(student1);
        after = System.nanoTime();
        System.out.println("\nSearching in my implementation of tree");
        System.out.println("Expected time - O(n*log(n)");
        System.out.println("Searched student - " + student1);
        System.out.println("Does is this student present in tree  - " + exist);
        System.out.println("Time of searching in nanos - " + (after - before));
    }
}