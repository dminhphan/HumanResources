import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class HumanResources {
    static ArrayList<Staff> listStaff = new ArrayList<Staff>(); // Create a new ArrayList named listStaff from the Staff class
    static ArrayList<Department> listDepartment = new ArrayList<Department>(); // Create a listDepartment ArrayList to store 3 options for the Department
    static Scanner console = new Scanner(System.in);

    // Main Method
    public static void main(String[] args) {

        // First Initiate - Create 3 objects in Department class for 3 different departments
        Department d1 = new Department("d01", "Business Department", 0);
        listDepartment.add(d1);
        Department d2 = new Department("d02", "Project Department", 0);
        listDepartment.add(d2);
        Department d3 = new Department("d03", "Technical Department", 0);
        listDepartment.add(d3);

        // Entering Console Interface
        int choose;
        do {
            showMenu();
            // Checking the user input is valid from 0 to 10
            while (true) {
                System.out.println("Please type a number from 0 to 9 to run our program: ");
                //choose = Integer.parseInt(console.nextLine());
                if (console.hasNextInt()){ // User type in an integer
                    choose = console.nextInt();
                    console.nextLine(); // clear console
                    if (choose < 0 || choose > 10) {
                        System.err.println("You should type a number between 0 and 9!");
                    } else {
                        break; // choose successfully passed
                    }
                } else { // User type in a String
                    System.err.println("You should type a number!");
                    console.nextLine(); // clear console
                }
            }

            // user input choose pass the condition, now choose is ranging from 0 to 10
            switch (choose) {
                case 1: //1. Showing all the staff's names.
                    displayAllStaff();
                    break;
                case 2: //2. Showing all the departments in the company.
                    displayAllDepartment();
                    break;
                case 3: //3. Showing all the staff's names in each department.
                    displayStaffInEachDep();
                    break;
                case 4: //4. Adding a new employee.
                    inputEmployee();
                    break;
                case 5: //5. Adding a new manager.
                    inputManager();
                    break;
                case 6: //6. Searching a staff's information based on a name.
                    searchNameStaff();
                    break;
                case 7: //7. Searching a staff's information based on an id.
                    searchIdStaff();
                    break;
                case 8: //8. Showing all the staff's salary.
                    displayAllSalary();
                    break;
                case 9: //9. Sorting the staff's salary in ascending order.
                    sortSalaryAscending();
                    break;
                case 10: //10. Sorting the staff's salary in descending order.
                    sortSalaryDescending();
                    break;
                case 0: //0. Closing the Program.
                    System.out.println("Good bye!");
                    break;
            }
        } while (choose != 0);
    }

    // Show Menu Method
    public static void showMenu() {
        breakLine();
        System.out.println("Welcome to our Human Resources Program, please choose one of the following numbers to run the program!");
        System.out.println("1. Showing all the staff's names.");
        System.out.println("2. Showing all the departments in the company.");
        System.out.println("3. Showing all the staff's names in each department.");
        System.out.println("4. Adding a new employee.");
        System.out.println("5. Adding a new manager.");
        System.out.println("6. Searching a staff's information based on a name.");
        System.out.println("7. Searching a staff's information based on an id.");
        System.out.println("8. Showing all the staff's salary.");
        System.out.println("9. Sorting the staff's salary in ascending order.");
        System.out.println("10. Sorting the staff's salary in descending order.");
        System.out.println("0. Closing the Program.");
    }

    // Feature 1 - Showing all the staff's names
    public static void displayAllStaff() {
        breakLine();
        System.out.println("LIST OF ALL THE STAFF: ");
        for (int i = 0; i < listStaff.size(); i++) {
            System.out.print(i + 1 + ". ");
            listStaff.get(i).displayInformation();
            System.out.println(); // Enter another line for another index in the list
        }
    }

    // Feature 2 - Showing all the departments' in the company
    public static void displayAllDepartment() {
        breakLine();
        System.out.println("LIST OF ALL THE DEPARTMENTS:");
        for (int i = 0; i < listDepartment.size(); i++) {
            System.out.print(i + 1 + ". ");
            System.out.println(listDepartment.get(i).getNameDepartment());  // Display Department Name
        }
    }

    // Feature 3 - Showing all the staff's names in each department
    public static void displayStaffInEachDep() {
        breakLine();
        System.out.println("DISPLAY ALL THE STAFF IN EACH DEPARTMENT");
        System.out.println();
        // 1st Loop - Loop through listDepartment & Print the details
        for (int i = 0; i < listDepartment.size(); i++) {
            System.out.print(i + 1 + ". ");
            System.out.println(listDepartment.get(i).getNameDepartment()); // Display the Department Name

            int index = 0;
            // 2nd Loop - Loop through listStaff to find the matching Staff in the same department & Print the details
            for (int j = 0; j < listStaff.size(); j++) {
                // If condition that an instance of listStaff which has the department property the same as the department
                if (listStaff.get(j).getDepartment().idDepartment.equals(listDepartment.get(i).idDepartment)) {
                    index++;
                    System.out.print(i + 1 + ". " + index + ". "); // Display the index, i.e. 1.1, 1.2, 1.3, etc.
                    listStaff.get(j).displayInformation(); // this method already has the Println function to display the Staff's details
                }
            }
        }
    }

    // Feature 4 - Adding new Employee Method
    public static void inputEmployee() {
        // Create a child object m_staff of the abstract class Staff with the Manager() package class
        Staff m_staff = new Employee();

        // 4.1 Employee ID Input
        breakLine();
        System.out.println("ADDING A NEW EMPLOYEE");
        System.out.println("Please enter the employee's id: ");
        while (true) {
            String idStaffInput = console.nextLine();
            boolean check = m_staff.setIdStaff(idStaffInput);
            if (check) {
                break;
            }
        }

        // 4.2 Employee Name Input
        System.out.println("Please enter the employee's name: ");
        while (true) {
            String nameStaffInput = console.nextLine();
            boolean check = m_staff.setNameStaff(nameStaffInput);
            if (check) {
                break;
            }
        }

        // 4.3 Employee Age Input
        System.out.println("Please enter the employee's age: ");
        while (true) {
            int ageStaffInput = getInt(); // the getInt() method here to check whether the input is as an integer
            boolean check = m_staff.setAgeStaff(ageStaffInput); // the setter here to check whether the input is a positive number
            if (check) {
                break;
            }
        }

        // 4.4 Salary Weight Input
        System.out.println("Please enter his/her salary weight: ");
        while (true) {
            int salaryWeightInput = getInt();
            boolean check = m_staff.setSalaryWeight(salaryWeightInput);
            if (check) {
                break;
            }
        }

        // 4.5 Starting Date Input
        System.out.println("Please enter the employee's starting date: ");
        String dateStartInput = console.nextLine();
        while (!m_staff.setDateStart(dateStartInput)) {
            System.err.println("Please enter as the Date format as dd/MM/yyyy");
            dateStartInput = console.nextLine();
        }

        // 4.6 Department Choosing
        System.out.println("List of Department: ");
        System.out.println("Press 1 for Business Department.");
        System.out.println("Press 2 for Project Department.");
        System.out.println("Press 3 for Technical Department.");
        System.out.println("Please choose the employee's department from one of three choices above: ");
        // Choose 1 in 3 Department then that Department Staff quantity increases by 1
        while (true) {
            int departmentInput = getInt();
            if (departmentInput == 1) { // User choose 1
                // Set the property m_department in abstract class Staff to the 1st element of listDepartment arrayList
                m_staff.setDepartment(listDepartment.get(0));
                // Set the number Staff in Business Department increased by 1 in class Department
                listDepartment.get(0).setNumberStaffDepartment(listDepartment.get(0).getNumberStaffDepartment() + 1);
                break;
            } else if (departmentInput == 2) { // User choose 2
                // Set the property m_department in abstract class Staff to the 2nd element of listDepartment arrayList
                m_staff.setDepartment(listDepartment.get(1));
                // Set the number Staff in Project Department increased by 1 in class Department
                listDepartment.get(1).setNumberStaffDepartment(listDepartment.get(1).getNumberStaffDepartment() + 1);
                break;
            } else if (departmentInput == 3) { // User choose 3
                // Set the property m_department in abstract class Staff to the 3rd element of listDepartment arrayList
                m_staff.setDepartment(listDepartment.get(2));
                // Set the number Staff in Technical Department increased by 1 in class Department
                listDepartment.get(2).setNumberStaffDepartment(listDepartment.get(2).getNumberStaffDepartment() + 1);
                break;
            } else {
                System.err.println("Please enter only number 1, 2, or 3!");
            }
        }

        // 4.7 Day Off Quantity Input
        System.out.println("Please enter the employee's number of day off: ");
        while (true) {
            int dayOffQuantityInput = getInt();
            boolean check = m_staff.setDayOffQuantity(dayOffQuantityInput);
            if (check) {
                break;
            }
        }

        // 4.8 Overtime Hours Input
        System.out.println("Please enter the employee's overtime hours: ");
        while (true) {
            int OTHoursInput = getInt();
            boolean check = ((Employee) m_staff).setOTHours(OTHoursInput); // DownCasting the type of 'm_staff' in abstract class 'Staff' to 'Employee' class to get the properties in 'Employee'
            if (check) {
                break;
            }
        }

        // Finishing filling all the properties of an object m_staff and save to the listStaff ArrayList with the next index
        listStaff.add(m_staff);
    }

    // Feature 5 - Adding new Manager Method
    public static void inputManager() {
        // Create a child object m_staff of the abstract class Staff with the Manager() package class
        Staff m_staff = new Manager();

        // 5.1 Manager ID input
        breakLine();
        System.out.println("ADDING A NEW MANAGER");
        System.out.println();
        System.out.println("Please enter the manager's id");
        while (true) {
            String idStaffInput = console.nextLine();
            boolean check = m_staff.setIdStaff(idStaffInput);
            if (check) {
                break;
            }
        }

        // 5.2 Manager Name Input
        System.out.println("Please enter the manager's name: ");
        while (true) {
            String nameStaffInput = console.nextLine();
            boolean check = m_staff.setNameStaff(nameStaffInput);
            if (check) {
                break;
            }
        }

        // 5.3 Manager Age Input
        System.out.println("Please enter the manager's age: ");
        while (true) {
            int ageStaffInput = getInt();
            boolean check = m_staff.setAgeStaff(ageStaffInput);
            if (check) {
                break;
            }
        }

        // 5.4 Salary Weight Input
        System.out.println("Please enter his/her salary weight: ");
        while (true) {
            int salaryWeightInput = getInt();
            boolean check = m_staff.setSalaryWeight(salaryWeightInput);
            if (check) {
                break;
            }
        }

        // 5.5 Starting Date Input
        System.out.println("Please enter the manager's starting date: ");
        String dateStartInput = console.nextLine();
        while (!m_staff.setDateStart(dateStartInput)) {
            System.err.println("Please enter as the Date format as dd/MM/yyyy");
            dateStartInput = console.nextLine();
        }

        // 5.6 Department Choosing
        System.out.println("List of Department: ");
        System.out.println("Press 1 for Business Department.");
        System.out.println("Press 2 for Project Department.");
        System.out.println("Press 3 for Technical Department.");
        System.out.println("Please choose the employee's department from one of three choices above: ");
        // Choose 1 in 3 Department then that Department Staff quantity increases by 1
        while (true) {
            int departmentInput = getInt();
            if (departmentInput == 1) { // User choose 1
                m_staff.setDepartment(listDepartment.get(0));
                // Set the number Staff in Business Department increased by 1 in class Department
                listDepartment.get(0).setNumberStaffDepartment(listDepartment.get(0).getNumberStaffDepartment() + 1);
                break;
            } else if (departmentInput == 2) { // User choose 2
                m_staff.setDepartment(listDepartment.get(1));
                listDepartment.get(1).setNumberStaffDepartment(listDepartment.get(1).getNumberStaffDepartment() + 1);
                break;
            } else if (departmentInput == 3) { // User choose 3
                m_staff.setDepartment(listDepartment.get(2));
                listDepartment.get(2).setNumberStaffDepartment(listDepartment.get(2).getNumberStaffDepartment() + 1);
                break;
            } else {
                System.err.println("Please enter only number 1, 2, or 3!");
            }
        }

        // 5.7 Day Off Quantity Input
        System.out.println("Please enter the manager's number of day off: ");
        while (true) {
            int dayOffQuantityInput = getInt();
            boolean check = m_staff.setDayOffQuantity(dayOffQuantityInput);
            if (check) {
                break;
            }
        }

        // 5.8 Manager Title Input
        System.out.println("Please enter the manager's title: ");
        while (true) {
            String titleInput = console.nextLine();
            // Downcasting the titleInput variable from m_staff variable belonging to class Staff down to become a variable in class Manager so the class Manager can use this variable for the following method
            boolean check = ((Manager) m_staff).setTitle(titleInput);
            if (check) {
                break;
            }
        }

        // Finishing filling all the properties of an object m_staff and save to the listStaff ArrayList with the next index
        listStaff.add(m_staff);
    }

    // Feature 6 - Searching a staff's information based on a name
    public static void searchNameStaff() {
        breakLine();
        System.out.println("SEARCH THE STAFF'S INFORMATION BASED ON THE STAFF'S NAME");
        System.out.println("Please enter the Staff's Name you want to look up: ");
        String nameStaffSearch = console.nextLine();
        int count = 0; // for moving to the next index in the listStaff arraylist
        // For Loop to Scan through all the elements inside the listStaff arraylist
        for (Staff staff : listStaff) {
            if (staff.getNameStaff().equalsIgnoreCase(nameStaffSearch)) { // If a name in listStaff has the same String with the user input query
                System.out.println("Yes, there is a staff having this name, whose information is displayed below: ");
                staff.displayInformation();
                count++;
            }
        }
        // After scanning through the listStaff arraylist but cannot find the matching name, so the count does not increase
        if (count == 0) {
            System.out.println("There is no staff having this id of \"" + nameStaffSearch + "\".");
        }
    }

    // Feature 7 - Searching a staff's information based on an id
    public static void searchIdStaff() {
        breakLine();
        System.out.println("SEARCH THE STAFF'S INFORMATION BASED ON THE STAFF'S ID");
        System.out.println("Please enter the Staff's Id you want to look up: ");
        String idStaffSearch = console.nextLine(); // Get the user input for search query
        int count = 0; // for moving to the next index in the listStaff arraylist
        // For Loop to Scan through all the elements inside the listStaff arraylist
        for (Staff staff : listStaff) {
            if (staff.getIdStaff().equalsIgnoreCase(idStaffSearch)) {
                System.out.println("Yes, there is a staff having this id, whose information is displayed below: ");
                staff.displayInformation();
                count++;
            }
        }
        // After scanning through the listStaff arraylist but cannot find the matching id, so the count does not increase
        if (count == 0) {
            System.out.println("There is no staff having this id of \"" + idStaffSearch + "\".");
        }
    }

    // Feature 8 - Showing all the staff's salary
    public static void displayAllSalary() {
        breakLine();
        System.out.println("ALL THE STAFF'S SALARY INFORMATION:");
        for (int i = 0; i < listStaff.size(); i++) {
            int salary = 0;
            System.out.print(i + 1 + ". ");
            System.out.print(listStaff.get(i).getNameStaff()); // Display the staff's name
            System.out.print("; Salary: ");
            // Downcasting the instance listStaff.get(i) belongs to class Staff down to become an object of Employee class
            if (listStaff.get(i) instanceof Employee) {
                Employee e = (Employee) listStaff.get(i);
                salary = e.calculateSalary();
            }
            // Downcasting the instance listStaff.get(i) belongs to class Staff down to become an object of Manager class
            if (listStaff.get(i) instanceof Manager) {
                Manager m = (Manager) listStaff.get(i);
                salary = m.calculateSalary();
            }
            System.out.print(salary); // Display the Salary
            System.out.println(); // Enter another line for the next index information
        }
    }

    // Feature 9 - Sorting the staff's salary in ascending order
    public static void sortSalaryAscending() {
        Collections.sort(listStaff, new Comparator<Staff>() { // Loop through the listStaff arrayList
            @Override
            public int compare(Staff o1, Staff o2) { // Create 2 objects in the Staff class to consecutively go through each index
                // Downcast o1 and o2 to access the calculateSalary() method in 2 Employee and Manager classes to return a number to compare
                int salary1 = 0;
                // TODO Staff class already implements ICalculator so that Don't need the If parts here
                //salary1 = o1.calculateSalary();
                if(o1 instanceof Employee){ // if o1 is an instance created by the class Employee
                    Employee e = (Employee) o1;
                    salary1 = e.calculateSalary();
                } else { // if o1 instanceof Manager
                    Manager m = (Manager) o1;
                    salary1 = m.calculateSalary();
                }
                int salary2 = 0;
                if(o2 instanceof Employee){ // if o2 is an instance created by the class Employee
                    Employee e = (Employee) o2;
                    salary2 = e.calculateSalary();
                } else { // if o2 instanceof Manager
                    Manager m = (Manager) o2;
                    salary2 = m.calculateSalary();
                }
                // Compare 2 Salaries value
                if (salary1 >= salary2) { // if o1 > o2
                    return 1; // switch the index order, so o1 will be placed after o2
                } else { // if o1 < o2
                    return -1; // do not switch the index order, so o1 will be placed before o2
                }
            }
        });
        // Display the new Ascending order of listStaff
        breakLine();
        System.out.println("ALL THE STAFF'S SALARY BASED ON SALARY IN ASCENDING ORDER");
        for (int i = 0; i < listStaff.size(); i++) {
            int salary = 0;
            System.out.print(i + 1 + ". ");
            System.out.print(listStaff.get(i).getNameStaff()); // Display the Staff's Name
            System.out.print("; Salary: ");
            // Display the Salary of this Staff
            // Downcasting the instance listStaff.get(i) belongs to class Staff down to become an object of Employee class
            if (listStaff.get(i) instanceof Employee) {
                Employee e = (Employee) listStaff.get(i);
                salary =e.calculateSalary();
            }
            // Downcasting the instance listStaff.get(i) belongs to class Staff down to become an object of Manager class
            if (listStaff.get(i) instanceof Manager) {
                Manager m = (Manager) listStaff.get(i);
                salary = m.calculateSalary();
            }
            System.out.print(salary); // Display the Staff's Salary
            System.out.println(); // Enter another line for another index in the list
        }
    }

    // Feature 10 - Sorting the staff's salary in descending order.
    public static void sortSalaryDescending() {
        Collections.sort(listStaff, new Comparator<Staff>() {
            @Override
            public int compare(Staff o1, Staff o2) {
                // Downcast o1 and o2 to access the calculateSalary() method in 2 Employee and Manager classes to return a number to compare
                int salary1 = 0;
                if(o1 instanceof Employee){ // if o1 is an instance created by the class Employee
                    Employee e = (Employee) o1;
                    salary1 = e.calculateSalary();
                } else { // if o1 instanceof Manager
                    Manager m = (Manager) o1;
                    salary1 = m.calculateSalary();
                }
                int salary2 = 0;
                if(o2 instanceof Employee){ // if o2 is an instance created by the class Employee
                    Employee e = (Employee) o2;
                    salary2 = e.calculateSalary();
                } else { // if o2 instanceof Manager
                    Manager m = (Manager) o2;
                    salary2 = m.calculateSalary();
                }
                // Compare 2 Salaries value
                return salary1 >= salary2? -1: 1; // return condition ? a : b; == if( condition ) {return a;} else {return b;}
            }
        });
        // Display the new Descending order of listStaff
        breakLine();
        System.out.println("ALL THE STAFF'S SALARY BASED ON SALARY IN DESCENDING ORDER");
        for (int i = 0; i < listStaff.size(); i++) {
            int salary = 0;
            System.out.print(i + 1 + ". ");
            System.out.print(listStaff.get(i).getNameStaff()); // Display the Staff's Name
            System.out.print("; Salary: ");
            // Display the Salary of this Staff
            // Downcasting the instance listStaff.get(i) belongs to class Staff down to become an object of Employee class
            if (listStaff.get(i) instanceof Employee) {
                Employee e = (Employee) listStaff.get(i);
                salary =e.calculateSalary();
            }
            // Downcasting the instance listStaff.get(i) belongs to class Staff down to become an object of Manager class
            if (listStaff.get(i) instanceof Manager) {
                Manager m = (Manager) listStaff.get(i);
                salary = m.calculateSalary();
            }
            System.out.print(salary); // Display the Staff's Salary
            System.out.println(); // Enter another line for another index in the list
        }
    }

    // Method to check the correct number input
    // TODO Check if it's a negative number
    public static int getInt() {
        int userInput = 0; // grant as 0 to avoid the uninitialized error
        do {
            System.out.println("Please enter a number as an Integer!");
            if (console.hasNextInt()) {
                userInput = console.nextInt();
                console.nextLine(); // Clear Scanner
                break;
            } else {
                console.nextLine(); // Clear Scanner
                System.err.println("Wrong input!");
            }
        } while (true);
        return userInput;
    }

    // Method to create a new paragraph
    public static void breakLine() {
        System.out.println();
        System.out.println();
    }
}
