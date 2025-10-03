package com.abhinavjain.projectone.Project_1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Welcome Controller - Basic Spring Boot Web Concepts
 * 
 * This controller demonstrates fundamental Spring Boot web features:
 * 
 * 1. Basic request mapping and handling
 * 2. Path variables and request parameters
 * 3. Property injection from application.properties
 * 4. JSON response creation
 * 5. HTTP method handling (GET, POST)
 * 
 * This is perfect for beginners to understand how Spring Boot handles web requests
 * before diving into more complex CRUD operations.
 * 
 * Test these endpoints:
 * - GET  /                    -> Welcome message
 * - GET  /hello              -> Simple hello world
 * - GET  /hello/{name}       -> Personalized greeting
 * - GET  /info               -> Application information
 * - GET  /time               -> Current server time
 * - POST /echo               -> Echo back request data
 * 
 * @author Abhinav Jain
 */
@RestController
public class WelcomeController {

    /**
     * Property Injection Example
     * 
     * @Value annotation injects values from application.properties
     * This demonstrates configuration-driven development
     */
    @Value("${app.description:Spring Boot Learning Project}")
    private String appDescription;
    
    @Value("${app.author:Abhinav Jain}")
    private String appAuthor;

    /**
     * Root endpoint - Application welcome page
     * 
     * Accessible at: GET http://localhost:8080/
     * 
     * @return Welcome message with basic navigation info
     */
    @GetMapping("/")
    public Map<String, Object> welcome() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "🚀 Welcome to Spring Boot Learning Project!");
        response.put("description", "This project demonstrates various Spring Boot concepts");
        response.put("author", appAuthor);
        response.put("availableEndpoints", new String[]{
            "GET /hello - Simple hello world",
            "GET /hello/{name} - Personalized greeting", 
            "GET /info - Application information",
            "GET /time - Current server time",
            "GET /students - Student CRUD operations",
            "POST /echo - Echo request data"
        });
        response.put("timestamp", LocalDateTime.now());
        return response;
    }

    /**
     * Simple Hello World endpoint
     * 
     * Accessible at: GET http://localhost:8080/hello
     * 
     * @return Simple greeting message
     */
    @GetMapping("/hello")
    public Map<String, String> hello() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello, World!");
        response.put("tip", "Try /hello/{yourName} for a personalized greeting");
        return response;
    }

    /**
     * Personalized greeting with path variable
     * 
     * Accessible at: GET http://localhost:8080/hello/John
     * 
     * @PathVariable demonstrates how to extract values from URL path
     * 
     * @param name The name from the URL path
     * @return Personalized greeting message
     */
    @GetMapping("/hello/{name}")
    public Map<String, String> helloName(@PathVariable String name) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello, " + name + "! 👋");
        response.put("note", "This demonstrates @PathVariable usage");
        return response;
    }

    /**
     * Application information endpoint
     * 
     * Accessible at: GET http://localhost:8080/info
     * 
     * Demonstrates property injection from application.properties
     * 
     * @return Application metadata and configuration
     */
    @GetMapping("/info")
    public Map<String, Object> appInfo() {
        Map<String, Object> info = new HashMap<>();
        info.put("applicationName", "Spring Boot Learning Project");
        info.put("description", appDescription);
        info.put("author", appAuthor);
        info.put("springBootFeatures", new String[]{
            "Dependency Injection",
            "Auto Configuration", 
            "REST API Development",
            "Data JPA Integration",
            "Property Configuration",
            "Conditional Beans"
        });
        return info;
    }

    /**
     * Current server time endpoint
     * 
     * Accessible at: GET http://localhost:8080/time
     * 
     * @return Current server timestamp and timezone info
     */
    @GetMapping("/time")
    public Map<String, Object> currentTime() {
        Map<String, Object> timeInfo = new HashMap<>();
        timeInfo.put("currentTime", LocalDateTime.now());
        timeInfo.put("timezone", System.getProperty("user.timezone"));
        timeInfo.put("epoch", System.currentTimeMillis());
        return timeInfo;
    }

    /**
     * Echo endpoint - demonstrates POST request handling
     * 
     * Accessible at: POST http://localhost:8080/echo
     * 
     * Request Body Example:
     * {
     *   "message": "Hello Spring Boot",
     *   "sender": "John Doe"
     * }
     * 
     * @RequestBody demonstrates how to receive JSON data in POST requests
     * 
     * @param requestData The JSON data sent in the request body
     * @return Echo response with the received data plus server info
     */
    @PostMapping("/echo")
    public Map<String, Object> echo(@RequestBody Map<String, Object> requestData) {
        Map<String, Object> response = new HashMap<>();
        response.put("echo", "You sent: " + requestData);
        response.put("receivedAt", LocalDateTime.now());
        response.put("note", "This demonstrates @RequestBody usage for POST requests");
        response.put("httpMethod", "POST");
        return response;
    }

    /**
     * Query parameter example
     * 
     * Accessible at: GET http://localhost:8080/greet?name=John&message=Welcome
     * 
     * @RequestParam demonstrates how to handle query parameters
     * 
     * @param name Optional name parameter (defaults to "Guest")
     * @param message Optional message parameter (defaults to "Hello")
     * @return Greeting with query parameters
     */
    @GetMapping("/greet")
    public Map<String, String> greetWithParams(
            @RequestParam(defaultValue = "Guest") String name,
            @RequestParam(defaultValue = "Hello") String message) {
        
        Map<String, String> response = new HashMap<>();
        response.put("greeting", message + ", " + name + "!");
        response.put("note", "This demonstrates @RequestParam usage");
        response.put("example", "Try: /greet?name=John&message=Welcome");
        return response;
    }
}