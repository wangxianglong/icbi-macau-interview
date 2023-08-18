package com.icbi.macau;

import com.icbi.macau.entity.Apple;
import com.icbi.macau.entity.Fruit;
import com.icbi.macau.entity.Mango;
import com.icbi.macau.entity.Strawberry;
import com.icbi.macau.promote.PromoteRule;
import com.icbi.macau.promote.impl.PromoteRuleImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 单元测试类，四个test方法分别对应文档里的四个问题
 */
public class PurchaseTest {

    /**
     * 有一家超市
     */
   private Supermarket supermarket = new Supermarket();

    @Test
    public void test1(){
        List<Fruit> fruits = new ArrayList<>();
        /**
         * 购买了9斤苹果
         */
        Fruit apple = new Apple();
        apple.setWeight(9);
        fruits.add(apple);

        /**
         * 购买了3斤草莓
         */
        Fruit strawberry = new Strawberry();
        strawberry.setWeight(3);
        fruits.add(strawberry);

        float totalPrice = supermarket.countTotalPrice(fruits);
        System.out.println("最终价钱是：" + totalPrice);
    }

    @Test
    public void test2(){
        List<Fruit> fruits = new ArrayList<>();
        /**
         * 购买了9斤苹果
         */
        Fruit apple = new Apple();
        apple.setWeight(9);
        fruits.add(apple);

        /**
         * 购买了3斤草莓
         */
        Fruit strawberry = new Strawberry();
        strawberry.setWeight(3);
        fruits.add(strawberry);

        /**
         * 购买了5斤芒果
         */
        Fruit mango = new Mango();
        mango.setWeight(5);
        fruits.add(mango);

        float totalPrice = supermarket.countTotalPrice(fruits);
        System.out.println("最终价钱是：" + totalPrice);
    }

    @Test
    public void test3(){
        List<Fruit> fruits = getFruits();

        Supermarket supermarket = new Supermarket();
        float totalPrice = supermarket.countTotalPrice(fruits);
        System.out.println("最终价钱是：" + totalPrice);
    }

    @Test
    public void test4(){
        List<Fruit> fruits = getFruits();

        PromoteRule promoteRule = new PromoteRuleImpl();
        supermarket.setPromoteRule(promoteRule);
        float totalPrice = supermarket.countTotalPrice(fruits);
        System.out.println("最终价钱是：" + totalPrice);
    }

    /**
     * 问题3和问题4购买的水果抽取出一个方法
     * @return
     */
    private List<Fruit> getFruits() {
        List<Fruit> fruits = new ArrayList<>();
        /**
         * 购买了9斤苹果
         */
        Fruit apple = new Apple();
        apple.setWeight(9);
        fruits.add(apple);

        /**
         * 购买了3斤草莓
         */
        Fruit strawberry = new Strawberry();
        strawberry.setWeight(3);
        strawberry.setDiscount(0.8f);
        fruits.add(strawberry);

        /**
         * 购买了5斤芒果
         */
        Fruit mango = new Mango();
        mango.setWeight(5);
        fruits.add(mango);
        return fruits;
    }

    /**
     * 测试边界值
     */
    @Test
    public void testBoundaryValue(){
        PromoteRule promoteRule = new PromoteRuleImpl();
        supermarket.setPromoteRule(promoteRule);

        List<Fruit> fruits = new ArrayList<>();

        Fruit apple = new Apple();
        apple.setWeight(10);
        apple.setUnitPrice(10);
        fruits.add(apple);

        float totalPrice = supermarket.countTotalPrice(fruits);
        System.out.println("最终价钱是：" + totalPrice);

        fruits.clear();
        Fruit mango = new Mango();
        mango.setWeight(10);
        mango.setUnitPrice(10.1f);
        fruits.add(mango);
        totalPrice = supermarket.countTotalPrice(fruits);
        System.out.println("最终价钱是：" + totalPrice);

        fruits.clear();
        Fruit strawberry = new Strawberry();
        strawberry.setWeight(10);
        strawberry.setUnitPrice(9.999f);
        fruits.add(strawberry);
        totalPrice = supermarket.countTotalPrice(fruits);
        System.out.println("最终价钱是：" + totalPrice);
    }
}
