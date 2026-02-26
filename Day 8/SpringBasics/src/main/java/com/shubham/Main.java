package com.shubham;

import com.shubham.model.Trader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
    public static void main(String[] args) {
        System.out.println("=== SPRING FRAMEWORK EXAMPLE ===\n");

        // Load Spring configuration
        ApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");

        // Get bean from Spring container
        Trader trader = context.getBean("trader", Trader.class);

        // Use the bean
        trader.executeTrade("RELIANCE", 2500, 10);

        System.out.println("\n=== WHAT JUST HAPPENED? ===");
        System.out.println("1. Spring read beans.xml configuration");
        System.out.println("2. Spring created ZerodhaBroker object");
        System.out.println("3. Spring created Trader object");
        System.out.println("4. Spring INJECTED broker into trader automatically");
        System.out.println("5. We just asked Spring for 'trader' bean and used it");
        System.out.println("\nThis is IoC (Inversion of Control)!");
        System.out.println("We didn't create objects - Spring did it for us!");
    }
}