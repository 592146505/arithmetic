package com.roamer.stream;

import com.roamer.stream.entity.Person;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class LambdaApiTest {
    LambdaApi<Person> api = new LambdaApi();

    List<Person> list;

    @Before
    public void setUp() throws Exception {
        list = new ArrayList<>();
        list.add(new Person("fg", 27, "男"));
        list.add(new Person("sw", 12, "女"));
        list.add(new Person("sc", 64, "男"));
        list.add(new Person("awd", 52, "女"));
    }

    @After
    public void tearDown() throws Exception {
        list = null;
    }

    @Test
    public void getNameByAge() {
        List<String> names = api.getNameByAge(list);
        assertEquals(Arrays.asList("sc", "awd", "fg"), names);
    }

    @Test
    public void computeLimitSum() {
        list.add(null);
        list.add(list.get(0));
        list.add(null);
        list.add(list.get(1));
        int sum = api.computeLimitSum(list);
        assertEquals(116, sum);
    }


    @Test
    public void range() {
        List<String> nums = api.range(IntStream.range(0, 80));
        assertEquals(Arrays.asList("0", "1", "2", "3", "4"), nums);
    }



}