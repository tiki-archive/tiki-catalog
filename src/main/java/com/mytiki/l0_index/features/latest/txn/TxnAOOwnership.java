/*
 * Copyright (c) TIKI Inc.
 * MIT license. See LICENSE file in root directory.
 */

package com.mytiki.l0_index.features.latest.txn;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "Ownership")
public class TxnAOOwnership implements TxnAOContents {
    private String raw;
    private String source;
    private String type;
    private String origin;
    private String about;
    private String contains;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getContains() {
        return contains;
    }

    public void setContains(String contains) {
        this.contains = contains;
    }

    @Override
    public String getRaw() {
        return raw;
    }

    @Override
    public void setRaw(String raw) {
        this.raw = raw;
    }
}
