
Test plan:

------ Static testing (Requirements testing) ------
0. Fields types are not defined
1. Found missing requirement about distance equal (=) 30km (in requirements discussed only less 30 (<) and above 30 (>));
3. Found lack of information about distance - no min/max values;
3. Found lack of information about size of parcel - no exact values;
4. Found lack of information about size of parcel - no min/max values;

------ Dynamic testing ------
(Using white-box testing - decision testing (checking all if clauses))

Decision table technique 
(combined with equivalence technique -> used only 1 value from each group of parameters):
| Distance | Size | Fragile | Load | Final cost |
| <2       | <150 | false   | 1	   | <400       |
| <10      | >=150| true    | 1.2  | >=400      |
| <30      |      |         | 1.4  |            |      
| >30      |      |         | 1.6  |            | 

Combinations (min number of required cases - 4):
| Distance | Size | Fragile | Load | Final cost | Exp. result |
| 1        | 130  | false   | 1    | <400       | 400         |
| 5        | 170  | true    | 1.2  | >=400      | 720         |
| 15       | 50   | false   | 1.4  | >=400      | 420         | - final cost won't work
| 40       | 190  | true    | 1.6  | >=400      | 1280        | - final cost won't work
extra case (exceptional): 
| 35       | 30   | true    | 1    | >=400      | exception   | - fragule goods not allowed to deliver on more than 30km 

Bundary technique 
(could be added in decision table cases depending on available time for testing  
or if enought time be as separate cases (not to mix possible errors)
(also we could select 2 or 3 bound cases, depending on available time and risks)

Distance parameter:
         0                 <2                 <10                   <30
---------|-----------------|-------------------|---------------------|-------------------
 (-0.01)(0)(0.01)  (1.99)(2.0)(2.01)  (9.99)(10.0)(10.01)  (29.99)(30.0)(30.01)
	
Size parameter:
         0                 <150
---------|-------------------|---------------
    (-1)(0)(1)        (149)(150)(151)



Final list of all scenarios for testing:
| Distance | Size | Fragile | Load | Final cost | Exp. result |
                        positive scenarios
| 1.2      | 130  | false   | 1    | <400       | 400         |
| 5.05     | 170  | true    | 1.2  | >=400      | 720         |
| 15       | 50   | false   | 1.4  | >=400      | 420         | - final cost won't work
| 40       | 190  | false   | 1.6  | >=400      | 1280        | - final cost won't work
                      extra case (exceptional) 
| 35       | 30   | true    | 1    | >=400      | exception   | - fragule goods not allowed to deliver on more than 30km 
                       negative scenarios
| -2       | 30   | false   | 1    | >=400      | exception   | - distance is < 0
| 0        | 30   | false   | 1    | >=400      | exception   | - distance is = 0
| 4        | -3   | false   | 1    | >=400      | exception   | - size is < 0
| 11       | 0    | true    | 1    | >=400      | exception   | - size is = 0
| 18       | 160  | true    | 1.1  | >=400      | exception   | - invalid load value
                        boundary scenarios
| -0.01    | 30   | false   | 1    | >=400      | exception   | - distance is < 0
| 0.01     | 130  | false   | 1    | <400       | 400         |
| 4        | -1   | false   | 1    | >=400      | exception   | - size is < 0
| 13       | 1    | false   | 1.4  | >=400      | 420         |
...


+ Acceptance testing (select few most usefull cases for business), ex.
| Distance | Size | Fragile | Load | Final cost | Exp. result |
| 5        | 170  | true    | 1.2  | >=400      | 720         |
| 15       | 50   | false   | 1.4  | >=400      | 420         |
