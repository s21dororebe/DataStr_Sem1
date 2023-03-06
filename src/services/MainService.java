package services;

import datastr.MyArrayList;
import datastr.SortingType;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class MainService {
    public static void main(String[] args) {
        MyArrayList charList1 = new MyArrayList();
        try {
            charList1.add('a'); //a
            charList1.add('d'); //a , d
            charList1.add('r'); //a, d, r
            charList1.add('h', 0); //h, a, d, r
            charList1.print();
            System.out.println(charList1.howManyElements()); //4
            charList1.remove(1);
            charList1.print(); //h, d, r
            System.out.println(charList1.retrieve(1)); //d
            System.out.println("Search: " + charList1.search('d')); //true
            charList1.add('i'); //a, d, r, i
            charList1.add('k'); //a, d, r, i, k
            charList1.add('l'); //a, d, r, i, k, l
            charList1.add('u'); //a, d, r, i, k, l, u increase() will be called
            System.out.println(Arrays.toString(charList1.retrieveNextNeighbours('i')));
            System.out.println(charList1.sort(SortingType.ASC)); //a d i k l r
            charList1.print(); //a, d, r, i, k, l
            charList1.makeEmpty();
            charList1.add('d');
            charList1.print(); //d
            System.out.println();
            System.out.println("Number list");
            MyArrayList numberList = getArrayElementsFromFile("resources/numbers.txt");
            numberList.print();
            numberList.add('r');
            numberList.print();
            numberList.remove(2);
            numberList.print();
            numberList.add('a');
            numberList.add('c');
            System.out.println(Arrays.toString(numberList.sort(SortingType.ASC)));
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    public static MyArrayList getArrayElementsFromFile(String path) throws FileNotFoundException {
        File myFile = new File(path);
        FileInputStream myInputStream = new FileInputStream(myFile);
        Scanner myScanner = new Scanner(myInputStream);
        MyArrayList listFromFile = new MyArrayList();

        while (myScanner.hasNextLine()){
            String line = myScanner.nextLine(); //lasit rindinu
            char element = line.charAt(0);
            listFromFile.add(element);
        }
        myScanner.close();
        return listFromFile;
    }
}
