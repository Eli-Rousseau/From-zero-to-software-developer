# Git

## 1. Introduction to Version Control Systems

#### 1.1 What is Git?

Git is the most popular version control system in the world. It helps record changes made to code over time, storing them in a special database called a repository. This allows users to review project history, seeing who made changes, when, and why. If something goes wrong, it’s easy to revert to an earlier state. Without a version control system, managing different versions of a project would require multiple folders, which is slow and impractical, especially for teams.

#### 1.2 Categories of Version Control Systems

There are two main types of version control systems: centralized and distributed.

###### 1.2.1 Centralized Version Control Systems

In a centralized version control system, all team members connect to a central server to work on the latest copy of the code and share changes. The major drawback is that if the central server goes offline, team members cannot work on the project or save snapshots.

###### 1.2.2 Distributed Version Control Systems

Distributed version control systems, like Git, avoid this issue by giving each team member a complete copy of the project. Members can save snapshots locally on their machines. If the server is online, they can synchronize their work with others, making collaboration seamless.

#### 1.3 Why Git?

Git stands out because it is free, open source, super fast, scalable, and supports cheap branching and merging. This makes it an excellent choice for developers and teams working on projects of any size.

#### 1.4 Using Git

There are different ways that Git is used:

1. Git can be used from the command line by opening a terminal to execute Git commands. This method offers full access to all Git features and is often preferred by experienced users.

2. Most code editors and integrated development environments (IDEs) have built-in support for basic Git features. This integration allows developers to use Git commands directly within their coding environment, simplifying the workflow.

3. There are also graphical user interfaces (GUIs) specifically designed for using Git, such as GitKraken and Sourcetree. While GUI tools provide a more user-friendly experience, they may have limitations in terms of features and availability.

Although everything can be done from the command line, many people combine the use of both the command line and GUI tools. This combination can make certain tasks easier and more intuitive, enhancing the overall Git experience.

#### 1.5 Installing Git

