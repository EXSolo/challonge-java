package at.stefangeyer.challonge.model.wrapper;

import at.stefangeyer.challonge.model.Tournament;

/**
 * Wrapper for easy JSON serialisation of a Tournament
 *
 * @author Stefan Geyer
 * @version 2018-07-08
 */
public class TournamentWrapper {
    private Tournament tournament;

    public TournamentWrapper(Tournament tournament) {
        this.tournament = tournament;
    }

    public Tournament getTournament() {
        return this.tournament;
    }
}
