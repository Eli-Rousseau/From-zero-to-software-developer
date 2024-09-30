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
