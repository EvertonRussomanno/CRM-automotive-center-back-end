package com.evertonmartins.crm.models.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

@Embeddable
public class OrderItemPK {

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "executedService_id")
    private ExecutedService executedService;

    public OrderItemPK(){}

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ExecutedService getExecutedService() {
        return executedService;
    }

    public void setExecutedService(ExecutedService executedService) {
        this.executedService = executedService;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderItemPK that = (OrderItemPK) o;

        if (!Objects.equals(order, that.order)) return false;
        if (!Objects.equals(product, that.product)) return false;
        return Objects.equals(executedService, that.executedService);
    }

    @Override
    public int hashCode() {
        int result = order != null ? order.hashCode() : 0;
        result = 31 * result + (product != null ? product.hashCode() : 0);
        result = 31 * result + (executedService != null ? executedService.hashCode() : 0);
        return result;
    }
}
