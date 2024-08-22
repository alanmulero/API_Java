package br.com.alura.screenmatch.principal;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;

public class PrincipalComBusca {

	public static void main(String[] args) throws IOException, InterruptedException {
		// Integrando com API e usando classe Scanner.
		Scanner leitura = new Scanner(System.in);

		// Implementando uma busca dinamica pelo teclado com a classe Scanner.
		System.out.println("Digite um nome de filme para busca: ");
		var busca = leitura.next();
		var endereco = "http://www.omdbapi.com/?t=" + busca + "&apikey=6331e1f1";

		// Chamando classe HttpRequest.
		// Requisição.
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();

		// Buscando a resposta da requisição pela Interface HttpResponse.

		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		System.out.println(response.body());

	}

}
