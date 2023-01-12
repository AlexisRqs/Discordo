package org.waa.sme.discordo.testUsers;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ajoutUserMultiple {

    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String POST_URL = "http://localhost:9000/usersAjout";
    //String jsonBody = "{\"nom\":\"bob\",\"prenom\":\"testeur\",\"mail\":\"bobletesteurfou@mail.com\",\"password\":\"mdpdebob\",\"banni\":\"FALSE\",\"date_Naissance\":\"3000-0-0\"}";
    //JSONObject jsonObject = new JSONObject(jsonBody);

    public ajoutUserMultiple() throws JSONException {
    }

    public static void main(String[] args) throws IOException {
        String jsonBody = "{\"nom\":\"bob\",\"prenom\":\"testeur\",\"mail\":\"bobletesteurfou@mail.com\",\"password\":\"mdpdebob\",\"banni\":\"FALSE\",\"date_Naissance\":\"3000-0-0\"}";
        String jsonBody1 = "{\"nom\": \"rigolo\",\"prenom\": \"fedro\",\"mail\": \"fredolerigolo@mail.com\",\"password\": \"mdpdefredo\",\"banni\": \"FALSE\",\"date_Naissance\": \"3023-0-0\"}";
        String jsonBody2 = "{\"nom\": \"palma\",\"prenom\": \"jeane\",\"mail\": \"maisElleEstOuJeaaane@mail.com\",\"password\": \"mdpdejeane\",\"banni\": \"FALSE\",\"date_Naissance\": \"1789-0-0\"}";
        String jsonBody3 = "{\"nom\": \"ouer\",\"prenom\": \"wa\",\"mail\": \"waouer@mail.com\",\"password\": \"mdpdewa\",\"banni\": \"FALSE\",\"date_Naissance\": \"1789-0-0\"}";
        String jsonBody4 = "{\"nom\": \"pel\",\"prenom\": \"wi\",\"mail\": \"wipel@mail.com\",\"password\": \"mdpdewi\",\"banni\": \"FALSE\",\"date_Naissance\": \"1789-0-0\"}";
        String jsonBody5 = "{\"nom\": \"mon\",\"prenom\": \"ma\",\"mail\": \"mamon@mail.com\",\"password\": \"mdpdema\",\"banni\": \"FALSE\",\"date_Naissance\": \"1789-0-0\"}";

        sendPOST(jsonBody);
        sendPOST(jsonBody1);
        sendPOST(jsonBody2);
        sendPOST(jsonBody3);
        sendPOST(jsonBody4);
        HttpURLConnection validationFinale = sendPOST(jsonBody5);

        if (validationFinale.getResponseCode() == HttpURLConnection.HTTP_OK) {
            System.out.println("Le test ajoutUserMultiple est un succes");
        } else {
            System.out.println("Le test ajoutUserMultiple est un echec");
        }

    }

    private static HttpURLConnection sendPOST(String jsonBody) throws IOException {
        URL obj = new URL(POST_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("PUT");
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
            System.out.println(response.toString());

        } else {
            System.out.println("POST request not worked");
        }
        return con;
    }
}
