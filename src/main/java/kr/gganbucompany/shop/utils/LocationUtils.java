package kr.gganbucompany.shop.utils;


import kr.gganbucompany.shop.utils.location.SimpleLocation;

public class LocationUtils {

    public static SimpleLocation parseSimpleLocation(String string) {
        String split[] = string.split(",");
        return new SimpleLocation(split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3]));
    }

}
