package uz.akbar;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * GitHubActivityParser
 */
public class GitHubActivityParser {

	public static void parseAndDisplayActivity(String jsonResponse) {
		JSONArray events = new JSONArray(jsonResponse);

		for (int i = 0; i < events.length(); i++) {
			JSONObject event = events.getJSONObject(i);
			String eventType = event.getString("type");

			switch (eventType) {
				case "PushEvent":
					int commits = event.getJSONObject("payload").getJSONArray("commits").length();
					String repoName = event.getJSONObject("repo").getString("name");
					System.out.println("- 📍 Pushed " + commits + " commits to " + repoName + "\n");
					break;

				case "IssuesEvent":
					String action = event.getJSONObject("payload").getString("action");
					repoName = event.getJSONObject("repo").getString("name");
					System.out.println("- 🧨 " + action + " an issue in " + repoName + "\n");
					break;

				case "WatchEvent":
					repoName = event.getJSONObject("repo").getString("name");
					System.out.println("- 🌟 Starred " + repoName + "\n");
					break;

				case "CreateEvent":
					String refType = event.getJSONObject("payload").getString("ref_type");
					repoName = event.getJSONObject("repo").getString("name");

					if ("repository".equals(refType)) {
						System.out.println("- 👼 Created a new repository: " + repoName + "\n");
					} else if ("branch".equals(refType)) {
						String ref = event.getJSONObject("payload").getString("ref");
						System.out.println("- 👼 Created a new branch: " + ref + " in " + repoName + "\n");
					} else if ("tag".equals(refType)) {
						String ref = event.getJSONObject("payload").getString("ref");
						System.out.println("- 👼 Created a new tag: " + ref + " in " + repoName + "\n");
					}
					break;

				default:
					System.out.println("- 🤷 Not supported type: " + eventType + "\n");
					break;
			}

		}

	}
}
