package org.spring;

import org.springframework.web.client.RestTemplate;


import org.spring.model.Employee;

import java.util.LinkedHashMap;
import java.util.List;

public class App
{
    public static final String SERVER_URI = "http://localhost:8086/springMVCRest";

    public static void main( String[] args )
    {
                CreateEmployee();

                GetEmployeeById();

                GetAllEmployee();

            }

            private static void GetAllEmployee() {
                RestTemplate restTemplate = new RestTemplate();
                List<LinkedHashMap> emp = restTemplate.getForObject(SERVER_URI+"/findEmp", List.class);
                System.out.println("List of Employees: ");
                for(LinkedHashMap map : emp){
                    System.out.println("ID="+map.get("id")+",Name="+map.get("name")+",department="+map.get("department"));
                }
            }

            private static void CreateEmployee() {
                RestTemplate restTemplate = new RestTemplate();
                Employee emp = new Employee();
                emp.setId(1);
                emp.setName("gagandeep kaur");
                emp.setDepartment("CS");
                System.out.println("Added Employee: ");
                Employee response = restTemplate.postForObject(SERVER_URI+"/addEmp", emp, Employee.class);
                printEmpData(response);
            }

            private static void GetEmployeeById() {
                RestTemplate restTemplate = new RestTemplate();
                System.out.println("Employee details found for given id: ");
                Employee emp = restTemplate.getForObject(SERVER_URI+"/findByID/1", Employee.class);
                printEmpData(emp);
            }


            public static void printEmpData(Employee emp){
                System.out.println("ID="+emp.getId()+",Name="+emp.getName()+",department="+emp.getDepartment());
            }
        }


