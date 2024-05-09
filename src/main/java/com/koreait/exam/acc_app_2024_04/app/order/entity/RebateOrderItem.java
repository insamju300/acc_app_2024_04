package com.koreait.exam.acc_app_2024_04.app.order.entity;


import com.koreait.exam.acc_app_2024_04.app.base.entity.BaseEntity;
import com.koreait.exam.acc_app_2024_04.app.product.entity.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class RebateOrderItem extends BaseEntity {

    @OneToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    @JoinColumn(foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private OrderItem orderItem;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    @JoinColumn(foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Product product;


    //가격
    private int price; // 권장 판매가
    private int salePrice; // 실제 판매가
    private int wholesalePrice; // 도매가
    private int pgFee; // 결제대행사 수수료
    private int payPrice; // 결제금액
    private int refundPrice; // 환불금액
    private boolean isPaid;  // 결제 여부
    private LocalDateTime payDate; // 결제 날짜

    // 상품
    private String productName;

    // 상품 옵션
//    private String productOptionColor;
//    private String productOptionSize;
//    private String productOptionDisplayColor;
//    private String productOptionDisplaySize;

//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(name = "color", column = @Column(name = "product_option_color")),
//            @AttributeOverride(name = "size", column = @Column(name = "product_option_size")),
//            @AttributeOverride(name = "displayColor", column = @Column(name = "product_option_display_color")),
//            @AttributeOverride(name = "displaySize", column = @Column(name = "product_option_display_size")),
//    })
//    private RebateOrderItem.EmbProductOption embProductOption;
    // 주문 품목
    private LocalDateTime orderItemCreateDate;

    public RebateOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
        order = orderItem.getOrder();
        product = orderItem.getProduct();
        price = orderItem.getPrice();
        salePrice = orderItem.getSalePrice();
        wholesalePrice = orderItem.getWholesalePrice();
        pgFee = orderItem.getPgFee();
        payPrice = orderItem.getPayPrice();
        refundPrice = orderItem.getRefundPrice();
        isPaid = orderItem.isPaid();
        payDate = orderItem.getPayDate();

        // 상품 추가데이터
        productName = orderItem.getProduct().getSubject();


        // 상품옵션 추가데이터
//        productOptionColor = orderItem.getProductOption().getColor();
//        productOptionSize = orderItem.getProductOption().getSize();
//        productOptionDisplayColor = orderItem.getProductOption().getDisplayColor();
//        productOptionDisplaySize = orderItem.getProductOption().getDisplaySize();
 //       embProductOption = new EmbProductOption(orderItem.getProductOption());

        // 주문 품목 추가데이터
        orderItemCreateDate = orderItem.getCreateDate();

    }

//    @Embeddable
//    @NoArgsConstructor
//    public static class EmbProductOption{
//        private String color;
//        private String size;
//        private String displayColor;
//        private String displaySize;
//
//        public EmbProductOption(ProductOption productOption){
//            color = productOption.getColor();
//            size = productOption.getSize();
//            displayColor = productOption.getDisplayColor();
//            displaySize = productOption.getDisplaySize();
//        }
//
//    }
}