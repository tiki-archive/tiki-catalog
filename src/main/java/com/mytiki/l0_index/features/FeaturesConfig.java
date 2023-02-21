/*
 * Copyright (c) TIKI Inc.
 * MIT license. See LICENSE file in root directory.
 */

package com.mytiki.l0_index.features;

import com.mytiki.l0_index.features.latest.address.AddressConfig;
import com.mytiki.l0_index.features.latest.app.AppConfig;
import com.mytiki.l0_index.features.latest.block.BlockConfig;
import com.mytiki.l0_index.features.latest.report.ReportConfig;
import com.mytiki.l0_index.features.latest.search.SearchConfig;
import com.mytiki.l0_index.features.latest.txn.TxnConfig;
import org.springframework.context.annotation.Import;

@Import({
        AppConfig.class,
        AddressConfig.class,
        BlockConfig.class,
        TxnConfig.class,
        ReportConfig.class,
        SearchConfig.class
})
public class FeaturesConfig {}
