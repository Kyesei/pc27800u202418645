package com.andeslogistics.platform.u202418645.logistics.domain.model.valueobjects;

public record PackageLoad(Long packageLoad) {

    public PackageLoad {
        if (packageLoad == null || packageLoad < 0) {
            throw new IllegalArgumentException("PackageLoad cannot be null or less than 0");
        }
    }
}