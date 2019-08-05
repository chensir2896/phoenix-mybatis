package com.phoenix.mapper;

import com.phoenix.entity.Person;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import java.util.Map;

@Mapper
public interface PersonMapper {


    List<Person> listPerson();

    Person getLastPerson();


    void save(Person person);

    Long deleteAll();

    List<Person> pageList(Map<String, Object> paramMap);

    Person get(Integer id);

    List<Person> getMany(List<Integer> idList);

    Long countSex(String sex);
}
