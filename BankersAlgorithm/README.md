____
#### BANKER'S ALGORITHM DEADLOCK MANAGEMENT TECHNIQUE
___
The banker’s algorithm is a resource allocation and deadlock avoidance algorithm that tests for safety by simulating the allocation for predetermined maximum possible amounts of all resources, then makes an “s-state” check to test for possible activities, before deciding whether allocation should be allowed to continue.

#### HOW IT WORKS
This program accept the following as inputs

- allocation matrix values
- max matrix values
- available matrix values
- The value for all the tracks

After accepting the input it then compute the following
- Calculate need

    Which is `CalcNeed() method`
- Check allocation

    Which is `check_allocatable() method`

- Check if dead will occur or not

    Which is `checkSafety() method`


After the computation, the program then display the following
- `Need matrix values`
- `If safe state or not`


##### RUN CODE
To run the this program. You should
copy the entire contents of  the folder into a project in the IDE or Text Editor, and then run the Main.java in the folder.
 ___


____
