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
package com.ubiqube.etsi.mano.controller.vnflcm;

import org.springframework.http.ResponseEntity;

import com.ubiqube.etsi.mano.dao.mano.vnflcm.VnfLcmNotification;

/**
 *
 * @author olivier
 *
 */
public interface VnfLcmNotificationFrontController {

	ResponseEntity<Void> creationCheck();

	ResponseEntity<Void> creationNotification(VnfLcmNotification body, String version);

	ResponseEntity<Void> deletionCheck();

	ResponseEntity<Void> deletionNotification(VnfLcmNotification body, String version);

	ResponseEntity<Void> vnflcmopoccCheck();

	ResponseEntity<Void> vnflcmopoccNotification(VnfLcmNotification body, String version);

}
