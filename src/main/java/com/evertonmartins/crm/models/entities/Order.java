package com.evertonmartins.crm.models.entities;

import com.evertonmartins.crm.models.enums.OrderStatus;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.*;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant momentInitial;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant momentFinal;

    private OrderStatus status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userClient;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;

    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>();

    public Order() {
    }

    public Order(Long id, Instant momentInitial, Instant momentFinal, OrderStatus status, User userClient, Payment payment) {
        this.id = id;
        this.momentInitial = momentInitial;
        this.momentFinal = momentFinal;
        this.status = status;
        this.userClient = userClient;
        this.payment = payment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMomentInitial() {
        return momentInitial;
    }

    public void setMomentInitial(Instant momentInitial) {
        this.momentInitial = momentInitial;
    }

    public Instant getMomentFinal() {
        return momentFinal;
    }

    public void setMomentFinal(Instant momentFinal) {
        this.momentFinal = momentFinal;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public User getUserClient() {
        return userClient;
    }

    public void setUserClient(User userClient) {
        this.userClient = userClient;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Set<OrderItem> getItems() {
        return items;
    }

    public List<Product> getProducts(){
        return items.stream().map(x -> x.getProduct()).toList();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
