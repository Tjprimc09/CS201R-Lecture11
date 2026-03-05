import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        System.out.println("Welcome to classes!");

        //define file values
        ArrayList<Person> people = new ArrayList<>();
        
        //CREATE A STUDENT OBJECT USING OVERLOADED CONSTRUCTOR
        Student s1 = new Student('S', "Mahomes","Patrick", 29, 3.5);
        System.out.println(s1.toString());

        //CREATE A STUDENT OBJECT USING DEFAULT CONSTRUCTOR
        Student s2 = new Student();
        s2.setType('S');
        s2.setLName("Kelce");
        s2.setFName("Travis");
        s2.setAge(35);
        s2.setGPA(3.4);


        //PRINT OBJECTS 
         System.out.print(s1);
         System.out.print(s2);

        people.add(s1);
        people.add(s2);

        try {
            File inFile = new File("people.txt");
            Scanner scanner = new Scanner(inFile);

            //input values from a file & add to people
            if (loadArrayList(people, scanner) == -1){
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
 
        while (input.hasNextLine()){
            //get the next line of input from the file
            inputLine = input.nextLine();
            String[] tokens = inputLine.split(",");

            //check that the number of tokens includes row & colum
            if (tokens[0].equals("P") && tokens.length < 4){
                return -1;
            } 
            if (tokens[0].equals("S") && tokens.length < 5){
                return -1;
            } 
            f = tokens[2];
            l = tokens[1];

            if (tokens[0].equals("P")){
                try{
                    a = Integer.parseInt(tokens[3]);
                    Person newPerson = new Person(f,l,a);
                    people.add(newPerson);
                }
                catch(NumberFormatException e){
                    System.out.println("Error in the line: " + inputLine);
                }
            }
            else if (tokens[0].equals("S")){
                try{
                    a = Integer.parseInt(tokens[3]);
                    g = Double.parseDouble(tokens[4]);
                    //Student newPerson = new Student('S',f,l,a,g);
                    //people.add(newPerson);
                    Person newPerson2 = new Student('S',f,l,a,g);
                    people.add(newPerson2);
                }
                catch(NumberFormatException e){
                    System.out.println("Error in the line: " + inputLine);
                }
            }

       }
                   
       return 1;
    }
      
}

