package gabi.clinic.demo.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class PetType extends BaseEntity{
    private String name;
}
