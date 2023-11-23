# Data Monitoring CLI (DMCLI)

![GitHub repo size](https://img.shields.io/github/repo-size/gba-exe/data-monitoring-cli?style=for-the-badge)
![GitHub language count](https://img.shields.io/github/languages/count/gba-exe/data-monitoring-cli?style=for-the-badge)
![GitHub forks](https://img.shields.io/github/forks/gba-exe/data-monitoring-cli?style=for-the-badge)
![Bitbucket open issues](https://img.shields.io/bitbucket/issues/gba-exe/data-monitoring-cli?style=for-the-badge)
![Bitbucket open pull requests](https://img.shields.io/bitbucket/pr-raw/gba-exe/data-monitoring-cli?style=for-the-badge)


> Terminal interface for dynamically monitoring component data. Part of [StockSafe Solutions](https://github.com/StockSafe-Solutions) college project.

### Future improvements

This project is currently in development, so it may have some problems and/or possible improvements, such as:

- [x] Implement more monitoring categories
- [ ] Create online database
- [ ] Create alert features

## Pre-requisites

Before starting, check if you meet all the requirements:

- `Java 17` (or above).
- `Git` installed (and `Git Bash` if you're on Windows)
- `Windows / Linux / Mac`.
- Read [this](https://github.com/gba-exe/data-monitoring-cli/blob/main/README.md) entire document.

## How to install DMCLI

Follow these steps to install:

### Linux and macOS:
#### If you want to make changes in the source code and/or test the project
- Clone this repo:

```
git clone https://github.com/gba-exe/data-monitoring-cli
```

- Execute scriptMySQL.sql

- Open the project with your favorite IDE (i.e. IntelliJ IDEA, Netbeans, Eclipse)

- Run the project

#### If you want it for personal use
- Download the latest release [here](https://github.com/gba-exe/data-monitoring-cli/releases)
- Open your terminal and execute
```
java -jar [DOWNLOADED_ARCHIVE]
```

### Windows:
#### If you want to make changes in the source code and/or test the project
- Open `Git Bash`
- Clone this repo:
```
git clone https://github.com/gba-exe/data-monitoring-cli
```

- Execute scriptMySQL.sql

- Open the project with your favorite IDE (i.e. IntelliJ IDEA, Netbeans, Eclipse)

- Run the project

#### If you want it for personal use
- Download the latest release [here](https://github.com/gba-exe/data-monitoring-cli/releases)
- Open your terminal and execute
 ```
java -jar <DOWNLOADED_ARCHIVE>
```

## Using DMCLI

To use DMCLI you should follow these steps:

#### If you want it for personal use

- Choose Local environment
- Pick what category you want to monitor
- Insert 0 or Ctrl + C to exit

#### If you want to make changes in the source code and/or test the project

- Choose Local environment or Remote database(remote database is for altering categories on MySQL)
- Pick what category you want to monitor
- Insert 0 or Ctrl + C to exit

## Contributing to DMCLI

To contribute to DMCLI follow these instructions:

1. Fork this repo.
2. Create a new branch: `git checkout -b <BRANCH_NAME>`.
3. Make your changes and commit them: `git commit -m '<COMMIT_MESSAGE>'`
4. Send to original branch: `git push origin <PROJECT_NAME> / <PLACE>`
5. Create pull request.

Check docs on [creating pull requests](https://help.github.com/en/github/collaborating-with-issues-and-pull-requests/creating-a-pull-request).

## License

This project is under GPL-3.0 license. Read [LICENSE](LICENSE) for more details.
