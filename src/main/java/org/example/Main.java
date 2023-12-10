package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * @author 1ommy
 * @version 10.12.2023
 */
public class Main {
    public static void main(String[] args) {
        try {
            //
            Document document = Jsoup.connect("https://www.avito.ru/moskva/kvartiry/prodam-ASgBAgICAUSSA8YQ?cd=1&q=квартиры+в+москве+купить").get();

            System.out.println(document.title());
//            "section.programs-teaching > div.container-fluid > div.row > div.col-12.header-section > h1"
            Elements select = document.select("div[data-marker='item']");

            for (Element element : select) {
//                Elements url = element.select("div > div > div:nth-child(2) > div:nth-child(2) > div > div " +
//                        "a[item-prop='url']");
                Elements url = element.select("div > div:nth-child(2)");
                url.forEach((el) -> System.out.println("https://avito.ru" + el.text()));

                Elements price = element.select("meta[itemprop='price']");
                System.out.println(price.attr("content") +" руб");

            }

        } catch (IOException exception) {
            System.out.println(exception.getMessage());
            System.err.println("такого сайта нет");
        }

    }
}