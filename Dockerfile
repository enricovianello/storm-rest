FROM centos:7

COPY docker/run.sh /run.sh

RUN chmod +x /run.sh

RUN yum clean all && \
    yum update -y && \
    yum install -y attr hostname epel-release wget git curl tar maven java-1.8.0-openjdk-devel

EXPOSE 8080

ENTRYPOINT /bin/bash /run.sh