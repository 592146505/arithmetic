package com.roamer.stream;

import com.roamer.stream.entity.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author roamer
 * @version V1.0
 * @date 2018/12/14
 */
public class Api<E extends Person> {

    private List<String> getNameByAge(Collection<E> collection) {
        return collection.parallelStream().filter(x -> x.getAge() > 15)
                .sorted(Comparator.comparingInt(Person::getAge).reversed()).map(Person::getName)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("fg", 27, "男"));
        list.add(new Person("sw", 12, "女"));
        list.add(new Person("sc", 64, "男"));
        list.add(new Person("awd", 52, "女"));
        List<String> names = new Api<>().getNameByAge(list);
        names.stream().forEach(System.out::println);
    }
}