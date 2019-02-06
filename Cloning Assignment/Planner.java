/**
 * The <code>Planner</code> class implements an abstract
 * data type for a list of courses supporting some common
 * operations on such lists.
 * 
 * @author Joseph Deguzman
 * 		email: joseph.deguzman@stonybrook.edu
 * 		Stony Brook ID: 111720116
 *
 */
public class Planner implements Cloneable{
	private Course[] courseArray; //An array holding the courses in the planner
	private static int MAX_COURSES = 50; //A constant holding the maximum number of courses in the planner
	
	/**
	 * Constructs an instance of <code>Planner</code> with no 
	 * <code>Course</code> objects in it.
	 * 
	 * <dt>Postconditions:
	 * 	<dd>This Planner has been intialized to an empty list of Courses.
	 * 
	 * 
	 **/
	public Planner()
	{
		courseArray = new Course[MAX_COURSES];
	}
	
	/**
	 * Gets the size of the planner
	 *
	 * <dt>Preconditions:
	 * 		This Planner has been instantiated.
	 * @return 
	 * 	The number of Courses in the Planner
	 * 	courses were added to the it. 
	 */
	public int size()
	{
		int counter = 0;
		for (int i = 0; i < courseArray.length; i++)
		{
			if (courseArray[i] instanceof Course)
			{
				counter++;
			}
		}
		return counter;
	}
	
	/**
	 * Adds a new course to the planner in a specified position
	 * 
	 * @param newCourse
	 * 	The course to get added to the planner
	 * @param position
	 * 	The position of where the course gets added in the list
	 * 
	 * <dt>Preconditions:
	 * 	<dd>This Course object has been instantiated and position >= 1 and position <=size()+1 
	 * 		The number of Course objects in this Planner is less than MAX_COURSES
	 * <dt>Postconditions:
	 * 	<dd>newCourse has been added to the courseArray in the specified position.
	 * 		All of the previous values whose position is greater than or equal to
	 * 		the specified position shift down one position. 
	 * @throws IllegalArgumentException 
	 * 			Indicates that position is not within the valid range.
	 * 			FullPlannerException
	 * 			Indicates that there is no more room in the Planner to record an additional Course.
	 * 
	 * position refers to the position in the Planner and not in the array
	 * 
	 */
	public void addCourse(Course newCourse, int position) throws FullPlannerException
	{
		if (position <= 0 || position > this.size()+1)
		{
			throw new IllegalArgumentException("Position is not valid");
		}
		
		if (size()>=MAX_COURSES)
		{
			throw new FullPlannerException("The Planner is full");
		}
		for (int i = courseArray.length-1; i >= position; i--)
		{
			courseArray[i] = courseArray[i-1];
		}
		courseArray[position-1] = newCourse;
		
	}
	
	/**
	 * Adds a new course to the planner at the end of all of the previously
	 * input courses
	 * 
	 * @param newCourse
	 * 	The course to get added to the planner
	 * 
	 * <dt>Preconditions:
	 * 	<dd>newCourse is a Course object
	 * 
	 * <dt>Postconditions:
	 * 	<dd>newCourse has been added to the courseArray at the end of the 
	 * 		already added courses, it takes the next available open space
	 * @throws FullPlannerException 
	 */
	public void addCourse(Course newCourse) throws FullPlannerException
	{
		addCourse(newCourse, this.size()+1);
	}
	
	/**
	 * Removes a course from a specified position
	 * 
	 * @param position
	 * 	The position of the course that is to be removed
	 * 
	 * <dt>Preconditions:
	 * 	<dd>position is greater than 0 and less than or equal to the size()
	 * 
	 * <dt>Postconditions
	 * 	<dd>The course located at the specified position is removed and all
	 * 		elements ahead of it in the list move down so there are no spaces
	 * 		in between any courses
	 * 
	 * @exception IllegalArgumentException
	 */
	public void removeCourse(int position)
	{
		for (int i = position-1; i<courseArray.length - 1; i++)
		{
			courseArray[i] = courseArray[i+1];
		}
	}
	
	/**
	 * Gets a course from a specified position
	 * 
	 * @param position 
	 * 	The position of the Course that is taken
	 * 
	 * @return
	 * 	Course at the specified position
	 * 
	 * @throw IllegalArgumentException
	 **/
	public Course getCourse(int position)
	{
		if (position <= 0 || position > this.size()+1)
		{
			throw new IllegalArgumentException("Position is not valid");
		}
		return courseArray[position-1];
	}
	/**
	 * Prints all Courses that are within the specified department.
	 * 
	 * 
	 * 
	 * @param planner
	 * 	The list of courses to search in
	 * @param department
	 * 	The 3 letter department code for a Course
	 */
	public static void filter(Planner planner, String department)
	{
		String s = "";
		for (int i = 0; i<planner.size(); i++)
		{
			if (planner.courseArray[i].getDepartment().equals(department))
			{
				s = s + String.format("%-4d%-26s%-12s%-6d%-8d%-2s", i+1, planner.courseArray[i].getName(), planner.courseArray[i].getDepartment(), 
						planner.courseArray[i].getCode(), planner.courseArray[i].getSection(), 
						planner.courseArray[i].getInstructor()) + "\n"; 
			}
		}
		System.out.print(s);
	}
	
	/**
	 * 	Checks to see if a course is in the Planner 
	 * 
	 * @param course
	 * 	The course that gets checked if it is in the Planner
	 * 
	 * @return
	 * 	True if the course is in the Planner, False if it is not
	 * 
	 * @exception IllegalArgumentException
	 **/
	public boolean exists(Course course)
	{
		for (int i = 0; i<size(); i++)
		{
			if (courseArray[i].equals(course))
			{
				return true;
			}
		}
		return false;
	}
	
	
	public Object clone()
	{
		Planner plannerClone = new Planner();
		for (int i = 0; i<this.size(); i++)
		{
			Course tempCourse = (Course) courseArray[i].clone();
			try 
			{
				plannerClone.addCourse(tempCourse);
			} catch (FullPlannerException e) 
			{
				System.out.println("Please try again");
			}
		}
		return plannerClone;
	}
	
	/**
	 * Prints all of the courses in a list
	 * 
	 */
	public void printAllCourses()
	{
		System.out.print(this.toString());
	}
	
	/**
	 * Takes all of the courses and displays their information into one string
	 * 
	 * @return
	 * 	A String that is concatenated over a loop to create one big list of all
	 * 	of the courses (String representation of the Planner object)
	 * 
	 */
	public String toString()
	{
		String s = "";
		for (int i = 0; i<this.size(); i++)
		{
			s = s + String.format("%-4d%-26s%-12s%-6d%-8d%-2s", i+1, this.courseArray[i].getName(), this.courseArray[i].getDepartment(), 
									this.courseArray[i].getCode(), this.courseArray[i].getSection(), 
									this.courseArray[i].getInstructor()) + "\n"; 
		}
		return s;
	}
	
	/**
	 * 
	 * @param course
	 * 	The course that we are interested in finding the position.
	 * 
	 * @return
	 * 	The position of the course if it is in the Planner, 0 if it is not. 
	 * 
	 **/
	public int getPosition(Course course)
	{
		for (int i = 0; i<size(); i++)
		{
			if (courseArray[i].equals(course))
			{
				return i+1;
			}
		}
		return 0;
	}
}
