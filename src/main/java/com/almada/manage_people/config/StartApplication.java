package com.almada.manage_people.config;

import com.almada.manage_people.entity.Person;
import com.almada.manage_people.enumerated.MaritalStatus;
import com.almada.manage_people.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@RequiredArgsConstructor
public class StartApplication implements CommandLineRunner {

    private final PersonRepository personRepository;

    @Override
    public void run(String... args) throws Exception {

        personRepository.saveAll(
                Arrays.asList(
                        Person.builder().name("Figueiredo").email("fig@gmail.com").age(21).maritalStatus(MaritalStatus.SINGLE).build(),
                        Person.builder().name("Almeida").email("almeida@gmail.com").age(22).maritalStatus(MaritalStatus.SINGLE).build(),
                        Person.builder().name("Silva").email("silva@gmail.com").age(23).maritalStatus(MaritalStatus.MARRIED).build(),
                        Person.builder().name("Oliveira").email("oliveira@gmail.com").age(24).maritalStatus(MaritalStatus.SINGLE).build(),
                        Person.builder().name("Costa").email("costa@gmail.com").age(25).maritalStatus(MaritalStatus.DIVORCED).build(),
                        Person.builder().name("Santos").email("santos@gmail.com").age(26).maritalStatus(MaritalStatus.SINGLE).build(),
                        Person.builder().name("Pereira").email("pereira@gmail.com").age(27).maritalStatus(MaritalStatus.WIDOWER).build(),
                        Person.builder().name("Ferreira").email("ferreira@gmail.com").age(28).maritalStatus(MaritalStatus.MARRIED).build(),
                        Person.builder().name("Rodrigues").email("rodrigues@gmail.com").age(29).maritalStatus(MaritalStatus.SINGLE).build(),
                        Person.builder().name("Martins").email("martins@gmail.com").age(30).maritalStatus(MaritalStatus.DIVORCED).build(),
                        Person.builder().name("Gomes").email("gomes@gmail.com").age(31).maritalStatus(MaritalStatus.WIDOWER).build(),
                        Person.builder().name("Ribeiro").email("ribeiro@gmail.com").age(32).maritalStatus(MaritalStatus.MARRIED).build(),
                        Person.builder().name("Carvalho").email("carvalho@gmail.com").age(33).maritalStatus(MaritalStatus.SINGLE).build(),
                        Person.builder().name("Teixeira").email("teixeira@gmail.com").age(34).maritalStatus(MaritalStatus.DIVORCED).build(),
                        Person.builder().name("Lima").email("lima@gmail.com").age(35).maritalStatus(MaritalStatus.SINGLE).build(),
                        Person.builder().name("Barros").email("barros@gmail.com").age(36).maritalStatus(MaritalStatus.WIDOWER).build(),
                        Person.builder().name("Sousa").email("sousa@gmail.com").age(37).maritalStatus(MaritalStatus.MARRIED).build(),
                        Person.builder().name("Mendes").email("mendes@gmail.com").age(38).maritalStatus(MaritalStatus.SINGLE).build(),
                        Person.builder().name("Araújo").email("araujo@gmail.com").age(39).maritalStatus(MaritalStatus.DIVORCED).build()
                )
        );

    }
}
