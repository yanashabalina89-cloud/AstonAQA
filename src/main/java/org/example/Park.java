package org.example;
import java.time.LocalTime;

public class Park {
    private String parkName;
    private String parkAddress;

    Park(String parkName, String parkAddress) {
        this.parkName = parkName;
        this.parkAddress = parkAddress;
    }

    public class Attraction{
        private String attractionName;
        private LocalTime openTime;
        private LocalTime closeTime;
        private float price;

        public Attraction(String attractionName, String openTime, String closeTime, float price) {
            this.attractionName = attractionName;
            this.openTime = LocalTime.parse(openTime);
            this.closeTime = LocalTime.parse(closeTime);
            this.price = price;
        }

        public void getAttractionInfo() {
            System.out.println(
                    "Park Name: " + Park.this.parkName +
                    "\nPark Address: " + Park.this.parkAddress +
                    "\nAttraction Name: " + this.attractionName +
                    "\nOpen Time: " + this.openTime +
                    "\nClose Time: " + this.closeTime +
                    "\nPrice: " + this.price
            );
        }
    }

}
