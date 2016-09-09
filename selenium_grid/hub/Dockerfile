FROM selenium_grid/base:2.53.1
#FROM selenium_grid/base:3.0.0-beta3

EXPOSE 4433

ADD selenium.hub.start /var/selenium.hub.start
RUN chmod 755 /var/selenium.hub.start

CMD ["/bin/bash", "/var/selenium.hub.start"]

