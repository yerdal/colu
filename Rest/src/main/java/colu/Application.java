package colu;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.util.ArrayList;


/**
 * Starting the application with right configurations, init database etc.
 */
@SpringBootApplication
public class Application extends ParsingXML implements CommandLineRunner{

    @Autowired
    ParametersRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        ArrayList<OngoingVoyages> ongoingVoyages = new ArrayList<OngoingVoyages>();
        ongoingVoyages = getXMLOngoingVoyages();

        for(int i = 0; i < ongoingVoyages.size();i++){
            //System.out.println("Ongoning voyage ID " + ongoingVoyages.get(i).getVoyageId());
            //id , requiredCurrentSpeed, requiredWindSpee, requiredWindDir,requiredSignWaveHeight,requiredCurrentDir,requiredAvgSpeedMin,requiredAvgSpeedMax
            repository.save(new SavedParameters((ongoingVoyages.get(i).getVoyageId()), 0.5 ,15.0, 120, 1.5, 26.2, 16.2, 18.0, "", ""));
        }
        //SHIPOperator inputs 
        
        

        System.out.println("Operator saved voyage ID found with findAll():");
        System.out.println("-------------------------------");
        for (SavedParameters savedParameters : repository.findAll()) {
            System.out.println(savedParameters.getId());
        }
        System.out.println();

        // // fetch an individual savedParameters by VoyageID
        // SavedParameters savedParameters = repository.findOne(89710);
        // System.out.println("SavedParameters found with findOne(89710):");
        // System.out.println("--------------------------------");
        // System.out.println(savedParameters.getRequiredCurrentDir());
        // System.out.println();
    }
}