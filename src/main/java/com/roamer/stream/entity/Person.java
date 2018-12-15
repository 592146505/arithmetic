package com.roamer.stream.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 人员信息
 *
 * @author roamer
 * @version V1.0
 * @date 2018/12/15
 */
@Data
@AllArgsConstructor
public class Person {
    private String name;
    private Integer age;
    private String sex;
}

