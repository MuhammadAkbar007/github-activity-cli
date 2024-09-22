package uz.akbar;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

/**
 * GitHubApi
 */
public class GitHubApi {
	private static final String GITHUB_API_URL = "https://api.github.com/users/";

	public static String getGitHubActivity(String username) throws Exception {
		String uriString = GITHUB_API_URL + username + "/events";

		URI uri = new URI(uriString);
		URL url = uri.toURL();
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");

		int responseCode = connection.getResponseCode();
		if (responseCode != 200) {
			throw new Exception("Failed to fetch activity. Response code: " + responseCode);
		}

		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String inputline;
		StringBuilder content = new StringBuilder();

		while ((inputline = reader.readLine()) != null) {
			content.append(inputline);
		}

		reader.close();
		connection.disconnect();

		return content.toString();
	}
}
