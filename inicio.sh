#!/bin/bash
java -cp out ServidorRMI &

sleep 3

java -cp out App

tail -f /dev/null
