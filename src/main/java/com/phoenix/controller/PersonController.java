package com.phoenix.controller;

import com.phoenix.entity.Person;
import com.phoenix.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/list")
    public List<Person> list(){
        return personService.list();
    }

    @GetMapping("/pageList")
    public List<Person> pageList(@RequestParam(value = "pageNo",defaultValue = "1")Integer pageNo,@RequestParam(value = "pageCount",defaultValue = "10") Integer pageCount){

        return personService.pageList(pageNo,pageCount);
    }

    @GetMapping("/get/{id}")
    public Person get(@PathVariable(value = "id") Integer id){
        return personService.get(id);
    }

    @GetMapping("/getMany")
    public List<Person> getMany(String  ids){
        return personService.getMany(ids);
    }

    @GetMapping("/countSex")
    public Long countSex(String sex){
        return personService.countSex(sex);
    }



    @PostMapping("/save")
    public String list(int count){
        return personService.save(count);
    }

    @RequestMapping("/deleteAll")
    public long deleteAll(){
        return personService.deleteAll();
    }

}
