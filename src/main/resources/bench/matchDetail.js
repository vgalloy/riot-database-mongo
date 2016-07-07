use riot2;
db.result4.aggregate([
    {$match: {"value.players.summonerId" : NumberLong("24550736")}},
    {$match: {"value.players.championId" : 7}},
    {$unwind: "$value.players"},
    {$match: {"value.players.summonerId" : NumberLong("24550736")}},
    {$match: {"value.players.championId" : 7}},
    {$out: "result3"}
]);
db.result3.find();
db.result3.find().count();
