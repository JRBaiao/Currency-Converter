# 💱 Java Currency Converter

This is a simple Java-based Currency Converter application that allows users to convert between different currencies using real-time exchange rates fetched via an external API.

## 🚀 Features

- Convert between any two global currencies
- Real-time exchange rate updates using API
- Clean and user-friendly interface (CLI or GUI, depending on your implementation)
- Error handling for invalid inputs and API issues

## 🔧 Technologies Used

- **Java**
- **HTTP Requests** via `HttpURLConnection` or a library like `HttpClient`
- **JSON Parsing** (e.g., with `org.json` or `Gson`)
- **External Currency API** (e.g., ExchangeRate-API, Open Exchange Rates, or another provider)

## 🔑 API Key

To access live exchange rates, you'll need an API key from a currency exchange service provider.

1. Sign up at (https://app.currencyapi.com)) or your chosen provider.
2. Get your API key.
3. Add the key to your Java project securely. (e.g., in an environment variable or configuration file — avoid hardcoding it in your source code)
