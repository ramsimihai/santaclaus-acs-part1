# santaclaus-acs-part1

321CA - Mihai Daniel Soare
Object Oriented Programming Course

Project Stage 1 - Santa Claus is coming to ACS

warning: i hate uppercases so i wont use them too much

January 2022

----------------------------------------------------------------------------------------------------


* Santa's workshop (aka Database)
    -  the program is an implementation of a singleton Database of a Santa's workshop
    that simulates the delivery of gifts to children in a noYears given in function of
    a corresponding budget for every children & a list of available gifts in the workshop

__Classes__

`fileio` 

- InputLoader -> input loader used to extract the input data from every JSON object and collect it
                into input classes such as:
                
              -> Input --> noYears (field)
              
                       --> santasBudget (field)
                       
                       --> field of InitialDataInput (class)   --> ChildrenInput
                       
                                                               --> GiftInput
                                                               
                       --> field of AnnualChangesInput (class) --> ChangeOfTheYear --> GiftInput
                       
                                                                                --> ChildrenInput
                                                                                
                                                                                --> ChildrenUpdates

all the input classes mentioned have the basic parameters for the real classes

- Writer -> used to open an output filed and write it into a JSONObject 

`main`
- Main -> implements 2 methods, this is actually the main program where the test files are opened
        the output tests are created and then every test is checked by the checker

`workshop`
- Santa -> implemented with lazy instantiation a Singleton that is going to be used as the main
            program. it simulates a delivery of gifts over a noYears to children in function
            of a given list of gifts.
        -> every year changes are made to the database and a simulation of delivery starts again
        -> contains the following fields:
        
                -> noYears of the over-all delivery simulation
                
                -> santasBudget the overall budget of santa
                
                -> initialData the initial Data extracted from the input (the first simulation)
                
                -> annualChanges the following noYears extracted data from the input (next noYears
                deivery)
                
                -> children -- a list of children that can receive gifts
                
                -> availableGifts -- a list of all available gifts that can be given to children
                
                -> actualYear -- field that contains the actual Year of the simulation to know
                
                what data should we use in the simulation
                
                -> budgetUnit -- something that is used to calculate every children budget
                

`memory`
- InitialData -> contains the initial data extracted from the input that is going to be added
                to the annual changes as "first change"

- AnnualChanges -> contains all the changes across the noYears

`updates`
- ChangeOfTheYear -> the actual change of the year that contains: a new budget for santa, 
                    a list of new children, a list of new gifts and a list of new children
                    updates

`children`
- Child -> contains the following:

            -> the fields representative for a child
            
            -> a niceScore list that is updated every year
            
            -> a strategy that calculates the averageScore of every children
            
            -> the initialBudget assigned to the child an auxiliary field for calculating
            the delivery of gifts
            
            -> a receivedGifts in every year
            
            -> a getJSON method to get an output JSONObject that contains all the data of
            the child
            
            -> basic methods

- ChildUpdates -> contains updates of a corresponding child every year

`scores`
- AverageScoreStrategy -> an interface used to get the averageScore for every child
- 
- AverageScoreStrategyFactory -> class used to create 4 different types of strategies
                                to calculate children averageScore
                                
                              -> they are the following:
                              
                                    -> BabyStrategy: they get a 10 out of 10
                                    
                                    -> KidStrategy: normal average
                                    
                                    -> TeenStrategy: some weird average based on a formula
                                    
                                    -> YoungAdultStrategy: they have a null strategy
                                    cause they arent wanted in the children list

`gift`
- Gift -> contains basic gifts information

`utils`
- Utils -> contains a convertJSONArray method that transforms an array of JSONs into an array
        of strings

`common`
Constants -> storing constants used in the implementation

----------------------------------------------------------------------------------------------------

* How to use the program

__Entry Point__

- A new fileWriter is instantiated to write in every output file made & a new JSONObject ALSO
that will contain the output written in the output files;

- Santa is instatiated firstly in `Main`, then the input of the Database is imported from
<InputLoader> to the corresponding fields from the Santa.

- The delivery starts by creating an JSONObject that is returned by the delivery method;

__Input__

- it was used the model used from the first Homework, gets data from JSONObjects extracted from
the tests and they are added to input classes;
- then data from the input classes are imported in the database, uhm santa's workshop (my bad);

__Tricks__

- Used some streams & comparators to sort children & gifts;
- Used LinkedHashSet to remove duplicates from a list in the old order;
- Used divide & impera to put my tasks into tiny task and so i've done the homework in 2 days;

__Design_Patterns__

- Sincerely this homework could be done without any patterns i dont really see their use,
because in the case of Strategy, there isnt a hard algorithm for every single strategy and ALSO
they could be addded in an actual method, anyways;

- used Singleton so I could get the santa instance everywhere, but anyways the delivery is
simulated in this class;
- used Strategy to create strategies of calculating averageScore in function of age category;
- used Factory to instantiate Strategies in function of age category;

__Delivery__

- iterates through all the noYears changes and starts the delivery for every year

There are 6 big steps to do the delivery in one year:

(1) -> makes children changes
    
(2) -> makes gift changes
    
(3) -> calculates the averageScore & initializes the budget assigned to every children
    
(4) -> delivering the gifts to every children of the list
    
(5) -> extracts the list of children and prepare it for output
    
(6) -> increments the age of kiddos (for the next year)

    
[ (1) ]
    
-> adds new children to the list (if it is the initial year it wouldnt happen)
    
-> delete young adults from the list of children
    
-> sort the children (the children might be unordered, but in the tests wouldnt happen)
    
-> update every child with the new info (if the child is found in the list)

[ (2) ]
    
-> add new gifts to the list (if it is the initial year it wouldnt happen)
    
-> sort gifts in function of category and ascending price cause the children gets the lowest
priced gifts from the category preferred by them

[ (3) ]
    
-> calculates the averageScore of every type of children by using a Strategy & Factory pattern
mentioned before
    
-> initialize the budget from where a child can get a priced gift

[ (4) ]
    
-> calculates the actual delivery of gifts to every children in that year
    
-> the actual delivery works like this:
    
    -> iterate through the list of kiddos
    
    -> clear the list of received gifts of every kiddo (cause this is a new year)
    
    -> iterate through prefferences of every kiddos & then through the list of available
    gifts
    
        -> if the gift is wanted add it to the children received gifts list
    
        -> decrease the assigned budget of that child to give him another gift

[ (5) ]
    
-> extract the output of the list of children to a JSONObject

[ (6) ]
    
-> if there is another year the kiddos years will be incremented

----------------------------------------------------------------------------------------------------

* Feedback

- this project was done in ~2 days ish aka 15hours of work. it was clearly easier than the first
homwork;
- sincerely i would really use commander in this project, but for real there is no point in doing
that, you could just create as many methods to actually do the specified little task for you
and we also do not need redo / undo;
- learnt how an input loader works, not so bad;
- learnt how to use a file writer;
- learnt how to organize my tasks more carefully;
- i appreciate the extra time on this deadline cause last months were horrible;
- let you some easter eggs, out there :);

----------------------------------------------------------------------------------------------------
