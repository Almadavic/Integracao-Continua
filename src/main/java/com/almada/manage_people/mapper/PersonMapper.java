package com.almada.manage_people.mapper;

import com.almada.manage_people.dto.request.register.PersonRegisterDTO;
import com.almada.manage_people.dto.request.update.PersonUpdateDTO;
import com.almada.manage_people.dto.response.PersonResponseDTO;
import com.almada.manage_people.entity.Person;
import com.almada.manage_people.util.ConvertUtils;
import org.springframework.data.domain.Page;

public class PersonMapper {

    private PersonMapper() {

    }

    public static Person toEntity(PersonRegisterDTO personDTO) {
        return Person.builder()
                .name(personDTO.name())
                .email(personDTO.email())
                .maritalStatus(ConvertUtils.convertMaritalStatus(personDTO.maritalStatus()))
                .age(personDTO.age())
                .build();
    }

    public static void update(Person person, PersonUpdateDTO personDTO) {
        person.setName(personDTO.name());
        person.setEmail(personDTO.email());
        person.setMaritalStatus(ConvertUtils.convertMaritalStatus(personDTO.maritalStatus()));
        person.setAge(personDTO.age());
    }

    public static PersonResponseDTO toDTO(Person person) {
        return new PersonResponseDTO(person);
    }

    public static Page<PersonResponseDTO> toDTOPage(Page<Person> people) {
        return people.map(PersonMapper::toDTO);
    }

}
