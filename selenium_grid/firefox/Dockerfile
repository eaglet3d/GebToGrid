FROM selenium_grid/base:2.53.1
#FROM selenium_grid/base:3.0.0-beta3

ENV FIREFOX_MINOR 45.5.1esr

RUN apt-get update -qqy
RUN apt-get update --fix-missing
RUN apt-get -qqy --no-install-recommends install xvfb
RUN apt-get -qqy --no-install-recommends install firefox
RUN apt-get -qqy --no-install-recommends install bzip2 \
vim \
&& rm -rf /var/lib/apt/lists/*

RUN [ -e /usr/bin/firefox ] && rm /usr/bin/firefox
ADD https://ftp.mozilla.org/pub/mozilla.org/firefox/releases/${FIREFOX_MINOR}/linux-x86_64/en-US/firefox-${FIREFOX_MINOR}.tar.bz2 /tmp/
RUN apt-get install -q -y libdbus-glib-1-2
RUN tar -xvjf /tmp/firefox-${FIREFOX_MINOR}.tar.bz2 -C /opt/
RUN chmod -R +x /opt/firefox/
RUN ln -s /opt/firefox/firefox /usr/bin/firefox

ADD selenium.node.register /var/selenium.node.register
RUN chmod 755 /var/selenium.node.register

CMD ["/bin/bash", "/var/selenium.node.register"]

