package child;

public class Child
{
    private int age;
    private boolean male;

    public Child(int age, boolean male)
    {
        this.age = age;
        this.male = male;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public boolean isMale()
    {
        return male;
    }

    public void setMale(boolean male)
    {
        this.male = male;
    }
    
    //Nye metoder
    public String gender() {
    	String sex = " ";
    	if(this.male == true)
    		sex = "Boy";
    	if(this.male == false)
		sex = "Girl";
    	
    	return sex;
    }
    
    public String team() {
    	String team = " ";
    	
    	if (this.male == true) {
    		if (age < 8 ) {
    			team = "Young boys";
    		}
    		else if(this.male == true) {
        		if (age >= 8 ) {
        			team = "Cool boys";
        		}
    		}
    	}
    	
    	if (this.male == false) {
    		if (age < 8 ) {
    			team = "Tumbling girls";
    		}
    		else if(this.male == false) {
        		if (age >= 8 ) {
        			team = "Springy girls";
        		}
    		}
    	}
    	
    	return team;
    	
    }
    
    public String institution()
    {
        String str = " ";
        
        if (age == 0)
        	str = "Home";
        else if (age >= 1 && age <=2)
        	str = "Nursery";
        else if (age >= 3 && age <=5)
        	str = "Kindergarten";
        else if (age >= 6 && age <=16)
        	str = "School";
        else if (age >= 17)
        	str = "Out of School";
        
        return str; 
    }

}
