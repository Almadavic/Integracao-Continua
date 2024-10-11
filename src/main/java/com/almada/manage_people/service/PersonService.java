package com.almada.manage_people.service;

import com.almada.manage_people.dto.request.register.PersonRegisterDTO;
import com.almada.manage_people.dto.request.update.PersonUpdateDTO;
import com.almada.manage_people.dto.response.PersonResponseDTO;
import com.almada.manage_people.entity.Person;
import com.almada.manage_people.mapper.PersonMapper;
import com.almada.manage_people.repository.PersonRepository;
import com.almada.manage_people.service.exception_custom.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository repository;

    public Page<PersonResponseDTO> findPage(Pageable pageable) {
        return PersonMapper.toDTOPage(
                repository.findAll(pageable)
        );
    }

    public PersonResponseDTO findById(Long id) {
        return PersonMapper.toDTO(
                RecoverById(id)
        );
    }

    public PersonResponseDTO save(PersonRegisterDTO personRegisterDTO) {

        Person person = PersonMapper.toEntity(personRegisterDTO);

        return PersonMapper.toDTO(
                repository.save(person)
        );
    }

    public PersonResponseDTO update(Long id, PersonUpdateDTO personUpdateDTO) {

        Person person = RecoverById(id);

        PersonMapper.update(person, personUpdateDTO);

        return PersonMapper.toDTO(
                repository.save(person)
        );
    }

    public void delete(Long id) {
        repository.delete(RecoverById(id));
    }

    private Person RecoverById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person id: " + id + " not found"));
    }

}
