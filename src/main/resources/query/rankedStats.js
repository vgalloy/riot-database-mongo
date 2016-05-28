use riot;
DBQuery.shellBatchSize = 300;

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
		
		emit ( Math.pow( Math.ceil( Math.sqrt( Math.ceil( champ.stats.totalSessionsPlayed / 3 ) ) ), 2) * 3, result );
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



var mapFunction2 = function() {
    if(this._id != 0 ) {
	result = {};
	result.value = this.value;
	key = Math.ceil( Math.sqrt( Math.ceil( this._id / 3 ) ) )
	
	result.status = 1;
	emit(Math.pow( key, 2 ) * 3, result);

	result.status = -1;
	emit(Math.pow( key + 1, 2 ) * 3, result);
    }
};

var reduceFunction2 = function(key, values) {
    if(values[0].status == 1){
	valuePlus = values[0]
	valueMoins = values[1]
    } else {
	valuePlus = values[1]
	valueMoins = values[0]
    }
    
    result = {}
    keyMoins = Math.pow( (Math.ceil( Math.sqrt( Math.ceil( key / 3 ) ) ) - 1), 2) * 3;
    result.winRate = Math.round((key * valuePlus.value.winRate - keyMoins * valueMoins.value.winRate)/(key - keyMoins));
  
    return result;
    
};


db.result.mapReduce(
    mapFunction2,
    reduceFunction2,
    {
	out: "result2"
    }
);


db.result.find();
db.result2.find();
DBQuery.shellBatchSize = 20
