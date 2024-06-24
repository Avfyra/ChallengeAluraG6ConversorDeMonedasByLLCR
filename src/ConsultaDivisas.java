import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaDivisas {
    public TasaDeCambio  buscarDivisa (String divisaInicial, String divisaFinal) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/d1cfb8b4d655ee6e3c68ada5/pair/" +
                divisaInicial + "/" + divisaFinal);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try{
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), TasaDeCambio.class);
        } catch (Exception e){
            throw new RuntimeException("Solicitud no procesada, favor de verificar sus datos");
        }
    }
}
