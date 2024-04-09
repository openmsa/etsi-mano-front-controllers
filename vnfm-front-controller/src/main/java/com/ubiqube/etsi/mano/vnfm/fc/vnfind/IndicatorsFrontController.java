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
package com.ubiqube.etsi.mano.vnfm.fc.vnfind;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import org.springframework.http.ResponseEntity;

import com.ubiqube.etsi.mano.dao.mano.VnfIndicator;

import jakarta.annotation.Nullable;

public interface IndicatorsFrontController {

	<U> ResponseEntity<List<U>> search(@Nullable String filter, @Nullable String nextpageOpaqueMarker, Function<VnfIndicator, U> mapper, Consumer<U> makeLink);

	<U> ResponseEntity<List<U>> findByVnfInstanceId(String vnfInstanceId, @Nullable String filter, @Nullable String nextpageOpaqueMarker, Function<VnfIndicator, U> mapper, Consumer<U> makeLink);

	<U> ResponseEntity<U> findByVnfInstanceIdAndIndicatorId(String vnfInstanceId, String indicatorId, Function<VnfIndicator, U> mapper, Consumer<U> makeLink);

}