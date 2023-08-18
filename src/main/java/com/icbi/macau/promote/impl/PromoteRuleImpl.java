package com.icbi.macau.promote.impl;

import com.icbi.macau.promote.PromoteRule;

/**
 * 策略模式的实现类，此类的满减的模式，其他类型的模式可以通过创建新的实现类来实现
 */
public class PromoteRuleImpl implements PromoteRule {

    /**
     * 促销的总价格门槛
     */
    private static float promoteTotalPrice = 100;

    /**
     * 促销的扣减价格
     */
    private static float reducedPrice = 10;

    @Override
    public float countByPromote(float totalPrice) {
        System.out.println("总价钱是：" + totalPrice);
        if(totalPrice >= promoteTotalPrice){
            System.out.println("达到满减条件");
            totalPrice = totalPrice - reducedPrice;
        }else{
            System.out.println("未达到满减条件");
        }
        return totalPrice;
    }
}
