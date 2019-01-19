#!/usr/bin/env bash

clear


echo '--------------------------------------------------------'
echo 'Valid url'
echo '--------------------------------------------------------'
curl -i --data '{"url":"http://www.rodrigosouza.net.br"}' -H "Content-Type: application/json" -X POST http://localhost:8080/

echo

echo '--------------------------------------------------------'
echo 'Invalid url'
echo '--------------------------------------------------------'
curl -i --data '{"url":"abc"}' -H "Content-Type: application/json" -X POST http://localhost:8080/
