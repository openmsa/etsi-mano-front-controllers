package com.ubiqube.etsi.mano.nfvo.fc.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.UUID;

import org.junit.jupiter.api.Test;

class NfvoConstantsTest {

	@Test
	void test() {
		assertThrows(NullPointerException.class, () -> NfvoConstants.getSafeUUID(null));
		assertNotNull(NfvoConstants.getSafeUUID(UUID.randomUUID().toString()));
	}

}
