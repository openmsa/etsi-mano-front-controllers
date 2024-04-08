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
package com.ubiqube.etsi.mano.controller.lcmgrant;

import java.util.function.Consumer;
import java.util.function.Function;

import org.springframework.http.ResponseEntity;

import com.ubiqube.etsi.mano.dao.mano.GrantResponse;

public interface LcmGrantsFrontController {

	<U> ResponseEntity<U> grantsGrantIdGet(String grantId, Function<GrantResponse, U> func, Consumer<U> makeLink);

	<U> ResponseEntity<U> grantsPost(GrantResponse grantRequest, Function<GrantResponse, U> func, Function<U, String> getSelfLink);

}