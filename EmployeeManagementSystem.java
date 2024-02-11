import java.util.*;
//employee interface
interface Employee {
    // getters
    int getEmpID();

    String getName();

    String getPosition();

    int getSalary();

    // setters
    void setEmpID(int id);

    void setName(String name);

    void setPosition(String pos);

    void setSalary(int sal);


    void showInfo();
}

// Fulltime employee and part time employee classes implementing the employee interface
class FullTimeEmployee implements Employee {
    private int EmpID;
    private String EmpName;
    private String EmpPosition;
    private int salary;

    public FullTimeEmployee(int EmpID, String EmpName, String EmpPosition, int salary) {
        this.EmpID = EmpID;
        this.EmpName = EmpName;
        this.EmpPosition = EmpPosition;
        this.salary = salary;
    }

    // getters
    public int getEmpID() {
        return EmpID;
    }

    public String getName() {
        return EmpName;
    }

    public String getPosition() {
        return EmpPosition;
    }

    public int getSalary() {
        return salary;
    }

    // setters
    public void setEmpID(int id) {
        this.EmpID = id;
    }

    public void setName(String name) {
        this.EmpName = name;
    }

    public void setPosition(String pos) {
        this.EmpPosition = pos;
    }

    public void setSalary(int sal) {
        this.salary = sal;
    }

    public void showInfo() {
        System.out.print("FULL TIME EMPLOYEE-->");
        System.out.print("Employee ID: " + getEmpID());
        System.out.print(", Employee name: " + getName());
        System.out.print(", Employee position: " + getPosition());
        System.out.println(", Employee salary: " + getSalary());
    }
}

class PartTimeEmployee implements Employee {
    int EmpID;
    String EmpName;
    String EmpPosition;
    int salary;

    public PartTimeEmployee(int EmpID, String EmpName, String EmpPosition, int salary) {
        this.EmpID = EmpID;
        this.EmpName = EmpName;
        this.EmpPosition = EmpPosition;
        this.salary = salary;
    }

    public int getEmpID() {
        return EmpID;
    }

    public String getName() {
        return EmpName;
    }

    public String getPosition() {
        return EmpPosition;
    }

    public int getSalary() {
        return salary;
    }

    // setters
    public void setEmpID(int id) {
        this.EmpID = id;
    }

    public void setName(String name) {
        this.EmpName = name;
    }

    public void setPosition(String pos) {
        this.EmpPosition = pos;
    }

    public void setSalary(int sal) {
        this.salary = sal;
    }

    public void showInfo() {
        System.out.print("PART TIME EMPLOYEE-->");
        System.out.print("Employee ID: " + getEmpID());
        System.out.print(", Employee name: " + getName());
        System.out.print(", Employee position: " + getPosition());
        System.out.println(", Employee salary: " + getSalary());
    }

}

// class implementing all the funtionalities

class EmployeeManagement {
    Map<Integer, Employee> mp = new HashMap<>();

    // method to add employee
    public void addEmp(Employee e) {
        // check for duplicate id
        if (mp.containsKey(e.getEmpID())) {
            System.out.println("Employee id already exist");
        } else {
            mp.put(e.getEmpID(), e);
            System.out.println("Employee added successfully!!");
        }
    }

    // method to remove the employee
    public void removeEmp(int eID) {
        if (mp.containsKey(eID)) {
            mp.remove(eID);
            System.out.println("Employee removed successfully!!");
        } else {
            System.out.println("Employee with this id doesn't exist");
        }
    }

    // displaying employee information
    public void displayInfo(int eID) {
        if (mp.containsKey(eID)) {
            mp.get(eID).showInfo();
        } else {
            System.out.println("Employee with this id doesn't exist");
        }
    }

    // displaying all Employees info

    public void displayAll() {
        if (mp.isEmpty()) {
            System.out.println("Add some employees!!");
        } else {
            for (Employee e : mp.values()) {
                e.showInfo();
            }
        }
    }

    // total salary
    public int totalSalary() {
        int salary = 0;
        for (Employee e : mp.values()) {
            salary += e.getSalary();
        }
        return salary;
    }

    // sorting employees accoriding to their salary
    public void sortEmployee() {
        List<Employee> arr = new ArrayList<>(mp.values());
        arr.sort(Comparator.comparingInt(Employee::getSalary));
        for (Employee e : arr) {
            e.showInfo();
        }
    }

    // SEARCHING
    // searching employee based on name
    public void searchByName(String name) {
        boolean flag= false;
        for (Employee e : mp.values()) {
            if (name.equals(e.getName())) {
                e.showInfo();
                flag=true;
            }
        }
        if (flag==false) {
            System.out.println("Employee not found!!");
        }
    }

