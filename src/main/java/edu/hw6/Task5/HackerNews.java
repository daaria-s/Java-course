package edu.hw6.Task5;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.net.http.HttpClient.newHttpClient;

public class HackerNews {

    static long[] hackerNewsTopStories() throws URISyntaxException, IOException, InterruptedException {
        var request =
            HttpRequest.newBuilder().uri(new URI("https://hacker-news.firebaseio.com/v0/topstories.json")).GET()
                .build();

        HttpResponse<String> response = newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        return Arrays.stream(response.body().substring(1, response.body().length() - 1).split(",")).map(Long::parseLong)
            .mapToLong(Long::longValue).toArray();

    }

    static String news(long id) throws URISyntaxException, IOException, InterruptedException {
        var request =
            HttpRequest.newBuilder().uri(new URI("https://hacker-news.firebaseio.com/v0/item/" + id + ".json")).GET()
                .build();

        HttpResponse<String> response = newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        Pattern pattern = Pattern.compile("\"title\":\"([^\"]*)\"");

        Matcher matcher = pattern.matcher(response.body());

        assert matcher.find();
        return matcher.group(1);

    }

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        hackerNewsTopStories();
        System.out.println(news(37570037));
    }
}
