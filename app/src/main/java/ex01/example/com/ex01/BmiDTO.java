package ex01.example.com.ex01;

import java.io.Serializable;

/**
 * Created by hong-in-yong on 2017. 4. 24..
 */

//intent를 이용해서 객체를 넘길경우 Serializable을 구현해야함
//객체 직렬화(객체를 바이트배열로 만들어서 넘기는것
// 객체에 포함된 변소들의 자료형을 무시하고 바이트배열로 전송

public class BmiDTO implements Serializable {
    private String name;
    private int age;
    private double bmi;
    private String result;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
