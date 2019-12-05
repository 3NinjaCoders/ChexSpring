package com.chex.registration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RegistrationMessageBuilderTest {

	private RegistrationMessageBuilder rmb;
	@BeforeEach
	void setUp() throws Exception {
		rmb = new RegistrationMessageBuilder();
	}

	@Test
	void test_password() {
		rmb.check_password("xx66");
		Assertions.assertEquals("Hasło musi mieć conajmniej 6 znaków\n", rmb.build_message());
		Assertions.assertFalse(rmb.data_is_correct());
		
		rmb.check_password("xxxxxxx");
		Assertions.assertEquals("Hasło musi zawierac conajmniej jedna literę i cyfrę\n", rmb.build_message());
		Assertions.assertFalse(rmb.data_is_correct());
		
		rmb.check_password("x");
		Assertions.assertEquals("Hasło musi mieć conajmniej 6 znaków\nHasło musi zawierac conajmniej jedna literę i cyfrę\n", rmb.build_message());
		Assertions.assertFalse(rmb.data_is_correct());
		
		rmb.check_password("xxxxx1111");
		Assertions.assertEquals("", rmb.build_message());
		Assertions.assertTrue(rmb.data_is_correct());
	}
	
	@Test
	void test_login() {
		rmb.check_login("");
		Assertions.assertEquals("Pole login nie może być puste\n", rmb.build_message());
		Assertions.assertFalse(rmb.data_is_correct());
		
		rmb.check_login("aaa");
		Assertions.assertEquals("", rmb.build_message());
		Assertions.assertTrue(rmb.data_is_correct());
	}
	
	@Test
	void test_firstname() {
		rmb.check_firstname("");
		Assertions.assertEquals("Pole imię nie może być puste\n", rmb.build_message());
		Assertions.assertFalse(rmb.data_is_correct());
		
		rmb.check_firstname("aaa");
		Assertions.assertEquals("", rmb.build_message());
		Assertions.assertTrue(rmb.data_is_correct());
	}
	
	@Test
	void test_lastname() {
		rmb.check_lastname("");
		Assertions.assertEquals("Pole nazwisko nie może być puste\n", rmb.build_message());
		Assertions.assertFalse(rmb.data_is_correct());
		
		rmb.check_lastname("aaa");
		Assertions.assertEquals("", rmb.build_message());
		Assertions.assertTrue(rmb.data_is_correct());
	}
	
	@Test
	void test_is_exist() {
		rmb.check_isnt_exist(false);
		Assertions.assertEquals("Taki login już istnieje\n", rmb.build_message());
		Assertions.assertFalse(rmb.data_is_correct());
		
		rmb.check_isnt_exist(true);
		Assertions.assertEquals("", rmb.build_message());
		Assertions.assertTrue(rmb.data_is_correct());
	}
	
	@Test
	void test_dwo_fields_are_wrong() {
		rmb.check_lastname("");
		rmb.check_isnt_exist(false);
		Assertions.assertEquals("Pole nazwisko nie może być puste\nTaki login już istnieje\n", rmb.build_message());
		Assertions.assertFalse(rmb.data_is_correct());
	}
	
	@Test
	void test_everythink_is_good() {
		rmb.check_password("xxxxxx1");
		rmb.check_firstname("aaa");
		rmb.check_lastname("bb");
		rmb.check_login("aa");
		rmb.check_isnt_exist(true);
		Assertions.assertEquals("", rmb.build_message());
		Assertions.assertTrue(rmb.data_is_correct());
	}
}
