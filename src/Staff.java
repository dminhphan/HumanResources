import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Staff {
    // Staff's attributes
    Department m_department; // Special variable m_department created from the class Department, which have all the properties in the prototype of this class
    protected String idStaff;
    protected String nameStaff;
    protected int ageStaff;
    protected int salaryWeight;
    protected String dateStart;
    protected int dayOffQuantity;

    // Setters and Getters
    public String getIdStaff() {
        return idStaff;
    }

    public boolean setIdStaff(String idStaff){
        if (!idStaff.equals("")) {
            this.idStaff = idStaff;
            return true;
        } else {
            System.err.println("You should type something!");
            return false;
        }
    }

    public String getNameStaff() {
        return nameStaff;
    }

    public boolean setNameStaff(String nameStaff){
        if (!nameStaff.equals("")) {
            this.nameStaff = nameStaff;
            return true;
        } else {
            System.err.println("You should type something!");
            return false;
        }
    }

    public int getAgeStaff() {
        return ageStaff;
    }

    public boolean setAgeStaff(int ageStaff) {
        if (ageStaff < 0) {
            System.err.println("You should type a positive number!");
            return false;
        } else {
            this.ageStaff = ageStaff;
            return true;
        }
    }

    public int getSalaryWeight() {
        return salaryWeight;
    }

    public boolean setSalaryWeight(int salaryWeight) {
        if (salaryWeight < 0) {
            System.err.println("You should type a positive number!");
            return false;
        } else {
            this.salaryWeight = salaryWeight;
            return true;
        }
    }

    public String getDateStart() {
        return dateStart;
    }

    // Check the format for the Date Input in Java
    // TODO check if the input date is in the future
    public boolean setDateStart(String dateStart) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            date = sdf.parse(dateStart); // turn dateStart parameter to date format and grant it to date variable, .parse() to convert String to date format
            if (dateStart.equals(sdf.format(date))) { // check if dateStart parameter equals to the String format of date variable, .format() to convert date to String format
                this.dateStart = dateStart;
                return true;
            }
        } catch (ParseException ex) { // If things go wrong (the code doesn't follow the rules in Try), execute the Catch part, ex here is a parameter, ParseException is the type of error
            //ex.printStackTrace(); //Do not need to display the error screen
        }
        //System.err.println("Please enter as the Date format as dd/MM/yyyy"); // Already written in the Main class
        return false;
    }

    // Getter & Setter for department
    public Department getDepartment() {
        return m_department;
    }

    public void setDepartment(Department department) {
        m_department = department; // Pass the value of 1 of 3 lists of Department details to m_department in the Department class
    }

    public int getDayOffQuantity() {
        return dayOffQuantity;
    }

    public boolean setDayOffQuantity(int dayOffQuantity) {
        if (dayOffQuantity < 0) {
            System.err.println("You should type a positive number!");
            return false;
        } else {
            this.dayOffQuantity = dayOffQuantity;
            return true;
        }
    }

    public abstract void displayInformation();
}
