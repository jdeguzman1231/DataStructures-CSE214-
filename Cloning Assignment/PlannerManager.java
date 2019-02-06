/**
 * The <code>PlannerManager</code> class creates an empty Planner object
 * and prompts the user for various commands.
 * 
 * 
 * @author Joseph Deguzman
 * 		email: joseph.deguzman@stonybrook.edu
 * 		Stony Brook ID: 111720116
 *
 */
import java.util.Scanner;
public class PlannerManager {
	public static void main(String[] args)
	{
		Planner planner = new Planner();
		Planner plannerBackup = new Planner();
		Scanner scan = new Scanner(System.in);
		String s = "";
		String line = "-------------------------------------------------------------------------------\n";
		try {
			while(!s.equals("Q"))
			{
				System.out.println("(A) Add Course");
				System.out.println("(G) Get Course");
				System.out.println("(R) Remove Course");
				System.out.println("(F) Filter by Department Code");
				System.out.println("(L) Look For Course");
				System.out.println("(S) Size");
				System.out.println("(B) Backup");
				System.out.println("(PB) Print Courses in Backup");
				System.out.println("(RB) Revert to Backup");
				System.out.println("(Q) Quit");
				System.out.println();
				System.out.println("Enter a selection: ");
				s = scan.next().toUpperCase();
				if (s.equals("A"))
				{
					scan.nextLine();
					System.out.println("Enter course name: ");
					String courseName = scan.nextLine();
					System.out.println("Enter department: ");
					String courseDepartment = scan.nextLine();
					System.out.println("Enter course code: ");
					int courseCode = scan.nextInt();
					System.out.println("Enter course section: ");
					byte courseSection = scan.nextByte();
					scan.nextLine();
					System.out.println("Enter instructor: ");
					String courseInstructor = scan.nextLine();
					System.out.println("Enter position: " );
					int position = scan.nextInt();
					Course tempCourse = new Course(courseName, courseDepartment, courseCode, courseSection, courseInstructor);
					try {
						planner.addCourse(tempCourse, position);
						System.out.println(courseDepartment + " " + courseCode + ".0" + courseSection + " successfully added to the planner.");
					} catch (FullPlannerException e) {
						System.out.println("Planner is full");
					} catch (IllegalArgumentException i) {
						System.out.println("Invalid position");
					}
					System.out.println();
				}
				else if (s.equals("G"))
				{
					scan.nextLine();
					System.out.println("Enter position: ");
					int pos = scan.nextInt();
					Course tempCourse = planner.getCourse(pos);
					System.out.print(String.format("%-4s%-26s%-12s%-6s%-8s%-2s", "No.", 
							"Course Name", "Department", 
							"Code", "Section", 
							"Instructor") + "\n"); 
					System.out.print(line);
					System.out.print(String.format("%-4d%-26s%-12s%-6d%-8d%-2s", pos, 
							tempCourse.getName(), tempCourse.getDepartment(), 
							tempCourse.getCode(), tempCourse.getSection(), 
							tempCourse.getInstructor()) + "\n"); 
					System.out.println("");
				}
				else if (s.equals("R"))
				{
					scan.nextLine();
					System.out.println("Enter position: ");
					int pos = scan.nextInt();
					Course tempCourse = (Course) planner.getCourse(pos).clone();
					planner.removeCourse(pos);
					System.out.println(tempCourse.getDepartment() + " " + tempCourse.getCode() + ".0" + 
					tempCourse.getSection() + " has been successfully removed from the planner.");
				}
				else if (s.equals("P"))
				{
					System.out.println("Planner:");
					System.out.print(String.format("%-4s%-26s%-12s%-6s%-8s%-2s", "No.", 
							"Course Name", "Department", 
							"Code", "Section", 
							"Instructor") + "\n"); 
					System.out.print(line);
					scan.nextLine();
					planner.printAllCourses();
				}
				else if (s.equals("F"))
				{
					scan.nextLine();
					System.out.println("Enter department code: ");
					String department = scan.nextLine();
					System.out.print(String.format("%-4s%-26s%-12s%-6s%-8s%-2s", "No.", 
							"Course Name", "Department", 
							"Code", "Section", 
							"Instructor") + "\n"); 
					System.out.print(line);
					Planner.filter(planner, department);
				}
				else if (s.equals("L"))
				{
					scan.nextLine();
					System.out.println("Enter course name: ");
					String courseName = scan.nextLine();
					System.out.println("Enter department: ");
					String courseDepartment = scan.nextLine();
					System.out.println("Enter course code: ");
					int courseCode = scan.nextInt();
					System.out.println("Enter course section: ");
					byte courseSection = scan.nextByte();
					scan.nextLine();
					System.out.println("Enter instructor: ");
					String courseInstructor = scan.nextLine();
					Course tempCourse = new Course(courseName, courseDepartment, courseCode, courseSection, courseInstructor);
					boolean test = planner.exists(tempCourse);
					if (test==true)
					{
						System.out.println(courseDepartment + " " + courseCode + ".0" + courseSection + " is found in the planner at position " + planner.getPosition(tempCourse));
					}
					else
					{
						System.out.println("That course is not in the planner.");
					}
				}
				else if (s.equals("S"))
				{
					scan.nextLine();
					System.out.println("There are " + planner.size() + " courses in the planner.");
				}
				else if (s.equals("B"))
				{
					scan.nextLine();
					plannerBackup = (Planner) planner.clone();
					System.out.println("Created a backup on the current planner.");
				}
				else if (s.equals("PB"))
				{
					scan.nextLine();
					System.out.print(String.format("%-4s%-26s%-12s%-6s%-8s%-2s", "No.", 
							"Course Name", "Department", 
							"Code", "Section", 
							"Instructor") + "\n"); 
					System.out.print(line);
					plannerBackup.printAllCourses();
				}
				else if (s.equals("RB"))
				{
					scan.nextLine();
					planner = (Planner) plannerBackup.clone();
					System.out.println("Planner successfully reverted to the backup copy.");
				}
			System.out.println();
			}
		}
		catch(IllegalArgumentException e) 
		{
			System.out.println("Please enter a different value");
		}
	System.out.println("Program terminating successfully...");
	scan.close();
	}
}
