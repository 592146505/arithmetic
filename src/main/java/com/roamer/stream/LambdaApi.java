package com.roamer.stream;

import com.roamer.stream.entity.Person;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.Objects.isNull;
import static java.util.stream.Collectors.toList;

/**
 * Lambda API使用
 *
 * @author roamer
 * @version V1.0
 * @date 2018/12/14
 */
public class LambdaApi<E extends Person> {

    public List<String> getNameByAge(Collection<E> collection) {
        return collection.parallelStream().filter(x -> x.getAge() > 15)
                .sorted(Comparator.comparingInt(Person::getAge).reversed()).map(Person::getName).collect(toList());
    }

    public Integer computeLimitSum(Collection<E> collection) {
        return collection.stream().filter(p -> !isNull(p)).distinct().mapToInt(Person::getAge).peek(System.out::println)
                .skip(2).limit(4).sum();
    }

    public List<String> range(IntStream intStream) {
        // Stream的中间操作都是惰性的
        return intStream.peek(System.out::println).mapToObj(String::valueOf).limit(5).collect(toList());
    }

}