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

echo

echo '--------------------------------------------------------'
echo 'Empty url'
echo '--------------------------------------------------------'
curl -i --data '{"url":""}' -H "Content-Type: application/json" -X POST http://localhost:8080/

echo

echo '--------------------------------------------------------'
echo 'Redir from Valid url'
echo '--------------------------------------------------------'
curl -i -H "Content-Type: application/json" -X GET http://localhost:8080/b9a982c

echo

echo '--------------------------------------------------------'
echo 'Redir from invalid url'
echo '--------------------------------------------------------'
curl -i -H "Content-Type: application/json" -X GET http://localhost:8080/xxxxxxx

echo

echo '--------------------------------------------------------'
echo 'Try to shorten a Valid url ALREADY shortened'
echo '--------------------------------------------------------'
curl -i --data '{"url":"http://www.rodrigosouza.net.br"}' -H "Content-Type: application/json" -X POST http://localhost:8080/

echo
