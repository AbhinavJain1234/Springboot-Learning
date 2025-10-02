package com.abhinavjain.projectone.Project_1;

import com.abhinavjain.projectone.Project_1.understandingBeans.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Project1Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Project1Application.class, args);
	}

    @Autowired
    PaymentService paymentService1;

    private final PaymentService paymentService2;

    public Project1Application(PaymentService paymentService2) {
        this.paymentService2 = paymentService2;
    }

    @Override
    public void run(String... args) throws Exception {
        paymentService1.pay();
        paymentService2.pay();
    }
}
