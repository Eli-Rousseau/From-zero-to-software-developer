# Docker

## 1. Introduction

#### 1.1 What is Docker

Docker is a platform that ensures applications run consistently across different environments by packaging everything they need, including dependencies, into containers. This eliminates issues like missing files, software version mismatches, and inconsistent configuration settings. With Docker, applications that run on a developer's machine will run the same way on testing or production machines. Teams benefit from streamlined workflows, as Docker automates the setup process, allowing multiple versions of applications to run simultaneously in isolated environments. When finished, Docker enables the removal of applications and their dependencies with ease, preventing system clutter and dependency conflicts.

#### 1.2 Containers vs. Virtual Machines

A container is a lightweight, isolated environment for running applications, while a virtual machine (VM) is a full abstraction of physical hardware, requiring its own operating system. VMs, managed by a hypervisor, allow multiple isolated applications to run on the same physical machine but are resource-intensive, slow to start, and limited in number due to the need for separate OS instances. In contrast, containers share the host's OS, making them faster to start, less resource-demanding, and capable of running many applications side by side, offering more efficient isolation and scalability.

#### 1.3 Docker's Client-Server Architecture

Docker operates using a client-server architecture, where the client communicates with the server, known as the Docker Engine, via a RESTful API. The Docker Engine runs in the background, handling the creation and execution of containers, which are essentially isolated processes sharing the host's operating system kernel. Since containers use the host’s kernel, they don’t include a full operating system. This means Linux containers can only run on Linux hosts, while Windows supports both Windows and Linux containers due to its integrated Linux kernel. macOS, lacking native container support, uses a lightweight Linux virtual machine to run Docker containers.

#### 1.4 Installing Docker

