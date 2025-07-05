import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;
import org.json.JSONObject;

public class main {

    public static void main (String[] args) throws IOException {

        HashMap<Integer, String> currencyCodes = new HashMap<Integer, String>();

        // Add currency codes
        currencyCodes.put(1, "USD");
        currencyCodes.put(2, "CAD");
        currencyCodes.put(3, "EUR");
        currencyCodes.put(4, "HKD");
        currencyCodes.put(5, "INR");

        Integer from, to;
        String fromCode, toCode;
        double amount;

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the currency converter!");

        System.out.println("Currency converting FROM?");
        System.out.println("1:USD\t 2:CAD\t 3:EUR\t 4:HKD\t 5:INR\t ");
        from = sc.nextInt();
        while(from < 1 || from > 5){
            System.out.println("Please select a valid currency (1-5)");
            System.out.println("Please select a valid currency (1-5)");
            from = sc.nextInt();
        }
        fromCode = currencyCodes.get(from);

        System.out.println("Currency converting TO?");
        System.out.println("1:USD\t 2:CAD\t 3:EUR\t 4:HKD\t 5:INR\t ");
        to = sc.nextInt();
        while(to < 1 || to > 5){
            System.out.println("Please select a valid currency (1-5)");
            System.out.println("Please select a valid currency (1-5)");
            to = sc.nextInt();
        }
        toCode = currencyCodes.get(to);


        System.out.println("Amount you wish to convert?");
        amount = sc.nextFloat();

        sendHTTPGETRequest(fromCode, toCode, amount);

        System.out.println("Thank you for using the currency converter!");
    }

    private static void sendHTTPGETRequest(String fromCode, String toCode, double amount) throws IOException {

        DecimalFormat f = new DecimalFormat("00.00");

        // Replace this with your actual API key
        String API_KEY = "cur_live_pCxZOceAoF6KIvoQEwCVWdPKHsIMcPr4C0So1hcI";

        String GET_URL = "https://api.currencyapi.com/v3/latest?apikey=" + API_KEY
                + "&base_currency=" + fromCode + "&currencies=" + toCode;

        URL url = new URL(GET_URL);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        int responseCode = httpURLConnection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            JSONObject obj = new JSONObject(response.toString());
            Double exchangeRate = obj.getJSONObject("data").getJSONObject(toCode).getDouble("value");

            System.out.println();
            System.out.println(f.format(amount) + " " + fromCode + " = " + f.format(amount * exchangeRate) + " " + toCode);
        } else {
            System.out.println("GET request failed! Response Code: " + responseCode);
        }
    }


}