import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        System.out.println("Welcome to classes!");

        //define file values
        ArrayList<Person> people = new ArrayList<>(); // initializing a new empty ArrayList of type Person called people. Stores Person objects and objects of any subclasses of Person, such as Student.
        
        //CREATE A STUDENT OBJECT USING OVERLOADED CONSTRUCTOR
        Student s1 = new Student('S', "Mahomes","Patrick", 29, 3.5); // creates a new Student object using the overloaded constructor.
        System.out.println(s1.toString()); // print the string representation of the Student object s1 to the console. Using the toString() method defined in the Object class, which is overridden in the Student class.

        //CREATE A STUDENT OBJECT USING DEFAULT CONSTRUCTOR
        Student s2 = new Student(); // creating a second student object using overridden default constructor.

        // then SETTING the values using the setter methods
        s2.setType('S');
        s2.setLName("Kelce");
        s2.setFName("Travis");
        s2.setAge(35);
        s2.setGPA(3.4);

        Person px = new Person("Bubba", "Gump", 50); // creating a new Person object using the overloaded constructor. This object is not added to the people ArrayList, but it demonstrates that we can create Person objects as well as Student objects.
        
        //PRINT OBJECTS 
         System.out.print(s1); // printing the students
         System.out.print(s2);
         System.out.print(px); // printing the person object

        people.add(s1);// adding the students to the people ArrayList. Since Student is a subclass of Person, we can add Student objects to an ArrayList of type Person.
        people.add(s2);
        people.add(px);



        try { // try to stream the file and catch any exceptions that may occur if the file is not found.
            File inFile = new File("people.txt"); // create a new file object
            Scanner scanner = new Scanner(inFile); // create a new scanner object with the file object as an argument.

            //input values from a file & add to people
            if (loadArrayList(people, scanner) == -1){ // calling the loadArrayList method (defined further down), using people and scanner as arguments. If the method returns -1, it indicates that there was an error. 
                System.out.println("Input is not valid");
            }
            
            System.out.println("\nPRINT ALL PEOPLE USING OBJECT PRINTPERSON");
            for (Person p : people){
                System.out.print(p);
            }
            System.out.println("Total People:   " + Person.totalPeople);
            System.out.println("Total Students: " + Student.totalStudent);

            System.out.println("\nPRINT ALL PEOPLE USING GETTERS");
            for (Person p : people){
                System.out.print(p);
            }

            System.out.println("\nPRINT ONLY STUDENTS");
            //using instanceof to print only
            for (Person p : people){
                if (p instanceof Student)
                    System.out.print(p);
            }
            scanner.close();
        }

        catch (FileNotFoundException e){
            System.out.println("Unable to open file");
        }
         
    }

    public static int loadArrayList(ArrayList<Person> people, Scanner input){

        String inputLine, f, l;
        int a;
        double g;
 
        while (input.hasNextLine()){ // as long as there is more input
            //get the next line of input from the file
            inputLine = input.nextLine(); // get the next line of input from the file and store it in the variable inputLine.
            String[] tokens = inputLine.split(","); // break the line into tokens using the comma as a delimiter and store the tokens in an array of strings called tokens.

            //check that the number of tokens includes row & colum
            if (tokens[0].equals("P") && tokens.length < 4){ //if there are less than 4 tokens and the first token is "P", it indicates that the input line does not have enough information to create a Person object. In this case, the method returns -1 to indicate an error.
                return -1;
            } 
            if (tokens[0].equals("S") && tokens.length < 5){ // if there are less than 5 tokens and the first token is "S", it indicates that the input line does not have enough information to create a Student object. In this case, the method also returns -1 to indicate an error.
                return -1;
            } 
            f = tokens[2]; // assign the third token (index 2) to the variable f, which represents the first name of the person.
            l = tokens[1]; // assign the second token (index 1) to the variable l, which represents the last name of the person.

            if (tokens[0].equals("P")){
                try{
                    a = Integer.parseInt(tokens[3]); // a = Integer.parseInt(tokens[3]) attempts to convert the fourth token (index 3) from a string to an integer and assigns it to the variable a, which represents the age of the person. If the conversion fails (e.g., if the token is not a valid integer), it will throw a NumberFormatException, which is caught in the catch block.
                    Person newPerson = new Person(f,l,a); // creates a new Person IN THE TRY BLOCK using the overloaded constructor with the first name, last name, and age as arguments.
                    people.add(newPerson); // adds the newly created Person object to the people ArrayList. Since the Person class is a superclass of Student, we can add Person objects to an ArrayList of type Person.
                }
                catch(NumberFormatException e){ // if a NumberFormatException is thrown (e.g., if the age token is not a valid integer), the catch block will execute, printing an error message that includes the original input line that caused the error. This helps identify which line in the input file had invalid data.
                    System.out.println("Error in the line: " + inputLine);
                }
            }
            else if (tokens[0].equals("S")){ //otherwise, if the first token is "S", it indicates that we are trying to create a Student object. In this case, we need to parse both the age and the GPA from the input line.
                try{ // try to parse the age and GPA, and catch any NumberFormatException that may occur if the tokens are not valid numbers.
                    a = Integer.parseInt(tokens[3]);
                    g = Double.parseDouble(tokens[4]);
                    //Student newPerson = new Student('S',f,l,a,g);
                    //people.add(newPerson);
                    Person newPerson2 = new Student('S',f,l,a,g);
                    people.add(newPerson2);
                }
                catch(NumberFormatException e){ // if a NumberFormatException is thrown (e.g., if the age or GPA tokens are not valid numbers), the catch block will execute, printing an error message that includes the original input line that caused the error. This helps identify which line in the input file had invalid data.
                    System.out.println("Error in the line: " + inputLine);
                }
            }

       }
                   
       return 1;
    }
      
}

