# <u>Bash (Unix Shell)</u>

## <u>1. Introduction</u>

#### 1.1 Unix and Linux

Unix and Linux are operating systems that belong to the Unix-like family. Unix, developed in the 1970s, is a portable, multitasking, and multi-user system known for its stability and scalability. It has variants like AT&T Unix, BSD, and commercial versions. Linux, created by Linus Torvalds in 1991, is a Unix-like OS developed independently. It gained popularity as an open-source operating system, freely available for modification and distribution. Linux has a wide range of distributions tailored for different purposes. While Unix can be proprietary and requires licensing, Linux is open-source and widely used in desktops, servers, embedded systems, and mobile devices. Unix is prevalent in commercial and enterprise environments. To retrieve various details about the Linux distribution you are currently using, you can run the command `cat /etc/os-release`, which displays the contents of the file `/etc/os-release`.

#### 1.2 Ubuntu

Ubuntu is a Linux distribution that is built upon the Linux kernel and is based on Debian. It serves as a user-friendly and accessible operating system for desktops, servers, and other devices. As an implementation of Linux, Ubuntu inherits its open-source nature, customizability, and community-driven development. It includes the Linux kernel and various software packages, utilities, and tools. Ubuntu prioritizes ease of use, stability, regular updates, and extensive software support. It falls under the category of Linux distributions within the broader Unix-like family, distinguishing it from Unix while sharing similar principles and design concepts.

#### 1.3 Linux Shell

In the context of Linux, a shell refers to a program that provides a command-line interface for interacting with the operating system. It acts as an intermediary between the user and the Linux kernel, allowing users to execute commands, run scripts, and manage various aspects of the system. The shell interprets the commands entered by the user and then executes them by invoking the corresponding system programs.

There are several different shells available in Linux. In this document we will focus on the Bourne Again Shell, that is referred as Bash. This is the default and most widely used shell on Linux systems. It is highly compatible with the original Bourne shell and provides a rich set of features.

To determine which shell you are currently using, you can use the `echo` command followed by the `$SHELL` environment variable. 

```bash
$ echo $SHELL
```

## <u>2. Commands</u>

#### 2.1 Basic syntax

Commands refer to the instructions or actions that you give to the command-line shell. The basic syntax of a command consists of the command itself followed by options and arguments.

The command is typically the name of the program or utility you want to run.

Options, also known as flags or switches, modify the behavior of the command. They are preceded by a hyphen (-) or double hyphen (--). Options can be used individually or combined.

Arguments are the inputs or parameters provided to the command. They can be filenames, directory paths, text strings, or any other data required by the command to perform its task. Arguments are typically separated by spaces.

```powershell
$ command-name [option(s)] [argument(s)]
```

#### 2.2 Keyboard shortcuts

Every modern shell has some built-in shortcuts to edit command lines efficiently.

1. `Tab` completion: Hit `Tab` and the system will try to complete file and
   directory names.

2. Arrow keys: Move in the history of previously used commands.

3. `[CTRL] + E`: Move to the end of the line.

4. `[CTRL] + A`: Move to the beginning of the line.

5. `[CTRL] + L`: Clear the screen.

6. `[CTRL] + C`: Terminate the command on the current line and return to the terminal on a new line.

#### 2.3 Aliases

###### 2.3.1 What is an alias?

In Bash, aliases are used to create custom shortcuts or alternate names for commands or command sequences. An alias is essentially a command or a set of commands assigned to a keyword. Aliases can save you time and typing effort by providing convenient shortcuts for frequently used commands or complex command sequences. However, it's important to use aliases judiciously, as they can sometimes cause confusion or conflicts with other commands or scripts.

###### 2.3.2 Create an alias

To create an alias, you can use the `alias` command followed by the alias name and the command or sequence of commands it represents.

```bash
$ alias ll='command'
```

###### 2.3.3 Display all the aliases

To display all the aliases defined in a Bash session, you can use the `alias` command without any arguments.

```bash
$ alias
```

#### 2.4 Operators

In bash scripting, operators are symbols or characters that perform specific operations on variables, values, or expressions. They allow you to manipulate data, make comparisons, perform arithmetic calculations, and control the flow of your script.

###### 2.4.1 Arithmetic operators

In Bash, arithmetic operators are used to perform mathematical calculations on numeric values. They allow you to manipulate numbers, perform calculations, and evaluate expressions in your scripts.

| Operators | Description                        | Example        |
| --------- | ---------------------------------- | -------------- |
| `+`       | Addition.                          | `expr 20 + 10` |
| `-`       | Subtraction.                       | `expr 20 - 10` |
| `*`       | Multiplication.                    | `expr 20 * 10` |
| `/`       | Division.                          | `expr 20 / 10` |
| `%`       | Calculate the remainder (modulus). | `expr 20 % 10` |

###### 2.4.2 Assignment operators

In Bash, assignment operator `=` are used to assign values to variables. in addition, Bash also provides compound assignment operators that combine an operation with assignment. These operators perform a specific operation on the variable and then assign the result back to the variable.

| Operator | Description                                                                  | Example      |
| -------- | ---------------------------------------------------------------------------- | ------------ |
| `=`      | Assigns a value to a variable.                                               | `var=value`  |
| `+=`     | Adds the right-hand side value to the current value of the variable.         | `var+=value` |
| `-=`     | Subtracts the right-hand side value from the current value of the variable.  | `var-=value` |
| `*=`     | Multiplies the right-hand side value with the current value of the variable. | `var*=value` |
| `/=`     | Divides the current value of the variable by the right-hand side value.      | `var/=value` |

###### 2.4.3 Numeric comparison operators

In Bash, numeric comparison operators are used to compare numeric values and evaluate conditions based on their relationships.

| Operator | Description                                                                         | Example             |
| -------- | ----------------------------------------------------------------------------------- | ------------------- |
| `-eq`    | Checks if two values are equal numerically.                                         | `value1 -eq value2` |
| `-ne`    | Checks if two values are not equal numerically.                                     | `value1 -ne value2` |
| `-gt`    | Checks if the value on the left is greater than the value on the right.             | `value1 -gt value2` |
| `-lt`    | Checks if the value on the left is less than the value on the right.                | `value1 -lt value2` |
| `-ge`    | Checks if the value on the left is greater than or equal to the value on the right. | `value1 -ge value2` |
| `le`     | Checks if the value on the left is less than or equal to the value on the right.    | `value1 -le value2` |

###### 2.4.3 String comparison operators

In Bash, sting comparison operators are used to compare strings and evaluate conditions based on their lexicographical order or equality.

| Operators | Description                                                     | Example                  |
| --------- | --------------------------------------------------------------- | ------------------------ |
| `==`      | Checks if two strings are equal.                                | `'string1' == 'string2'` |
| `!=`      | Checks if two strings are not equal.                            | `'string1' != 'string2'` |
| `>`       | Checks if one string is lexicographically greater than another. | `'string1' > 'string2'`  |
| `<`       | Checks if one string is lexicographically less than another.    | `'string1' < 'string2'`  |

###### 2.4.4 Logical operators

In Bash, logical operators are used to combine and manipulate logical expressions. They allow you to create complex conditions by combining multiple conditions and determine the overall truth value of the expression.

| Operator | Description                                                                                              | Example                                                                                                              |
| -------- | -------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------- |
| `&&`     | The logical AND operator returns true if both conditions on the left and right of the operator are true. | `[ condition1 ] && [ condition2 ]`                                                                                   |
| `\|      | `                                                                                                        | The logical OR operator returns true if at least one of the conditions on the left or right of the operator is true. |
| `!`      | The logical NOT operator reverses the truth value of a condition.                                        | `! [ condition ]`                                                                                                    |

###### 2.4.5 File operators

in Bash, file operators are used to perform operations and checks on files and directories. These operators are commonly used in conditional statements to make decisions based on the state or properties of files.

| Operators | Description                                                                                      | Example   |
| --------- | ------------------------------------------------------------------------------------------------ | --------- |
| `-e`      | Checks if the file exists, regardless of its type (regular file, directory, symbolic link, ...). | `-e file` |
| `-f`      | Checks if the file exists and is a regular file.                                                 | `-f file` |
| `-d`      | Checks if the file exists and is a directory.                                                    | `-d file` |
| `-L`      | Checks if the file exists and is a symbolic link.                                                | `-L file` |
| `-s`      | Checks if the file exists and has a non-zero size.                                               | `-s file` |
| `-r`      | Checks if the file exists and is readable.                                                       | `-r file` |
| `-w`      | Checks if the file exists and is writable.                                                       | `-w file` |
| `-x`      | Checks if the file exists and is executable.                                                     | `-x file` |

