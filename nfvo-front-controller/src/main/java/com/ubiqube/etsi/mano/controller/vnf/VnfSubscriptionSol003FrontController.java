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
package com.ubiqube.etsi.mano.controller.vnf;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import org.springframework.http.ResponseEntity;

import com.ubiqube.etsi.mano.dao.mano.VnfPackageChangeNotification;
import com.ubiqube.etsi.mano.dao.mano.VnfPackageOnboardingNotification;
import com.ubiqube.etsi.mano.service.event.model.Subscription;

public interface VnfSubscriptionSol003FrontController {

	<U> ResponseEntity<List<U>> search(String filters, Function<Subscription, U> func, Consumer<U> makeLinks);

	<U> ResponseEntity<U> create(Subscription subscriptionsPostQuery, Function<Subscription, U> mapper, Class<?> version, Consumer<U> makeLinks);

	ResponseEntity<Void> delete(String subscriptionId);

	<U> ResponseEntity<U> findById(String subscriptionId, Function<Subscription, U> func, Consumer<U> makeLinks);

	void vnfPackageChangeNotificationPost(VnfPackageChangeNotification notificationsMessage);

	void vnfPackageOnboardingNotificationPost(VnfPackageOnboardingNotification notificationsMessage);

}