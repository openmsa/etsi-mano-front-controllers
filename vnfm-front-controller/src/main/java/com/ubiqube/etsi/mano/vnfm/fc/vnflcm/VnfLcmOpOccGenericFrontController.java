/**
 *     Copyright (C) 2019-2024 Ubiqube.
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see https://www.gnu.org/licenses/.
 */
package com.ubiqube.etsi.mano.vnfm.fc.vnflcm;

import java.util.UUID;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import com.ubiqube.etsi.mano.dao.mano.v2.VnfBlueprint;

public interface VnfLcmOpOccGenericFrontController {

	<U> ResponseEntity<String> search(MultiValueMap<String, String> requestParams, Function<VnfBlueprint, U> mapper, Consumer<U> makeLinks, Class<?> frontClass);

	ResponseEntity<Void> lcmOpOccRollback(UUID id);

	ResponseEntity<Void> lcmOpOccRetry(UUID id);

	<U> ResponseEntity<U> lcmOpOccFail(UUID id);

	<U> ResponseEntity<U> lcmOpOccCancel(UUID id);

	<U> ResponseEntity<U> lcmOpOccFindById(VnfLcmClassMaping mapping, UUID fromString, Consumer<U> makeLink, BiConsumer<U, Object> operationParameter);

}