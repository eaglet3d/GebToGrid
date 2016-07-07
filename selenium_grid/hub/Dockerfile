FROM selenium_grid/base:2.53.1

EXPOSE 4444

ADD selenium.hub.start /var/selenium.hub.start
RUN chmod 755 /var/selenium.hub.start

CMD ["/bin/bash", "/var/selenium.hub.start"]

