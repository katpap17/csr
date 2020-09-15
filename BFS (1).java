import java.util.*;

public class BFS{

    
    public void BidirectionalSearch (int s, int f, CompressedSparseRows csra, CompressedSparseRows csrb){
      
      //calculates when program starts
      long start = System.currentTimeMillis();
      
      //checks if neighbor is found
      boolean found = false;
      
      //stores colour of nodes
      String[] coloura = new String[csra.getVertices().size()];
      String[] colourb = new String[csrb.getVertices().size()];
      
      //stores relative position of nodes
      Integer [] da = new Integer [csra.getVertices().size()];
      Integer [] db = new Integer [csrb.getVertices().size()];
      
      //sets starting values for nodes
      for(int i=0; i<(csra.getVertices().size()); i++){
            coloura[i]="white";
            da[i] = null;
        }
      for(int i=0; i<(csrb.getVertices().size()); i++){
            colourb[i]="white";
            db[i] = null;
        }
      //creates new queue
      Queue<Integer> queueA = new LinkedList<Integer>();
      Queue<Integer> queueB = new LinkedList<Integer>();
      
      //adds starting node to queueA
      coloura[s] = "grey";
      da[s] = 0;
      queueA.add(s);
      
      //adds end node to queueB
      colourb[f] = "grey";
      db[f] = 0;
      queueB.add(f);
      
      //while queues are not empty and neighbor has not been found execute BidirectionalSearch
      while((!queueB.isEmpty()||!queueA.isEmpty())&&!found){
        if(!found){
        found=pathFinder(queueA, da, db, coloura, colourb, f, csra.getEdges(), csra.getVertices());
        }
        if(!found){
        found=pathFinder(queueB, db, da, colourb, coloura, s, csrb.getEdges(), csrb.getVertices());
        }
        }
        
      //if neighbour was not found
      if(found==false){
        System.out.print("The path does not exist.\n");
    }
    
    //calculates program duration time
    long duration = System.currentTimeMillis() - start;
    
    System.out.print("Execution time is "+duration+" millisecons\n"); //prints program duration time
    
    }
    
    
    private boolean pathFinder(Queue<Integer> queue, Integer[] d, Integer[]dRev, String[] colour, 
    String[] colourRev, int z, ArrayList<Integer> edge, ArrayList<Integer> vert){
        
        //if queue is not empty
        if(!queue.isEmpty()){
        
        //removes first node in queue and stores it in variable u
        int u = queue.poll();
        
        //calculates number of adjascent nodes from vertices table
        int numAdj = (vert.get(u+1)) - (vert.get(u));
          
        //for every neighbor v of u do..
        for(int i=0; i<numAdj; i++){
                
            //gets neighbor from edge table
            int edgePos = vert.get(u);
            int v = edge.get(edgePos+i);
                    
                //checks if node has already been visited
                if(colour[v] == "white"){
                    colour[v] = "grey";
                    d[v] = d[u]+1;
                    
                    //checks if sides of search met 
                    if(colourRev[v] == "grey"){
                        int path = d[v]+dRev[v];
                        System.out.print("The path exists and the nodes are connected through "+path+" vertices\n");
                        return true;
                    }
                    //adds node to queue
                    queue.add(v);
                
                }
        }
        colour[u] = "black";
        }
        return false;
    }

    public void simpleBFS (int s, int f, CompressedSparseRows csr){
      
      //calculates when program starts
      long start = System.currentTimeMillis();
      
      //checks if neighbor is found
      int br = 0;
      
      //stores colour of nodes
      String[] colour = new String[csr.getVertices().size()];
      
      //stores relative position of nodes
      Integer [] d = new Integer [csr.getVertices().size()];
      
      //sets starting values for nodes
      for(int i=0; i<(csr.getVertices().size()); i++){
            colour[i]="white";
            d[i] = null;
        }
      
      //creates new queue
      Queue<Integer> queue = new LinkedList<Integer>(); 
      
      //adds starting node to queue
      colour[s] = "grey";
      d[s] = 0;
      queue.add(s);
      
      //while queue is not empty and neighbor has not been found
      while(!queue.isEmpty()&&br==0){
        
        //sets u as the first node in the queue
        int u = queue.poll();
        
        //calculates number of adjascent nodes from vertices table
        int numAdj = (csr.getVertices().get(u+1)) - (csr.getVertices().get(u));
        
        //for every neighbor v of u do..
        for(int i=0; i<numAdj; i++){
            
            //gets neighbor from edge table
            int edgePos = csr.getVertices().get(u);
            int v = csr.getEdges().get(edgePos+i);
                
                //checks if node has already been visited
                if(colour[v] == "white"){
                    colour[v] = "grey";
                    d[v] = d[u]+1;
                    
                    //checks iif node is the one we are looking for
                    if(v==f){                    
                        System.out.print("The path exists and the nodes are connected through "+d[v]+" vertices\n");
                        i=numAdj;
                        br++;
                    }
                    //adds node to queue
                    queue.add(v);
            
                }
        }
        
        
        colour[u] = "black";
   
    }
      //if neighbour was not founf
      if(br==0){
        System.out.print("The path does not exist.\n");
    }
    
    //calculates program duration time
    long duration = System.currentTimeMillis() - start;
    
    System.out.print("Execution time is "+duration+" millisecons\n"); //prints program duration time
      
}
      
}
        
        

