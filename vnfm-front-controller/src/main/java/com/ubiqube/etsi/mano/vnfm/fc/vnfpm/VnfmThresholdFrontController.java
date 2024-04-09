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
package com.ubiqube.etsi.mano.vnfm.fc.vnfpm;

import java.util.function.Consumer;
import java.util.function.Function;

import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import com.ubiqube.etsi.mano.dao.mano.pm.Threshold;

import jakarta.annotation.Nullable;

public interface VnfmThresholdFrontController {

	<U> ResponseEntity<U> thresholdsCreate(Threshold request, Function<Threshold, U> mapper, Consumer<U> makeLink, Function<U, String> getSelfLink);

	ResponseEntity<Void> deleteById(String thresholdId);

	<U> ResponseEntity<U> findById(String thresholdId, Function<Threshold, U> mapper, Consumer<U> makeLink);

	<U> ResponseEntity<String> search(MultiValueMap<String, String> requestParams, @Nullable String nextpageOpaqueMarker, Function<Threshold, U> mapper, Consumer<U> makeLink);

	<U> ResponseEntity<U> patch(String thresholdId, Object body, Function<Threshold, U> mapper);

}