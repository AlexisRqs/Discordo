package org.waa.sme.discordo.testUsers;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class connexion2 {

    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String GET_URL = "http://localhost:9000//connexion/";
    public connexion2() throws JSONException {
    }

    public static void main(String[] args) throws IOException {
        sendPOST();
    }

    private static void sendPOST() throws IOException {
        String mail = "bobletesteurfou@mail.com";
        String pwd = "mdpdebob";
        try {
            URL url = new URL("http://localhost:9000/connexion/" + mail);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
