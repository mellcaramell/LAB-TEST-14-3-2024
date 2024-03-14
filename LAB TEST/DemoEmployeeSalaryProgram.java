/**
 * Program Description: To process employee salary data based on a given class diagram and an input file called "employeeSalaries.txt"
 * Programmer: mell
 * Date: 14/03/2024
 * 
 */

import java.io.*;
import java.util.StringTokenizer;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class DemoEmployeeSalaryProgram
{
    public static void main(String[]args) throws IOException
    {
        DecimalFormat dF = new DecimalFormat("£ 0.00");
        try
        {
            //input file
            BufferedReader inputFile = new BufferedReader(new FileReader("employeeSalaries.txt"));
            //output files
            PrintWriter outputFile = new PrintWriter(new FileWriter("employeeName.txt"));
            

            //Declare the variables
            String inputData = null;
            String employeeName = " ";
            double employeeSalary = 0.00;
            int employeeWorkingYear = 0;

            //variable for top performing employee
            String top_employeeName = " ";
            double top_employeeAnnualSalary = 0.00;
            int top_employeeWorkingYear = 0;

            //variable for latest employee
            String latest_employeeName = " ";
            double latest_employeeAnnualSalary = 0.00;
            int latest_employeeWorkingYear = 0;

            //Write the title header
            outputFile.println("\n\n==================== List of Employees ====================");
            while((inputData = inputFile.readLine()) != null)
            {
                StringTokenizer tokenizer = new StringTokenizer(inputData,"|");

                employeeName = tokenizer.nextToken();
                employeeSalary = Double.parseDouble (tokenizer.nextToken());
                employeeWorkingYear= Integer.parseInt(tokenizer.nextToken());

                double annualSalary = employeeSalary + (employeeSalary * 0.05);

                //to test the negative number
                if(employeeSalary < 0 || employeeWorkingYear < 0)
                    throw new IllegalArgumentException();

                //find the top performing employee
                if(annualSalary > top_employeeAnnualSalary)
                {
                    top_employeeName = employeeName;
                    top_employeeAnnualSalary = annualSalary;
                    top_employeeWorkingYear = employeeWorkingYear;
                }

                //find the employee with least years of services
                if(latest_employeeWorkingYear == 0 || employeeWorkingYear < latest_employeeWorkingYear){
                    latest_employeeName = employeeName;
                    latest_employeeAnnualSalary = annualSalary;
                    latest_employeeWorkingYear = employeeWorkingYear;

                }

                String employeeData = employeeName + "\t\t £ " + annualSalary + "\t\t (" + employeeWorkingYear + " years)";
                outputFile.println(employeeData);

            }
            //top performing employee
            outputFile.println("\n\n**************************************************************" );
            outputFile.println("\n\n==================== Top Performing Employee ====================" );
            String top_employeeData = top_employeeName + "\t\t £ " + top_employeeAnnualSalary + "\t\t (" + top_employeeWorkingYear + " years)";
            outputFile.println(top_employeeData);
            
            //display top performing employee
            JOptionPane.showMessageDialog(null, "======= Top Performing Employee =======\n" + top_employeeData + "\n⋆ ˚｡⋆ʚ🎀ɞ⋆ ˚｡⋆ ‎⋆ ˚｡⋆ʚ🎀ɞ⋆ ˚｡⋆ ‎⋆ ˚｡⋆ʚ🎀ɞ⋆ ˚｡⋆",
            "⋆˚ʚɞ", JOptionPane.INFORMATION_MESSAGE);
            
            //latest employee
            outputFile.println("\n\n*************************************************************" );
            outputFile.println("\n\n============== Employee With The Least Years of Services ==============" );
            String latest_employeeData = latest_employeeName + "\t\t £ " + latest_employeeAnnualSalary + "\t\t (" + latest_employeeWorkingYear + " years)";
            outputFile.println(latest_employeeData);
            
            //display top performing employee
            JOptionPane.showMessageDialog(null, "====== Employee With The Least Years of Services ======\n" + latest_employeeData + "\n‎⋆ ˚｡⋆ʚ🎀ɞ⋆ ˚｡⋆ ‎⋆ ˚｡⋆ʚ🎀ɞ⋆ ˚｡⋆ ‎⋆ ˚｡⋆ʚ🎀ɞ⋆ ˚｡⋆ ‎⋆ ˚｡⋆ʚ🎀ɞ⋆ ˚｡⋆ ",
            "⋆˚ʚɞ", JOptionPane.INFORMATION_MESSAGE);
            
            //close all files
            inputFile.close();
            outputFile.close();
        }
        catch(FileNotFoundException ex)
        {
            String output="File not found";
            JOptionPane.showMessageDialog(null, output);
        }
        catch(IllegalArgumentException iae)
        {
            String output="Invalid input!";
            JOptionPane.showMessageDialog(null, output);
        }
    }
}