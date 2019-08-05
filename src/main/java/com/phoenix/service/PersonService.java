package com.phoenix.service;

import com.clearspring.analytics.util.Lists;
import com.phoenix.entity.Person;
import com.phoenix.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@SuppressWarnings("all")
public class PersonService {

    @Autowired
    private PersonMapper personMapper;

    public List<Person> list() {
        return personMapper.listPerson();
    }

    private String[] genders = {"male","female"};

    public String save(int count) {

        Person lastPerson = personMapper.getLastPerson();
        Integer lastPersonId;
        if(lastPerson == null){
            lastPersonId = 0;
        }else {
            lastPersonId = lastPerson.getId();
        }
        Random random = new Random();
        List<Person> personList = Lists.newArrayList();
        for (int i = 0; i < count; i++) {
            lastPersonId ++;
            Person person = new Person();
            person.setId(lastPersonId);
            person.setAge(random.nextInt(100)+1);
            person.setName("张三"+person.getId());
            person.setSex(genders[random.nextInt(2)]);
            personList.add(person);
            personMapper.save(person);
        }
        return "success";
    }

    public Long deleteAll() {
        return personMapper.deleteAll();
    }

    public List<Person> pageList(Integer pageNo, Integer pageCount) {
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("startId",(pageNo-1)*pageCount);
        paramMap.put("pageCount",pageCount);
        //select * from tableName limit 10 offset 1；  分页这么用
        return personMapper.pageList(paramMap);
    }

    public Person get(Integer id) {
        return personMapper.get(id);
    }

    public List<Person> getMany(String ids) {
        String[] idArray = ids.split(",");
        List<Integer> idList = new ArrayList<>();
        for(String id : idArray){
            idList.add(Integer.valueOf(id));
        }

        return personMapper.getMany(idList);
    }

    public Long countSex(String sex) {
        return personMapper.countSex(sex);
    }
}
