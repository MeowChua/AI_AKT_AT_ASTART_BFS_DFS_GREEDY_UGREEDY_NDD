package ASTART;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import static ASTART.Node.aStar;
import static ASTART.Node.printPath;

/**
 *
 * @author WIN 10
 */
public class Main {
    public static void main(String[] args) {
    /*
    Node head = new Node(3);
    head.g = 0;

    Node n1 = new Node(2);
    Node n2 = new Node(2);
    Node n3 = new Node(2);
    Node n4 = new Node(2);
    head.addBranch(9, n1);
    head.addBranch(7, n2);
    head.addBranch(13, n3);
    head.addBranch(20, n4);
    n3.addBranch(4, n3);

    Node n5 = new Node(1);
    Node n6 = new Node(1);
    Node n7 = new Node(1);
    Node n8 = new Node(1);
    Node target = new Node(0);

    n1.addBranch(6, n5);
    n2.addBranch(8, n5);
    n3.addBranch(4, n6);
    n3.addBranch(3, n7);
    n4.addBranch(4, n8);

    n7.addBranch(9, n6);
    n5.addBranch(5, n6);
    n4.addBranch(6, n7);

    n6.addBranch(6, target);
    n7.addBranch(5, target);


    Node res = aStar(head, target);
    printPath(res);
    */
        Node head = new Node(3);
        head.g = 0;

        Node n1 = new Node(2);
        Node n2 = new Node(2);
        Node n3 = new Node(2);

        head.addBranch(1, n1);
        head.addBranch(5, n2);
        head.addBranch(2, n3);
        n3.addBranch(1, n2);

        Node n4 = new Node(1);
        Node n5 = new Node(1);
        Node target = new Node(0);

        n1.addBranch(7, n4);
        n2.addBranch(4, n5);
        n3.addBranch(6, n4);

        n4.addBranch(3, target);
        n5.addBranch(1, n4);
        n5.addBranch(3, target);
        Node res = aStar(head, target);

        printPath(res);
    }
}

