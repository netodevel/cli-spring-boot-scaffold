package br.com.generate;

/**
 * Created by ivanmarreta on 03/11/16.
 */
public class Parameter {

    public static String getParametersGenerate(String[] arguments) {
        String parameters = "";
        for (int i = 3; i < arguments.length; i++) {
            parameters += " " + arguments[i];
        }
        return parameters;
    }
}
