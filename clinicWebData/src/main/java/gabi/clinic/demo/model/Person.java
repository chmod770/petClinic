package gabi.clinic.demo.model;

import lombok.Setter;
import lombok.Getter;

@Getter @Setter
public class Person extends BaseEntity{

    private String firstName;
    private String lastName;

}
