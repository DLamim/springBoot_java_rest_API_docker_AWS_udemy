package com.erudio.service;

import com.erudio.data.vo.v1.PersonVO;
import com.erudio.exceptions.ResourceNotFoundException;
import com.erudio.mapper.DozerMapper;
import com.erudio.model.Person;
import com.erudio.repository.PersonRepository;
import com.github.dozermapper.core.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonService {

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    PersonRepository personRepository;

    public List<PersonVO> findAll() {

        logger.info("Finding all people!");

        return DozerMapper.parseListObjects(personRepository.findAll(), PersonVO.class) ;
    }

    public PersonVO findById(Long id) {

        logger.info("Finding one person!");

        var entity = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No results for this ID"));

        return DozerMapper.parseObject(entity, PersonVO.class);
    }

    public PersonVO create(PersonVO person) {

        logger.info("Creating one person!");

        var entity = DozerMapper.parseObject(person, Person.class);
        entity = personRepository.save(entity);

        return DozerMapper.parseObject(entity, PersonVO.class);
    }

    public PersonVO update(PersonVO person) {

        logger.info("Updating one person!");

        Person entity = personRepository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No results for this ID"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        var vo = DozerMapper.parseObject(personRepository.save(entity), PersonVO.class);

        return vo;
    }

    public void delete(Long id) {

        logger.info("Deleting one person!");

        Person entity = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No results for this ID"));

        personRepository.delete(entity);
    }
}
