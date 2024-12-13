package org.example;

class Vehicle {

    private String engine;
    private int wheel;

    //optional

    private int airbags;

    public Vehicle(){

    }

    public String getEngine() {
        return this.engine = engine;
    }

    public int getWheel() {
        return this.wheel = wheel;
    }

    public int getAirbags() {
        return this.airbags = airbags;
    }


    public Vehicle(VehicleBuilder builder) {
        this.engine = builder.engine;
        this.wheel = builder.wheel;
        this.airbags = builder.airbags;
    }

    public static class VehicleBuilder {
        private String engine;
        private int wheel;
        //optional
        private int airbags;

        public Vehicle build() {
            return new Vehicle(this);
        }
        public VehicleBuilder(String engine, int wheel) {
            this.engine = engine;

            this.wheel = wheel;
        }
        //setter method for airbags

        public VehicleBuilder setAirbags(int airbags) {
            this.airbags = airbags;
            return this;
        }




    }

}
     public class BuilderPatternExample{

        public static void main(String[] args) {
        Vehicle car= new Vehicle.VehicleBuilder("1500 cc ",4).setAirbags(2).build();
        Vehicle bike= new Vehicle.VehicleBuilder("100 cc",2).build();

            System.out.println("Car Engine "+car.getEngine());
            System.out.println("Car Wheels "+car.getWheel());
            System.out.println("Car Airbags "+car.getAirbags());

            System.out.println("Car Engine "+bike.getEngine());
            System.out.println("Car Wheels "+bike.getWheel());
            System.out.println("Car Airbags "+bike.getAirbags());

        }
    }

