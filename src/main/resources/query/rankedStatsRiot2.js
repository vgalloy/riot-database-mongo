use riot2;
db.rankedStats.aggregate([
    {$unwind: "$item.champions"},
    {$group:{
	_id: {championId: "$item.champions.id", played:"$item.champions.stats.totalSessionsPlayed", region:"$region"},
	played: {$sum: "$item.champions.stats.totalSessionsPlayed"},
	won: {$sum: "$item.champions.stats.totalSessionsWon"},
	total : {$sum: 1}
    }},
    {$sort: {_id:1}},
    {$out: "result"}
]);

//db.result.find({"_id.championId":7})
db.result.aggregate([
    {$match: {"_id.championId": 7}},
    {$group:{
	_id : {championId: "$_id.championId", played: {$multiply : [1, {$ceil: {$divide: ["$_id.played", 1]}}]}, region: "$_id.region"},
	played: {$sum: "$played"},
	won: {$sum: "$won"},
	total : {$sum: "$total"}
    }},
    {$project: {result: {$divide: [{$floor: {$multiply: [1000, {$divide: ["$won", "$played"]}]}}, 10]}, total:1, played:1}},
    {$sort: {_id:1}}
])

