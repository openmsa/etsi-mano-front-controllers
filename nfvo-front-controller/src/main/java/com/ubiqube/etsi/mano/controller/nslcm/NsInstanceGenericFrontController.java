/**
 * Copyright (C) 2019-2024 Ubiqube.
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
 * along with this program. If not, see https://www.gnu.org/licenses/.
 */
package com.ubiqube.etsi.mano.controller.nslcm;

import java.util.function.Consumer;
import java.util.function.Function;

import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import com.ubiqube.etsi.mano.dao.mano.NsdInstance;
import com.ubiqube.etsi.mano.dao.mano.dto.CreateNsInstance;
import com.ubiqube.etsi.mano.dao.mano.dto.nsi.NsInstanceDto;
import com.ubiqube.etsi.mano.dao.mano.dto.nsi.NsInstantiate;
import com.ubiqube.etsi.mano.dao.mano.nsd.upd.UpdateRequest;
import com.ubiqube.etsi.mano.dao.mano.nslcm.scale.NsHeal;
import com.ubiqube.etsi.mano.dao.mano.nslcm.scale.NsScale;
import com.ubiqube.etsi.mano.dao.mano.v2.nfvo.NsBlueprint;

public interface NsInstanceGenericFrontController {

	<U> ResponseEntity<String> search(MultiValueMap<String, String> requestParams, Function<NsInstanceDto, U> mapper, String nextpageOpaqueMarker, Consumer<U> makeLink, Class<U> frontClass);

	ResponseEntity<Void> delete(String nsInstanceId);

	<U> ResponseEntity<U> findById(String nsInstanceId, Function<NsInstanceDto, U> clazz, Consumer<U> makeLink);

	<U> ResponseEntity<U> heal(String nsInstanceId, NsHeal request, final Function<NsBlueprint, String> getSelfLink);

	<U> ResponseEntity<U> instantiate(String nsInstanceId, NsInstantiate request, Function<NsBlueprint, String> getSelfLink);

	<U> ResponseEntity<U> scale(String nsInstanceId, NsScale request, final Function<NsBlueprint, String> getSelfLink);

	<U> ResponseEntity<U> terminate(String nsInstanceId, Object request, Function<NsBlueprint, String> getSelfLink);

	<U> ResponseEntity<U> update(String nsInstanceId, UpdateRequest request, final Function<NsBlueprint, String> getSelfLink);

	<U> ResponseEntity<U> create(CreateNsInstance request, Function<NsdInstance, U> func, Consumer<U> makeLink, Function<U, String> getSelfLink);

}