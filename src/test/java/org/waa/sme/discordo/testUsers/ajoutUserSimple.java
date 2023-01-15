package org.waa.sme.discordo.testUsers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

public class ajoutUserSimple {

    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String POST_URL = "http://localhost:9001/usersAjout";
    private static final String jsonBody = "{\"nom\":\"bob\",\"prenom\":\"testeur\",\"mail\":\"bobletesteurfou@mail.com\",\"password\":\"mdpdebob\",\"banni\":\"FALSE\",\"date_Naissance\":\"3000-0-0\"}";

    public ajoutUserSimple() throws JSONException {
    }

    public static void main(String[] args) throws IOException {
        sendPOST();
    }

    public static void sendPOST() throws IOException {
        URL obj = new URL(POST_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setDoOutput(true);
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setDoOutput(true);

        try (OutputStream os = con.getOutputStream()) {
            System.out.println("jsonBody = " + jsonBody);
            byte[] input = jsonBody.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        int responseCode = con.getResponseCode();
        System.out.println("POST Response Code : " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { //success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            if (!response.toString().equals(null)) {
                System.out.println("User ajouté");
            } else {
                System.out.println("User deja ajouté");
            }

        } else {
            System.out.println("POST request not worked");
        }
    }
}
