package com.icbi.macau.promote;

/**
 * 策略模式的接口类
 */
public interface PromoteRule {
    /**
     * 策略方法
     * @param totalPrice 购买水果的总价格
     * @return
     */
    float countByPromote(float totalPrice);
}
