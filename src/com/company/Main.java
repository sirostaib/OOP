package com.company;
import java.util.*;
import javax.swing.*;
import java.io.IOException;


/*
 *
 *
 *           Object Oriented Programming
 *           University Management System
 *
 *
 *           This code is written by:
 *
 *               Siroz Ali Taib
 *               Zheer Ardalan
 *               San Akram
 *               Ahmad Safaa
 *
 *           Section Two
 *           Third Year
 *
 *
 * */


class Section{

    private int sectionNum;
    private ArrayList< StudentAccount > students;

    public Section(){
        students = new ArrayList<StudentAccount>();
    }

    public ArrayList<StudentAccount> getStudents() {
        return students;
    }

    public void setStudents(StudentAccount students) {
        this.students.add( students );
    }

    public int getSectionNum() {
        return sectionNum;
    }

    public void setSectionNum(int sectionNum){
        this.sectionNum = sectionNum;
    }

}


class Department{

    private String departmentName;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Department(String d){
        departmentName = d;
    }
    public Department(){
        departmentName = "Null";
    }


}

class Account{


    private String email;
    private String fullName;
    private String password;


    public Account(String e, String fn, String p){

        email = e;
        fullName = fn;
        password = p;

    }
    public Account(){

    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }





}

class StaffAccount extends Account{


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    private String role;

    public StaffAccount(String e, String fn, String p, String r){
        super(e, fn, p);
        role = r;
    }


}

class StudentAccount extends Account{


    public String getMatricID() {
        return matricID;
    }

    public void setMatricID(String matricID) {
        this.matricID = matricID;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }



    public int getStudyYear() {
        return studyYear;
    }

    public void setStudyYear(int studyYear) {
        this.studyYear = studyYear;
    }

    private String matricID;
    private int age;

    private int studyYear;

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    private String section;

    public String getMyDepartment() {
        return myDepartment.getDepartmentName();
    }

    public void setMyDepartment(Department myDepartment) {
        this.myDepartment = myDepartment;
    }

    private Department myDepartment;
    // courses[]

    public StudentAccount(String e, String fn, String p){
        super(e, fn, p);
        numOfCourses = 0;
        myCourses = new Courses[6];
        myDepartment = new Department();
    }
    public StudentAccount(){
        super();
    }

    public Courses[] getMyCourses() {
        return myCourses;
    }

    public void registerCourse(Courses myCourses) {
        if (numOfCourses <= 6) {
            this.myCourses[numOfCourses] = myCourses;
            numOfCourses++;
            System.out.println( myCourses.getCourseName() +" Course was registered successfully!");
        }else {
            System.out.println("You can't register more than 6 courses!");
        }
    }

    public int getNumOfCourses() {
        return numOfCourses;
    }

    private int numOfCourses;
    private Courses[] myCourses;


}


class Courses{


    private String courseName;
    private String courseCode;
    private int courseCredit;
    private ArrayList<Section> sections;
    private int numOfSections;

    public Courses(String n, String c, int credit){

        courseCode = c;
        courseName = n;
        courseCredit = credit;

        sections = new ArrayList<Section>();
        numOfSections = 0;

    }
    public Courses(){
        sections = new ArrayList<Section>();
        numOfSections = 0;
    }

    public ArrayList<Section> getSections() {
        return sections;
    }

    public void addSections(Section sectoins) {
        this.sections.add(sectoins);
    }

    public int getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(int courseCredit) {
        this.courseCredit = courseCredit;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }







}





public class Main {


    private static String userType;
    private static int userIndex;
    public static Scanner cin2 = new Scanner(System.in);


