FROM centos:7

RUN yum clean all && \
    yum install -y attr hostname epel-release && \
    yum -y update && \
    yum -y install wget git curl tar maven java-1.8.0-openjdk-devel

RUN git clone https://github.com/enricovianello/storm-rest.git && \
    cd storm-rest

EXPOSE 8080

ENTRYPOINT mvn spring-boot:run