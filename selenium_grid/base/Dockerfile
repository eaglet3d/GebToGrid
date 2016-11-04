FROM ubuntu

ENV VERSION 2.53.1
ENV VER_FOLDER 2.53
#ENV VERSION 3.0.0-beta3
#ENV VER_FOLDER 3.0-beta3

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
    oracle-java8-installer \
    sudo \
    unzip \
    vim \
    less \
    iproute \
    net-tools \
    iputils-ping \
    && rm -rf /var/lib/apt/lists/*

RUN cd /var && wget http://selenium-release.storage.googleapis.com/${VER_FOLDER}/selenium-server-standalone-${VERSION}.jar

#========================================
# Add normal user with passwordless sudo
#========================================
RUN sudo useradd seluser --shell /bin/bash --create-home \
    && sudo usermod -a -G sudo seluser \
    && echo 'ALL ALL = (ALL) NOPASSWD: ALL' >> /etc/sudoers \
    && echo 'seluser:secret' | chpasswd