To install Docker, visit [Docker’s official website](https://www.docker.com/) and download the appropriate installer for your operating system by clicking the download button at the top of the page or from the release notes section.

For Windows:

1. Run the installer by double-clicking `Docker Desktop Installer.exe`. By default, Docker Desktop will be installed at `C:\Program Files\Docker\Docker`.
2. During installation, you can choose the backend for Docker. Ensure the **Use WSL 2 instead of Hyper-V** option is selected (or not) based on your preference.
3. Follow the on-screen instructions to complete the setup.
4. Once installed, click **Close** to finish.

To verify the installation, open a terminal and run:

```bash
docker version
```

This will display the version of Docker installed and confirm that it's running correctly.

#### 1.5 Docker Development Workflow

In the Docker development workflow, any application can be "dockerized," meaning it is adapted to run in a Docker container. This involves adding a `Dockerfile` to the project—a simple text file with instructions for packaging the application into a Docker image. The image includes everything needed to run the application, such as a minimal operating system, runtime environment, application files, libraries, and environment variables. Once the image is built, Docker can create a container—a specialized process with its own file system based on the image—on the development machine.

The application runs within this container, making it easy to launch locally. Once the image is ready, it can be pushed to a container registry like Docker Hub. From there, the image can be pulled to any machine, ensuring the application runs consistently in any environment. All the steps for building the image are defined in the `Dockerfile`, making the application portable and easy to deploy across different systems.

#### 1.6 Working with Linux Distributions on Docker

Linux, being open-source, has many versions called distributions, each tailored for different needs. One of the most popular distributions is Ubuntu. While most Linux distributions share common shell commands, there might be slight variations among them.

To use Ubuntu in Docker, you can pull the image from Docker Hub by running:

```bash
docker pull ubuntu
```

Alternatively, you can pull the image and start a container in one step using:

```bash
docker run ubuntu
```

However, this command will stop the container immediately since it doesn’t run interactively. To view all active containers, use:

```bash
docker ps
```

To see all containers, including those that have stopped, use the `-a` flag:

```bash
docker ps -a
```

For interactive usage, where you can interact with the container’s shell, use:

```bash
docker run -it ubuntu # Creates and starts a new container
docker start -t id_container # Restarts an existing, stopped container
```

This opens an interactive shell, allowing you to pass commands directly to the Ubuntu container.

## 2. Building Images

#### 2.1 Docker Images and Containers

A **Docker image** is a packaged environment that includes everything an application needs to run, such as a minimal operating system, libraries, application files, and environment variables. It contains all the necessary configuration and dependencies to ensure consistency across environments. Once an image is created, it can be used to instantiate a container.

A **Docker container**, on the other hand, is an isolated environment created from an image where the application is executed. Containers are essentially special operating system processes with their own file systems provided by the image. They can be started, stopped, and restarted as needed.

#### 2.2 Dockerfile

A `Dockerfile` contains the instructions needed to build a Docker image. Here are the key directives commonly used:

- **`FROM`**: Specifies the base image to build upon.
  
  ```dockerfile
  FROM ubuntu:jammy
  ```

- **`WORKDIR`**: Sets the working directory inside the container.
  
  ```dockerfile
  WORKDIR /app
  ```

- **`COPY`** or **`ADD`**: Copies files and directories from the host machine into the container.
  
  ```dockerfile
  COPY . /app
  ```

- **`RUN`**: Executes OS commands during the image build process.
  
  ```dockerfile
  RUN apt-get update && apt-get install -y python3
  ```

- **`ENV`**: Defines environment variables within the container.
  
  ```dockerfile
  ENV APP_ENV=production
  ```

- **`EXPOSE`**: Informs Docker that the container will listen on a specified port.
  
  ```dockerfile
  EXPOSE 8080
  ```

- **`USER`**: Specifies which user should run the application.
  
  ```dockerfile
  USER node
  ```

- **`CMD`**: Sets the default command to be executed when the container starts.
  
  ```dockerfile
  CMD ["python3", "app.py"]
  ```

- **`ENTRYPOINT`**: Defines the command that will always run when the container starts.
  
  ```dockerfile
  ENTRYPOINT ["python3", "app.py"]
  ```

These instructions guide the process of building a Docker image, defining the environment and behavior of the resulting container.

#### 2.3 Creating and Building Docker Images with a Dockerfile

To start using Docker, create a `Dockerfile` in your project directory. The `FROM` instruction specifies the base image, which can be an operating system (e.g., Linux or Windows) or a combination of an OS and a runtime environment, like Node.js on Linux. For example, a common lightweight base image is Node.js with Alpine Linux:

```dockerfile
FROM node:current-alpine3.20
```

This small-sized image improves build and deployment speed. It's important to avoid using images tagged as `latest`, as they can introduce inconsistencies. Instead, specify a version to ensure a stable environment.

To build the image from the `Dockerfile` in your current directory, run:

```bash
docker build -t application-name .
```

You can list all images on your machine using:

```bash
docker image ls
```

To run the built image and start a new container interactively, use:

```bash
docker run -it application-name sh
```

This opens a shell session inside the container, allowing you to interact with the running environment.

#### 2.4 Copying Application Files into a Docker Image

In Docker, the `COPY` and `ADD` instructions are used to copy files from the local system into the image during the build process.

- **`COPY`**: This command copies files or directories from the current directory on the host machine into the Docker image. You can use patterns to select specific files:
  
  ```dockerfile
  COPY file*.txt /app/
  ```
  
  To copy everything from the current directory, use:
  
  ```dockerfile
  COPY . /app/
  ```

- **`WORKDIR`**: This sets the working directory for the subsequent instructions, making it easier to use relative paths:
  
  ```dockerfile
  WORKDIR /app
  ```

- **`ADD`**: Similar to `COPY`, but with additional features like downloading files from URLs or automatically extracting compressed files.
  
  ```dockerfile
  ADD https://example.com/file.zip /app/
  ```

Both commands are crucial for transferring application files into the Docker image, with `ADD` offering extra flexibility for external files and compression.

#### 2.5 Excluding Files from Docker Image

When deploying to a remote Docker engine, the Docker client transfers the build context—everything in your project directory—to the remote machine. If the build context contains millions of files, such as `node_modules` in a Node.js project, it can slow down the build process. However, since dependencies are defined in `package.json`, you can exclude unnecessary files to reduce the context size and speed up the build.

To exclude files, create a `.dockerignore` file in your project directory and list the files and directories that should be ignored during the build. For example:

```plaintext
node_modules/
.git
*.log
```

This ensures a smaller, more efficient build context.

#### 2.6 Executing Commands During Image Build

The `RUN` in your `Dockerfile` instruction allows you to execute shell commands. If one decided to exclude dependencies in the `.dockerignore` file, these would be installed  during the image build process, such as installing dependencies for a Node.js application using `npm`:

```dockerfile
RUN npm install
```

This ensures that all required packages are installed in the image when it is built, so the application can run smoothly in the container. The `RUN` instruction executes during the build phase and adds the installed dependencies to the final image.

#### 2.7 Setting Environment Variables in Docker

You can define environment variables in a Docker container using the `ENV` instruction in the `Dockerfile`. For example:

```dockerfile
ENV API_URL=https://api.myapp.com/
```

This sets the `API_URL` variable during the image build process, making it available as a system environment variable inside the container. These variables can be accessed by the application or other processes running within the container, ensuring a consistent environment for your app.

#### 2.8 Exposing and Mapping Ports in Docker

When running an application inside a Docker container, it's important to understand that the application runs on the container's network, not directly on `localhost`. The `EXPOSE` instruction in the `Dockerfile` specifies which port the container's application will listen on:

```dockerfile
EXPOSE 8080
```

However, this does not automatically map the container's port to the host. `EXPOSE` serves as documentation to indicate which port the container is listening to. To make the application accessible on the host, you must explicitly map the container's port to a host port when running the container:

```bash
docker run -p 8080:8080 application-name
```

This command maps port `8080` on the host to port `8080` in the container, allowing external access to the application.

#### 2.9 Running Docker Containers with a Non-Root User

By default, Docker runs applications with the `root` user, which has high privileges and can pose security risks. To minimize these risks, it's best to run the application with a non-root user that has limited privileges.

In your `Dockerfile`, you can create a new system user and group using the `RUN` instruction:

```dockerfile
RUN addgroup app && adduser -S -G app app
```

Here, a group and user named `app` are created. After that, use the `USER` instruction to switch to this non-privileged user:

```dockerfile
USER app
```

This ensures the application runs with restricted privileges, improving security by limiting access to system resources and preventing the user from owning or modifying application files.

#### 2.10 Run Applications in Docker

When running a container without opening a shell, such as starting a React application, you can use the `CMD` instruction in the `Dockerfile` to define a default command that runs when the container starts. For example:

```dockerfile
CMD ["npm", "start"]
```

This command runs the `npm start` script at runtime. Note that `CMD` is a runtime instruction, while `RUN` is used during the image build.

To launch the container, use:

```bash
docker run application
```

Alternatively, `ENTRYPOINT` is similar to `CMD` but locks the execution of a specific command unless overridden with the `--entrypoint` flag. It's used when the command to be executed is fixed:

```dockerfile
ENTRYPOINT ["npm", "start"]
```

You can still override `ENTRYPOINT` at runtime if needed:

```bash
docker run application --entrypoint echo "Different entry point"
```

This allows flexibility while maintaining control over the default behavior.

#### 2.10 Build Optimization

A Docker image consists of multiple layers, each representing a small file system with modified files. When Docker creates an image from a `Dockerfile`, it generates a new layer for each instruction, capturing only the files modified by that instruction. This layering leads to an accumulation of changes across the image. Docker employs caching mechanisms to optimize builds by reusing layers from previous builds when possible. 

However, certain instructions, like `COPY`, can prevent effective caching. If any file changes, the modified layer and all subsequent layers must be rebuilt, which can significantly slow down the process. For instance:

```dockerfile
COPY package*.json
RUN npm install
COPY . .
```

By placing the `COPY package*.json` instruction before `RUN npm install`, Docker can cache the installation of dependencies as long as the `package.json` files remain unchanged. This optimization means that during consecutive builds, if the package files haven't changed, the cached `npm install` can be reused, reducing build times. 

To further enhance build efficiency, it's advisable to structure the `Dockerfile` so that frequently changing instructions are placed at the bottom, allowing the more stable parts of the image to remain cached.

#### 2.11 Removing Images and Containers

During the process of building Docker images, you may encounter dangling images—unlabeled layers that are not associated with any image. To clean up these unnecessary layers, you can run:

```bash
docker image prune
```

If you need to remove a specific image, you can do so with the following command:

```bash
docker image rm application
```

Additionally, to delete all stopped containers, you can use:

```bash
docker container prune
```

These commands help maintain a tidy Docker environment by removing unused images and containers.

#### 2.12 Tagging Docker Images for Version Control

By default, Docker assigns the **latest** tag to newly created images. While this label is suitable for development, it can lead to confusion in production environments since the meaning of "latest" can change over time. To ensure clarity, it's important to use specific tags for production images. You can assign a tag at build time using the following command:

```bash
docker build -t application:v1.0 .
```

To change an existing tag, use:

```bash
docker image tag application:latest application:v1.0
```

If you need to remove a specific tag from an image, you can do so with:

```bash
docker image rm application:v1.0
```

Using well-defined tags helps maintain version control and stability in production deployments.

#### 2.11 Sharing Docker Images via Docker Hub

To share Docker images with others, you can create a Docker Hub account and set up a new repository. This repository can contain multiple images and can optionally be linked to a GitHub account. This integration allows Docker Hub to automatically pull the latest code and build a new image each time you push changes to GitHub. The repository will follow the naming convention `username/application`. 

To push your image to the repository, first tag it with the repository name:

```bash
docker image tag application:v1.0 username/application:v1.0
```

Next, log in to Docker Hub using your credentials:

```bash
docker login
```

You can then push the image to your repository with:

```bash
docker push username/application:v1.0
```

To retrieve any of the images stored on Docker Hub, use:

```bash
docker pull username/application:v1.0
```

This process enables seamless sharing and version control of your Docker images.

#### 2.12 Sharing Docker Images Without Docker Hub

To share Docker images directly between users without using Docker Hub, you can compress the image into a file. To save the image in a compressed format, use the following command:

```bash
docker image save -o application.tar application:v1.0
```

Once the `application.tar` file is created, it can be exchanged between users. To load the image from the compressed file, use:

```bash
docker image load -i application.tar
```

This method allows for easy transfer of Docker images without relying on an external repository.

## 3. Working With Containers

#### 3.1 Creating a Docker Container

To run a new container from the application image, use the following command:

```bash
docker run application
```

If the entry point is set correctly in the Dockerfile, this command will launch the application. To run the container in detached mode, which allows you to use the command line while the application runs in the background, use:

```bash
docker run -d application
```

To view all active containers, execute:

```bash
docker ps
```

For a complete list of all containers, including stopped ones, add the `-a` flag:

```bash
docker ps -a
```

#### 3.2 Docker Container Logs

To troubleshoot errors in a Docker container, you can view the log files that capture all output and errors produced by the container, similar to what is displayed in the terminal. Use the following command to access the logs:

```bash
docker logs container
```

Replace `container` with the name or ID of your specific container to see the relevant log information.

#### 3.3 Mapping Container Ports to Host Ports

When an application runs in a Docker container, it is published on the container's port, not directly on the host. To access the application from the host, you must explicitly map the container's port to a host port. This can be done using the `-p` flag when running the container, as shown below:

```bash
docker run -p 8080:8080 application-name
```

In this example, port 8080 on the host is mapped to port 8080 on the container, allowing external traffic to reach the application.

#### 3.4 Executing Commands in a Running Container

By default, a Docker container runs the command specified in the Dockerfile's  `ENTRYPOINT` or `CMD` at runtime. However, if you need to run additional commands in a running container, you can use the `docker exec` command to execute them without stopping the container. For example:

```bash
docker exec container echo "Command was executed in running container"
```

To open an interactive shell session inside a running container, use the following command:

```bash
docker exec -it container sh
```

This allows you to directly interact with the container's file system and environment.

#### 3.5 Stopping and Restarting Containers

To stop a running Docker container, use the following command:

```bash
docker stop container
```

This gracefully halts the container. To resume a stopped container, use:

```bash
docker start container
```

This command restarts the container from where it left off.

#### 3.6 Removing a Docker Container

To remove a Docker container, first ensure it is stopped by using:

```bash
docker stop container
```

Once the container is stopped, you can remove it with the following command:

```bash
docker rm container
```

This completely deletes the container from your system.

#### 3.7. Persisting Data with Docker Volumes

Storing data directly inside a container is not recommended, as it will be lost when the container is removed. To persist data, Docker provides volumes, which store data outside the container, either on the host or in the cloud.

To create a new volume, use:

```bash
docker volume create local-volume
```

You can inspect the details of a volume with:

```bash
docker volume inspect local-volume
```

To use the volume in a container, map it to a directory within the container when running it:

```bash
docker run -v local-volume:/app/data application
```

Ensure that the directory inside the container has the appropriate permissions for the user defined in the Dockerfile. Volumes allow containers to be removed without losing data and enable data sharing across multiple containers.

#### 3.8 Copying Files Between Host and Docker Container

To transfer files between the host system and a Docker container, you can use the `docker cp` command. This allows you to copy files from a running container to the host or vice versa. For example, to copy a file from the container to the host system, use:

```bash
docker cp container:/app/file.txt .
```

To copy a file from the host system to a container, use:

```bash
docker cp file.txt container:/app/
```

This is useful for sharing files or retrieving logs and data from the container without stopping or restarting it.

#### 3.9 Binding Host Directories to Containers for Development

In development, it's inefficient to rebuild a Docker image for every change made to the application. Instead, you can create a binding between a directory on the host and a directory inside the container. This way, changes made on the host are immediately reflected in the container.

To achieve this, you can use a volume mapping, similar to how volumes are linked. For example, to link the current working directory (`pwd`) on the host to the `/app/` directory inside the container, use the following command:

```bash
docker run -v $(pwd):/app/ application-image
```

This allows you to develop on the host while seeing changes instantly within the container without rebuilding the image. In production, however, always build a new Docker image for updates to ensure consistency and isolation across deployments.
