package com.abhinavjain.projectone.Project_1.understandingBeans;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/**
 * Stripe Payment Service Implementation
 * 
 * This class demonstrates the same Spring Boot concepts as RazorPayPaymentService
 * but configured for a different payment provider.
 * 
 * Key Learning Points:
 * 1. Multiple implementations of the same interface
 * 2. Configuration-based bean selection using @ConditionalOnProperty
 * 3. Clean separation of concerns for different payment providers
 * 
 * To activate this implementation:
 * Set payment.provider=stripe in application.properties
 * 
 * Benefits of this approach:
 * - Easy to switch payment providers without code changes
 * - Support for multiple payment gateways in the same application
 * - Environment-specific configurations (test vs production gateways)
 * - Gradual migration from one provider to another
 * 
 * @author Abhinav Jain
 */
@Component
@ConditionalOnProperty(name = "payment.provider", havingValue = "stripe")
public class StripePaymentService implements PaymentService {

    /**
     * Process payment using Stripe gateway
     * 
     * In a real application, this would integrate with Stripe's APIs
     * to handle international payments, subscriptions, and marketplace payments.
     * 
     * @return confirmation message for Stripe payment processing
     */
    @Override
    public String pay() {
        String payment = "Stripe Payment Gateway";
        System.out.println("✓ Processing payment through: " + payment);
        System.out.println("  → Payment method: Credit/Debit Cards");
        System.out.println("  → Region: Global");
        System.out.println("  → Currency: Multi-currency support");
        return payment;
    }
}
