/*
 * Copyright (c) TIKI Inc.
 * MIT license. See LICENSE file in root directory.
 */

package com.mytiki.l0_index.features.latest.index;

import com.mytiki.l0_index.features.latest.block.BlockDO;
import com.mytiki.l0_index.features.latest.block.BlockService;
import com.mytiki.l0_index.features.latest.license.LicenseService;
import com.mytiki.l0_index.features.latest.title.TitleService;
import jakarta.transaction.Transactional;

public class IndexService {
    private final BlockService blockService;
    private final TitleService titleService;
    private final LicenseService licenseService;

    public IndexService(
            BlockService blockService,
            TitleService titleService,
            LicenseService licenseService) {
        this.blockService = blockService;
        this.titleService = titleService;
        this.licenseService = licenseService;
    }

    @Transactional
    public void index(IndexAOReq req){
        BlockDO block = blockService.insert(req.getBlock(), req.getSrc());
        if(req.getTitles() != null)
            req.getTitles().forEach(title -> titleService.insert(title, req.getAppId(), block));
        if(req.getLicenses() != null)
            req.getLicenses().forEach(license -> licenseService.insert(license, req.getAppId(), block));
    }
}