    private static boolean loginn(ArrayList<StaffAccount> staffList, ArrayList<StudentAccount> studentList){
        boolean loginStatus = false;
        JTextField email = new JTextField();
        JTextField password = new JPasswordField();
        Object[] message = {
                "Email:", email,
                "Password:", password
        };


        while (loginStatus == false) {
            int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                // for staff




                for (int i = 0; i < staffList.size(); i++) {
                    if (email.getText().equals(staffList.get(i).getEmail()) && password.getText().equals(staffList.get(i).getPassword())) {
                        System.out.println("Login successful");
                        userType = "staff";
                        userIndex = i;
                        loginStatus = true;
                        return true;
                    }

                }
                // for student
                for (int i = 0; i < studentList.size(); i++) {

                    if (email.getText().equals(studentList.get(i).getEmail()) && password.getText().equals(studentList.get(i).getPassword())) {
                        System.out.println("Login successful");
                        userType = "student";
                        userIndex = i;
                        loginStatus = true;
                        return true;
                    }

                }


                System.out.println("Email or Password is Wrong!");
                loginStatus = false;


            } else {
                System.out.println("Login canceled");
                System.exit(0);
                loginStatus = false;
                return false;
            }}
        return false;
    }

    public static int printMenu(String n)
    {
        System.out.println( "Welcome " + n + "!" );
        System.out.println( "1 - View Your Information." );
        System.out.println( "2 - View Your Courses." );
        System.out.println( "3 - Register For Courses." );
        System.out.println( "4 - View Time Table." );
        System.out.println( "5 - Log out.");

        int choice = 0;
        System.out.println();

        System.out.print("Your Choice --> ");
        choice = cin2.nextInt();
        cin2.nextLine();

        return choice;
    }
    public static int mainMenu()
    {

        System.out.println( "1 - Log in." );
        System.out.println( "2 - Exit Application.");

        int choice = 0;
        System.out.println();



        System.out.print("Your Choice --> ");
        choice = cin2.nextInt();
        cin2.nextLine();

        return choice;
    }

    private static void viewInfo(StudentAccount s_a){


        System.out.println("Here is the information for this student account!");
        System.out.println("................................................");
        System.out.println("    Full Name: " + s_a.getFullName() );
        System.out.println("    Email: " + s_a.getEmail() );
        System.out.println("    Age: " + s_a.getAge() );
        System.out.println("    Matrix ID: " + s_a.getMatricID() );
        System.out.println("    Department: " + s_a.getMyDepartment() );
        System.out.println("    Section: " + s_a.getSection() );
        System.out.println("    Study Year: " + s_a.getStudyYear() );
        System.out.println("................................................");


    }

    private static void viewStaffInfo(StaffAccount st_a){

        System.out.println("Here is the information for this staff account!");
        System.out.println("................................................");
        System.out.println("    Full Name: " + st_a.getFullName() );
        System.out.println("    Email: " + st_a.getEmail() );
        System.out.println("    Role: " + st_a.getRole() );
        System.out.println("................................................");

    }

    private static void viewAllStudents(ArrayList<StudentAccount> stu){

        System.out.println("Here is the list of All Students:");
        System.out.println("................................................");
        for (int i = 0; i < stu.size(); i++){

            System.out.println("Student #" + (i+1) );
            viewInfo( stu.get(i) );
            System.out.println();

        }


    }

    private static StudentAccount addStudent(){

        StudentAccount tempData = new StudentAccount();
        System.out.println("Enter the information of the Student:");
        System.out.println("................................................");
        System.out.println();
        System.out.print("Student Full Name: ");
        tempData.setFullName( cin2.nextLine() );
        System.out.print("Email: ");
        tempData.setEmail( cin2.nextLine() );
        System.out.print( "Age: " );
        tempData.setAge( cin2.nextInt() );
        cin2.nextLine();
        System.out.print("Matrix ID: ");
        tempData.setMatricID( cin2.nextLine() );
        System.out.print("Department: ");
        tempData.setMyDepartment( new Department( cin2.nextLine() ) );
        System.out.print("Study Year: ");
        tempData.setStudyYear( cin2.nextInt() );
        cin2.nextLine();
        System.out.println("Enter a Password for this student Account: ");
        tempData.setPassword( cin2.nextLine() );

        return tempData;

    }


    private static int doesStudentExist(ArrayList<StudentAccount> stu){

        String tempEmail = "";

        System.out.println("Enter the Email of the Student that you want to remove: ");
        System.out.print( " --> ");
        tempEmail = cin2.nextLine();


        for (int i = 0; i < stu.size(); i++){

            if(stu.get(i).getEmail().equals(tempEmail)){

                System.out.println( "Student (" + stu.get(i).getFullName() + ") was removed successfully!" );
                return i;

            }

        }
        System.out.println("Student was not found!");
        return -1;

    }


    private static void viewAllCourses(ArrayList <Courses> tempCourse){

        if (tempCourse.size() == 0){
            System.out.println("There are no courses!");
        }else {

            System.out.println("Here are the available Courses: ");
            System.out.println("................................................");
            for (int i = 0; i < tempCourse.size(); i++){

                System.out.println("Course #" + (i+1) );
                System.out.println("Name: " + tempCourse.get(i).getCourseName() );
                System.out.println("Code: " + tempCourse.get(i).getCourseCode() );
                System.out.println("Credit: " + tempCourse.get(i).getCourseCredit() );
                System.out.println();

            }
            System.out.println("................................................");
            System.out.println();

        }

    }

    private static Courses addCourse(){

        Courses tempInput = new Courses();
        System.out.println("Enter the information of the Course:");
        System.out.println("................................................");
        System.out.print("Course Name: ");
        tempInput.setCourseName( cin2.nextLine() );
        System.out.println("Course Code: ");
        tempInput.setCourseCode( cin2.nextLine() );
        System.out.println("Course Credit: ");
        tempInput.setCourseCredit( cin2.nextInt() );
        cin2.nextLine();

        return tempInput;
    }


    private static int doesCourseExist(ArrayList<Courses> cou){

        String tempID = "";

        System.out.println("Enter the Course ID of the Course that you want to remove: ");
        System.out.print( " --> ");
        tempID = cin2.nextLine();


        for (int i = 0; i < cou.size(); i++){

            if(cou.get(i).getCourseCode().equals(tempID)){

                System.out.println( "Course (" + cou.get(i).getCourseName() + ") was removed successfully!" );
                return i;

            }

        }
        System.out.println("Course was not found!");
        return -1;

    }


    private static void viewAllSections(ArrayList<Courses> cou){

        System.out.println("Here are the List of Courses: ");
        System.out.println("................................................");
        for (int i = 0; i < cou.size(); i++) {
            System.out.print("Course #" + (i + 1) + ": ");
            System.out.print( cou.get(i).getCourseName());
            System.out.println(" - " + cou.get(i).getCourseCode());
        }

        System.out.println();

        int choiceCourse = 0, sectionChoice = 0;
        System.out.print("Which courses sections do you want to see: ");
        choiceCourse = cin2.nextInt();
        cin2.nextLine();

        System.out.println();

        ArrayList<Section> currentSections = cou.get(choiceCourse-1).getSections();

        if(currentSections.size() == 0){
            System.out.println("There are no Sections in this Course yet!");
        }else {

            System.out.println("Here are the Sections in " + cou.get(choiceCourse - 1).getCourseName() + ": ");
            System.out.println("................................................");
            for (int i = 0; i < currentSections.size(); i++) {

                System.out.println("Sections number: " + currentSections.get(i).getSectionNum());

            }

            System.out.print("Which sections student list do you with to see: ");
            sectionChoice = cin2.nextInt();
            cin2.nextLine();

            ArrayList<StudentAccount> currentSecStudents = currentSections.get(sectionChoice-1).getStudents();

            if (currentSecStudents.size() == 0){

                System.out.println("There are no students in this sections yet!");

            }else{

                System.out.println("Here is the list of students in this Section: ");
                System.out.println("................................................");
                for (int i = 0; i < currentSecStudents.size(); i++){

                    System.out.println( (i+1) + ". " + currentSecStudents.get(i).getFullName() +
                            ", " + currentSecStudents.get(i).getMatricID() + ", " + currentSecStudents.get(i).getMyDepartment() +
                            ", Year: " + currentSecStudents.get(i).getStudyYear() );

                }
                System.out.println();
                System.out.println("................................................");


            }


        }

    }


    private static void createSection(){



    }


    // this function is used to clear the command line text
    public static void blankSpace() {

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

    }
    public static void promptEnterKey(){
        System.out.println("Press \"ENTER\" to continue...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int staffMenu(){
        System.out.println();
        System.out.println(" Staff Menu:");
        System.out.println("................................................");
        System.out.println( "   1  - View Your Account Information." ); // done
        System.out.println( "   2  - View All Students.");              // done
        System.out.println( "   3  - Add Student.");                    // done
        System.out.println( "   4  - Remove Student.");                 // done
        System.out.println( "   5  - View All Courses." );              // done
        System.out.println( "   6  - Add Course." );                    // done -
        System.out.println( "   7  - Remove Course." );                 // done -
        System.out.println( "   8  - View All Sections.");              // done -
        System.out.println( "   9  - Create Section.");
        System.out.println( "   10 - Add Students to a Section.");
        System.out.println( "   11 - Create Time Table.");
        System.out.println( "   12 - Log out.");
        System.out.println("................................................");

        int choice = 0;
        System.out.println();

        System.out.print("Your Choice --> ");
        choice = cin2.nextInt();
        cin2.nextLine();

        return choice;


    }


    public static void viewCourses(StudentAccount s_a){

        Courses tempCourse[] = s_a.getMyCourses();
        int courseNum = s_a.getNumOfCourses();
        if(s_a.getNumOfCourses() == 0){
            System.out.println("                You have no Courses! ");
            System.out.println();
        }else {

            System.out.println("Your Courses: ");
            System.out.println("................................................");
            for (int i = 0; i < courseNum; i++) {
                System.out.println("Course Name: " + tempCourse[i].getCourseName());
                System.out.println("Course Code: " + tempCourse[i].getCourseCode());
                System.out.println("Course Credit: " + tempCourse[i].getCourseCredit());
                System.out.println();
            }
            System.out.println("................................................");
        }
    }

    public static void registerCourses(ArrayList<Courses> tempCourse, StudentAccount s_a){
        System.out.println("Here are the list of courses:");
        System.out.println();
        for (int i = 0; i < tempCourse.size(); i++){

            System.out.println((i+1) + ". Course Name: " + tempCourse.get(i).getCourseName());
            System.out.println("Course Code: " + tempCourse.get(i).getCourseCode());
            System.out.println("Course Credit: " + tempCourse.get(i).getCourseCredit());
            System.out.println();

        }
        System.out.println("which Course do you want to register -> ");
        int choiceC = cin2.nextInt();
        cin2.nextLine();

        s_a.registerCourse(tempCourse.get(choiceC-1));

    }




    public static void main(String[] args) {



        // students predefined list, can add more later.
        ArrayList<StudentAccount> studentsList = new ArrayList<StudentAccount>();
        studentsList.add(new StudentAccount("sirostaib@gmail.com", "Siroz Ali Taib", "slaw"));
        studentsList.add(new StudentAccount("zheerardalan@gmail.com", "Zheer Ardalan Salih", "slaw"));
        studentsList.add(new StudentAccount("sanakram@gmail.com", "San Akram Ali", "slaw"));
        studentsList.add(new StudentAccount("ahmadsafaa@gmail.com", "Ahmad Safaa", "slaw"));
        studentsList.add(new StudentAccount("student", "Student Test", "student"));


        // staff list
        ArrayList<StaffAccount> staffList = new ArrayList<StaffAccount>();
        staffList.add(new StaffAccount("admin", "Administrator Test", "admin", "Adminstrator"));
        staffList.add(new StaffAccount("kanartariq@qaiwan.com", "Kanar R. Tariq", "Admin", "Staff"));
        staffList.add(new StaffAccount("mohamadtahir@qaiwan.com", "Mohamad Tahir", "Admin", "Staff"));

        // courses List
        ArrayList<Courses> availableCourses = new ArrayList<Courses>();
        availableCourses.add(new Courses("OOP", "SCSJ-2154", 4));
        availableCourses.add(new Courses("Application Development", "SCSJ-3104", 4));
        availableCourses.add(new Courses("Advanced English Language", "ULAB-3162", 2));
        availableCourses.add(new Courses("Probability & Statistical Data Analysis", "SCSI-1143", 3));







        int choiceStudent = 0, choiceGeneral = 0, choiceStaff = 0;
        int removeIndex = -1;


        while (choiceGeneral != 2) {
            choiceGeneral = mainMenu();
            if (choiceGeneral == 1) {

                // if the user is logged in
                if (loginn(staffList, studentsList)) {

                    // if the user is staff
                    if (userType == "staff") {

                        choiceStaff = 0;

                        while (choiceStaff != 12) {

                            choiceStaff = staffMenu();

                            if (choiceStaff == 1) {

                                blankSpace();
                                viewStaffInfo( (StaffAccount)staffList.get(userIndex));
                                promptEnterKey();
                                blankSpace();

                            } else if (choiceStaff == 2) {

                                blankSpace();
                                viewAllStudents(studentsList);
                                promptEnterKey();
                                blankSpace();

                            } else if (choiceStaff == 3) {

                                blankSpace();
                                studentsList.add( addStudent() );
                                System.out.println("Student was added successfully!");
                                System.out.println();
                                promptEnterKey();
                                blankSpace();

                            } else if (choiceStaff == 4) {

                                blankSpace();
                                removeIndex = doesStudentExist(studentsList);
                                if( removeIndex != -1){
                                    studentsList.remove( removeIndex );
                                }
                                promptEnterKey();
                                blankSpace();


                            } else if (choiceStaff == 5) {

                                blankSpace();
                                viewAllCourses(availableCourses);
                                promptEnterKey();
                                blankSpace();

                            }else if(choiceStaff == 6){

                                blankSpace();
                                availableCourses.add( addCourse() );
                                promptEnterKey();
                                blankSpace();

                            }else if(choiceStaff == 7){

                                blankSpace();
                                removeIndex = doesCourseExist(availableCourses);
                                if(removeIndex != -1)
                                    availableCourses.remove( removeIndex );
                                promptEnterKey();
                                blankSpace();

                            }else if(choiceStaff == 8){


                                blankSpace();
                                viewAllSections(availableCourses);
                                promptEnterKey();
                                blankSpace();


                            }

                        }

                        // if the user is student
                    } else if (userType == "student") {

                        choiceStudent = 0;

                        while (choiceStudent != 5) {


                            choiceStudent = printMenu(studentsList.get(userIndex).getFullName());
                            choiceGeneral = choiceStudent;

                            // choice 1
                            // View your information
                            if (choiceStudent == 1) {

                                blankSpace();
                                viewInfo((StudentAccount) studentsList.get(userIndex));
                                promptEnterKey();
                                blankSpace();

                                // Choice 2 view your courses
                            } else if (choiceStudent == 2) {


                                blankSpace();
                                viewCourses((StudentAccount) studentsList.get(userIndex));
                                promptEnterKey();
                                blankSpace();


                                // Choice 3 register courses
                            } else if (choiceStudent == 3) {

                                blankSpace();
                                registerCourses(availableCourses, (StudentAccount) studentsList.get(userIndex));
                                promptEnterKey();
                                blankSpace();

                            // view time table option
                            } else if (choiceStudent == 4) {


                            } else if (choiceStudent > 5) {
                                System.out.println("Wrong number!");
                            } else if (choiceStudent < 1) {
                                System.out.println("Wrong number input!");
                            }


                        }
                    } else {

                        System.out.println("Wrong user! please log in again...");

                    }
                }else{
                    System.out.println("the return was false!");
                }
            } else {
                //System.out.println("here");
            }
        }
        System.out.println("Thanks for using our application!");
    }
}
