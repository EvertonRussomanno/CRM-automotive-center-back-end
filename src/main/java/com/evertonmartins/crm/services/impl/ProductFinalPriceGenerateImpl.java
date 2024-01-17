package com.evertonmartins.crm.services.impl;

import com.evertonmartins.crm.services.ProductFinalPriceGenerate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductFinalPriceGenerateImpl implements ProductFinalPriceGenerate {
    @Override
    public BigDecimal finalPriceProfit(BigDecimal costPrice, BigDecimal profitMargin) {
        return costPrice.add(costPrice.multiply(profitMargin));
    }

    @Override
    public BigDecimal finalPriceWithDiscount(BigDecimal finalPriceNoDiscount, BigDecimal profitDiscount) {
        return finalPriceNoDiscount.add(finalPriceNoDiscount.multiply(profitDiscount));
    }
}
