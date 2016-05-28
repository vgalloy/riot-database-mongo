use riot
db.rankedStats.aggregate(
    [
	{ $match : {"rankedStatsDto.champions.id": 7} },
	{ $unwind : "$rankedStatsDto.champions" },
	{ $match : {"rankedStatsDto.champions.id": 7} },
	{ $group : {
	    _id: "$rankedStatsDto.champions.stats.totalSessionsPlayed",
	    won: {$sum : "$rankedStatsDto.champions.stats.totalSessionsWon"},
	    played: {$sum : "$rankedStatsDto.champions.stats.totalSessionsPlayed"}}},
	{ $project : { played: 1, winRate : { $divide : ["$won", "$played"] }}},
	{ $project : { played: 1,  winRate : { $multiply : ["$winRate", 100] }}},
	{ $sort : { _id : 1} }
    ]
);
