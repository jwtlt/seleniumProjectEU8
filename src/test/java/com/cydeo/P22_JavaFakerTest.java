package com.cydeo;

import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class P22_JavaFakerTest {

    @Test
    public void fakerTest(){

        Faker faker = new Faker();

        //faker.categoryName().availableOptions);
        System.out.println("faker.name().fullName() = " + faker.name().fullName());
        System.out.println("faker.address().streetAddress() = " + faker.address().streetAddress());
        System.out.println("faker.address().cityName() = " + faker.address().cityName());
        System.out.println("faker.address().state() = " + faker.address().state());
        System.out.println("faker.address().zipCode() = " + faker.address().zipCode());

        System.out.println("faker.number().numberBetween(100,1563) = " + faker.number().numberBetween(100, 1563));

        System.out.println("faker.numerify(\"703-##-####\") = " + faker.numerify("703-##-####"));

        System.out.println("faker.letterify(\"??????????\") = " + faker.letterify("??????????"));

        System.out.println("faker.bothify(\"##-???-####-??\") = " + faker.bothify("##-???-####-??"));

        System.out.println("faker.finance().creditCard(CreditCardType.VISA) = " + faker.finance().creditCard(CreditCardType.VISA));

    }

}
