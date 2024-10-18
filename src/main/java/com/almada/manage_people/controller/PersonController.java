package com.almada.manage_people.controller;

import com.almada.manage_people.dto.request.register.PersonRegisterDTO;
import com.almada.manage_people.dto.request.update.PersonUpdateDTO;
import com.almada.manage_people.dto.response.PersonResponseDTO;
import com.almada.manage_people.entity.Person;
import com.almada.manage_people.enumerated.MaritalStatus;
import com.almada.manage_people.service.PersonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/people")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping
    public ResponseEntity<Page<PersonResponseDTO>> findPage(@PageableDefault(size = 8, sort = "name") Pageable pageable) {
        return ResponseEntity.ok(personService.findPage(pageable));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PersonResponseDTO> findPage(@PathVariable Long id) {
        return ResponseEntity.ok(personService.findById(id));
    }

    @PostMapping
    public ResponseEntity<PersonResponseDTO> save(@RequestBody @Valid PersonRegisterDTO personRegisterDTO,
                                                  UriComponentsBuilder uriBuilder) {

        PersonResponseDTO personResponseDTO = personService.save(personRegisterDTO);

        URI uri = uriBuilder.path("/people/{id}").buildAndExpand(personResponseDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(personResponseDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PersonResponseDTO> update(@PathVariable Long id, @RequestBody @Valid PersonUpdateDTO personUpdateDTO) {
        return ResponseEntity.ok(personService.update(id, personUpdateDTO));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        personService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/figueiredo")
    public ResponseEntity<PersonResponseDTO> buscaFigueiredo() {
        Person person = Person.builder()
                .name("Figueiredo")
                .email("fig@gmail.com")
                .age(21)
                .maritalStatus(MaritalStatus.SINGLE)
                .build();

        PersonResponseDTO personResponseDTO = new PersonResponseDTO(person);

        return ResponseEntity.ok(personResponseDTO);
    }

}
