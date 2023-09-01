package org.example;

/**
 * Hello world!
 *
 */
import DAO.IEmployeeDAOInterface;
import DAO.MysqlEmployeeDAO;
import DTO.Employee;
import Exceptions.DAOException;

import java.util.List;
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        IEmployeeDAOInterface employeeDAO = new MysqlEmployeeDAO();
        findAndPrintAllEmployees(employeeDAO);
    }


    private static void findAndPrintAllEmployees(IEmployeeDAOInterface employeeDAO)
    {
        try
        {
            List<Employee> employees = employeeDAO.findAllEmployees();
            for (Employee employee : employees)
            {
                System.out.println(employee);
            }
        }
        catch (DAOException e)
        {
            System.out.println("Failed to get all employees " + e.getMessage());
        }
    }
}