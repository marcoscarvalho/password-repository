#!/bin/bash

if [ "run" = $1 ]; then
  mvn clean package;
  docker build -t password-validator .;
  docker run --rm -p8080:8080 password-validator
elif [ "--help" = $1 ]; then
  echo "Usage: $ ./exec.sh [OPTION]"
  echo -e ' \t  build \t\t Execute docker command to create password-validator image and run using 8080 port'
else
  echo "Invalid command"
  echo "Try 'exec.sh --help' for more information."
fi