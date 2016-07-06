use riot2;

var mapFunction = function() {
    key = this._id;
    result = {};
    result.players = [];
    
    /* Convertion */
    if(this.item.participantIdentities != undefined) {
	this.item.participantIdentities.forEach(function(participantIdentity) {
	    identity = {};
	    identity.summonerId = participantIdentity.player.summonerId;
	    identity.participantId = participantIdentity.participantId;
	    result.players[participantIdentity.participantId] = identity;
	});
	
	if(this.item.participants != undefined) {
	    this.item.participants.forEach(function(participant) {
		result.players[participant.participantId].championId = participant.championId;
	    });

	    result.players.forEach(function(player) {
		player.position = [];
	    });
	    if(this.item.timeline != undefined && this.item.timeline.frames != undefined) {
		this.item.timeline.frames.forEach(function(frame) {
		    result.players.forEach(function(player) {
			position = frame.participantFrames[player.participantId].position;
			if(position != null) {
			    player.position.push(position);
			}
		    });
		});
		emit(key, result);
	    }
	}
    }
};

var reduceFunction = function(key, values) {
    return result;
};

db.matchDetail.mapReduce(
    mapFunction,
    reduceFunction,
    {
	out: "result4",
	verbose: true
    }
);

DBQuery.shellBatchSize = 1;
db.result4.find();
DBQuery.shellBatchSize = 20;