#### 2.5 Basic mathematics

###### 2.5.1 Evaluate expressions

In Bash, arithmetic operations can be performed using the `expr` command, which allows you to evaluate and manipulate arithmetic expressions. The `expr` command takes the form described here below, where`OPERAND` can be a numeric value, a variable, and arithmetic operator.

```bash
$ expr OPERAND OPERAND OPERAND
```

Note that in the `expr` command, `*` is interpreted as a meta character, therefore it must be preceded by the escape character `\*`.

###### 2.5.2 Arithmetic expansion

In Bash, arithmetic expansions are a feature that allows you to perform arithmetic operations within double parentheses or by using the `$((...))` syntax.

```bash
$ echo $((expression))
```

#### 2.6 Special characters

###### 2.6.1 Escape character

The escape character in Bash is a powerful tool for handling special characters within strings or commands. It allows you to include characters that would otherwise have a special meaning and ensures they are treated as literal characters. In Bash, the escape character is the backslash (`\`). When the backslash is placed before a character, it signals that the character should be escaped or treated specially. 

To illustrate the use of the escape character, we can show how the escape character is used to handle quotes within strings:

1. Single Quote within Single Quotes: When using single quotes to enclose a string, the escape character does not have any effect.
   
   ```bash
   $ echo 'I\'m a programmer'
   ```

2. Double Quote within Double Quotes: When using double quotes to enclose a string, the escape character allows for the inclusion of a literal double quote within the string.
   
   ```bash
   echo "She said, \"Hello!\""
   ```

#### 2.6 Pattern matching

###### 2.6.1 Wildcard characters

Wildcard characters are special characters used in Bash for pattern matching and filename expansion. They allow you to specify a set of filenames or paths that match a particular pattern. The most commonly used wildcard characters in Bash are:

1. Asterisk (`*`): The asterisk represents any sequence of characters (including an empty sequence).

2. Question Mark (`?`): The question mark matches any single character.

3. Square Brackets (`[]`): Square brackets define a character class and match any single character within that class.

4. Negation (`!` or `^`): Placing a negation symbol immediately after the opening square bracket negates the character class.

These wildcard characters are used with commands like `ls`, `cp`, `rm`, and others to specify filenames or paths that match a particular pattern. The shell expands the wildcard pattern before executing the command, replacing it with the matching filenames.

###### 2.6.2 Regular expressions

Regular expressions, often referred to as regex, are powerful tools used for pattern matching and manipulating text. They provide a concise and flexible way to describe complex patterns of characters. Here are some relevant concepts and common uses of regular expressions in Bash:

1. Metacharacters: Regular expressions utilize metacharacters to represent patterns. Some of the most commonly used metacharacters include:
   
   - `.` (dot): Matches any single character.
   - `*`: Matches zero or more occurrences of the preceding character or group.
   - `+`: Matches one or more occurrences of the preceding character or group.
   - `?`: Matches zero or one occurrence of the preceding character or group.
   - `[]`: Defines a character class and matches any character within it.
   - `()` (parentheses): Groups patterns together.

2. Anchors: Anchors are used to specify the position of a pattern within the text. The most common anchors include:
   
   - `^`: Matches the start of a line or string.
   - `$`: Matches the end of a line or string.

3. Quantifiers: Quantifiers specify the number of occurrences of a pattern. Some common quantifiers are:
   
   - `{n}`: Matches exactly `n` occurrences of the preceding character or group.
   - `{n,}`: Matches `n` or more occurrences of the preceding character or group.
   - `{n,m}`: Matches between `n` and `m` occurrences of the preceding character or group.

4. Character Classes: Character classes are used to define a set of characters that can match a single position in the pattern. Common character classes include:
   
   - `\d`: Matches a digit character (0-9).
   - `\w`: Matches a word character (alphanumeric and underscore).
   - `\s`: Matches a whitespace character.

In Bash, regular expressions are used in various commands and utilities, such as `grep`, `sed`, and `awk`, to search for and manipulate text based on specific patterns.

#### 2.6 History

###### 2.6.1 What is the command history?

The command history in Bash is a feature that keeps track of the commands you have executed in your current shell session. It allows you to easily recall and reuse previously entered commands without having to retype them.

The `history` command is used to display a list of your previous commands along with their line numbers. 

```bash
$ history
```

###### 2.6.2 Executing commands from the history

To execute a specific command from history, type `!n`, where `n` is the line number of the command in the history list.

```bash
$ !n  
```

#### 2.7 Assistance

There are several tools integrated into the system itself that can provide assistance regarding the usage of certain commands.

###### 2.7.1 Command built-in help

Most of the Unix commands have some sort of built-in help.

```bash
$ command-name --help
```

###### 2.7.2 Man pages

Unix documentation is available through the man pages.

```bash
$ man command-name
```

###### 2.7.3 Info pages

The info pages are usually far more complete, with extended parts like tutorials.

```bash
$ info command-name
```

#### 2.8 Package manager

###### 2.8.1 What is a package manager?

A package manager is a software tool that automates the process of installing, updating, configuring, and removing software packages on a computer system. It simplifies the management of software dependencies and ensures smooth installation and maintenance of applications. The `apt` package manager is commonly used in Bash and Ubuntu, providing a command-line interface for easy management of software packages in Debian-based systems. By regularly updating and upgrading packages with `apt`, you can ensure that your system stays up to date with the latest security patches, bug fixes, and new features.

###### 2.8.2 Update the package lists and upgrade installed packages

To update the package lists and fetch the latest information about available packages from the software repositories using `apt`, you can execute the following command:

```bash
$ sudo apt update
```

To upgrade the installed packages and upgrade the installed packages to their latest available versions using apt, you can execute the following command:

```bash
$ sudo apt upgrade
```

It's important to note that the `apt` commands mentioned above usually require administrative (superuser) privileges. Therefore, the `sudo` command is used to run them with elevated privileges.

## <u>3. File system and utilities</u>

#### 3.1 File system

A file system is a method of organizing and storing files on storage devices like hard drives and SSDs. It manages file organization, retrieval, and access control by defining rules for file naming, directory structure, metadata management, and data storage. In the context of the Bash command-line shell used in Unix-like systems, the default and frequently used file system is typically ext4. Ext4 is a mature file system with features like support for large files and partitions, journaling for reliability, and efficient performance. However, the choice of file system in Bash depends on the underlying operating system, and other file systems like ext3, btrfs, and XFS are also commonly used depending on the specific operating system and configuration.

#### 3.2 Path

In Bash, a path refers to the location or address of a file or directory within the file system. It specifies the unique location of an item in the directory hierarchy.

###### 3.2.1 Absolute path

An absolute path provides the complete and precise location of a file or directory from the root directory. It describes the entire path hierarchy, starting from the root directory (`/`) and traversing through all the intermediate directories to reach the target item. 

Absolute paths are not dependent on the current working directory and provide an unambiguous reference to the item's location. For example: `/home/user/file.txt` is an absolute path that points to the file "file.txt" located in the "user" directory, which is inside the "home" directory at the root level.

###### 3.2.2 Relative path

A relative path specifies the location of a file or directory relative to the current working directory. Instead of starting from the root directory, a relative path starts from the current directory and indicates the necessary steps to navigate to the target item. You can refer to the current folder with a single dot notation (`.`) or to the parent folder with a double dot notation  (`..`).

Relative paths depend on the current working directory and are shorter and more concise than absolute paths.  For example:

- If the current working directory is `/home/user/`, a relative path like `file.txt` refers to a file named "file.txt" in the current directory.

- If the current working directory is `/home/user/`, a relative path like `../other/file.txt` indicates a file "file.txt" in the "other" directory, which is located in the parent directory of the current working directory.

#### 3.2 System navigation

###### 3.1 Display the working directory

The `pwd` command displays the present working directory, which is the directory you are currently in.

```bash
$ pwd
```

###### 3.2 Change the working directory

The `cd` command is used to change the current working directory. It allows you to move to a different directory within the file system.

```bash
$ cd new/working/directory/
```

The `~` argument denotes the home directory and it can be used as a shortcut.

###### 3.3 List the content of the working directory

The `ls` command lists the files and directories in the current directory. By default, it displays the names of files and directories in a simple format. Adding options such as `-l` (long format) , `-a` (including hidden files), or `-h` (human readable format for file sizes) can provide more detailed information.

```pwd
$ ls
```

#### 3.3 File utilities

###### 3.3.1 Create files and directories

To create a new file, you can use the `touch` command followed by the desired filename.

```bash
$ touch myfile.txt
```

To create a new directory, you can use the `mkdir` command followed by the desired directory name.

```powershell
$ mkdir myfolder
```

###### 3.3.2 Copy files and directories

To copy a file, you can use the `cp` command followed by the source file and the destination.

```bash
$ cp file.txt newfile.txt
```

To copy a directory and its contents, you can use the `cp` command with the `-r` option for recursive copying. 

```bash
$ cp -r directory newdirectory
```

###### 3.3.3 Move and rename files and directories

To move or rename a file or directory, you can use the `mv` command followed by the source and destination. 

```bash
$ mv file.txt newlocation/new_file_name.txt
```

###### 3.3.4 Remove files and directories

To remove a file, you can use the `rm` command followed by the filename. 

```bash
$ rm file.txt
```

To remove an empty directory, you can use the `rmdir` command followed by the directory name. 

```bash
$ rmdir directory
```

If you want to remove a directory and its contents recursively, you can use the `rm` command with the `-r` option.

```bash
$ rm -r directory
```

###### 3.3.5 File types and attributes

In Bash, file types determine the nature of a file, such as whether it is a regular file, directory, symbolic link, device file, or special file. The `file` command is used to determine the type of a file. By providing the path to a file as an argument (e.g., `file myfile.txt`), it identifies the file type based on its content and provides a description. 

```bash
$ file file.txt
```

In bash, file attributes provide additional information about files, such as permissions, ownership, size, creation/modification timestamps, and more. The `stat` command is used to display detailed information about a file or directory. By specifying the file or directory path, it provides various attributes such as size, permissions, timestamps, and more.

```bash
$ stat file.txt
```

###### 3.3.6 Symbolic links

In Bash, a symbolic link contains the path or location of another file or directory. When you access a symbolic link, it redirects you to the target file or directory it points to. Symbolic links can be used to create shortcuts or aliases to access files or directories without having to navigate through the entire file system.

To create a symbolic link, you can use the `ln` command with the `-s` option, followed by the source file or directory and the desired name of the symbolic link. 

```bash
$ ln -s /path/to/source/file linkname
```

To remove a symbolic link, you can use the `rm` command followed by the name of the symbolic link. 

```bash
$ rm linkname
```

It's important to note that symbolic links can become broken or "dangling" if the target file or directory is moved or deleted. In such cases, accessing the symbolic link may result in an error.

###### 3.3.7 Compressing files

File compression is the process of reducing the size of a file or a collection of files. It is done by using algorithms that eliminate redundant or repetitive data in order to store the information more efficiently. The main purpose of compression is to save storage space by reducing the file size.

The `gzip` command in Bash is used to compress files using the gzip compression algorithm. It offers various options to control the compression level and behavior. The `.gz` extension suggests that the file is compressed with gzip.

The command can be configured to create a compressed version of the file while retaining the original file. The `--fast` option prioritizes speed, while the `--best` option focuses on achieving the highest compression ratio. The `-k` option ensures that the original file is preserved, and the `-v` option provides progress and details during the compression process.

```bash
$ gzip -kv --fast example.txt
$ gzip -kv --best example.txt
```

The command can be configured to restore the original file from the compressed version while retaining the compressed file. The `--fast` option prioritizes speed, while the `--best` option focuses on achieving the highest decompression efficiency. The `-d` option indicates decompression, the `-k` option preserves the original compressed file, and the `-v` option provides progress and details during the decompression process.

```bash
$ gzip -dkv --fast example.txt
$ gzip -dkv --best example.txt
```

###### 3.3.8 Archiving files and directories

Archiving is the process of combining multiple files and directories into a single file, known as an archive. The purpose of archiving is to simplify the management, storage, and transfer of multiple files and directories as a cohesive unit. Archives are commonly used for backup purposes, software distribution, and transferring collections of files.

In Bash, he `tar` command allows you to create an archive file that contains the specified files and directories and allow their compression with `gzip`. The `.gz.tar` extension suggests that the archive is compressed with both gzip and tar.

The command can be configured to create a compressed archive for a range of files while preserving the original files and directories. The `-c` option creates a new archive, the `-z` option compresses the archive using gzip, the `-v` option displays the progress and details, and the `-f` option specifies the name of the archive file.

```bash
$ tar -czvf archive_name.gz.tar file(s)
```

The command can be configured to extract files from a compressed archive for a range of files while preserving the archive. The `-x` option extract the files, the `-z` option decompresses the archive using gzip, the `-v` option displays the progress and details, and the `-f` option specifies the name of the archive file to be extracted.

```bash
$ tar -xzvf archive_name.gz.tar file(s)
```

###### 3.3.9 Locating files

The `find` command in Linux is used to search for files and directories in a specified directory hierarchy based on various criteria. It allows you to locate files by name, size, type, modification time, ownership, and more. The `path` represents the directories in which you want to search, and `expression` specifies the search criteria.

```shell
$ find path expression
```

| Options               | Description                                                                                                                                                                                                                                                               | Examples               |
| --------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------- |
| `-name pattern`       | Searches for files and directories with a specific name or pattern.                                                                                                                                                                                                       | `find . -name "*.txt"` |
| `-type type`          | Searches for files of a specific type, for example, looks for `f` for files and `d` for directories.                                                                                                                                                                      | `find . -type f`       |
| `-size [+\|-]size`    | Searches for files based on their size, where you can specify the size in bytes, kilobytes (K), megabytes (M), gigabytes (G), and so on.                                                                                                                                  | `find . -size +1M`     |
| `-mtime [+\|-]days`   | Searches for files based on their modification time, where you can specify the number of days using `+` for older files or `-` for newer files.                                                                                                                           | `find . -mtime +7`     |
| `-user owner`         | Searches for files owned by a specific user.                                                                                                                                                                                                                              | `find . -user Eli`     |
| `-exec command {} \;` | Perform an `command` on the files or directories found during the search, recurring examples being `rm` or `chmod`. The `{}` represents a placeholder that is replaced by the path of any matching file or directory. The `+` represent the terminator of each iteration. | `find . -exec rm {} +` |

###### 3.3.10 Locating executables

The `which` command in Linux is used to locate the executable file associated with a given command or program. It helps you determine the absolute path of the command that will be executed when you run it in the shell.

```bash
$ which command-name
```

#### 3.5 File permissions

###### 3.5.1 What are file permissions?

In Bash, file permissions are a set of access rights that define what actions can be performed on a file or directory. They determine who can read, write, or execute the file and in what capacity. File permissions are primarily used to control access to files and protect them from unauthorized modifications.

###### 3.5.2 Understanding the permission string

The permission string in the long listing output of the `ls -l` command consists of ten characters, divided into several sections. Each section represents a different aspect of the permissions for a file or directory.

1. File type indicator: The first character in the permission string represents the type of the item. It can be one of the following:
   
   - `-` : Represents a regular file.
   - `d`: Represents a directory.
   - `l`: Represents a symbolic link.

2. Owner permissions: The next three characters represent the permissions for the owner of the file. Each character can be one of the following:
   
   - `r` (read): Indicates the owner has read permission.
   - `w` (write): Indicates the owner has write permission.
   - `x` (execute): Indicates the owner has execute permission.
   - `-` (hyphen): Indicates no permission for the owner.

3. Group permissions: The following three characters represent the permissions for the group that the file belongs to. The meanings of the characters are the same as for owner permissions.

4. Other permissions: The last three characters represent the permissions for users who are neither the owner nor part of the group. The meanings of the characters are the same as for owner permissions.

###### 3.5.3 Differences between files and directories

Interpreting file permissions:

- Read permission (`r`): When a file has read permission for the owner (`r`), it means that the owner can view the contents of the file.

- Write permission (`w`): Write permission for the owner (`w`) allows the owner to modify the contents of the file.

- Execute permission (`x`): Execute permission for the owner (`x`) is applicable to executable files (e.g., scripts or binary executables).

Interpreting directory permissions:

- Read permission (`r`): Read permission for the owner on a directory allows them to list the files and subdirectories within that directory.

- Write permission (`w`): Write permission for the owner on a directory grants the ability to add, remove, or rename files and subdirectories within that directory.

- Execute permission (`x`): Execute permission for the owner on a directory enables the owner to access the directory, traverse its contents, and perform operations within it. Without execute permission, the owner cannot access the contents of the directory or perform any operations within it, even if they have read or write permission on specific files within the directory.

###### 3.5.4 Changing permissions

The `chmod` command in Bash is used to change the file permissions of a file or directory. It allows you to grant or revoke read (`r`), write (`w`), and execute (`x`) permissions for the owner, group, and other users. The basic syntax of the `chmod` command is as follows:

```bash
$ chmod options permissions file(s)
```

The `-R` option stands for recursive mode, that means that it applies the permission changes recursively to all files and directories within a directory, including the directory itself.

The permissions can be specified using one of the two different modes:

1. Symbolic mode: This involves using letters to represent the permissions and operators to modify them. The letters used are: `u` (user/owner), `g` (group), `o` (others), and `a` (all: owner, group, and others). The operators used are: `+` (add the permission), `-` (remove the permission), and `=` (set the permission exactly as specified). 
   
   - For example, `chmod u=rw,g+x,o-w file.txt` sets read and write permissions for the owner, adds execute permission for the group, and removes write permission for others on `file.txt`.

2. Numeric mode: Each permission has a corresponding numeric value: `r` (read) is represented by 4, `w` (write) is represented by 2, `x` (execute) is represented by 1, `-` (no permission) is represented by 0. To set permissions, you add the numeric values together.
   
   - For example, `chmod 755 file.txt` sets read, write, and execute permissions for the owner (7 = 4+2+1), and read and execute permissions for the group and others (5 = 4+1) on `file.txt`.

###### 3.5.5 Changing ownership and group

In Bash, ownership and group are closely intertwined concepts that relate to the user and group associations assigned to files and directories. These concepts are crucial for determining permissions and access rights for these items.

When using the `ls -l` command, you can view ownership and group information. The username of the owner is displayed in the third column, while the group name is shown in the fourth column of the output. This allows you to identify the current owner and group of the files and directories.

To change the ownership or group of a file or directory, you can utilize the `chown` command. The syntax `[new_owner]:[new_group]` is used to specify the desired new owner and group for the file(s) in question. By using this command, you can modify the ownership and group association of the specified files.

```bash
$ chown [options] [new_owner]:[new_group] file(s)
```

In the above command, `[options]` represents any additional settings or parameters you may want to use with the `chown` command. This can include the `-R` option, which stands for recursive mode. When applied, this option ensures that the ownership changes are propagated recursively to all files and directories within a directory, including the directory itself.

It is important to note that changing the ownership of files that you do not own requires root or `sudo` privileges. This ensures that only authorized users can modify ownership and maintain security and integrity.

## <u>4. Text and data stream processing</u>

#### 4.1 Display file content

###### 4.1.1 Static display

The `cat` command is used to concatenate and display the contents of one or more files.

```shell
$ cat file.txt
```

The `head` command displays the first few lines of a file. By default, it displays the first 10 lines, but you can specify a different number using the `-n` option.

```shell
$ head -n 5 file.txt
```

The `tail` command displays the last few lines of a file. By default, it displays the last 10 lines, but you can specify a different number using the `-n` option.

```shell
$ tail -n 5 file.txt
```

###### 4.1.2 Interactive display

The `less` command is a pager that allows you to view the contents of a file interactively. It enables scrolling, searching, and navigating through the file.

```shell
$ less file.txt
```

The `more` command is a pager that allows you to view the contents of a file. It displays one screenful of text at a time and requires pressing the Enter key to view additional content.

```shell
$ more file.txt
```

#### 4.2 Text manipulation

###### 4.2.1 Sorting lines

The `sort` command is used to sort lines of text alphabetically or numerically. It takes input from a file or standard input and outputs the sorted lines.

```shell
$ sort [options] file.txt
```

| Options   | Description                                                                                                                                                                                      |
| --------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| `-r`      | This option sorts the lines in reverse order, from highest to lowest or in reverse alphabetical order.                                                                                           |
| `-n`      | This option performs a numeric sort instead of the default lexicographic sort.                                                                                                                   |
| `-k`      | This option allows you to specify a key or field on which to sort. For example, `-k 2` sorts based on the second field, and `-k 2,3` sorts based on fields 2 and 3 combined.                     |
| `-t char` | This option lets you specify a field separator for sorting. By default, the separator is whitespace, but you can use a desired separator character(s) (e.g., `-t ,` for comma-separated values). |
| `-u`      | This option removes duplicate lines from the input before sorting.                                                                                                                               |
| `-f`      | This option performs a case-insensitive sort.                                                                                                                                                    |

###### 4.2.2 Removing duplicate lines

The `uniq` command filters adjacent duplicate lines from input. It takes sorted input as its source and removes consecutive duplicate lines, only showing unique lines. So it is best to work with a sorted file to ensure that duplicate lines are below each other so that `uniq` can operate on them.

```shell
$ uniq [options] file.txt
```

| Options | Description                                                                             |
| ------- | --------------------------------------------------------------------------------------- |
| `-d`    | This option displays only the duplicate lines in the output, omitting unique lines.     |
| `-c`    | This option prefixes each line with the number of occurrences of that line in the input |

###### 4.2.3 Joining lines

The `join` command combines two files on a specified field. It compares two files based on a common field and outputs the lines where the field values match.

```shell
$ join [options] file1.txt file2.txt
```

| Options          | Descriptions                                                                                                                                                                                     |
| ---------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| `-1 field`       | This option specifies the field in `file1.txt` to be used for the join operation. The field can be specified by its position (field number) or by its column name if the file has a header.      |
| `-2 field`       | This option specifies the field in `file2.txt` to be used for the join operation. The field can be specified by its position (field number) or by its column name if the file has a header.      |
| `-t char`        | This option lets you specify a field separator for sorting. By default, the separator is whitespace, but you can use a desired separator character(s) (e.g., `-t ,` for comma-separated values). |
| `-a file_number` | This option specifies that all lines from a particular file should be included in the output, even if there is no match in the other file.                                                       |
| `-e string`      | This option replaces missing fields with the specified string in the output.                                                                                                                     |

###### 4.2.4 Selecting columns

The `cut` command extracts specific columns or fields from lines of input. It allows you to specify a delimiter and select columns or character ranges to extract.

```shell
$ cut [options] file.txt
```

| Options         | Description                                                                                                                                                                                                 |
| --------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `-f field_list` | This option specifies the fields or columns to be selected. For example, `-f 2` selects the second field, and `-f 1-3` selects fields 1 to 3.                                                               |
| `-d delimiter`  | This option allows you to specify the field delimiter character. By default, the delimiter is a tab character, but you can use the desired delimiter character (e.g., `-d ','` for comma-separated values). |
| `-s`            | This option suppresses lines that do not contain the delimiter character.                                                                                                                                   |

###### 4.2.5 Selecting lines

The `grep` command is used to search for specific patterns or lines that match a given pattern. It can be used to filter lines based on <u>regular expression</u> and display only the matching lines.

```shell
$ grep [options] pattern file.txt
```

| Options | Description                                                                       |
| ------- | --------------------------------------------------------------------------------- |
| `-i`    | This option performs a case-insensitive search.                                   |
| `-v`    | This option inverts the match, displaying lines that do not match the pattern.    |
| `-n`    | This option displays line numbers along with the matching lines.                  |
| `-w`    | This option matches the pattern only as a whole word, ignoring partial matches.   |
| `-c`    | This option displays the count of matching lines instead of the lines themselves. |

###### 4.2.6 Editing lines

The `tr` command is used to edit lines by performing character-level transformations on the input. The `tr` command takes input from a file or standard input and performs character-level replacements or deletions based on the specified sets of characters (`set1` and `set2`). To edit lines using the `tr` command, you typically focus on replacing or deleting specific characters within each line.

```shell
$ tr [options] set1 set2 < input.txt > output.txt
```

| Options | Description                                                                                                                               |
| ------- | ----------------------------------------------------------------------------------------------------------------------------------------- |
| `-d`    | This option deletes characters in `set1` from the input.                                                                                  |
| `-s`    | This option squeezes consecutive occurrences of the characters in `set1` to a single occurrence in the output.                            |
| `-c`    | This option complements the set of characters in `set1`. It replaces all characters except those in `set1` with the characters in `set2`. |
| `-t`    | This option truncates `set1` to the length of `set2`.                                                                                     |
| `-u`    | This option converts characters in `set1` to uppercase in the output.                                                                     |
| `-l`    | This option converts characters in `set1` to lowercase in the output.                                                                     |

###### 4.2.7 Counting lines

The `wc -l` command is used to count the number of lines in a file or the output from a command.

```bash
$ wc -l file.txt
```

#### 4.3 Filtering lines with awk

###### 4.3.1 Basic syntax of awk

The `awk` command is a versatile text processing tool that operates on data line by line. It allows you to apply commands or patterns to manipulate and extract information from the input data. 

The basic syntax of the `awk` command is as follows:

```shell
$ awk 'pattern { action }' file
```

###### 4.3.2 The seperator

In `awk`, the separator, specified using the `-F` option, defines the field separator character(s) used to split the input lines into individual fields. By default, `awk` considers whitespace (spaces and tabs) as the field separator. However, you can use the `-F` option to specify a different character or a regular expression pattern as the field separator.

In the provided example, the `-F ','` option sets the field separator to a comma.

```bash
$ awk -F ',' '{ print $0 }' file.txt
```

###### 4.3.3 The pattern

The `pattern` part in an `awk` command is an optional condition or pattern used to filter and select specific lines from the input data. It can be a regular expression, string comparison, numerical comparison, or a combination of these. When a line matches the pattern, the associated action(s) enclosed in curly braces `{ }` are executed. This feature provides a flexible and powerful approach to process and analyze text data based on desired patterns or conditions.

To provide an example, the pattern `/apples/` selects lines containing the word "apples", and the action `print $1` prints the first field of each matching line.

```bash
$ awk -F ',' '/apples/ { print $1 }' fruits.csv
```

###### 4.3.4 Field variables

The `awk` command provides several built-in variables for manipulating individual fields and their attributes. These field variables allow you to access and manipulate specific fields within the input data, perform calculations, comparisons, and various operations based on field values. These variables include:

- `$0`: Represents the entire record (the entire line).
- `$1`, `$2`, etc.: Represent the individual fields in the record, with `$1` referring to the first field, `$2` referring to the second field, and so on.
- `NR`: Stores the current record number being processed.
- `NF`: Holds the number of fields in the current record.
- `$NF`: Contains the value of the last field in the record.

###### 4.3.5 Actions

In an `awk` command, the action part refers to the set of instructions enclosed in curly braces `{ }`. It specifies the actions or operations that should be performed on the lines of input that match the specified pattern.

| Actions                            | Description                                                                                              | Example                                         |
| ---------------------------------- | -------------------------------------------------------------------------------------------------------- | ----------------------------------------------- |
| `print`                            | The `print` statement is used to display output. It can print individual fields or entire lines.         | `awk '{print $1} file'`                         |
| `gsub()`                           | The `gsub()` function is used to substitute a pattern with a replacement string in a given input string. | `awk '{gsub(“old”, “new”, $0); print $0} file'` |
| `if`                               | The `if` statement allows you to perform conditional operations.                                         | `awk '{ if ($1 > 10) print $0 }' file`          |
| Mathematical and string operations | Allows to perform calculations, comparisons, concatenation, and more.                                    | `awk '{sum = $1 + $2; print sum}' file`         |

#### 4.4 Data streams

###### 4.4.1 What are data streams

In Bash, data streams refer to the flow of data between programs, files, and the terminal. There are three standard data streams in Bash:

1. Standard Output (`stdout`, `1`): It is the output stream where a command or program sends its regular output. By default, stdout is connected to the terminal, and the output is displayed on the screen.

2. Standard Error (`stderr`, `2`): It is the output stream where a command or program sends its error or diagnostic messages. By default, stderr is also connected to the terminal, and the error messages are displayed on the screen.

3. Standard Input (`stdin`): It is the input stream from which a command or program reads data. By default, stdin is connected to the terminal, allowing the user to provide input.

###### 4.4.2 Stream redirection

Data stream redirection in Bash allows you to change the default flow of data between programs, files, and the terminal. It enables you to redirect the output of one command to another command or save it to a file.

There are several common data stream redirection operators in Bash:

| Operators | Description                                                                                      | Example                 |
| --------- | ------------------------------------------------------------------------------------------------ | ----------------------- |
| `>`       | Redirects stdout to a file, overwriting the file if it already exists.                           | `command > file.txt`    |
| `>>`      | Redirects stdout to a file, appending the output to the end of the file if it exists.            | `command >> file.txt`   |
| `<`       | Redirects stdin to read from a file instead of the terminal.                                     | `command < file.txt`    |
| `2>`      | Redirects stderr to a file, overwriting the file if it already exists.                           | `command 2> error.txt`  |
| `2>>`     | Redirects stderr to a file, appending the error messages to the end of the file.                 | `command 2>> error.txt` |
| `&>`      | Redirects stdout and stderr to a file, overwriting the file if it already exists.                | `command &> file.txt`   |
| `&>>`     | Redirects stdout and stderr to a file, appending the output to the end of the file if it exists. | `command &>> file.txt`  |

The stdout and stderr streams can also be redirected to two different locations as follows:

```bash
$ command > stdout_file.txt 2> stderr_file.txt
```

###### 4.4.3 Piping

Piping refers to the process of connecting the standard output (stdout) of one command to the standard input (stdin) of another command. It allows you to chain multiple commands together, where the output of one command becomes the input for the next command, forming a pipeline of data processing. The pipe operator `|` is used to create a pipe and establish the connection between commands.

```bash
$ command1 | command2
```

Piping is useful for performing complex data manipulations and processing operations. It allows you to break down a task into smaller, more manageable steps, with each command in the pipeline performing a specific operation on the data before passing it along to the next command.

###### 4.4.4 Black hole

The `/dev/null` file is essentially a black hole for data. Anything written to it is discarded, and reading from it returns nothing. It provides a convenient way to suppress or discard output in Bash, ensuring a cleaner and more controlled execution environment.

If you have a command or program that generates output that you don't need or want to see, you can redirect it to `/dev/null`.

```bash
$ command > /dev/null
```

If you want to run a command silently without displaying any output, you can redirect both stdout and stderr to `/dev/null`.

```bash
$ command &> /dev/null
```

#### 4.5 Text editor

###### 4.5.1 Introduction to nano text editor

Nano is a user-friendly, command-line text editor available on Linux systems. It is designed to be simple and easy to use, making it a popular choice for beginners or users who prefer a straightforward editing experience.

###### 4.5.2 Launch nano text editor

To launch the Nano text editor, you you'll need to open a terminal window. In the terminal just type `nano`, or you can add the name of the file if you want to edit a file whether it is in the current directory or in a different directory. If this file does not exist, nano automatically generates it with the name that is provided in the current folder. From then on, you can start using nano and start writing and editing text.

```bash
$ nano myfile.txt
```

###### 4.5.3 Saving and exiting

Nano will open with the specified file displayed. You can use the keyboard to navigate, make changes, and perform various actions. The bottom of the screen will show available commands and shortcuts. You can use the arrow keys to move the cursor, type to add or edit text, and press `Ctrl + O`to save the changes. The text editor will ask you if you want to change the file name, and by default will save the file in your current working directory. To exit Nano, you can press `Ctrl + X`.

###### 4.5.4 Searching text

To search for text in the Nano text editor, you can press `Ctrl + W` to initiate a search, enter the desired text you want to search for, and press `Enter` to perform the search. Nano will then highlight the first occurrence of the search term. To find subsequent occurrences, simply press `Ctrl + W` again.

###### 4.5.5 Cut and paste text

To cut text in the Nano text editor, you can move the cursor to the beginning of the text you wish to cut and use the `Shift` key to move along the lines and words that you want to select. Then, press `Ctrl + K` to cut either the current line if any text was selected or cut the part of text that you selected. This is also used as a method to cut and delete text.

If you have cut text with `Ctrl + K`, you can also paste it. Therefore, the position the cursor is moved at the desired location where you want to paste the cut text. Finally, press `Ctrl + U` to paste the cut text at the cursor's position. If you just want to copy the text instead of cut and paste, you can cut the text first with `Ctrl + K` and then paste it again in the same place with `Ctrl + U`. The text remains stored in the buffer after the cut operation, allowing you to paste it multiple times using `Ctrl + U` at different locations.

###### 4.5.6 Go to a specific line number

To go to a specific line number in the Nano text editor, you can press `Ctrl + W` to open the search box. Next, press `Ctrl + T`, which prompts you to enter a line number. Type in the desired line number you want to navigate to. Once you've entered the line number, press Enter to execute the command, and the cursor will be positioned at the specified line.

## <u>5. Processes</u>

#### 5.1 Managing processes

In Linux, a process refers to an executing program or a running instance of a program. It is a fundamental concept in the operating system that represents an independent unit of execution. Each process has its own memory space and resources allocated to it, such as CPU time, open files, network connections, and more.

###### 5.1.1 Display all the processes

The `ps` command provides information about currently running processes. By default, it displays a snapshot of active processes in a tabular format. Commonly used options include `-e` (all processes), `-f` (full format), and `-aux` (detailed information for all processes).

```bash
$ ps options
```

The `htop` command provides an e process viewer with a more user-friendly interface. It presents a hierarchical view of processes, color-coded resource usage, and allows for sorting, searching, and process management.

```bash
$ htop
```

###### 5.1.2 Kill processes

The `kill` command is used to terminate a process by sending a signal to it, which gracefully requests a process to terminate.

```bash
$ kill process_ID
```

The `killall` command is similar to `kill`, but it terminates processes by name rather than by process ID. It sends a signal to all processes with a specific name. 

```bash
$ killall process_name
```

## <u>6. Jobs</u>

#### 6.1 Job control

In Linux, a job refers to a task or command that is executed in the shell. Job control is a feature that allows you to manage and manipulate these jobs within the shell environment. It provides capabilities such as running jobs in the background, bringing them to the foreground, suspending and resuming jobs, and managing their execution.

###### 6.1.1 Display the jobs

The `jobs` command displays a list of currently running or stopped jobs. It provides information such as job numbers, their status (running or stopped), and the corresponding commands.

```bash
$ jobs
```

###### 6.1.2 Sending jobs to the background

The `bg` command is used to move a suspended or stopped job with number `n` to the background, allowing it to continue running.

```bash
$ bg %n
```

###### 6.1.3 Bringing jobs to the foreground

The `fg` command is used to bring a background job with number `n` to the foreground, allowing you to interact with it directly. 

```bash
$ fg %n
```

###### 6.1.4 Job control with keyboard shortcuts

Pressing `Ctrl+Z` suspends the currently running foreground job and returns you to the shell prompt. The job is paused and can be resumed later using the `bg` or `fg` command.

Pressing `Ctrl+C` sends an interrupt signal (`SIGINT`) to the currently running foreground job, causing it to terminate.

Pressing `Ctrl+D` signals the end of input (EOF) and can be used to terminate a running command or exit from an interactive shell session.

#### 6.2 Scheduling jobs with at

###### 6.2.1 When do you use at scheduling?

The `at` command in Bash allows you to schedule a job at a specific time in the future, for instance, the execution of a script or command. It is useful for one-time tasks or recurring tasks that need to be executed at a specific date and time. Keep in mind that the availability and specific usage of the `at` command may vary depending on your operating system or distribution. To do this, install the `at` package by using the command `sudo apt install at`.

###### 6.2.2 Schedule a job in at

To schedule a job using the `at` command at a specific date and time, you need to provide the `time` parameter in the format `HH:MM` (24-hour format), and the `date` parameter in the format `MMDDYYYY`. Additionally, you can include the `-f` option to specify that a file should be read, followed by the name of the script.

```bash
$ at HH:MM MMDDYYYY -f /path/to/script.sh
```

###### 6.2.3 List the scheduled jobs

The `atq` command can be used to list all the scheduled jobs with their reference number.

```bash
$ atq
```

###### 6.2.4 Removing scheduled jobs

The `atrm job_number` command can be used to remove scheduled jobs using their corresponding job number.

```bash
$ atrm job_number
```

#### 6.3 Scheduling jobs with cron

###### 6.3.1 When do you use cron scheduling?

Cron is a time-based job scheduler in Unix-like operating systems, including Linux. It allows you to schedule jobs at predefined intervals or specific times, for instance, the execution of scripts or commands. It is useful for performing recurring tasks, such as backups, log rotation, or data synchronization, as cron allows you to easily set up jobs that run at fixed intervals or specific times on a regular basis, including daily, weekly, monthly, or custom intervals.

###### 6.3.2 Schedule a job in cron

Here's a brief explanation of how to use cron to schedule script execution in Bash:

1. Edit the cron table: Each user has their own cron table where scheduled jobs are defined. To edit the cron table, use the following command:
   
   ```bash
   $ crontab -e
   ```
   
   This will open the cron table in the default text editor.

2. Define a cron job: The cron table contains comments that explain how new tasks can be determined. Under these comments, you can write a new line to specify a cron job. The basic syntax of a cron job entry is as follows:
   
   ```bash
   * * * * * command_to_execute
   ```
   
   The five asterisks represent the scheduling parameters: minute, hour, day of the month, month, and day of the week. Each parameter can be specified as a specific value, a range, or a wildcard (`*`).
   
   For example, to schedule a script to run every day at 9:00 AM, you can use the following cron job entry:
   
   ```bash
   0 9 * * * /path/to/script.sh
   ```
   
   This cron job will execute the script `/path/to/script.sh` at 9:00 AM every day.

3. Save and exit the cron table: Once you have defined your cron job(s), save the changes and exit the cron table editor.

###### 6.3.3 List the scheduled jobs

The `crontab -l` command can be used to view the list of scheduled cron jobs.

```bash
$ crontable -l
```

###### 6.3.4 Removing scheduled jobs

If you want to remove or modify a cron job, you can edit the cron table again using `crontab -e` or remove all cron jobs using `crontab -r`.

```bash
$ crontab -r
```

## <u>7. Persistent terminal sessions</u>

#### 7.1 Screen utility

###### 7.1.1 What is a persistent terminal session?

A persistent terminal is a type of terminal session that remains active and retains its state even after the terminal window is closed or the user logs out. It allows users to pick up their work from where they left off, keeping running processes, commands, and output intact.

To establish a persistent terminal session, tools like `screen` are often utilized. These tools create a virtual terminal session that operates independently of the physical terminal window. They offer features such as multiple windows, window splitting, and detach/reattach functionality, enabling users to work on different tasks and easily switch between them.

When a persistent terminal session is initiated, it becomes a detached session that continues running in the background. It remains active even if the terminal window is closed or the user disconnects from the remote server. When the user needs to resume their work, they can simply attach to the existing session, seamlessly picking up where they left off with all processes and windows still intact.

###### 7.1.2 Create a terminal session

To initiate the `screen` utility in your terminal, all you need to do is type the command `screen` and press the Enter key. This action will commence a new `screen` session, providing you with a virtual terminal within your current terminal window. 

```bash
$ screen
```

To determine whether or not you are connected to a `screen` session, you can look into the content of the `STY` variable, which provides the session name or ID if you are in a `screen` session. If you are not in a `screen` session, the command will not return any output.

```bash
$ echo $STY
```

###### 7.1.3 Detach and reattach to terminal session

If you wish to detach from your current `screen` session while allowing it to continue running in the background, you can achieve this by pressing `Ctrl + A` followed by `D`. This action will detach you from the session without terminating its processes.

To gain insight into all the available `screen` sessions, you can execute the command `screen -ls`. By doing so, a comprehensive list of active sessions will be displayed, showcasing their respective session IDs.

```bash
$ screen -ls
```

When you want to reconnect to a specific `screen` session, you can utilize the command `screen -r session_id`, replacing `session_id` with the actual ID of the desired session. By executing this command, you will successfully reestablish your connection to the designated session, allowing you to resume your work or tasks within that session.

```bash
$ screen -r session_id
```

###### 7.1.4 Create multiple windows within a session

Within a `screen` session, you have the flexibility to open multiple windows, each functioning as an independent workspace. To create a new window, simply press `Ctrl + A` followed by the letter `c`. To navigate between these windows seamlessly, you can press `Ctrl + A` followed by `N`  to move to the next window or `Ctrl + A` followed by `P` to move to the previous window. This convenient command empowers you to efficiently manage and organize your work within `screen` sessions, optimizing your productivity and command-line experience.

###### 7.1.5 Split windows for multitasking

In addition to opening multiple windows within a `screen` session, you can further enhance your multitasking capabilities by splitting the current window into multiple panes. To split the window vertically, you can press `Ctrl + A` followed by the pipe symbol `|`. Conversely, if you prefer a horizontal split, you can achieve this by pressing `Ctrl + A` followed by the letter `S`. 

Once you have multiple panes within a window, navigating between them becomes effortless. By pressing `Ctrl + A` followed by the `Tab` key, you can switch the cursor  from one pane to another. This intuitive shortcut allows you to seamlessly move between the various panes, ensuring you can easily monitor and interact with each section of your `screen` session.

###### 7.1.6 Terminate a terminal session

To terminate a screen terminal session in Bash, you can use the command `screen -X -S session_id quit`. Here, `session_id` refers to the specific session ID of the session you want to end. This action closes all windows and processes associated with the session, ensuring a complete shutdown.

```powershell
$ screen -X -S session_id quit
```

## <u>8. Bash scripting</u>

#### 8.1 Create a script

###### 8.1.1 What is a script?

A Bash script refers to a file containing a series of commands written in the Bash scripting language that can be executed by the Bash shell. Bash scripting allows you to automate tasks, execute multiple commands sequentially or conditionally, and perform complex operations.

###### 8.1.2 Steps for creating a script

To create and execute a script in Bash, you can follow these main steps:

1. Open a text editor: Start by opening a text editor of your choice.

2. Start the script: Begin the script with a shebang line that specifies the path to the Bash interpreter. This informs the system that the script should be executed using Bash. The shebang line typically looks like this:
   
   ```bash
   $ #!/bin/bash
   ```

3. Write the script: Add the commands and instructions you want the script to execute.

4. Save the script: Save the script file with a descriptive name and the `.sh` extension. This extension is not mandatory, but it is a convention. For example, you could save it as `myscript.sh`.

5. Make the script executable: Before you can execute the script, you need to make it executable. Open a terminal and navigate to the directory where the script is located. Then, use the `chmod` command to set the executable permission.
   
   ```bash
   $ chmod +x myscript.sh
   ```

6. Execute the script: Once the script is executable, you can run it by providing its file name as a command. Use the `./` prefix to indicate that the script is in the current directory. For example:
   
   ```bash
   ./myscript.sh
   ```

7. Script output: The script will execute the commands you have written, and any output or results will be displayed in the terminal.

#### 8.2 Scripting syntax

###### 8.2.1 Identation

In Bash scripting, indentation involves aligning lines of code with consistent spacing or tabs to visually structure and format the script. By adding leading whitespace characters, the hierarchical structure and logical flow of the code are represented. While not mandatory for the functioning of the script, proper indentation greatly improves readability, maintainability, and understandability, particularly as the script becomes larger and more complex.

###### 8.2.2 Comments

In Bash scripts, comments are lines of text that are ignored by the interpreter and are meant for human readers to understand the code. They provide explanations, descriptions, or annotations about the script's functionality, making the code more readable and maintainable. A line comment start with the `#` symbol and continue until the end of the line. Everything after the `#` symbol on that line is treated as a comment and is ignored by the interpreter.

```bash
# This is a comment in Bash
```

###### 8.2.3 Fully qualified command names

A distinction can be made between regular command names that rely on system-specific configurations or aliases (example: `command`), and fully qualified command names that explicitly specify the location or path of the command (example: `/usr/bin/command`). In the context of writing scripts, the use of fully qualified command names in Bash scripts is strongly recommended for several reasons. It helps to avoid conflicts that may arise from different versions of commands with varying behaviors or options on different systems or distributions. By specifying the full command name, the intended command will be executed consistently across systems, without relying on system-specific configurations or aliases. The usage of fully qualified command names also contribute to script maintenance by making the scripts easier to understand and update.

#### 8.3 Variables

###### 8.3.1 What are variables

In Bash, variables are used to store data or values that can be referenced and manipulated within a script. They provide a way to assign and store information for later use. 

###### 8.3.2 Declare a variable

Variable names in Bash are case-sensitive and can contain letters, numbers, and underscores. It's important to note that there should be no spaces around the equal sign when assigning a value to a variable. To declare a variable in Bash, you typically assign a value to it using the following syntax:

```bash
$ variable_name="value"
```

By convention, new variables in Bash are typically declared with lowercase letters rather than uppercase. This convention helps differentiate variables from environment variables and other types of shell variables, which are often defined using uppercase letters.

###### 8.3.3 Reference to a variable

To reference the value of a variable within a script, you prefix the variable name with a dollar sign ($). For example:

```bash
$ echo $name
```

When referencing variables within a string in Bash, it's a good practice to enclose them in double quotes. When using single quotes (`''`) in Bash, any variable references within the quotes will be treated as literal text rather than being expanded to their values. In contrast, using double quotes (`"`) allows for variable expansion, meaning the variable references within the quotes will be replaced with their actual values. For example:

```bash
# Single quotes
$ echo 'My name is $name.' # Output: My name is $name.

# Double quotes
$ echo "My name is $name." # Output: My name is Eli.
```

Note, that variables declared in a Bash session are not persistent by default. They are tied to the current session and will be lost once the session ends. When you exit the Bash session or close the terminal, any variables you have defined within that session will no longer be accessible.

###### 8.3.4 Capture output of a command

Subshells allow you to execute commands within a separate environment and capture their output into a variable for further processing or display. To invoke a command and store its output in a variable, you can use command substitution (`$()`). 

```bash
$ variable=$(command)
```

###### 8.3.5 Scope of variables

Variables declared in a Bash session are not persistent by default. They are tied to the current session and will be lost once the session ends. When you exit the Bash session or close the terminal, any variables you have defined within that session will no longer be accessible. By defining variables within a script, you can have greater control and ensure the variables' availability and behavior within the script's scope.

Environmental variables, on the other hand, are built-in variables that are part of the operating system's environment. These variables are available to all sessions and scripts running on the system. They are persistent and can be referenced regardless of the session. Examples of environmental variables include `PATH`, `HOME`, `USER`, and `LANG`. To display all your environmental variables along with their values you can make use of the `env` command.

```bash
$ env
```

#### 8.4 Interact with terminal

###### 8.4.1 Write to the terminal

The `echo` command in Bash is commonly used to display messages or output on the terminal. It can be used within Bash scripts to provide information or communicate with the user.

```bash
$ echo "message"
```

###### 8.4.2 Read from the terminal

The `read` command in Bash is used to obtain input from the terminal and store it in a variable. It allows you to prompt the user for input and capture their response for further processing within a script.

```bash
$ read variable_name
```

#### 8.5 Conditionals

###### 8.5.1 if statement

An "if" statement is used for conditional branching, allowing the script to make decisions based on certain conditions. It evaluates an expression and executes a block of code only if the expression is true. 

The general syntax of an if statement in Bash is as follows:

```bash
$ if [ condition ]
then
   # Code to be executed if the condition is true
fi
```

Expressions are often evaluated using the `test` command. In practice, the alternative notation using square brackets (`[ condition ]`) is more commonly used in if statements instead of explicitly using the `test condition` command. Keep in mind that both expressions are completely equivalent to each other. 

```bash
$ if test condition
then
   # Code to be executed if the condition is true
fi
```

Instead of using the `test` command explicitly, you can use any other command to evaluate an expression in the condition of an if statement. One common example is using the `command -v` command that can be used to check if a specific command is available and produces the command name as output when it is available. In the example here below, the `command -v echo >/dev/null` is utilized to verify the existence of the `echo` command, with its output redirected to `/dev/null` to discard any output.

```powershell
$ if command -v echo >/dev/null
then
   # Code to be executed if the condition is true
fi
```

###### 8.5.2 else statement

An "else" statement is used in conjunction with an "if" statement to provide an alternative block of code to be executed when the condition of the "if" statement is false. It allows for branching based on the condition being evaluated. 

The general syntax of an "else" statement in Bash is as follows:

```bash
$ if [ condition ]
then
   # Code to be executed if the condition is true
else
   # Code to be executed if the condition is false
fi
```

Again, the same applies as explained above, where the condition is evaluated with the `test` command (with or without the alternative notation in square brackets), but the expression can also be evaluated with any other command.

#### 8.6 Exit codes

###### 8.6.1 What are exit codes

Exit codes, also known as exit statuses or return codes, are numeric values returned by a program or command when it finishes executing. They indicate the outcome of the program or command, serving as a way to communicate the execution status to other programs or scripts. Exit codes can have different meanings, but generally, an exit code of zero (`0`) represents success or a successful execution. Non-zero exit codes (`1`, `2`, `3`, ...) indicate various types of errors or failures, with different codes representing different error conditions.

###### 8.6.2 Accessing the exit code

In Bash, you can access the exit code of the previously executed command or program using the special variable `$?`. After executing a command, you can refer to `$?` to retrieve the exit code.

```powershell
$ command
$ echo $?
```

###### 8.6.3 Handling exit codes in scripts

Exit codes are commonly used in scripts for error handling and decision-making. You can use control structures (e.g., if-else statements) to check the exit code and perform actions accordingly. For example, if a command exits with a non-zero code, you might want to display an error message or take alternative steps.

To access and interpret the exit code in a script, you can use it in conditional statements like this:

```bash
$ command
$ if [ $? -eq 0 ]; then
    # Command executed successfully
    # Perform actions accordingly
else
    # Command encountered an error
    # Handle the error or take alternative steps
fi
```

###### 8.6.4 Manipulate the exit code

In Bash, you can manipulate the exit code of a script using the `exit` command. The `exit` command allows you to explicitly set the exit code to a specific value. For this, you will have to decide on the desired exit code value based on the conditions or logic you have implemented. If your script completed successfully, you can just use the null value (`0`), and if it was not successful, you can use non-zero values  (`1`, `2`, `3`, ...). To set the exit code, use the `exit` command followed by the desired value. 

```powershell
$ command
$ if [ $? -eq 0 ]; then
    # Command executed successfully
    # Perform actions accordingly
    exit 0
else
    # Command encountered an error
    # Handle the error or take alternative steps
    exit 1
fi
```

Place the `exit` command at an appropriate location within your script, typically used after the script has completed its execution. At the moment the `exit` command is encountered, it forces the script execution to stop at that point, and the specified exit code is returned to the calling process. The calling process, which can access the exit code using `$?`, can then determine the outcome of the script execution based on the received exit code.

#### 8.7 Looping

###### 8.7.1 while loop

In Bash, a while loop is a control structure that allows you to repeatedly execute a block of code as long as a certain condition is true. It provides a way to create iterative processes in your scripts.

The syntax for a while loop in Bash is as follows:

```bash
$ while [ condition ]
do
  # Code block to be executed
done
```

Again, the same applies as in the section on conditionals, where the condition is evaluated with the `test` command (with or without the alternative notation in square brackets), but the expression can also be evaluated with any other command.

###### 8.7.2 for loop

In Bash, a for loop is a control structure that allows you to iterate over a list of items or perform a set of actions a certain number of times. It provides a way to repeat a block of code for each item in a list or based on a specific range of values. To refer to list items, use the dollar sign (`$item`), in the same way you would refer to a variable.

The syntax for a for loop in Bash is as follows:

```bash
$ for item in list
do
  # Code block to be executed
done
```

Again, the same applies as in the section on conditionals, where the condition is evaluated with the `test` command (with or without the alternative notation in square brackets), but the expression can also be evaluated with any other command.

###### 8.7.3 Iterate over different modalities

In Bash, a `for` loop can iterate over different modalities or collections of data.

1. Numeric Range: Iterate over a sequence of numbers using brace expansion `$ {start..end}`.
   
   ```bash
   $ for i in {1..5} 
   do
    echo $i
   done
   ```

2. Array: Iterate over elements in an array using the `for` loop.
   
   ```bash
   $ array_name=(element1 element2 element3 ...)
   $ for elem in "${array_name[@]}" 
   do
    echo $elem
   done
   ```

3. Command Output: Iterate over the output of a command or a command substitution using the `for` loop.
   
   ```bash
   $ for file in $(ls) 
   do
    echo $file
   done
   ```

#### 8.8 Functions

###### 8.8.1 What are functions used for

In Bash, functions are blocks of code that can be defined and called to perform specific tasks. They provide a way to organize and reuse code within a script. Functions allow you to encapsulate a set of commands, which can be executed multiple times throughout the script without duplicating the code.

###### 8.8.2 Defining functions

In Bash scripts, a function can be defined after choosing a name followed by parentheses (`()`). Inside the curly braces (`{}`), you define the body of the function.  Within the function, you can define parameters by using the `local`keyword followed by the parameter name and assigning it a value. After defining the parameters, you can write the code that needs to be executed using those parameters. To return a variable from the function, you can use the `echo` keyword followed by the value you want to return. Outside of the function, you can call the function by using its name followed by parentheses, and you can also pass arguments to it. The result of the function, which is assigned to the variable, and can be accessed and used further in the script.

Here is the basic syntax for defining and using functions in Bash:

```bash
function_name() {

    # Define parameters
    local parameter1=$1
    local parameter2=$2
    ...

    # Code to be executed using the parameters
    # ...

    # Return a variable
    echo $variable
}

# Call the function and pass arguments
variable=$(function_name argument1 argument2)
```

#### 8.9 Case statements

In Bash, a case statement provides a way to perform different actions based on the value of a variable or an expression. It allows you to check multiple patterns and execute corresponding code blocks when a match is found. It is similar to a switch statement in other programming languages.

The basic syntax of a case statement in Bash is as follows:

```bash
case expression in
    pattern1)
        # code block 1
        ;;
    pattern2)
        # code block 2
        ;;
    pattern3)
        # code block 3
        ;;
    ...
    *)
        # default code block
        ;;
esac
```

The case statement evaluates each pattern in order until it finds a match with the expression. Once a match is found, the corresponding code block is executed, and the case statement terminates. If no match is found, the code block associated with the `*` pattern (default) is executed, if provided.

#### 8.10 Arguments

###### 8.10.1 What are script arguments?

Script arguments, also known as command-line arguments, are values provided to a script when it is executed. They allow you to pass input data or parameters to a script from the command line. Bash scripts can access these arguments and use them within the script's code. Script arguments are useful for making scripts more versatile and customizable. They enable you to provide different inputs or configurations to the script each time it is run, without modifying the script itself. This can be particularly useful when automating tasks or when the same script needs to be executed with varying inputs or options.

###### 8.10.2 Accessing the arguments

In Bash, script arguments are accessed using positional parameters. The first argument is referred to as `$1`, the second argument as `$2`, and so on. The special variable `$0` represents the script's name itself. You can use these variables within your script to retrieve and utilize the provided arguments.

For example, if you have a script called `myscript.sh` and you execute it as follows:

```bash
./myscript.sh arg1 arg2 arg3
```

Within the script, you can access the values of the arguments using `$1`, `$2`, and `$3`, respectively. You can then use these values to perform specific actions or calculations in your script.

###### 8.10.3 Checking the number of arguments

In Bash scripts, the variable `$#` represents the number of arguments passed to the script or function. It provides a convenient way to determine the count of arguments provided at runtime. It is particularly useful when you want to check the number of arguments and make decisions or perform specific actions based on that count.

#### 8.11 Storing scripts

###### 8.11.1 Where to store scripts

The `/usr/local/bin` directory is commonly used to store scripts in Unix-like systems, including Linux. It is considered a good practice because it is part of the standard directory structure, and it is intended for locally installed software or scripts that are not part of the operating system's default installation. When scripts or executables are placed in the `/usr/local/bin` directory, they can be executed without specifying the full path. A script can be executed by simply typing the name of the script.

Regarding ownership and group, it is generally recommended to set the ownership and group of scripts stored in `/usr/local/bin` to the root user (or another privileged user) for security reasons. By assigning ownership to the root user, you ensure that only authorized users can modify or execute those scripts. It helps prevent unauthorized modifications and potential security vulnerabilities.

###### 8.11.2 $PATH variable

The `$PATH` variable is an environment variable that contains a colon-separated list of directories. It specifies the directories where the shell looks for executable files when you type a command in the terminal. When you enter a command in the shell, it searches for the corresponding executable file in each directory listed in the `$PATH` variable, in the order they appear. If the executable file is found, the command is executed. This way, `/usr/local/bin` forms one of the directories in which `$PATH` appears and in which executables are searched for.

To add new directories to the `$PATH` variable, you can modify the value of the variable. For this, a new directory is added to the beginning of the `$PATH` variable, followed by a colon `:` to separate it from the existing directories. The `$PATH` variable is then exported using the `export` command to make the change effective for the current shell session.

```bash
$ export PATH="/new/directory:$PATH"
```

###### 8.11.3 Making changes permanent

The method we used above to demonstrate how to add a new directory to the `$PATH` environment variable ensures that the changes you export are only temporary and usable only in the current session. If you want to save and run scripts from a particular directory, it would be nice if the directory is immediately available in the `$PATH` variable without having to change the variable each time. So we will now discuss a general method that can be used to make any kind of changes permanent in Bash.

To make changes to the `$PATH` variable permanent in Bash, follow these steps:

1. Open the `~/.bashrc` file in a text editor. You can use the `nano` editor for this:
   
   ```bash
   $ nano ~/.bashrc
   ```
   
   The `~/.bashrc` file is typically used for configuring Bash settings and is loaded when you start an interactive Bash shell.

2. Edit the file with the change you want to make permanent. In this case, scroll to the bottom of the file and look for the section where environment variables are set and add the following line to add your desired directory to the `$PATH` variable:
   
   ```bash
   $ export PATH="/path/to/directory:$PATH"
   ```

3. Save the file and exit the text editor.

4. To apply the changes to the current shell session, either restart your terminal or run the following command:
   
   ```bash
   source ~/.bashrc
   ```

5. The directory you added to the `$PATH` variable will be automatically available in your Bash sessions, allowing you to run scripts or executables from that directory without specifying the full path.

It's important to note that modifying the `~/.bashrc` file affects only the user account in which it is modified. If you want the changes to apply system-wide or for other user accounts, you may need to modify different configuration files, such as `/etc/profile` or `/etc/environment`, depending on your Linux distribution and system configuration.
