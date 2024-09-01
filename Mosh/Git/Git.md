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
git log --all # Shows the commits for all branches
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

To restore a file in the staging area to the version from the last commit, use the following command:

```bash
git restore --staged <file> # Copies the last version of file from repo to index
```

#### 2.11 Discarding Local Changes

To restore a file in the working directory to the version present in the last commit, use the following command:

```bash
git restore <file> # Copies file from staging area to working directory
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

#### 3.1 Viewing the History

One can consult in the commit history the list of modified files and actual changes made to them by combining multiple flags:

```bash
git log --stat # Shows the list of modified files in each commit
git log --patch # Shows the actual changes (patches)
```

By adding the file name at the end one can consult the commit history for a specific file:

```bash
git log <file>
```

#### 3.2 Filtering the History

One can filter the commit history using different flags:

```bash
git log -3 # Shows the last 3 entries
git log --author=“Eli” # Shows all the commit of the author
git log --before=“2024-08-04” # Finds all commits on the indicated date or before
git log --after=“2024-08-04” # Finds all commits on the indicated date or after
git log --grep=“pattern” # Commits with “pattern” in their message
git log -S“pattern” # Commits with “pattern” in their patches
git log reference1..reference2 # Range of commits
git log file.txt # Commits that touched file.txt
```

#### 3.3 Creating an Alias

One can create aliases for frequently used Git commands to avoid typing their full form by using:

```bash
git config --global alias.<custom-cmd-name> "my git command"
```

#### 3.4 Comparing Commits

One can compare the changes of one or more files across two commits using the following command:

```bash
git diff HEAD~2 HEAD # Shows the changes between two commits
git diff HEAD~2 HEAD <file> # Changes to file only
```

#### 3.5 Checking out a Commit

To view a snapshot of your project at a specific commit, you can use:

```bash
git checkout <commit-hash>
```

Using the `git checkout` command places you in a detached HEAD state, meaning the HEAD pointer is not on the master branch. Be cautious not to create new commits in this state; use it for inspecting or experimenting with a previous version of your project.

To return to the master branch and reattach the HEAD pointer, use:

```bash
git checkout master
```

#### 3.6 Finding Contributors

One can find all the contributors and their commit messages in the repository using the following command:

```bash
git shortlog
```

#### 3.7 Finding the Author of Lines

To identify who made specific changes to a file one can use the following command:

```bash
git blame <file>
```

#### 3.8 Tagging

Tags are bookmarks for commits in a project.

```bash
git tag # Shows all the current tags
git tag <name-of-tag> <hash-commit> # Creates a lightweight tag
git tag <name-of-tag> <hash-commit> -m "message" # Creates an annotated tag with custom message
git tag -d <name-of-tag> # Deletes a tag
```

Tags can be used as commit references in Git commands, similar to the HEAD pointer.

## 4. Branching & Merging

#### 4.1 How do Branches Work?

Branching allows you to diverge from the main line of work (typically the master branch) and work in isolation on different tasks. Each branch acts as a separate workspace. Once the work in a branch is tested and approved, it can be merged back into the master branch, keeping the main line stable.  In Git, branching is efficient as it uses pointers instead of copying the entire project. The master branch is a pointer to the latest commit, and new branches create additional pointers that move with new commits. The HEAD pointer indicates the current branch you are working on.

#### 4.2 Managing branches

To display the current branch and its status one uses the following command:

```bash
git status
```

Instead one can also use the following command to show all branches:

```bash
git branch
```

There are different commands that are used to manipulate and switch between branches:

```bash
git branch <branch-name> # Creates a new branch
git switch <branch-name> # Switches to another branch
git branch -m <old-branch-name> <new-branc-name> # Rename a branch
git branch -d <branch-name> # Deletes branch without commits
git branch -D <branch-name> # Enforce the branch deletion
```

#### 4.3 Comparing branches

To display the differences in commits or in the exact changes that have been made between two branches, one can use the following commands:  

```bash
git log <branch1>..<branch2> # Lists the commits of branch2 not in branch1
git diff <branch1>..<branch2> # Shows the summary of changes in branch2 not in branch1
```

#### 4.4 Stashing

Git prevents switching branches if there are unstaged changes, but you can use a stash to save these changes temporarily. This allows you to switch branches freely and later reapply the stashed changes to your working directory when you return to the original branch.

```bash
## Creating stach for a branch
git stash push -m “message” # Creates a new stash

