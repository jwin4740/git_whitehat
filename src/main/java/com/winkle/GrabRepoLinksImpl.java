package com.winkle;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlListItem;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.util.HashMap;
import java.util.List;

public class GrabRepoLinksImpl implements GrabRepoLinks {
    public int totalRepos = 0;
    public int getTotalRepositories(){
        return totalRepos;
    }
    public void setUpScraper() {
        Configuration config = new Configuration();
        HashMap<String, String> props = config.getProperties();

        String repoDiv = props.get("repoDiv");
        String baseUrl = props.get("baseUrl");
        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);
        try {
            String searchUrl = baseUrl + "/jwin4740?page=1&tab=repositories";
            HtmlPage page = client.getPage(searchUrl);
            HtmlElement ele = page.getHtmlElementById(repoDiv);
            List<HtmlListItem> l = ele.getHtmlElementsByTagName("li");
            HtmlAnchor j = (HtmlAnchor) l.get(0).getFirstChild().getFirstChild().getFirstChild();
            System.out.println(j.getAttribute("href"));
            for (HtmlListItem i : l) {
                HtmlAnchor a = (HtmlAnchor) i.getFirstChild().getFirstChild().getFirstChild();
                System.out.println(a.getAttribute("href"));
            }


        } catch (
                Exception e) {
            e.printStackTrace();
        }

    }
}
