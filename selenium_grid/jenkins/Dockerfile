FROM jenkins/jenkins:lts

USER root

RUN apt-get update -qqy \
    && apt-get -qqy --no-install-recommends install \
    software-properties-common \
    # && rm -rf /var/lib/apt/lists/*
RUN add-apt-repository -y ppa:webupd8team/java

RUN echo debconf shared/accepted-oracle-license-v1-1 select true | debconf-set-selections
RUN echo debconf shared/accepted-oracle-license-v1-1 seen true | debconf-set-selections

RUN echo "America/New_York" | tee /etc/timezone

RUN apt-get update -qqy \
    && apt-get -qqy --no-install-recommends install \
    bzip2 \
    ca-certificates \
    iproute \
    iputils-ping \
    less \
    net-tools \
    oracle-java8-installer \
    sudo \
    tree \
    unzip \
    vim \
    curl \
    rsync \
    dos2unix
    # && rm -rf /var/lib/apt/lists/*

RUN apt -qqy upgrade

USER jenkins

COPY executors.groovy /usr/share/jenkins/ref/init.groovy.d/executors.groovy

Copy .ssh /var/jenkins_home/

#========================================
# Add normal user with passwordless sudo
#========================================
RUN sudo useradd seluser --shell /bin/bash --create-home \
    && sudo usermod -a -G sudo seluser \
    && echo 'ALL ALL = (ALL) NOPASSWD: ALL' >> /etc/sudoers \
    && echo 'seluser:secret' | chpasswd
