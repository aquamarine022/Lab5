package me.masha.models;

/**
 * enum with vehicles names
 */
public enum VehicleType {
        CAR,
        DRONE,
        MOTORCYCLE,
        SPACESHIP;
        public static String names() {
                StringBuilder nameList = new StringBuilder();
                for (var dragonType : values()) {
                        nameList.append(dragonType.name()).append(", ");
                }
                return nameList.substring(0, nameList.length()-2);
        }
        }
