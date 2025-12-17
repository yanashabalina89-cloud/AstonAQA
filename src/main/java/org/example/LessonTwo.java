package org.example;

public class LessonTwo {
    public static void main(String[] args) {
        Product[] productsArray = new Product[5];
        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025",
                "Samsung Corp.", "Korea", 5599, true);
        productsArray[1] = new Product("OPPO A5x", "25.05.2025",
                "OPPO", "China", 6427, true);
        productsArray[2] = new Product("realme P3 Lite", "03.12.2025",
                "realme", "China", 8986, false);
        productsArray[3] = new Product("Tecno POVA 7", "21.08.2025",
                "Tecno", "China", 15801, false);
        productsArray[4] = new Product("iQOO Z10R", "19.07.2025",
                "iQOO", "China", 16780, true);

        for (Product product : productsArray){
            product.printInformation();
            System.out.println();
        }

        Park park = new Park("ЦПКиО", "Волгоградская обл., Волгоград, ул. Батальонная, 4");
        Park.Attraction attraction = park.new Attraction("Колесо обозрения", "10:00", "18:00", 500);
        attraction.getAttractionInfo();
    }
}
