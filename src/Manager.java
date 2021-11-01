public class Manager extends Staff implements ICalculator{
    protected String title;

    public Manager() {};
    // Manager Class Constructor
    public Manager(String idStaff, String nameStaff, int ageStaff, int salaryWeight, String dateStart, Department department, int dayOffQuantity, String title) {
        this.idStaff = idStaff;
        this.nameStaff = nameStaff;
        this.ageStaff = ageStaff;
        this.salaryWeight = salaryWeight;
        this.dateStart = dateStart;
        m_department = department;
        this.dayOffQuantity = dayOffQuantity;
        this.title = title;
    };

    public String getTitle() {
        return title;
    }

    public boolean setTitle(String title) {
        if (title != null) {
            this.title = title;
            return true;
        } else {
            System.err.println("You should type something!");
            return false;
        }
    }

    // Display Info Method
    @Override
    public void displayInformation() {
        System.out.println("Manager's id: " + idStaff + "; Manager's Name: " + nameStaff + "; Manager's age: " + ageStaff + "; Manager's salary weight: " + salaryWeight + "; Manager's starting Date: " + dateStart + "; Manager's department: " + m_department + "; Number of Day Off: " + dayOffQuantity + "; Manager's title: " + title + ".");
        System.out.println();
    }

    // Employee Salary Calculation Method
    @Override
    public int calculateSalary() {
        if (m_department.getIdDepartment().equals("d01")) { // User type 1 in console which is equivalent to "Business Department"
            return salaryWeight * 5000000 + 8000000;
        } else if (m_department.getIdDepartment().equals("d02")) { // User type 2 in console which is equivalent to "Project Department"
            return salaryWeight * 5000000 + 5000000;
        } else { // User type 3 in console which is equivalent to "Technical Department"
            return salaryWeight * 5000000 + 6000000;
        }

    }
}
