package com.chex.registration;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataRegistrationCheckerTest {

	DataRegistrationChecker drc;
	@BeforeEach
    public void setUp() {
        drc = new DataRegistrationChecker();
    }
	
	@Test
	void test_size_password() {
		Assertions.assertTrue(drc.check_password_size("123456"));
		Assertions.assertFalse(drc.check_password_size("12345"));
		Assertions.assertFalse(drc.check_password_size(""));
	}
	
	@Test
	void test_passord_dig_alf() {
		Assertions.assertFalse(drc.check_password_alfdig("123456"));
		Assertions.assertFalse(drc.check_password_alfdig("abcd"));
		Assertions.assertFalse(drc.check_password_alfdig(""));
		Assertions.assertTrue(drc.check_password_alfdig("abc123"));
	}
	
	@Test
	void test_first_name_is_empty() {
		Assertions.assertFalse(drc.check_firstname(""));
		Assertions.assertFalse(drc.check_firstname(" "));
		Assertions.assertTrue(drc.check_firstname("abc123"));
	}

	@Test
	void test_last_name_is_empty() {
		Assertions.assertFalse(drc.check_lastname(""));
		Assertions.assertFalse(drc.check_lastname(" "));
		Assertions.assertTrue(drc.check_lastname("abc123"));
	}
	
	@Test
	void test_login_name_is_empty() {
		Assertions.assertFalse(drc.check_lastname(""));
		Assertions.assertFalse(drc.check_lastname(" "));
		Assertions.assertTrue(drc.check_lastname("abc123"));
	}
}
