/*
 * Copyright (c) TIKI Inc.
 * MIT license. See LICENSE file in root directory.
 */

package com.mytiki.l0_index.features.latest.report;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ReportAO {
    private String appId;
    private String address;
    private String block;
    private String src;
    private List<String> transactions;

    @JsonCreator
    public ReportAO(
            @JsonProperty(required = true) String appId,
            @JsonProperty(required = true) String address,
            @JsonProperty(required = true) String block,
            @JsonProperty(required = true) String src,
            @JsonProperty(required = true) List<String> transactions) {
        this.appId = appId;
        this.address = address;
        this.block = block;
        this.src = src;
        this.transactions = transactions;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public List<String> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<String> transactions) {
        this.transactions = transactions;
    }
}
