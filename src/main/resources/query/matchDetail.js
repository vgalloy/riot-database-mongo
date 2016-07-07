use riot;

CHAMP_ID = 7;

var mapFunction = function() {
    this.rankedStatsDto.champions.forEach(
	function(champ) {
	    CHAMP_ID = 7;
	    if(champ.id == CHAMP_ID) {
		result = {};
		result.totalSessionsPlayed = champ.stats.totalSessionsPlayed;
		result.totalSessionsWon = champ.stats.totalSessionsWon;
		result.totalMinionKills = champ.stats.totalMinionKills;
		result.totalChampionKills = champ.stats.totalChampionKills;
		result.totalDeathsPerSession = champ.stats.totalDeathsPerSession;
		result.totalAssists = champ.stats.totalAssists;
		result.totalDamageDealt = champ.stats.totalDamageDealt;
		result.totalGoldEarned = champ.stats.totalGoldEarned;
		result.player = 1;
		
		emit ( champ.stats.totalSessionsPlayed, result );
		emit ( 0, result );
	    }
	}
    )
};

var reduceFunction = function(key, values) {
    result = {};
    result.totalSessionsWon = 0;
    result.totalMinionKills = 0;
    result.totalSessionsPlayed = 0;
    result.totalChampionKills = 0;
    result.totalDeathsPerSession = 0;
    result.totalAssists = 0;
    result.totalDamageDealt = 0;
    result.totalGoldEarned = 0;
    result.player = 0;
    values.forEach(
	function(value) {
	    result.totalSessionsPlayed += value.totalSessionsPlayed;
	    result.totalSessionsWon += value.totalSessionsWon;
	    result.totalMinionKills += value.totalMinionKills;
	    result.totalChampionKills += value.totalChampionKills;
	    result.totalDeathsPerSession += value.totalDeathsPerSession;
	    result.totalAssists += value.totalAssists;
	    result.totalDamageDealt += value.totalDamageDealt;
	    result.totalGoldEarned += value.totalGoldEarned;
	    result.player += value.player;
	}
    )
    
    return result;
};

var finalizeFunction = function(key, value) {
    result = {}
    
    result.winRate = Math.round( value.totalSessionsWon * 100 / value.totalSessionsPlayed );
    result.minion = Math.round( value.totalMinionKills / value.totalSessionsPlayed );
    result.kill = Math.round( value.totalChampionKills / value.totalSessionsPlayed );
    result.death = Math.round( value.totalDeathsPerSession / value.totalSessionsPlayed );
    result.assit = Math.round( value.totalAssists / value.totalSessionsPlayed );
    result.damage = Math.round( value.totalDamageDealt / value.totalSessionsPlayed );
    result.gold = Math.round( value.totalGoldEarned / value.totalSessionsPlayed );
    result.player = value.player;
    return result;
};

db.rankedStats.mapReduce(
    mapFunction,
    reduceFunction,
    {
	query: {"rankedStatsDto.champions.id": CHAMP_ID},
	out: "result",
	finalize: finalizeFunction,
	verbose: true
    }
);

db.result.find();
