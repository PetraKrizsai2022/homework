package service;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class ApiService {

    public HttpResponse getUsers() throws IOException {
        HttpGet get = new HttpGet("https://jsonplaceholder.typicode.com/users");
        HttpClient client = HttpClientBuilder.create().build();
        return client.execute(get);
    }

    public String getResponseBody(HttpResponse response) throws IOException {
        return EntityUtils.toString(response.getEntity());
    }
}
