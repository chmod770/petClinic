package gabi.clinic.demo.bootstrap;

import gabi.clinic.demo.model.Owner;
import gabi.clinic.demo.model.Pet;
import gabi.clinic.demo.model.PetType;
import gabi.clinic.demo.model.Vet;
import gabi.clinic.demo.services.OwnerService;
import gabi.clinic.demo.services.PetTypeService;
import gabi.clinic.demo.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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
        owner1.setAddress("Cuba 20");
        owner1.setCity("Los Angeles");
        owner1.setTelephone("123321123");

        Pet tonysPet = new Pet();
        tonysPet.setPetType(savedDogPetType);
        tonysPet.setOwner(owner1);
        tonysPet.setName("Puppy");
        tonysPet.setBirthDate(LocalDate.now());

        owner1.getPets().add(tonysPet);



        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Bob");
        owner2.setLastName("Burnquist");
        owner2.setAddress("Carolina 23");
        owner2.setCity("Peuerto Rico");
        owner2.setTelephone("234432234");

        Pet bobsPet = new Pet();
        bobsPet.setPetType(savedCatPetType);
        bobsPet.setOwner(owner2);
        bobsPet.setName("Fiona");
        bobsPet.setBirthDate(LocalDate.now());

        owner2.getPets().add(bobsPet);

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

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
