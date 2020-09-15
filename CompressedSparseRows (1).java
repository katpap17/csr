

import java.util.*;

public class CompressedSparseRows {


    private ArrayList<SourceAndTarget> sat; //arraylist that contains the source and target objects

    private ArrayList<Integer> edges;   //edges array

    private ArrayList<Integer> vertices;    //vertices array

    //constructor that creates instance
    public CompressedSparseRows(){

        sat=new ArrayList<SourceAndTarget>();
        edges = new ArrayList<Integer>();
        vertices = new ArrayList<Integer>();
    } 

    //method that adds SourceAndTarget objects to ArrayList sat
    public void addSat(String a, String b){
    
        int x = Integer.parseInt(a); //converts strings from txt file to integers 
        int y = Integer.parseInt(b);
        SourceAndTarget st = new SourceAndTarget(x, y); //creates new source and target object
        sat.add(st); //adds object to arraylist
    }


    //method that sorts array items according to source
    public ArrayList<SourceAndTarget> sortSat(){
        //compares all nodes 
        for(int j=0; j<sat.size()-1; j++){
            for(int i=j+1; i<sat.size(); i++){
                //checks if a node's source is greater than another one's(that is in a greater position)
                if((sat.get(j)).getSource()>(sat.get(i)).getSource()){ 
                    //swaps source and targets
                    int c = (sat.get(j)).getSource();
                    int d = (sat.get(j)).getTarget();
                    sat.get(j).setSource((sat.get(i)).getSource());
                    sat.get(j).setTarget((sat.get(i)).getTarget());
                    sat.get(i).setSource(c);
                    sat.get(i).setTarget(d);
                }
            }
        }
        return sat;
    } 
 
    //creates edges array
    public ArrayList<Integer> createEdges (){
        
        for(int i =0; i<sat.size(); i++){
            edges.add(sat.get(i).getTarget());
        }
        
        return edges;
    
    }
    
    
        //returns edges
    public ArrayList<Integer> getEdges(){
        return this.edges;
    }
    
    
      //return max element of sat
    public int findMax (){
        
        int max = 0;
        for (int i=0;i<sat.size();i++){
            if (max<sat.get(i).getSource()){
                max = sat.get(i).getSource();
            }
            if (max<sat.get(i).getTarget()){
                max = sat.get(i).getTarget();
            }
        }
        return max;
    } 
 
   
    
    //creates vertices array
    public ArrayList<Integer> createVertices (int max){
        
        vertices.add(0); // first = 0
        int nonZero = 0; // counts total amount of nonZero elements
        
        for (int i=0;i<=max;i++){ 
            for (int j=0;j<sat.size();j++)
                if (sat.get(j).getSource() == i) { //if current node has one or more neighbors..
                    nonZero++;
                }
            vertices.add(nonZero); //adds total nonZero elements untill current line
        }
        vertices.add(nonZero+1);  //adds one more cell to verices array for convenience
        return vertices;
    }
    

    
    //returns vertices
    public ArrayList<Integer> getVertices(){
        return this.vertices;
    }
    
    //searches neighbors
    public void navigate(int u){
    
        int numAdj = (vertices.get(u+1)) - (vertices.get(u)); //gets number of neighbors
    
        //for every neighbor v of s do..
        for(int i=0; i<numAdj; i++){
            
            //gets neighbor from edge table
            int edgePos = vertices.get(u);
            int v = edges.get(edgePos+i);
        
            //prints neighbor
            System.out.print("Node "+u+" is connected to node "+v+".\n");
        }
        
        //checks if there are no neighbors
        if(numAdj==0){
            System.out.print("Node "+u+" is connected to no nodes\n");
        }
    
    }
    
}


      
      
