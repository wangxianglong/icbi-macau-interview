package com.icbi.macau;

import com.icbi.macau.entity.Fruit;
import com.icbi.macau.promote.PromoteRule;

import java.util.List;

public class Supermarket {

    private PromoteRule promoteRule;

    /**
     * 通过传入不同的策略模式来实现促销折扣
     */
    public void setPromoteRule(PromoteRule promoteRule) {
        this.promoteRule = promoteRule;
    }

    /**
     * 计算购买水果的总价格
     * @param fruits
     * @return
     */
    public float countTotalPrice(List<Fruit> fruits){
        float totalPrice = 0;
        for(Fruit fruit : fruits){
            totalPrice = totalPrice + fruit.getTotalPrice();
        }
        if(promoteRule != null){
            totalPrice = promoteRule.countByPromote(totalPrice);
        }
        return totalPrice;
    }

}
