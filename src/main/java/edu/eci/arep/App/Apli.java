package edu.eci.arep.App;

import static spark.Spark.*;
import spark.Request;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import spark.Response;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Apli {
	public static void main(String[] args) {
		port(getPort());
		get("/datos", (req, res) -> inputDataPage(req, res));
		get("/results", (req, res) -> resultsPage(req, res));  
	}
	static int getPort() {
		 if (System.getenv("PORT") != null) {
			 return Integer.parseInt(System.getenv("PORT"));
		 }
		 return 4567; 
		 }

	private static String inputDataPage(Request req, Response res) {
        String page
                = "<!DOCTYPE html>"
                + "<html>"
                + "<body style=\"background-color:#B9C5BC;\">"
                +"<font align=\"center\" color=\"Green\" face=\"Comic Sans MS,arial\">"
                + "<h1>Convertidor de grados farenheit en grados celcius</h1>"
                + "<form action=\"/results\">"
                + "  Ingrese unicamente valores en grados farenheit puesto que su respuesta sera en grados celcius <br>"
                + "  <input type=\"text\" name=\"numbers\" >"
                + "  <br><br>"
                + "  <input type=\"submit\" value=\"Submit\">"
                + "</form>"
                + "</body>"
                + "</html>";
        return page;
    }
	
	private static String resultsPage(Request req, Response res) {
        int ent= Integer.parseInt(String.valueOf(req));
        String result="";
        try {
            URL url = new URL(   "" + "?value=" + ent);
            String cad;
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            while ((cad = reader.readLine()) != null) {
                result = result + cad;
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(Apli.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Apli.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
		
}