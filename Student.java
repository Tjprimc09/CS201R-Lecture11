public class Student extends Person {

    private  double gpa;
        
    Student(){
        super();
        type = 'S';
        gpa = 0.0;
    }
    Student(char t, String f, String l, int a, double g){
        super(f,l,a);
        type = t;
        gpa = g;
        totalStudent++;
    }

    //create all getters (accessors)
    public double getGPA(){return gpa;}
    
    //create all setters (mutators)
    public void setGPA(double g){this.gpa = g;}

    //create the print method
    @Override
    public String toString(){
        String out = String.format("%-5s%-15s%-15s%5d%10.2f\n",type,fname,lname, age, gpa);
        return out;
    }

    public static int totalStudent = 0;
            
}
