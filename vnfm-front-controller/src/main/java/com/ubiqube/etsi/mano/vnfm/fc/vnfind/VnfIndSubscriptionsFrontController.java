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
package com.ubiqube.etsi.mano.vnfm.fc.vnfind;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import com.ubiqube.etsi.mano.service.event.model.Subscription;

public interface VnfIndSubscriptionsFrontController {

	<U> ResponseEntity<List<U>> search(MultiValueMap<String, String> requestParams, Function<Subscription, U> mapper, Consumer<U> makeLink);

	<U> ResponseEntity<U> create(Subscription vnfIndicatorSubscriptionRequest, Function<Subscription, U> func, Class<?> versionController, Consumer<U> makeLink, Function<U, String> getSelfLink);

	ResponseEntity<Void> delete(String subscriptionId);

	<U> ResponseEntity<U> findById(String subscriptionId, Function<Subscription, U> mapper, Consumer<U> makeLink);

}