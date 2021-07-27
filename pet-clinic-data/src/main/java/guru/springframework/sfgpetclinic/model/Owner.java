package guru.springframework.sfgpetclinic.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "owners")
public class Owner extends Person {

    @Builder
    public Owner(Long id, String firstName, String lastName, String address, String city,
                 String telephone, Set<Pet> pets) {
        super(id, firstName, lastName);
        this.address = address;
        this.city = city;
        this.telephone = telephone;
    }

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "telephone")
    private String telephone;

    // one Owner can have many Pets
    // if delete Owner all related Pets will be deleted
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

    //Builder pattern

//    public static Builder builder() {
//        return new Builder();
//    }
//
//    public static class Builder {
//        private Owner owner;
//
//        public Builder() {
//            owner = new Owner();
//        }
//
//        public Builder id(Long id) {
//            owner.setId(id);
//            return this;
//        }
//
//        public Owner build() {
//            return owner;
//        }
//    }

    @Override
    public String toString() {
        return "Owner{" +
                "id='" + super.getId() + '\'' +
                ", city='" + city + '\'' +
                ", telephone='" + telephone + '\'' +
                ", pets=" + pets +
                '}';
    }
}
