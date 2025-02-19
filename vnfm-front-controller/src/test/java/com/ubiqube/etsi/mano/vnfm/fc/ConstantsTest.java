package com.ubiqube.etsi.mano.vnfm.fc;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.UUID;

import org.junit.jupiter.api.Test;

class ConstantsTest {

	@Test
	void test() {
		assertThrows(NullPointerException.class, () -> Constants.getSafeUUID(null));
		assertNotNull(Constants.getSafeUUID(UUID.randomUUID().toString()));
	}

}
