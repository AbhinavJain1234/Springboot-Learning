package com.abhinavjain.projectone.Project_1;

import com.abhinavjain.projectone.Project_1.understandingBeans.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main Spring Boot Application Class
 * 
 * This is the entry point of our Spring Boot application. It demonstrates several key concepts:
 * 
 * 1. @SpringBootApplication: This is a meta-annotation that combines:
 *    - @Configuration: Marks this class as a source of bean definitions
 *    - @EnableAutoConfiguration: Enables Spring Boot's auto-configuration mechanism
 *    - @ComponentScan: Enables component scanning to find Spring components in the package hierarchy
 * 
 * 2. CommandLineRunner: Interface used to run specific code after the application context is loaded
 *    but before the application has fully started. Useful for initialization tasks.
 * 
 * 3. Dependency Injection: This class demonstrates two ways of injecting dependencies:
 *    - Field Injection (@Autowired)
 *    - Constructor Injection (recommended approach)
 * 
 * @author Abhinav Jain
 */
@SpringBootApplication
public class Project1Application implements CommandLineRunner {

    /**
     * Main method - Entry point of the Spring Boot application
     * 
     * SpringApplication.run() method:
     * 1. Creates an ApplicationContext
     * 2. Registers command-line arguments as Spring properties
     * 3. Loads all Spring beans
     * 4. Triggers auto-configuration
     * 5. Starts embedded web server (if web application)
     * 
     * @param args Command line arguments passed to the application
     */
	public static void main(String[] args) {
		SpringApplication.run(Project1Application.class, args);
	}

    /**
     * Field Injection Example
     * 
     * @Autowired annotation tells Spring to inject a PaymentService bean here.
     * Note: Field injection is not recommended as it makes testing difficult
     * and creates tight coupling. Use constructor injection instead.
     */
    @Autowired
    PaymentService paymentService1;

    /**
     * Constructor Injection Example (Recommended Approach)
     * 
     * This final field will be injected through constructor injection.
     * Benefits of constructor injection:
     * - Makes dependencies explicit and required
     * - Enables immutable objects (final fields)
     * - Easier to test (can create objects without Spring context)
     * - Prevents circular dependencies
     */
    private final PaymentService paymentService2;

    /**
     * Constructor for Dependency Injection
     * 
     * Spring will automatically call this constructor and inject the required dependencies.
     * When there's only one constructor, @Autowired is optional.
     * 
     * @param paymentService2 PaymentService implementation to be injected
     */
    public Project1Application(PaymentService paymentService2) {
        this.paymentService2 = paymentService2;
    }

    /**
     * CommandLineRunner implementation
     * 
     * This method runs after the Spring application context is loaded.
     * It's useful for:
     * - Database initialization
     * - Cache warming
     * - External service health checks
     * - Running one-time setup tasks
     * 
     * @param args Command line arguments
     * @throws Exception if any error occurs during execution
     */
    @Override
    public void run(String... args) throws Exception {
        System.out.println("=== Spring Boot Application Started ===");
        System.out.println("Demonstrating different dependency injection approaches:");
        
        System.out.println("\n1. Field Injection (@Autowired):");
        paymentService1.pay();
        
        System.out.println("\n2. Constructor Injection (Recommended):");
        paymentService2.pay();
        
        System.out.println("\n=== Demo completed ===");
    }
}
