package gabi.clinic.demo.bootstrap;

import gabi.clinic.demo.model.*;
import gabi.clinic.demo.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if(count == 0){
            loadData();
        }
    }

    private void loadData() {

        PetType savedDogPetType = petTypeService.save(PetType.builder().name("Dog").build());
        PetType savedCatPetType = petTypeService.save(PetType.builder().name("Cat").build());
        System.out.println("Loaded PetTypes...");


        Speciality savedRadiology = specialityService.save(Speciality.builder().description("Radiology").build());
        Speciality savedSurgery = specialityService.save(Speciality.builder().description("Surgery").build());
        Speciality savedDentistry = specialityService.save(Speciality.builder().description("Dentistry").build());
        System.out.println("Loaded specialities...");

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

        Visit catVisit = new Visit();
        catVisit.setPet(bobsPet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy kitty");

        visitService.save(catVisit);

        Visit dogVisit = new Visit();
        dogVisit.setPet(tonysPet);
        dogVisit.setDate(LocalDate.now());
        dogVisit.setDescription("Sneezy doggy");

        visitService.save(dogVisit);

        Vet vet1 = new Vet();
        vet1.setFirstName("Anthony");
        vet1.setLastName("Robbins");
        vet1.getSpecialities().add(savedSurgery);
        vet1.getSpecialities().add(savedDentistry);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Doctor");
        vet2.setLastName("Queen");
        vet2.getSpecialities().add(savedSurgery);
        vet2.getSpecialities().add(savedDentistry);
        vet2.getSpecialities().add(savedRadiology);

        vetService.save(vet2);

        System.out.println("Loaded vets...");
    }
}
