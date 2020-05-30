package com.bryan.cloud;

import java.math.BigInteger;

public class App {



    public static void main(String[] args) {
//        StringBuilder sb=new StringBuilder();
//        //sb.append(1);
//        for(int i=0;i<1000;i++){
//            sb.append(0);
//        }
//        sb.append(1).append(1);
//
//        String str1=sb.toString();
//        String str2="101";
//        BigInteger b1=new BigInteger(str1);
//        BigInteger b2=new BigInteger(str2);
//        BigInteger and = b1.and(b2);
//        System.out.println(and);
//        System.out.println(and.testBit(0));
//        System.out.println(and.testBit(1));
//        System.out.println(and.testBit(2));

        BigInteger b1=new BigInteger("0");
        BigInteger bigInteger = b1.setBit(0);
        System.out.println(bigInteger);
        System.out.println(bigInteger.bitLength());  //统计 位数
        System.out.println(bigInteger.bitCount());   //统计设置了1的位数
        System.out.println(bigInteger.testBit(0));
        System.out.println(bigInteger.testBit(1));
        System.out.println(bigInteger.testBit(7));
        System.out.println(bigInteger.testBit(70));

    }
}