To install Git on your machine, download the installer from the [Git website](https://git-scm.com/). Run the installer and follow the setup instructions to configure your installation. On Windows, the Git installer provides a Git Bash terminal application, which emulates a Linux bash terminal, allowing you to use Git commands in a familiar environment.

Once installed, you can verify the installation by opening a terminal and running the following command:

```bash
git --version
```

This command will display the installed version of Git, confirming that the installation was successful.

#### 1.6 Configuring Git for the First Time

###### 1.6.1 Configuation Level

When launching Git for the first time, you need to configure several settings, including your name, email, default editor, and line ending handling. This configuration can be set at three levels:

- **System Level**: Applies to all users on the machine.
- **Global Level**: Applies to all repositories for the current user.
- **Local Level**: Applies only to the current repository.

###### 1.6.2 Setting Configuration Values

You can start configuring Git using the following commands:

```bash
git config --global user.name "Name of User"
git config --global user.email user@email.com
git config --global core.editor "editor --wait" # Waits until editor is closed
git config --global -e # Opens configuration file in the core.editor
```

###### 1.6.3 Handling Line Endings

On Windows, line endings are marked by two characters: `\r` (carriage return) and `\n` (line feed), while MacOS only supports the line feed. Properly setting up line ending configurations is crucial to avoid issues.

- **`true`**: Ensures carriage returns are removed when synchronizing code to the repository and added back when checking out code.
- **`input`**: Ensures carriage returns are not added when checking out code and removes them if added by the code editor.

Set the configuration for line endings with:

```bash
git config --global core.autocrlf true
```

###### 1.6.4 Configuring Visual Difference Tool

Git allows you to set up a visual diff tool for easier inspection of file differences. To configure Visual Studio Code (VSCode) as your visual diff tool, use the following commands:

1. **Set the Diff Tool**:
   
   ```bash
   git config --global diff.tool vscode
   ```

2. **Configure the Launch Command**:
   
   ```bash
   git config --global difftool.vscode.cmd "code --wait --diff $LOCAL $REMOTE"
   ```

#### 1.7 Getting Help with Git Commands

To obtain more information about a specific Git command, you can use the `--help` or `-h` flags to find extended or concise documentation pages about a command.

```bash
git <command> --help
git <command> -h
```

## 2. Creating Snapshots

#### 2.1 The Git Workflow

As you modify files in your project directory, you eventually reach a point where you want to record these changes. Git manages this process with the following steps:

1. **Staging Area**: Before committing changes, they are first moved to the staging area. This area acts as a review space where you can select and prepare which changes to include in the next snapshot.
2. **Committing Changes**: Once you are satisfied with the staged changes, commit them to the repository. Each commit is then stored under a compressed fromat in the Git repository database.

#### 2.1 Initializing a Repository

To initialize a new Git repository in a project directory, one uses the following command:

```bash
git init 
```

This command creates a hidden subdirectory named `.git` within your project directory. The `.git` directory is where Git stores all the information about your project's history and configuration. This directory is essential for Git's operation and should not be modified manually.

#### 2.2 Staging Files

Files newly created or modified can be transferred to the staging area using the following commands:

```bash
git add <file> # Stages a single file
git add <file1> <file2> # Stages multiple files
git add *.txt # Stages with a pattern
git add . # Stages the current directory and all its content
```

###### 2.2.1 Ignoring Files and Directories for Stagging

In most projects, you should instruct Git to ignore certain files and directories, such as log files or binary files generated during compilation. To prevent Git from tracking specific files or directories, create a `.gitignore` file in your project directory. One can list relative or absolute paths of files and directories to ignore in the `.gitignore` file.

#### 2.3 Viewing the Status

One can observe the status of files using the following command:

```bash
git status # Full status
git status -s # Short status
```

These commands show the current state of your working directory and staging area, with red files indicating unstaged or modified files and green files indicating staged files ready for commit.

#### 2.4 Commiting the Staged Files

After reviewing the staging area, you can create a commit with a message using the following command:

```bash
git commit -m “Message” # Commits with a one-line message
git commit # Opens the default editor to type a long message
```

#### 2.5 Removing Files

The staging area retains files from current or upcoming commits. If you delete a file from the project directory, you need to stage this change with:

```bash
git add <deleted-file>
```

To directly remove a file from both the project directory and the staging area, use:

```bash
git rm <file>
```

#### 2.6 Renaming or Moving Files

The staging area retains files from current or upcoming commits. If you rename a file, you need to stage this change with:

```bash
git add <old-file-name>
git add <new-file-name>
```

To directly move a file in both the project directory and the staging area, use:

```bash
git mv <old-file-name> <new-file-name>
```

#### 2.7 Viewing the Staged/Unstaged Changes

To review the difference between the staged/unstaged files, one can use the following commands:

```bash
git diff # Shows unstaged changes
git diff --staged # Shows staged changes
```

#### 2.8 Viewing the Commit History

One can consult the history of commit operations from a repository using the following commands:

```bash
git log # Full history
git log --oneline # Summary
git log --reverse # Lists the commits from the oldest to the newest
```

The history provides detailed information about each commit, including the unique identifier, author, date and time, and the commit message.

#### 2.9 Viewing a Commit

Using a reference to a commit, one can consult all changes or changes made to an unique file in a commit using the folloiwng commands:

```bash
git show 921a2ff # Shows the given commit
git show HEAD # Shows the last commit
git show HEAD~2 # Two steps before the last commit
git show HEAD:<file> # Shows the version of file stored in the last commit
```

#### 2.10 Unstagging Files (Undoing git add)

To restore a file in the working directory to the version present in the staging area, use the following command:

```bash
git restore --staged <file> # Copies the last version of file from repo to index
```

#### 2.11 Discarding Local Changes

To restore a file in the working directory to the version present in the last commit, use the following command:

```bash
git restore <file> # Copies file from index to working directory
git restore <file1> <file2> # Restores multiple files in working directory
git restore . # Discards all local changes (except untracked files)

```

If one wants to restore all the files and also remove the untracked files not present in the stagging area, one should use the following command instead:

```bash
git clean -fd # Removes all untracked files
```

#### 2.12 Restoring Earlier Versions of a File

To restore earlier versions of a file in the working directory, one should also use a commit reference in the following command:

```bash
git restore --source=HEAD~2 file.js
```

## 3. Browsing History

#### 3.1 Viewing the History:

#### 3.2 Filtering the History:

#### 3.3 Formatting the log Output:

#### 3.4 Creating an Alias:

#### 3.5 Viewing a Commit:

#### 3.6 Comparing Commits

#### 3.7 Checking out a Commit:

#### 3.8 Finding a Bad Commit:

#### 3.9 Finding Contributors:

#### 3.10 Viewing the History of a File:

#### 3.11 Finding the Author of Lines:

#### 3.12 Tagging:

## 4. Branching & Merging

## 5. Collaboration

## 6. Rewriting History


