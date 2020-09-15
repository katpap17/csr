import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.io.PrintWriter; 
import java.io.*;

public class CsrTester{
    
    public static void main(String[] args){	

    int flag = 0; //flag to exit program
    
    //prints welcome message
    System.out.print("Welcome to AreTheyFriends! Please wait while CSR is being created:\n");
    
    //prints message
    System.out.print("Making CSR..\n");
    
    //creates csr object
    CompressedSparseRows csra = new CompressedSparseRows();
    CompressedSparseRows csrb = new CompressedSparseRows();

    //inputs columns from txt file 
    try {
        File text = new File(args[0]);
        Scanner scnr = new Scanner(text);
            while(scnr.hasNextLine()){
                String line = scnr.nextLine();
                
                if(line.matches("\\d+\\t\\d+")){
                String[] col = line.split("\\t"); //splits columns to array rows
                csra.addSat(col[0], col[1]); //adds them to sat array
                csrb.addSat(col[1], col[0]); //adds them to sat array
                }
            }
            
            scnr.close();
    } 
    catch (FileNotFoundException e) { //file error handling 
        e.printStackTrace();
        }
    
    csra.sortSat(); //sorts array items
    csrb.sortSat();
    
    int max = csra.findMax();
    
    csra.createEdges(); //creates edges array from sat
    csrb.createEdges();
    
    csra.createVertices(max); //creates vertices array from sat
    csrb.createVertices(max);
    

    
    BFS bfs = new BFS(); //creates bfs instance
    
    System.out.print("CSR created! What do you want to do?\n"); //prints message
    //scanner that accepts user's input
    Scanner sc = new Scanner(System.in);
    
    //checks if user wants to exit program
    while(flag==0){
        //prints user's choices
        System.out.print("a: Find out a node's neighbors\n"); 
        System.out.print("b: Find out if two nodes are connected and how long the path between them is (Breadth-First-Search)\n");
        System.out.print("c: Find out if two nodes are connected and how long the path between them is (Bidirectional Search)\n");
        System.out.print("d: Exit program\n");
        //inputs user's choice
        char ch = sc.next().charAt(0);
        //executes navigate method
        if(ch=='a'){
            System.out.print("Enter a node number (0 to "+max+"):\n");
            int n = sc.nextInt();
            csra.navigate(n);
        }
        
                //executes simple bfs
        else if(ch == 'b'){
            System.out.print("Enter starting node number (0 to "+max+"):\n");
            int s = sc.nextInt();
            
            System.out.print("Enter end node number (0 to "+max+"):\n");
            int f = sc.nextInt();
            
            bfs.simpleBFS(s, f, csra);
        }
        
        //executes bidirectional search
        else if(ch == 'c'){
            System.out.print("Enter starting node number (0 to "+max+"):\n");
            int s = sc.nextInt();
            
            System.out.print("Enter end node number (0 to "+max+"):\n");
            int f = sc.nextInt();
            
            bfs.BidirectionalSearch(s, f, csra, csrb);
        }

        //exits program
        else if(ch=='d'){
            flag++;
        }
        else{
            System.out.print("You need to choose a, b, c or d\n");
        }   
  }  
  System.out.print("Program exited succesfully");
}




    
}
