package org.example;

import java.util.ArrayList;

public class AlgorithmsOfSearch {
    public static int linear(ArrayList<Student> list, Student searchingStudent) {
        int index = 0;
        for (Student student : list) {
            if (student.equals(searchingStudent)) return index;
            else index++;
        }
        return -1;
    }

    public static int binary(ArrayList<Student> list, Student searchingStudent) {
        int firstIndex = 0;
        int lastIndex = list.size() - 1;
        while (firstIndex <= lastIndex) {
            int middleIndex = (lastIndex + firstIndex) / 2;
            if (searchingStudent.equals(list.get(middleIndex))) {
                return middleIndex;
            } else if (searchingStudent.getIdnp() < list.get(middleIndex).getIdnp()) {
                lastIndex = middleIndex - 1;
            } else if (searchingStudent.getIdnp() > list.get(middleIndex).getIdnp()) {
                firstIndex = middleIndex + 1;
            }
        }
        return -1;
    }

    public static int interpolation(ArrayList<Student> list, Student searchingStudent){
        int firstIndex = 0;
        int lastIndex = list.size() - 1;
        while (firstIndex <= lastIndex) {
            int k = list.get(lastIndex).getIdnp() - list.get(firstIndex).getIdnp();
            int z = searchingStudent.getIdnp() - list.get(firstIndex).getIdnp();
            int position = firstIndex + (lastIndex - firstIndex) / k * z;
            if (list.get(position).equals(searchingStudent)) {
                return position;
            } else if (list.get(position).getIdnp() < searchingStudent.getIdnp()) {
                firstIndex = position + 1;
            } else if (list.get(position).getIdnp() > searchingStudent.getIdnp()) {
                lastIndex = position - 1;
            }
        }
        return -1;
    }


}
