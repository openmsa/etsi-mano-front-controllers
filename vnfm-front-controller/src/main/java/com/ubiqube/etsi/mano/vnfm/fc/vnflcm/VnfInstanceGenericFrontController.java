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

import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;

import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import com.ubiqube.etsi.mano.dao.mano.CancelModeTypeEnum;
import com.ubiqube.etsi.mano.dao.mano.VnfInstance;
import com.ubiqube.etsi.mano.dao.mano.v2.VnfBlueprint;
import com.ubiqube.etsi.mano.dao.mano.vnfi.ChangeExtVnfConnRequest;
import com.ubiqube.etsi.mano.model.VnfInstantiate;
import com.ubiqube.etsi.mano.model.VnfOperateRequest;
import com.ubiqube.etsi.mano.model.VnfScaleRequest;
import com.ubiqube.etsi.mano.model.VnfScaleToLevelRequest;

import jakarta.annotation.Nullable;

public interface VnfInstanceGenericFrontController {

	ResponseEntity<Void> terminate(UUID vnfInstanceId, CancelModeTypeEnum cancelMode, @Nullable Integer timeout, Function<VnfBlueprint, String> getSelfLink);

	<U> ResponseEntity<Void> scaleToLevel(UUID vnfInstanceId, VnfScaleToLevelRequest req, Function<VnfBlueprint, String> getSelfLink);

	<U> ResponseEntity<Void> scale(UUID vnfInstanceId, VnfScaleRequest req, Function<VnfBlueprint, String> getSelfLink);

	<U> ResponseEntity<Void> snapshot(UUID vnfInstanceId, U body);

	<V> ResponseEntity<V> modify(UUID vnfInstanceId, String body, String ifMatch, Function<VnfInstance, String> getSelfLink);

	<U> ResponseEntity<Void> operate(UUID vnfInstanceId, VnfOperateRequest req, Function<VnfBlueprint, String> getSelfLink);

	<U> ResponseEntity<Void> instantiate(UUID vnfInstanceId, VnfInstantiate req, Function<VnfBlueprint, String> getSelfLink);

	ResponseEntity<Void> heal(UUID vnfInstanceId, String cause, Map<String, String> hashMap, final Function<VnfBlueprint, String> getSelfLink);

	<U> ResponseEntity<U> findById(UUID vnfInstanceId, Function<VnfInstance, U> func, Consumer<U> makeLink, String instanceSelfLink);

	ResponseEntity<Void> deleteById(UUID vnfInstanceId);

	<U> ResponseEntity<Void> createSnapshot(UUID vnfInstanceId, U object, Function<VnfBlueprint, String> getSelfLink);

	<U> ResponseEntity<Void> changeVnfPkg(UUID vnfInstanceId, U object, Function<VnfBlueprint, String> getSelfLink);

	<U> ResponseEntity<Void> changeFlavour(UUID vnfInstanceId, U object, Function<VnfBlueprint, String> getSelfLink);

	<U> ResponseEntity<Void> changeExtConn(UUID vnfInstanceId, ChangeExtVnfConnRequest object, Function<VnfBlueprint, String> getSelfLink);

	<U> ResponseEntity<U> create(String vnfdId, String vnfInstanceName, @Nullable String vnfInstanceDescription, Function<VnfInstance, U> func, Consumer<U> makeLink, String selfLink);

	<U> ResponseEntity<String> search(MultiValueMap<String, String> requestParams, Function<VnfInstance, U> mapper, @Nullable String nextpageOpaqueMarker, Consumer<U> makeLink);

}