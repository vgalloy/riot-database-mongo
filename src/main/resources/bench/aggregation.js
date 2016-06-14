use riot;
db.rankedStats.aggregate([
    {$unwind : "$rankedStatsDto.champions"},
    {$group :
     { _id: "$rankedStatsDto.champions.id",
       played : {$sum: "$rankedStatsDto.champions.stats.totalSessionsPlayed"},
       won : {$sum: "$rankedStatsDto.champions.stats.totalSessionsWon"}

     }},
    {$project : {result : {$multiply : [100, {$divide : ["$won", "$played"]}]}}},
    {$sort : {_id:1}}
])
