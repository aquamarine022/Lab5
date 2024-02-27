package me.masha.models;

public class Coordinates {
        private Integer x; //Максимальное значение поля: 717, Поле не может быть null
        private float y;
        public Coordinates(int x, float y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + ";" + y;
        }
    }
