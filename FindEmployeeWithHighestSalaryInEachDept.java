package StreamAPI;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindEmployeeWithHighestSalaryInEachDept {
	
	public static void main(String[] args) {
		
		List<Employee> employees=Stream.of(
				new Employee(1, "Md Irfan", "DEV", 50000),
				new Employee(2, "Sumit", "DEV", 10000),
				new Employee(3, "Prince", "QA", 15000),
				new Employee(4, "Gaurav", "QA", 11000),
				new Employee(5, "Nikhil", "BA", 20000))
				.toList();
				
		
		   // Comparator to compare employees by salary in descending order
        Comparator<Employee> comparingBySalary = Comparator.comparing(Employee::getSalary);
        
        // Finding the highest salary employee in each department
        Map<String, Optional<Employee>> highestSalaryInEachDept = employees.stream()
            .collect(Collectors.groupingBy(
                Employee::getDept,
                Collectors.reducing(
                    BinaryOperator.maxBy(comparingBySalary))));
        
        System.out.println(highestSalaryInEachDept);
                    
             
	}
}
	
	


