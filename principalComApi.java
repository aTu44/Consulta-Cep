package Principal;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class principalComApi {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner read = new Scanner(System.in);

        String busca = "";

        List<Cep> lista = new ArrayList<>();

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting()
                .create();

        while (!busca.equalsIgnoreCase("Sair")) {
            System.out.println("Digite seu cep:");
            busca = read.nextLine();

            if (busca.equalsIgnoreCase("Sair")) {
                break;
            }

            String endereco = "https://viacep.com.br/ws/" + busca + "/json/?callback=callback_name";
            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
                String json = response.body();
                System.out.println(json);

                Cep dadoCep = new Cep(json);

                lista.add(dadoCep);

            } catch (IllegalArgumentException e) {
                System.out.println("Erro");
                System.out.println(e.getMessage());
            }
        }
        FileWriter arquivo = new FileWriter("Cps.txt");
        arquivo.write(gson.toJson(lista));
        arquivo.close();
        read.close();
    }
}