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

import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;

import com.ubiqube.etsi.mano.dao.mano.VnfPackage;
import com.ubiqube.etsi.mano.dao.mano.pkg.UploadUriParameters;

import jakarta.annotation.Nullable;
import jakarta.servlet.http.HttpServletRequest;

public interface VnfPackageFrontController {

	ResponseEntity<Resource> getArtifactPath(HttpServletRequest request, UUID vnfPkgId, @Nullable String includeSignature);

	<U> ResponseEntity<U> findById(UUID vnfPkgId, Function<VnfPackage, U> mapper, Consumer<U> makeLinks);

	<U> ResponseEntity<U> findByIdReadOnly(UUID vnfPkgId, Class<U> clazz, Consumer<U> makeLinks);

	ResponseEntity<Resource> getManifest(UUID vnfPkgId, @Nullable String includeSignature);

	ResponseEntity<Resource> getContent(UUID vnfPkgId);

	ResponseEntity<Resource> getVfnd(UUID vnfPkgId, @Nullable String contentType, @Nullable String includeSignature);

	ResponseEntity<Resource> getSelectArtifacts(HttpServletRequest request, UUID vnfPkgId);

	ResponseEntity<Void> deleteById(UUID vnfPkgId);

	<U> ResponseEntity<String> search(MultiValueMap<String, String> requestParams, Function<VnfPackage, U> mapper, Consumer<U> makeLinks, Class<?> frontClass);

	<U> ResponseEntity<U> create(Map<String, String> userDefinedData, Function<VnfPackage, U> mapper, Consumer<U> makeLinks, Function<U, String> getSelfLink);

	<U> ResponseEntity<U> getExternalArtifacts(UUID id);

	<U> ResponseEntity<U> putExternalArtifact(U body, UUID id);

	ResponseEntity<Void> putContent(UUID id, String accept, @Nullable MultipartFile file);

	ResponseEntity<Void> uploadFromUri(UploadUriParameters body, UUID id, String contentType);

	<U> ResponseEntity<U> modify(String body, UUID vnfPkgId, @Nullable String ifMatch, Function<VnfPackage, U> mapper, Consumer<U> makeLinks);

	ResponseEntity<Resource> searchArtifact(UUID safeUUID, @Nullable String includeSignatures, @Nullable String excludeAllManoArtifacts, @Nullable String excludeAllNonManoArtifacts, @Nullable String selectNonManoArtifactSets);

}