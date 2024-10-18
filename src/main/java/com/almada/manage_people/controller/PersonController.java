package com.almada.manage_people.controller;

import com.almada.manage_people.dto.request.register.PersonRegisterDTO;
import com.almada.manage_people.dto.request.update.PersonUpdateDTO;
import com.almada.manage_people.dto.response.PersonResponseDTO;
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
        PersonResponseDTO person = personService.findById(id);
        return ResponseEntity.ok(person);
    }

    @PostMapping
    public ResponseEntity<PersonResponseDTO> Save(@RequestBody @Valid PersonRegisterDTO personRegisterDTO,
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

}
