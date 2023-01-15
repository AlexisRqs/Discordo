package org.waa.sme.discordo.testUsers;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class connexion {

    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String GET_URL = "http://localhost:9000//connexion/";
    public connexion() throws JSONException {
    }

    public static void main(String[] args) throws IOException, JSONException {
        sendPOST();
    }

    private static void sendPOST() throws IOException, JSONException {
        ajoutUserSimple ajoutUserSimpleMethode = new ajoutUserSimple();
        ajoutUserSimpleMethode.sendPOST();

        String mail = "bobletesteurfou@mail.com";
        String pwd = "mdpdebob";
        try {
            URL url = new URL("http://localhost:9001/connexion/" + mail);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setDoOutput(true);
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Content-Length", Integer.toString(pwd.getBytes().length));
            con.getOutputStream().write(pwd.getBytes());
            int status = con.getResponseCode();
            System.out.println("status:" + status);
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            con.disconnect();
            System.out.println(content);
            if (status == 200 && content.toString().equals("1")) {
                System.out.println("Connexion réussie");
            } else {
                System.out.println("Connexion échouée");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
