package com.abhinavjain.projectone.Project_1.understandingBeans;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/**
 * RazorPay Payment Service Implementation
 * 
 * This class demonstrates several important Spring Boot concepts:
 * 
 * 1. @Component: Marks this class as a Spring-managed bean
 *    - Spring will create and manage the lifecycle of this object
 *    - Available for dependency injection throughout the application
 * 
 * 2. @ConditionalOnProperty: Conditional bean creation based on application properties
 *    - This bean will only be created if payment.provider=razorpay in application.properties
 *    - Enables configuration-driven component selection
 *    - Useful for environment-specific implementations (dev, test, prod)
 * 
 * 3. Interface Implementation: Implements PaymentService contract
 *    - Provides RazorPay-specific payment processing logic
 *    - Can be easily swapped with other payment providers
 * 
 * Real-world usage:
 * - Different payment gateways for different regions
 * - Switch between test and production payment providers
 * - A/B testing different payment solutions
 * 
 * @author Abhinav Jain
 */
@Component
@ConditionalOnProperty(name = "payment.provider", havingValue = "razorpay")
public class RazorPayPaymentService implements PaymentService {

    /**
     * Process payment using RazorPay gateway
     * 
     * In a real application, this method would:
     * - Validate payment details
     * - Call RazorPay APIs
     * - Handle payment responses
     * - Log transaction details
     * - Update order status
     * 
     * @return confirmation message for RazorPay payment processing
     */
    @Override
    public String pay() {
        String payment = "RazorPay Payment Gateway";
        System.out.println("✓ Processing payment through: " + payment);
        System.out.println("  → Payment method: UPI/Cards/NetBanking");
        System.out.println("  → Region: India");
        System.out.println("  → Currency: INR");
        return payment;
    }
}
