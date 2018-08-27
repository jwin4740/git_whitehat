package com.winkle;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;

import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String searchQuery = "iphone 6s";
        String baseUrl = "https://github.com/";
        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);
        try {
            String searchUrl = baseUrl + "jwin4740?tab=repositories";
            HtmlPage page = client.getPage(searchUrl);

            DomNodeList h3 = page.getElementsByTagName("h3");


            for (int i = 3; i < 13; i++) {
                DomNode a = (DomNode) h3.get(i);
                System.out.println(a.asXml());
            }
//                System.out.println(h3);
//                for (HtmlElement htmlItem : items) {
//                    HtmlAnchor itemAnchor = ((HtmlAnchor) htmlItem.getFirstByXPath(".//p[@class='result-info']/a"));
//                    HtmlElement spanPrice = ((HtmlElement) htmlItem.getFirstByXPath(".//a/span[@class='result-price']"));
//
//                    // It is possible that an item doesn't have any price, we set the price to 0.0 in this case
//                    String itemPrice = spanPrice == null ? "0.0" : spanPrice.asText();
//
//                    Item item = new Item();
//                    item.setTitle(itemAnchor.asText());
//                    item.setUrl(baseUrl + itemAnchor.getHrefAttribute());
//
//                    item.setPrice(new BigDecimal(itemPrice.replace("$", "")));
//
//
//                    ObjectMapper mapper = new ObjectMapper();
//                    String jsonString = mapper.writeValueAsString(item);
//
//                    System.out.println(jsonString);
//                }

        } catch (
                Exception e) {
            e.printStackTrace();
        }

    }

}