    // searching employee based on position
    public void searchByPosition(String position) {
        boolean flag= false;
        for (Employee e : mp.values()) {
            if (position.equals(e.getPosition())){
                e.showInfo();
                flag=true;
            }
        }
        if (flag==false) {
            System.out.println("Employee not found!!");
        }
    }

    // searching employee based on salary
    public void searchBySalary(int sal) {
        boolean flag= false;
        for (Employee e : mp.values()) {
            if (sal == e.getSalary()) {
                e.showInfo();
                flag=true;
            }
        }
        if (flag==false) {
            System.out.println("Employee not found!!");
        }
    }

    public void searchByID(int sal) {
        boolean flag= false;
        for (Employee e : mp.values()) {
            if (sal == e.getEmpID()) {
                flag=true;
                e.showInfo();
            }
        }
        if (flag==false) {
            System.out.println("Employee not found!!");
        }
    }

    // Updating info of employee
    public void updateEmployeeInfo(int employeeID, String name, String position, int salary) {
        if (!mp.containsKey(employeeID)) {
            System.out.println("Employee not Found!");
        } else {
            Employee e = mp.get(employeeID);
            e.setEmpID(employeeID);
            e.setName(name);
            e.setPosition(position);
            e.setSalary(salary);

            mp.put(employeeID, e);
        }
    }
}


public class EmployeeManagementSystem {

    public static void main(String[] args) {
        EmployeeManagement ems = new EmployeeManagement();
        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        do {
            System.out.println("****************Welcome to the Employee Management System*****************");
            System.out.println("1. Add Employee\n" +
                    "2. Remove Employee\n" +
                    "3. Display Employee Information\n" +
                    "4. Display All Employees\n" +
                    "5. Calculate Total Salary\n" +
                    "6. Sort Employees by Salary\n" +
                    "7. Search Employees\n" +
                    "8. Update Employee Information\n" +
                    "9. Exit");

            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int empID = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Employee Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Employee Position: ");
                    String position = sc.nextLine();
                    System.out.print("Enter Employee Salary: ");
                    int salary = sc.nextInt();
                    System.out.println("Enter 'f' for full time employee , for part time employee enter 'p' ");
                    char c = sc.next().charAt(0);
                    if(c=='f'){
                        Employee newEmployee = new FullTimeEmployee(empID, name, position, salary);
                        ems.addEmp(newEmployee);
                    }
                    else if (c=='p') {
                        Employee newEmployee = new PartTimeEmployee(empID, name, position, salary);
                        ems.addEmp(newEmployee);
                    }
                    else{
                        System.out.println("Invalid inpu1!!");
                    }
                    break;
                case 2:
                    System.out.print("Enter Employee ID to remove: ");
                    int id = sc.nextInt();
                    ems.removeEmp(id);
                    break;
                case 3:
                    System.out.print("Enter Employee ID to display information: ");
                    int ID = sc.nextInt();
                    ems.displayInfo(ID);
                    break;
                case 4:
                    ems.displayAll();
                    break;
                case 5:
                    System.out.println("Total Salary: " + ems.totalSalary());
                    break;
                case 6:
                    ems.sortEmployee();
                    System.out.println("Employees sorted successfully according to their salary!");
                    break;
                case 7:
                    System.out.println("Search by:\n1. Name\n"+"2. Position\n"+"3. Salary\n"+ 
                                                "4. id");
                    System.out.print("Enter choice: ");
                    int search = sc.nextInt();
                    sc.nextLine(); 
                    switch (search) {
                        case 1:
                            System.out.print("Enter name to search: ");
                            String searchName = sc.nextLine();
                            ems.searchByName(searchName);
                            break;
                        case 2:
                            System.out.print("Enter position to search: ");
                            String searchPosition = sc.nextLine();
                            ems.searchByPosition(searchPosition);
                            break;
                        case 3:
                            System.out.print("Enter salary to search: ");
                            int searchSalary = sc.nextInt();
                            ems.searchBySalary(searchSalary);
                            break;
                        case 4:
                            System.out.print("Enter id to search: ");
                            int searchid = sc.nextInt();
                            ems.searchByID(searchid);

                        default:
                            System.out.println("Invalid choice!");
                    }
                    break;
                case 8:
                    System.out.print("Enter Employee ID to update information: ");
                    int updateID = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new Name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter new Position: ");
                    String newPosition = sc.nextLine();
                    System.out.print("Enter new Salary: ");
                    int newSalary = sc.nextInt();
                    ems.updateEmployeeInfo(updateID, newName, newPosition, newSalary);
                    break;
                case 9:
                    flag = false;
                    System.out.println("Exiting..");
                    break;
                default:
                    System.out.println("Invalid input!");
                    break;
            }
        } while (flag);
        sc.close();
    }
}
