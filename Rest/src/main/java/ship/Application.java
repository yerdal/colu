package ship;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    ParametersRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        // save a couple of customers
        // repository.save(new SavedParameters(0,0,0,0,0,0,0, "stan "));
        // repository.save(new SavedParameters(0,0,0,0,0,0,0, "s1"));
        // repository.save(new SavedParameters(0,0,0,0,0,0,0, "Blo"));
        // repository.save(new SavedParameters(0,0,0,0,0,0,0," Bahs"));
        //SHIPOperator inputs 
      
        repository.save(new SavedParameters(0.1,15.0 , 120 ,0.4 , 26.2 ,16.2,18.0 , "00-00-00 00:00"));

        // fetch all customers
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (SavedParameters customer : repository.findAll()) {
            System.out.println(customer.getRequiredETA());
        }
        System.out.println();

        // fetch an individual customer by ID
        SavedParameters customer = repository.findOne(1L);
        System.out.println("SavedParameters found with findOne(1L):");
        System.out.println("--------------------------------");
        System.out.println(customer.getRequiredETA());
        System.out.println();

        // fetch customers by last name
        // System.out.println("SavedParameters found with findByLastName('Bauer'):");
        // System.out.println("--------------------------------------------");
        // for (SavedParameters bauer : repository.findByRequiredETA("Bauer")) {
        //     System.out.println(bauer.getRequiredETA());
        // }
    }
}