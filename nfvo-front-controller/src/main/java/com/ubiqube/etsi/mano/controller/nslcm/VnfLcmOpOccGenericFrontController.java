/**
 * Copyright (C) 2019-2025 Ubiqube.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 */
package com.ubiqube.etsi.mano.controller.nslcm;

import java.util.UUID;
import java.util.function.Consumer;

import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

public interface VnfLcmOpOccGenericFrontController {

	<U> ResponseEntity<String> search(MultiValueMap<String, String> requestParams, Class<U> class1, Consumer<U> makeLinks);

	ResponseEntity<Void> lcmOpOccRollback(UUID id);

	ResponseEntity<Void> lcmOpOccRetry(UUID id);

	<U> U lcmOpOccFindById(UUID id);

	<U> ResponseEntity<U> lcmOpOccFail(UUID id);

	<U> ResponseEntity<U> lcmOpOccCancel(UUID id);

}