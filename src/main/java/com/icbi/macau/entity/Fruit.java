package com.icbi.macau.entity;

/**
 * 水果实体类
 */
public abstract class Fruit {

    /**
     * 水果的单价，单位：元/斤
     */
    private float unitPrice;

    /**
     * 重量，单位：斤
     */
    private int weight;

    /**
     * 折扣百分比
     */
    private float discount;

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public float getTotalPrice() {
        if(unitPrice > 0 && weight > 0){
            if(discount > 0){
                return unitPrice * weight * discount;
            }else {
                return unitPrice * weight;
            }
        }else{
            return 0;
        }
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }
}
