package gabi.clinic.demo.bootstrap;

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

    }
}
