/*
 * Copyright (c) TIKI Inc.
 * MIT license. See LICENSE file in root directory.
 */

package com.mytiki.l0_index.features.latest.address;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AddressRepository extends JpaRepository<AddressDO, Long> {
    Optional<AddressDO> findByAidAndAddress(String aid, byte[] address);
    List<AddressDO> findAllByAid(String aid);
}
