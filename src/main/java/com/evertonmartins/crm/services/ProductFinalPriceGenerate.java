package com.evertonmartins.crm.services;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public interface ProductFinalPriceGenerate {

    BigDecimal finalPriceProfit(BigDecimal costPrice, BigDecimal profitMargin);

    BigDecimal finalPriceWithDiscount(BigDecimal finalPriceNoDiscount, BigDecimal discount);

}
