use riot;

var mapFunction = function() {
    if(this.rankedStatsDto.champions != undefined) {
	this.rankedStatsDto.champions.forEach(
	    function(champ) {
		result = {};
		result.totalSessionsPlayed = champ.stats.totalSessionsPlayed;
		result.totalSessionsWon = champ.stats.totalSessionsWon;
		
		emit (champ.id , result );
	    }
	)
    }
};

var reduceFunction = function(key, values) {
    result = {};
    result.totalSessionsPlayed = 0;
    result.totalSessionsWon = 0;
    result.player = 0;
    values.forEach(
	function(value) {
	    result.totalSessionsPlayed += value.totalSessionsPlayed;
	    result.totalSessionsWon += value.totalSessionsWon;
	}
    )
    
    return result;
};

var finalizeFunction = function(key, value) {
    result = {}
    
    result.winRate = value.totalSessionsWon * 100 / value.totalSessionsPlayed;
    return result;
};

db.rankedStats.mapReduce(
    mapFunction,
    reduceFunction,
    {
	out: "result",
	finalize: finalizeFunction,
	verbose: true
    }
);

db.result.find();
