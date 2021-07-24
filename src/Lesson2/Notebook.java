package Lesson2;

import java.util.Random;

public class Notebook implements Comparable<Notebook> {
    private static final Random random = new Random();
    private int id;
    private String manufacturer;
    private Integer manufacturerID;
    private Integer RAM;

    private Integer price;

    private static final int[] COUNT_RAM = {4, 8, 12};

    private static final String[] COUNT_MANUFACTURER = {"Lenuvo", "Asos", "MacNote", "Eser", "Xamiou"};

    private static final int[] COUNT_MANUFACTURER_ID = {0, 1, 2, 3, 4};
    private static final int[] COUNT_PRICE = {500, 600, 700, 800, 900, 1000};

    public Notebook(int id, String manufacturer, int manufacturerID, int RAM, int price) {
        this.id = id;
        this.manufacturerID = manufacturerID;
        this.manufacturer = manufacturer;
        this.RAM = RAM;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public Integer getManufacturerID() {
        return manufacturerID;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getRAM() {
        return RAM;
    }

    public int getPrice() {
        return price;
    }

    public static Notebook[] getArray(int length) {
        Notebook[] arr = new Notebook[length];
        for (int i = 0; i < length; i++) {
            int manID = random.nextInt(COUNT_MANUFACTURER.length);
            arr[i] = new Notebook(i + 1,
                    COUNT_MANUFACTURER[manID],
                    manID,
                    COUNT_RAM[random.nextInt(COUNT_RAM.length)],
                    COUNT_PRICE[random.nextInt(COUNT_PRICE.length)]);
        }
        return arr;
    }

    //чит
    @Override
    public int compareTo(Notebook o) {
        int result = this.price.compareTo(o.price);

        if (result == 0) {
            result = this.RAM.compareTo(o.RAM);
        }

        if (result == 0) {
            result = this.manufacturerID.compareTo(o.manufacturerID);
        }
        return result;
    }
}