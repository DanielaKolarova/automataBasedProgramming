package edu.abp.paradigm.turnstile.builder;

import org.junit.Assert;
import org.junit.Test;

import edu.abp.paradigm.turnstile.builder.GenericBuilder;

public class GenericBuilderTest {
	
	private static final String name = "Syed";
	
	private static final int age = 50;

	@Test
	public void testBuild() {
		Person person = GenericBuilder.of(Person::new)
                .with(Person::setName, name)
                .with(Person::setAge, 50)
                .build();
		
		Assert.assertEquals(name, person.getName());
		Assert.assertTrue(age == person.getAge());
	}
}

class Person {

	private String name;
	private int age;

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
}