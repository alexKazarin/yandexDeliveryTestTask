package com.company;

import java.text.DecimalFormat;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        try {
            Double deliveryCostResult = deliveryCost(15, 50, false, 1.4);
            System.out.println("Cost of delivery will be : "  + deliveryCostResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param distance - double value how far delivery is
     * @param size - integer value as sum of 3 dimensions in cm, size of parcel
     * @param fragile - boolean value is parcel fragile or not
     * @param currentLoad - double value how loaded service is at the moment
     * @return finalCost - double value result cost of delivery
     */
    public static double deliveryCost(double distance, Integer size, Boolean fragile, double currentLoad) throws Exception {
        double finalCost = 0;

        if ( distance <= 0) {
            throw new Exception("Distance is low");
        }

        if ( size <= 0) {
            throw new Exception("Size is low");
        }

        if ( !Arrays.asList(1.0, 1.2, 1.4, 1.6).contains(currentLoad)) {
            throw new Exception("Unknown load");
        }

        if (distance < 2) {
            finalCost+=50;
        }
        else if (distance < 10) {
            finalCost+=100;
        }
        else if (distance < 30) {
            finalCost+=200;
        }
        else if (distance > 30) {
            finalCost+=300;
            if (fragile) throw new FragileException();
        }

        if (size < 150) {
            finalCost+=100;
        }
        else {
            finalCost+=200;
        }

        if (fragile) {
            finalCost+=300;
        }

        finalCost*=currentLoad;

        if (finalCost < 400) {
            finalCost = 400;
        }

        return finalCost;
    }

}

