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
package com.ubiqube.etsi.mano.vnfm.fc.vnfpm;

import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;

import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import com.ubiqube.etsi.mano.dao.mano.pm.PerformanceReport;
import com.ubiqube.etsi.mano.dao.mano.pm.PmJob;

public interface VnfmPmGenericFrontController {

	<U> ResponseEntity<String> search(MultiValueMap<String, String> requestParams, Function<PmJob, U> mapper, Consumer<U> makeLink, Class<U> frontClass);

	ResponseEntity<Void> deleteById(UUID pmJobId);

	<U> ResponseEntity<U> findById(UUID pmJobIdn, Function<PmJob, U> mapper, Consumer<U> makeLinks);

	<U> ResponseEntity<U> findReportById(String pmJobId, String reportId, Function<PerformanceReport, U> mapper);

	<U> ResponseEntity<U> pmJobsPost(PmJob createPmJobRequest, Function<PmJob, U> mapper, Consumer<U> makeLinks, Function<U, String> getSelfLink);

	<U> ResponseEntity<U> pmJobsPmJobIdPatch(UUID pmJobId, Object pmJobModifications);

}