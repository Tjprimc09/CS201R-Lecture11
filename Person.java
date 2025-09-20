public class Person {
    protected    char type;
    protected    String fname;
    protected    String lname;
    protected    int age;

    Person(){
        this("","",0);
        type = 'P';
        //fname = "";
        //lname = "";
        //age = 0;
    }
    Person(String f, String l, int a){
        type = 'P';
        fname = f;
        lname = l;
        age = a;
        totalPeople++;
    }

    //create all getters (accessors)
    public String getFName(){return fname;}
    public String getLName(){return lname;}
    public int getAge(){return age;}    
    
    //create all setters (mutators)
    public void setType(char t){type = t;}
    public void setFName(String fname){this.fname = fname;}
    public void setLName(String lname){this.lname = lname;}
    public void setAge(int a){age = a;}

    //create the print method
    public String printPerson(){
        String out = String.format("%-15s%-15s%5d\n",fname,lname, age);
        return out;
    }

    public static int totalPeople = 0;
            
}
