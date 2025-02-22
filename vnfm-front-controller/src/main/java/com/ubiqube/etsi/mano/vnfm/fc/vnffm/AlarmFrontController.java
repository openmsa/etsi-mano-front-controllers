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
package com.ubiqube.etsi.mano.vnfm.fc.vnffm;

import java.util.function.Consumer;
import java.util.function.Function;

import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import com.ubiqube.etsi.mano.dao.mano.alarm.AckState;
import com.ubiqube.etsi.mano.dao.mano.alarm.Alarms;
import com.ubiqube.etsi.mano.dao.mano.alarm.PerceivedSeverityType;

import org.jspecify.annotations.Nullable;

public interface AlarmFrontController {

	ResponseEntity<Void> escalate(String alarmId, PerceivedSeverityType perceivedSeverityRequest);

	<U> ResponseEntity<U> findById(String alarmId, Function<Alarms, U> mapper, Consumer<U> makeLink);

	<U> ResponseEntity<U> patch(String alarmId, AckState ackState, @Nullable String ifMatch, Function<Alarms, U> mapper);

	<U> ResponseEntity<String> search(MultiValueMap<String, String> requestParams, Function<Alarms, U> mapper, Consumer<U> makeLink, Class<U> frontClass);

}