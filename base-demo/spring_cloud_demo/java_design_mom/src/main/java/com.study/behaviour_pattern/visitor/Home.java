package com.study.behaviour_pattern.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @类名称:Home
 * @类描述:
 * @包名:behaviour_pattern.visitor
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-03-10
 * @版本:V1.0.0
 */
public class Home {
    private List<Animal> animalList = new ArrayList<>();

    public void add(Animal animal) {
        animalList.add(animal);
    }

    public void action(Person person){
        for (Animal animal : animalList) {
            animal.accept(person);
        }
    }
}
