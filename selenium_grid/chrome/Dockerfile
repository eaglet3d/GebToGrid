FROM selenium/base
MAINTAINER Selenium <selenium-developers@googlegroups.com>

USER root

#===============
# Google Chrome
#===============
RUN if [ ! -f linux_signing_key.pub ] ; then ( wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add - \
&& echo "deb http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google-chrome.list \
&& apt-get update -qqy \
&& apt-get -qqy install \
unzip \
google-chrome-stable \
&& rm /etc/apt/sources.list.d/google-chrome.list \
&& rm -rf /var/lib/apt/lists/* ) ; fi

#========================================
# Add normal user with passwordless sudo
#========================================
RUN sudo useradd seluser --shell /bin/bash --create-home \
&& sudo usermod -a -G sudo seluser \
&& echo 'ALL ALL = (ALL) NOPASSWD: ALL' >> /etc/sudoers \
&& echo 'seluser:secret' | chpasswd

#==================
# Chrome webdriver
#==================
ENV CHROME_DRIVER_VERSION 2.21
RUN if [ ! -f /opt/selenium/chromedriver-${CHROME_DRIVER_VERSION} ] ; then ( wget --no-verbose -O /tmp/chromedriver_linux64.zip https://chromedriver.storage.googleapis.com/${CHROME_DRIVER_VERSION}/chromedriver_linux64.zip \
&& rm -rf /opt/selenium/chromedriver \
&& unzip /tmp/chromedriver_linux64.zip -d /opt/selenium \
&& rm /tmp/chromedriver_linux64.zip \
&& mv /opt/selenium/chromedriver /opt/selenium/chromedriver-${CHROME_DRIVER_VERSION} \
&& chmod 755 /opt/selenium/chromedriver-${CHROME_DRIVER_VERSION} \
&& ln -fs /opt/selenium/chromedriver-${CHROME_DRIVER_VERSION} /usr/bin/chromedriver ) ; fi

#========================
# Selenium Configuration
#========================
COPY config.json /opt/selenium/config.json

#====================================
# Scripts to run Selenium Standalone
#====================================
RUN mkdir -p /opt/bin
COPY node.chrome.start /opt/bin/node.chrome.start
RUN chmod +x /opt/bin/node.chrome.start
COPY functions.env /opt/bin/

#===================================
# Chrome Launch Script Modification
#===================================
COPY chrome_launcher.sh /opt/google/chrome/google-chrome
RUN chmod +x /opt/google/chrome/google-chrome

ADD selenium.node.register /var/selenium.node.register
RUN chmod 755 /var/selenium.node.register

USER seluser
# Following line fixes
# https://github.com/SeleniumHQ/docker-selenium/issues/87
ENV DBUS_SESSION_BUS_ADDRESS=/dev/null

CMD ["/bin/bash", "/var/selenium.node.register"]