## Inspect the staches and their content
git stash list # Lists all the stashes
git stash show stash@{1} # Shows the given stash
git stash show 1 # shortcut for stash@{1}

## Apply the stached changes to the working directory
git stash apply 1 # Applies the given stash to the working dir

## Deleting Staches
git stash drop 1 # Deletes the given stash
git stash clear # Deletes all the stashes
```

#### 4.5 Merging

###### 4.5.1 Types of Merges

In Git, there are two types of merges:

1. **Fast-forward merges**: occur when changes in a branch are linear and have not diverged from the master branch, allowing the master pointer to simply move to the latest commit of the branch. 

2. **3-way merges**: are used when branches have diverged, with commits made independently. In this case, Git creates a new commit that combines the last common commit and the latest commits from both branches.

###### 4.5.2 Merging Branches

To merge a branch with the master branch, one needs to switch to the master branch and use the following command:

```bash
git merge <banch-name> # Default merge
git merge --no-ff <banch-name> # Disable fast forward merge
```

By default, Git performs a fast-forward merge when branches have not diverged, but this can be disabled to force a 3-way merge, which creates a new commit combining the last commits from both branches and their common ancestor. Disabling fast-forward merges can simplify reverting features later by allowing a single commit to undo changes, rather than multiple steps. This choice depends on personal preference and project needs.

###### 4.5.3 Display Graph History

To display the commit history in a visual format with all branches one can use the following command:

```bash
git log --oneline --all --graph
```

###### 4.5.4 Viewing the merged branches

To see all branches currently merged/unmerged with the current master branch one can use the following commands:

```bash
git branch --merged ## Shows all branches merged with master
git branch --no-merged ## Shows all branches not merged with master
```

###### 4.5.5 Resolving Merging Conflicts

When merging branches, conflicts can occur if the same code is modified differently, a file is deleted in one branch and changed in another, or different contents are added to the same file in both branches. The more branches diverge, the more conflicts may arise. Git halts the merge process when conflicts occur, requiring user intervention to resolve them. One can check conflicts with the status command, open the conflicted files in a code editor, follow the prompts to resolve the conflicts, and stage the resolved files. Once all conflicts are resolved, one can complete the merge using the commit command.

Git can be configured to use external visual merge tools, such as p4merge, to handle conflicts more effectively.

###### 4.5.6 Aborting a Merge

If we do not want to handle a conflict immediately, one can use the following command to abort a merge operation:

```bash
git merge --abort
```

###### 4.5.7 Undoing a Faulty Merging

If a merge results in a non-working project, you can undo the merge by creating a new commit that reverts it, rather than rewriting history. Use the following command, where `-m 1` refers to the first parent branch:

```bash
git revert -m 1 HEAD
```

###### 4.5.8 Squash Merging

For merging two branches while avoiding undesirable commits, use a squash merge. This method merges the commits of the second branch into the master branch without tracking the divergence, maintaining a linear history and preventing history pollution. It's ideal for short branches with bad history. Use the following command, then review and commit the changes:

```bash
git merge --squash <branch-name>
```

Note that this command only stages the changes without making a commit, and the target branch should be removed after the merge.

#### 4.6 Rebasing

To align the commits of a diverging branch with the latest commit of the master branch, use rebasing. This process moves the branch's commits on top of the master branch, creating a linear history and allowing for fast-forward merging. However, be cautious as rebasing rewrites history. Perform the rebase with:

```bash
git rebase master
```

If conflicts arise, resolve them and then use:

```bash
git rebase --continue # Continues the rebase after resolving conflicts
git rebase --abort    # Aborts the current rebase operation
```

#### 4.7 Cherry picking

Cherry-picking allows you to apply a specific commit from one branch to another. To use a commit from a second branch on the master branch, switch to the master branch and run:

```bash
git cherry-pick <hash-commit>
```

#### 4.8 Transferring a File from Another Branch

To transfer a specific file version from a commit in a second branch to the master branch, use:

```bash
git restore --source=<branch-name> <file-name>
```

## 5. Collaboration

#### 5.1 Collaboration Workflows

###### 5.1.1 Understanding Git's Distributed System and Collaboration

Git operates on a distributed system, allowing each individual to maintain a complete copy of the project on their local machine. This setup enables users to save snapshots locally and synchronize their work with others when the server is online, facilitating seamless collaboration.

###### 5.1.2 Centralized Workflow and Repositories

Collaboration is based on a centralized workflow where each team member has a separate local repository, but synchronization occurs through a centralized repository. These repositories can be stored on private servers or cloud services like GitHub, which can be set as private for team access only. Team members start by pulling a copy of the centralized repository to their local systems, make their commits, and push these commits back to the centralized repository. Before pushing their own commits, members must pull any updates from the centralized repository to ensure synchronization.

###### 5.1.3 Open-Source Collaboration and Integration Manager Architecture

In open-source projects, an integration manager architecture is used, involving maintainers and contributors. Contributors, who are external and not fully trusted, do not have push or write access to the centralized repository. Instead, they fork the repository to create a copy in the cloud, clone it locally, make their commits, and push changes to the forked copy. They then send a pull request to the maintainer. The maintainer reviews the changes and, if satisfied, merges and pushes them to the original centralized repository.

###### 5.1.4 GitHub Plateform

GitHub is a popular Git hosting platform where users can create their own repositories. To add collaborators, users can go to the repository settings and manage access to invite them.

#### 5.2 Pushing, Fetching, and Pulling

###### 5.2.1 Cloning a Repository

Once access is granted to all collaborators, each can work on the project by cloning the repository to their local machine. They need to copy the URL of the centralized repository from the GitHub page and use the following command:

```bash
git clone <project-url>
```

Git will create a new repository with the same name. The source repository is named 'origin,' referring to the centralized repository. This includes pointers like origin/master for the master branch and origin/HEAD for the HEAD pointer of the centralized repository. Origin is a remote tracking branch that cannot be directly accessed from the local machine.

###### 5.2.2 Fetching a Repository

Our local repository is not automatically synchronized with the remote repository, so new commits made remotely will not be reflected locally. To download the latest commits from the remote repository, use the following command:

```bash
git fetch origin <branch-name> # Default without branch name fetches all branches
```

This updates the local repository and moves the `origin/master` pointer to the new commit. To synchronize the local master pointer, merge it with `origin/master` and resolve any conflicts that arise:

```bash
git merge origin/master
```

###### 5.5.3 Pulling a Repository

To bring changes from a remote repository into your local repository, combine the fetch and merge commands using:

```bash
git pull
```

This command pulls the latest commits from the remote repository and adds them to the local repository. By default, if the master and origin/master branches have diverged, it performs a three-way merge. Alternatively, you can use the rebase option to apply your local commits directly behind the remote commits in a linear fashion:

```bash
git pull --rebase
```

###### 5.5.4 Pushing a Repository

To synchronize the master branch on your local machine with the remote repository, use:

```bash
git push
```

This command updates the remote repository, moving the origin/master pointer to the latest commit on the master branch. If the local master branch is ahead of origin/master, but the remote repository has diverged, you must first synchronize your local repository with the remote repository before the push command will be valid.

###### 5.5.5 Sharing Tags

To share a local tag with collaborators on the central repository, use:

```bash
git push origin <tag-name>
```

To remove a tag from the remote repository, use:

```bash
git push origin --delete <tag-name>
```

###### 5.5.6 GitHub Releases

GitHub's releases feature allows you to package software with source code, binary files, and release notes. You can create a new release in the repository's release settings, add tags, a release title, and notes, and attach binary files. The tag is added to the latest commit of the centralized repository, providing a convenient way to distribute software packages.

###### 5.5.7 Sharing Branches

Local branches in Git are private by default and need to be explicitly pushed to the centralized repository for collaboration. To share a branch, switch to it and use:

```bash
git push -u origin <branch-name>
```

This command links the local branch to the remote repository with the origin pointer. To verify the linkage, use:

```bash
git branch -vv # Displays local branch coupled to remote branch
git branch -r # Displays all the remote branches
```

To remove a remote branch without deleting the local branch, use:

```bash
git remote prune origin  # Removes remote branch from local repository
git push -d origin <branch-name>  # Removes remote branch from centralized repository without deleting the local branch
```

#### 5.3 Pull Requests, Issues, and Milestones

###### 5.3.1 Collaborating with Pull Requests

Pull requests in GitHub allow team members to review and provide feedback on changes before merging a branch into the master branch. After pushing the local branch to the centralized repository, a pull request can be initiated from GitHub by selecting the base (master) and the feature branch for comparison. This process checks for mergeability and potential conflicts. Reviewers can be added to the pull request to provide comments and suggestions. The review process facilitates discussion and necessary changes before the final merge.

###### 5.3.2 Collaborating with Issues

GitHub's issue tracking feature complements pull requests by allowing users to create, describe, and assign issues to collaborators with specific labels. This opens a discussion page for team collaboration on resolving the issue. Successfully merging a pull request can close the related issue. The issues tab also enables the customization of project labels.

###### 5.3.3 Milestones

Milestones in GitHub help track the progress of multiple issues by bundling them together, making it easier to manage improvements for a new project version or other goals. Issues can be assigned to milestones to monitor collective progress.

#### 5.4 Contributing to Open-Source Projects

###### 5.4.1 Contributing with Forked Repository

To collaborate on an open-source project without push access on GitHub, you can fork the repository to your account, creating a local version. You can then clone this fork to your local machine to work on. After making changes and pushing them to your fork, you can open a pull request to propose merging your changes into the original repository. Only the maintainers of the original repository can merge and close the pull request.

###### 5.4.2 Keeping Forked Repositories Synchronized

To keep a forked repository in sync with the original base repository, add a reference to the base repository and pull new commits. This can be done with the following commands:

```bash
git remote add upstream <url-base-repository> # Adds a remote link to the base repository
git remote -v # Shows all remote links
git pull upstream master # Pulls new commits from the base repository's master branch
git push origin master # Pushes the updates to your forked repository
```

To remove a remote link, use:

```bash
git remote rm <remote-name>
```

## 6. Rewriting History

#### 6.1 Why and When to Rewrite History

To maintain a clean, readable, and meaningful commit history in Git, it's important to ensure commit messages are meaningful and commits are appropriately sized and related. You can squash small related commits into a single commit, split large commits into multiple logical ones, reword commit messages, drop unwanted commits, and modify commit contents. 

Rewriting history can be risky and should adhere to the golden rule of not rewriting public history, meaning commits that have been pushed and shared with others should not be modified. However, rewriting the history of local commits before pushing is a good practice.

#### 6.2 Undo or Revert Commits

###### 6.2.1 Remove Commit from History

Git allows complete removal of a commit from history using the reset command. The effects of different options are:

- `--soft`: Moves the HEAD pointer to the specified commit without changing the staging area or working directory, effectively just removing the commit.
- `--mixed`: Moves the HEAD pointer and changes the staging area but leaves the working directory unchanged, unstaging files.
- `--hard`: Moves the HEAD pointer and resets both the staging area and working directory to match the specified commit, discarding all local changes.

```bash
git reset --hard HEAD~1
```

###### 6.2.2 Reverting Commits in History

To avoid dropping commits, use the revert operation to create a new commit that reverts changes from previous commits. This method ensures all intermediate commits remain intact. The `--no-commit` option stages the changes of the indicated range of commits without committing them, allowing a single commit to revert multiple commits.

```bash
git revert --no-commit HEAD~3..HEAD
```

This command stages the reversion of the last three commits, and you need to commit the changes manually afterward.

###### 6.2.3 Recover a Lost Commit

To recover a lost commit in Git, use the reflog, which keeps track of how the HEAD pointer has moved. Git temporarily retains commits even after they've been removed from the history. By checking the reflog, you can find the commit's identifier and reset it to recover the lost commit from a revert operation.

```bash
git reflog
```

This command displays the history of HEAD movements, allowing you to identify and recover the lost commit by its identifier.

#### 6.3 Use Interactive Rebasing

###### 6.3.1 Amending/Editing a Commit

To correct small mistakes like typos or including irrelevant files in a recent commit, you don't need to make a new commit. Instead, you can modify or amend the commit by fixing the mistake in your working directory, staging the changes, and using the `--amend` option with the `git commit` command:

```bash
git commit --amend -m "corrected commit message"
```

If you don't provide a new message, it will keep the initial commit message.

To edit an earlier commit in the commit history, use interactive rebasing. This allows you to stop, make changes, and continue the rebase, effectively modifying the commit and replaying subsequent commits on top of it. Use the interactive mode of the `rebase` command by using the hash value of the parent commit:

```bash
git rebase -i <hash-commit>
```

This command opens a script listing all commit comments to be replayed from oldest to newest. You can change `pick` to `edit` for the commits you want to modify. After closing the script window, the rebase operation pauses at each commit marked for editing. Make the necessary changes, amend the commit, and continue the rebase:

```bash
git commit --amend -m "corrected commit message"
git rebase --continue
```

Remember, rebasing rewrites history and should only be done on commits that haven't been shared with others.

###### 6.3.2 Dropping Commits

Similar to the amend operation, you can use the interactive mode of the rebase operation in Git to drop specific commits from the history. To begin, use the interactive rebase command by using the hash value of the parent commit:

```bash
git rebase -i <hash-commit>
```

This command opens a script listing all commit comments to be replayed from oldest to newest. You can change `pick` to `drop` for the commits you want to remove. After closing the script window, the rebase operation will skip the specified commits, ensuring they are no longer present in the commit history.

Be aware that dropping certain commits may result in conflicts. These conflicts must be resolved, staged, and committed before continuing the rebase operation seamlessly:

```bash
git rebase --continue
```

This process rewrites history and should be performed with caution, especially on commits that have already been shared with others.

###### 6.3.3 Rewording Commit Messages

Similar to the amend operation, you can use the interactive rebase mode in Git to reword commit messages in the commit history. Start by using the interactive rebase command by using the hash value of the parent commit:

```bash
git rebase -i <hash-commit>
```

This command opens a script listing all commit comments to be replayed from oldest to newest. Change `pick` to `reword` for the commits you want to reword. After closing the script window, Git will open the text editor to allow you to enter the modified commit message.

This process rewrites history and should be performed with caution, especially on commits that have already been shared with others.

###### 6.3.4 Reordering Commits

Similar to the amend operation, you can use the interactive rebase mode in Git to reorder commits in the history. Start by using the interactive rebase command with the hash value of the parent commit:

```bash
git rebase -i <hash-commit>
```

This command opens a script listing all commit comments to be replayed from oldest to newest. Change the order of the commit lines, then close the script. Git will perform the rebase according to the new commit order. 

Be aware that changing the order of certain commits may result in conflicts, which must be resolved, staged, and committed before continuing the rebase operation seamlessly:

```bash
git rebase --continue
```

This process rewrites history and should be performed with caution, especially on commits that have already been shared with others.

###### 6.3.5 Combine Multiple Commits Together

Similar to the amend operation, you can use the interactive rebase mode in Git to combine commits in the history. Start by using the interactive rebase command with the hash value of the parent commit:

```bash
git rebase -i <hash-commit>
```

This command opens a script listing all commit comments to be replayed from oldest to newest. Change `pick` to `squash` for the commit you want to combine with the previous commit. After closing the script, the rebase operation will perform the squash, merging the selected commits into a single commit. 

Be aware that squash merging may result in conflicts, which must be resolved, staged, and committed before continuing the rebase operation seamlessly:

```bash
git rebase --continue
```

This process rewrites history and should be performed with caution, especially on commits that have already been shared with others.

###### 6.3.6 Splitting a Commit

Similar to the amend operation, you can use the interactive rebase mode in Git to split specific commits from the history. Start by using the interactive rebase command with the hash value of the parent commit:

```bash
git rebase -i <hash-commit>
```

This command opens a script listing all commit comments to be replayed from oldest to newest. Change `pick` to `edit` for the commits you want to split. After closing the script, the rebase operation pauses at each commit marked for editing. You can then split the content of a commit into two by performing the stages, staging, and committing in subsequent operations (without using the amend option). After correctly implementing the split, continue the rebase:

```bash
git rebase --continue
```

Rebasing rewrites history and should only be done on commits that haven't been shared with others.
