package com.example;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class EmployeeClient {
    public static void main(String[] args) {
        try {
            // Set up the connection to the server
            URL url = new URL("http://localhost:8080/employees");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            // Read the response
            InputStreamReader reader = new InputStreamReader(connection.getInputStream());
            StringBuilder response = new StringBuilder();
            int i;
            while ((i = reader.read()) != -1) {
                response.append((char) i);
            }

            // Convert the response to a JSON array
            JSONArray employees = new JSONArray(response.toString());

            // Iterate through the JSON array and extract employee data
            for (int j = 0; j < employees.length(); j++) {
                JSONObject employee = employees.getJSONObject(j);
                int id = employee.getInt("id");
                String name = employee.getString("name");
                String position = employee.getString("position");
                int salary = employee.getInt("salary");

                // Print the employee's details
                System.out.println("Employee ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Position: " + position);
                System.out.println("Salary: " + salary);
                System.out.println("------------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
