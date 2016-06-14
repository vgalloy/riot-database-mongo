use riot2;
db.rankedStats.aggregate([
    {$unwind: "$item.champions"},
    {$group:
     { _id: {championId: "$item.champions.id", played:"$item.champions.stats.totalSessionsPlayed"},
       played: {$sum: "$item.champions.stats.totalSessionsPlayed"},
       won: {$sum: "$item.champions.stats.totalSessionsWon"},
       total : {$sum: 1}
     }},
    {$project: {result: {$divide: [{$floor: {$multiply: [1000, {$divide: ["$won", "$played"]}]}}, 10]}, total:1}},
    {$sort: {_id:1}},
    {$out: "result"}
])

db.result.find({"_id.championId":7})

