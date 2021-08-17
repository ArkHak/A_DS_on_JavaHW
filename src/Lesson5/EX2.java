package Lesson5;

import java.util.ArrayList;
import java.util.List;

public class EX2 {

    public static void main(String[] args) {
        List<ItemBag> itemList = new ArrayList<>();
        itemList.add(new ItemBag("Книга", 1, 600));
        itemList.add(new ItemBag("Бинокль", 2, 5000));
        itemList.add(new ItemBag("Аптечка", 4, 1500));
        itemList.add(new ItemBag("Ноутбук", 2, 40000));
        itemList.add(new ItemBag("Котелок", 1, 500));


        Bag myBag = new Bag(7);
        myBag.createAllSetsItems(itemList);
        System.out.println("Исходный набор предметов:");
        System.out.println(itemList);
        System.out.println("\n***[!!!ВЫПОЛНЯЕТСЯ ПОИСК ЛУЧШЕГО КОМПЛЕКТА СВОРОВАНННЫХ ПРЕДМЕТОВ!!!]***\n");
        myBag.getBestSetOfItems();

    }


    static class ItemBag {
        String title;
        int weight;
        int price;

        public ItemBag(String title, int weight, int price) {
            this.title = title;
            this.weight = weight;
            this.price = price;
        }

        public int getWeight() {
            return weight;
        }

        public int getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return title + ". W: " + weight + ", P: " + price + "\n";
        }
    }

    static class Bag {

        private List<ItemBag> bestSetOfItems;
        private int maxWeight;
        private int bestSumPrice;

        public Bag(int maxWeight) {
            this.maxWeight = maxWeight;
            this.bestSumPrice = 0;
            this.bestSetOfItems = new ArrayList<>();
        }

        public int summaryBagPrice(List<ItemBag> items) {
            int resultPrice = 0;
            for (ItemBag item : items) {
                resultPrice += item.getPrice();
            }
            return resultPrice;
        }

        public int summaryBagWeight(List<ItemBag> items) {
            int resultWeight = 0;
            for (ItemBag item : items) {
                resultWeight += item.getWeight();
            }
            return resultWeight;
        }

        public void checkBestList(List<ItemBag> items) {
            if (this.bestSetOfItems == null) {
                if (this.summaryBagWeight(items) <= this.maxWeight) {
                    this.bestSetOfItems = items;
                    this.bestSumPrice = this.summaryBagPrice(items);
                }
            } else {
                if (this.summaryBagWeight(items) <= this.maxWeight && this.summaryBagPrice(items) > this.bestSumPrice) {
                    this.bestSetOfItems = items;
                    this.bestSumPrice = this.summaryBagPrice(items);
                }
            }
        }

        //рекурсия!
        public void createAllSetsItems(List<ItemBag> items) {
            if (items.size() > 0) {
                this.checkBestList(items);
            }
            for (int i = 0; i < items.size(); i++) {
                List<ItemBag> tmpSet = new ArrayList<>(items);
                tmpSet.remove(i);
                createAllSetsItems(tmpSet);
            }
        }

        public void getBestSetOfItems() {
            System.out.println("Лучший набор при данном мешке:\n" + bestSetOfItems);
            System.out.println("Сумма украденого: " + bestSumPrice);
        }
    }
}

