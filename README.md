# GebToGrid
Presentation of my talk on using Geb to test against a Selenium Grid

## Selenium Grid Setup
1. Ensure docker and docker-compose gets installed for your OS.
  * If using Windows, 
    * I recommend installing Docker Toolbox instead of Docker for Windows.  Both Docker and Docker Compose will be installed with Docker Toolbox.  
    * However, these instructions should work using Docker for Windows (not tested).
  * If using Linux, both Docker and Docker Compose will need to be installed.
2. Ensure at least 4GB of memory is available.
  * If using Docker Toolbox, open VirtualBox to configure at least 4GB of memory to the default VM.
  * If using Linux, ensure your system has sufficient RAM installed.
3. Build the base image
  * `cd selenium_grid`
  * `docker build -t selenium_grid/base:2.53.1 base/.`
4. Build and start the hub and one firefox node
  * `docker-compose up -d hub firefox`
5. Scale to six firefox nodes
  * `docker-compose scale firefox=6`
6. View your running containers
  * `docker ps`
