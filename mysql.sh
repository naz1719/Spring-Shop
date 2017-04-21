#!/usr/bin/env bash
password=LACOSTA;
mysql -u root -p$password -e "CREATE DATABASE IF NOT EXISTS shop;"
