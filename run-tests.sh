#!/usr/bin/env bash

clear


echo '--------------------------------------------------------'
echo 'Valid url'
echo '--------------------------------------------------------'
curl -i --data '{"url":"http://www.rodrigosouza.net.br"}' -H "Content-Type: application/json" -X POST http://localhost:8080/

echo

echo '--------------------------------------------------------'
echo 'Another Valid url'
echo '--------------------------------------------------------'
curl -i --data '{"url":"http://www.rodrigosouza.net.br/publication/trends-entropy_raa/"}' -H "Content-Type: application/json" -X POST http://localhost:8080/

echo

echo '--------------------------------------------------------'
echo 'Another Valid url'
echo '--------------------------------------------------------'
curl -i --data '{"url":"https://arxiv.org/abs/1609.00716"}' -H "Content-Type: application/json" -X POST http://localhost:8080/

echo

echo '--------------------------------------------------------'
echo 'Another Valid url'
echo '--------------------------------------------------------'
curl -i --data '{"url":"https://arxiv.org"}' -H "Content-Type: application/json" -X POST http://localhost:8080/

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

echo '--------------------------------------------------------'
echo 'Statistics'
echo '--------------------------------------------------------'
curl -i -H "Content-Type: application/json" -X GET http://localhost:8080/statistics

