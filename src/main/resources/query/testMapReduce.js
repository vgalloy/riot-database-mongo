use riot;

var mapFunction = function() {
    this.rankedStatsDto.champions.forEach(
	function(champ) {
	    if(champ.id == 7) {
		result = {}
		emit ( champ.stats.totalSessionsPlayed, champ.stats.totalSessionsWon );
	    }
	}
    )
};

var reduceFunction = function(key, values) {
    result = {};
    result.played = key * values.length;
    result.winRate = 0;
    values.forEach(function(value) {
	result.winRate += value;
    });
    return result;
};

var finalizeFunction = function(key, value) {
    result = {};
    result.winRate = value.winRate / key * 100;
    result.played = value.played
    return result;
};

db.rankedStats.mapReduce(
    mapFunction,
    reduceFunction,
    {
	query: {"rankedStatsDto.champions.id": 7},
	out: "result",
	finalize: finalizeFunction,
	verbose: true
    }
);

db.result.find();
