package uz.akbar;

/**
 * Main
 */
public class Main {

	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("Please provide a GitHub username! 😾");
		} else {
			String username = args[0];

			try {
				String activityJson = GitHubApi.getGitHubActivity(username);
				GitHubActivityParser.parseAndDisplayActivity(activityJson);
			} catch (Exception e) {
				System.out.println("Error fetching GitHub Activity:\n" + e.getMessage());
			}
		}
	}
}
