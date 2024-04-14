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
package com.ubiqube.etsi.mano.vnfm.fc.vnflcm;

import com.ubiqube.etsi.mano.dao.mano.v2.VnfBlueprint;

/**
 * Mapping class for VnfLcmOpOcc.
 *
 * @author ncuser
 *
 */
public interface VnfLcmClassMaping {

	<R> R getInstantiateVnfRequest(VnfBlueprint o);

	<R> R getScaleVnfRequest(VnfBlueprint o);

	<R> R getScaleVnfToLevelRequest(VnfBlueprint o);

	<R> R getChangeVnfFlavourRequest(VnfBlueprint o);

	<R> R getOperateVnfRequest(VnfBlueprint o);

	<R> R getHealVnfRequest(VnfBlueprint o);

	<R> R getChangeExtVnfConnectivityRequest(VnfBlueprint o);

	<R> R getTerminateVnfRequest(VnfBlueprint o);

	<R> R getVnfInfoModificationRequest(VnfBlueprint o);

	<R> R getCreateVnfSnapshotRequest(VnfBlueprint o);

	<R> R getRevertToVnfSnapshotRequest(VnfBlueprint o);

	<R> R getChangeCurrentVnfPkgRequest(VnfBlueprint o);

	<R> R mapToVnfLcmOpOcc(VnfBlueprint o);
}
