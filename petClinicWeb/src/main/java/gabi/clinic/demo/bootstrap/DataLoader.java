package gabi.clinic.demo.bootstrap;

import gabi.clinic.demo.model.Owner;
import gabi.clinic.demo.model.PetType;
import gabi.clinic.demo.model.Vet;
import gabi.clinic.demo.services.OwnerService;
import gabi.clinic.demo.services.PetTypeService;
import gabi.clinic.demo.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;

    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat= new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);
        System.out.println("Loaded PetTypes...");


        Owner owner1 = new Owner();
        owner1.setFirstName("Tony");
        owner1.setLastName("Hawk");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Bob");
        owner2.setLastName("Burnquist");
        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Anthony");
        vet1.setLastName("Robbins");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Doctor");
        vet2.setLastName("Queen");

        vetService.save(vet2);

        System.out.println("Loaded vets...");


    }
}
