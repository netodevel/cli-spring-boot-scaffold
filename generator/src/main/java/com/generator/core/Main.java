package com.generator.core;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        new SampleGenerator().generate(new GeneratorModel("User", new HashMap<String, String>()));
    }

}
