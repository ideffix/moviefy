package com.moviefy.backend.actor;

import com.moviefy.backend.search.Search;

public class ActorService {
    Search search = new Search();

    public void addActor(Actor actor) {
        search.actors.add(actor);
    }

    public void delethaActor(int id) {
        search.actors.removeIf(actor -> actor.getId() == id);
    }
}
