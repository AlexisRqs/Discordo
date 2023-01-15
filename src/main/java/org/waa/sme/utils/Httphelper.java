package org.waa.sme.utils;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

@Data
@Service
public class Httphelper {

    private static final String debutURL = "http://localhost:9000/";

    /**
     * Méthode qui permet la connexion avec mail/mdp
     * @param urlToRead
     * @return
     * @throws IOException
     */
    public static Long checkPassword(String mail, String pwd) throws IOException {
        try {
            URL url = new URL(debutURL+"connexion/" + mail);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setDoOutput(true);
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            byte[] pwdB = pwd.getBytes();
            con.setRequestProperty("Content-Length", Integer.toString(pwdB.length));
            con.getOutputStream().write(pwdB);
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
            System.out.println("mi sad"+content);
            String stringtmp= content.toString();
            Long longtmp = Long.parseLong(stringtmp, 10);
            return longtmp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<String> loadListeAmis(Long id) throws IOException {
        URL url = new URL(debutURL+"users/"+id+"/listeAmis");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
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
        String modifiedString = content.substring(1, content.length() - 1);
        modifiedString = modifiedString.replace("\"", "");
        List<String> list = Arrays.asList(modifiedString.split(","));
        return list;
    }

    public static String createUser(String nom, String prenom, String mail, String pwd, String dateNaissance) throws IOException {
        try {
            URL url = new URL(debutURL+"usersAjout");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setDoOutput(true);
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            String jsonInputString = "{\"nom\":\"" + nom + "\",\"prenom\":\"" + prenom + "\",\"mail\":\"" + mail + "\",\"pwd\":\"" + pwd + "\",\"dateNaissance\":\"" + dateNaissance + "\"}";
            byte[] jsonInputStringBytes = jsonInputString.getBytes();
            con.setRequestProperty("Content-Length", Integer.toString(jsonInputStringBytes.length));
            con.getOutputStream().write(jsonInputStringBytes);
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
            System.out.println("mi sad"+content);
            String stringtmp= content.toString();
            return stringtmp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //A Décommenter pour le test

    /*
    private void checkCreate() throws IOException {
        DiscordoApp m = new DiscordoApp();

        String prenom = prenom.getText();
        String nom = nom.getText();
        String mail = username.getText();
        String pwd = password.getText();
        String dateNaissance = dateNaissance.getText();


        if (!mail.equals("") && !pwd.equals("") && !prenom.equals("") && !nom.equals("") && !dateNaissance.equals("")) {
            try {
                String reponse = httpHelper.createUser(prenom, nom, mail, pwd, dateNaissance);
                if (reponse != null && !reponse.equals("")) {
                    System.out.println("NOUS VOILA ICI VIVANT VAILLANT :"+id);
                    m.changeScene("Login.fxml");
                }
                else {wrongPassword.setText("Mail deja utilisé");}
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (mail.equals("") && pwd.equals("") && prenom.equals("") && nom.equals("") && dateNaissance.equals("")) {
            wrongPassword.setText("Veuillez remplir les champs");
        }
        else {
            if(mail.equals("")) {
                wrongPassword.setText("Veuillez saisir une adresse e-mail");
            }
            if(pwd.equals("")) {
                wrongPassword.setText("Veuillez saisir un mot de passe");
            }
            if(prenom.equals("")) {
                wrongPassword.setText("Veuillez saisir un prenom");
            }
            if(nom.equals("")) {
                wrongPassword.setText("Veuillez saisir un nom");
            }
            if(dateNaissance.equals("")) {
                wrongPassword.setText("Veuillez saisir une date de naissance");
            }
        }
    }
     */
}
