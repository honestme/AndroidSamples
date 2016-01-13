package com.honestme.animetasteex;

import android.net.Uri;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangconglin on 2016/1/11.
 */
public class ATEApiUtil {
    public static final int ATE_MAIN = 0;
    public static final int ATE_INTERVIEW = 1;
    public static final int ATE_WEEKLY_INSPIRATIONS = 2;
    public static final int ATE_AIMOZHEN = 3;
    public static final int ATE_SUGER = 4;
    public static final int ATE_ATTENTION = 5;

    public static final String ATE_MAIN_URL = "http://animetaste.net";
    public static final String ATE_INTERVIEW_URL = "animetaste.net/category/interview";
    public static final String ATE_WEEKLY_INSPIRATIONS_URL = "animetaste.net/category/weekly-inspirations";
    public static final String ATE_AIMOZHEN_URL = "http://aimozhen.com";
    public static final String ATE_SUGER_URL = "http://bingtanghuluer.com/";
    public static final String ATE_ATTENTION_URL = "";

    public static String getFormatUri(int type,int page){
        StringBuffer stringBuffer = new StringBuffer();

        switch (type){
            case ATE_MAIN:
                stringBuffer.append(ATE_MAIN_URL);
                break;
            case ATE_INTERVIEW:
                stringBuffer.append(ATE_INTERVIEW_URL);
                break;
            case ATE_WEEKLY_INSPIRATIONS:
                stringBuffer.append(ATE_WEEKLY_INSPIRATIONS_URL);
                break;
            case ATE_AIMOZHEN:
                stringBuffer.append(ATE_AIMOZHEN_URL);
                break;
            case ATE_SUGER:
                stringBuffer.append(ATE_SUGER_URL);
                break;
            case ATE_ATTENTION:
                stringBuffer.append(ATE_ATTENTION_URL);
                break;
        }

        stringBuffer.append("/page/" + page);

        return stringBuffer.toString();
    }

    public static String getHtmlFromUrl(String urlStr) throws Exception{
        StringBuffer stringBuffer = new StringBuffer();

        try {
            URL url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setDoInput(true);
            connection.setDoOutput(true);

            if(connection.getResponseCode() == 200){
                InputStream inputStream = connection.getInputStream();
                int length = 1024;
                byte[] buffer = new byte[1024];
                while(inputStream.read(buffer) != -1){
                    stringBuffer.append(new String(buffer,0,length,"UTF-8"));
                }
                inputStream.close();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return stringBuffer.toString();
    }

    public static List<ATEItem> getDataFromUri(int type,int page){
        List<ATEItem> itemList = new ArrayList<ATEItem>();


        String formatUrl = getFormatUri(type, page);

        Uri uri = Uri.parse(formatUrl);
        try {
            String htmlStr = getHtmlFromUrl(formatUrl);
            Document document = Jsoup.parse(htmlStr);
            Elements elements = document.select("div.post");
            Elements elementsAMZ= document.select(".post.amz-post");

            for(int i = 0; i < elements.size();++i){
                ATEItem item = new ATEItem();
                Element element = elements.get(i);
                Element elementViewTimes = element.select(".post-viewed").get(0);
                String viewTimes = elementViewTimes.text();
                item.setmViewTimes(viewTimes);

                Element elementTitle = element.select(".post-title").get(0);
                String title = elementTitle.text();
                String contentLink = elementTitle.attr("href");
                item.setmTitle(title);
                item.setmContentLink(contentLink);

                Element elementAuthor = element.select(".post-author").get(0);
                String author = elementAuthor.text();
                item.setmAuthor(author);

                Element elementMain = element.select(".post-main").get(0);
                String imageUrl = elementMain.select(".post-thumbnail").get(0).attr("src");
                item.setmImageUrl(imageUrl);

                Element elementAMZ = elementsAMZ.get(i);
                Element elementContent = elementAMZ.select(".content").get(0);
                Element elementAnimeTitle = elementContent.select("title").get(0);
                String animeTitle = elementAnimeTitle.text();
                String animeLink = elementAnimeTitle.attr("href");
                Element elementAnimeDescription = elementContent.select("description").get(0);
                String animeContent = elementAnimeDescription.text();
                item.setmAnimeLink(animeLink);
                item.setmAnimeContent(animeContent);
                item.setmAnimeTitle(animeTitle);

                itemList.add(item);

            }

        }catch (Exception ex){
            ex.printStackTrace();
        }

        return itemList;
    }

}
