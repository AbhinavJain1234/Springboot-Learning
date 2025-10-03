package com.abhinavjain.projectone.Project_1.understandingBeans;

/**
 * PaymentService Interface
 * 
 * This interface demonstrates the Strategy Pattern and Dependency Injection in Spring Boot.
 * 
 * Key Learning Points:
 * 1. Interface-based programming: Define contracts through interfaces
 * 2. Multiple implementations: Different payment providers can implement this interface
 * 3. Spring Bean Management: Spring can manage multiple implementations of the same interface
 * 4. Dependency Injection: Spring automatically injects the appropriate implementation
 * 
 * Benefits:
 * - Loose coupling between components
 * - Easy to add new payment providers
 * - Testable code (can mock implementations)
 * - Follows SOLID principles (Open/Closed, Dependency Inversion)
 * 
 * @author Abhinav Jain
 * @see com.abhinavjain.projectone.Project_1.understandingBeans.RazorPayPaymentService
 * @see com.abhinavjain.projectone.Project_1.understandingBeans.StripePaymentService
 */
public interface PaymentService {
    
    /**
     * Process a payment transaction
     * 
     * This method should be implemented by each payment provider
     * to handle their specific payment processing logic.
     * 
     * @return String confirmation message about the payment processing
     */
    String pay();
}
