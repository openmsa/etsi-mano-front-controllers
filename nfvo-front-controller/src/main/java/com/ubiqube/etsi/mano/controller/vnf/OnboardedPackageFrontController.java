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
package com.ubiqube.etsi.mano.controller.vnf;

import java.util.function.Consumer;
import java.util.function.Function;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import com.ubiqube.etsi.mano.dao.mano.VnfPackage;

import jakarta.annotation.Nullable;
import jakarta.servlet.http.HttpServletRequest;

/**
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 */
public interface OnboardedPackageFrontController {
	ResponseEntity<Resource> onboardedGetContentByVnfdId(String vnfdId, String accept, @Nullable String includeSignature);

	<U> ResponseEntity<String> onboardedSearch(MultiValueMap<String, String> requestParams, Function<VnfPackage, U> mapper, Consumer<U> makeLinks, Class<?> frontClass);

	ResponseEntity<Resource> onboardedGetArtifact(HttpServletRequest request, String safeUUID, @Nullable String includeSignature);

	<U> ResponseEntity<U> onboardedFindById(String safeUUID, Function<VnfPackage, U> mapper, Consumer<U> makeLinks);

	ResponseEntity<Resource> onboardedGetManifestByVnfd(String fromString, @Nullable String includeSignature);

	ResponseEntity<Resource> onboardedGetVnfdByVnfdId(String vnfdId, @Nullable String includeSignature);

	ResponseEntity<Resource> onboardedGetArtifactByVnfdId(String safeUUID);

}
