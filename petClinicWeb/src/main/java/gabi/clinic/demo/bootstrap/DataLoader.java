package gabi.clinic.demo.bootstrap;

import gabi.clinic.demo.model.Owner;
import gabi.clinic.demo.model.Vet;
import gabi.clinic.demo.services.OwnerService;
import gabi.clinic.demo.services.VetService;
import gabi.clinic.demo.services.map.OwnerServiceMap;
import gabi.clinic.demo.services.map.vetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new vetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Tony");
        owner1.setLastName("Hawk");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner1.setId(2L);
        owner1.setFirstName("Bob");
        owner1.setLastName("Burnquist");
        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Anthony");
        vet1.setLastName("Robbins");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet1.setId(2L);
        vet1.setFirstName("Doctor");
        vet1.setLastName("Queen");

        vetService.save(vet2);

        System.out.println("Loaded vets...");


    }
}
