package com.httpExamples;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.time.Duration;

public class PostRequest {

    public static final String FILE_JSON = "C:\\Users\\Pichau\\Documents\\MeusProjetos\\consumindo-api-java\\src\\com\\httpExamples\\pedido.json";
    public static final String URL_POST = "http://httpbin.org/forms/post";

    public static void main(String[] args) throws IOException {
        // instanciando um client http
        HttpClient client = HttpClient.newHttpClient();

        // criando a requisicao
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofFile(Path.of(FILE_JSON)))
                .timeout(Duration.ofSeconds(10))
                .uri(URI.create(URL_POST))
                .build();

        // enviando a requisicao do tipo POST (essa requisicao nao sera aceita!)
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();
    }
}
