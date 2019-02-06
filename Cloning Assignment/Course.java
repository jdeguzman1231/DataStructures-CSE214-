/**
 * The <code>Course</code> class implements a <code>name</code>,
 * <code>department</code>,<code>code</code>,<code>section</code>,
 * <code>instructor</code> 
 * 
 * @author Joseph Deguzman
 * 		email: joseph.deguzman@stonybrook.edu
 * 		Stony Brook ID: 111720116
 *
 */
public class Course implements Cloneable
{
	private String name; //The name of the course
	private String department; //The department of the course
	private int code; //The course code
	private byte section; //The course section
	private String instructor; //The course instructor
	
	/**
	 * Constructs an instance of <code>Course</code> 
	 * with no parameters
	 * 
	 * There are no parameters, all of the elements can be set
	 * using the set methods below
	 * 
	 */
	public Course() 
	{
		
	}
	
	/**
	 * Constructs an instance of <code>Course</code> with specified
	 * parameters
	 * 
	 * @param name
	 * 	The name of the course
	 * @param department
	 * 	The department of the course
	 * @param code
	 * 	The course code
	 * @param section
	 * 	The course section
	 * @param instructor
	 * 	The course instructor
	 * 
	 * <dt>Precondition:
	 * 	<dd><code>code</code> must be greater than 100 and less than 999
	 * 	<dd><code>section</code> must be greater than 0 and less than 20
	 *
	 **/
	public Course(String name, String department, int code, byte section, String instructor)
	{
		this.name = name;
		this.department = department;
		this.code = code;
		this.section = section;
		this.instructor = instructor;
	}
	
	/**
	 * Get the course name
	 * @return
	 * 	Return the name of the course
	 * 
	 */
	public String getName()
    {
        return name;
    }
	
	/**
	 * Set the course name
	 * @param s
	 * 	The String that will be the course name
	 */
    public void setName(String s)
    {
        name = s;
    }
    
    /**
	 * Get the course department
	 * @return
	 * 	Return the department of the course
	 * 
	 */
    public String getDepartment()
    {
        return department;
    }
    
    /**
	 * Set the course name
	 * @param s
	 * 	The String that will be the course department
	 */
    public void setDepartment(String s)
    {
        department = s;
    }

    /**
	 * Get the course code
	 * @return
	 * 	Return the code of the course
	 * 
	 */
    public int getCode()
    {
        return code;
    }
    
    /**
	 * Set the course name
	 * @param i
	 * 	The int that will be the course code
	 * @exception IllegalArgumentException
	 */
    public void setCode(int i)
    {
    		if (i<100||i>999)
    		{
    			throw new IllegalArgumentException("Code is invalid");
    		}
        code = i;
    }

    /**
	 * Get the course section
	 * @return
	 * 	Return the section of the course
	 * 
	 */
    public byte getSection()
    {
        return section;
    }

    /**
   	 * Set the course section
   	 * @param b
   	 * 	The byte that will be the course code
   	 * @exception IllegalArgumentException
   	 */
    public void setSection(byte b)
    {
        section = b;
    }

    /**
	 * Get the course instructor
	 * @return
	 * 	Return the instructor of the course
	 * 
	 */
    public String getInstructor()
    {
        return instructor;
    }

    /**
	 * Set the course instructor 
	 * @param s
	 * 	The String that will be the course instructor
	 */
    public void setInstructor(String s)
    {
        instructor = s;
    }
    
    public Object clone()
    {
        Course newCourse = new Course();
        newCourse.setName(this.name);
        newCourse.setDepartment(this.department);
        newCourse.setCode(this.code);
        newCourse.setSection(this.section);
        newCourse.setInstructor(this.instructor);
        return newCourse;
    }
    
    /**
     * Checks if two courses are the same
     * 
     * @param obj
     * 	The Course that is checked with the other course
     * 
     * @return
     * 	True if the courses are the same in every aspect, false if otherwise.
     */
    public boolean equals(Object obj)
    {
        if (obj instanceof Course)
        {
        		Course tempCourse = (Course) obj;
            if (this.getName().equals(tempCourse.getName())&&
                    getDepartment().equals(tempCourse.getDepartment())&&
                    getCode()==tempCourse.getCode()&&
                    getSection()==tempCourse.getSection()&&
                    getInstructor().equals(tempCourse.getInstructor()))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        return false;
    }

}


