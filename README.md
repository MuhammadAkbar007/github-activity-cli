# GitHub Activity CLI

## Description
A simple command-line tool to fetch and display the recent activity of a GitHub user 🐱
using the GitHub API 🐙. The project is built using Java ☕️ (Maven 🪶)

## Features
* Fetches recent activity from a specified GitHub user.
* Displays activities like commits, issues, stars, and repository creation.
* Handles invalid usernames and API errors gracefully.

## GitHub Events
The application include the following GitHub Events:
- [x] Push Event 📍
- [x] Issues Event 🧨
- [x] Watch Event 🌟
- [x] Create Event 👼

## Usage
1. Clone the Repository:
```bash
git clone https://github.com/MuhammadAkbar007/github-activity-cli.git
cd github-activity-cli
```
2. Build the Project:
Make sure you have Maven installed, then run:
```bash
mvn clean package
```
This will create a JAR file in the `target` directory.
3. Run the Application:
```bash
java -jar target/github-activity-1.0-SNAPSHOT-jar-with-dependencies.jar [USARNAME]
```

## Error Handling
The application gracefully handles errors such as:
* Invalid GitHub username: If the username does not exist, it will display an error message.
* API failures: If there is an issue reaching the GitHub API, an appropriate error message will be shown.

## Project structure
* `src/main/java/`: Contains the main application source code.
* `target/`: Contains the compiled output and the JAR file.

## Project idea
The idea is taken from [Roadmap](https://roadmap.sh/) projects for beginners [task](https://roadmap.sh/projects/github-user-activity)

## Author
Created by [Akbar](https://github.com/MuhammadAkbar007).
