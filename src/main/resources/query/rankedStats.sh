#!/bin/bash

sed -i -e "s/CHAMP_ID = [0-9]*/CHAMP_ID = $1/g" rankedStats.js
mongo < rankedStats.js

