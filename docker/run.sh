#!/bin/bash

set -x

if [ ! -d "/storm-rest/.git" ]; then
  git clone https://github.com/enricovianello/storm-rest.git
fi

cd /storm-rest
mvn spring-boot:run
