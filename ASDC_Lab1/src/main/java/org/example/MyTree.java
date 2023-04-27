package org.example;

public class MyTree {
    class Node {
        Student value;
        Node left;
        Node right;

        Node(Student value) {
            this.value = value;
        }
    }

    Node root;

    private Node addRecursive(Node current, Student student) {
        if (current == null) {
            return new Node(student);
        } else if (student.getIdnp() < current.value.getIdnp()) {
            current.left = addRecursive(current.left, student);
        } else if (student.getIdnp() > current.value.getIdnp()) {
            current.right = addRecursive(current.right, student);
        } else return current;
        return current;
    }
    public void add(Student student){
        root = addRecursive(root,student);
    }

    private boolean existsRecursive(Node current, Student student){
        if(current == null) return false;
        if(current.value.equals(student)) return true;
        return student.getIdnp() < current.value.getIdnp()
                ? existsRecursive(current.left,student)
                : existsRecursive(current.right,student);
    }
    public boolean exists(Student student){
        return existsRecursive(root,student);
    }
}
