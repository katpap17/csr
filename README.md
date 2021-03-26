# AreTheyFriends

AreTheyFriends is an app for asking "friendship" questions in social networks. It reads social networks in graph form and converts to [compressed-sparse-rows](https://en.wikipedia.org/wiki/Sparse_matrix#Compressed_sparse_row_(CSR,_CRS_or_Yale_format). 
## Compilation

Compile using: 

```console
javac SourceAndTarget.java CompressedSparseRows.java BFS.java CsrTester.java
```

## Execution

Execute using:

```console

java CsrTester

```

Program will ask for a file path:

```console

Welcome to AreTheyFriends! Please enter a file path:

```

Program accepts text files (.txt):

```console

myfile.txt

```

Program will then make a csr: 

```console

Making CSR...

```

When the csr creation is complete, the user can choose what to do: 

```console

CSR created! What do you want to do?
a: Find out a node's neighbors
b: Find out if two nodes are connected and how long tha path between them is
c: Exit program
```


### Option a


```console

Enter a node number:
```

### Option b


```console

Enter starting node number:

```



```console

Enter end node number:

```
### Option c


```console
Program exited succesfully
```

## Output

### Option a

```console
Node 0 is connected to node 1.
Node 0 is connected to node 2.
Node 0 is connected to node 3.
```

```console
Node 0 is connected to no nodes
```
### Option b


```console
The path exists and the nodes are connected through 1 vertices
Execution time is 24 millisecons

```


```console
The path does not exist.
Execution time is 2 millisecons

```

## Contributing

Papapostolou Katerina
