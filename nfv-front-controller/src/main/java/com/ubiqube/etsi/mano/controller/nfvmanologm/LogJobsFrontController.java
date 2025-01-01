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
package com.ubiqube.etsi.mano.controller.nfvmanologm;

import java.util.function.Function;

import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import com.ubiqube.etsi.mano.dao.mano.sol009.logm.CompileLogRequest;
import com.ubiqube.etsi.mano.dao.mano.sol009.logm.CreateLoggingJobRequest;
import com.ubiqube.etsi.mano.dao.mano.sol009.logm.LogReport;
import com.ubiqube.etsi.mano.dao.mano.sol009.logm.LoggingJob;

public interface LogJobsFrontController {

	<U> ResponseEntity<String> search(MultiValueMap<String, String> requestParams, Function<LoggingJob, U> mapper, String nextpageOpaqueMarker);

	<U> ResponseEntity<U> compile(String logJobId, CompileLogRequest req, Function<LogReport, U> mapper);

	ResponseEntity<Void> delete(String logJobId);

	<U> ResponseEntity<U> findById(String logJobId, Function<LoggingJob, U> mapper);

	<U> ResponseEntity<U> findLogReport(String logJobId, String logReportId, Function<LogReport, U> mapper);

	<U> ResponseEntity<U> create(CreateLoggingJobRequest request, Function<LoggingJob, U> mapper);

}
