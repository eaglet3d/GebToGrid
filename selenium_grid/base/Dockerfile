FROM ubuntu
ENV SELENIUM_VERSION 2.53.1

RUN apt-get update -qqy \
    && apt-get -qqy --no-install-recommends install \
    software-properties-common \
    && rm -rf /var/lib/apt/lists/*
RUN add-apt-repository -y ppa:webupd8team/java

RUN echo debconf shared/accepted-oracle-license-v1-1 select true | debconf-set-selections
RUN echo debconf shared/accepted-oracle-license-v1-1 seen true | debconf-set-selections

RUN apt-get update -qqy \
    && apt-get -qqy --no-install-recommends install \
    bzip2 \
    ca-certificates \
    oracle-java7-installer \
    sudo \
    unzip \
    vim \
    iproute \
    && rm -rf /var/lib/apt/lists/*

ADD "http://selenium-release.storage.googleapis.com/2.53/selenium-server-standalone-${SELENIUM_VERSION}.jar" /opt/
#RUN cd /opt/ && wget http://selenium-release.storage.googleapis.com/${SELENIUM_VERSION%.*}/selenium-server-standalone-${SELENIUM_VERSION}.jar

#========================================
# Add normal user with passwordless sudo
#========================================
RUN sudo useradd seluser --shell /bin/bash --create-home \
    && sudo usermod -a -G sudo seluser \
    && echo 'ALL ALL = (ALL) NOPASSWD: ALL' >> /etc/sudoers \
    && echo 'seluser:secret' | chpasswd
